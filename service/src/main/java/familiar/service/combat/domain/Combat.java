package familiar.service.combat.domain;

import familiar.service.character.domain.RpgCharacter;
import familiar.service.note.domain.Note;
import familiar.service.session.domain.Session;
import lombok.Data;

import java.util.List;

@Data
public class Combat {

    private long id;
    private Session session;
    private String description;
    private List<Note> notes;
    private List<RpgCharacter> characters;

}
