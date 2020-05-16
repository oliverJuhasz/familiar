package familiar;

import familiar.dao.CampaignRepository;
import familiar.domain.Campaign;
import familiar.domain.Session;
import familiar.domain.User;
import familiar.domain.World;
import familiar.domain.character.Gender;
import familiar.domain.character.Name;
import familiar.domain.character.witcher.profession.wProfession;
import familiar.domain.character.witcher.wCharacter;
import familiar.domain.character.witcher.wRace;
import familiar.domain.character.witcher.wSkills;
import familiar.domain.character.witcher.wStats;
import familiar.entities.CampaignEntity;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private CampaignRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        wCharacter remia = wCharacter.builder()
                .name(new Name("Remia", null, null, null))
                .gender(Gender.FEMALE)
                .race(wRace.ELF)
                .age(30)
                .profession(wProfession.CRAFTSMAN)
                .coreAbilities(Map.of(wStats.INTELLIGENCE, 9, wStats.REFLEXES, 7, wStats.DEXTERITY, 8,
                        wStats.BODY, 6, wStats.SPEED, 5, wStats.EMPATHY, 7, wStats.CRAFT, 9,
                        wStats.WILL, 6, wStats.LUCK, 3))
                .coreSkills(Map.of(wSkills.AWARENESS, 2, wSkills.BUSINESS, 2, wSkills.EDUCATION, 3, wSkills.DEDUCTION, 1,
                        wSkills.STREETWISE, 5, wSkills.DODGEESCAPE, 3, wSkills.ARCHERY, 4, wSkills.ATHLETICS, 4,
                        wSkills.CROSSBOW, 1, wSkills.PHYSIQUE, 4))
                .build();
        User player = User.builder()
                .created(LocalDateTime.now())
                .name("Ildi")
                .password("abc")
                .build();
        User master = User.builder()
                .created(LocalDateTime.now())
                .name("Oli")
                .password("cba")
                .build();
        Campaign myFirstCampaign = Campaign.builder()
                .characters(List.of(remia))
                .created(LocalDateTime.now())
                .world(World.WITCHER)
                .sessions(new ArrayList<Session>())
                .masters(List.of(master))
                .players(List.of(player))
                .name("My first campaign")
                .build();
        System.out.println(myFirstCampaign);
        CampaignEntity campaignEntity = new CampaignEntity();
        campaignEntity.setName("My first campaign");
        campaignEntity.setCreated(LocalDateTime.now());
        campaignEntity.setWorld(familiar.entities.World.WITCHER);
        repo.saveAndFlush(campaignEntity);
        System.out.println("oh hai");
        List<CampaignEntity> all = repo.findAll();

    }
}
