package familiar.service.session.transformer;

import familiar.entities.SessionEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.character.transformer.RpgCharacterMapper;
import familiar.service.session.domain.Session;
import org.mapstruct.Builder;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = RpgCharacterMapper.class,
        builder = @Builder(disableBuilder = true))
public interface SessionMapper {

    SessionEntity sessionToSessionEntity(Session session, @Context CycleAvoidingMappingContext context);

    Session sessionEntityToSession(SessionEntity sessionEntity, @Context CycleAvoidingMappingContext context);

}
