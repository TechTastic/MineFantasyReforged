package minefantasy.mfr.worldgen;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MFRBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class MFRConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> YEW_KEY;
    public static final ResourceKey<ConfiguredFeature<?, ?>> IRONBARK_KEY;
    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_KEY;

    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY;
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY;
    public static final ResourceKey<ConfiguredFeature<?, ?>> MYTHIC_ORE_KEY;

    public static final ResourceKey<ConfiguredFeature<?, ?>> KAOLINITE_ORE_KEY;
    public static final ResourceKey<ConfiguredFeature<?, ?>> NITRE_ORE_KEY;
    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY;
    public static final ResourceKey<ConfiguredFeature<?, ?>> BORAX_ORE_KEY;
    public static final ResourceKey<ConfiguredFeature<?, ?>> TUNGSTEN_ORE_KEY;
    public static final ResourceKey<ConfiguredFeature<?, ?>> RICH_COAL_ORE_KEY;

    public static final ResourceKey<ConfiguredFeature<?, ?>> LIMESTONE_KEY;

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        registerTrees(context);
        registerOres(context);
    }

    private static void registerTrees(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(YEW_KEY, new ConfiguredFeature<>(Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MFRBlocks.YEW_LOG.get()),
                        new ForkingTrunkPlacer(4, 4, 3),

                        BlockStateProvider.simple(MFRBlocks.YEW_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                        new TwoLayersFeatureSize(1, 0, 2)).build()
        ));

        context.register(IRONBARK_KEY, new ConfiguredFeature<>(Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MFRBlocks.IRONBARK_LOG.get()),
                        new ForkingTrunkPlacer(4, 4, 3),

                        BlockStateProvider.simple(MFRBlocks.IRONBARK_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                        new TwoLayersFeatureSize(1, 0, 2)).build()
        ));

        context.register(EBONY_KEY, new ConfiguredFeature<>(Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MFRBlocks.EBONY_LOG.get()),
                        new ForkingTrunkPlacer(4, 4, 3),

                        BlockStateProvider.simple(MFRBlocks.EBONY_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                        new TwoLayersFeatureSize(1, 0, 2)).build()
        ));
    }

    private static void registerOres(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        FeatureUtils.register(context, TIN_ORE_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(stoneReplaceables,
                                MFRBlocks.TIN_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables,
                                MFRBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())
                ), 5
        ));

        FeatureUtils.register(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(stoneReplaceables,
                                MFRBlocks.SILVER_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables,
                                MFRBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())
                ), 9
        ));

        FeatureUtils.register(context, MYTHIC_ORE_KEY, Feature.SCATTERED_ORE, new OreConfiguration(
                deepslateReplaceables, MFRBlocks.MYTHIC_ORE.get().defaultBlockState(), 1));



        FeatureUtils.register(context, KAOLINITE_ORE_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(stoneReplaceables,
                                MFRBlocks.KAOLINITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables,
                                MFRBlocks.DEEPSLATE_KAOLINITE_ORE.get().defaultBlockState())
                ), 15
        ));

        FeatureUtils.register(context, NITRE_ORE_KEY, Feature.ORE, new OreConfiguration(
                deepslateReplaceables, MFRBlocks.NITRE_ORE.get().defaultBlockState(), 9));

        FeatureUtils.register(context, SULFUR_ORE_KEY, Feature.ORE, new OreConfiguration(
               deepslateReplaceables, MFRBlocks.SULFUR_ORE.get().defaultBlockState(), 9));

        FeatureUtils.register(context, BORAX_ORE_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(stoneReplaceables,
                                MFRBlocks.BORAX_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables,
                                MFRBlocks.DEEPSLATE_BORAX_ORE.get().defaultBlockState())
                ), 4
        ));

        FeatureUtils.register(context, TUNGSTEN_ORE_KEY, Feature.SCATTERED_ORE, new OreConfiguration(
                deepslateReplaceables, MFRBlocks.TUNGSTEN_ORE.get().defaultBlockState(), 2, 1f));

        FeatureUtils.register(context, RICH_COAL_ORE_KEY, Feature.SCATTERED_ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new BlockMatchTest(Blocks.COAL_ORE),
                                MFRBlocks.RICH_COAL_ORE.get().defaultBlockState()),
                        OreConfiguration.target(new BlockMatchTest(Blocks.DEEPSLATE_COAL_ORE),
                                MFRBlocks.DEEPSLATE_RICH_COAL_ORE.get().defaultBlockState())
                ), 2
        ));



        FeatureUtils.register(context, LIMESTONE_KEY, Feature.ORE, new OreConfiguration(
                new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), MFRBlocks.LIMESTONE.get().defaultBlockState(), 64));
    }
    
    static {
        YEW_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "yew"));
        IRONBARK_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ironbark"));
        EBONY_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ebony"));

        TIN_ORE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "tin_ore"));
        SILVER_ORE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "silver_ore"));
        MYTHIC_ORE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "mythic_ore"));

        KAOLINITE_ORE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "kaolinite_ore"));
        NITRE_ORE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "nitre_ore"));
        SULFUR_ORE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "sulfur_ore"));
        BORAX_ORE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "borax_ore"));
        TUNGSTEN_ORE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "tungsten_ore"));
        RICH_COAL_ORE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "rich_coal_ore"));

        LIMESTONE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "limestone"));
    }
}
