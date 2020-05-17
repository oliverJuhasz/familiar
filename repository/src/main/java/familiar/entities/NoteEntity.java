package familiar.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "`Notes`")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`NoteID`")
    private long id;

    @Column(name = "`Title`")
    private String title;

    @Column(name = "`Text`")
    private String text;

    @Column(name = "`Created`")
    private LocalDateTime created;

}
