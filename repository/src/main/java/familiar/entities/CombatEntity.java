package familiar.entities;

import familiar.entities.character.RpgCharacterEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private List<RpgCharacterEntity> characters;

}
