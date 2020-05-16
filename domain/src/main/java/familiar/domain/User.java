package familiar.domain;

import familiar.domain.character.RPGCharacter;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class User {

    private long id;
    private String name;
    private String password;
    private LocalDateTime created;
}
