package familiar.entities.character;


import familiar.entities.NoteEntity;
import familiar.entities.PlayerEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "`RpgCharacters`")
public abstract class RPGCharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`RpgCharacterID`")
    protected long id;

    @ManyToOne
    protected PlayerEntity owner;

    @Column(name = "`Created`")
    protected LocalDateTime created;

    @OneToOne
    protected NameEntity nameEntity;

    @Column(name = "`Gender`")
    protected Gender gender;

    @Column(name = "`Age`")
    protected int age;

    @OneToMany
    protected List<NoteEntity> storyTellerNotes;

    @Column(name = "`Status`")
    protected Status status;

}
