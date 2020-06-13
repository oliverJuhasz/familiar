package familiar.service.combat.domain;

import familiar.service.character.domain.RpgCharacter;
import familiar.service.note.domain.Note;
import familiar.service.session.domain.Session;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Combat {

    private long id;
    private Session session;
    private String description;
    private List<Note> notes;
    private List<RpgCharacter> characters;

}
