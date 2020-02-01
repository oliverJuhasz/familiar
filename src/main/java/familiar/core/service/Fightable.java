package familiar.core.service;


import familiar.core.domain.character.RPGCharacter;

import java.util.List;

public interface Fightable {

    void nextTurn();
    void addCharacters(RPGCharacter character);
    List<RPGCharacter> getCharacters();
    void disableCharacter(int rank);
    void activateCharacter(int rank);

}
