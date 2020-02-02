package familiar.domain;

import familiar.domain.character.RPGCharacter;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Session {

    private long id;
    private List<RPGCharacter> players;
    private List<Note> notes;
    private LocalDateTime created;
    private Campaign campaign;
    private String summary;
    
}
