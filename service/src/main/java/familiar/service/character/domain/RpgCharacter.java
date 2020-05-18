package familiar.service.character.domain;


import familiar.service.note.domain.Note;
import familiar.service.user.domain.Player;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public abstract class RpgCharacter {

    protected long id;
    protected Player owner;
    protected LocalDateTime created;
    protected Name name;
    protected Gender gender;
    protected int age;
    protected List<Note> storyTellerNotes;
    protected Status status;

}
