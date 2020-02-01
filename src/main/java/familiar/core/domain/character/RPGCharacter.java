package familiar.core.domain.character;

import familiar.core.domain.Note;
import familiar.core.domain.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public abstract class RPGCharacter {
    private long id;
    private User owner;
    private LocalDateTime created;
    private Name name;
    private long money;
    private int hitPoints;
    private List<Note> storyTellerNotes;
    private Status status;
}
