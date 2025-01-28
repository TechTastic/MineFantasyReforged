package minefantasy.mfr.item.color;

import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class OneLayerMaterialItemColor implements ItemColor {
    @Override
    public int getColor(@NotNull ItemStack itemStack, int i) {
        if (i == 0)
            return CustomToolHelper.getColourFromItemStack(itemStack, i);
        return 0xFFFFFFFF;
    }
}
