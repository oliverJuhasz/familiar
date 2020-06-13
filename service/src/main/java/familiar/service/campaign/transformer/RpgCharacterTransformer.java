package familiar.service.campaign.transformer;

import familiar.entities.character.RpgCharacterEntity;
import familiar.entities.character.witcher.WitcherCharacterEntity;
import familiar.service.character.domain.RpgCharacter;
import familiar.service.character.domain.witcher.WitcherCharacter;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Mapper(componentModel = "spring")
public abstract class RpgCharacterTransformer {

    @Autowired
    NameMapper nameMapper;

    @Autowired
    NoteMapper noteMapper;

    public RpgCharacterEntity rpgCharacterToRgpCharacterEntity(RpgCharacter rpgCharacter, @Context CycleAvoidingMappingContext context) {
        WitcherCharacter from = (WitcherCharacter) rpgCharacter;
        RpgCharacterEntity character = WitcherCharacterEntity.builder()
                .age(from.getAge())
                .coreAbilities(convertKeyToString(from.getCoreAbilities()))
                .coreSkills(convertKeyToString(from.getCoreSkills()))
                .created(from.getCreated())
                .gender(from.getGender().toString())
                .id(from.getId())
                .nameEntity(nameMapper.convertNameToNameEntity(rpgCharacter.getName(), context))
//                .owner(playerTransformer.transformPlayerToPlayerEntity(from.getOwner()))
                .profession(from.getProfession().toString())
                .professionSkills(convertKeyToString(from.getProfessionSkills()))
                .race(from.getRace().toString())
                .status(from.getStatus().toString())
//                .storyTellerNotes(noteMapper.convertNoteToNoteEntity(rpgCharacter.getStoryTellerNotes(), context))
                .build();
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
