import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.impl.campaign.intel.bar.events.BarEventManager;
import com.fs.starfarer.api.impl.campaign.shared.SharedData;
import data.scripts.world.springrollsFactionGen;
import exerelin.campaign.SectorManager;

public class springroll_ModPlugin extends BaseModPlugin {



    @Override
    public void onNewGame() {
        initSpringrollSyndicate();
    }

    @Override
    public void onGameLoad(boolean newGame) {
        super.onGameLoad(newGame);
        BarEventManager bar = BarEventManager.getInstance();
        boolean hasSpringrollSyndicate = SharedData.getData().getPersonBountyEventData().isParticipating("springrollsyndicate");

        if (!hasSpringrollSyndicate) {
            initSpringrollSyndicate();
        }


    }

    private static void initSpringrollSyndicate() {
        boolean haveNexerelin = Global.getSettings().getModManager().isModEnabled("nexerelin");
        new springrollsFactionGen().generate(Global.getSector());
        if (haveNexerelin && !SectorManager.getManager().isCorvusMode()) {
            SharedData.getData().getPersonBountyEventData().addParticipatingFaction("springrollsyndicate");
        }
    }


//    @Override
//    public void onNewGameAfterEconomyLoad(){
//        SectorAPI sector = Global.getSector();
//        PlayerFleetPersonnelTracker.getInstance();
//        data.scripts.sbrPeople.create();
//        if (!sector.hasScript(sbr_personalfleetVDG.class)) {
//            sector.addScript(new sbr_personalfleetVDG());
//        }
//        if (!sector.hasScript(sbr_personalfleetMidway.class)) {
//            sector.addScript(new sbr_personalfleetMidway());
//        }
//        if (!sector.hasScript(sbr_personalfleetCastle.class)) {
//            sector.addScript(new sbr_personalfleetCastle());
//        }
//        if (isUAF) {
//            MarketAPI favonius = Global.getSector().getEconomy().getMarket("uaf_favonius_station_market");
//            PersonAPI sbr_uafambassador = Global.getSector().getImportantPeople().getPerson("sbr_uafambassador");
//            if (favonius != null){
//                favonius.addPerson(sbr_uafambassador);
//                favonius.getCommDirectory().addPerson(sbr_uafambassador, 2);
//            }
//        }
//    }
}