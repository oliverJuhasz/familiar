package familiar.service.session.domain;

import familiar.service.campaign.domain.Campaign;
import familiar.service.character.domain.RpgCharacter;
import familiar.service.combat.domain.Combat;
import familiar.service.note.domain.Note;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Session {

    private long id;
    private List<RpgCharacter> characters;
    private List<Note> notes;
    private List<Combat> combats;
    private LocalDateTime created;
    private Campaign campaign;
    private String summary;

}
