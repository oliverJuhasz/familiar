package familiar.service.campaign.transformer;

import familiar.entities.CampaignEntity;
import familiar.service.campaign.domain.Campaign;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring", uses = RpgCharacterTransformer.class)
public interface CampaignMapper {

    CampaignEntity campaignToCampaignEntity(Campaign campaign, @Context CycleAvoidingMappingContext context);


}
