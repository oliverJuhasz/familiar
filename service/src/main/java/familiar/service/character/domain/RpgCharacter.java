package familiar.service.character.domain;


import familiar.service.note.domain.Note;
import familiar.service.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class RpgCharacter {

    protected long id;
    protected User owner;
    protected LocalDateTime created;
    protected Name name;
    protected Gender gender;
    protected int age;
    protected List<Note> storyTellerNotes;
    protected Status status;

}
