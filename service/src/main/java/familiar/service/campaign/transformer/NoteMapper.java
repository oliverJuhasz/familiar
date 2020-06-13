package familiar.service.campaign.transformer;

import familiar.entities.NoteEntity;
import familiar.service.note.domain.Note;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteEntity convertNoteToNoteEntity(Note note, @Context CycleAvoidingMappingContext context);

}
