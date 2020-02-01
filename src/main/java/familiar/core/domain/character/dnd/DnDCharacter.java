package familiar.core.domain.character.dnd;

import familiar.core.domain.character.RPGCharacter;
import familiar.core.domain.character.dnd.item.DnDItem;
import lombok.Data;

import java.util.List;

@Data
public class DnDCharacter extends RPGCharacter {
    private DnDRace race;
    private DnDSkills skills;
    private DnDAbilities abilities;
    private int initiative;
    private List<DnDItem> inventory;
    private int armorClass;
}
