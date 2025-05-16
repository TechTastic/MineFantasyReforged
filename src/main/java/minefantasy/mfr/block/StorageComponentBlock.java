package minefantasy.mfr.block;

import minefantasy.mfr.blockentity.StorageComponentBE;
import minefantasy.mfr.init.MFRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StorageComponentBlock extends Block implements EntityBlock {
    public static final EnumProperty<Type> TYPE;
    public static final IntegerProperty STACK_SIZE;

    public StorageComponentBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(TYPE, STACK_SIZE));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new StorageComponentBE(blockPos, blockState);
    }

    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return super.getShape(state, level, pos, context);
    }

    @Override
    public boolean onDestroyedByPlayer(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, boolean willHarvest, @NotNull FluidState fluid) {

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public void onDestroyedByPushReaction(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Direction pushDirection, @NotNull FluidState fluid) {
        super.onDestroyedByPushReaction(state, level, pos, pushDirection, fluid);
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull BlockState state, @NotNull HitResult target, @NotNull LevelReader level, @NotNull BlockPos pos, @NotNull Player player) {
        return super.getCloneItemStack(state, target, level, pos, player);
    }

    @Override
    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return super.getFlammability(state, level, pos, direction);
    }

    @Override
    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        Type type = state.getValue(TYPE);
        return switch (type) {
            case TIMBER, PANE -> true; // Check Pane material for Wood
            default -> false;
        };
    }

    @Override
    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return super.getFireSpreadSpeed(state, level, pos, direction);
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
            case TIMBER, PANE, BAR, PLATE_HUGE -> defaultColor; // Get Material Color from BlockEntity
            case POT, JAR -> MapColor.COLOR_BROWN;
            default -> super.getMapColor(state, level, pos, defaultColor);
        };
    }

    @Override
    public @Nullable PushReaction getPistonPushReaction(@NotNull BlockState state) {
        return PushReaction.DESTROY;
    }

    static {
        TYPE = EnumProperty.create("type", Type.class);
        STACK_SIZE = IntegerProperty.create("stack_size", 1, 64);

        // Shape = Type then Size
        //     TIMBER - 1-64
        //     PANE - 1-16
        //     BAR - 1-64
        //     POT - 1-64
        //     JAR - 1-32
        //     PLATE_HUGE - 1-8
    }

    public enum Type implements StringRepresentable {
        TIMBER(64),
        PANE(16),
        BAR(64),
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
            if (item.is(MFRItems.TIMBER) || item.is(MFRItems.TIMBER_CUT))
                return TIMBER;
            else if (item.is(MFRItems.TIMBER_PANE) || item.is(MFRItems.PLATE) || item.is(MFRItems.CHAIN_MESH) || item.is(MFRItems.SCALE_MESH) || item.is(MFRItems.SPLINT_MESH))
                return PANE;
            else if (item.is(MFRItems.BAR) /* or Firebrick or Mould or Brick */)
                return BAR;
            /*
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
