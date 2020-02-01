package familiar.core.domain;

import familiar.core.domain.character.RPGCharacter;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class User {

    private long id;
    private String name;
    private String password;
    private LocalDateTime created;
    private List<Campaign> campaigns;
    private List<RPGCharacter> characters;
}
