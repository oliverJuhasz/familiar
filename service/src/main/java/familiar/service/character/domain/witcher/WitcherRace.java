package familiar.service.character.domain.witcher;

import java.util.Map;

public enum WitcherRace {
    WITCHER(Map.of(WitcherStats.EMPATHY, -4, WitcherStats.REFLEXES, 1), Map.of(WitcherSkills.AWARENESS, 1)),
    HUMAN(Map.of(WitcherStats.EMPATHY, -4), Map.of(WitcherSkills.DEDUCTION, 1)),
    DWARF(Map.of(), Map.of(WitcherSkills.PHYSIQUE, 1, WitcherSkills.BUSINESS, 1)),
    ELF(Map.of(), Map.of(WitcherSkills.FINEARTS, 1, WitcherSkills.ARCHERY, 2));

    public final Map<WitcherStats, Integer> stats;
    public final Map<WitcherSkills, Integer> skills;

    WitcherRace(Map<WitcherStats, Integer> stats, Map<WitcherSkills, Integer> skills) {
        this.stats = stats;
        this.skills = skills;
    }
}
