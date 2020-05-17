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

    @Column(name = "`Title`", length = 100, nullable = false)
    private String title;

    @Column(name = "`Text`", columnDefinition = "TEXT")
    private String text;

    @Column(name = "`Created`", nullable = false)
    private LocalDateTime created;

}
