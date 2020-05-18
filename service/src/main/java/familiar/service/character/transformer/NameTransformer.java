package familiar.service.character.transformer;

import familiar.entities.character.NameEntity;
import familiar.service.character.domain.Name;
import org.springframework.stereotype.Service;

@Service
public class NameTransformer {

    public NameEntity transformNameToNameEntity(Name from) {
        NameEntity to = NameEntity.builder()
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .id(from.getId())
                .nickName(from.getNickName())
                .title(from.getTitle())
                .build();
        return to;

    }
}
