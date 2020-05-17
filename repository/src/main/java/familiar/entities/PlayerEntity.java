package familiar.entities;

import familiar.entities.character.RPGCharacterEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "`FK_UserID`")
@Table(name = "`Players`")
public class PlayerEntity extends UserEntity {

    @Column(name = "`Name`")
    private String name;

    @ManyToMany(mappedBy="players")
    private List<CampaignEntity> campaign;

    @OneToMany(mappedBy="owner")
    private List<RPGCharacterEntity> characters;
}
