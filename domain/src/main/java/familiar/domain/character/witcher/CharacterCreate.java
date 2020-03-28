package familiar.domain.character.witcher;

import familiar.domain.character.Gender;
import familiar.domain.character.Name;
import familiar.domain.character.witcher.profession.wProfession;

import java.util.Map;

public class CharacterCreate {

    public static void main(String[] args) {
        wCharacter remia = wCharacter.builder()
                .name(new Name("Remia", null, null, null))
                .gender(Gender.FEMALE)
                .race(wRace.ELF)
                .age(30)
                .profession(wProfession.CRAFTSMAN)
                .coreAbilities(Map.of(wAbilities.INTELLIGENCE, 9, wAbilities.REFLEXES, 7, wAbilities.DEXTERITY, 8,
                        wAbilities.BODY, 6, wAbilities.SPEED, 5, wAbilities.EMPATHY, 7, wAbilities.CRAFT, 9,
                        wAbilities.WILL, 6, wAbilities.LUCK, 3))
                .coreSkills(Map.of(wSkills.AWARENESS, 2, wSkills.BUSINESS, 2, wSkills.EDUCATION, 3, wSkills.DEDUCTION, 1,
                        wSkills.STREETWISE, 5, wSkills.DODGEESCAPE, 3, wSkills.ARCHERY, 4, wSkills.ATHLETICS, 4,
                        wSkills.CROSSBOW, 1, wSkills.PHYSIQUE, 4))
                .build();
        System.out.println(remia);
    }

}
