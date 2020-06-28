package familiar.entities.character.witcher;

import familiar.entities.NoteEntity;
import familiar.entities.UserEntity;
import familiar.entities.character.NameEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "`WitcherCharacters`")
public class WitcherCharacterEntity extends familiar.entities.character.RpgCharacterEntity {

    @Builder
    public WitcherCharacterEntity(long id, UserEntity owner, LocalDateTime created, NameEntity nameEntity, String gender,
                                  int age, List<NoteEntity> storyTellerNotes, String status, Map<String, Integer> coreStatistics,
                                  Map<String, Integer> coreSkills, Map<String, Integer> professionSkills, String race,
                                  String profession) {
        super(id, owner, created, nameEntity, gender, age, storyTellerNotes, status);
        this.coreStatistics = coreStatistics;
        this.coreSkills = coreSkills;
        this.professionSkills = professionSkills;
        this.race = race;
        this.profession = profession;
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "`WitcherCharacters_CoreStatistics`", joinColumns = @JoinColumn(name = "`RpgCharacterId`"))
    @MapKeyColumn(name = "`Statistic`", length = 20)
    @Column(name = "`CoreStatisticValue`")
    private Map<String, Integer> coreStatistics;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "`WitcherCharacters_CoreSkills`", joinColumns = @JoinColumn(name = "`RpgCharacterId`"))
    @MapKeyColumn(name = "`Skill`", length = 20)
    @Column(name = "`CoreSkillValue`")
    private Map<String, Integer> coreSkills;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "`WitcherCharacters_ProfessionSkills`", joinColumns = @JoinColumn(name = "`RpgCharacterId`"))
    @MapKeyColumn(name = "`Profession`", length = 40)
    @Column(name = "`CoreSkillValue`")
    private Map<String, Integer> professionSkills;

    @Column(name = "`Race`", nullable = false, length = 20)
    private String race;

    @Column(name = "`Profession`", nullable = false, length = 20)
    private String profession;

}
