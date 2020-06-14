package familiar.service.user.transformer;

import familiar.entities.PlayerEntity;
import familiar.entities.UserEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.user.domain.Player;
import familiar.service.user.domain.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public UserEntity userToUserEntity(User user, @Context CycleAvoidingMappingContext context) {
        UserEntity target = context.getMappedInstance(user, UserEntity.class);
        if (target != null) {
            return target;
        }

        if (user == null) {
            return null;
        }


        UserEntity userEntity;
        if (user instanceof Player) {
            PlayerEntity playerEntity = new PlayerEntity();
            playerEntity.setUserName(user.getUserName());
            playerEntity.setName(((Player) user).getName());
            playerEntity.setCreated(user.getCreated());
            playerEntity.setPassword(user.getPassword());
            userEntity = playerEntity;
        } else {
            userEntity = null;
        }
        context.storeMappedInstance(userEntity, UserEntity.class);
        return userEntity;
    }

}
