package familiar.service.campaign.transformer;

import familiar.entities.CampaignEntity;
import familiar.entities.SessionEntity;
import familiar.service.campaign.domain.Campaign;
import familiar.service.note.transformer.NoteTransformer;
import familiar.service.session.transformer.SessionTransformer;
import familiar.service.user.transformer.PlayerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignTransformer {

    @Autowired
    NoteTransformer noteTransformer;
    @Autowired
    PlayerTransformer playerTransformer;
    @Autowired
    SessionTransformer sessionTransformer;


    public CampaignEntity transformCampaignToCampaignEntity(Campaign from) {
        CampaignEntity to = CampaignEntity.builder()
                .created(from.getCreated())
                .description(from.getDescription())
                .id(from.getId())
                .name(from.getName())
                .notes(noteTransformer.transformNoteToNoteEntity(from.getNotes()))
                .players(playerTransformer.transformPlayerToPlayerEntity(from.getPlayers()))
                .world(from.getWorld())
                .build();
        to.setSessions(sessionTransformer.transformSessionToSessionEntity(from.getSessions(), to));
        return to;
    }

    public CampaignEntity transformCampaignToCampaignEntity(Campaign from, SessionEntity session) {
        CampaignEntity to = new CampaignEntity();
        to.builder()
                .created(from.getCreated())
                .description(from.getDescription())
                .id(from.getId())
                .name(from.getName())
                .notes(noteTransformer.transformNoteToNoteEntity(from.getNotes()))
                .players(playerTransformer.transformPlayerToPlayerEntity(from.getPlayers()))
                .sessions(sessionTransformer.transformSessionToSessionEntity(from.getSessions()))
                .world(from.getWorld())
                .build();
        return to;
    }

    public List<CampaignEntity> transformCampaignToCampaignEntity(List<Campaign> from) {
        return from.stream().map(this::transformCampaignToCampaignEntity).collect(Collectors.toList());
    }

    public List<CampaignEntity> transformCampaignToCampaignEntity(List<Campaign> from, SessionEntity session) {
        return from.stream().map(campaign -> transformCampaignToCampaignEntity(campaign, session)).collect(Collectors.toList());
    }

}
