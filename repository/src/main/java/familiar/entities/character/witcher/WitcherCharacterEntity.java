package familiar.entities.character.witcher;

import familiar.entities.NoteEntity;
import familiar.entities.PlayerEntity;
import familiar.entities.character.NameEntity;
import familiar.entities.character.RpgCharacterEntity;
import familiar.service.character.domain.Gender;
import familiar.service.character.domain.Status;
import familiar.service.character.domain.witcher.WitcherRace;
import familiar.service.character.domain.witcher.WitcherSkills;
import familiar.service.character.domain.witcher.WitcherStats;
import familiar.service.character.domain.witcher.profession.WitcherProfession;
import familiar.service.character.domain.witcher.profession.WitcherProfessionSkills;
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
public class WitcherCharacterEntity extends RpgCharacterEntity {

    @Builder
    public WitcherCharacterEntity(long id, PlayerEntity owner, LocalDateTime created, NameEntity nameEntity, Gender gender,
                                  int age, List<NoteEntity> storyTellerNotes, Status status, Map<WitcherStats, Integer> coreAbilities,
                                  Map<WitcherSkills, Integer> coreSkills, Map<WitcherProfessionSkills, Integer> professionSkills, WitcherRace race,
                                  WitcherProfession profession) {
        super(id, owner, created, nameEntity, gender, age, storyTellerNotes, status);
        this.coreAbilities = coreAbilities;
        this.coreSkills = coreSkills;
        this.professionSkills = professionSkills;
        this.race = race;
        this.profession = profession;
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "`WitcherCharacters_CoreAbilities`", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "xyz"), joinColumns = @JoinColumn(name = "`CoreAbilityID`"))
    @MapKeyColumn(name = "`Ability`", length = 20)
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "`CoreAbilityValue`")
    private Map<WitcherStats, Integer> coreAbilities;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "`WitcherCharacters_CoreSkills`", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "xyz2"), joinColumns = @JoinColumn(name = "`CoreSkillID`"))
    @MapKeyColumn(name = "`Skill`", length = 20)
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "`CoreSkillValue`")
    private Map<WitcherSkills, Integer> coreSkills;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "`WitcherCharacters_ProfessionSkills`", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "xyz3"), joinColumns = @JoinColumn(name = "`ProfessionID`"))
    @MapKeyColumn(name = "`Profession`", length = 40)
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "`CoreSkillValue`")
    private Map<WitcherProfessionSkills, Integer> professionSkills;

    @Enumerated(EnumType.STRING)
    @Column(name = "`Race`", nullable = false, length = 20)
    private WitcherRace race;

    @Enumerated(EnumType.STRING)
    @Column(name = "`Profession`", nullable = false, length = 20)
    private WitcherProfession profession;

}
