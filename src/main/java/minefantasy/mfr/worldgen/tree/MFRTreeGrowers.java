package minefantasy.mfr.worldgen.tree;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.worldgen.MFRConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class MFRTreeGrowers {
    public static final TreeGrower YEW = new TreeGrower(
            MineFantasyReforged.MOD_ID + ":yew",
            Optional.empty(),
            Optional.of(MFRConfiguredFeatures.YEW_KEY),
            Optional.empty()
    );

    public static final TreeGrower IRONBARK = new TreeGrower(
            MineFantasyReforged.MOD_ID + ":ironbark",
            Optional.empty(),
            Optional.of(MFRConfiguredFeatures.IRONBARK_KEY),
            Optional.empty()
    );

    public static final TreeGrower EBONY = new TreeGrower(
            MineFantasyReforged.MOD_ID + ":ebony",
            Optional.empty(),
            Optional.of(MFRConfiguredFeatures.EBONY_KEY),
            Optional.empty()
    );
}
