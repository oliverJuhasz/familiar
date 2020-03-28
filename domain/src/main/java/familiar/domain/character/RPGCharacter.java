package familiar.domain.character;

import familiar.domain.Note;
import familiar.domain.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

public abstract class RPGCharacter {
    protected long id;
    protected User owner;
    protected LocalDateTime created;
    protected Name name;
    protected Gender gender;
    protected int age;
    protected List<Note> storyTellerNotes;
    protected Status status;

    public RPGCharacter(Name name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
