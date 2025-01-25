package minefantasy.mfr.item.color;

import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TwoLayerMaterialItemColor implements ItemColor {
    @Override
    public int getColor(@NotNull ItemStack itemStack, int i) {
        return CustomToolHelper.getColourFromItemStack(CustomMaterialRegistry.ACCESS, itemStack, i);
    }
}
