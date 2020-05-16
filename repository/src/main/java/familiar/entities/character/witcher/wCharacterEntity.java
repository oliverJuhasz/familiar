package familiar.entities.character.witcher;

import familiar.entities.character.Gender;
import familiar.entities.character.NameEntity;
import familiar.entities.character.RPGCharacterEntity;
import familiar.entities.character.witcher.profession.wProfession;
import familiar.entities.character.witcher.profession.wProfessionSkills;
import lombok.*;

import javax.persistence.Entity;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class wCharacterEntity extends RPGCharacterEntity {
//    private Map<wStats, Integer> coreAbilities;
//    private Map<wSkills, Integer> coreSkills;
//    private Map<wProfessionSkills, Integer> professionSkills;
//    private wRace race;
//    private wProfession profession;

}
