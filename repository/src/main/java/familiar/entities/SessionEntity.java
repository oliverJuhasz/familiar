package familiar.entities;

import familiar.entities.character.RpgCharacterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "`Sessions`")
@AllArgsConstructor
@NoArgsConstructor
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`SessionID`")
    private long id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "`Sessions_Characters`",
            joinColumns = @JoinColumn(name = "`SessionID`"),
            inverseJoinColumns = @JoinColumn(name = "`CharacterID`"))
    @ToString.Exclude
    private List<RpgCharacterEntity> characters;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "`Sessions_Notes`",
            joinColumns = @JoinColumn(name = "`SessionID`"),
            inverseJoinColumns = @JoinColumn(name = "`NoteID`"))
    @ToString.Exclude
    private List<NoteEntity> notes;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "`Sessions_Combats`",
            joinColumns = @JoinColumn(name = "SessionID"),
            inverseJoinColumns = @JoinColumn(name = "CombatID"))
    @ToString.Exclude
    private List<CombatEntity> combats;

    @Column(name = "`Created`", nullable = false)
    private LocalDateTime created;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`FK_CampaignID`")
    private CampaignEntity campaign;

    @Column(name = "`Summary`", columnDefinition = "TEXT")
    private String summary;
    
}
