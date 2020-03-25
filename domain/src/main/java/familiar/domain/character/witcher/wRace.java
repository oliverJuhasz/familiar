package familiar.domain.character.witcher;

import java.util.Collections;
import java.util.Map;

public enum wRace {
    witcher(Map.of(wAbilities.Empathy, -4, wAbilities.Reflexes, 1), Map.of(wSkills.Awareness, 1)),
    human(Map.of(wAbilities.Empathy, -4), Map.of(wSkills.Deduction, 1)),
    dwarf(Map.of(), Map.of(wSkills.Physique, 1, wSkills.Business, 1)),
    elf(Map.of(), Map.of(wSkills.FineArts, 1, wSkills.Archery, 2));


    wRace(Map<wAbilities, Integer> abilities, Map<wSkills, Integer> skills) {
    }
}
