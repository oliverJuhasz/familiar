package familiar.entities;

import familiar.entities.character.RPGCharacterEntity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
public class PlayerEntity extends UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy="players")
    private List<CampaignEntity> campaign;

    @OneToMany
    private List<RPGCharacterEntity> characters;
}
