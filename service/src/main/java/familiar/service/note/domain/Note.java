package familiar.service.note.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Note {

    private long id;
    private String title;
    private String text;
    private LocalDateTime created;

}
