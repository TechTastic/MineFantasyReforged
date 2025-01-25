package minefantasy.mfr.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MFRBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class MFRBlockModelDatagen extends BlockStateProvider {
    public MFRBlockModelDatagen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MineFantasyReforged.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(MFRBlocks.YEW_LOG.get());
        axisBlock(MFRBlocks.YEW_WOOD.get(), blockTexture(MFRBlocks.YEW_LOG.get()), blockTexture(MFRBlocks.YEW_LOG.get()));
        //logBlock(MFRBlocks.STRIPPED_YEW_LOG.get());
        //axisBlock(MFRBlocks.STRIPPED_YEW_WOOD.get(), blockTexture(MFRBlocks.STRIPPED_YEW_LOG.get()), blockTexture(MFRBlocks.STRIPPED_YEW_LOG.get()));
        blockWithItem(MFRBlocks.YEW_PLANKS);
        leavesBlock(MFRBlocks.YEW_LEAVES);
        saplingBlock(MFRBlocks.YEW_SAPLING);
        pottedSaplingBlock(MFRBlocks.POTTED_YEW_SAPLING, MFRBlocks.YEW_SAPLING);
        stairsBlock(MFRBlocks.YEW_STAIRS.get(), blockTexture(MFRBlocks.YEW_PLANKS.get()));
        slabBlock(MFRBlocks.YEW_SLAB.get(), blockTexture(MFRBlocks.YEW_PLANKS.get()), blockTexture(MFRBlocks.YEW_PLANKS.get()));
        fenceBlock(MFRBlocks.YEW_FENCE.get(), blockTexture(MFRBlocks.YEW_PLANKS.get()));
        fenceGateBlock(MFRBlocks.YEW_FENCE_GATE.get(), blockTexture(MFRBlocks.YEW_PLANKS.get()));
        pressurePlateBlock(MFRBlocks.YEW_PRESSURE_PLATE.get(), blockTexture(MFRBlocks.YEW_PLANKS.get()));
        buttonBlock(MFRBlocks.YEW_BUTTON.get(), blockTexture(MFRBlocks.YEW_PLANKS.get()));
        //doorBlockWithRenderType(MFRBlocks.YEW_DOOR.get(), modLoc("block/yew_door_bottom"), modLoc("block/yew_door_top"), "cutout");
        //trapdoorBlockWithRenderType(MFRBlocks.YEW_TRAPDOOR.get(), modLoc("block/yew_trapdoor"), true, "cutout");

        blockItem(MFRBlocks.YEW_LOG);
        blockItem(MFRBlocks.YEW_WOOD);
        blockItem(MFRBlocks.STRIPPED_YEW_LOG);
        blockItem(MFRBlocks.STRIPPED_YEW_WOOD);
        blockItem(MFRBlocks.YEW_STAIRS);
        blockItem(MFRBlocks.YEW_SLAB);
        blockItem(MFRBlocks.YEW_FENCE_GATE);
        blockItem(MFRBlocks.YEW_PRESSURE_PLATE);
        //blockItem(MFRBlocks.YEW_TRAPDOOR, "_bottom");



        logBlock(MFRBlocks.IRONBARK_LOG.get());
        axisBlock(MFRBlocks.IRONBARK_WOOD.get(), blockTexture(MFRBlocks.IRONBARK_LOG.get()), blockTexture(MFRBlocks.IRONBARK_LOG.get()));
        //logBlock(MFRBlocks.STRIPPED_IRONBARK_LOG.get());
        //axisBlock(MFRBlocks.STRIPPED_IRONBARK_WOOD.get(), blockTexture(MFRBlocks.STRIPPED_IRONBARK_LOG.get()), blockTexture(MFRBlocks.STRIPPED_IRONBARK_LOG.get()));
        blockWithItem(MFRBlocks.IRONBARK_PLANKS);
        leavesBlock(MFRBlocks.IRONBARK_LEAVES);
        saplingBlock(MFRBlocks.IRONBARK_SAPLING);
        pottedSaplingBlock(MFRBlocks.POTTED_IRONBARK_SAPLING, MFRBlocks.IRONBARK_SAPLING);
        stairsBlock(MFRBlocks.IRONBARK_STAIRS.get(), blockTexture(MFRBlocks.IRONBARK_PLANKS.get()));
        slabBlock(MFRBlocks.IRONBARK_SLAB.get(), blockTexture(MFRBlocks.IRONBARK_PLANKS.get()), blockTexture(MFRBlocks.IRONBARK_PLANKS.get()));
        fenceBlock(MFRBlocks.IRONBARK_FENCE.get(), blockTexture(MFRBlocks.IRONBARK_PLANKS.get()));
        fenceGateBlock(MFRBlocks.IRONBARK_FENCE_GATE.get(), blockTexture(MFRBlocks.IRONBARK_PLANKS.get()));
        pressurePlateBlock(MFRBlocks.IRONBARK_PRESSURE_PLATE.get(), blockTexture(MFRBlocks.IRONBARK_PLANKS.get()));
        buttonBlock(MFRBlocks.IRONBARK_BUTTON.get(), blockTexture(MFRBlocks.IRONBARK_PLANKS.get()));
        //doorBlockWithRenderType(MFRBlocks.IRONBARK_DOOR.get(), modLoc("block/ironbark_door_bottom"), modLoc("block/ironbark_door_top"), "cutout");
        //trapdoorBlockWithRenderType(MFRBlocks.IRONBARK_TRAPDOOR.get(), modLoc("block/ironbark_trapdoor"), true, "cutout");

        blockItem(MFRBlocks.IRONBARK_LOG);
        blockItem(MFRBlocks.IRONBARK_WOOD);
        blockItem(MFRBlocks.STRIPPED_IRONBARK_LOG);
        blockItem(MFRBlocks.STRIPPED_IRONBARK_WOOD);
        blockItem(MFRBlocks.IRONBARK_STAIRS);
        blockItem(MFRBlocks.IRONBARK_SLAB);
        blockItem(MFRBlocks.IRONBARK_FENCE_GATE);
        blockItem(MFRBlocks.IRONBARK_PRESSURE_PLATE);
        //blockItem(MFRBlocks.IRONBARK_TRAPDOOR, "_bottom");


        
        logBlock(MFRBlocks.EBONY_LOG.get());
        axisBlock(MFRBlocks.EBONY_WOOD.get(), blockTexture(MFRBlocks.EBONY_LOG.get()), blockTexture(MFRBlocks.EBONY_LOG.get()));
        //logBlock(MFRBlocks.STRIPPED_EBONY_LOG.get());
        //axisBlock(MFRBlocks.STRIPPED_EBONY_WOOD.get(), blockTexture(MFRBlocks.STRIPPED_EBONY_LOG.get()), blockTexture(MFRBlocks.STRIPPED_EBONY_LOG.get()));
        blockWithItem(MFRBlocks.EBONY_PLANKS);
        leavesBlock(MFRBlocks.EBONY_LEAVES);
        saplingBlock(MFRBlocks.EBONY_SAPLING);
        pottedSaplingBlock(MFRBlocks.POTTED_EBONY_SAPLING, MFRBlocks.EBONY_SAPLING);
        stairsBlock(MFRBlocks.EBONY_STAIRS.get(), blockTexture(MFRBlocks.EBONY_PLANKS.get()));
        slabBlock(MFRBlocks.EBONY_SLAB.get(), blockTexture(MFRBlocks.EBONY_PLANKS.get()), blockTexture(MFRBlocks.EBONY_PLANKS.get()));
        fenceBlock(MFRBlocks.EBONY_FENCE.get(), blockTexture(MFRBlocks.EBONY_PLANKS.get()));
        fenceGateBlock(MFRBlocks.EBONY_FENCE_GATE.get(), blockTexture(MFRBlocks.EBONY_PLANKS.get()));
        pressurePlateBlock(MFRBlocks.EBONY_PRESSURE_PLATE.get(), blockTexture(MFRBlocks.EBONY_PLANKS.get()));
        buttonBlock(MFRBlocks.EBONY_BUTTON.get(), blockTexture(MFRBlocks.EBONY_PLANKS.get()));
        //doorBlockWithRenderType(MFRBlocks.EBONY_DOOR.get(), modLoc("block/ebony_door_bottom"), modLoc("block/ebony_door_top"), "cutout");
        //trapdoorBlockWithRenderType(MFRBlocks.EBONY_TRAPDOOR.get(), modLoc("block/ebony_trapdoor"), true, "cutout");

        blockItem(MFRBlocks.EBONY_LOG);
        blockItem(MFRBlocks.EBONY_WOOD);
        blockItem(MFRBlocks.STRIPPED_EBONY_LOG);
        blockItem(MFRBlocks.STRIPPED_EBONY_WOOD);
        blockItem(MFRBlocks.EBONY_STAIRS);
        blockItem(MFRBlocks.EBONY_SLAB);
        blockItem(MFRBlocks.EBONY_FENCE_GATE);
        blockItem(MFRBlocks.EBONY_PRESSURE_PLATE);
        //blockItem(MFRBlocks.EBONY_TRAPDOOR, "_bottom");
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void pottedSaplingBlock(DeferredBlock<Block> pot, DeferredBlock<Block> sapling) {
        simpleBlock(pot.get(), models().withExistingParent(pot.getId().toString(), mcLoc("block/flower_pot_cross"))
                .texture("plant", modLoc("block/" + sapling.getId().getPath())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(
                MineFantasyReforged.MOD_ID + ":block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(
                MineFantasyReforged.MOD_ID + ":block/" + deferredBlock.getId().getPath() + appendix));
    }
}
