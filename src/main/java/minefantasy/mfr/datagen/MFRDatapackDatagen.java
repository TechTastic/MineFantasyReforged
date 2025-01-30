package minefantasy.mfr.datagen;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.worldgen.MFRBiomeModifiers;
import minefantasy.mfr.worldgen.MFRConfiguredFeatures;
import minefantasy.mfr.worldgen.MFRPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class MFRDatapackDatagen extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(CustomMaterialRegistry.MATERIAL_REGISTRY_KEY, CustomMaterialRegistry::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, MFRConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, MFRPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, MFRBiomeModifiers::bootstrap);

    public MFRDatapackDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(MineFantasyReforged.MOD_ID));
    }
}