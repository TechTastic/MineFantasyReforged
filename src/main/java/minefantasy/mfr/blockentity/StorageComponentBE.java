package minefantasy.mfr.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class StorageComponentBE extends BlockEntity {
    public StorageComponentBE(BlockPos pos, BlockState blockState) {
        super(null, pos, blockState);
    }
}
