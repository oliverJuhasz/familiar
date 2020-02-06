package familiar.domain;

import familiar.domain.character.RPGCharacter;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Campaign {

    private Long id;
    private List<User> players;
    private List<User> masters;
    private List<RPGCharacter> characters;
    private LocalDateTime created;
    private List<Session> sessions;
    private List<Note> notes;

}
