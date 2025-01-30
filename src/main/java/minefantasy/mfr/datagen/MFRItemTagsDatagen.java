package minefantasy.mfr.datagen;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MFRBlocks;
import minefantasy.mfr.init.MFRItems;
import minefantasy.mfr.init.MFRTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class MFRItemTagsDatagen extends ItemTagsProvider {
    public MFRItemTagsDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MineFantasyReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(MFRTags.Items.YEW_LOGS).add(
                MFRBlocks.YEW_LOG.asItem(),
                MFRBlocks.YEW_WOOD.asItem(),
                MFRBlocks.STRIPPED_YEW_LOG.asItem(),
                MFRBlocks.STRIPPED_YEW_WOOD.asItem()
        );

        this.tag(MFRTags.Items.IRONBARK_LOGS).add(
                MFRBlocks.IRONBARK_LOG.asItem(),
                MFRBlocks.IRONBARK_WOOD.asItem(),
                MFRBlocks.STRIPPED_IRONBARK_LOG.asItem(),
                MFRBlocks.STRIPPED_IRONBARK_WOOD.asItem()
        );

        this.tag(MFRTags.Items.EBONY_LOGS).add(
                MFRBlocks.EBONY_LOG.asItem(),
                MFRBlocks.EBONY_WOOD.asItem(),
                MFRBlocks.STRIPPED_EBONY_LOG.asItem(),
                MFRBlocks.STRIPPED_EBONY_WOOD.asItem()
        );

        this.tag(ItemTags.LOGS_THAT_BURN)
                .addTag(MFRTags.Items.YEW_LOGS)
                .addTag(MFRTags.Items.IRONBARK_LOGS)
                .addTag(MFRTags.Items.EBONY_LOGS);

        this.tag(ItemTags.PLANKS).add(
                MFRBlocks.YEW_PLANKS.asItem(),
                MFRBlocks.IRONBARK_PLANKS.asItem(),
                MFRBlocks.EBONY_PLANKS.asItem()
        );

        this.tag(ItemTags.LEAVES).add(
                MFRBlocks.YEW_LEAVES.asItem(),
                MFRBlocks.IRONBARK_LEAVES.asItem(),
                MFRBlocks.EBONY_LEAVES.asItem()
        );

        this.tag(ItemTags.SAPLINGS).add(
                MFRBlocks.YEW_SAPLING.asItem(),
                MFRBlocks.IRONBARK_SAPLING.asItem(),
                MFRBlocks.EBONY_SAPLING.asItem()
        );

        this.tag(ItemTags.WOODEN_STAIRS).add(
                MFRBlocks.YEW_STAIRS.asItem(),
                MFRBlocks.IRONBARK_STAIRS.asItem(),
                MFRBlocks.EBONY_STAIRS.asItem()
        );

        this.tag(ItemTags.WOODEN_SLABS).add(
                MFRBlocks.YEW_SLAB.asItem(),
                MFRBlocks.IRONBARK_SLAB.asItem(),
                MFRBlocks.EBONY_SLAB.asItem()
        );

        this.tag(ItemTags.WOODEN_FENCES).add(
                MFRBlocks.YEW_FENCE.asItem(),
                MFRBlocks.IRONBARK_FENCE.asItem(),
                MFRBlocks.EBONY_FENCE.asItem()
        );

        this.tag(ItemTags.FENCE_GATES).add(
                MFRBlocks.YEW_FENCE_GATE.asItem(),
                MFRBlocks.IRONBARK_FENCE_GATE.asItem(),
                MFRBlocks.EBONY_FENCE_GATE.asItem()
        );

        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(
                MFRBlocks.YEW_PRESSURE_PLATE.asItem(),
                MFRBlocks.IRONBARK_PRESSURE_PLATE.asItem(),
                MFRBlocks.EBONY_PRESSURE_PLATE.asItem()
        );

        this.tag(ItemTags.WOODEN_BUTTONS).add(
                MFRBlocks.YEW_BUTTON.asItem(),
                MFRBlocks.IRONBARK_BUTTON.asItem(),
                MFRBlocks.EBONY_BUTTON.asItem()
        );

        this.tag(ItemTags.WOODEN_DOORS).add(
                MFRBlocks.YEW_DOOR.asItem(),
                MFRBlocks.IRONBARK_DOOR.asItem(),
                MFRBlocks.EBONY_DOOR.asItem()
        );

        this.tag(ItemTags.WOODEN_TRAPDOORS).add(
                MFRBlocks.YEW_TRAPDOOR.asItem(),
                MFRBlocks.IRONBARK_TRAPDOOR.asItem(),
                MFRBlocks.EBONY_TRAPDOOR.asItem()
        );

        // BOATS
        // CHEST BOATS
        // SIGNS
        // HANGING SIGNS

        this.tag(ItemTags.PICKAXES).add(
                MFRItems.STANDARD_PICK.get(),
                MFRItems.STANDARD_HEAVY_PICK.get(),
                MFRItems.STANDARD_HANDPICK.get(),
                MFRItems.STANDARD_MATTOCK.get()
        );

        this.tag(ItemTags.AXES).add(
                MFRItems.STANDARD_AXE.get(),
                MFRItems.STANDARD_LUMBER.get(),
                MFRItems.STANDARD_SAW.get()
        );

        this.tag(ItemTags.SHOVELS).add(
                MFRItems.STANDARD_SHOVEL.get(),
                MFRItems.STANDARD_HEAVY_SHOVEL.get(),
                MFRItems.STANDARD_TROW.get()
        );

        this.tag(ItemTags.HOES).add(
                MFRItems.STANDARD_HOE.get(),
                MFRItems.STANDARD_SCYTHE.get()
        );

        this.tag(ItemTags.SWORDS).add(
                MFRItems.STANDARD_SWORD.get(),
                MFRItems.STANDARD_WARAXE.get(),
                MFRItems.STANDARD_MACE.get(),
                MFRItems.STANDARD_DAGGER.get(),
                MFRItems.STANDARD_SPEAR.get(),
                MFRItems.STANDARD_GREATSWORD.get(),
                MFRItems.STANDARD_BATTLEAXE.get(),
                MFRItems.STANDARD_WARHAMMER.get(),
                MFRItems.STANDARD_KATANA.get(),
                MFRItems.STANDARD_HALBEARD.get(),
                MFRItems.STANDARD_LANCE.get(),
                MFRItems.STANDARD_KNIFE.get()
        );

        this.tag(ItemTags.SWORD_ENCHANTABLE).add(
                MFRItems.STANDARD_SWORD.get(),
                MFRItems.STANDARD_WARAXE.get(),
                MFRItems.STANDARD_MACE.get(),
                MFRItems.STANDARD_DAGGER.get(),
                MFRItems.STANDARD_SPEAR.get(),
                MFRItems.STANDARD_GREATSWORD.get(),
                MFRItems.STANDARD_BATTLEAXE.get(),
                MFRItems.STANDARD_WARHAMMER.get(),
                MFRItems.STANDARD_KATANA.get(),
                MFRItems.STANDARD_HALBEARD.get(),
                MFRItems.STANDARD_LANCE.get(),
                MFRItems.STANDARD_KNIFE.get()
        );

        this.tag(ItemTags.HEAD_ARMOR).add(
                MFRItems.STANDARD_SCALE_HELMET.get(),
                MFRItems.STANDARD_CHAIN_HELMET.get(),
                MFRItems.STANDARD_SPLINT_HELMET.get(),
                MFRItems.STANDARD_PLATE_HELMET.get()
        );

        this.tag(ItemTags.CHEST_ARMOR).add(
                MFRItems.STANDARD_SCALE_CHESTPLATE.get(),
                MFRItems.STANDARD_CHAIN_CHESTPLATE.get(),
                MFRItems.STANDARD_SPLINT_CHESTPLATE.get(),
                MFRItems.STANDARD_PLATE_CHESTPLATE.get()
        );

        this.tag(ItemTags.LEG_ARMOR).add(
                MFRItems.STANDARD_SCALE_LEGGINGS.get(),
                MFRItems.STANDARD_CHAIN_LEGGINGS.get(),
                MFRItems.STANDARD_SPLINT_LEGGINGS.get(),
                MFRItems.STANDARD_PLATE_LEGGINGS.get()
        );

        this.tag(ItemTags.FOOT_ARMOR).add(
                MFRItems.STANDARD_SCALE_BOOTS.get(),
                MFRItems.STANDARD_CHAIN_BOOTS.get(),
                MFRItems.STANDARD_SPLINT_BOOTS.get(),
                MFRItems.STANDARD_PLATE_BOOTS.get()
        );

        this.tag(ItemTags.BOW_ENCHANTABLE).add(
                MFRItems.STANDARD_BOW.get()
        );

        this.tag(ItemTags.ARROWS).add(
                MFRItems.STANDARD_ARROW.get(),
                MFRItems.STANDARD_BOLT.get(),
                MFRItems.STANDARD_ARROW_BODKIN.get(),
                MFRItems.STANDARD_ARROW_BROAD.get()
        );

        this.tag(ItemTags.STONE_BRICKS).add(
                MFRBlocks.LIMESTONE_BRICKS.asItem()
        );

        this.tag(ItemTags.COAL_ORES).add(
                MFRBlocks.RICH_COAL_ORE.asItem(),
                MFRBlocks.DEEPSLATE_RICH_COAL_ORE.asItem()
        );

        this.tag(ItemTags.STAIRS).add(
                MFRBlocks.LIMESTONE_STAIRS.asItem(),
                MFRBlocks.COBBLE_LIMESTONE_STAIRS.asItem(),
                MFRBlocks.LIMESTONE_BRICK_STAIRS.asItem()
        );

        this.tag(ItemTags.SLABS).add(
                MFRBlocks.LIMESTONE_SLAB.asItem(),
                MFRBlocks.COBBLE_LIMESTONE_SLAB.asItem(),
                MFRBlocks.LIMESTONE_BRICK_SLAB.asItem()
        );

        this.tag(ItemTags.WALLS).add(
                MFRBlocks.LIMESTONE_WALL.asItem(),
                MFRBlocks.COBBLE_LIMESTONE_WALL.asItem(),
                MFRBlocks.LIMESTONE_BRICK_WALL.asItem()
        );

        this.tag(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(MFRBlocks.COBBLE_LIMESTONE.asItem());

        this.tag(ItemTags.STONE_TOOL_MATERIALS)
                .add(MFRBlocks.COBBLE_LIMESTONE.asItem());

        this.tag(MFRTags.Items.getCommonTag("cobblestones"))
                .add(MFRBlocks.COBBLE_LIMESTONE.asItem());

        this.tag(MFRTags.Items.getCommonTag("ores_in_ground/stone")).add(
                MFRBlocks.TIN_ORE.asItem(),
                MFRBlocks.SILVER_ORE.asItem(),

                MFRBlocks.KAOLINITE_ORE.asItem(),
                MFRBlocks.BORAX_ORE.asItem(),
                MFRBlocks.RICH_COAL_ORE.asItem()
        );

        this.tag(MFRTags.Items.getCommonTag("ores_in_ground/deepslate")).add(
                MFRBlocks.DEEPSLATE_TIN_ORE.asItem(),
                MFRBlocks.DEEPSLATE_SILVER_ORE.asItem(),
                MFRBlocks.MYTHIC_ORE.asItem(),

                MFRBlocks.DEEPSLATE_KAOLINITE_ORE.asItem(),
                MFRBlocks.NITRE_ORE.asItem(),
                MFRBlocks.SULFUR_ORE.asItem(),
                MFRBlocks.DEEPSLATE_BORAX_ORE.asItem(),
                MFRBlocks.TUNGSTEN_ORE.asItem(),
                MFRBlocks.DEEPSLATE_RICH_COAL_ORE.asItem()
        );

        this.tag(MFRTags.Items.getCommonTag("ores")).add(
                MFRBlocks.TIN_ORE.asItem(),
                MFRBlocks.DEEPSLATE_TIN_ORE.asItem(),
                MFRBlocks.SILVER_ORE.asItem(),
                MFRBlocks.DEEPSLATE_SILVER_ORE.asItem(),
                MFRBlocks.MYTHIC_ORE.asItem(),

                MFRBlocks.KAOLINITE_ORE.asItem(),
                MFRBlocks.DEEPSLATE_KAOLINITE_ORE.asItem(),
                MFRBlocks.NITRE_ORE.asItem(),
                MFRBlocks.SULFUR_ORE.asItem(),
                MFRBlocks.BORAX_ORE.asItem(),
                MFRBlocks.DEEPSLATE_BORAX_ORE.asItem(),
                MFRBlocks.TUNGSTEN_ORE.asItem(),
                MFRBlocks.RICH_COAL_ORE.asItem(),
                MFRBlocks.DEEPSLATE_RICH_COAL_ORE.asItem()
        );

        this.tag(MFRTags.Items.getCommonTag("stones"))
                .add(MFRBlocks.LIMESTONE.asItem());

        this.tag(MFRTags.Items.getCommonTag("stripped_logs")).add(
                MFRBlocks.STRIPPED_YEW_LOG.asItem(),
                MFRBlocks.STRIPPED_IRONBARK_LOG.asItem(),
                MFRBlocks.STRIPPED_EBONY_LOG.asItem()
        );

        this.tag(MFRTags.Items.getCommonTag("stripped_woods")).add(
                MFRBlocks.STRIPPED_YEW_WOOD.asItem(),
                MFRBlocks.STRIPPED_IRONBARK_WOOD.asItem(),
                MFRBlocks.STRIPPED_EBONY_WOOD.asItem()
        );

        this.tag(MFRTags.Items.getCommonTag("fence_gates/wooden")).add(
                MFRBlocks.YEW_FENCE_GATE.asItem(),
                MFRBlocks.IRONBARK_FENCE_GATE.asItem(),
                MFRBlocks.EBONY_FENCE_GATE.asItem()
        );

        this.tag(MFRTags.Items.getCommonTag("tools/melee_weapon")).add(
                MFRItems.STANDARD_SWORD.get(),
                MFRItems.STANDARD_WARAXE.get(),
                MFRItems.STANDARD_MACE.get(),
                MFRItems.STANDARD_DAGGER.get(),
                MFRItems.STANDARD_SPEAR.get(),
                MFRItems.STANDARD_GREATSWORD.get(),
                MFRItems.STANDARD_BATTLEAXE.get(),
                MFRItems.STANDARD_WARHAMMER.get(),
                MFRItems.STANDARD_KATANA.get(),
                MFRItems.STANDARD_HALBEARD.get(),
                MFRItems.STANDARD_LANCE.get(),
                MFRItems.STANDARD_KNIFE.get()
        );

        this.tag(MFRTags.Items.getCommonTag("tools/mining_tool")).add(
                MFRItems.STANDARD_PICK.get(),
                MFRItems.STANDARD_HEAVY_PICK.get(),
                MFRItems.STANDARD_HANDPICK.get(),
                MFRItems.STANDARD_MATTOCK.get()
        );

        this.tag(MFRTags.Items.getCommonTag("tools/ranged_weapon"))
                .add(MFRItems.STANDARD_BOW.get());
    }
}
