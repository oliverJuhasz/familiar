package familiar.service.combat.transformer;

import familiar.entities.CombatEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.combat.domain.Combat;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CombatMapper {

    CombatEntity convertCombatToCombatEntity(Combat combat, @Context CycleAvoidingMappingContext context);

}
