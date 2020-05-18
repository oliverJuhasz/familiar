package familiar.entities;

import familiar.entities.character.RPGCharacterEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "`FK_UserID`")
@Table(name = "`Players`")
public class PlayerEntity extends UserEntity {

    @Builder
    public PlayerEntity(long id, String userName, String password, LocalDateTime created, String name,
                        List<CampaignEntity> campaigns, List<RPGCharacterEntity> characters) {
        super(id, userName, password, created);
        this.name = name;
        this.campaign = campaigns;
        this.characters = characters;
    }

    @Column(name = "`Name`")
    private String name;
}
