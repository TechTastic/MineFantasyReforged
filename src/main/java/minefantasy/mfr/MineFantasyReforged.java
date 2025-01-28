package minefantasy.mfr;

import minefantasy.mfr.datagen.*;
import minefantasy.mfr.events.MFREvents;
import minefantasy.mfr.init.*;
import minefantasy.mfr.item.color.ArmorMaterialItemColor;
import minefantasy.mfr.item.color.OneLayerMaterialItemColor;
import minefantasy.mfr.item.color.TwoLayerMaterialItemColor;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.registry.types.CustomMaterialType;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod(MineFantasyReforged.MOD_ID)
public class MineFantasyReforged {
    public static final String MOD_ID = "minefantasyreforged";

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public MineFantasyReforged(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::registerDatapackRegistries);
        modEventBus.addListener(this::registerRegistries);
        modEventBus.addListener(this::onGatherData);
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.addListener(this::onLevelLoad);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        CustomMaterialTypeRegistry.register(modEventBus);
        MFRDataComponents.register(modEventBus);
        MFRItems.register(modEventBus);
        MFRBlocks.register(modEventBus);
        MFRCreativeTabs.register(modEventBus);
    }

    private void onLevelLoad(LevelEvent.Load event) {
        CustomMaterialRegistry.setupAccess(event.getLevel());
    }

    public void registerDatapackRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(
                CustomMaterialRegistry.MATERIAL_REGISTRY_KEY,
                CustomMaterialTypeRegistry.MATERIAL_TYPE_REGISTRY
                        .byNameCodec()
                        .dispatch(
                                "type",
                                CustomMaterial::getType,
                                CustomMaterialType::getCodec
                        ),
                CustomMaterial.SYNC_CODEC
        );
    }

    public void commonSetup(FMLCommonSetupEvent event) {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(MFRBlocks.YEW_SAPLING.getId(), MFRBlocks.POTTED_YEW_SAPLING);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(MFRBlocks.IRONBARK_SAPLING.getId(), MFRBlocks.POTTED_IRONBARK_SAPLING);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(MFRBlocks.EBONY_SAPLING.getId(), MFRBlocks.POTTED_EBONY_SAPLING);
    }

    public void registerRegistries(NewRegistryEvent event) {
        event.register(CustomMaterialTypeRegistry.MATERIAL_TYPE_REGISTRY);
    }

    public void onGatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // Client Datagen
        gen.addProvider(event.includeClient(),
                new MFRBlockModelDatagen(packOutput, fileHelper));
        gen.addProvider(event.includeClient(),
                new MFRItemModelDatagen(packOutput, fileHelper));
        gen.addProvider(event.includeClient(),
                new MFRLanguageDatagen(packOutput));

        // Server Datagen
        gen.addProvider(event.includeServer(),
                new MFRMaterialsDatagen(packOutput, lookup, Set.of(MineFantasyReforged.MOD_ID)));
        BlockTagsProvider blockTags = gen.addProvider(event.includeServer(),
                new MFRBlockTagsDatagen(packOutput, lookup, fileHelper));
        gen.addProvider(event.includeServer(),
                new MFRItemTagsDatagen(packOutput, lookup, blockTags.contentsGetter(), fileHelper));
        gen.addProvider(event.includeServer(),
                new MFRRecipesDatagen(packOutput, lookup));
        gen.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(MFRBlockLootTableDatagen::new,
                        LootContextParamSets.BLOCK)), lookup));
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // BOW

            ItemProperties.register(MFRItems.STANDARD_BOW.get(), ResourceLocation.withDefaultNamespace("pull"), (p_344163_, p_344164_, p_344165_, p_344166_) -> {
                if (p_344165_ == null) {
                    return 0.0F;
                } else {
                    return p_344165_.getUseItem() != p_344163_ ? 0.0F : (float)(p_344163_.getUseDuration(p_344165_) - p_344165_.getUseItemRemainingTicks()) / 20.0F;
                }
            });
            ItemProperties.register(
                    MFRItems.STANDARD_BOW.get(),
                    ResourceLocation.withDefaultNamespace("pulling"),
                    (p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F
            );
        }

        @SubscribeEvent
        public static void registerColors(RegisterColorHandlersEvent.Item event) {
            event.register(new TwoLayerMaterialItemColor(),
                    MFRItems.BAR,

                    MFRItems.METAL_HUNK,
                    MFRItems.PLATE,
                    MFRItems.PLATE_HUGE,
                    MFRItems.SCALE_MESH,
                    MFRItems.CHAIN_MESH,
                    MFRItems.SPLINT_MESH,

                    MFRItems.TIMBER,
                    MFRItems.TIMBER_CUT,
                    MFRItems.TIMBER_PANE,

                    MFRItems.STANDARD_SWORD,
                    MFRItems.STANDARD_WARAXE,
                    MFRItems.STANDARD_MACE,
                    MFRItems.STANDARD_DAGGER,
                    MFRItems.STANDARD_SPEAR,
                    MFRItems.STANDARD_GREATSWORD,
                    MFRItems.STANDARD_BATTLEAXE,
                    MFRItems.STANDARD_WARHAMMER,
                    MFRItems.STANDARD_KATANA,
                    MFRItems.STANDARD_HALBEARD,
                    MFRItems.STANDARD_LANCE,
                    MFRItems.STANDARD_PICK,
                    MFRItems.STANDARD_AXE,
                    MFRItems.STANDARD_SHOVEL,
                    MFRItems.STANDARD_HOE,
                    MFRItems.STANDARD_HEAVY_PICK,
                    MFRItems.STANDARD_HEAVY_SHOVEL,
                    MFRItems.STANDARD_HANDPICK,
                    MFRItems.STANDARD_TROW,
                    MFRItems.STANDARD_SCYTHE,
                    MFRItems.STANDARD_MATTOCK,
                    MFRItems.STANDARD_LUMBER,
                    MFRItems.STANDARD_HAMMMER,
                    MFRItems.STANDARD_HEAVY_HAMMMER,
                    MFRItems.STANDARD_KNIFE,
                    MFRItems.STANDARD_SAW,
                    MFRItems.STANDARD_SPANNER,
                    MFRItems.STANDARD_BOW
            );

            event.register(new OneLayerMaterialItemColor(),
                    MFRItems.STANDARD_TONGS,
                    MFRItems.STANDARD_SHEARS,
                    MFRItems.STANDARD_NEEDLE,
                    MFRItems.STANDARD_SPOON,
                    MFRItems.STANDARD_MALLET,
                    MFRItems.STANDARD_ARROW,
                    MFRItems.STANDARD_BOLT,
                    MFRItems.STANDARD_ARROW_BODKIN,
                    MFRItems.STANDARD_ARROW_BROAD
            );

            event.register(new ArmorMaterialItemColor(),
                    MFRItems.STANDARD_SCALE_HELMET,
                    MFRItems.STANDARD_SCALE_CHESTPLATE,
                    MFRItems.STANDARD_SCALE_LEGGINGS,
                    MFRItems.STANDARD_SCALE_BOOTS,
                    MFRItems.STANDARD_CHAIN_HELMET,
                    MFRItems.STANDARD_CHAIN_CHESTPLATE,
                    MFRItems.STANDARD_CHAIN_LEGGINGS,
                    MFRItems.STANDARD_CHAIN_BOOTS,
                    MFRItems.STANDARD_SPLINT_HELMET,
                    MFRItems.STANDARD_SPLINT_CHESTPLATE,
                    MFRItems.STANDARD_SPLINT_LEGGINGS,
                    MFRItems.STANDARD_SPLINT_BOOTS,
                    MFRItems.STANDARD_PLATE_HELMET,
                    MFRItems.STANDARD_PLATE_CHESTPLATE,
                    MFRItems.STANDARD_PLATE_LEGGINGS,
                    MFRItems.STANDARD_PLATE_BOOTS
            );

            event.register((itemStack, i) -> FoliageColor.getDefaultColor(),
                    MFRBlocks.YEW_LEAVES.asItem(),
                    MFRBlocks.IRONBARK_LEAVES.asItem(),
                    MFRBlocks.EBONY_LEAVES.asItem()
            );
        }

        @SubscribeEvent
        public static void registerColors(RegisterColorHandlersEvent.Block event) {
            event.register((blockState, blockAndTintGetter, blockPos, i) -> blockAndTintGetter != null & blockPos != null
                    ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor(),
                    MFRBlocks.YEW_LEAVES.get(),
                    MFRBlocks.IRONBARK_LEAVES.get(),
                    MFRBlocks.EBONY_LEAVES.get()
            );
        }
    }
}