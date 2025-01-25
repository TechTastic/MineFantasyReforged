package minefantasy.mfr.init;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.block.FlammableRotatedPillarBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.BlockFamily;
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
                new SaplingBlock(null, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
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
                new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
        YEW_TRAPDOOR = BLOCKS.register("yew_trapdoor", () ->
                new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
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
                new SaplingBlock(null, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
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
                new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
        IRONBARK_TRAPDOOR = BLOCKS.register("ironbark_trapdoor", () ->
                new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
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
                new SaplingBlock(null, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
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
                new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
        EBONY_TRAPDOOR = BLOCKS.register("ebony_trapdoor", () ->
                new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
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
