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
    private List<NoteEntity> notes;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<CombatEntity> combats;

    @Column(name = "`Created`")
    private LocalDateTime created;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`FK_CampaignID`")
    private CampaignEntity campaign;

    @Column(name = "`Summary`")
    private String summary;
    
}
