package familiar.service.user.transformer;

import familiar.entities.PlayerEntity;
import familiar.entities.UserEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.user.domain.Player;
import familiar.service.user.domain.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
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

    public User userEntityToUser(UserEntity userEntity, @Context CycleAvoidingMappingContext context) {
        User target = context.getMappedInstance(userEntity, User.class);
        if (target != null) {
            return target;
        }

        if (userEntity == null) {
            return null;
        }


        User user;
        if (userEntity instanceof PlayerEntity) {
            Player player = new Player();
            player.setUserName(userEntity.getUserName());
            player.setName(((PlayerEntity) userEntity).getName());
            player.setCreated(userEntity.getCreated());
            player.setPassword(userEntity.getPassword());
            user = player;
        } else {
            user = null;
        }
        context.storeMappedInstance(user, User.class);
        return user;
    }

}
