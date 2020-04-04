package familiar.domain.character.witcher;

public enum wSkills {
    AWARENESS(wAbilities.INTELLIGENCE, 1),
    BUSINESS(wAbilities.INTELLIGENCE, 1),
    DEDUCTION(wAbilities.INTELLIGENCE, 1),
    EDUCATION(wAbilities.INTELLIGENCE, 1),
    LANGUAGECOMMON(wAbilities.INTELLIGENCE, 2),
    LANGUAGEDWARVEN(wAbilities.INTELLIGENCE, 2),
    LANGUAGEELDER(wAbilities.INTELLIGENCE, 2),
    MONSTERLORE(wAbilities.INTELLIGENCE, 2),
    SOCIALETIQUETTE(wAbilities.INTELLIGENCE, 1),
    STREETWISE(wAbilities.INTELLIGENCE, 1),
    TACTICS(wAbilities.INTELLIGENCE, 2),
    TEACHING(wAbilities.INTELLIGENCE, 1),
    WILDERNESSSURVIVAL(wAbilities.INTELLIGENCE, 1),
    BRAWLING(wAbilities.REFLEXES, 1),
    DODGEESCAPE(wAbilities.REFLEXES, 1),
    MELEE(wAbilities.REFLEXES, 1),
    RIDING(wAbilities.REFLEXES, 1),
    SAILING(wAbilities.REFLEXES, 1),
    SMALLBLADES(wAbilities.REFLEXES, 1),
    STAFFSPEAR(wAbilities.REFLEXES, 1),
    SWORDSMANSHIP(wAbilities.REFLEXES, 1),
    ARCHERY(wAbilities.DEXTERITY, 1),
    ATHLETICS(wAbilities.DEXTERITY, 1),
    CROSSBOW(wAbilities.DEXTERITY, 1),
    SLEIGHTOFHAND(wAbilities.DEXTERITY, 1),
    STEALTH(wAbilities.DEXTERITY, 1),
    PHYSIQUE(wAbilities.BODY, 1),
    ENDURANCE(wAbilities.BODY, 1),
    CHARISMA(wAbilities.EMPATHY, 1),
    DECEIT(wAbilities.EMPATHY, 1),
    FINEARTS(wAbilities.EMPATHY, 1),
    GAMBLING(wAbilities.EMPATHY, 1),
    GROOMINGANDSTYLE(wAbilities.EMPATHY, 1),
    HUMANPERCEPTION(wAbilities.EMPATHY, 1),
    LEADERSHIP(wAbilities.EMPATHY, 1),
    PERSUASION(wAbilities.EMPATHY, 1),
    PERFORMANCE(wAbilities.EMPATHY, 1),
    SEDUCTION(wAbilities.EMPATHY, 1),
    ALCHEMY(wAbilities.CRAFT, 2),
    CRAFTING(wAbilities.CRAFT, 2),
    DISGUISE(wAbilities.CRAFT, 1),
    FIRSTAID(wAbilities.CRAFT, 1),
    FORGERY(wAbilities.CRAFT, 1),
    PICKLOCK(wAbilities.CRAFT, 1),
    TRAPCRAFTING(wAbilities.CRAFT, 2),
    COURAGE(wAbilities.WILL, 1),
    HEXWEAVING(wAbilities.WILL, 2),
    INTIMIDATION(wAbilities.WILL, 1),
    SPELLCASTING(wAbilities.WILL, 2),
    RESISTMAGIC(wAbilities.WILL, 2),
    RESISTCOERCION(wAbilities.WILL, 1),
    RITUALCRAFTING(wAbilities.WILL, 2);

    public final wAbilities baseAbility;
    public final int multiplier;

    wSkills(wAbilities ability, int multiplier) {
        this.baseAbility = ability;
        this.multiplier = multiplier;
    }



}
