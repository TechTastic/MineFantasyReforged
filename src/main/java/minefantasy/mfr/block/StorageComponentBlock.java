package minefantasy.mfr.block;

import com.sun.jna.platform.win32.WinBase;
import minefantasy.mfr.blockentity.StorageComponentBE;
import minefantasy.mfr.init.MFRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

import static minefantasy.mfr.MineFantasyReforged.MOD_ID;

public class StorageComponentBlock extends Block implements EntityBlock {
    public static final EnumProperty<Type> TYPE;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final VoxelShape[] SHAPES_BY_SIZE;

    public StorageComponentBlock(Properties properties) {
        super(properties
                .noOcclusion()
                .instabreak()
                .pushReaction(PushReaction.DESTROY)
                .noLootTable()
        );

        this.registerDefaultState(this.defaultBlockState()
                .setValue(FACING, Direction.NORTH)
                .setValue(TYPE, Type.BAR));
    }

    @Override
    protected boolean propagatesSkylightDown(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(TYPE, FACING));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new StorageComponentBE(blockPos, blockState);
    }

    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof StorageComponentBE comp))
            return super.getShape(state, level, pos, context);
        int size = comp.getStack().getCount();

        Type type = state.getValue(TYPE);
        return switch (type) {
            case TIMBER, TIMBER_CUT -> SHAPES_BY_SIZE[(size - 1) / 4];
            case TIMBER_PANE, PLATE, CHAIN_MESH, SCALE_MESH, SPLINT_MESH -> SHAPES_BY_SIZE[size + 15];
            case BAR, MOULD, FIREBRICK -> SHAPES_BY_SIZE[2 * ((size - 1) / 8) + 1];
            case POT -> SHAPES_BY_SIZE[4 * ((size - 1) / 16) + 3];
            case EMPTY_JUG, PLANT_OIL_JUG, WATER_JUG, MILK_JUG -> SHAPES_BY_SIZE[(size <= 16) ? 7 : 15];
            case PLATE_HUGE, PIE_TRAY -> SHAPES_BY_SIZE[size * 2 + 15];
        };
    }

    @Override
    public boolean onDestroyedByPlayer(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, boolean willHarvest, @NotNull FluidState fluid) {
        // Itemize

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public void onDestroyedByPushReaction(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Direction pushDirection, @NotNull FluidState fluid) {
        // Itemize and Push in direction

        super.onDestroyedByPushReaction(state, level, pos, pushDirection, fluid);
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull BlockState state, @NotNull HitResult target, @NotNull LevelReader level, @NotNull BlockPos pos, @NotNull Player player) {
        BlockEntity be = level.getBlockEntity(pos);

        if (!(be instanceof StorageComponentBE comp))
            return super.getCloneItemStack(state, target, level, pos, player);

        return comp.getStackWithSize(1);
    }

    @Override
    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        Type type = state.getValue(TYPE);
        return switch (type) {
            case TIMBER, TIMBER_CUT, TIMBER_PANE -> 20; // Check material for Wood
            default -> 0;
        };
    }

    @Override
    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        Type type = state.getValue(TYPE);
        return switch (type) {
            case TIMBER, TIMBER_CUT, TIMBER_PANE -> true; // Check Pane material for Wood
            default -> false;
        };
    }

    @Override
    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        Type type = state.getValue(TYPE);
        return switch (type) {
            case TIMBER, TIMBER_CUT, TIMBER_PANE -> 10; // Check material for Wood
            default -> 0;
        };
    }

    @Override
    public boolean canDropFromExplosion(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Explosion explosion) {
        return super.canDropFromExplosion(state, level, pos, explosion);
    }

    @Override
    public void onBlockExploded(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Explosion explosion) {
        super.onBlockExploded(state, level, pos, explosion);
    }

    @Override
    public @NotNull MapColor getMapColor(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull MapColor defaultColor) {
        Type type = state.getValue(TYPE);
        return switch (type) {
            case POT, PIE_TRAY, EMPTY_JUG, PLANT_OIL_JUG, WATER_JUG, MILK_JUG, MOULD, FIREBRICK -> MapColor.TERRACOTTA_BROWN;
            default -> super.getMapColor(state, level, pos, defaultColor);
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        StorageComponentBlock.Type type = StorageComponentBlock.Type.getType(context.getItemInHand());
        if (type == null) return null;

        return this.defaultBlockState()
                .setValue(FACING, Arrays.stream(context.getNearestLookingDirections()).filter(dir -> FACING.getPossibleValues().contains(dir)).findFirst().orElse(Direction.NORTH))
                .setValue(TYPE, type);
    }

    @Override
    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);

        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof StorageComponentBE comp) {
            comp.setStack(stack);
            comp.setChanged();
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_CLIENTS);
        }
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level,
            @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        Type type = state.getValue(TYPE);
        BlockEntity be = level.getBlockEntity(pos);

        if (level.isClientSide || type != Type.getType(stack) || !(be instanceof StorageComponentBE comp)
                || !(comp.hasStack() && ItemStack.isSameItemSameComponents(stack, comp.getStack())) || !comp.incrementStack((ServerLevel) level, pos, state))
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);

        if (!player.isCreative())
            stack.shrink(1);
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        BlockEntity be = level.getBlockEntity(pos);

        if (level.isClientSide || !(be instanceof StorageComponentBE comp) || !player.canTakeItem(comp.getStackWithSize(1)))
            return super.useWithoutItem(state, level, pos, player, hitResult);

        comp.decrementStack((ServerLevel) level, pos, state);
        if (!player.isCreative())
            player.addItem(comp.getStackWithSize(1));
        return InteractionResult.SUCCESS;
    }

    @Override
    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    protected void spawnDestroyParticles(@NotNull Level level, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState state) {
        //super.spawnDestroyParticles(level, player, pos, state);
    }

    static {
        TYPE = EnumProperty.create("type", Type.class);

        SHAPES_BY_SIZE = new VoxelShape[] {
                Block.box(0, 0, 0, 16, 1, 16),
                Block.box(0, 0, 0, 16, 2, 16),
                Block.box(0, 0, 0, 16, 3, 16),
                Block.box(0, 0, 0, 16, 4, 16),
                Block.box(0, 0, 0, 16, 5, 16),
                Block.box(0, 0, 0, 16, 6, 16),
                Block.box(0, 0, 0, 16, 7, 16),
                Block.box(0, 0, 0, 16, 8, 16),
                Block.box(0, 0, 0, 16, 9, 16),
                Block.box(0, 0, 0, 16, 10, 16),
                Block.box(0, 0, 0, 16, 11, 16),
                Block.box(0, 0, 0, 16, 12, 16),
                Block.box(0, 0, 0, 16, 13, 16),
                Block.box(0, 0, 0, 16, 14, 16),
                Block.box(0, 0, 0, 16, 15, 16),
                Block.box(0, 0, 0, 16, 16, 16),
                Block.box(1, 0, 1, 15, 1, 15),
                Block.box(1, 0, 1, 15, 2, 15),
                Block.box(1, 0, 1, 15, 3, 15),
                Block.box(1, 0, 1, 15, 4, 15),
                Block.box(1, 0, 1, 15, 5, 15),
                Block.box(1, 0, 1, 15, 6, 15),
                Block.box(1, 0, 1, 15, 7, 15),
                Block.box(1, 0, 1, 15, 8, 15),
                Block.box(1, 0, 1, 15, 9, 15),
                Block.box(1, 0, 1, 15, 10, 15),
                Block.box(1, 0, 1, 15, 11, 15),
                Block.box(1, 0, 1, 15, 12, 15),
                Block.box(1, 0, 1, 15, 13, 15),
                Block.box(1, 0, 1, 15, 14, 15),
                Block.box(1, 0, 1, 15, 15, 15),
                Block.box(1, 0, 1, 15, 16, 15)
        };
    }

    public enum Type implements StringRepresentable {
        TIMBER(64, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_timber")),
        TIMBER_CUT(64, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_timber_cut")),

        TIMBER_PANE(16, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_timber_pane")),
        PLATE(16, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_plate")),
        CHAIN_MESH(16, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_mesh_chain")),
        SCALE_MESH(16, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_mesh_scale")),
        SPLINT_MESH(16, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_mesh_splint")),

        BAR(64, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_bar")),
        MOULD(64, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_mould")),
        FIREBRICK(64, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_firebrick")),

        POT(64, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_pot")),

        EMPTY_JUG(32, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_jug_empty")),
        PLANT_OIL_JUG(32, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_jug_plant_oil")),
        WATER_JUG(32, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_jug_water")),
        MILK_JUG(32, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_jug_milk")),

        PLATE_HUGE(8, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_plate_huge")),
        PIE_TRAY(8, ResourceLocation.fromNamespaceAndPath(MOD_ID, "attachment/placed_tray"));

        private final int max;
        private final ResourceLocation modelLocation;

        Type(int max, ResourceLocation location) {
            this.max = max;
            this.modelLocation = location;
        }

        public int getMaxStackSize() {
            return this.max;
        }

        public ResourceLocation getModelLocation() {
            return this.modelLocation;
        }

        public static @Nullable Type getType(ItemStack item) {
            if (item.is(MFRItems.TIMBER))
                return TIMBER;
            else if (item.is(MFRItems.TIMBER_CUT))
                return TIMBER_CUT;
            else if (item.is(MFRItems.TIMBER_PANE))
                return TIMBER_PANE;
            else if (item.is(MFRItems.PLATE))
                return PLATE;
            else if (item.is(MFRItems.CHAIN_MESH))
                return CHAIN_MESH;
            else if (item.is(MFRItems.SCALE_MESH))
                return SCALE_MESH;
            else if (item.is(MFRItems.SPLINT_MESH))
                return SPLINT_MESH;
            else if (item.is(MFRItems.BAR))
                return BAR;
            else if (item.is(MFRItems.INGOT_MOULD))
                return MOULD;
            else if (item.is(MFRItems.FIREBRICK))
                return FIREBRICK;
            else if (item.is(MFRItems.CLAY_POT))
                return POT;
            else if (item.is(MFRItems.PIE_TRAY))
                return PIE_TRAY;
            else if (item.is(MFRItems.EMPTY_JUG))
                return EMPTY_JUG;
            else if (item.is(MFRItems.PLANT_OIL_JUG))
                return PLANT_OIL_JUG;
            else if (item.is(MFRItems.WATER_JUG))
                return WATER_JUG;
            else if (item.is(MFRItems.MILK_JUG))
                return MILK_JUG;
            else if (item.is(MFRItems.PLATE_HUGE))
                return PLATE_HUGE;
            return null;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.name().toLowerCase();
        }
    }
}