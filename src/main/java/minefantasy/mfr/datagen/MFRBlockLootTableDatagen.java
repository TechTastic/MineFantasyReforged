package minefantasy.mfr.datagen;

import minefantasy.mfr.init.MFRBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.*;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

public class MFRBlockLootTableDatagen extends BlockLootSubProvider {
    public MFRBlockLootTableDatagen(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(MFRBlocks.TIN_ORE.get());
        dropSelf(MFRBlocks.DEEPSLATE_TIN_ORE.get());
        dropSelf(MFRBlocks.SILVER_ORE.get());
        dropSelf(MFRBlocks.DEEPSLATE_SILVER_ORE.get());
        dropSelf(MFRBlocks.MYTHIC_ORE.get());

        dropSelf(MFRBlocks.KAOLINITE_ORE.get());
        dropSelf(MFRBlocks.DEEPSLATE_KAOLINITE_ORE.get());
        dropSelf(MFRBlocks.NITRE_ORE.get());
        dropSelf(MFRBlocks.SULFUR_ORE.get());
        dropSelf(MFRBlocks.BORAX_ORE.get());
        dropSelf(MFRBlocks.DEEPSLATE_BORAX_ORE.get());
        dropSelf(MFRBlocks.TUNGSTEN_ORE.get());
        dropSelf(MFRBlocks.RICH_COAL_ORE.get());
        dropSelf(MFRBlocks.DEEPSLATE_RICH_COAL_ORE.get());

        //createOreDrop()

        blockFamily(MFRBlocks.COBBLE_BRICK_FAMILY.get());

        dropWhenSilkTouch(MFRBlocks.WINDOW.get());
        dropWhenSilkTouch(MFRBlocks.WINDOW_PANE.get());
        dropWhenSilkTouch(MFRBlocks.FRAMED_GLASS.get());
        dropWhenSilkTouch(MFRBlocks.FRAMED_GLASS_PANE.get());

        blockFamily(MFRBlocks.THATCH_FAMILY.get());

        dropOther(MFRBlocks.LIMESTONE.get(), MFRBlocks.COBBLE_LIMESTONE.asItem());
        dropWhenSilkTouch(MFRBlocks.LIMESTONE.get());
        dropSelf(MFRBlocks.LIMESTONE_STAIRS.get());
        dropSelf(MFRBlocks.LIMESTONE_SLAB.get());
        dropSelf(MFRBlocks.LIMESTONE_WALL.get());

        blockFamily(MFRBlocks.COBBLE_LIMESTONE_FAMILY.get());
        blockFamily(MFRBlocks.LIMESTONE_BRICK_FAMILY.get());

        blockFamily(MFRBlocks.FIREBRICK_FAMILY.get());
        blockFamily(MFRBlocks.CLAY_PANEL_FAMILY.get());

        dropSelf(MFRBlocks.BRONZE_BARS.get());

        dropSelf(MFRBlocks.OAK_CARPENTER.get());
        dropSelf(MFRBlocks.BIRCH_CARPENTER.get());
        dropSelf(MFRBlocks.SPRUCE_CARPENTER.get());
        dropSelf(MFRBlocks.JUNGLE_CARPENTER.get());
        dropSelf(MFRBlocks.DARK_OAK_CARPENTER.get());
        dropSelf(MFRBlocks.ACACIA_CARPENTER.get());
        dropSelf(MFRBlocks.MANGROVE_CARPENTER.get());
        dropSelf(MFRBlocks.BAMBOO_CARPENTER.get());
        dropSelf(MFRBlocks.CRIMSON_CARPENTER.get());
        dropSelf(MFRBlocks.WARPED_CARPENTER.get());
        dropSelf(MFRBlocks.YEW_CARPENTER.get());
        dropSelf(MFRBlocks.IRONBARK_CARPENTER.get());
        dropSelf(MFRBlocks.EBONY_CARPENTER.get());

        blockFamily(MFRBlocks.REFINED_FAMILY.get());
        blockFamily(MFRBlocks.NAILED_FAMILY.get());

        dropSelf(MFRBlocks.ENGRAVED_REINFORCED_STONE_0.get());
        dropSelf(MFRBlocks.ENGRAVED_REINFORCED_STONE_1.get());
        dropSelf(MFRBlocks.ENGRAVED_REINFORCED_STONE_2.get());
        dropSelf(MFRBlocks.ENGRAVED_REINFORCED_STONE_3.get());
        blockFamily(MFRBlocks.REINFORCED_STONE_FAMILY.get());

        blockFamily(MFRBlocks.REINFORCED_STONE_BRICK_FAMILY.get());
        blockFamily(MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_FAMILY.get());
        blockFamily(MFRBlocks.CRACKED_REINFORCED_STONE_BRICK_FAMILY.get());

        blockFamily(MFRBlocks.FRAMED_REINFORCED_STONE_FAMILY.get());
        blockFamily(MFRBlocks.IRON_FRAMED_REINFORCED_STONE_FAMILY.get());

        dropSelf(MFRBlocks.YEW_LOG.get());
        dropSelf(MFRBlocks.YEW_WOOD.get());
        dropSelf(MFRBlocks.STRIPPED_YEW_LOG.get());
        dropSelf(MFRBlocks.STRIPPED_YEW_WOOD.get());
        this.add(MFRBlocks.YEW_LEAVES.get(), block ->
                createLeavesDrops(block, MFRBlocks.YEW_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MFRBlocks.YEW_SAPLING.get());
        dropPottedContents(MFRBlocks.POTTED_YEW_SAPLING.get());
        blockFamily(MFRBlocks.YEW_FAMILY.get());
        
        dropSelf(MFRBlocks.IRONBARK_LOG.get());
        dropSelf(MFRBlocks.IRONBARK_WOOD.get());
        dropSelf(MFRBlocks.STRIPPED_IRONBARK_LOG.get());
        dropSelf(MFRBlocks.STRIPPED_IRONBARK_WOOD.get());
        this.add(MFRBlocks.IRONBARK_LEAVES.get(), block ->
                createLeavesDrops(block, MFRBlocks.IRONBARK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MFRBlocks.IRONBARK_SAPLING.get());
        dropPottedContents(MFRBlocks.POTTED_IRONBARK_SAPLING.get());
        blockFamily(MFRBlocks.IRONBARK_FAMILY.get());
        
        dropSelf(MFRBlocks.EBONY_LOG.get());
        dropSelf(MFRBlocks.EBONY_WOOD.get());
        dropSelf(MFRBlocks.STRIPPED_EBONY_LOG.get());
        dropSelf(MFRBlocks.STRIPPED_EBONY_WOOD.get());
        this.add(MFRBlocks.EBONY_LEAVES.get(), block ->
                createLeavesDrops(block, MFRBlocks.EBONY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MFRBlocks.EBONY_SAPLING.get());
        dropPottedContents(MFRBlocks.POTTED_EBONY_SAPLING.get());
        blockFamily(MFRBlocks.EBONY_FAMILY.get());
    }

    private void blockFamily(BlockFamily family) {
        Map<BlockFamily.Variant, Block> variants = family.getVariants();

        dropSelf(family.getBaseBlock());
        if (variants.get(BlockFamily.Variant.STAIRS) instanceof StairBlock stairs)
            dropSelf(stairs);
        if (variants.get(BlockFamily.Variant.SLAB) instanceof SlabBlock slab)
            dropSelf(slab);
        if (variants.get(BlockFamily.Variant.FENCE) instanceof FenceBlock fence)
            dropSelf(fence);
        if (variants.get(BlockFamily.Variant.FENCE_GATE) instanceof FenceGateBlock gate)
            dropSelf(gate);
        if (variants.get(BlockFamily.Variant.PRESSURE_PLATE) instanceof PressurePlateBlock plate)
            dropSelf(plate);
        if (variants.get(BlockFamily.Variant.BUTTON) instanceof ButtonBlock button)
            dropSelf(button);
        if (variants.get(BlockFamily.Variant.DOOR) instanceof DoorBlock door)
            dropSelf(door);
        if (variants.get(BlockFamily.Variant.TRAPDOOR) instanceof TrapDoorBlock trapdoor)
            dropSelf(trapdoor);
        if (variants.get(BlockFamily.Variant.WALL) instanceof WallBlock wall)
            dropSelf(wall);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return MFRBlocks.getKnownBlocks();
    }
}
