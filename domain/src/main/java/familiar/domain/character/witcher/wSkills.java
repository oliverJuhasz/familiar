package familiar.domain.character.witcher;

public enum wSkills {
    AWARENESS(wStats.INTELLIGENCE, 1),
    BUSINESS(wStats.INTELLIGENCE, 1),
    DEDUCTION(wStats.INTELLIGENCE, 1),
    EDUCATION(wStats.INTELLIGENCE, 1),
    LANGUAGECOMMON(wStats.INTELLIGENCE, 2),
    LANGUAGEDWARVEN(wStats.INTELLIGENCE, 2),
    LANGUAGEELDER(wStats.INTELLIGENCE, 2),
    MONSTERLORE(wStats.INTELLIGENCE, 2),
    SOCIALETIQUETTE(wStats.INTELLIGENCE, 1),
    STREETWISE(wStats.INTELLIGENCE, 1),
    TACTICS(wStats.INTELLIGENCE, 2),
    TEACHING(wStats.INTELLIGENCE, 1),
    WILDERNESSSURVIVAL(wStats.INTELLIGENCE, 1),
    BRAWLING(wStats.REFLEXES, 1),
    DODGEESCAPE(wStats.REFLEXES, 1),
    MELEE(wStats.REFLEXES, 1),
    RIDING(wStats.REFLEXES, 1),
    SAILING(wStats.REFLEXES, 1),
    SMALLBLADES(wStats.REFLEXES, 1),
    STAFFSPEAR(wStats.REFLEXES, 1),
    SWORDSMANSHIP(wStats.REFLEXES, 1),
    ARCHERY(wStats.DEXTERITY, 1),
    ATHLETICS(wStats.DEXTERITY, 1),
    CROSSBOW(wStats.DEXTERITY, 1),
    SLEIGHTOFHAND(wStats.DEXTERITY, 1),
    STEALTH(wStats.DEXTERITY, 1),
    PHYSIQUE(wStats.BODY, 1),
    ENDURANCE(wStats.BODY, 1),
    CHARISMA(wStats.EMPATHY, 1),
    DECEIT(wStats.EMPATHY, 1),
    FINEARTS(wStats.EMPATHY, 1),
    GAMBLING(wStats.EMPATHY, 1),
    GROOMINGANDSTYLE(wStats.EMPATHY, 1),
    HUMANPERCEPTION(wStats.EMPATHY, 1),
    LEADERSHIP(wStats.EMPATHY, 1),
    PERSUASION(wStats.EMPATHY, 1),
    PERFORMANCE(wStats.EMPATHY, 1),
    SEDUCTION(wStats.EMPATHY, 1),
    ALCHEMY(wStats.CRAFT, 2),
    CRAFTING(wStats.CRAFT, 2),
    DISGUISE(wStats.CRAFT, 1),
    FIRSTAID(wStats.CRAFT, 1),
    FORGERY(wStats.CRAFT, 1),
    PICKLOCK(wStats.CRAFT, 1),
    TRAPCRAFTING(wStats.CRAFT, 2),
    COURAGE(wStats.WILL, 1),
    HEXWEAVING(wStats.WILL, 2),
    INTIMIDATION(wStats.WILL, 1),
    SPELLCASTING(wStats.WILL, 2),
    RESISTMAGIC(wStats.WILL, 2),
    RESISTCOERCION(wStats.WILL, 1),
    RITUALCRAFTING(wStats.WILL, 2);

    public final wStats baseAbility;
    public final int multiplier;

    wSkills(wStats ability, int multiplier) {
        this.baseAbility = ability;
        this.multiplier = multiplier;
    }



}
