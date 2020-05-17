package familiar.entities;

import familiar.entities.character.RPGCharacterEntity;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
public class PlayerEntity extends UserEntity {

    @Column(name = "`Name`")
    private String name;

    @ManyToMany(mappedBy="players")
    private List<CampaignEntity> campaign;

    @OneToMany
    private List<RPGCharacterEntity> characters;
}
