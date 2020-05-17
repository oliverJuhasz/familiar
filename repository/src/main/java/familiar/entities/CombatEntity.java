package familiar.entities;

import familiar.entities.character.RPGCharacterEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "`Combats`")
public class CombatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`CombatID`")
    private long id;

    @ManyToOne
    @JoinColumn(name = "`FK_SessionID`")
    private SessionEntity session;

    @Column(name = "`Description`", columnDefinition = "TEXT")
    private String description;

    @OneToMany
    @JoinTable(name = "`Combats_Notes`",
            joinColumns = @JoinColumn(name = "`CombatID`"),
            inverseJoinColumns = @JoinColumn(name = "`NoteID`"))
    private List<NoteEntity> notes;

    @OneToMany
    @JoinTable(name = "`Combats_Characters`",
            joinColumns = @JoinColumn(name = "`CombatID`"),
            inverseJoinColumns = @JoinColumn(name = "`CharacterID`"))
    private List<RPGCharacterEntity> characters;


}
