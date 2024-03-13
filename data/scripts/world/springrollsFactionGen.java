package data.scripts.world;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.impl.campaign.ids.*;
import com.fs.starfarer.api.impl.campaign.shared.SharedData;
import org.apache.log4j.Logger;

public class springrollsFactionGen implements SectorGeneratorPlugin {

    public static void initFactionRelationships(SectorAPI sector) {
        FactionAPI springrolls_syndicate = sector.getFaction("springrollssyndicate");
        FactionAPI player = sector.getFaction(Factions.PLAYER);
        FactionAPI hegemony = sector.getFaction(Factions.HEGEMONY);
        FactionAPI tritachyon = sector.getFaction(Factions.TRITACHYON);
        FactionAPI pirates = sector.getFaction(Factions.PIRATES);
        FactionAPI independent = sector.getFaction(Factions.INDEPENDENT);
        FactionAPI church = sector.getFaction(Factions.LUDDIC_CHURCH);
        FactionAPI path = sector.getFaction(Factions.LUDDIC_PATH);
        FactionAPI kol = sector.getFaction(Factions.KOL);
        FactionAPI diktat = sector.getFaction(Factions.DIKTAT);
        FactionAPI persean = sector.getFaction(Factions.PERSEAN);
        FactionAPI guard = sector.getFaction(Factions.LIONS_GUARD);
        FactionAPI remnants = sector.getFaction(Factions.REMNANTS);
        FactionAPI derelicts = sector.getFaction(Factions.DERELICT);

        springrolls_syndicate.setRelationship(player.getId(), 0.2f);
        springrolls_syndicate.setRelationship(hegemony.getId(), -0.8f);
        springrolls_syndicate.setRelationship(tritachyon.getId(), -0.1f);
        springrolls_syndicate.setRelationship(church.getId(), -0.25f);
        springrolls_syndicate.setRelationship(persean.getId(), 0.4f);
        springrolls_syndicate.setRelationship(independent.getId(), 0.2f);
        springrolls_syndicate.setRelationship(pirates.getId(), -0.5f);
        springrolls_syndicate.setRelationship(path.getId(), -0.8f);
        springrolls_syndicate.setRelationship(kol.getId(), -0.25f);
        springrolls_syndicate.setRelationship(diktat.getId(), 0.4f);
        springrolls_syndicate.setRelationship(guard.getId(),  0.4f);
        springrolls_syndicate.setRelationship(remnants.getId(), -0.5f);
        springrolls_syndicate.setRelationship(derelicts.getId(), -0.5f);

        //modded factions
        //san_batavia.setRelationship("uaf", (float) 0.4);

    }
    private static final Logger log = Global.getLogger(springrollsFactionGen.class);
    @Override
    public void generate(SectorAPI sector) {

        // System Generation
        new data.scripts.world.systems.springrollsyndicate_flavortown().generate(sector);
//        new data.scripts.world.systems.sbr_midway().generate(sector);
//        new data.scripts.world.systems.sbr_pele().generate(sector);
//        new data.scripts.world.systems.sbr_castle().generate(sector);
//        new data.scripts.world.systems.sbr_brandaris().generate(sector);
//        //new data.scripts.world.systems.sbr_exomma().generate(sector);
//        new data.scripts.world.systems.sbr_leeghwater().generate(sector);
//        new data.scripts.world.systems.sbr_kane().generate(sector);
//        //new data.scripts.world.systems.sbr_idris().generate(sector);
//        new data.scripts.world.systems.sbr_taroa().generate(sector);
//        //new data.scripts.world.systems.sbr_laka().generate(sector);
//        //new data.scripts.world.systems.sbr_maui().generate(sector);
        SharedData.getData().getPersonBountyEventData().addParticipatingFaction("springrollssyndicate");
        initFactionRelationships(sector);


        // Constellation Tag Generation
//        LocationAPI hyper = Global.getSector().getHyperspace();
//        SectorEntityToken springrollLabel = hyper.addCustomEntity("springrollsyndicate_flavortown_label", null, "springrollsyndicate_flavortown_label", null);
//
//        springrollLabel.setFixedLocation(-30000, 23000);

    }


}