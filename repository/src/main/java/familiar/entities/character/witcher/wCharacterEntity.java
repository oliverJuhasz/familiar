package familiar.entities.character.witcher;

import familiar.entities.character.RPGCharacterEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "WitcherCharacters")
public class wCharacterEntity extends RPGCharacterEntity {
//    private Map<wStats, Integer> coreAbilities;
//    private Map<wSkills, Integer> coreSkills;
//    private Map<wProfessionSkills, Integer> professionSkills;
//    private wRace race;
//    private wProfession profession;

}
