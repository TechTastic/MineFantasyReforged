package minefantasy.mfr.init;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.worldgen.structure.processor.DwarvenStrongholdAgeProcessor;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MFRStructureProcessorTypes {
    private static final DeferredRegister<StructureProcessorType<?>> PROCESSORS;

    public static final DeferredHolder<StructureProcessorType<?>, StructureProcessorType<DwarvenStrongholdAgeProcessor>> DWARVEN_AGE_PROCESSOR;

    public static void register(IEventBus bus) {
        PROCESSORS.register(bus);
    }

    static {
        PROCESSORS = DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, MineFantasyReforged.MOD_ID);

        DWARVEN_AGE_PROCESSOR = PROCESSORS.register("dwarven_stronghold_age",
                () -> () -> DwarvenStrongholdAgeProcessor.CODEC);
    }
}
