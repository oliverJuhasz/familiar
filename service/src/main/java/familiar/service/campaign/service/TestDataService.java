package familiar.service.campaign.service;

import familiar.dao.CampaignRepository;
import familiar.entities.CampaignEntity;
import familiar.service.campaign.domain.Campaign;
import familiar.service.campaign.domain.World;
import familiar.service.campaign.transformer.CampaignMapper;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.character.domain.Gender;
import familiar.service.character.domain.Name;
import familiar.service.character.domain.Status;
import familiar.service.character.domain.witcher.WitcherCharacter;
import familiar.service.character.domain.witcher.WitcherRace;
import familiar.service.character.domain.witcher.WitcherSkills;
import familiar.service.character.domain.witcher.WitcherStats;
import familiar.service.character.domain.witcher.profession.WitcherProfession;
import familiar.service.character.domain.witcher.profession.WitcherProfessionSkills;
import familiar.service.combat.domain.Combat;
import familiar.service.note.domain.Note;
import familiar.service.session.domain.Session;
import familiar.service.user.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestDataService {


    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    CampaignMapper campaignMapper;

    public void addTestData() {
        Player player = new Player();
        player.setName("Ildi");
        player.setCreated(LocalDateTime.now());
        player.setPassword("abcd");
        player.setUserName("Bloodpotato");

        WitcherCharacter remia = createRemia();
        WitcherCharacter thorim = createThorim();
        remia.setOwner(player);

        Campaign myFirstCampaign = Campaign.builder()
                .created(LocalDateTime.now())
                .world(World.WITCHER)
                .name("My first campaign")
                .notes(List.of(new Note(0, "First note", "note text", LocalDateTime.now()), new Note(0, "second note", "second note text", LocalDateTime.now())))
                .description("A very peculiar descriptive description")
                .players(List.of(player))
                .build();
        Session session = Session.builder()
                .campaign(myFirstCampaign)
                .characters(List.of(remia, thorim))
                .created(LocalDateTime.now())
                .summary("The first session of madness")
                .notes(List.of(new Note(0, "First note", "note text", LocalDateTime.now()), new Note(0, "second note", "second note text", LocalDateTime.now())))
                .combats(new ArrayList<>())
                .build();

        Combat combat = Combat.builder()
                .description("A very epic battle")
                .session(session)
                .notes(List.of(new Note(0, "Combat note", "Combat note text", LocalDateTime.now())))
                .characters(List.of(remia, thorim))
                .build();
        session.setCombats(List.of(combat));
        myFirstCampaign.setSessions(List.of(session));
        CampaignEntity campaignEntity = campaignMapper.campaignToCampaignEntity(myFirstCampaign, new CycleAvoidingMappingContext());
        campaignRepository.saveAndFlush(campaignEntity);
        System.out.println(campaignRepository.findById(1L));
        System.out.println("heyhey");

    }

    private WitcherCharacter createRemia() {
        Map<WitcherSkills, Integer> remiaCoreSkills = new HashMap<>();
        remiaCoreSkills.put(WitcherSkills.AWARENESS, 2);
        remiaCoreSkills.put(WitcherSkills.BUSINESS, 2);
        remiaCoreSkills.put(WitcherSkills.EDUCATION, 3);
        remiaCoreSkills.put(WitcherSkills.DEDUCTION, 1);
        remiaCoreSkills.put(WitcherSkills.STREETWISE, 5);
        remiaCoreSkills.put(WitcherSkills.DODGEESCAPE, 3);
        remiaCoreSkills.put(WitcherSkills.ARCHERY, 4);
        remiaCoreSkills.put(WitcherSkills.ATHLETICS, 4);
        remiaCoreSkills.put(WitcherSkills.CROSSBOW, 1);
        remiaCoreSkills.put(WitcherSkills.PHYSIQUE, 4);
        remiaCoreSkills.put(WitcherSkills.ENDURANCE, 4);
        remiaCoreSkills.put(WitcherSkills.DECEIT, 2);
        remiaCoreSkills.put(WitcherSkills.FINEARTS, 4);
        remiaCoreSkills.put(WitcherSkills.HUMANPERCEPTION, 1);
        remiaCoreSkills.put(WitcherSkills.PERSUASION, 4);
        remiaCoreSkills.put(WitcherSkills.PERFORMANCE, 2);
        remiaCoreSkills.put(WitcherSkills.ALCHEMY, 6);
        remiaCoreSkills.put(WitcherSkills.CRAFTING, 6);
        remiaCoreSkills.put(WitcherSkills.FORGERY, 2);
        remiaCoreSkills.put(WitcherSkills.COURAGE, 1);

        WitcherCharacter remia = WitcherCharacter.builder()
                .name(Name.builder().firstName("Remia").build())
                .gender(Gender.FEMALE)
                .race(WitcherRace.ELF)
                .age(30)
                .profession(WitcherProfession.CRAFTSMAN)
                .coreAbilities(Map.of(WitcherStats.INTELLIGENCE, 9, WitcherStats.REFLEXES, 7, WitcherStats.DEXTERITY, 8,
                        WitcherStats.BODY, 6, WitcherStats.SPEED, 5, WitcherStats.EMPATHY, 7, WitcherStats.CRAFT, 9,
                        WitcherStats.WILL, 6, WitcherStats.LUCK, 3))
                .coreSkills(remiaCoreSkills)
                .professionSkills(Map.of(WitcherProfessionSkills.HEALINGHANDS, 1))
                .status(Status.ALIVE)
                .storyTellerNotes(new ArrayList<>())
                .created(LocalDateTime.now())
                .build();
        return remia;
    }

    private WitcherCharacter createThorim() {
        Map<WitcherSkills, Integer> thorimCoreSkills = new HashMap<>();
        thorimCoreSkills.put(WitcherSkills.AWARENESS, 6);
        thorimCoreSkills.put(WitcherSkills.BUSINESS, 1);
        thorimCoreSkills.put(WitcherSkills.MONSTERLORE, 2);
        thorimCoreSkills.put(WitcherSkills.STREETWISE, 6);
        thorimCoreSkills.put(WitcherSkills.SLEIGHTOFHAND, 1);
        thorimCoreSkills.put(WitcherSkills.STEALTH, 6);
        thorimCoreSkills.put(WitcherSkills.PHYSIQUE, 2);
        thorimCoreSkills.put(WitcherSkills.ENDURANCE, 2);
        thorimCoreSkills.put(WitcherSkills.DECEIT, 6);
        thorimCoreSkills.put(WitcherSkills.FORGERY, 3);
        thorimCoreSkills.put(WitcherSkills.PICKLOCK, 2);
        thorimCoreSkills.put(WitcherSkills.COURAGE, 6);
        thorimCoreSkills.put(WitcherSkills.INTIMIDATION, 6);

        WitcherCharacter thorim = WitcherCharacter.builder()
                .name(Name.builder().firstName("Thorim").build())
                .gender(Gender.MALE)
                .race(WitcherRace.DWARF)
                .age(331)
                .profession(WitcherProfession.CRIMINAL)
                .coreAbilities(Map.of(WitcherStats.INTELLIGENCE, 8, WitcherStats.REFLEXES, 8, WitcherStats.DEXTERITY, 5,
                        WitcherStats.BODY, 10, WitcherStats.SPEED, 5, WitcherStats.EMPATHY, 5, WitcherStats.CRAFT, 2,
                        WitcherStats.WILL, 8, WitcherStats.LUCK, 11))
                .coreSkills(thorimCoreSkills)
                .professionSkills(Map.of(WitcherProfessionSkills.PRACTICEDPARANOIA, 1))
                .status(Status.ALIVE)
                .storyTellerNotes(new ArrayList<>())
                .created(LocalDateTime.now())
                .build();
        return thorim;
    }
}
