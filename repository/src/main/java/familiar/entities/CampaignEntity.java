package familiar.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "`Campaigns`")
public class CampaignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`CampaignID`")
    private Long id;

    @Column(name = "`Name`")
    private String name;

    @Column(name = "`World`")
    private World world;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "`player_campaign`",
                joinColumns = @JoinColumn(name = "campaign_id"),
                inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<PlayerEntity> players;

    @Column(name = "`Created`")
    private LocalDateTime created;

    @OneToMany(mappedBy="campaign", cascade = CascadeType.PERSIST)
    private List<SessionEntity> sessions;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "`CampaignNote`",
                joinColumns = @JoinColumn(name = "CampaignID"),
                inverseJoinColumns = @JoinColumn(name = "NoteId"))
    private List<NoteEntity> notes;
}
