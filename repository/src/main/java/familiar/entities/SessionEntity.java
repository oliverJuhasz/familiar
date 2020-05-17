package familiar.entities;

import familiar.entities.character.RPGCharacterEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "`Sessions`")
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`SessionID`")
    private long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`FK_CharacterID`")
    private List<RPGCharacterEntity> characters;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "`Sessions_Notes`",
            joinColumns = @JoinColumn(name = "`SessionID`"),
            inverseJoinColumns = @JoinColumn(name = "`NoteID`"))
    private List<NoteEntity> notes;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "`Sessions_Combats`",
            joinColumns = @JoinColumn(name = "SessionID"),
            inverseJoinColumns = @JoinColumn(name = "CombatID"))
    private List<CombatEntity> combats;

    @Column(name = "`Created`", nullable = false)
    private LocalDateTime created;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`FK_CampaignID`")
    private CampaignEntity campaign;

    @Column(name = "`Summary`", columnDefinition = "TEXT")
    private String summary;
    
}
