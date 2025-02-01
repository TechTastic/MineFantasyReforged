package minefantasy.mfr.datagen;

import minefantasy.mfr.block.CarpenterBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.models.blockstates.Condition;
import net.minecraft.data.models.blockstates.MultiPartGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MFRBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Map;

public class MFRBlockModelDatagen extends BlockStateProvider {
    public MFRBlockModelDatagen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MineFantasyReforged.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(MFRBlocks.TIN_ORE);
        blockWithItem(MFRBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(MFRBlocks.SILVER_ORE);
        blockWithItem(MFRBlocks.DEEPSLATE_SILVER_ORE);
        blockWithItem(MFRBlocks.MYTHIC_ORE);

        blockWithItem(MFRBlocks.KAOLINITE_ORE);
        blockWithItem(MFRBlocks.DEEPSLATE_KAOLINITE_ORE);
        blockWithItem(MFRBlocks.NITRE_ORE);
        blockWithItem(MFRBlocks.SULFUR_ORE);
        blockWithItem(MFRBlocks.BORAX_ORE);
        blockWithItem(MFRBlocks.DEEPSLATE_BORAX_ORE);
        blockWithItem(MFRBlocks.TUNGSTEN_ORE);
        blockWithItem(MFRBlocks.RICH_COAL_ORE);
        blockWithItem(MFRBlocks.DEEPSLATE_RICH_COAL_ORE);

        blockFamily(MFRBlocks.COBBLE_BRICK_FAMILY.get());

        glassBlock(MFRBlocks.WINDOW);
        paneBlockWithRenderType(MFRBlocks.WINDOW_PANE.get(), modLoc("block/framed_glass"), modLoc("block/framed_glass_pane"), "translucent");
        glassBlock(MFRBlocks.FRAMED_GLASS);
        paneBlockWithRenderType(MFRBlocks.FRAMED_GLASS_PANE.get(), modLoc("block/window"), modLoc("block/framed_glass_pane"), "translucent");

        blockFamily(MFRBlocks.THATCH_FAMILY.get());

        blockFamily(MFRBlocks.LIMESTONE_FAMILY.get());

        blockFamily(MFRBlocks.COBBLE_LIMESTONE_FAMILY.get());
        blockFamily(MFRBlocks.LIMESTONE_BRICK_FAMILY.get());

        blockFamily(MFRBlocks.FIREBRICK_FAMILY.get());
        blockFamily(MFRBlocks.CLAY_PANEL_FAMILY.get());

        // BARS
        bars(MFRBlocks.BRONZE_BARS);
        //fourWayBlock(MFRBlocks.BRONZE_BARS.get(), models().withExistingParent("bronze_bars_post", mcLoc(("block/iron_bars_post")))
        //                .texture("bars", modLoc("block/bronze_bars"))
        //                .texture("particle", "block/bronze_bars"),
        //        models().withExistingParent("bronze_bars_side", mcLoc(("block/iron_bars_side")))
        //                .texture("bars", modLoc("block/bronze_bars"))
        //                .texture("particle", "block/bronze_bars")
        //                .texture("edge", "block/bronze_bars")
        //                .renderType("translucent")
        //);

        carpenter(MFRBlocks.OAK_CARPENTER, Blocks.OAK_LOG);
        carpenter(MFRBlocks.BIRCH_CARPENTER, Blocks.BIRCH_LOG);
        carpenter(MFRBlocks.SPRUCE_CARPENTER, Blocks.SPRUCE_LOG);
        carpenter(MFRBlocks.JUNGLE_CARPENTER, Blocks.JUNGLE_LOG);
        carpenter(MFRBlocks.DARK_OAK_CARPENTER, Blocks.DARK_OAK_LOG);
        carpenter(MFRBlocks.ACACIA_CARPENTER, Blocks.ACACIA_LOG);
        carpenter(MFRBlocks.MANGROVE_CARPENTER, Blocks.MANGROVE_LOG);
        carpenter(MFRBlocks.BAMBOO_CARPENTER, Blocks.BAMBOO_BLOCK);
        carpenter(MFRBlocks.CRIMSON_CARPENTER, Blocks.CRIMSON_STEM);
        carpenter(MFRBlocks.WARPED_CARPENTER, Blocks.WARPED_STEM);
        carpenter(MFRBlocks.YEW_CARPENTER, MFRBlocks.YEW_LOG.get());
        carpenter(MFRBlocks.IRONBARK_CARPENTER, MFRBlocks.IRONBARK_LOG.get());
        carpenter(MFRBlocks.EBONY_CARPENTER, MFRBlocks.EBONY_LOG.get());

        blockFamily(MFRBlocks.REFINED_FAMILY.get());
        blockFamily(MFRBlocks.NAILED_FAMILY.get());

        axisBlock(MFRBlocks.ENGRAVED_REINFORCED_STONE_0.get(),
                modLoc("block/" + MFRBlocks.ENGRAVED_REINFORCED_STONE_0.getId().getPath()),
                modLoc("block/" + MFRBlocks.REINFORCED_STONE.getId().getPath()));
        axisBlock(MFRBlocks.ENGRAVED_REINFORCED_STONE_1.get(),
                modLoc("block/" + MFRBlocks.ENGRAVED_REINFORCED_STONE_1.getId().getPath()),
                modLoc("block/" + MFRBlocks.REINFORCED_STONE.getId().getPath()));
        axisBlock(MFRBlocks.ENGRAVED_REINFORCED_STONE_2.get(),
                modLoc("block/" + MFRBlocks.ENGRAVED_REINFORCED_STONE_2.getId().getPath()),
                modLoc("block/" + MFRBlocks.REINFORCED_STONE.getId().getPath()));
        axisBlock(MFRBlocks.ENGRAVED_REINFORCED_STONE_3.get(),
                modLoc("block/" + MFRBlocks.ENGRAVED_REINFORCED_STONE_3.getId().getPath()),
                modLoc("block/" + MFRBlocks.REINFORCED_STONE.getId().getPath()));
        blockFamily(MFRBlocks.REINFORCED_STONE_FAMILY.get());

        blockFamily(MFRBlocks.REINFORCED_STONE_BRICK_FAMILY.get());
        blockFamily(MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_FAMILY.get());
        blockFamily(MFRBlocks.CRACKED_REINFORCED_STONE_BRICK_FAMILY.get());

        blockFamily(MFRBlocks.FRAMED_REINFORCED_STONE_FAMILY.get());
        blockFamily(MFRBlocks.IRON_FRAMED_REINFORCED_STONE_FAMILY.get());

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
        if (variants.get(BlockFamily.Variant.FENCE) instanceof FenceBlock fence) {
            fenceBlock(fence, blockTexture(family.getBaseBlock()));
            fenceBlockItem(fence, family.getBaseBlock());
        }
        if (variants.get(BlockFamily.Variant.FENCE_GATE) instanceof FenceGateBlock gate) {
            fenceGateBlock(gate, blockTexture(family.getBaseBlock()));
            blockItem(gate);
        }
        if (variants.get(BlockFamily.Variant.PRESSURE_PLATE) instanceof PressurePlateBlock plate) {
            pressurePlateBlock(plate, blockTexture(family.getBaseBlock()));
            blockItem(plate);
        }
        if (variants.get(BlockFamily.Variant.BUTTON) instanceof ButtonBlock button) {
            buttonBlock(button, blockTexture(family.getBaseBlock()));
            buttonBlockItem(button, family.getBaseBlock());
        }

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
            wallBlockItem(wall, family.getBaseBlock());
        }
    }

    private void bars(DeferredBlock<IronBarsBlock> bars) {
        var barsPostEnds = models().withExistingParent(bars.getId() + "_post_ends", mcLoc("block/iron_bars_post_ends"))
                .texture("particle", modLoc("block/" + bars.getId().getPath()))
                .texture("bars", modLoc("block/" + bars.getId().getPath()))
                .texture("edge", modLoc("block/" + bars.getId().getPath()))
                .renderType("translucent");
        var barsSide = models().withExistingParent(bars.getId() + "_side", mcLoc("block/iron_bars_side"))
                .texture("particle", modLoc("block/" + bars.getId().getPath()))
                .texture("bars", modLoc("block/" + bars.getId().getPath()))
                .texture("edge", modLoc("block/" + bars.getId().getPath()))
                .renderType("translucent");
        var barsPost = models().withExistingParent(bars.getId() + "_post", mcLoc("block/iron_bars_post"))
                .texture("particle", modLoc("block/" + bars.getId().getPath()))
                .texture("bars", modLoc("block/" + bars.getId().getPath()))
                .renderType("translucent");
        var barsCap = models().withExistingParent(bars.getId() + "_cap", mcLoc("block/iron_bars_cap"))
                .texture("particle", modLoc("block/" + bars.getId().getPath()))
                .texture("bars", modLoc("block/" + bars.getId().getPath()))
                .texture("edge", modLoc("block/" + bars.getId().getPath()))
                .renderType("translucent");
        var barsCapAlt = models().withExistingParent(bars.getId() + "_cap_alt", mcLoc("block/iron_bars_cap_alt"))
                .texture("particle", modLoc("block/" + bars.getId().getPath()))
                .texture("bars", modLoc("block/" + bars.getId().getPath()))
                .texture("edge", modLoc("block/" + bars.getId().getPath()))
                .renderType("translucent");
        var barsSideAlt = models().withExistingParent(bars.getId() + "_side_alt", mcLoc("block/iron_bars_side_alt"))
                .texture("particle", modLoc("block/" + bars.getId().getPath()))
                .texture("bars", modLoc("block/" + bars.getId().getPath()))
                .texture("edge", modLoc("block/" + bars.getId().getPath()))
                .renderType("translucent");

        getMultipartBuilder(bars.get())
                .part().modelFile(barsPostEnds).addModel()
                .end()
                .part().modelFile(barsPost).addModel()
                .condition(CrossCollisionBlock.NORTH, false)
                .condition(CrossCollisionBlock.SOUTH, false)
                .condition(CrossCollisionBlock.EAST, false)
                .condition(CrossCollisionBlock.WEST, false)
                .end()

                .part().modelFile(barsCap).addModel()
                .condition(CrossCollisionBlock.NORTH, true)
                .condition(CrossCollisionBlock.SOUTH, false)
                .condition(CrossCollisionBlock.EAST, false)
                .condition(CrossCollisionBlock.WEST, false)
                .end()
                .part().modelFile(barsCap).rotationY(90).addModel()
                .condition(CrossCollisionBlock.NORTH, false)
                .condition(CrossCollisionBlock.SOUTH, false)
                .condition(CrossCollisionBlock.EAST, true)
                .condition(CrossCollisionBlock.WEST, false)
                .end()

                .part().modelFile(barsCapAlt).addModel()
                .condition(CrossCollisionBlock.NORTH, false)
                .condition(CrossCollisionBlock.SOUTH, true)
                .condition(CrossCollisionBlock.EAST, false)
                .condition(CrossCollisionBlock.WEST, false)
                .end()
                .part().modelFile(barsCapAlt).rotationY(90).addModel()
                .condition(CrossCollisionBlock.NORTH, false)
                .condition(CrossCollisionBlock.SOUTH, false)
                .condition(CrossCollisionBlock.EAST, false)
                .condition(CrossCollisionBlock.WEST, true)
                .end()

                .part().modelFile(barsSide).addModel()
                .condition(CrossCollisionBlock.NORTH, true)
                .end()
                .part().modelFile(barsSide).rotationY(90).addModel()
                .condition(CrossCollisionBlock.EAST, true)
                .end()
                .part().modelFile(barsSideAlt).addModel()
                .condition(CrossCollisionBlock.SOUTH, true)
                .end()
                .part().modelFile(barsSideAlt).rotationY(90).addModel()
                .condition(CrossCollisionBlock.WEST, true)
                .end();
    }

    private void buttonBlockItem(ButtonBlock button, Block base) {
        itemModels().buttonInventory(BuiltInRegistries.BLOCK.getKey(button).toString(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(base).getPath()));
    }

    private void fenceBlockItem(FenceBlock fence, Block base) {
        itemModels().fenceInventory(BuiltInRegistries.BLOCK.getKey(fence).toString(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(base).getPath()));
    }

    private void wallBlockItem(WallBlock wall, Block base) {
        itemModels().wallInventory(BuiltInRegistries.BLOCK.getKey(wall).toString(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(base).getPath()));
    }

    private void carpenter(DeferredBlock<CarpenterBlock> block, Block log) {
        ResourceLocation logName = BuiltInRegistries.BLOCK.getKey(log);
        simpleBlockWithItem(block.get(), models().withExistingParent(block.getId().toString(), modLoc("block/carpenter_bench"))
                .texture("log", logName.getNamespace() + ":block/" + logName.getPath()));
    }

    private void glassBlock(DeferredBlock<Block> block) {
        simpleBlockWithItem(block.get(), models().cubeAll(block.getId().getPath(), blockTexture(block.get())).renderType("translucent"));
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));

        itemModels().withExistingParent(blockRegistryObject.getId().toString(), mcLoc("item/generated"))
                .texture("layer0", modLoc("block/" + blockRegistryObject.getId().getPath()));
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
