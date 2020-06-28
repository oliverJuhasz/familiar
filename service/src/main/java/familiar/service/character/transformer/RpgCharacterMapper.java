package familiar.service.character.transformer;

import familiar.entities.character.RpgCharacterEntity;
import familiar.entities.character.witcher.WitcherCharacterEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.character.domain.Gender;
import familiar.service.character.domain.RpgCharacter;
import familiar.service.character.domain.Status;
import familiar.service.character.domain.witcher.WitcherCharacter;
import familiar.service.character.domain.witcher.WitcherRace;
import familiar.service.character.domain.witcher.WitcherSkills;
import familiar.service.character.domain.witcher.WitcherStats;
import familiar.service.character.domain.witcher.profession.WitcherProfession;
import familiar.service.character.domain.witcher.profession.WitcherProfessionSkills;
import familiar.service.note.transformer.NoteMapper;
import familiar.service.user.transformer.UserMapper;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public abstract class RpgCharacterMapper {

    @Autowired
    private NameMapper nameMapper;

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private UserMapper userMapper;

    public RpgCharacterEntity rpgCharacterToRgpCharacterEntity(RpgCharacter rpgCharacter, @Context CycleAvoidingMappingContext context) {
        RpgCharacterEntity target = context.getMappedInstance(rpgCharacter, RpgCharacterEntity.class);
        if (target != null) {
            return target;
        }

        if (rpgCharacter == null) {
            return null;
        }

        WitcherCharacter from = (WitcherCharacter) rpgCharacter;
        RpgCharacterEntity characterEntity = WitcherCharacterEntity.builder()
                .age(from.getAge())
                .coreAbilities(convertKeyToString(from.getCoreAbilities()))
                .coreSkills(convertKeyToString(from.getCoreSkills()))
                .created(from.getCreated())
                .gender(from.getGender().toString())
                .id(from.getId())
                .nameEntity(nameMapper.convertNameToNameEntity(rpgCharacter.getName(), context))
                .owner(userMapper.userToUserEntity(rpgCharacter.getOwner(), context))
                .profession(from.getProfession().toString())
                .professionSkills(convertKeyToString(from.getProfessionSkills()))
                .race(from.getRace().toString())
                .status(from.getStatus().toString())
                .storyTellerNotes(rpgCharacter.getStoryTellerNotes()
                        .stream()
                        .map(note -> noteMapper.convertNoteToNoteEntity(note, context))
                        .collect(Collectors.toList()))
                .build();
        context.storeMappedInstance(rpgCharacter, characterEntity);
        return characterEntity;
    }

    public RpgCharacter rpgCharacterEntityToRgpCharacter(RpgCharacterEntity rpgCharacterEntity, @Context CycleAvoidingMappingContext context) {
        RpgCharacter target = context.getMappedInstance(rpgCharacterEntity, RpgCharacter.class);
        if (target != null) {
            return target;
        }

        if (rpgCharacterEntity == null) {
            return null;
        }

        WitcherCharacterEntity from = (WitcherCharacterEntity) rpgCharacterEntity;
        RpgCharacter character = WitcherCharacter.builder()
                .age(from.getAge())
                .coreAbilities(convertAbilityToKey(from.getCoreAbilities()))
                .coreSkills(convertCoreSkillToKey(from.getCoreSkills()))
                .created(from.getCreated())
                .gender(Gender.valueOf(from.getGender()))
                .id(from.getId())
                .name(nameMapper.convertNameEntityToName(from.getNameEntity(), context))
                .owner(userMapper.userEntityToUser(from.getOwner(), context))
                .profession(WitcherProfession.valueOf(from.getProfession()))
                .professionSkills(convertProfessionSkillToKey(from.getProfessionSkills()))
                .race(WitcherRace.valueOf(from.getRace()))
                .status(Status.valueOf(from.getStatus()))
                .storyTellerNotes(rpgCharacterEntity.getStoryTellerNotes()
                        .stream()
                        .map(noteEntity -> noteMapper.noteEntityToNote(noteEntity, context))
                        .collect(Collectors.toList()))
                .build();
        context.storeMappedInstance(rpgCharacterEntity, character);
        return character;
    }

    private Map<String, Integer> convertKeyToString(Map<?, Integer> abilities) {
        Map<String, Integer> converted = new HashMap<>();
        for (Map.Entry<?, Integer> ability : abilities.entrySet()) {
            converted.put(ability.getKey().toString(), ability.getValue());
        }
        return converted;
    }

    private Map<WitcherStats, Integer> convertAbilityToKey(Map<String, Integer> abilities) {
        Map<WitcherStats, Integer> converted = new HashMap<>();
        for (Map.Entry<String, Integer> ability : abilities.entrySet()) {
            converted.put(WitcherStats.valueOf(ability.getKey()), ability.getValue());
        }
        return converted;
    }

    private Map<WitcherSkills, Integer> convertCoreSkillToKey(Map<String, Integer> abilities) {
        Map<WitcherSkills, Integer> converted = new HashMap<>();
        for (Map.Entry<String, Integer> ability : abilities.entrySet()) {
            converted.put(WitcherSkills.valueOf(ability.getKey()), ability.getValue());
        }
        return converted;
    }

    private Map<WitcherProfessionSkills, Integer> convertProfessionSkillToKey(Map<String, Integer> abilities) {
        Map<WitcherProfessionSkills, Integer> converted = new HashMap<>();
        for (Map.Entry<String, Integer> ability : abilities.entrySet()) {
            converted.put(WitcherProfessionSkills.valueOf(ability.getKey()), ability.getValue());
        }
        return converted;
    }
}
