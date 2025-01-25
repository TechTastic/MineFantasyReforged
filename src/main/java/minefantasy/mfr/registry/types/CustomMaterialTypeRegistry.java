package minefantasy.mfr.registry.types;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.material.LeatherMaterial;
import minefantasy.mfr.material.MetalMaterial;
import minefantasy.mfr.material.WoodMaterial;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryBuilder;

import java.util.function.Supplier;

public class CustomMaterialTypeRegistry {
    public static final ResourceKey<Registry<CustomMaterialType>> MATERIAL_TYPE_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "material_types"));

    public static final Registry<CustomMaterialType> MATERIAL_TYPE_REGISTRY =
            new RegistryBuilder<>(CustomMaterialTypeRegistry.MATERIAL_TYPE_REGISTRY_KEY)
                    .sync(true)
                    .defaultKey(ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "none"))
                    .maxId(Integer.MAX_VALUE >> 5)
                    .create();

    private static final DeferredRegister<CustomMaterialType> TYPES =
            DeferredRegister.create(MATERIAL_TYPE_REGISTRY_KEY, MineFantasyReforged.MOD_ID);

    public static final Supplier<CustomMaterialType> WOOD_TYPES =
            TYPES.register("wood_types", () -> new CustomMaterialType(WoodMaterial.CODEC));
    public static final Supplier<CustomMaterialType> METAL_TYPES =
            TYPES.register("metal_types", () -> new CustomMaterialType(MetalMaterial.CODEC));
    public static final Supplier<CustomMaterialType> LEATHER_TYPES =
            TYPES.register("leather_types", () -> new CustomMaterialType(LeatherMaterial.CODEC));
    public static final Supplier<CustomMaterialType> NONE =
            TYPES.register("none", () -> new CustomMaterialType(CustomMaterial.CODEC));

    public static ResourceLocation getName(CustomMaterialType type) {
        return MATERIAL_TYPE_REGISTRY.getKey(type);
    }

    public static CustomMaterialType getType(ResourceLocation type) {
        return MATERIAL_TYPE_REGISTRY.get(type);
    }

    public static void register(IEventBus bus) {
        TYPES.register(bus);
    }
}
