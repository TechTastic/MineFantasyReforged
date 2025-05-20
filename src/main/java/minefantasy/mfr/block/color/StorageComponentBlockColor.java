package minefantasy.mfr.block.color;

import minefantasy.mfr.blockentity.StorageComponentBE;
import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.item.color.OneLayerMaterialItemColor;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StorageComponentBlockColor implements BlockColor {
    @Override
    public int getColor(@NotNull BlockState blockState, @Nullable BlockAndTintGetter blockAndTintGetter, @Nullable BlockPos blockPos, int i) {
        if (blockAndTintGetter != null && blockPos != null && blockAndTintGetter.getBlockEntity(blockPos) instanceof StorageComponentBE comp)
            return new OneLayerMaterialItemColor().getColor(comp.getStackWithSize(1), 0);
        return CustomMaterialRegistry.getMaterial(MFRMaterials.ANY).getColourInt();
    }
}