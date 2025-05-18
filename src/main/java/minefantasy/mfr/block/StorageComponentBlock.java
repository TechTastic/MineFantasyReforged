package minefantasy.mfr.block;

import minefantasy.mfr.blockentity.StorageComponentBE;
import minefantasy.mfr.init.MFRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StorageComponentBlock extends Block implements EntityBlock {
    public static final EnumProperty<Type> TYPE;
    public static final IntegerProperty SIZE;

    public StorageComponentBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(TYPE, SIZE));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new StorageComponentBE(blockPos, blockState);
    }

    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        // Per Type, per Stack Size
        Type type = state.getValue(TYPE);
        int size = state.getValue(SIZE);
        //return switch (type) {
        //    case TIMBER, TIMBER_CUT ->
        //};

        return super.getShape(state, level, pos, context);
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
        // Get from Block Entity
        return super.getCloneItemStack(state, target, level, pos, player);
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
            case POT, JAR, MOULD -> MapColor.COLOR_BROWN;
            case FIREBRICK, BRICK -> MapColor.TERRACOTTA_BROWN;
            default -> super.getMapColor(state, level, pos, defaultColor);
        };
    }

    @Override
    public @Nullable PushReaction getPistonPushReaction(@NotNull BlockState state) {
        return PushReaction.DESTROY;
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level,
            @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        Type type = state.getValue(TYPE);
        BlockEntity be = level.getBlockEntity(pos);

        if (level.isClientSide || type != Type.getType(stack) || !(be instanceof StorageComponentBE comp) || !comp.incrementStack((ServerLevel) level, pos, state))
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);

        stack.shrink(1);
        return ItemInteractionResult.CONSUME;
    }

    static {
        TYPE = EnumProperty.create("type", Type.class);
        SIZE = IntegerProperty.create("stack_size", 1, 64);
    }

    public enum Type implements StringRepresentable {
        TIMBER(64),
        TIMBER_CUT(64),

        TIMBER_PANE(16),
        PLATE(16),
        CHAIN_MESH(16),
        SCALE_MESH(16),
        SPLINT_MESH(16),

        BAR(64),
        MOULD(64),
        BRICK(64),
        FIREBRICK(64),

        POT(64),
        JAR(32),
        PLATE_HUGE(8);

        private final int max;

        Type(int max) {
            this.max = max;
        }

        public int getMaxStackSize() {
            return this.max;
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
            /*
            else if (item.is(MFRItems.MOULD))
                return MOULD;
            else if (item.is(MFRItems.FIREBRICK))
                return FIREBRICK;
            else if (item.is(MFRItems.BRICK))
                return BRICK;
            else if (item.is(MFRItems.CLAY_POT))
                return POT;
             */
            else if (item.is(MFRItems.PLATE_HUGE))
                return PLATE_HUGE;
            return null;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.name();
        }
    }
}
