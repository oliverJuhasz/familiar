package familiar.service.campaign.transformer;

import familiar.entities.CampaignEntity;
import familiar.service.campaign.domain.Campaign;
import familiar.service.character.transformer.RpgCharacterMapper;
import org.mapstruct.Builder;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = RpgCharacterMapper.class,
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CampaignMapper {

    CampaignEntity campaignToCampaignEntity(Campaign campaign, @Context CycleAvoidingMappingContext context);

    Campaign campaignEntityToCampaign(CampaignEntity campaignEntity, @Context CycleAvoidingMappingContext context);

}
