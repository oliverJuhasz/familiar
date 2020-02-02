package familiar.service;


import familiar.domain.Combat;
import familiar.domain.character.RPGCharacter;
import familiar.domain.character.Status;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.Collections;
import java.util.List;

public class CombatHandler implements Fightable {

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
