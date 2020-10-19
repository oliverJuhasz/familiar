package familiar;

import familiar.service.assist.DiceService;
import familiar.service.campaign.service.TestDataService;
import familiar.service.character.service.WitcherCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private TestDataService testDataService;

    @Autowired
    private DiceService diceService;

    @Autowired
    private WitcherCharacterService witcherCharacterService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testDataService.addTestData();
        System.out.println(diceService.evaluateDiceExpression("2d6"));
        System.out.println(witcherCharacterService.findWitcherCharacterById(1));
    }
}
