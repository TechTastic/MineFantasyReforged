package minefantasy.mfr.block;

import minefantasy.mfr.init.MFRBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FlammableRotatedPillarBlock extends RotatedPillarBlock {
    public FlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(@NotNull BlockState state, UseOnContext context, @NotNull ItemAbility itemAbility, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(MFRBlocks.YEW_LOG))
                return MFRBlocks.STRIPPED_YEW_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            if (state.is(MFRBlocks.YEW_WOOD))
                return MFRBlocks.STRIPPED_YEW_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            if (state.is(MFRBlocks.IRONBARK_LOG))
                return MFRBlocks.STRIPPED_IRONBARK_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            if (state.is(MFRBlocks.IRONBARK_WOOD))
                return MFRBlocks.STRIPPED_IRONBARK_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            if (state.is(MFRBlocks.EBONY_LOG))
                return MFRBlocks.STRIPPED_EBONY_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            if (state.is(MFRBlocks.EBONY_WOOD))
                return MFRBlocks.STRIPPED_EBONY_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
