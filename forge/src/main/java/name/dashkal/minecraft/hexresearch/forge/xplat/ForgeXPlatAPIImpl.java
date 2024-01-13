package name.dashkal.minecraft.hexresearch.forge.xplat;

import name.dashkal.minecraft.hexresearch.effect.MindFatigueEffect;
import name.dashkal.minecraft.hexresearch.forge.cap.ICognitiveInducerMarks;
import name.dashkal.minecraft.hexresearch.forge.effect.MindFatigueEffectImpl;
import name.dashkal.minecraft.hexresearch.xplat.XPlatAPI;
import net.minecraft.world.entity.npc.Villager;

import java.util.SortedSet;

public class ForgeXPlatAPIImpl extends XPlatAPI {
    public static void init() {
        XPlatAPI.instance = new ForgeXPlatAPIImpl();
    }

    @Override
    public MindFatigueEffect getMindFatigueEffect() {
        return MindFatigueEffectImpl.INSTANCE;
    }

    @Override
    public void cognitiveInducerMarkVillager(Villager villager, long gameTime) {
        ICognitiveInducerMarks.with(villager, c -> c.mark(gameTime));
    }

    @Override
    public SortedSet<Long> cognitiveInducerGetMarks(Villager villager) {
        return ICognitiveInducerMarks.withF(villager, ICognitiveInducerMarks::getMarks);
    }

    @Override
    public void cognitiveInducerPruneMarks(Villager villager, long gameTime) {
        ICognitiveInducerMarks.with(villager, c -> c.pruneMarks(gameTime));
    }
}
