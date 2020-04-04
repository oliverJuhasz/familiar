package familiar.domain.character.witcher;

import java.util.Map;

public enum wRace {
    WITCHER(Map.of(wStats.EMPATHY, -4, wStats.REFLEXES, 1), Map.of(wSkills.AWARENESS, 1)),
    HUMAN(Map.of(wStats.EMPATHY, -4), Map.of(wSkills.DEDUCTION, 1)),
    DWARF(Map.of(), Map.of(wSkills.PHYSIQUE, 1, wSkills.BUSINESS, 1)),
    ELF(Map.of(), Map.of(wSkills.FINEARTS, 1, wSkills.ARCHERY, 2));


    wRace(Map<wStats, Integer> abilities, Map<wSkills, Integer> skills) {
    }
}
