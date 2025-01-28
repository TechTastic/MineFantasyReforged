package minefantasy.mfr.datagen;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MFRBlocks;
import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.init.MFRTags;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MFRBlockTagsDatagen extends BlockTagsProvider {
    public MFRBlockTagsDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MineFantasyReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(MFRTags.Blocks.YEW_LOGS).add(
                MFRBlocks.YEW_LOG.get(),
                MFRBlocks.YEW_WOOD.get(),
                MFRBlocks.STRIPPED_YEW_LOG.get(),
                MFRBlocks.STRIPPED_YEW_WOOD.get()
        );

        this.tag(MFRTags.Blocks.IRONBARK_LOGS).add(
                MFRBlocks.IRONBARK_LOG.get(),
                MFRBlocks.IRONBARK_WOOD.get(),
                MFRBlocks.STRIPPED_IRONBARK_LOG.get(),
                MFRBlocks.STRIPPED_IRONBARK_WOOD.get()
        );

        this.tag(MFRTags.Blocks.EBONY_LOGS).add(
                MFRBlocks.EBONY_LOG.get(),
                MFRBlocks.EBONY_WOOD.get(),
                MFRBlocks.STRIPPED_EBONY_LOG.get(),
                MFRBlocks.STRIPPED_EBONY_WOOD.get()
        );

        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(MFRTags.Blocks.YEW_LOGS)
                .addTag(MFRTags.Blocks.IRONBARK_LOGS)
                .addTag(MFRTags.Blocks.EBONY_LOGS);

        this.tag(BlockTags.PLANKS).add(
                MFRBlocks.YEW_PLANKS.get(),
                MFRBlocks.IRONBARK_PLANKS.get(),
                MFRBlocks.EBONY_PLANKS.get()
        );

        this.tag(BlockTags.LEAVES).add(
                MFRBlocks.YEW_LEAVES.get(),
                MFRBlocks.IRONBARK_LEAVES.get(),
                MFRBlocks.EBONY_LEAVES.get()
        );

        this.tag(BlockTags.SAPLINGS).add(
                MFRBlocks.YEW_SAPLING.get(),
                MFRBlocks.IRONBARK_SAPLING.get(),
                MFRBlocks.EBONY_SAPLING.get()
        );

        this.tag(BlockTags.WOODEN_STAIRS).add(
                MFRBlocks.YEW_STAIRS.get(),
                MFRBlocks.IRONBARK_STAIRS.get(),
                MFRBlocks.EBONY_STAIRS.get()
        );

        this.tag(BlockTags.WOODEN_SLABS).add(
                MFRBlocks.YEW_SLAB.get(),
                MFRBlocks.IRONBARK_SLAB.get(),
                MFRBlocks.EBONY_SLAB.get()
        );

        this.tag(BlockTags.WOODEN_FENCES).add(
                MFRBlocks.YEW_FENCE.get(),
                MFRBlocks.IRONBARK_FENCE.get(),
                MFRBlocks.EBONY_FENCE.get()
        );

        this.tag(BlockTags.FENCE_GATES).add(
                MFRBlocks.YEW_FENCE_GATE.get(),
                MFRBlocks.IRONBARK_FENCE_GATE.get(),
                MFRBlocks.EBONY_FENCE_GATE.get()
        );

        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(
                MFRBlocks.YEW_PRESSURE_PLATE.get(),
                MFRBlocks.IRONBARK_PRESSURE_PLATE.get(),
                MFRBlocks.EBONY_PRESSURE_PLATE.get()
        );

        this.tag(BlockTags.WOODEN_BUTTONS).add(
                MFRBlocks.YEW_BUTTON.get(),
                MFRBlocks.IRONBARK_BUTTON.get(),
                MFRBlocks.EBONY_BUTTON.get()
        );

        this.tag(BlockTags.WOODEN_DOORS).add(
                MFRBlocks.YEW_DOOR.get(),
                MFRBlocks.IRONBARK_DOOR.get(),
                MFRBlocks.EBONY_DOOR.get()
        );

        this.tag(BlockTags.WOODEN_TRAPDOORS).add(
                MFRBlocks.YEW_TRAPDOOR.get(),
                MFRBlocks.IRONBARK_TRAPDOOR.get(),
                MFRBlocks.EBONY_TRAPDOOR.get()
        );

        // STANDING SIGNS
        // WALL SIGNS
        // CEILING SIGNS
        // WALL_HANGING_SIGNS

        this.tag(MFRTags.Blocks.INCORRECT_FOR_TIN_TOOL).addTag(BlockTags.INCORRECT_FOR_WOODEN_TOOL);

        this.tag(MFRTags.Blocks.INCORRECT_FOR_COPPER_TOOL).addTag(BlockTags.INCORRECT_FOR_STONE_TOOL);

        this.tag(MFRTags.Blocks.INCORRECT_FOR_SILVER_TOOL).addTag(BlockTags.INCORRECT_FOR_GOLD_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_GOLD_TOOL).addTag(BlockTags.INCORRECT_FOR_GOLD_TOOL);

        this.tag(MFRTags.Blocks.INCORRECT_FOR_BRONZE_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL).remove(BlockTags.DIAMOND_ORES);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_IRON_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_PIG_IRON_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_STEEL_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);

        this.tag(MFRTags.Blocks.INCORRECT_FOR_ENCRUSTED_TOOL).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_OBSIDIAN_TOOL).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_TUNGSTEN_TOOL).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        this.tag(MFRTags.Blocks.INCORRECT_FOR_BLACK_STEEL_TOOL).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_BLUE_STEEL_TOOL).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_RED_STEEL_TOOL).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_NETHERITE_TOOL).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);

        this.tag(MFRTags.Blocks.INCORRECT_FOR_MITHRIL_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_ADAMANTIUM_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_MITHIUM_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_IGNOTUMITE_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_ENDER_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_COMPOSITE_ALLOY_TOOL);
        this.tag(MFRTags.Blocks.INCORRECT_FOR_BLACK_STEEL_TOOL);
    }
}
