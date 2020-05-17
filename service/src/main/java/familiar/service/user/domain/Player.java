package familiar.service.user.domain;

import familiar.entities.UserEntity;
import familiar.service.campaign.domain.Campaign;
import familiar.service.character.domain.RpgCharacter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Player extends UserEntity {

    private String name;
    private List<Campaign> campaign;
    private List<RpgCharacter> characters;

}
