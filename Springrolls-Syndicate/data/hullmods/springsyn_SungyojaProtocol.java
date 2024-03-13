package data.hullmods;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.combat.BaseEveryFrameCombatPlugin;
import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.CollisionClass;
import com.fs.starfarer.api.combat.CombatEngineAPI;
import com.fs.starfarer.api.combat.CombatFleetManagerAPI;
import com.fs.starfarer.api.combat.DeployedFleetMemberAPI;
import com.fs.starfarer.api.combat.EveryFrameCombatPlugin;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShieldAPI;
import com.fs.starfarer.api.combat.ShieldAPI.ShieldType;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.combat.ShipCommand;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import com.fs.starfarer.api.impl.campaign.ids.Personalities;
import com.fs.starfarer.api.impl.campaign.ids.Skills;
import com.fs.starfarer.api.impl.campaign.ids.Tags;
import com.fs.starfarer.api.impl.campaign.ids.Stats;
import com.fs.starfarer.api.impl.combat.RiftCascadeEffect;
import com.fs.starfarer.api.impl.combat.RiftLanceEffect;
import com.fs.starfarer.api.input.InputEventAPI;
import com.fs.starfarer.api.loading.FighterWingSpecAPI;
import com.fs.starfarer.api.util.IntervalUtil;
import com.fs.starfarer.api.util.Misc;
import com.fs.starfarer.api.util.WeightedRandomPicker;
import org.lwjgl.util.vector.Vector2f;

import java.util.List;

public class springsyn_SungyojaProtocol extends BaseHullMod {

    public springsyn_SungyojaProtocol() {
    }

    public static final float RADIUS_MULT = 10f;
    public static final float DAMAGE_MULT = 10f;

    Vector2f v1 = new Vector2f(0.1f, 1f);

    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getDynamic().getStat(Stats.EXPLOSION_DAMAGE_MULT).modifyMult(id, DAMAGE_MULT);
        stats.getDynamic().getStat(Stats.EXPLOSION_RADIUS_MULT).modifyMult(id, RADIUS_MULT);
    }

    public String getDescriptionParam(int index, HullSize hullSize) {
        return null;
    }

    @Override
    public void advanceInCombat(ShipAPI ship, float amount) {
        ship.setExplosionScale(10f);
        ship.setExplosionVelocityOverride(v1);

    }
}
