package familiar.service.user.transformer;

import familiar.entities.PlayerEntity;
import familiar.service.user.domain.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerTransformer {

    public List<PlayerEntity> transformPlayerToPlayerEntity(List<Player> from) {
        return from
                .stream()
                .map(this::transformPlayerToPlayerEntity)
                .collect(Collectors.toList());

    }

    public PlayerEntity transformPlayerToPlayerEntity(Player from) {
        PlayerEntity to = PlayerEntity.builder()
                .id(from.getId())
                .created(from.getCreated())
                .userName(from.getUserName())
                .password(from.getPassword())
                .name(from.getName())
                .build();
        return to;

    }

}
