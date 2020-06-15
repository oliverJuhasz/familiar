package familiar.service.character.service;

import familiar.dao.RpgCharacterRepository;
import familiar.entities.character.RpgCharacterEntity;
import familiar.entities.character.witcher.WitcherCharacterEntity;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.character.domain.RpgCharacter;
import familiar.service.character.domain.witcher.WitcherCharacter;
import familiar.service.character.transformer.RpgCharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class WitcherCharacterService {

    @Autowired
    RpgCharacterRepository rpgCharacterRepository;

    @Autowired
    RpgCharacterMapper rpgCharacterMapper;

    public WitcherCharacter findWitcherCharacterById(long id) {
        Optional<RpgCharacterEntity> optionalRpgCharacterEntity = rpgCharacterRepository.findById(id);
        if (optionalRpgCharacterEntity.isEmpty()) {
            throw new IllegalArgumentException("Item not present in database");
        }
        RpgCharacterEntity rpgCharacterEntity = optionalRpgCharacterEntity.get();
        if (!(rpgCharacterEntity instanceof WitcherCharacterEntity)) {
            throw new IllegalArgumentException("Character is not a Witcher character!");
        }
        return (WitcherCharacter) convertRpgCharacterEntityToRpgCharacter(rpgCharacterEntity);
    }

    public void saveWitcherCharacter(WitcherCharacter witcherCharacter) {
        rpgCharacterRepository.saveAndFlush(convertRpgCharacterToRpgCharacterEntity(witcherCharacter));
    }

    private RpgCharacter convertRpgCharacterEntityToRpgCharacter(RpgCharacterEntity rpgCharacterEntity) {
        return rpgCharacterMapper.rpgCharacterEntityToRgpCharacter(rpgCharacterEntity, new CycleAvoidingMappingContext());
    }

    private RpgCharacterEntity convertRpgCharacterToRpgCharacterEntity(RpgCharacter rpgCharacter) {
        return rpgCharacterMapper.rpgCharacterToRgpCharacterEntity(rpgCharacter, new CycleAvoidingMappingContext());
    }

}
