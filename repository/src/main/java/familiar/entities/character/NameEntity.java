package familiar.entities.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "`Names`")
public class NameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`NameID`")
    private long id;

    @Column(name = "`First`")
    private String firstName;

    @Column(name = "`Last`")
    private String lastName;

    @Column(name = "`Title`")
    private String title;

    @Column(name = "`Nick`")
    private String nickName;
}
