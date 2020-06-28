package familiar.service.session.domain;

import familiar.service.campaign.domain.Campaign;
import familiar.service.character.domain.RpgCharacter;
import familiar.service.combat.domain.Combat;
import familiar.service.note.domain.Note;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Session {

    private long id;

    @ToString.Exclude
    private List<RpgCharacter> characters;

    @ToString.Exclude
    private List<Note> notes;

    @ToString.Exclude
    private List<Combat> combats;

    private LocalDateTime created;
    private LocalDate held;
    private Campaign campaign;
    private Note summary;

}
