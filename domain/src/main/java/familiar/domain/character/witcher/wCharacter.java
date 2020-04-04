package familiar.domain.character.witcher;

import familiar.domain.character.Gender;
import familiar.domain.character.Name;
import familiar.domain.character.RPGCharacter;
import familiar.domain.character.witcher.assist.HandToHandTable;
import familiar.domain.character.witcher.assist.PhysicalTable;
import familiar.domain.character.witcher.profession.wProfession;
import familiar.domain.character.witcher.profession.wProfessionSkills;
import lombok.Builder;
import lombok.ToString;

import java.util.Map;

@ToString
public class wCharacter extends RPGCharacter {
    private Map<wStats, Integer> coreAbilities;
    private Map<wSkills, Integer> coreSkills;
    private Map<wProfessionSkills, Integer> professionSkills;
    private wRace race;
    private wProfession profession;
    private PhysicalTable physicalTable = new PhysicalTable();
    private HandToHandTable handToHandTable = new HandToHandTable();

    @Builder
    public wCharacter(Name name, Gender gender, int age, Map<wStats, Integer> coreAbilities, Map<wSkills, Integer> coreSkills,
                      wRace race, wProfession profession) {
        super(name, gender, age);
        this.coreAbilities = coreAbilities;
        this.coreSkills = coreSkills;
        this.race = race;
        this.profession = profession;
    }

    public int getDerivedSkill(wSkills skill) {
        return coreAbilities.get(skill.baseAbility) + coreSkills.get(skill);
    }

    public int getDerivedProfessionalSkill(wProfessionSkills professionSkill) {
        return coreAbilities.get(professionSkill.baseAbility) + professionSkills.get(professionSkill);
    }
}
