package familiar.service.character.transformer;

import familiar.entities.character.witcher.WitcherCharacterEntity;
import familiar.service.character.domain.witcher.WitcherCharacter;
import familiar.service.note.transformer.NoteTransformer;
import familiar.service.user.transformer.PlayerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WitcherCharacterTransformer {

    @Autowired
    PlayerTransformer playerTransformer;
    @Autowired
    NameTransformer nameTransformer;
    @Autowired
    NoteTransformer noteTransformer;

    public WitcherCharacterEntity transformWitcherCharacterToWitcherCharacterEntity(WitcherCharacter from) {
        WitcherCharacterEntity to = WitcherCharacterEntity.builder()
                .age(from.getAge())
                .coreAbilities(from.getCoreAbilities())
                .coreSkills(from.getCoreSkills())
                .created(from.getCreated())
                .gender(from.getGender())
                .id(from.getId())
                .nameEntity(nameTransformer.transformNameToNameEntity(from.getName()))
                .owner(playerTransformer.transformPlayerToPlayerEntity(from.getOwner()))
                .profession(from.getProfession())
                .professionSkills(from.getProfessionSkills())
                .race(from.getRace())
                .status(from.getStatus())
                .storyTellerNotes(noteTransformer.transformNoteToNoteEntity(from.getStoryTellerNotes()))
                .build();
        return to;
    }

    public List<WitcherCharacterEntity> transformWitcherCharacterToWitcherCharacterEntity(List<WitcherCharacter> from) {
        return from.stream().map(this::transformWitcherCharacterToWitcherCharacterEntity).collect(Collectors.toList());
    }

}
