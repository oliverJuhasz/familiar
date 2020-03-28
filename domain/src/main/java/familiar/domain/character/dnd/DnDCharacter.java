package familiar.domain.character.dnd;

import familiar.domain.character.RPGCharacter;
import familiar.domain.character.dnd.item.DnDItem;
import lombok.Data;

import java.util.List;


public class DnDCharacter{
    private DnDRace race;
    private DnDSkills skills;
    private DnDAbilities abilities;
    private int initiative;
    private List<DnDItem> inventory;
    private int armorClass;
}
