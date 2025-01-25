package minefantasy.mfr.datagen;

import minefantasy.mfr.init.MFRBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class MFRBlockLootTableDatagen extends BlockLootSubProvider {
    public MFRBlockLootTableDatagen(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(MFRBlocks.YEW_LOG.get());
        dropSelf(MFRBlocks.YEW_WOOD.get());
        dropSelf(MFRBlocks.STRIPPED_YEW_LOG.get());
        dropSelf(MFRBlocks.STRIPPED_YEW_WOOD.get());
        dropSelf(MFRBlocks.YEW_PLANKS.get());
        this.add(MFRBlocks.YEW_LEAVES.get(), block ->
                createLeavesDrops(block, MFRBlocks.YEW_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MFRBlocks.YEW_SAPLING.get());
        dropPottedContents(MFRBlocks.POTTED_YEW_SAPLING.get());
        dropSelf(MFRBlocks.YEW_STAIRS.get());
        dropSelf(MFRBlocks.YEW_SLAB.get());
        dropSelf(MFRBlocks.YEW_FENCE.get());
        dropSelf(MFRBlocks.YEW_FENCE_GATE.get());
        dropSelf(MFRBlocks.YEW_PRESSURE_PLATE.get());
        dropSelf(MFRBlocks.YEW_BUTTON.get());
        dropSelf(MFRBlocks.YEW_DOOR.get());
        dropSelf(MFRBlocks.YEW_TRAPDOOR.get());
        
        dropSelf(MFRBlocks.IRONBARK_LOG.get());
        dropSelf(MFRBlocks.IRONBARK_WOOD.get());
        dropSelf(MFRBlocks.STRIPPED_IRONBARK_LOG.get());
        dropSelf(MFRBlocks.STRIPPED_IRONBARK_WOOD.get());
        dropSelf(MFRBlocks.IRONBARK_PLANKS.get());
        this.add(MFRBlocks.IRONBARK_LEAVES.get(), block ->
                createLeavesDrops(block, MFRBlocks.IRONBARK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MFRBlocks.IRONBARK_SAPLING.get());
        dropPottedContents(MFRBlocks.POTTED_IRONBARK_SAPLING.get());
        dropSelf(MFRBlocks.IRONBARK_STAIRS.get());
        dropSelf(MFRBlocks.IRONBARK_SLAB.get());
        dropSelf(MFRBlocks.IRONBARK_FENCE.get());
        dropSelf(MFRBlocks.IRONBARK_FENCE_GATE.get());
        dropSelf(MFRBlocks.IRONBARK_PRESSURE_PLATE.get());
        dropSelf(MFRBlocks.IRONBARK_BUTTON.get());
        dropSelf(MFRBlocks.IRONBARK_DOOR.get());
        dropSelf(MFRBlocks.IRONBARK_TRAPDOOR.get());
        
        dropSelf(MFRBlocks.EBONY_LOG.get());
        dropSelf(MFRBlocks.EBONY_WOOD.get());
        dropSelf(MFRBlocks.STRIPPED_EBONY_LOG.get());
        dropSelf(MFRBlocks.STRIPPED_EBONY_WOOD.get());
        dropSelf(MFRBlocks.EBONY_PLANKS.get());
        this.add(MFRBlocks.EBONY_LEAVES.get(), block ->
                createLeavesDrops(block, MFRBlocks.EBONY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MFRBlocks.EBONY_SAPLING.get());
        dropPottedContents(MFRBlocks.POTTED_EBONY_SAPLING.get());
        dropSelf(MFRBlocks.EBONY_STAIRS.get());
        dropSelf(MFRBlocks.EBONY_SLAB.get());
        dropSelf(MFRBlocks.EBONY_FENCE.get());
        dropSelf(MFRBlocks.EBONY_FENCE_GATE.get());
        dropSelf(MFRBlocks.EBONY_PRESSURE_PLATE.get());
        dropSelf(MFRBlocks.EBONY_BUTTON.get());
        dropSelf(MFRBlocks.EBONY_DOOR.get());
        dropSelf(MFRBlocks.EBONY_TRAPDOOR.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return MFRBlocks.getKnownBlocks();
    }
}
