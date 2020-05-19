package familiar.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`Campaigns`")
public class CampaignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`CampaignID`")
    private Long id;

    @Column(name = "`Name`", length = 100, nullable = false)
    private String name;

    @Column(name = "`Description`", columnDefinition = "TEXT")
    private String description;

    @Column(name = "`World`", nullable = false)
    private String world;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "`Campaigns_Players`",
            joinColumns = @JoinColumn(name = "`CampaignID`"),
            inverseJoinColumns = @JoinColumn(name = "`PlayerID`"))
    private List<PlayerEntity> players;

    @Column(name = "`Created`", nullable = false)
    private LocalDateTime created;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.PERSIST)
    private List<SessionEntity> sessions;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "`Campaigns_Notes`",
            joinColumns = @JoinColumn(name = "CampaignID"),
            inverseJoinColumns = @JoinColumn(name = "NoteId"))
    private List<NoteEntity> notes;

    @Override
    public String toString() {
        return "CampaignEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", world='" + world + '\'' +
                '}';
    }
}
