package familiar.service.character.transformer;

import familiar.entities.character.RpgCharacterEntity;
import familiar.entities.character.witcher.WitcherCharacterEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.character.domain.RpgCharacter;
import familiar.service.character.domain.witcher.WitcherCharacter;
import familiar.service.note.transformer.NoteMapper;
import familiar.service.user.transformer.UserMapper;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Mapper(componentModel = "spring")
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
        RpgCharacterEntity character = WitcherCharacterEntity.builder()
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
        context.storeMappedInstance(character, RpgCharacter.class);
        return character;
    }

    private Map<String, Integer> convertKeyToString(Map<?, Integer> abilities) {
        Map<String, Integer> converted = new HashMap<>();
        for (Map.Entry<?, Integer> ability : abilities.entrySet()) {
            converted.put(ability.getKey().toString(), ability.getValue());
        }
        return converted;
    }
}
