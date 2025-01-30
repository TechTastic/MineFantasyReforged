package minefantasy.mfr.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MFRBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Map;

public class MFRBlockModelDatagen extends BlockStateProvider {
    public MFRBlockModelDatagen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MineFantasyReforged.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(MFRBlocks.TIN_ORE);
        //blockWithItem(MFRBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(MFRBlocks.SILVER_ORE);
        //blockWithItem(MFRBlocks.DEEPSLATE_SILVER_ORE);
        blockWithItem(MFRBlocks.MYTHIC_ORE);

        blockWithItem(MFRBlocks.KAOLINITE_ORE);
        //blockWithItem(MFRBlocks.DEEPSLATE_KAOLINITE_ORE);
        blockWithItem(MFRBlocks.NITRE_ORE);
        blockWithItem(MFRBlocks.SULFUR_ORE);
        blockWithItem(MFRBlocks.BORAX_ORE);
        //blockWithItem(MFRBlocks.DEEPSLATE_BORAX_ORE);
        blockWithItem(MFRBlocks.TUNGSTEN_ORE);
        blockWithItem(MFRBlocks.RICH_COAL_ORE);
        //blockWithItem(MFRBlocks.DEEPSLATE_RICH_COAL_ORE);



        blockFamily(MFRBlocks.LIMESTONE_FAMILY.get());
        blockFamily(MFRBlocks.COBBLE_LIMESTONE_FAMILY.get());
        blockFamily(MFRBlocks.LIMESTONE_BRICK_FAMILY.get());



        logBlock(MFRBlocks.YEW_LOG.get());
        axisBlock(MFRBlocks.YEW_WOOD.get(), blockTexture(MFRBlocks.YEW_LOG.get()), blockTexture(MFRBlocks.YEW_LOG.get()));
        //logBlock(MFRBlocks.STRIPPED_YEW_LOG.get());
        //axisBlock(MFRBlocks.STRIPPED_YEW_WOOD.get(), blockTexture(MFRBlocks.STRIPPED_YEW_LOG.get()), blockTexture(MFRBlocks.STRIPPED_YEW_LOG.get()));
        leavesBlock(MFRBlocks.YEW_LEAVES);
        saplingBlock(MFRBlocks.YEW_SAPLING);
        pottedSaplingBlock(MFRBlocks.POTTED_YEW_SAPLING, MFRBlocks.YEW_SAPLING);

        blockItem(MFRBlocks.YEW_LOG);
        blockItem(MFRBlocks.YEW_WOOD);
        blockItem(MFRBlocks.STRIPPED_YEW_LOG);
        blockItem(MFRBlocks.STRIPPED_YEW_WOOD);

        blockFamily(MFRBlocks.YEW_FAMILY.get());



        logBlock(MFRBlocks.IRONBARK_LOG.get());
        axisBlock(MFRBlocks.IRONBARK_WOOD.get(), blockTexture(MFRBlocks.IRONBARK_LOG.get()), blockTexture(MFRBlocks.IRONBARK_LOG.get()));
        //logBlock(MFRBlocks.STRIPPED_IRONBARK_LOG.get());
        //axisBlock(MFRBlocks.STRIPPED_IRONBARK_WOOD.get(), blockTexture(MFRBlocks.STRIPPED_IRONBARK_LOG.get()), blockTexture(MFRBlocks.STRIPPED_IRONBARK_LOG.get()));
        leavesBlock(MFRBlocks.IRONBARK_LEAVES);
        saplingBlock(MFRBlocks.IRONBARK_SAPLING);
        pottedSaplingBlock(MFRBlocks.POTTED_IRONBARK_SAPLING, MFRBlocks.IRONBARK_SAPLING);

        blockItem(MFRBlocks.IRONBARK_LOG);
        blockItem(MFRBlocks.IRONBARK_WOOD);
        blockItem(MFRBlocks.STRIPPED_IRONBARK_LOG);
        blockItem(MFRBlocks.STRIPPED_IRONBARK_WOOD);

        blockFamily(MFRBlocks.IRONBARK_FAMILY.get());


        
        logBlock(MFRBlocks.EBONY_LOG.get());
        axisBlock(MFRBlocks.EBONY_WOOD.get(), blockTexture(MFRBlocks.EBONY_LOG.get()), blockTexture(MFRBlocks.EBONY_LOG.get()));
        //logBlock(MFRBlocks.STRIPPED_EBONY_LOG.get());
        //axisBlock(MFRBlocks.STRIPPED_EBONY_WOOD.get(), blockTexture(MFRBlocks.STRIPPED_EBONY_LOG.get()), blockTexture(MFRBlocks.STRIPPED_EBONY_LOG.get()));
        leavesBlock(MFRBlocks.EBONY_LEAVES);
        saplingBlock(MFRBlocks.EBONY_SAPLING);
        pottedSaplingBlock(MFRBlocks.POTTED_EBONY_SAPLING, MFRBlocks.EBONY_SAPLING);

        blockItem(MFRBlocks.EBONY_LOG);
        blockItem(MFRBlocks.EBONY_WOOD);
        blockItem(MFRBlocks.STRIPPED_EBONY_LOG);
        blockItem(MFRBlocks.STRIPPED_EBONY_WOOD);

        blockFamily(MFRBlocks.EBONY_FAMILY.get());
    }

    private void blockFamily(BlockFamily family) {
        Map<BlockFamily.Variant, Block> variants = family.getVariants();

        simpleBlockWithItem(family.getBaseBlock(), cubeAll(family.getBaseBlock()));
        if (variants.get(BlockFamily.Variant.STAIRS) instanceof StairBlock stairs) {
            stairsBlock(stairs, blockTexture(family.getBaseBlock()));
            blockItem(stairs);
        }
        if (variants.get(BlockFamily.Variant.SLAB) instanceof SlabBlock slab) {
            slabBlock(slab, blockTexture(family.getBaseBlock()), blockTexture(family.getBaseBlock()));
            blockItem(slab);
        }
        if (variants.get(BlockFamily.Variant.FENCE) instanceof FenceBlock fence)
            fenceBlock(fence, blockTexture(family.getBaseBlock()));
        if (variants.get(BlockFamily.Variant.FENCE_GATE) instanceof FenceGateBlock gate) {
            fenceGateBlock(gate, blockTexture(family.getBaseBlock()));
            blockItem(gate);
        }
        if (variants.get(BlockFamily.Variant.PRESSURE_PLATE) instanceof PressurePlateBlock plate) {
            pressurePlateBlock(plate, blockTexture(family.getBaseBlock()));
            blockItem(plate);
        }
        if (variants.get(BlockFamily.Variant.BUTTON) instanceof ButtonBlock button)
            buttonBlock(button, blockTexture(family.getBaseBlock()));

        //if (variants.get(BlockFamily.Variant.DOOR) instanceof DoorBlock door) {
        //    String name = BuiltInRegistries.BLOCK.getKey(door).getPath();
        //    doorBlockWithRenderType(door, modLoc("block/" + name + "_bottom"), modLoc("block/" + name + "_top"), "cutout");
        //}

        //if (variants.get(BlockFamily.Variant.TRAPDOOR) instanceof TrapDoorBlock trapdoor) {
        //    String name = BuiltInRegistries.BLOCK.getKey(trapdoor).getPath();
        //    trapdoorBlockWithRenderType(trapdoor, modLoc("block/" + name), true, "cutout");
        //    blockItem(trapdoor, "_bottom");
        //}

        if (variants.get(BlockFamily.Variant.WALL) instanceof WallBlock wall) {
            wallBlock(wall, blockTexture(family.getBaseBlock()));
        }
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
        blockItem(deferredBlock, "");
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile(
                MineFantasyReforged.MOD_ID + ":block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void blockItem(Block block, String appendix) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(
                MineFantasyReforged.MOD_ID + ":block/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + appendix));
    }

    private void blockItem(Block block) {
        blockItem(block, "");
    }
}
