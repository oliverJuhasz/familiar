package familiar.core.service;


import familiar.core.domain.Campaign;
import familiar.core.domain.Combat;
import familiar.core.domain.character.dnd.DnDAbilities;
import familiar.core.domain.character.dnd.DnDCharacter;
import familiar.core.domain.character.dnd.DnDRace;
import familiar.core.domain.character.dnd.DnDSkills;

public class Main {

    public static void main(String[] args) {

        Campaign misfits = new Campaign();

        DnDCharacter hollo = new DnDCharacter();
        hollo.setHitPoints(32);
        hollo.setMoney(2000);
        hollo.setAbilities(new DnDAbilities());
        hollo.getAbilities().setCharisma(20);
        hollo.getAbilities().setStrength(8);
        hollo.getAbilities().setConstitution(12);
        hollo.getAbilities().setDexterity(16);
        hollo.getAbilities().setIntelligence(11);
        hollo.getAbilities().setWisdom(8);
        hollo.setInitiative(3);
        hollo.setRace(DnDRace.Human);
        hollo.setSkills(new DnDSkills());
        hollo.getSkills().setPerformance(12);
        hollo.getSkills().setPersuasion(12);
        hollo.getSkills().setDeception(12);
        hollo.setArmorClass(14);

        DnDCharacter darren = new DnDCharacter();
        darren.setHitPoints(50);
        darren.setMoney(500);
        darren.setAbilities(new DnDAbilities());
        darren.getAbilities().setCharisma(8);
        darren.getAbilities().setStrength(14);
        darren.getAbilities().setConstitution(16);
        darren.getAbilities().setDexterity(8);
        darren.getAbilities().setIntelligence(8);
        darren.getAbilities().setWisdom(16);
        darren.setInitiative(5);
        darren.setRace(DnDRace.Dwarf);
        darren.setSkills(new DnDSkills());
        darren.getSkills().setAnimalHandling(4);
        darren.getSkills().setAthletics(8);
        darren.getSkills().setSurvival(12);
        darren.setArmorClass(21);

        Combat combat = new Combat();
        combat.addCharacter(darren);
        combat.addCharacter(hollo);


    }

}
