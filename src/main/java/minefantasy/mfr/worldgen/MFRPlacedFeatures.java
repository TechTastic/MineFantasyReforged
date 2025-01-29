package minefantasy.mfr.worldgen;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MFRBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class MFRPlacedFeatures {
    public static final ResourceKey<PlacedFeature> YEW_PLACED_KEY;
    public static final ResourceKey<PlacedFeature> IRONBARK_PLACED_KEY;
    public static final ResourceKey<PlacedFeature> EBONY_PLACED_KEY;

    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY;
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY;
    public static final ResourceKey<PlacedFeature> MYTHIC_ORE_PLACED_KEY;

    public static final ResourceKey<PlacedFeature> KAOLINITE_ORE_PLACED_KEY;
    public static final ResourceKey<PlacedFeature> NITRE_ORE_PLACED_KEY;
    public static final ResourceKey<PlacedFeature> SULFUR_ORE_PLACED_KEY;
    public static final ResourceKey<PlacedFeature> BORAX_ORE_PLACED_KEY;
    public static final ResourceKey<PlacedFeature> TUNGSTEN_ORE_PLACED_KEY;
    public static final ResourceKey<PlacedFeature> RICH_COAL_ORE_PLACED_KEY;

    public static final ResourceKey<PlacedFeature> LIMESTONE_PLACED_KEY;
    
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        
        registerTrees(context, configuredFeatures);
        registerOres(context, configuredFeatures);
    }
    
    private static void registerTrees(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {
        context.register(YEW_PLACED_KEY, new PlacedFeature(configuredFeatures.getOrThrow(MFRConfiguredFeatures.YEW_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        MFRBlocks.YEW_SAPLING.get())));

        context.register(IRONBARK_PLACED_KEY, new PlacedFeature(configuredFeatures.getOrThrow(MFRConfiguredFeatures.IRONBARK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        MFRBlocks.IRONBARK_SAPLING.get())));

        context.register(EBONY_PLACED_KEY, new PlacedFeature(configuredFeatures.getOrThrow(MFRConfiguredFeatures.EBONY_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        MFRBlocks.EBONY_SAPLING.get())));
    }

    private static void registerOres(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures) {
        PlacementUtils.register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(MFRConfiguredFeatures.TIN_ORE_KEY),
                commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-12), VerticalAnchor.absolute(116))));
        // 48 - 96
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightRange) {
        return List.of(countPlacement, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count), heightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), heightRange);
    }
    
    static {
        YEW_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "yew_placed"));
        IRONBARK_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ironbark_placed"));
        EBONY_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ebony_placed"));

        TIN_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "tin_ore_placed"));
        SILVER_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "silver_ore_placed"));
        MYTHIC_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "mythic_ore_placed"));

        KAOLINITE_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "kaolinite_ore_placed"));
        NITRE_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "nitre_ore_placed"));
        SULFUR_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "sulfur_ore_placed"));
        BORAX_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "borax_ore_placed"));
        TUNGSTEN_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "tungsten_ore_placed"));
        RICH_COAL_ORE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "rich_coal_ore_placed"));

        LIMESTONE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "limestone_placed"));
    }
}
