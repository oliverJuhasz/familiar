package familiar.service.user.domain;

import familiar.entities.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Player extends UserEntity {

    private String name;

}
