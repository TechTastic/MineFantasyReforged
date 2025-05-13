package minefantasy.mfr.worldgen;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.worldgen.structure.processor.DwarvenStrongholdAgeProcessor;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;

public class MFRStructureProcessorLists {
    public static final ResourceKey<StructureProcessorList> DWARVEN_STRUCTURE_PROCESSOR_LIST;

    public static void bootstrap(BootstrapContext<StructureProcessorList> context) {
        context.register(DWARVEN_STRUCTURE_PROCESSOR_LIST, new StructureProcessorList(List.of(new DwarvenStrongholdAgeProcessor(0.25f))));
    }

    static {
        DWARVEN_STRUCTURE_PROCESSOR_LIST = ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "dwarven_stronghold_age"));
    }
}
