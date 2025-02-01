package minefantasy.mfr.init;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.block.CarpenterBlock;
import minefantasy.mfr.block.FlammableRotatedPillarBlock;
import minefantasy.mfr.worldgen.tree.MFRTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.BlockFamily;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.function.Supplier;

public class MFRBlocks {
    private static final DeferredRegister.Blocks BLOCKS;
    private static final DeferredRegister.Blocks BLOCKS_WITHOUT_ITEMS;
    private static final DeferredRegister.Items BLOCK_ITEMS;

    public static final DeferredBlock<Block> TIN_ORE;
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE;
    public static final DeferredBlock<Block> SILVER_ORE;
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE;
    public static final DeferredBlock<Block> MYTHIC_ORE;

    public static final DeferredBlock<Block> KAOLINITE_ORE;
    public static final DeferredBlock<Block> DEEPSLATE_KAOLINITE_ORE;
    public static final DeferredBlock<Block> NITRE_ORE;
    public static final DeferredBlock<Block> SULFUR_ORE;
    public static final DeferredBlock<Block> BORAX_ORE;
    public static final DeferredBlock<Block> DEEPSLATE_BORAX_ORE;
    public static final DeferredBlock<Block> TUNGSTEN_ORE;
    public static final DeferredBlock<Block> RICH_COAL_ORE;
    public static final DeferredBlock<Block> DEEPSLATE_RICH_COAL_ORE;
    
    public static final DeferredBlock<Block> COBBLE_BRICKS;
    public static final DeferredBlock<StairBlock> COBBLE_BRICK_STAIRS;
    public static final DeferredBlock<SlabBlock> COBBLE_BRICK_SLAB;
    public static final DeferredBlock<WallBlock> COBBLE_BRICK_WALL;
    public static final Supplier<BlockFamily> COBBLE_BRICK_FAMILY;

    public static final DeferredBlock<Block> WINDOW;
    public static final DeferredBlock<IronBarsBlock> WINDOW_PANE;
    public static final DeferredBlock<Block> FRAMED_GLASS;
    public static final DeferredBlock<IronBarsBlock> FRAMED_GLASS_PANE;

    public static final DeferredBlock<Block> THATCH;
    public static final DeferredBlock<StairBlock> THATCH_STAIRS;
    public static final DeferredBlock<SlabBlock> THATCH_SLAB;
    public static final DeferredBlock<WallBlock> THATCH_WALL;
    public static final Supplier<BlockFamily> THATCH_FAMILY;

    public static final DeferredBlock<Block> LIMESTONE;
    public static final DeferredBlock<StairBlock> LIMESTONE_STAIRS;
    public static final DeferredBlock<SlabBlock> LIMESTONE_SLAB;
    public static final DeferredBlock<WallBlock> LIMESTONE_WALL;
    public static final Supplier<BlockFamily> LIMESTONE_FAMILY;

    public static final DeferredBlock<Block> COBBLE_LIMESTONE;
    public static final DeferredBlock<StairBlock> COBBLE_LIMESTONE_STAIRS;
    public static final DeferredBlock<SlabBlock> COBBLE_LIMESTONE_SLAB;
    public static final DeferredBlock<WallBlock> COBBLE_LIMESTONE_WALL;
    public static final Supplier<BlockFamily> COBBLE_LIMESTONE_FAMILY;
    public static final DeferredBlock<Block> LIMESTONE_BRICKS;
    public static final DeferredBlock<StairBlock> LIMESTONE_BRICK_STAIRS;
    public static final DeferredBlock<SlabBlock> LIMESTONE_BRICK_SLAB;
    public static final DeferredBlock<WallBlock> LIMESTONE_BRICK_WALL;
    public static final Supplier<BlockFamily> LIMESTONE_BRICK_FAMILY;

    public static final DeferredBlock<Block> FIREBRICKS;
    public static final DeferredBlock<StairBlock> FIREBRICK_STAIRS;
    public static final DeferredBlock<SlabBlock> FIREBRICK_SLAB;
    public static final DeferredBlock<WallBlock> FIREBRICK_WALL;
    public static final Supplier<BlockFamily> FIREBRICK_FAMILY;

    public static final DeferredBlock<Block> CLAY_PANEL;
    public static final DeferredBlock<StairBlock> CLAY_PANEL_STAIRS;
    public static final DeferredBlock<SlabBlock> CLAY_PANEL_SLAB;
    public static final DeferredBlock<WallBlock> CLAY_PANEL_WALL;
    public static final Supplier<BlockFamily> CLAY_PANEL_FAMILY;

    // IRON BARS
    public static final DeferredBlock<IronBarsBlock> BRONZE_BARS;
    // STEEL_BARS
    // BLACK_STEEL_BARS
    // RED_STEEL_BARS
    // BLUE_STEEL_BARS

    public static final DeferredBlock<CarpenterBlock> OAK_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> BIRCH_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> SPRUCE_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> JUNGLE_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> DARK_OAK_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> ACACIA_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> MANGROVE_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> BAMBOO_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> CRIMSON_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> WARPED_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> YEW_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> IRONBARK_CARPENTER;
    public static final DeferredBlock<CarpenterBlock> EBONY_CARPENTER;

    public static final DeferredBlock<Block> REFINED_PLANKS;
    public static final DeferredBlock<StairBlock> REFINED_STAIRS;
    public static final DeferredBlock<SlabBlock> REFINED_SLAB;
    public static final DeferredBlock<FenceBlock> REFINED_FENCE;
    public static final DeferredBlock<FenceGateBlock> REFINED_FENCE_GATE;
    public static final DeferredBlock<PressurePlateBlock> REFINED_PRESSURE_PLATE;
    public static final DeferredBlock<ButtonBlock> REFINED_BUTTON;
    public static final Supplier<BlockFamily> REFINED_FAMILY;
    public static final DeferredBlock<Block> NAILED_PLANKS;
    public static final DeferredBlock<StairBlock> NAILED_STAIRS;
    public static final DeferredBlock<SlabBlock> NAILED_SLAB;
    public static final DeferredBlock<FenceBlock> NAILED_FENCE;
    public static final DeferredBlock<FenceGateBlock> NAILED_FENCE_GATE;
    public static final DeferredBlock<PressurePlateBlock> NAILED_PRESSURE_PLATE;
    public static final DeferredBlock<ButtonBlock> NAILED_BUTTON;
    public static final Supplier<BlockFamily> NAILED_FAMILY;

    public static final DeferredBlock<Block> REINFORCED_STONE;
    public static final DeferredBlock<StairBlock> REINFORCED_STONE_STAIRS;
    public static final DeferredBlock<SlabBlock> REINFORCED_STONE_SLAB;
    public static final DeferredBlock<WallBlock> REINFORCED_STONE_WALL;
    public static final DeferredBlock<RotatedPillarBlock> ENGRAVED_REINFORCED_STONE_0;
    public static final DeferredBlock<RotatedPillarBlock> ENGRAVED_REINFORCED_STONE_1;
    public static final DeferredBlock<RotatedPillarBlock> ENGRAVED_REINFORCED_STONE_2;
    public static final DeferredBlock<RotatedPillarBlock> ENGRAVED_REINFORCED_STONE_3;
    public static final Supplier<BlockFamily> REINFORCED_STONE_FAMILY;

    public static final DeferredBlock<Block> REINFORCED_STONE_BRICKS;
    public static final DeferredBlock<StairBlock> REINFORCED_STONE_BRICK_STAIRS;
    public static final DeferredBlock<SlabBlock> REINFORCED_STONE_BRICK_SLAB;
    public static final DeferredBlock<WallBlock> REINFORCED_STONE_BRICK_WALL;
    public static final Supplier<BlockFamily> REINFORCED_STONE_BRICK_FAMILY;
    public static final DeferredBlock<Block> MOSSY_REINFORCED_STONE_BRICKS;
    public static final DeferredBlock<StairBlock> MOSSY_REINFORCED_STONE_BRICK_STAIRS;
    public static final DeferredBlock<SlabBlock> MOSSY_REINFORCED_STONE_BRICK_SLAB;
    public static final DeferredBlock<WallBlock> MOSSY_REINFORCED_STONE_BRICK_WALL;
    public static final Supplier<BlockFamily> MOSSY_REINFORCED_STONE_BRICK_FAMILY;
    public static final DeferredBlock<Block> CRACKED_REINFORCED_STONE_BRICKS;
    public static final DeferredBlock<StairBlock> CRACKED_REINFORCED_STONE_BRICK_STAIRS;
    public static final DeferredBlock<SlabBlock> CRACKED_REINFORCED_STONE_BRICK_SLAB;
    public static final DeferredBlock<WallBlock> CRACKED_REINFORCED_STONE_BRICK_WALL;
    public static final Supplier<BlockFamily> CRACKED_REINFORCED_STONE_BRICK_FAMILY;
    
    public static final DeferredBlock<Block> FRAMED_REINFORCED_STONE;
    public static final DeferredBlock<StairBlock> FRAMED_REINFORCED_STONE_STAIRS;
    public static final DeferredBlock<SlabBlock> FRAMED_REINFORCED_STONE_SLAB;
    public static final DeferredBlock<WallBlock> FRAMED_REINFORCED_STONE_WALL;
    public static final Supplier<BlockFamily> FRAMED_REINFORCED_STONE_FAMILY;
    public static final DeferredBlock<Block> IRON_FRAMED_REINFORCED_STONE;
    public static final DeferredBlock<StairBlock> IRON_FRAMED_REINFORCED_STONE_STAIRS;
    public static final DeferredBlock<SlabBlock> IRON_FRAMED_REINFORCED_STONE_SLAB;
    public static final DeferredBlock<WallBlock> IRON_FRAMED_REINFORCED_STONE_WALL;
    public static final Supplier<BlockFamily> IRON_FRAMED_REINFORCED_STONE_FAMILY;

    public static final DeferredBlock<FlammableRotatedPillarBlock> YEW_LOG;
    public static final DeferredBlock<FlammableRotatedPillarBlock> YEW_WOOD;
    public static final DeferredBlock<FlammableRotatedPillarBlock> STRIPPED_YEW_LOG;
    public static final DeferredBlock<FlammableRotatedPillarBlock> STRIPPED_YEW_WOOD;
    public static final DeferredBlock<Block> YEW_PLANKS;
    public static final DeferredBlock<Block> YEW_LEAVES;
    public static final DeferredBlock<Block> YEW_SAPLING;
    public static final DeferredBlock<Block> POTTED_YEW_SAPLING;
    public static final DeferredBlock<StairBlock> YEW_STAIRS;
    public static final DeferredBlock<SlabBlock> YEW_SLAB;
    public static final DeferredBlock<FenceBlock> YEW_FENCE;
    public static final DeferredBlock<FenceGateBlock> YEW_FENCE_GATE;
    public static final DeferredBlock<PressurePlateBlock> YEW_PRESSURE_PLATE;
    public static final DeferredBlock<ButtonBlock> YEW_BUTTON;
    public static final DeferredBlock<DoorBlock> YEW_DOOR;
    public static final DeferredBlock<TrapDoorBlock> YEW_TRAPDOOR;
    public static final Supplier<BlockFamily> YEW_FAMILY;

    public static final DeferredBlock<FlammableRotatedPillarBlock> IRONBARK_LOG;
    public static final DeferredBlock<FlammableRotatedPillarBlock> IRONBARK_WOOD;
    public static final DeferredBlock<FlammableRotatedPillarBlock> STRIPPED_IRONBARK_LOG;
    public static final DeferredBlock<FlammableRotatedPillarBlock> STRIPPED_IRONBARK_WOOD;
    public static final DeferredBlock<Block> IRONBARK_PLANKS;
    public static final DeferredBlock<Block> IRONBARK_LEAVES;
    public static final DeferredBlock<Block> IRONBARK_SAPLING;
    public static final DeferredBlock<Block> POTTED_IRONBARK_SAPLING;
    public static final DeferredBlock<StairBlock> IRONBARK_STAIRS;
    public static final DeferredBlock<SlabBlock> IRONBARK_SLAB;
    public static final DeferredBlock<FenceBlock> IRONBARK_FENCE;
    public static final DeferredBlock<FenceGateBlock> IRONBARK_FENCE_GATE;
    public static final DeferredBlock<PressurePlateBlock> IRONBARK_PRESSURE_PLATE;
    public static final DeferredBlock<ButtonBlock> IRONBARK_BUTTON;
    public static final DeferredBlock<DoorBlock> IRONBARK_DOOR;
    public static final DeferredBlock<TrapDoorBlock> IRONBARK_TRAPDOOR;
    public static final Supplier<BlockFamily> IRONBARK_FAMILY;

    public static final DeferredBlock<FlammableRotatedPillarBlock> EBONY_LOG;
    public static final DeferredBlock<FlammableRotatedPillarBlock> EBONY_WOOD;
    public static final DeferredBlock<FlammableRotatedPillarBlock> STRIPPED_EBONY_LOG;
    public static final DeferredBlock<FlammableRotatedPillarBlock> STRIPPED_EBONY_WOOD;
    public static final DeferredBlock<Block> EBONY_PLANKS;
    public static final DeferredBlock<Block> EBONY_LEAVES;
    public static final DeferredBlock<Block> EBONY_SAPLING;
    public static final DeferredBlock<Block> POTTED_EBONY_SAPLING;
    public static final DeferredBlock<StairBlock> EBONY_STAIRS;
    public static final DeferredBlock<SlabBlock> EBONY_SLAB;
    public static final DeferredBlock<FenceBlock> EBONY_FENCE;
    public static final DeferredBlock<FenceGateBlock> EBONY_FENCE_GATE;
    public static final DeferredBlock<PressurePlateBlock> EBONY_PRESSURE_PLATE;
    public static final DeferredBlock<ButtonBlock> EBONY_BUTTON;
    public static final DeferredBlock<DoorBlock> EBONY_DOOR;
    public static final DeferredBlock<TrapDoorBlock> EBONY_TRAPDOOR;
    public static final Supplier<BlockFamily> EBONY_FAMILY;

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
        BLOCKS_WITHOUT_ITEMS.register(bus);
        
        BLOCKS.getEntries().forEach(holder -> BLOCK_ITEMS.register(holder.getId().getPath(), () ->
                new BlockItem(holder.get(), new Item.Properties())));
        BLOCK_ITEMS.register(bus);
    }

    public static Iterable<Block> getKnownBlocks() {
        ArrayList<DeferredHolder<Block, ? extends Block>> entries = new ArrayList<>(BLOCKS.getEntries());
        entries.addAll(BLOCKS_WITHOUT_ITEMS.getEntries());
        return entries.stream().map(Holder::value)::iterator;
    }

    static {
        BLOCKS = DeferredRegister.Blocks.createBlocks(MineFantasyReforged.MOD_ID);
        BLOCKS_WITHOUT_ITEMS = DeferredRegister.Blocks.createBlocks(MineFantasyReforged.MOD_ID);
        BLOCK_ITEMS = DeferredRegister.Items.createItems(MineFantasyReforged.MOD_ID);
        

        TIN_ORE = BLOCKS.register("tin_ore", () -> new DropExperienceBlock(ConstantInt.of(0),
                BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_ORE)));
        DEEPSLATE_TIN_ORE = BLOCKS.register("deepslate_tin_ore", () -> new DropExperienceBlock(ConstantInt.of(0),
                BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_COPPER_ORE)));
        SILVER_ORE = BLOCKS.register("silver_ore", () -> new DropExperienceBlock(ConstantInt.of(0),
                BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_ORE)));
        DEEPSLATE_SILVER_ORE = BLOCKS.register("deepslate_silver_ore", () -> new DropExperienceBlock(ConstantInt.of(0),
                BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_GOLD_ORE)));
        MYTHIC_ORE = BLOCKS.register("mythic_ore", () -> new DropExperienceBlock(ConstantInt.of(0),
                BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));
        

        KAOLINITE_ORE = BLOCKS.register("kaolinite_ore", () -> new DropExperienceBlock(ConstantInt.of(1),
                BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE)));
        DEEPSLATE_KAOLINITE_ORE = BLOCKS.register("deepslate_kaolinite_ore", () -> new DropExperienceBlock(ConstantInt.of(1),
                BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_COAL_ORE)));
        NITRE_ORE = BLOCKS.register("nitre_ore", () -> new DropExperienceBlock(ConstantInt.of(1),
                BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_COAL_ORE)));
        SULFUR_ORE = BLOCKS.register("sulfur_ore", () -> new DropExperienceBlock(ConstantInt.of(2),
                BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_GOLD_ORE)));
        BORAX_ORE = BLOCKS.register("borax_ore", () -> new DropExperienceBlock(ConstantInt.of(4),
                BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)));
        DEEPSLATE_BORAX_ORE = BLOCKS.register("deepslate_borax_ore", () -> new DropExperienceBlock(ConstantInt.of(4),
                BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));
        TUNGSTEN_ORE = BLOCKS.register("tungsten_ore", () -> new DropExperienceBlock(ConstantInt.of(4),
                BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));
        RICH_COAL_ORE = BLOCKS.register("rich_coal_ore", () -> new DropExperienceBlock(ConstantInt.of(2),
                BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE)));
        DEEPSLATE_RICH_COAL_ORE = BLOCKS.register("deepslate_rich_coal_ore", () -> new DropExperienceBlock(ConstantInt.of(2),
                BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_COAL_ORE)));


        COBBLE_BRICKS = BLOCKS.register("cobble_bricks", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        COBBLE_BRICK_STAIRS = BLOCKS.register("cobble_brick_stairs", () ->
                new StairBlock(COBBLE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
        COBBLE_BRICK_SLAB = BLOCKS.register("cobble_brick_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
        COBBLE_BRICK_WALL = BLOCKS.register("cobble_brick_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        COBBLE_BRICK_FAMILY = () -> new BlockFamily.Builder(COBBLE_BRICKS.get())
                .stairs(COBBLE_BRICK_STAIRS.get())
                .slab(COBBLE_BRICK_SLAB.get())
                .wall(COBBLE_BRICK_WALL.get())
                .getFamily();
        
        
        WINDOW = BLOCKS.register("window", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
        WINDOW_PANE = BLOCKS.register("window_pane", () ->
                new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE)));
        FRAMED_GLASS = BLOCKS.register("framed_glass", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
        FRAMED_GLASS_PANE = BLOCKS.register("framed_glass_pane", () ->
                new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE)));


        //TODO: Burnable
        THATCH = BLOCKS.register("thatch", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
        THATCH_STAIRS = BLOCKS.register("thatch_stairs", () ->
                new StairBlock(THATCH.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
        THATCH_SLAB = BLOCKS.register("thatch_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
        THATCH_WALL = BLOCKS.register("thatch_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
        THATCH_FAMILY = () -> new BlockFamily.Builder(THATCH.get())
                .stairs(THATCH_STAIRS.get())
                .slab(THATCH_SLAB.get())
                .wall(THATCH_WALL.get())
                .getFamily();
        
        
        LIMESTONE = BLOCKS.register("limestone", () -> 
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
        LIMESTONE_STAIRS = BLOCKS.register("limestone_stairs", () ->
                new StairBlock(LIMESTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS)));
        LIMESTONE_SLAB = BLOCKS.register("limestone_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB)));
        LIMESTONE_WALL = BLOCKS.register("limestone_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        LIMESTONE_FAMILY = () -> new BlockFamily.Builder(LIMESTONE.get())
                .stairs(LIMESTONE_STAIRS.get())
                .slab(LIMESTONE_SLAB.get())
                .wall(LIMESTONE_WALL.get())
                .getFamily();
        

        COBBLE_LIMESTONE = BLOCKS.register("cobble_limestone", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
        COBBLE_LIMESTONE_STAIRS = BLOCKS.register("cobble_limestone_stairs", () ->
                new StairBlock(LIMESTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_STAIRS)));
        COBBLE_LIMESTONE_SLAB = BLOCKS.register("cobble_limestone_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB)));
        COBBLE_LIMESTONE_WALL = BLOCKS.register("cobble_limestone_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL)));
        COBBLE_LIMESTONE_FAMILY = () -> new BlockFamily.Builder(COBBLE_LIMESTONE.get())
                .stairs(COBBLE_LIMESTONE_STAIRS.get())
                .slab(COBBLE_LIMESTONE_SLAB.get())
                .wall(COBBLE_LIMESTONE_WALL.get())
                .getFamily();
        LIMESTONE_BRICKS = BLOCKS.register("limestone_bricks", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        LIMESTONE_BRICK_STAIRS = BLOCKS.register("limestone_brick_stairs", () ->
                new StairBlock(LIMESTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
        LIMESTONE_BRICK_SLAB = BLOCKS.register("limestone_brick_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
        LIMESTONE_BRICK_WALL = BLOCKS.register("limestone_brick_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        LIMESTONE_BRICK_FAMILY = () -> new BlockFamily.Builder(LIMESTONE_BRICKS.get())
                .stairs(LIMESTONE_BRICK_STAIRS.get())
                .slab(LIMESTONE_BRICK_SLAB.get())
                .wall(LIMESTONE_BRICK_WALL.get())
                .getFamily();


        FIREBRICKS = BLOCKS.register("firebricks", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        FIREBRICK_STAIRS = BLOCKS.register("firebrick_stairs", () ->
                new StairBlock(FIREBRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
        FIREBRICK_SLAB = BLOCKS.register("firebrick_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
        FIREBRICK_WALL = BLOCKS.register("firebrick_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        FIREBRICK_FAMILY = () -> new BlockFamily.Builder(FIREBRICKS.get())
                .stairs(FIREBRICK_STAIRS.get())
                .slab(FIREBRICK_SLAB.get())
                .wall(FIREBRICK_WALL.get())
                .getFamily();


        CLAY_PANEL = BLOCKS.register("clay_panel", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        CLAY_PANEL_STAIRS = BLOCKS.register("clay_panel_stairs", () ->
                new StairBlock(CLAY_PANEL.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
        CLAY_PANEL_SLAB = BLOCKS.register("clay_panel_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
        CLAY_PANEL_WALL = BLOCKS.register("clay_panel_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        CLAY_PANEL_FAMILY = () -> new BlockFamily.Builder(CLAY_PANEL.get())
                .stairs(CLAY_PANEL_STAIRS.get())
                .slab(CLAY_PANEL_SLAB.get())
                .wall(CLAY_PANEL_WALL.get())
                .getFamily();

        // IRON BARS
        BRONZE_BARS = BLOCKS.register("bronze_bars", () ->
                new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS)));
        // STEEL_BARS
        // BLACK_STEEL_BARS
        // RED_STEEL_BARS
        // BLUE_STEEL_BARS

        OAK_CARPENTER = BLOCKS.register("oak_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        BIRCH_CARPENTER = BLOCKS.register("birch_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        SPRUCE_CARPENTER = BLOCKS.register("spruce_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        JUNGLE_CARPENTER = BLOCKS.register("jungle_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        DARK_OAK_CARPENTER = BLOCKS.register("dark_oak_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        ACACIA_CARPENTER = BLOCKS.register("acacia_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        MANGROVE_CARPENTER = BLOCKS.register("mangrove_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        BAMBOO_CARPENTER = BLOCKS.register("bamboo_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        CRIMSON_CARPENTER = BLOCKS.register("crimson_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        WARPED_CARPENTER = BLOCKS.register("warped_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        YEW_CARPENTER = BLOCKS.register("yew_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        IRONBARK_CARPENTER = BLOCKS.register("ironbark_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
        EBONY_CARPENTER = BLOCKS.register("ebony_carpenter_bench", () ->
                new CarpenterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));

        REFINED_PLANKS = BLOCKS.register("refined_planks", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        REFINED_STAIRS = BLOCKS.register("refined_stairs", () ->
                new StairBlock(REFINED_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        REFINED_SLAB = BLOCKS.register("refined_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        REFINED_FENCE = BLOCKS.register("refined_fence", () ->
                new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        REFINED_FENCE_GATE = BLOCKS.register("refined_fence_gate", () ->
                new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        REFINED_PRESSURE_PLATE = BLOCKS.register("refined_pressure_plate", () ->
                new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
        REFINED_BUTTON = BLOCKS.register("refined_button", () ->
                new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
        REFINED_FAMILY = () -> new BlockFamily.Builder(REFINED_PLANKS.get())
                .stairs(REFINED_STAIRS.get())
                .slab(REFINED_SLAB.get())
                .fence(REFINED_FENCE.get())
                .fenceGate(REFINED_FENCE_GATE.get())
                .pressurePlate(REFINED_PRESSURE_PLATE.get())
                .button(REFINED_BUTTON.get())
                // SIGN
                .recipeGroupPrefix("wooden")
                .getFamily();
        NAILED_PLANKS = BLOCKS.register("nailed_planks", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        NAILED_STAIRS = BLOCKS.register("nailed_stairs", () ->
                new StairBlock(NAILED_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        NAILED_SLAB = BLOCKS.register("nailed_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        NAILED_FENCE = BLOCKS.register("nailed_fence", () ->
                new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        NAILED_FENCE_GATE = BLOCKS.register("nailed_fence_gate", () ->
                new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        NAILED_PRESSURE_PLATE = BLOCKS.register("nailed_pressure_plate", () ->
                new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
        NAILED_BUTTON = BLOCKS.register("nailed_button", () ->
                new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
        NAILED_FAMILY = () -> new BlockFamily.Builder(NAILED_PLANKS.get())
                .stairs(NAILED_STAIRS.get())
                .slab(NAILED_SLAB.get())
                .fence(NAILED_FENCE.get())
                .fenceGate(NAILED_FENCE_GATE.get())
                .pressurePlate(NAILED_PRESSURE_PLATE.get())
                .button(NAILED_BUTTON.get())
                // SIGN
                .recipeGroupPrefix("wooden")
                .getFamily();

        REINFORCED_STONE = BLOCKS.register("reinforced_stone", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
        REINFORCED_STONE_STAIRS = BLOCKS.register("reinforced_stone_stairs", () ->
                new StairBlock(REINFORCED_STONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS)));
        REINFORCED_STONE_SLAB = BLOCKS.register("reinforced_stone_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB)));
        REINFORCED_STONE_WALL = BLOCKS.register("reinforced_stone_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        ENGRAVED_REINFORCED_STONE_0 = BLOCKS.register("engraved_reinforced_stone_0", () ->
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        ENGRAVED_REINFORCED_STONE_1 = BLOCKS.register("engraved_reinforced_stone_1", () ->
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        ENGRAVED_REINFORCED_STONE_2 = BLOCKS.register("engraved_reinforced_stone_2", () ->
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        ENGRAVED_REINFORCED_STONE_3 = BLOCKS.register("engraved_reinforced_stone_3", () ->
                new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        REINFORCED_STONE_FAMILY = () -> new BlockFamily.Builder(REINFORCED_STONE.get())
                .stairs(REINFORCED_STONE_STAIRS.get())
                .slab(REINFORCED_STONE_SLAB.get())
                .wall(REINFORCED_STONE_WALL.get())
                .getFamily();
        

        REINFORCED_STONE_BRICKS = BLOCKS.register("reinforced_stone_bricks", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        REINFORCED_STONE_BRICK_STAIRS = BLOCKS.register("reinforced_stone_brick_stairs", () ->
                new StairBlock(REINFORCED_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
        REINFORCED_STONE_BRICK_SLAB = BLOCKS.register("reinforced_stone_brick_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
        REINFORCED_STONE_BRICK_WALL = BLOCKS.register("reinforced_stone_brick_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        REINFORCED_STONE_BRICK_FAMILY = () -> new BlockFamily.Builder(REINFORCED_STONE_BRICKS.get())
                .stairs(REINFORCED_STONE_BRICK_STAIRS.get())
                .slab(REINFORCED_STONE_BRICK_SLAB.get())
                .wall(REINFORCED_STONE_BRICK_WALL.get())
                .getFamily();
        MOSSY_REINFORCED_STONE_BRICKS = BLOCKS.register("mossy_reinforced_stone_bricks", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        MOSSY_REINFORCED_STONE_BRICK_STAIRS = BLOCKS.register("mossy_reinforced_stone_brick_stairs", () ->
                new StairBlock(MOSSY_REINFORCED_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
        MOSSY_REINFORCED_STONE_BRICK_SLAB = BLOCKS.register("mossy_reinforced_stone_brick_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
        MOSSY_REINFORCED_STONE_BRICK_WALL = BLOCKS.register("mossy_reinforced_stone_brick_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        MOSSY_REINFORCED_STONE_BRICK_FAMILY = () -> new BlockFamily.Builder(MOSSY_REINFORCED_STONE_BRICKS.get())
                .stairs(MOSSY_REINFORCED_STONE_BRICK_STAIRS.get())
                .slab(MOSSY_REINFORCED_STONE_BRICK_SLAB.get())
                .wall(MOSSY_REINFORCED_STONE_BRICK_WALL.get())
                .getFamily();
        CRACKED_REINFORCED_STONE_BRICKS = BLOCKS.register("cracked_reinforced_stone_bricks", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        CRACKED_REINFORCED_STONE_BRICK_STAIRS = BLOCKS.register("cracked_reinforced_stone_brick_stairs", () ->
                new StairBlock(CRACKED_REINFORCED_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
        CRACKED_REINFORCED_STONE_BRICK_SLAB = BLOCKS.register("cracked_reinforced_stone_brick_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
        CRACKED_REINFORCED_STONE_BRICK_WALL = BLOCKS.register("cracked_reinforced_stone_brick_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        CRACKED_REINFORCED_STONE_BRICK_FAMILY = () -> new BlockFamily.Builder(CRACKED_REINFORCED_STONE_BRICKS.get())
                .stairs(CRACKED_REINFORCED_STONE_BRICK_STAIRS.get())
                .slab(CRACKED_REINFORCED_STONE_BRICK_SLAB.get())
                .wall(CRACKED_REINFORCED_STONE_BRICK_WALL.get())
                .getFamily();


        FRAMED_REINFORCED_STONE = BLOCKS.register("framed_reinforced_stone", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        FRAMED_REINFORCED_STONE_STAIRS = BLOCKS.register("framed_reinforced_stone_stairs", () ->
                new StairBlock(FRAMED_REINFORCED_STONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
        FRAMED_REINFORCED_STONE_SLAB = BLOCKS.register("framed_reinforced_stone_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
        FRAMED_REINFORCED_STONE_WALL = BLOCKS.register("framed_reinforced_stone_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        FRAMED_REINFORCED_STONE_FAMILY = () -> new BlockFamily.Builder(FRAMED_REINFORCED_STONE.get())
                .stairs(FRAMED_REINFORCED_STONE_STAIRS.get())
                .slab(FRAMED_REINFORCED_STONE_SLAB.get())
                .wall(FRAMED_REINFORCED_STONE_WALL.get())
                .getFamily();
        IRON_FRAMED_REINFORCED_STONE = BLOCKS.register("iron_framed_reinforced_stone", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
        IRON_FRAMED_REINFORCED_STONE_STAIRS = BLOCKS.register("iron_framed_reinforced_stone_stairs", () ->
                new StairBlock(IRON_FRAMED_REINFORCED_STONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
        IRON_FRAMED_REINFORCED_STONE_SLAB = BLOCKS.register("iron_framed_reinforced_stone_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));
        IRON_FRAMED_REINFORCED_STONE_WALL = BLOCKS.register("iron_framed_reinforced_stone_wall", () ->
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        IRON_FRAMED_REINFORCED_STONE_FAMILY = () -> new BlockFamily.Builder(IRON_FRAMED_REINFORCED_STONE.get())
                .stairs(IRON_FRAMED_REINFORCED_STONE_STAIRS.get())
                .slab(IRON_FRAMED_REINFORCED_STONE_SLAB.get())
                .wall(IRON_FRAMED_REINFORCED_STONE_WALL.get())
                .getFamily();
        

        YEW_LOG = BLOCKS.register("yew_log", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
        YEW_WOOD = BLOCKS.register("yew_wood", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
        STRIPPED_YEW_LOG = BLOCKS.register("stripped_yew_log", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
        STRIPPED_YEW_WOOD = BLOCKS.register("stripped_yew_wood", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
        YEW_PLANKS = BLOCKS.register("yew_planks", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        YEW_LEAVES = BLOCKS.register("yew_leaves", () ->
                new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 60;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 30;
                    }
                });
        YEW_SAPLING = BLOCKS.register("yew_sapling", () ->
                new SaplingBlock(MFRTreeGrowers.YEW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
        POTTED_YEW_SAPLING = BLOCKS_WITHOUT_ITEMS.register("potted_yew_sapling", () ->
                new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), YEW_SAPLING,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
        YEW_STAIRS = BLOCKS.register("yew_stairs", () ->
                new StairBlock(YEW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        YEW_SLAB = BLOCKS.register("yew_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        YEW_FENCE = BLOCKS.register("yew_fence", () ->
                new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        YEW_FENCE_GATE = BLOCKS.register("yew_fence_gate", () ->
                new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        YEW_PRESSURE_PLATE = BLOCKS.register("yew_pressure_plate", () ->
                new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
        YEW_BUTTON = BLOCKS.register("yew_button", () ->
                new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
        YEW_DOOR = BLOCKS.register("yew_door", () ->
                new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
        YEW_TRAPDOOR = BLOCKS.register("yew_trapdoor", () ->
                new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
        YEW_FAMILY = () -> new BlockFamily.Builder(YEW_PLANKS.get())
                .stairs(YEW_STAIRS.get())
                .slab(YEW_SLAB.get())
                .fence(YEW_FENCE.get())
                .fenceGate(YEW_FENCE_GATE.get())
                .pressurePlate(YEW_PRESSURE_PLATE.get())
                .button(YEW_BUTTON.get())
                .door(YEW_DOOR.get())
                .trapdoor(YEW_TRAPDOOR.get())
                // SIGN
                .recipeGroupPrefix("wooden")
                .getFamily();
        

        IRONBARK_LOG = BLOCKS.register("ironbark_log", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
        IRONBARK_WOOD = BLOCKS.register("ironbark_wood", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
        STRIPPED_IRONBARK_LOG = BLOCKS.register("stripped_ironbark_log", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
        STRIPPED_IRONBARK_WOOD = BLOCKS.register("stripped_ironbark_wood", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
        IRONBARK_PLANKS = BLOCKS.register("ironbark_planks", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        IRONBARK_LEAVES = BLOCKS.register("ironbark_leaves", () ->
                new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 60;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 30;
                    }
                });
        IRONBARK_SAPLING = BLOCKS.register("ironbark_sapling", () ->
                new SaplingBlock(MFRTreeGrowers.IRONBARK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
        POTTED_IRONBARK_SAPLING = BLOCKS_WITHOUT_ITEMS.register("potted_ironbark_sapling", () ->
                new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, IRONBARK_SAPLING,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
        IRONBARK_STAIRS = BLOCKS.register("ironbark_stairs", () ->
                new StairBlock(IRONBARK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        IRONBARK_SLAB = BLOCKS.register("ironbark_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        IRONBARK_FENCE = BLOCKS.register("ironbark_fence", () ->
                new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        IRONBARK_FENCE_GATE = BLOCKS.register("ironbark_fence_gate", () ->
                new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        IRONBARK_PRESSURE_PLATE = BLOCKS.register("ironbark_pressure_plate", () ->
                new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
        IRONBARK_BUTTON = BLOCKS.register("ironbark_button", () ->
                new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
        IRONBARK_DOOR = BLOCKS.register("ironbark_door", () ->
                new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
        IRONBARK_TRAPDOOR = BLOCKS.register("ironbark_trapdoor", () ->
                new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
        IRONBARK_FAMILY = () -> new BlockFamily.Builder(IRONBARK_PLANKS.get())
                .stairs(IRONBARK_STAIRS.get())
                .slab(IRONBARK_SLAB.get())
                .fence(IRONBARK_FENCE.get())
                .fenceGate(IRONBARK_FENCE_GATE.get())
                .pressurePlate(IRONBARK_PRESSURE_PLATE.get())
                .button(IRONBARK_BUTTON.get())
                .door(IRONBARK_DOOR.get())
                .trapdoor(IRONBARK_TRAPDOOR.get())
                // SIGN
                .recipeGroupPrefix("wooden")
                .getFamily();
        

        EBONY_LOG = BLOCKS.register("ebony_log", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
        EBONY_WOOD = BLOCKS.register("ebony_wood", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
        STRIPPED_EBONY_LOG = BLOCKS.register("stripped_ebony_log", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
        STRIPPED_EBONY_WOOD = BLOCKS.register("stripped_ebony_wood", () ->
                new FlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
        EBONY_PLANKS = BLOCKS.register("ebony_planks", () ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        EBONY_LEAVES = BLOCKS.register("ebony_leaves", () ->
                new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 60;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 30;
                    }
                });
        EBONY_SAPLING = BLOCKS.register("ebony_sapling", () ->
                new SaplingBlock(MFRTreeGrowers.EBONY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
        POTTED_EBONY_SAPLING = BLOCKS_WITHOUT_ITEMS.register("potted_ebony_sapling", () ->
                new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, EBONY_SAPLING,
                        BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
        EBONY_STAIRS = BLOCKS.register("ebony_stairs", () ->
                new StairBlock(EBONY_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        EBONY_SLAB = BLOCKS.register("ebony_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        EBONY_FENCE = BLOCKS.register("ebony_fence", () ->
                new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        EBONY_FENCE_GATE = BLOCKS.register("ebony_fence_gate", () ->
                new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)) {
                    @Override
                    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 20;
                    }

                    @Override
                    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                        return 5;
                    }
                });
        EBONY_PRESSURE_PLATE = BLOCKS.register("ebony_pressure_plate", () ->
                new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
        EBONY_BUTTON = BLOCKS.register("ebony_button", () ->
                new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
        EBONY_DOOR = BLOCKS.register("ebony_door", () ->
                new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
        EBONY_TRAPDOOR = BLOCKS.register("ebony_trapdoor", () ->
                new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
        EBONY_FAMILY = () -> new BlockFamily.Builder(EBONY_PLANKS.get())
                .stairs(EBONY_STAIRS.get())
                .slab(EBONY_SLAB.get())
                .fence(EBONY_FENCE.get())
                .fenceGate(EBONY_FENCE_GATE.get())
                .pressurePlate(EBONY_PRESSURE_PLATE.get())
                .button(EBONY_BUTTON.get())
                .door(EBONY_DOOR.get())
                .trapdoor(EBONY_TRAPDOOR.get())
                // SIGN
                .recipeGroupPrefix("wooden")
                .getFamily();
    }
}
