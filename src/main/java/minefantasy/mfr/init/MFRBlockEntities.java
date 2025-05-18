package minefantasy.mfr.init;

import minefantasy.mfr.blockentity.StorageComponentBE;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static minefantasy.mfr.MineFantasyReforged.MOD_ID;

public class MFRBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES;

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StorageComponentBE>> STORAGE_COMPONENT;

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }

    static {
        BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MOD_ID);

        STORAGE_COMPONENT = BLOCK_ENTITIES.register("storage_component", () ->
                BlockEntityType.Builder.of(
                        StorageComponentBE::new,
                        MFRBlocks.STORAGE_COMPONENT.get()
                ).build(null));
    }
}
