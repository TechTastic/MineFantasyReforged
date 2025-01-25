package minefantasy.mfr.api.archery;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;

public interface IArrowHandler {
    /**
     * Fire an Arrow
     *
     * @param entityArrow the Entity of the Arrow, instance of EntityArrowMFR
     * @param arrow       The Itemstack of the Arrow
     * @param bow         The Itemstack of the Bow
     * @param charge      The amount of charge (how fire the bowstring was pulled back)
     * @param player
     * @return the modified EntityArrowMFR
     */
    Arrow onFireArrow(Arrow entityArrow, ItemStack arrow, ItemStack bow, float charge, Player player);
}
