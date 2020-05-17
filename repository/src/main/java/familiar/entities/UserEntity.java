package familiar.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "`Users`")
public abstract class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`UserID`")
    protected long id;

    @Column(name = "`UserName`")
    protected String userName;

    @Column(name = "`Password`")
    protected String password;

    @Column(name = "`Created`")
    protected LocalDateTime created;
}
