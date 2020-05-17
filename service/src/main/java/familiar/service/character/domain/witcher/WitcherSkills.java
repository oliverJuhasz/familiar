package familiar.service.character.domain.witcher;

public enum WitcherSkills {
    AWARENESS(WitcherStats.INTELLIGENCE, 1),
    BUSINESS(WitcherStats.INTELLIGENCE, 1),
    DEDUCTION(WitcherStats.INTELLIGENCE, 1),
    EDUCATION(WitcherStats.INTELLIGENCE, 1),
    LANGUAGECOMMON(WitcherStats.INTELLIGENCE, 2),
    LANGUAGEDWARVEN(WitcherStats.INTELLIGENCE, 2),
    LANGUAGEELDER(WitcherStats.INTELLIGENCE, 2),
    MONSTERLORE(WitcherStats.INTELLIGENCE, 2),
    SOCIALETIQUETTE(WitcherStats.INTELLIGENCE, 1),
    STREETWISE(WitcherStats.INTELLIGENCE, 1),
    TACTICS(WitcherStats.INTELLIGENCE, 2),
    TEACHING(WitcherStats.INTELLIGENCE, 1),
    WILDERNESSSURVIVAL(WitcherStats.INTELLIGENCE, 1),
    BRAWLING(WitcherStats.REFLEXES, 1),
    DODGEESCAPE(WitcherStats.REFLEXES, 1),
    MELEE(WitcherStats.REFLEXES, 1),
    RIDING(WitcherStats.REFLEXES, 1),
    SAILING(WitcherStats.REFLEXES, 1),
    SMALLBLADES(WitcherStats.REFLEXES, 1),
    STAFFSPEAR(WitcherStats.REFLEXES, 1),
    SWORDSMANSHIP(WitcherStats.REFLEXES, 1),
    ARCHERY(WitcherStats.DEXTERITY, 1),
    ATHLETICS(WitcherStats.DEXTERITY, 1),
    CROSSBOW(WitcherStats.DEXTERITY, 1),
    SLEIGHTOFHAND(WitcherStats.DEXTERITY, 1),
    STEALTH(WitcherStats.DEXTERITY, 1),
    PHYSIQUE(WitcherStats.BODY, 1),
    ENDURANCE(WitcherStats.BODY, 1),
    CHARISMA(WitcherStats.EMPATHY, 1),
    DECEIT(WitcherStats.EMPATHY, 1),
    FINEARTS(WitcherStats.EMPATHY, 1),
    GAMBLING(WitcherStats.EMPATHY, 1),
    GROOMINGANDSTYLE(WitcherStats.EMPATHY, 1),
    HUMANPERCEPTION(WitcherStats.EMPATHY, 1),
    LEADERSHIP(WitcherStats.EMPATHY, 1),
    PERSUASION(WitcherStats.EMPATHY, 1),
    PERFORMANCE(WitcherStats.EMPATHY, 1),
    SEDUCTION(WitcherStats.EMPATHY, 1),
    ALCHEMY(WitcherStats.CRAFT, 2),
    CRAFTING(WitcherStats.CRAFT, 2),
    DISGUISE(WitcherStats.CRAFT, 1),
    FIRSTAID(WitcherStats.CRAFT, 1),
    FORGERY(WitcherStats.CRAFT, 1),
    PICKLOCK(WitcherStats.CRAFT, 1),
    TRAPCRAFTING(WitcherStats.CRAFT, 2),
    COURAGE(WitcherStats.WILL, 1),
    HEXWEAVING(WitcherStats.WILL, 2),
    INTIMIDATION(WitcherStats.WILL, 1),
    SPELLCASTING(WitcherStats.WILL, 2),
    RESISTMAGIC(WitcherStats.WILL, 2),
    RESISTCOERCION(WitcherStats.WILL, 1),
    RITUALCRAFTING(WitcherStats.WILL, 2);

    public final WitcherStats baseAbility;
    public final int multiplier;

    WitcherSkills(WitcherStats ability, int multiplier) {
        this.baseAbility = ability;
        this.multiplier = multiplier;
    }


}
