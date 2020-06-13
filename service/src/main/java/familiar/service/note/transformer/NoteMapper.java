package familiar.service.note.transformer;

import familiar.entities.NoteEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.note.domain.Note;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteEntity convertNoteToNoteEntity(Note note, @Context CycleAvoidingMappingContext context);

}
