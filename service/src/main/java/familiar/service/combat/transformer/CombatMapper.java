package familiar.service.combat.transformer;

import familiar.entities.CombatEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.character.transformer.RpgCharacterMapper;
import familiar.service.combat.domain.Combat;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RpgCharacterMapper.class)
public interface CombatMapper {

    CombatEntity convertCombatToCombatEntity(Combat combat, @Context CycleAvoidingMappingContext context);

}
