package familiar.service.character.transformer;

import familiar.entities.character.NameEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.character.domain.Name;
import org.mapstruct.Builder;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface NameMapper {

    NameEntity convertNameToNameEntity(Name name, @Context CycleAvoidingMappingContext context);

    Name convertNameEntityToName(NameEntity nameEntity, @Context CycleAvoidingMappingContext context);

}
