package familiar.entities.character.witcher;

import familiar.entities.NoteEntity;
import familiar.entities.PlayerEntity;
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
    public WitcherCharacterEntity(long id, PlayerEntity owner, LocalDateTime created, NameEntity nameEntity, String gender,
                                  int age, List<NoteEntity> storyTellerNotes, String status, Map<String, Integer> coreAbilities,
                                  Map<String, Integer> coreSkills, Map<String, Integer> professionSkills, String race,
                                  String profession) {
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
    @Column(name = "`CoreAbilityValue`")
    private Map<String, Integer> coreAbilities;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "`WitcherCharacters_CoreSkills`", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "xyz2"), joinColumns = @JoinColumn(name = "`CoreSkillID`"))
    @MapKeyColumn(name = "`Skill`", length = 20)
    @Column(name = "`CoreSkillValue`")
    private Map<String, Integer> coreSkills;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "`WitcherCharacters_ProfessionSkills`", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "xyz3"), joinColumns = @JoinColumn(name = "`ProfessionID`"))
    @MapKeyColumn(name = "`Profession`", length = 40)
    @Column(name = "`CoreSkillValue`")
    private Map<String, Integer> professionSkills;

    @Column(name = "`Race`", nullable = false, length = 20)
    private String race;

    @Column(name = "`Profession`", nullable = false, length = 20)
    private String profession;

}
