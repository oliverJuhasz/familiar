package familiar.service.session.transformer;

import familiar.entities.CampaignEntity;
import familiar.entities.SessionEntity;
import familiar.entities.character.RpgCharacterEntity;
import familiar.service.campaign.transformer.CampaignTransformer;
import familiar.service.character.domain.witcher.WitcherCharacter;
import familiar.service.character.transformer.WitcherCharacterTransformer;
import familiar.service.combat.transformer.CombatTransformer;
import familiar.service.note.transformer.NoteTransformer;
import familiar.service.session.domain.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionTransformer {

    @Autowired
    CampaignTransformer campaignTransformer;
    @Autowired
    WitcherCharacterTransformer witcherCharacterTransformer;
    @Autowired
    CombatTransformer combatTransformer;
    @Autowired
    NoteTransformer noteTransformer;


    //TODO: Fix casts
    public SessionEntity transformSessionToSessionEntity(Session from) {
        SessionEntity to = SessionEntity.builder()
                .campaign(campaignTransformer.transformCampaignToCampaignEntity(from.getCampaign()))
                .characters((List<RpgCharacterEntity>) witcherCharacterTransformer.transformWitcherCharacterToWitcherCharacterEntity((WitcherCharacter) from.getCharacters()))
                .created(from.getCreated())
                .notes(noteTransformer.transformNoteToNoteEntity(from.getNotes()))
                .id(from.getId())
                .summary(from.getSummary())
                .build();
        to.setCombats(combatTransformer.transformCombatToCombatEntity(from.getCombats(), to));
        return to;
    }

    public SessionEntity transformSessionToSessionEntity(Session from, CampaignEntity campaign) {
        SessionEntity to = SessionEntity.builder()
                .campaign(campaign)
                .characters((List<RpgCharacterEntity>) witcherCharacterTransformer.transformWitcherCharacterToWitcherCharacterEntity((WitcherCharacter) from.getCharacters()))
                .created(from.getCreated())
                .notes(noteTransformer.transformNoteToNoteEntity(from.getNotes()))
                .id(from.getId())
                .summary(from.getSummary())
                .build();
        to.setCombats(combatTransformer.transformCombatToCombatEntity(from.getCombats(), to));
        return to;
    }

    public List<SessionEntity> transformSessionToSessionEntity(List<Session> from) {
        return from.stream().map(this::transformSessionToSessionEntity).collect(Collectors.toList());
    }

    public List<SessionEntity> transformSessionToSessionEntity(List<Session> from, CampaignEntity campaign) {
        return from.stream().map(session -> transformSessionToSessionEntity(session, campaign)).collect(Collectors.toList());
    }

}
