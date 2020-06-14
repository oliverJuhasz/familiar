package familiar.entities;

import familiar.entities.character.RpgCharacterEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "`Combats_Notes`",
            joinColumns = @JoinColumn(name = "`CombatID`"),
            inverseJoinColumns = @JoinColumn(name = "`NoteID`"))
    @ToString.Exclude
    private List<NoteEntity> notes;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "`Combats_Characters`",
            joinColumns = @JoinColumn(name = "`CombatID`"),
            inverseJoinColumns = @JoinColumn(name = "`CharacterID`"))
    @ToString.Exclude
    private List<RpgCharacterEntity> characters;

}
