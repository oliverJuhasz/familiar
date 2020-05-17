package familiar;

import familiar.dao.CampaignRepository;
import familiar.dao.UserRepository;
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
import familiar.entities.NoteEntity;
import familiar.entities.PlayerEntity;
import familiar.entities.SessionEntity;
import familiar.entities.character.RPGCharacterEntity;
import familiar.entities.character.Status;
import familiar.entities.character.witcher.wCharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private CampaignRepository repo;

    @Autowired
    private UserRepository userRepo;

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

        NoteEntity note = new NoteEntity();
        note.setCreated(LocalDateTime.now());
        note.setText("This is my first note text!");
        note.setTitle("This is my title");

        NoteEntity note2 = new NoteEntity();
        note2.setCreated(LocalDateTime.now());
        note2.setText("This is my second note text!");
        note2.setTitle("This is my title");

        campaignEntity.setNotes(List.of(note));

        RPGCharacterEntity rpgCharacterEntity = new wCharacterEntity();
        rpgCharacterEntity.setAge(45);
        rpgCharacterEntity.setCampaigns(List.of(campaignEntity));
        rpgCharacterEntity.setCreated(LocalDateTime.now());
        rpgCharacterEntity.setGender(familiar.entities.character.Gender.FEMALE);
        rpgCharacterEntity.setStatus(Status.ALIVE);


        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity.setCampaign(campaignEntity);
        sessionEntity.setCreated(LocalDateTime.now());
        sessionEntity.setSummary("This was an intense session");
        sessionEntity.setCharacters(List.of(rpgCharacterEntity));
        sessionEntity.setNotes(List.of(note2));

        campaignEntity.setSessions(List.of(sessionEntity));

        repo.saveAndFlush(campaignEntity);
        System.out.println("oh hai");
        List<CampaignEntity> all = repo.findAll();

        PlayerEntity user = new PlayerEntity();
        user.setName("Oliver");
        user.setPassword("123");
        user.setCreated(LocalDateTime.now());
        user.setCharacters(List.of(rpgCharacterEntity));
        user.setCampaign(List.of(campaignEntity));
        user.setUserName("username");

        userRepo.save(user);
    }
}
