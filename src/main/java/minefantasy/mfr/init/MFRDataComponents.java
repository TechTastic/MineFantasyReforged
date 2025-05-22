package minefantasy.mfr.init;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.item.component.*;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MFRDataComponents {
    private static final DeferredRegister.DataComponents COMPONENTS =
            DeferredRegister.DataComponents.createDataComponents(Registries.DATA_COMPONENT_TYPE, MineFantasyReforged.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<MaterialDataComponent>> MATERIAL_DATA_COMPONENT_TYPE =
            COMPONENTS.register("material", () ->
                    DataComponentType.<MaterialDataComponent>builder()
                            .persistent(MaterialDataComponent.CODEC)
                            .networkSynchronized(MaterialDataComponent.STREAM_CODEC)
                            .build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CraftQualityDataComponent>> CRAFT_QUALITY_DATA_COMPONENT_TYPE =
            COMPONENTS.register("craft_quality", () ->
                    DataComponentType.<CraftQualityDataComponent>builder()
                            .persistent(CraftQualityDataComponent.CODEC)
                            .networkSynchronized(CraftQualityDataComponent.STREAM_CODEC)
                            .build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<InferiorQuailtyDataComponent>> INFERIOR_QUALITY_DATA_COMPONENT_TYPE =
            COMPONENTS.register("inferior_quality", () ->
                    DataComponentType.<InferiorQuailtyDataComponent>builder()
                            .persistent(InferiorQuailtyDataComponent.CODEC)
                            .networkSynchronized(InferiorQuailtyDataComponent.STREAM_CODEC)
                            .build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<SpecialTypeDataComponent>> SPECIAL_TYPE_DATA_COMPONENT_TYPE =
            COMPONENTS.register("special_type", () ->
                    DataComponentType.<SpecialTypeDataComponent>builder()
                            .persistent(SpecialTypeDataComponent.CODEC)
                            .networkSynchronized(SpecialTypeDataComponent.STREAM_CODEC)
                            .build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<SharpnessDataComponent>> SHARPNESS_DATA_COMPONENT_TYPE =
            COMPONENTS.register("sharpness", () ->
                    DataComponentType.<SharpnessDataComponent>builder()
                            .persistent(SharpnessDataComponent.CODEC)
                            .networkSynchronized(SharpnessDataComponent.STREAM_CODEC)
                            .build());

    public static void register(IEventBus bus) {
        COMPONENTS.register(bus);
    }
}
