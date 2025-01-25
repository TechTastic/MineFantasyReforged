package minefantasy.mfr.api.weapon;

import net.minecraft.world.item.ItemStack;

public interface ISharpenable {
    /**
     * The max amount of uses of sharpness -1 means can't be sharpened
     */
    float getMaxSharpness(ItemStack item);

    /**
     * The max percent that it can increase damage
     */
    float getDamagePercentMax(ItemStack item);

    /**
     * The modifier for how much percent is added each use
     */
    float getSharpUsesModifier(ItemStack item);
}
