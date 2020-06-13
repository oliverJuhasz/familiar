package familiar.service.character.transformer;

import familiar.entities.character.NameEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.character.domain.Name;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface NameMapper {

    NameEntity convertNameToNameEntity(Name name, @Context CycleAvoidingMappingContext context);

}
