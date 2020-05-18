package familiar.service.campaign.service;

import familiar.dao.CampaignRepository;
import familiar.service.campaign.domain.Campaign;
import familiar.service.campaign.domain.World;
import familiar.service.campaign.transformer.CampaignTransformer;
import familiar.service.character.domain.Gender;
import familiar.service.character.domain.Name;
import familiar.service.character.domain.witcher.WitcherCharacter;
import familiar.service.character.domain.witcher.WitcherRace;
import familiar.service.character.domain.witcher.WitcherSkills;
import familiar.service.character.domain.witcher.WitcherStats;
import familiar.service.character.domain.witcher.profession.WitcherProfession;
import familiar.service.session.domain.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestDataService {

    @Autowired
    private CampaignTransformer campaignTransformer;
    @Autowired
    private CampaignRepository campaignRepository;

    public void addTestData() {
        Campaign myFirstCampaign = Campaign.builder()
                .created(LocalDateTime.now())
                .world(World.WITCHER)
                .name("My first campaign")
                .build();
        Session session = Session.builder()
                .campaign(myFirstCampaign)
                .characters(List.of(createRemia()))
                .created(LocalDateTime.now())
                .summary("The first session of madness")
                .build();
        myFirstCampaign.setSessions(List.of(session));
        System.out.println(myFirstCampaign);

        campaignRepository.saveAndFlush(campaignTransformer.transformCampaignToCampaignEntity(myFirstCampaign));


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
                .coreSkills(Map.of(WitcherSkills.AWARENESS, 2, WitcherSkills.BUSINESS, 2, WitcherSkills.EDUCATION, 3, WitcherSkills.DEDUCTION, 1,
                        WitcherSkills.STREETWISE, 5, WitcherSkills.DODGEESCAPE, 3, WitcherSkills.ARCHERY, 4, WitcherSkills.ATHLETICS, 4,
                        WitcherSkills.CROSSBOW, 1, WitcherSkills.PHYSIQUE, 4))
                .build();
        return remia;
    }
}
