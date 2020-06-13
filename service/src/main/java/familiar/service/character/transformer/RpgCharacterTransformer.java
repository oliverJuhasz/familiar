package familiar.service.character.transformer;

import familiar.entities.character.RpgCharacterEntity;
import familiar.entities.character.witcher.WitcherCharacterEntity;
import familiar.service.campaign.transformer.NameTransformer;
import familiar.service.character.domain.RpgCharacter;
import familiar.service.character.domain.witcher.WitcherCharacter;
import familiar.service.note.transformer.NoteTransformer;
import familiar.service.user.transformer.PlayerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RpgCharacterTransformer {

    @Autowired
    PlayerTransformer playerTransformer;
    @Autowired
    NameTransformer nameTransformer;
    @Autowired
    NoteTransformer noteTransformer;

    public RpgCharacterEntity transformRpgCharacterToRpgCharacterEntity(RpgCharacter from) {
        WitcherCharacterEntity to = null;
        if (from instanceof WitcherCharacter) {
            to = transformWitcherCharacterToWitcherCharacterEntity(from);
        }
        return to;
    }

    private WitcherCharacterEntity transformWitcherCharacterToWitcherCharacterEntity(RpgCharacter rpgCharacter) {
        WitcherCharacterEntity witcherCharacterEntity = new WitcherCharacterEntity();
        WitcherCharacter from = (WitcherCharacter) rpgCharacter;
        WitcherCharacterEntity to = WitcherCharacterEntity.builder()
                .age(from.getAge())
                .coreAbilities(convertKeyToString(from.getCoreAbilities()))
                .coreSkills(convertKeyToString(from.getCoreSkills()))
                .created(from.getCreated())
                .gender(from.getGender().toString())
                .id(from.getId())
                .nameEntity(nameTransformer.transformNameToNameEntity(from.getName()))
                .owner(playerTransformer.transformPlayerToPlayerEntity(from.getOwner()))
                .profession(from.getProfession().toString())
                .professionSkills(convertKeyToString(from.getProfessionSkills()))
                .race(from.getRace().toString())
                .status(from.getStatus().toString())
                .storyTellerNotes(noteTransformer.transformNoteToNoteEntity(from.getStoryTellerNotes()))
                .build();
        return to;
    }

    public List<RpgCharacterEntity> transformRpgCharacterToRpgCharacterEntity(List<RpgCharacter> from) {
        return from.stream().map(this::transformRpgCharacterToRpgCharacterEntity).collect(Collectors.toList());
    }

    private Map<String, Integer> convertKeyToString(Map<?, Integer> abilities) {
        Map<String, Integer> converted = new HashMap<>();
        for (Map.Entry<?, Integer> ability : abilities.entrySet()) {
            converted.put(ability.getKey().toString(), ability.getValue());
        }
        return converted;
    }

}
