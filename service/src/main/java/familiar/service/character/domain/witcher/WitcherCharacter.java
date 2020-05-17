package familiar.service.character.domain.witcher;

import familiar.entities.character.RPGCharacterEntity;
import familiar.service.character.domain.witcher.profession.WitcherProfession;
import familiar.service.character.domain.witcher.profession.WitcherProfessionSkills;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class WitcherCharacter extends RPGCharacterEntity {

    private Map<WitcherStats, Integer> coreAbilities;
    private Map<WitcherSkills, Integer> coreSkills;
    private Map<WitcherProfessionSkills, Integer> professionSkills;
    private WitcherRace race;
    private WitcherProfession profession;

}
