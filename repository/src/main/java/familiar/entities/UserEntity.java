package familiar.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`PlayerID`")
    protected long id;

    @Column(name = "`UserName`")
    protected String name;

    @Column(name = "`Password`")
    protected String password;

    @Column(name = "`Created`")
    protected LocalDateTime created;
}
