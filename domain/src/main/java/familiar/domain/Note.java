package familiar.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Note {

    private String title;
    private String text;
    private LocalDateTime created;

}
