package familiar.domain.character.witcher.profession;

import familiar.domain.character.witcher.wSkills;

import java.util.List;

public abstract class wProfession {
    private wProfessionSkills definingSkill;
    private int vigor;
    private List<wSkills> skillSet;
    private int magicalPerksTEMP;
    private int startingGearTEMP;
}
