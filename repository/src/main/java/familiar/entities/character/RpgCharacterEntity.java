package familiar.entities.character;


import familiar.entities.NoteEntity;
import familiar.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`RpgCharacters`")
public abstract class RpgCharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`RpgCharacterID`")
    protected long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    protected UserEntity owner;

    @Column(name = "`Created`")
    protected LocalDateTime created;

    @OneToOne(cascade = CascadeType.PERSIST)
    protected NameEntity nameEntity;

    @Column(name = "`Gender`")
    protected String gender;

    @Column(name = "`Age`")
    protected int age;

    @OneToMany(cascade = CascadeType.PERSIST)
    protected List<NoteEntity> storyTellerNotes;

    @Column(name = "`Status`")
    protected String status;

}
