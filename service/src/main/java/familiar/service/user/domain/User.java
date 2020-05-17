package familiar.service.user.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class User {

    protected long id;
    protected String userName;
    protected String password;
    protected LocalDateTime created;

}