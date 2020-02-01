package familiar.core.domain;

import familiar.core.domain.character.RPGCharacter;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Combat {

    private Session session;
    private List<Note> notes;
    private List<RPGCharacter> characters = new LinkedList<>();

    public void addCharacter(RPGCharacter character) {
        characters.add(character);
    }



}
