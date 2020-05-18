package familiar.service.character.domain.witcher;

import familiar.service.character.domain.Gender;
import familiar.service.character.domain.Name;
import familiar.service.character.domain.RpgCharacter;
import familiar.service.character.domain.Status;
import familiar.service.character.domain.witcher.profession.WitcherProfession;
import familiar.service.character.domain.witcher.profession.WitcherProfessionSkills;
import familiar.service.note.domain.Note;
import familiar.service.user.domain.Player;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class WitcherCharacter extends RpgCharacter {

    @Builder
    public WitcherCharacter(long id, Player owner, LocalDateTime created, Name name, Gender gender,
                            int age, List<Note> storyTellerNotes, Status status, Map<WitcherStats, Integer> coreAbilities,
                            Map<WitcherSkills, Integer> coreSkills, Map<WitcherProfessionSkills, Integer> professionSkills, WitcherRace race,
                            WitcherProfession profession) {
        super(id, owner, created, name, gender, age, storyTellerNotes, status);
        this.coreAbilities = coreAbilities;
        this.coreSkills = coreSkills;
        this.professionSkills = professionSkills;
        this.race = race;
        this.profession = profession;
    }

    private Map<WitcherStats, Integer> coreAbilities;
    private Map<WitcherSkills, Integer> coreSkills;
    private Map<WitcherProfessionSkills, Integer> professionSkills;
    private WitcherRace race;
    private WitcherProfession profession;

}
