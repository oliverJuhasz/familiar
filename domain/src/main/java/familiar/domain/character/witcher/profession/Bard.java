package familiar.domain.character.witcher.profession;

import familiar.domain.character.witcher.wSkills;

import java.util.List;

public class Bard extends wProfession {
    public Bard() {
        super.definingSkill = wProfessionSkills.BUSKING;
        super.vigor = 0;
        super.magicalPerksTEMP = 0;
        super.skillSet = List.of(wSkills.CHARISMA, wSkills.DECEIT,
                wSkills.PERFORMANCE, wSkills.LANGUAGE,
                wSkills.HUMANPERCEPTION, wSkills.PERSUASION,
                wSkills.STREETWISE, wSkills.FINEARTS, wSkills.SEDUCTION,
                wSkills.SOCIALETIQUETTE);
    }
}
