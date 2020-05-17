package familiar.service.character.domain.witcher.profession;

import familiar.service.character.domain.witcher.WitcherSkills;

import java.util.List;

public enum WitcherProfession {
    BARD(0, WitcherProfessionSkills.BUSKING,
            List.of(WitcherSkills.CHARISMA, WitcherSkills.DECEIT, WitcherSkills.PERFORMANCE, WitcherSkills.LANGUAGECOMMON,
                    WitcherSkills.LANGUAGEDWARVEN, WitcherSkills.LANGUAGEELDER, WitcherSkills.HUMANPERCEPTION,
                    WitcherSkills.PERSUASION, WitcherSkills.STREETWISE, WitcherSkills.FINEARTS, WitcherSkills.SEDUCTION,
                    WitcherSkills.SOCIALETIQUETTE)),
    CRAFTSMAN(0, WitcherProfessionSkills.PATCHJOB,
            List.of(WitcherSkills.CRAFTING, WitcherSkills.BUSINESS, WitcherSkills.ATHLETICS, WitcherSkills.ENDURANCE,
                    WitcherSkills.PHYSIQUE, WitcherSkills.STREETWISE, WitcherSkills.FINEARTS, WitcherSkills.ALCHEMY,
                    WitcherSkills.EDUCATION, WitcherSkills.PERSUASION)),
    CRIMINAL(0, WitcherProfessionSkills.PRACTICEDPARANOIA,
            List.of(WitcherSkills.SLEIGHTOFHAND, WitcherSkills.PICKLOCK, WitcherSkills.STREETWISE, WitcherSkills.FORGERY,
                    WitcherSkills.DECEIT, WitcherSkills.STEALTH, WitcherSkills.INTIMIDATION, WitcherSkills.SMALLBLADES, WitcherSkills.ATHLETICS,
                    WitcherSkills.AWARENESS)),
    DOCTOR(0, WitcherProfessionSkills.HEALINGHANDS,
            List.of(WitcherSkills.RESISTCOERCION, WitcherSkills.CHARISMA, WitcherSkills.SOCIALETIQUETTE, WitcherSkills.COURAGE,
                    WitcherSkills.HUMANPERCEPTION, WitcherSkills.WILDERNESSSURVIVAL, WitcherSkills.BUSINESS, WitcherSkills.DEDUCTION,
                    WitcherSkills.SMALLBLADES, WitcherSkills.ALCHEMY)),
    MAGE(5, WitcherProfessionSkills.MAGICALTRAINING,
            List.of(WitcherSkills.HUMANPERCEPTION, WitcherSkills.SPELLCASTING, WitcherSkills.HEXWEAVING, WitcherSkills.RESISTMAGIC,
                    WitcherSkills.STAFFSPEAR, WitcherSkills.EDUCATION, WitcherSkills.RITUALCRAFTING, WitcherSkills.SOCIALETIQUETTE,
                    WitcherSkills.SEDUCTION, WitcherSkills.GROOMINGANDSTYLE)),
    MANATARMS(0, WitcherProfessionSkills.TOUGHASNAILS,
            List.of(WitcherSkills.WILDERNESSSURVIVAL, WitcherSkills.COURAGE, WitcherSkills.PHYSIQUE, WitcherSkills.INTIMIDATION,
                    WitcherSkills.DODGEESCAPE, WitcherSkills.SMALLBLADES, WitcherSkills.SWORDSMANSHIP, WitcherSkills.STAFFSPEAR,
                    WitcherSkills.MELEE, WitcherSkills.BRAWLING)),
    MERCHANT(0, WitcherProfessionSkills.WELLTRAVELED,
            List.of(WitcherSkills.CHARISMA, WitcherSkills.SMALLBLADES, WitcherSkills.EDUCATION, WitcherSkills.LANGUAGEDWARVEN,
                    WitcherSkills.LANGUAGEELDER, WitcherSkills.LANGUAGECOMMON, WitcherSkills.STREETWISE, WitcherSkills.BUSINESS,
                    WitcherSkills.PERSUASION, WitcherSkills.HUMANPERCEPTION, WitcherSkills.GAMBLING, WitcherSkills.RESISTCOERCION)),
    PRIEST(2, WitcherProfessionSkills.INITIATEOFTHEGODS,
            List.of(WitcherSkills.RITUALCRAFTING, WitcherSkills.LEADERSHIP, WitcherSkills.COURAGE, WitcherSkills.HUMANPERCEPTION,
                    WitcherSkills.HEXWEAVING, WitcherSkills.FIRSTAID, WitcherSkills.CHARISMA, WitcherSkills.WILDERNESSSURVIVAL,
                    WitcherSkills.TEACHING, WitcherSkills.SPELLCASTING)),
    WITCHER(2, WitcherProfessionSkills.WITCHERTRAINING,
            List.of(WitcherSkills.AWARENESS, WitcherSkills.DEDUCTION, WitcherSkills.SPELLCASTING, WitcherSkills.ALCHEMY, WitcherSkills.DODGEESCAPE,
                    WitcherSkills.WILDERNESSSURVIVAL, WitcherSkills.SWORDSMANSHIP, WitcherSkills.ATHLETICS, WitcherSkills.STEALTH,
                    WitcherSkills.RIDING));

    WitcherProfession(int vigor, WitcherProfessionSkills definingSkill, List<WitcherSkills> keySkills) {
    }
}
