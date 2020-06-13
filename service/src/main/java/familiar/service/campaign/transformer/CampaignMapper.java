package familiar.service.campaign.transformer;

import familiar.entities.CampaignEntity;
import familiar.service.campaign.domain.Campaign;
import familiar.service.character.transformer.RpgCharacterMapper;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RpgCharacterMapper.class)
public interface CampaignMapper {

    CampaignEntity campaignToCampaignEntity(Campaign campaign, @Context CycleAvoidingMappingContext context);


}
