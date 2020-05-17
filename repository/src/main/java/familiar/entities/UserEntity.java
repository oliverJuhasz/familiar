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
    private long id;

    @Column(name = "`UserName`")
    private String name;

    @Column(name = "`Password`")
    private String password;

    @Column(name = "`Created`")
    private LocalDateTime created;
}
