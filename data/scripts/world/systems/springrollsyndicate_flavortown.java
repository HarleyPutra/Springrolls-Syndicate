package data.scripts.world.systems;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.*;
import com.fs.starfarer.api.impl.campaign.procgen.NebulaEditor;
import com.fs.starfarer.api.impl.campaign.procgen.StarSystemGenerator.StarSystemType;
import com.fs.starfarer.api.impl.campaign.terrain.HyperspaceTerrainPlugin;
import com.fs.starfarer.api.util.Misc;
import data.scripts.world.springrollsyndicate_MarketPlaceAdder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

//import static data.scripts.plugins.sbr_addWhiskey.addWhiskey;
//import static data.scripts.plugins.sbr_addWhiskey.addBrewery;

public class springrollsyndicate_flavortown {


    public void generate(SectorAPI sector) {

        boolean presetConditions = true;

        StarSystemAPI system = sector.createStarSystem("Flavortown");
        system.getLocation().set(-28344, 17605);
        LocationAPI hyper = Global.getSector().getHyperspace();
        system.setType(StarSystemType.BINARY_FAR); //added by WMGreywind
        system.setBackgroundTextureFilename("graphics/backgrounds/SpaceBackground.jpg");

        // STAR //
        PlanetAPI flavortown = system.initStar(
                "flavortown",
                StarTypes.BLUE_GIANT, // id in planets.json
                1000f, // size of star
                500, // extent of corona outside star
                8f, // solar wind burn level
                0.5f, // flare probability
                2.0f); // CR loss multiplier, good values are in the range of 1-5

        // PLANETS AND ENTITIES //

        // Aromaria
        PlanetAPI aromaria = system.addPlanet("aromaria", flavortown, "Aromaria", "terran", 90, 100, 2500, 90); // WMGreywind planet object cheat sheet (0 (starting angle around orbit), 60 (planet size), 1500 (planet distance from orbiting object), 88 (days for a complete orbit to be made))
        MarketAPI aromaria_market = springrollsyndicate_MarketPlaceAdder.addMarketplace("springrollssyndicate", aromaria, null,
                "Aromaria",
                5,
                new ArrayList<String>(
                        Arrays.asList(Conditions.POPULATION_5,
                                Conditions.HABITABLE,
                                Conditions.MILD_CLIMATE,
                                Conditions.WATER_SURFACE,
                                Conditions.ORGANICS_TRACE,
                                Conditions.FREE_PORT
                        )
                ),
                new ArrayList<String>(
                        Arrays.asList(
                                Submarkets.GENERIC_MILITARY,
                                Submarkets.SUBMARKET_OPEN,
                                Submarkets.SUBMARKET_STORAGE,
                                Submarkets.SUBMARKET_BLACK
                        )),
                new ArrayList<String>(
                        Arrays.asList(
                                Industries.POPULATION,
                                Industries.MEGAPORT,
                                Industries.AQUACULTURE,
                                Industries.HEAVYBATTERIES,
                                Industries.STARFORTRESS_MID,
                                Industries.LIGHTINDUSTRY,
                                Industries.ORBITALWORKS
                        )
                ), true, false);
        //aromaria.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "aromaria"));
        //aromaria.applySpecChanges();

        // Asteroid Belt
        system.addAsteroidBelt(flavortown, 200, 4250, 100, 100, 200, Terrain.ASTEROID_BELT, "Meatballs");
        system.addRingBand(flavortown, "misc", "rings_dust0", 256f, 0, Color.white, 256f, 4250, 220f, null, null);

        // Extra Goodie 1
//        SectorEntityToken europa_weaponscache = system.addCustomEntity("europa_weapons_cache",
//                "Weapons Cache",
//                "weapons_cache_high",
//                "neutral");
//        europa_weaponscache.setCircularOrbitPointingDown(europa, (float) Math.random() * 360f, 4250, 220);
//        europa_weaponscache.setSensorProfile(1200f);
//        europa_weaponscache.setDiscoverable(true);

        // Latona
//        PlanetAPI latona = system.addPlanet("latona", europa, "Latona", "tundra", 270, 140, 5500, 225);
//        latona.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "latona"));
//        latona.applySpecChanges();

        // Gourmettopolis
        PlanetAPI gourmettopolis = system.addPlanet("gourmettopolis", flavortown, "Gourmettopolis", "broth", 90, 180, 7000, 365);
        gourmettopolis.getSpec().setGlowTexture(Global.getSettings().getSpriteName("glow", "gourmettopolis"));
        gourmettopolis.setCustomDescriptionId("gourmettopolis");
        gourmettopolis.setInteractionImage("illustrations", "gourmettopolis_background");
        gourmettopolis.applySpecChanges();
//        gourmettopolis.setCustomDescriptionId("sbr_planet_batavia_batavia");
        MarketAPI gourmettopolis_market = springrollsyndicate_MarketPlaceAdder.addMarketplace("springrollssyndicate", gourmettopolis, null,
                "Gourmettopolis",
                7,
                new ArrayList<String>(
                        Arrays.asList(Conditions.POPULATION_7,
                                Conditions.HABITABLE,
                                Conditions.MILD_CLIMATE,
                                Conditions.ORE_RICH,
                                Conditions.WATER_SURFACE,
                                Conditions.REGIONAL_CAPITAL,
                                Conditions.ORGANICS_TRACE,
                                Conditions.FREE_PORT
                        )
                ),
                new ArrayList<String>(
                        Arrays.asList(
                                Submarkets.GENERIC_MILITARY,
                                Submarkets.SUBMARKET_OPEN,
                                Submarkets.SUBMARKET_STORAGE,
                                Submarkets.SUBMARKET_BLACK,
                                Submarkets.LOCAL_RESOURCES
                        )),
                new ArrayList<String>(
                        Arrays.asList(
                                Industries.POPULATION,
                                Industries.MEGAPORT,
                                Industries.MILITARYBASE,
                                Industries.GROUNDDEFENSES,
                                Industries.ORBITALWORKS,
                                Industries.AQUACULTURE,
                                Industries.HEAVYBATTERIES,
                                Industries.STARFORTRESS_HIGH,
                                Industries.HIGHCOMMAND
                        )
                ), true, false);

                /*if (Global.getSettings().getModManager().isModEnabled("alcoholism")){
                        addBrewery(batavia_market);
                }*/

        // New Amsterdam Station
//        SectorEntityToken europa_abandonedstation = system.addCustomEntity("sbr_europa_abandonedstation", "Abandoned Terraforming Platform", "station_side06", "neutral");
//        europa_abandonedstation.setCircularOrbitPointingDown(system.getEntityById("batavia"), 45, 400, 30);
//        europa_abandonedstation.setInteractionImage("illustrations", "abandoned_station2");
//        Misc.setAbandonedStationMarket("corvus_abandoned_station_market", europa_abandonedstation);

        // Varendaal, Moon of Batavia
//        PlanetAPI varendaal = system.addPlanet("varendaal", batavia, "Varendaal", "frozen", 0, 40, 950, 45);
//        varendaal.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "varendaal"));
//        varendaal.getSpec().setGlowTexture(Global.getSettings().getSpriteName("glow", "glow2"));
//        varendaal.applySpecChanges();
//        varendaal.setCustomDescriptionId("sbr_planet_varendaal_batavia");

//        MarketAPI varendaal_market = springrollsyndicate_MarketPlaceAdder.addMarketplace("batavia", varendaal, null,
//                "Varendaal",
//                5,
//                new ArrayList<String>(
//                        Arrays.asList(Conditions.POPULATION_5,
//                                Conditions.VERY_COLD,
//                                Conditions.THIN_ATMOSPHERE,
//                                Conditions.LOW_GRAVITY,
//                                Conditions.ORE_RICH,
//                                Conditions.RARE_ORE_RICH,
//                                Conditions.FREE_PORT
//                        )
//                ),
//                new ArrayList<String>(
//                        Arrays.asList(
//                                Submarkets.SUBMARKET_OPEN,
//                                Submarkets.SUBMARKET_STORAGE,
//                                Submarkets.SUBMARKET_BLACK
//                        )),
//                new ArrayList<String>(
//                        Arrays.asList(
//                                Industries.POPULATION,
//                                Industries.MEGAPORT,
//                                "sbr_batavia_hq",
//                                Industries.MINING,
//                                Industries.REFINING,
//                                Industries.ORBITALWORKS,
//                                Industries.STARFORTRESS_MID,
//                                Industries.HEAVYBATTERIES,
//                                Industries.HIGHCOMMAND
//
//                        )
//                ), true, false);
//
//        varendaal_market.getIndustry(Industries.ORBITALWORKS).setSpecialItem(new SpecialItemData(Items.PRISTINE_NANOFORGE, null));
//        varendaal_market.getIndustry(Industries.HEAVYBATTERIES).setAICoreId(Commodities.BETA_CORE);

        // Gourmettopolis Jump Point
        JumpPointAPI gourmettopolis_jump_point = Global.getFactory().createJumpPoint("flavortown_jump1", "Flavortown Jump-Point");
        gourmettopolis_jump_point.setCircularOrbit(system.getEntityById("flavortown"), 245, 4500, 200);
        gourmettopolis_jump_point.setStandardWormholeToHyperspaceVisual();
        system.addEntity(gourmettopolis_jump_point);

        // Themis
        //PlanetAPI themis = system.addPlanet("themis", europa, "Themis", "ice_giant", 270, 420, 9500, 500); // edited by WMGreywind to change planet size

        // Cove
//        PlanetAPI cove = system.addPlanet("cove", themis, "Cove", "rocky_metallic", 180, 50, 750, 30); //edited by WMGreywind rocky_metallic not rocky-metallic also fixed planet overlap also changed planet size
//        cove.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "cove"));
//        cove.applySpecChanges();

        // Shelter
//        PlanetAPI shelter = system.addPlanet("shelter", themis, "Shelter", "cryovolcanic", 0, 35, 900, 30); // edited by WMGreywind to change planet size
//        shelter.getMarket().getCondition(Conditions.LOW_GRAVITY);
//        shelter.getMarket().getCondition(Conditions.COLD);
//        shelter.getMarket().getCondition(Conditions.ORE_MODERATE);
//        shelter.getMarket().getCondition(Conditions.VOLATILES_DIFFUSE);
//        shelter.getMarket().getCondition(Conditions.RARE_ORE_SPARSE);

        // SECOND STAR
//        PlanetAPI sterrennacht = system.addPlanet("sterrennacht", europa, "Sterrennacht", StarTypes.WHITE_DWARF, 0, 400, 15000, 1600);
//        system.setSecondary(sterrennacht);
//        system.addCorona(sterrennacht, 200, 2f, 0.1f, 2f);

        // Sterrennacht Jump Point
//        JumpPointAPI sterrenacht_jump_point = Global.getFactory().createJumpPoint("europa_jump3", "Sterrennacht Jump-Point");
//        sterrenacht_jump_point.setCircularOrbit(system.getEntityById("sterrennacht"), 245, 1500, 200);
//        sterrenacht_jump_point.setStandardWormholeToHyperspaceVisual();
//        system.addEntity(sterrenacht_jump_point);
//
//        system.addAsteroidBelt(sterrennacht, 50, 2000, 100, 100, 200, Terrain.ASTEROID_BELT, "Asteroid Belt");
//        system.addRingBand(sterrennacht, "misc", "rings_dust0", 256f, 0, Color.white, 256f, 2000, 220f, null, null);

        // Kuipers
//        PlanetAPI kuipers = system.addPlanet("kuipers", sterrennacht, "Kuipers", "island", 0, 160, 3500, 65);
//        kuipers.getSpec().setGlowTexture(Global.getSettings().getSpriteName("glow", "batavia"));
//        kuipers.applySpecChanges();
//        kuipers.setCustomDescriptionId("sbr_planet_kuipers_batavia");
//
//        MarketAPI kuipers_market = springrollsyndicate_MarketPlaceAdder.addMarketplace("batavia", kuipers, null,
//                "Kuipers",
//                4,
//                new ArrayList<String>(
//                        Arrays.asList(Conditions.POPULATION_5,
//                                Conditions.HABITABLE,
//                                Conditions.WATER_SURFACE,
//                                Conditions.ORE_MODERATE,
//                                Conditions.ORGANICS_PLENTIFUL,
//                                Conditions.FREE_PORT
//                        )
//                ),
//                new ArrayList<String>(
//                        Arrays.asList(
//                                Submarkets.SUBMARKET_OPEN,
//                                Submarkets.SUBMARKET_STORAGE,
//                                Submarkets.SUBMARKET_BLACK
//                        )),
//                new ArrayList<String>(
//                        Arrays.asList(
//                                Industries.POPULATION,
//                                Industries.MEGAPORT,
//                                Industries.AQUACULTURE,
//                                Industries.MINING
//                        )
//                ), true, false);

        // Tethys
//        PlanetAPI tethys = system.addPlanet("tethys", sterrennacht, "Tethys", "ice_giant", 90, 400, 6000, 700); //edited by WMGreywind fixed planet size
//        tethys.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "tethys"));
//        tethys.applySpecChanges();

        // Shrine
        //PlanetAPI shrine = system.addPlanet("shrine", tethys, "Shrine", "frozen", 0, 50, 800, 30); //edited to increase distance from tethys
        //shrine.getMarket().addCondition(Conditions.RUINS_VAST); // don't need to add market half if planet will not be inhabited at the start
        //shrine.getMarket().addCondition(Conditions.VERY_COLD);
        //shrine.getMarket().addCondition(Conditions.POOR_LIGHT);
       // shrine.getMarket().addCondition(Conditions.LOW_GRAVITY);
        //shrine.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "shrine"));
        //shrine.applySpecChanges();

        // Tethys Asteroid Belt
        // belt test added by WMGreywind
        //system.addAsteroidBelt(tethys, 50, 1200, 100, 100, 200, Terrain.ASTEROID_BELT, "Asteroid Belt");
        //system.addRingBand(tethys, "misc", "rings_dust0", 256f, 0, Color.white, 256f, 1200, 220f, null, null);
        //system.addRingBand(tethys, "misc", "rings_asteroids0", 256f, 0, Color.white, 256f, 1000, 226f, null, null);
        // system.addAsteroidBelt(tethys, 750, 6000, 500, 700, 300, Terrain.ASTEROID_BELT, "Asteroid Belt");
        // system.addRingBand(tethys, "misc", "rings_asteroids0", 256f, 4, Color.white,256f,6000,295f,Terrain.ASTEROID_BELT,"Asteroid Belt1");

        // Extra Goodie 2
//        SectorEntityToken europa_miningstation = system.addCustomEntity("europa_mining_station",
//                "Mining Station",
//                "station_mining",
//                "neutral");
//        europa_miningstation.setCircularOrbitPointingDown(tethys, 270, 1200, 220);
//        europa_miningstation.setSensorProfile(1200f);
//        europa_miningstation.setDiscoverable(true);

        //Misc stuff
        SectorEntityToken flavortownSensorArray = system.addCustomEntity("springsyn_flavortown_sensor", "Domain Sensor Array", "sensor_array", "springrollssyndicate");
        flavortownSensorArray.setCircularOrbitPointingDown(flavortown, 240.0F, 13000.0F, 200.0F);
        SectorEntityToken flavortownNavArray = system.addCustomEntity("springsyn_flavortown_nav", "Domain Navigation Array", "nav_buoy", "springrollssyndicate");
        flavortownNavArray.setCircularOrbitPointingDown(flavortown, 240.0F, 8500.0F, 200.0F);
        SectorEntityToken flavortownRelay = system.addCustomEntity("springsyn_flavortown_relay", "Domain Communication Array", "comm_relay", "springrollssyndicate");
        flavortownRelay.setCircularOrbitPointingDown(gourmettopolis, 140.0F, 1100.0F, 200.0F);

        system.autogenerateHyperspaceJumpPoints(true, true);


        // CONDITIONS //
        if (presetConditions) {

            // Aromaria
//            MarketAPI aromaria_market = Global.getFactory().createMarket("aromaria_market", aromaria.getName(), 0);
//            aromaria_market.setPlanetConditionMarketOnly(true);
//            aromaria_market.addCondition(Conditions.LOW_GRAVITY);
//            aromaria_market.addCondition(Conditions.HOT);
//            aromaria_market.addCondition(Conditions.NO_ATMOSPHERE);
//            aromaria_market.addCondition(Conditions.RUINS_VAST);
//            aromaria_market.setPrimaryEntity(aromaria);
//            aromaria.setMarket(aromaria_market);

            // Latona
//            MarketAPI latona_market = Global.getFactory().createMarket("latona_market", latona.getName(), 0);
//            latona_market.setPlanetConditionMarketOnly(true);
//            latona_market.addCondition(Conditions.HABITABLE);
//            latona_market.addCondition(Conditions.FARMLAND_ADEQUATE);
//            latona_market.addCondition(Conditions.RUINS_VAST);
//            latona_market.addCondition(Conditions.COLD);
//            latona_market.addCondition(Conditions.ORGANICS_ABUNDANT);
//            latona_market.setPrimaryEntity(latona);
//            latona.setMarket(latona_market);

            // Themis
//            MarketAPI themis_market = Global.getFactory().createMarket("themis_market", themis.getName(), 0);
//            themis_market.setPlanetConditionMarketOnly(true);
//            themis_market.addCondition(Conditions.VOLATILES_DIFFUSE);
//            themis_market.addCondition(Conditions.COLD);
//            themis_market.addCondition(Conditions.ORE_SPARSE);
//            themis_market.addCondition(Conditions.RARE_ORE_SPARSE);
//            themis_market.setPrimaryEntity(themis);
//            themis.setMarket(themis_market);

            // Cove
//            MarketAPI cove_market = Global.getFactory().createMarket("cove_market", cove.getName(), 0);
//            cove_market.setPlanetConditionMarketOnly(true);
//            cove_market.addCondition(Conditions.ORE_ULTRARICH);
//            cove_market.addCondition(Conditions.RARE_ORE_ULTRARICH);
//            cove_market.addCondition(Conditions.LOW_GRAVITY);
//            cove_market.addCondition(Conditions.NO_ATMOSPHERE);
//            cove_market.addCondition(Conditions.METEOR_IMPACTS);
//            cove_market.addCondition(Conditions.VERY_COLD);
//            cove_market.setPrimaryEntity(cove);
//            cove.setMarket(cove_market);

            // Shelter
        /*MarketAPI shelter_market = Global.getFactory().createMarket("shelter_market", shelter.getName(), 0);
        shelter_market.setPlanetConditionMarketOnly(true);
        shelter_market.addCondition(Conditions.HABITABLE);
        shelter_market.addCondition(Conditions.LOW_GRAVITY);
        shelter_market.addCondition(Conditions.COLD);
        shelter_market.addCondition(Conditions.ORE_MODERATE);
        shelter_market.addCondition(Conditions.VOLATILES_DIFFUSE);
        shelter_market.addCondition(Conditions.RARE_ORE_SPARSE);
        shelter_market.addCondition(Conditions.RUINS_SCATTERED);
        shelter_market.setPrimaryEntity(shelter);
        shelter.setMarket(shelter_market);*/

            // Tethys
//            MarketAPI tethys_market = Global.getFactory().createMarket("tethys_market", tethys.getName(), 0);
//            tethys_market.setPlanetConditionMarketOnly(true);
//            tethys_market.addCondition(Conditions.HIGH_GRAVITY);
//            tethys_market.addCondition(Conditions.VERY_COLD);
//            tethys_market.addCondition(Conditions.EXTREME_WEATHER);
//            tethys_market.addCondition(Conditions.TOXIC_ATMOSPHERE);
//            tethys_market.addCondition(Conditions.VOLATILES_DIFFUSE);
//            tethys_market.setPrimaryEntity(tethys);
//            tethys.setMarket(tethys_market);

            // Shrine uncommented to test non-market version non market version works, only needed for inhabited planets
        /*MarketAPI shrine_market = Global.getFactory().createMarket("shrine_market", shrine.getName(), 0);
        shrine_market.setPlanetConditionMarketOnly(true);
        shrine_market.addCondition(Conditions.RUINS_VAST);
        shrine_market.addCondition(Conditions.VERY_COLD);
        shrine_market.addCondition(Conditions.POOR_LIGHT);
        shrine_market.addCondition(Conditions.LOW_GRAVITY);
        shrine_market.setPrimaryEntity(shrine);
        shrine.setMarket(shrine_market);*/

            // get rid of hyperspace clouds directly on top of the system
            HyperspaceTerrainPlugin hyperspaceTerrainPlugin = (HyperspaceTerrainPlugin) Misc.getHyperspaceTerrain().getPlugin(); //get instance of hyperspace terrain
            NebulaEditor nebulaEditor = new NebulaEditor(hyperspaceTerrainPlugin); //object used to make changes to hyperspace nebula
            float minHyperspaceRadius = hyperspaceTerrainPlugin.getTileSize() * 2f; //minimum radius is two 'tiles'
            float maxHyperspaceRadius = system.getMaxRadiusInHyperspace();
            nebulaEditor.clearArc(system.getLocation().x, system.getLocation().y, 0, minHyperspaceRadius + maxHyperspaceRadius, 0f, 360f, 0.25f);
        }
    }
}