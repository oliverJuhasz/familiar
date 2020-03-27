package familiar.domain.character.witcher.profession;

import familiar.domain.character.witcher.wAbilities;

public enum wProfessionSkills {

    //BARD
    BUSKING(wAbilities.Empathy, null),
    RETURNACT(wAbilities.Empathy, BUSKING),
    RAISEACROWD(wAbilities.Empathy, RETURNACT),
    GOODFRIEND(wAbilities.Empathy, RAISEACROWD),
    FADE(wAbilities.Intelligence, BUSKING),
    SPREADTHEWORD(wAbilities.Intelligence, FADE),
    ACCLIMATIZE(wAbilities.Intelligence, SPREADTHEWORD),
    POISONTHEWELL(wAbilities.Empathy, BUSKING),
    NEEDLING(wAbilities.Empathy, POISONTHEWELL),
    ETTUBRUTE(wAbilities.Empathy, NEEDLING),

    //CRAFTSMAN
    PATCHJOB(wAbilities.Craft, null),
    EXTENSIVECATALOGUE(wAbilities.Intelligence, PATCHJOB),
    JOURNEYMAN(wAbilities.Craft, EXTENSIVECATALOGUE),
    MASTERCRAFTING(wAbilities.Craft, JOURNEYMAN),
    MENTALPHARMACY(wAbilities.Intelligence, PATCHJOB),
    DOUBLEDOSE(wAbilities.Craft, MENTALPHARMACY),
    ADAPTATION(wAbilities.Craft, DOUBLEDOSE),
    AUGMENTATION(wAbilities.Craft, PATCHJOB),
    SILVERCOATING(wAbilities.Craft, AUGMENTATION),
    PINPOINT(wAbilities.Craft, SILVERCOATING),

    //CRIMINAL
    PRACTICEDPARANOIA(wAbilities.Intelligence, null),
    CASETHEAREA(wAbilities.Intelligence, PRACTICEDPARANOIA),
    MENTALKEY(wAbilities.Intelligence, CASETHEAREA),
    GOTOGROUND(wAbilities.Intelligence, MENTALKEY),
    WEAKSPOT(wAbilities.Empathy, PRACTICEDPARANOIA),
    MARKEDMAN(wAbilities.Will, WEAKSPOT),
    RALLY(wAbilities.Will, MARKEDMAN),
    CAREFULAIM(wAbilities.Dexterity, PRACTICEDPARANOIA),
    EYEGOUGE(wAbilities.Dexterity, CAREFULAIM),
    ASSASSINSSTRIKE(wAbilities.Dexterity, EYEGOUGE),

    //DOCTOR

    HEALINGHANDS(wAbilities.Craft, null),
    DIAGNOSE(wAbilities.Intelligence, HEALINGHANDS),
    ANALYSIS(wAbilities.Intelligence, DIAGNOSE),
    EFFECTIVESURGERY(wAbilities.Craft, ANALYSIS),
    HEALINGTENT(wAbilities.Craft, HEALINGHANDS),
    IMPROVISATION(wAbilities.Intelligence, HEALINGTENT),
    HERBALREMEDY(wAbilities.Craft, IMPROVISATION),
    BLEEDINGWOUND(wAbilities.Intelligence, HEALINGHANDS),
    PRACTICALCARNAGE(wAbilities.Intelligence, BLEEDINGWOUND),
    CRIPPLINGWOUND(wAbilities.Intelligence, PRACTICALCARNAGE),

    //MAGE

    MAGICALTRAINING(wAbilities.Intelligence, null),
    SCHEMING(wAbilities.Intelligence, MAGICALTRAINING),
    GRAPEVINE(wAbilities.Intelligence, SCHEMING),
    ASSETS(wAbilities.Intelligence, GRAPEVINE),
    REVERSEENGINEER(wAbilities.Intelligence, MAGICALTRAINING),
    DISTILLATION(wAbilities.Craft, REVERSEENGINEER),
    MUTATE(wAbilities.Intelligence, DISTILLATION),
    INTOUCH(null, MAGICALTRAINING),
    IMMUTABLE(wAbilities.Will, INTOUCH),
    EXPANDEDMAGIC(wAbilities.Will, IMMUTABLE),

    //MANATARMS
    TOUGHASNAILS(wAbilities.Body, null),
    EXTREMERANGE(wAbilities.Dexterity, TOUGHASNAILS),
    TWINSHOT(wAbilities.Dexterity, EXTREMERANGE),
    PINPOINTAIM(wAbilities.Dexterity, TWINSHOT),
    BLOODHOUND(wAbilities.Intelligence, TOUGHASNAILS),
    BOOBYTRAP(wAbilities.Craft, BLOODHOUND),
    TACTICALAWARENESS(wAbilities.Intelligence, BOOBYTRAP),
    FURY(wAbilities.Will, TOUGHASNAILS),
    ZWEIHAND(wAbilities.Body, FURY),
    SHRUGITOFF(wAbilities.Body, ZWEIHAND),

    //MERCHANT
    WELLTRAVELED(wAbilities.Intelligence, null),
    OPTIONS(wAbilities.Intelligence, WELLTRAVELED),
    HARDBARGAIN(wAbilities.Empathy, OPTIONS),
    PROMISE(wAbilities.Empathy, HARDBARGAIN),
    ROOKERY(wAbilities.Empathy, WELLTRAVELED),
    INSIDER(wAbilities.Intelligence, ROOKERY),
    TREASUREMAP(wAbilities.Intelligence, INSIDER),
    WELLCONNECTED(wAbilities.Will, WELLTRAVELED),
    FENCE(wAbilities.Intelligence, WELLCONNECTED),
    WARRIORSDEPT(wAbilities.Empathy, FENCE),

    //PRIEST
    INITIATEOFTHEGODS(wAbilities.Empathy, null),
    DIVINEPOWER(wAbilities.Empathy, INITIATEOFTHEGODS),
    DIVINEAUTHORITY(wAbilities.Empathy, DIVINEPOWER),
    PRECOGNITION(wAbilities.Will, DIVINEAUTHORITY),
    NATUREATTUNEMENT(null, INITIATEOFTHEGODS),
    READNATURE(null, NATUREATTUNEMENT),
    ANIMALCOMPACT(wAbilities.Will, READNATURE),
    BLOODRITUALS(wAbilities.Will, INITIATEOFTHEGODS),
    FERVOR(wAbilities.Empathy, BLOODRITUALS),
    WORDOFGOD(wAbilities.Empathy, FERVOR),

    //WITCHER
    WITCHERTRAINING(wAbilities.Intelligence, null),
    MEDITATION(null, WITCHERTRAINING),
    MAGICALSOURCE(null, MEDITATION),
    HELIOTROPE(wAbilities.Will, MAGICALSOURCE),
    IRONSTOMACH(null, WITCHERTRAINING),
    FRENZY(null, IRONSTOMACH),
    TRANSMUTATION(wAbilities.Body, FRENZY),
    PARRYARROWS(wAbilities.Dexterity, WITCHERTRAINING),
    QUICKSTRIKE(wAbilities.Reflexes, PARRYARROWS),
    WHIRL(wAbilities.Reflexes, QUICKSTRIKE);

    wProfessionSkills(wAbilities empathy, wProfessionSkills preRequisite) {
    }
}
