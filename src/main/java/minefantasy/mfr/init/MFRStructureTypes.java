package minefantasy.mfr.init;

import com.mojang.serialization.MapCodec;
import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.worldgen.structure.DwarvenStrongholdStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MFRStructureTypes {
    private static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES;

    public static final DeferredHolder<StructureType<?>, StructureType<DwarvenStrongholdStructure>> DWARVEN_STRONGHOLD;

    public static void register(IEventBus bus) {
        STRUCTURE_TYPES.register(bus);
    }

    static {
        STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, MineFantasyReforged.MOD_ID);

        DWARVEN_STRONGHOLD = STRUCTURE_TYPES.register("dwarven_stronghold", () ->
                () -> Structure.simpleCodec(DwarvenStrongholdStructure::new));
    }
}
