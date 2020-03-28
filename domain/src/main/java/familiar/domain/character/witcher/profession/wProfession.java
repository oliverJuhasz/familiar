package familiar.domain.character.witcher.profession;

import familiar.domain.character.witcher.wSkills;

import java.util.List;

public enum wProfession {
    BARD(0, wProfessionSkills.BUSKING,
            List.of(wSkills.CHARISMA, wSkills.DECEIT, wSkills.PERFORMANCE, wSkills.LANGUAGECOMMON,
                    wSkills.LANGUAGEDWARVEN, wSkills.LANGUAGEELDER, wSkills.HUMANPERCEPTION,
                    wSkills.PERSUASION, wSkills.STREETWISE, wSkills.FINEARTS, wSkills.SEDUCTION,
                    wSkills.SOCIALETIQUETTE)),
    CRAFTSMAN(0, wProfessionSkills.PATCHJOB,
            List.of(wSkills.CRAFTING, wSkills.BUSINESS, wSkills.ATHLETICS, wSkills.ENDURANCE,
                    wSkills.PHYSIQUE, wSkills.STREETWISE, wSkills.FINEARTS, wSkills.ALCHEMY,
                    wSkills.EDUCATION, wSkills.PERSUASION)),
    CRIMINAL(0, wProfessionSkills.PRACTICEDPARANOIA,
            List.of(wSkills.SLEIGHTOFHAND, wSkills.PICKLOCK, wSkills.STREETWISE, wSkills.FORGERY,
                    wSkills.DECEIT, wSkills.STEALTH, wSkills.INTIMIDATION, wSkills.SMALLBLADES, wSkills.ATHLETICS,
            wSkills.AWARENESS)),
    DOCTOR(0, wProfessionSkills.HEALINGHANDS,
            List.of(wSkills.RESISTCOERCION, wSkills.CHARISMA, wSkills.SOCIALETIQUETTE, wSkills.COURAGE,
                    wSkills.HUMANPERCEPTION, wSkills.WILDERNESSSURVIVAL, wSkills.BUSINESS, wSkills.DEDUCTION,
                    wSkills.SMALLBLADES, wSkills.ALCHEMY)),
    MAGE(5, wProfessionSkills.MAGICALTRAINING,
            List.of(wSkills.HUMANPERCEPTION, wSkills.SPELLCASTING, wSkills.HEXWEAVING, wSkills.RESISTMAGIC,
                    wSkills.STAFFSPEAR, wSkills.EDUCATION, wSkills.RITUALCRAFTING, wSkills.SOCIALETIQUETTE,
                    wSkills.SEDUCTION, wSkills.GROOMINGANDSTYLE)),
    MANATARMS(0, wProfessionSkills.TOUGHASNAILS,
            List.of(wSkills.WILDERNESSSURVIVAL, wSkills.COURAGE, wSkills.PHYSIQUE, wSkills.INTIMIDATION,
                    wSkills.DODGEESCAPE, wSkills.SMALLBLADES, wSkills.SWORDSMANSHIP, wSkills.STAFFSPEAR,
                    wSkills.MELEE, wSkills.BRAWLING)),
    MERCHANT(0, wProfessionSkills.WELLTRAVELED,
            List.of(wSkills.CHARISMA, wSkills.SMALLBLADES, wSkills.EDUCATION, wSkills.LANGUAGEDWARVEN,
                    wSkills.LANGUAGEELDER, wSkills.LANGUAGECOMMON, wSkills.STREETWISE, wSkills.BUSINESS,
                    wSkills.PERSUASION, wSkills.HUMANPERCEPTION, wSkills.GAMBLING, wSkills.RESISTCOERCION)),
    PRIEST(2, wProfessionSkills.INITIATEOFTHEGODS,
            List.of(wSkills.RITUALCRAFTING, wSkills.LEADERSHIP, wSkills.COURAGE, wSkills.HUMANPERCEPTION,
                    wSkills.HEXWEAVING, wSkills.FIRSTAID, wSkills.CHARISMA, wSkills.WILDERNESSSURVIVAL,
                    wSkills.TEACHING, wSkills.SPELLCASTING)),
    WITCHER(2, wProfessionSkills.WITCHERTRAINING,
            List.of(wSkills.AWARENESS, wSkills.DEDUCTION, wSkills.SPELLCASTING, wSkills.ALCHEMY, wSkills.DODGEESCAPE,
                    wSkills.WILDERNESSSURVIVAL, wSkills.SWORDSMANSHIP, wSkills.ATHLETICS, wSkills.STEALTH,
                    wSkills.RIDING));

    wProfession(int vigor, wProfessionSkills definingSkill, List<wSkills> keySkills) {
    }
}
