package familiar.service.character.domain.witcher;

import familiar.service.character.domain.Gender;
import familiar.service.character.domain.Name;
import familiar.service.character.domain.Status;
import familiar.service.character.domain.witcher.profession.WitcherProfession;
import familiar.service.character.domain.witcher.profession.WitcherProfessionSkills;
import familiar.service.note.domain.Note;
import familiar.service.user.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class WitcherCharacter extends familiar.service.character.domain.RpgCharacter {

    @Builder
    public WitcherCharacter(long id, User owner, LocalDateTime created, Name name, Gender gender,
                            int age, List<Note> storyTellerNotes, Status status, Map<WitcherStats, Integer> coreStatistics,
                            Map<WitcherSkills, Integer> coreSkills, Map<WitcherProfessionSkills, Integer> professionSkills, WitcherRace race,
                            WitcherProfession profession) {
        super(id, owner, created, name, gender, age, storyTellerNotes, status);
        this.coreStatistics = coreStatistics;
        this.coreSkills = coreSkills;
        this.professionSkills = professionSkills;
        this.race = race;
        this.profession = profession;
    }

    private Map<WitcherStats, Integer> coreStatistics;
    private Map<WitcherSkills, Integer> coreSkills;
    private Map<WitcherProfessionSkills, Integer> professionSkills;
    private WitcherRace race;
    private WitcherProfession profession;

}
