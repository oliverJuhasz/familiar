package familiar.entities;

import familiar.entities.character.RPGCharacterEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "`Combats`")
public class CombatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`CombatID`")
    private long id;

    @ManyToOne
    private SessionEntity session;

    @OneToMany
    private List<NoteEntity> notes;

    @OneToMany
    private List<RPGCharacterEntity> characters;


}
