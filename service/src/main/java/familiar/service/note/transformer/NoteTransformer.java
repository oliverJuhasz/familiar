package familiar.service.note.transformer;

import familiar.entities.NoteEntity;
import familiar.service.note.domain.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteTransformer {

    public NoteEntity transformNoteToNoteEntity(Note from) {
        NoteEntity to = NoteEntity.builder()
                .created(from.getCreated())
                .title(from.getTitle())
                .id(from.getId())
                .text(from.getText())
                .build();
        return to;
    }

    public Note transformNoteEntityToNote(NoteEntity from) {
        Note to = Note.builder()
                .created(from.getCreated())
                .title(from.getTitle())
                .id(from.getId())
                .text(from.getText())
                .build();
        return to;
    }

    public List<NoteEntity> transformNoteToNoteEntity(List<Note> from) {
        List<NoteEntity> to = new ArrayList<>();
        for (Note note : from) {
            to.add(transformNoteToNoteEntity(note));
        }
        return to;
    }

    public List<Note> transformNoteEntityToNote(List<NoteEntity> from) {
        List<Note> to = new ArrayList<>();
        for (NoteEntity noteEntity : from) {
            to.add(transformNoteEntityToNote(noteEntity));
        }
        return to;
    }
}
