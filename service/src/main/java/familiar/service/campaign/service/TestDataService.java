package familiar.service.campaign.service;

import familiar.dao.CampaignRepository;
import familiar.entities.CampaignEntity;
import familiar.service.campaign.domain.Campaign;
import familiar.service.campaign.domain.World;
import familiar.service.campaign.transformer.CampaignMapper;
import familiar.service.campaign.transformer.CycleAvoidingMappingContext;
import familiar.service.character.domain.Gender;
import familiar.service.character.domain.Name;
import familiar.service.character.domain.RpgCharacter;
import familiar.service.character.domain.Status;
import familiar.service.character.domain.witcher.WitcherCharacter;
import familiar.service.character.domain.witcher.WitcherRace;
import familiar.service.character.domain.witcher.WitcherSkills;
import familiar.service.character.domain.witcher.WitcherStats;
import familiar.service.character.domain.witcher.profession.WitcherProfession;
import familiar.service.character.domain.witcher.profession.WitcherProfessionSkills;
import familiar.service.character.service.WitcherCharacterService;
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

    @Autowired
    WitcherCharacterService witcherCharacterService;

    public void addTestData() {
        Player player = new Player();
        player.setName("Ildi");
        player.setCreated(LocalDateTime.now());
        player.setPassword("abcd");
        player.setUserName("Bloodpotato");

        WitcherCharacter remia = createRemia();
        WitcherCharacter thorim = createThorim();
        WitcherCharacter berrik = createBerrik();
        WitcherCharacter durandal = createDurandal();
        WitcherCharacter priscilla = createPriscilla();
        remia.setOwner(player);
        thorim.setOwner(player);
        berrik.setOwner(player);
        durandal.setOwner(player);
        priscilla.setOwner(player);

        List<RpgCharacter> characters = List.of(remia, berrik, thorim, durandal, priscilla);

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
                .characters(characters)
                .created(LocalDateTime.now())
                .summary("The first session of madness")
                .notes(List.of(new Note(0, "First note", "note text", LocalDateTime.now()), new Note(0, "second note", "second note text", LocalDateTime.now())))
                .combats(new ArrayList<>())
                .build();

        Combat combat = Combat.builder()
                .description("A very epic battle")
                .session(session)
                .notes(List.of(new Note(0, "Combat note", "Combat note text", LocalDateTime.now())))
                .characters(characters)
                .build();
        session.setCombats(List.of(combat));
        myFirstCampaign.setSessions(List.of(session));
        CampaignEntity campaignEntity = campaignMapper.campaignToCampaignEntity(myFirstCampaign, new CycleAvoidingMappingContext());
        campaignRepository.saveAndFlush(campaignEntity);
        WitcherCharacter witcherCharacterById = witcherCharacterService.findWitcherCharacterById(1);
        witcherCharacterById.getName().setFirstName("ehehe");
        witcherCharacterService.saveWitcherCharacter(witcherCharacterById);

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

        return WitcherCharacter.builder()
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

        return WitcherCharacter.builder()
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
    }

    private WitcherCharacter createBerrik() {
        Map<WitcherSkills, Integer> berrikCoreSkills = new HashMap<>();
        berrikCoreSkills.put(WitcherSkills.AWARENESS, 2);
        berrikCoreSkills.put(WitcherSkills.DEDUCTION, 1);
        berrikCoreSkills.put(WitcherSkills.LANGUAGECOMMON, 8);
        berrikCoreSkills.put(WitcherSkills.TACTICS, 3);
        berrikCoreSkills.put(WitcherSkills.WILDERNESSSURVIVAL, 4);
        berrikCoreSkills.put(WitcherSkills.CROSSBOW, 3);
        berrikCoreSkills.put(WitcherSkills.PHYSIQUE, 5);
        berrikCoreSkills.put(WitcherSkills.ENDURANCE, 4);
        berrikCoreSkills.put(WitcherSkills.FIRSTAID, 2);
        berrikCoreSkills.put(WitcherSkills.COURAGE, 4);
        berrikCoreSkills.put(WitcherSkills.INTIMIDATION, 3);
        berrikCoreSkills.put(WitcherSkills.BRAWLING, 4);
        berrikCoreSkills.put(WitcherSkills.DODGEESCAPE, 5);
        berrikCoreSkills.put(WitcherSkills.MELEE, 3);
        berrikCoreSkills.put(WitcherSkills.RIDING, 4);
        berrikCoreSkills.put(WitcherSkills.SWORDSMANSHIP, 6);
        berrikCoreSkills.put(WitcherSkills.LEADERSHIP, 3);
        berrikCoreSkills.put(WitcherSkills.RESISTCOERCION, 1);

        return WitcherCharacter.builder()
                .name(Name.builder().firstName("Berrik").build())
                .gender(Gender.MALE)
                .race(WitcherRace.HUMAN)
                .age(30)
                .profession(WitcherProfession.MANATARMS)
                .coreAbilities(Map.of(WitcherStats.INTELLIGENCE, 7,
                        WitcherStats.REFLEXES, 10, WitcherStats.DEXTERITY, 9,
                        WitcherStats.BODY, 10, WitcherStats.SPEED, 8, WitcherStats.EMPATHY, 5, WitcherStats.CRAFT, 2,
                        WitcherStats.WILL, 7, WitcherStats.LUCK, 2))
                .coreSkills(berrikCoreSkills)
                .professionSkills(Map.of(WitcherProfessionSkills.TOUGHASNAILS, 3))
                .status(Status.ALIVE)
                .storyTellerNotes(new ArrayList<>())
                .created(LocalDateTime.now())
                .build();
    }

    private WitcherCharacter createDurandal() {
        Map<WitcherSkills, Integer> durandalCoreSkills = new HashMap<>();
        durandalCoreSkills.put(WitcherSkills.AWARENESS, 3);
        durandalCoreSkills.put(WitcherSkills.DEDUCTION, 3);
        durandalCoreSkills.put(WitcherSkills.WILDERNESSSURVIVAL, 4);
        durandalCoreSkills.put(WitcherSkills.ATHLETICS, 4);
        durandalCoreSkills.put(WitcherSkills.STEALTH, 1);
        durandalCoreSkills.put(WitcherSkills.PHYSIQUE, 3);
        durandalCoreSkills.put(WitcherSkills.ENDURANCE, 3);
        durandalCoreSkills.put(WitcherSkills.DODGEESCAPE, 3);
        durandalCoreSkills.put(WitcherSkills.RIDING, 1);
        durandalCoreSkills.put(WitcherSkills.SWORDSMANSHIP, 6);
        durandalCoreSkills.put(WitcherSkills.ALCHEMY, 4);
        durandalCoreSkills.put(WitcherSkills.FIRSTAID, 2);
        durandalCoreSkills.put(WitcherSkills.INTIMIDATION, 3);
        durandalCoreSkills.put(WitcherSkills.SPELLCASTING, 4);
        durandalCoreSkills.put(WitcherSkills.RESISTMAGIC, 4);

        return WitcherCharacter.builder()
                .name(Name.builder().firstName("Berrik").build())
                .gender(Gender.MALE)
                .race(WitcherRace.WITCHER)
                .age(70)
                .profession(WitcherProfession.WITCHER)
                .coreAbilities(Map.of(WitcherStats.INTELLIGENCE, 10,
                        WitcherStats.REFLEXES, 9, WitcherStats.DEXTERITY, 7,
                        WitcherStats.BODY, 8, WitcherStats.SPEED, 8, WitcherStats.EMPATHY, 1, WitcherStats.CRAFT, 6,
                        WitcherStats.WILL, 10, WitcherStats.LUCK, 3))
                .coreSkills(durandalCoreSkills)
                .professionSkills(Map.of(WitcherProfessionSkills.WITCHERTRAINING, 5))
                .status(Status.ALIVE)
                .storyTellerNotes(new ArrayList<>())
                .created(LocalDateTime.now())
                .build();
    }

    private WitcherCharacter createPriscilla() {
        Map<WitcherSkills, Integer> priscillaCoreSkills = new HashMap<>();
        priscillaCoreSkills.put(WitcherSkills.BUSINESS, 3);
        priscillaCoreSkills.put(WitcherSkills.DEDUCTION, 4);
        priscillaCoreSkills.put(WitcherSkills.SOCIALETIQUETTE, 3);
        priscillaCoreSkills.put(WitcherSkills.WILDERNESSSURVIVAL, 4);
        priscillaCoreSkills.put(WitcherSkills.SMALLBLADES, 5);
        priscillaCoreSkills.put(WitcherSkills.CHARISMA, 6);
        priscillaCoreSkills.put(WitcherSkills.DECEIT, 6);
        priscillaCoreSkills.put(WitcherSkills.HUMANPERCEPTION, 6);
        priscillaCoreSkills.put(WitcherSkills.PERSUASION, 6);
        priscillaCoreSkills.put(WitcherSkills.ALCHEMY, 4);
        priscillaCoreSkills.put(WitcherSkills.FIRSTAID, 6);
        priscillaCoreSkills.put(WitcherSkills.COURAGE, 4);
        priscillaCoreSkills.put(WitcherSkills.RESISTCOERCION, 3);

        return WitcherCharacter.builder()
                .name(Name.builder().firstName("Priscilla").build())
                .gender(Gender.FEMALE)
                .race(WitcherRace.WITCHER)
                .age(147)
                .profession(WitcherProfession.DOCTOR)
                .coreAbilities(Map.of(WitcherStats.INTELLIGENCE, 9,
                        WitcherStats.REFLEXES, 9, WitcherStats.DEXTERITY, 8,
                        WitcherStats.BODY, 5, WitcherStats.SPEED, 8, WitcherStats.EMPATHY, 2, WitcherStats.CRAFT, 7,
                        WitcherStats.WILL, 6, WitcherStats.LUCK, 6))
                .coreSkills(priscillaCoreSkills)
                .professionSkills(Map.of(WitcherProfessionSkills.HEALINGHANDS, 1))
                .status(Status.ALIVE)
                .storyTellerNotes(new ArrayList<>())
                .created(LocalDateTime.now())
                .build();
    }
}
