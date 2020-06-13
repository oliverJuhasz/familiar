package familiar.service.session.transformer;

import familiar.entities.SessionEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.session.domain.Session;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    SessionEntity sessionToSessionEntity(Session session, @Context CycleAvoidingMappingContext context);

}
