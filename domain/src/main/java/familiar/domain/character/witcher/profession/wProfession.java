package familiar.domain.character.witcher.profession;

import familiar.domain.character.witcher.wSkills;

import java.util.List;

public abstract class wProfession {
    protected wProfessionSkills definingSkill;
    protected int vigor;
    protected List<wSkills> skillSet;
    protected int magicalPerksTEMP;
    protected int startingGearTEMP;
}
