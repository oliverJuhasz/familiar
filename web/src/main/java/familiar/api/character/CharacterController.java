package familiar.api.character;

import familiar.service.character.domain.witcher.WitcherCharacter;
import familiar.service.character.service.WitcherCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CharacterController {

    @Autowired
    WitcherCharacterService witcherCharacterService;

    @GetMapping("/characters")
    public WitcherCharacter getCharacters() {
        return witcherCharacterService.findWitcherCharacterById(2);
    }
}
