package familiar.service.combat.transformer;

import familiar.entities.CombatEntity;
import familiar.entities.SessionEntity;
import familiar.entities.character.RpgCharacterEntity;
import familiar.service.character.domain.witcher.WitcherCharacter;
import familiar.service.character.transformer.RpgCharacterTransformer;
import familiar.service.combat.domain.Combat;
import familiar.service.note.transformer.NoteTransformer;
import familiar.service.session.transformer.SessionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CombatTransformer {

    @Autowired
    RpgCharacterTransformer witcherCharacterTransformer;
    @Autowired
    NoteTransformer noteTransformer;
    @Autowired
    SessionTransformer sessionTransformer;

    //TODO: Fix charactertransformer

    public CombatEntity transformCombatToCombatEntity(Combat from) {
        CombatEntity to = CombatEntity
                .builder()
                .characters((List<RpgCharacterEntity>) witcherCharacterTransformer.transformRpgCharacterToRpgCharacterEntity((WitcherCharacter) from.getCharacters()))
                .description(from.getDescription())
                .id(from.getId())
                .notes(noteTransformer.transformNoteToNoteEntity(from.getNotes()))
                .session(sessionTransformer.transformSessionToSessionEntity(from.getSession()))
                .build();
        return to;
    }

    public CombatEntity transformCombatToCombatEntity(Combat from, SessionEntity session) {
        CombatEntity to = CombatEntity
                .builder()
                .characters((List<RpgCharacterEntity>) witcherCharacterTransformer.transformRpgCharacterToRpgCharacterEntity((WitcherCharacter) from.getCharacters()))
                .description(from.getDescription())
                .id(from.getId())
                .notes(noteTransformer.transformNoteToNoteEntity(from.getNotes()))
                .session(session)
                .build();
        return to;
    }

    public List<CombatEntity> transformCombatToCombatEntity(List<Combat> from) {
        return from.stream().map(this::transformCombatToCombatEntity).collect(Collectors.toList());
    }

    public List<CombatEntity> transformCombatToCombatEntity(List<Combat> from, SessionEntity session) {
        return from.stream().map(combat -> transformCombatToCombatEntity(combat, session)).collect(Collectors.toList());
    }

}
