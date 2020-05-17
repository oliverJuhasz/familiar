package familiar.service.campaign.domain;

import familiar.entities.World;
import familiar.service.note.domain.Note;
import familiar.service.session.domain.Session;
import familiar.service.user.domain.Player;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class Campaign {

    private Long id;
    private String name;
    private String description;
    private World world;
    private List<Player> players;
    private LocalDateTime created;
    private List<Session> sessions;
    private List<Note> notes;

}