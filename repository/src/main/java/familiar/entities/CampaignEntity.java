package familiar.entities;

import familiar.entities.character.RPGCharacterEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
public class CampaignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private World world;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "player_campaign",
                joinColumns = @JoinColumn(name = "campaign_id"),
                inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<PlayerEntity> players;

    private LocalDateTime created;

    @JoinColumn(name = "session_id")
    @OneToMany(mappedBy="campaign", cascade = CascadeType.PERSIST)
    private List<SessionEntity> sessions;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "note_id")
    private List<NoteEntity> notes;
}