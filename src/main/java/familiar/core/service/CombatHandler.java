package familiar.core.service;

import familiar.core.domain.Combat;
import familiar.core.domain.character.RPGCharacter;
import familiar.core.domain.character.Status;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

public class CombatHandler implements Fightable {

    @Setter
    private Combat combat;

    @Override
    public void nextTurn() {
        Collections.rotate(combat.getCharacters(), 1);
    }

    @Override
    public void addCharacters(RPGCharacter character) {
        combat.addCharacter(character);
    }

    @Override
    public List<RPGCharacter> getCharacters() {
        return combat.getCharacters();
    }

    @Override
    public void disableCharacter(int rank) {
        combat.getCharacters().get(rank).setStatus(Status.DEAD);
    }

    @Override
    public void activateCharacter(int rank) {
        combat.getCharacters().get(rank).setStatus(Status.ALIVE);
    }


}
