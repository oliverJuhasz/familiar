package familiar.entities;

import familiar.entities.character.RPGCharacterEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "character_id")
    private List<RPGCharacterEntity> characters;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<NoteEntity> notes;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<CombatEntity> combats;

    private LocalDateTime created;

    @ManyToOne
    private CampaignEntity campaign;

    private String summary;
    
}
