package familiar.entities.character.witcher;

import familiar.entities.character.RPGCharacterEntity;
import familiar.entities.character.witcher.profession.wProfession;
import familiar.entities.character.witcher.profession.wProfessionSkills;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "`WitcherCharacters`")
public class wCharacterEntity extends RPGCharacterEntity {

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "`WitcherCharacter_CoreAbilities`", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "xyz"), joinColumns = @JoinColumn(name = "`CoreAbilityID`"))
    @MapKeyColumn(name = "`Ability`", length = 20)
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "`CoreAbilityValue`")
    private Map<wStats, Integer> coreAbilities;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "`WitcherCharacter_CoreSkills`", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "xyz2"), joinColumns = @JoinColumn(name = "`CoreSkillID`"))
    @MapKeyColumn(name = "`Skill`", length = 20)
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "`CoreSkillValue`")
    private Map<wSkills, Integer> coreSkills;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "`WitcherCharacter_ProfessionSkills`", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "xyz3"), joinColumns = @JoinColumn(name = "`ProfessionID`"))
    @MapKeyColumn(name = "`Profession`", length = 40)
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "`CoreSkillValue`")
    private Map<wProfessionSkills, Integer> professionSkills;

    @Enumerated(EnumType.STRING)
    @Column(name = "`Race`", nullable = false, length = 20)
    private wRace race;

    @Enumerated(EnumType.STRING)
    @Column(name = "`Profession`", nullable = false, length = 20)
    private wProfession profession;

}
