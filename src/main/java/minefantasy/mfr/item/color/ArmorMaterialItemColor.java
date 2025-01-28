package minefantasy.mfr.item.color;

import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ArmorMaterialItemColor implements ItemColor {
    @Override
    public int getColor(@NotNull ItemStack itemStack, int i) {
        if (i == 0) {
            /*if (stack.getItem() instanceof ItemArmourMFR) {
                ItemArmourMFR itemArmourMFR = (ItemArmourMFR) stack.getItem();
                if (itemArmourMFR.hasColor(stack)) {
                    return itemArmourMFR.getColor(stack);
                } else {
                    return CustomToolHelper.getColourFromItemStack(stack, tintIndex);
                }
            }*/
            return CustomToolHelper.getColourFromItemStack(itemStack, i);
        }
        return 0xFFFFFFFF;
    }
}
