package familiar.service.note.transformer;

import familiar.entities.NoteEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.note.domain.Note;
import org.mapstruct.Builder;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true))
public interface NoteMapper {

    NoteEntity convertNoteToNoteEntity(Note note, @Context CycleAvoidingMappingContext context);

}
