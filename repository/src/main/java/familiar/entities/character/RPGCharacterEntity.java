package familiar.entities.character;


import familiar.entities.CampaignEntity;
import familiar.entities.NoteEntity;
import familiar.entities.PlayerEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public abstract class RPGCharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @ManyToOne
    protected PlayerEntity owner;

    protected LocalDateTime created;

    @OneToOne
    protected NameEntity nameEntity;

    protected Gender gender;
    protected int age;

    @OneToMany
    protected List<NoteEntity> storyTellerNotes;
    protected Status status;

    @OneToMany
    protected List<CampaignEntity> campaigns;

}
