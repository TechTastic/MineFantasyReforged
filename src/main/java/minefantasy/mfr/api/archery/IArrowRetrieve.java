package minefantasy.mfr.api.archery;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;

public interface IArrowRetrieve {
    /**
     * Gets if the arrow will be dropped by a killed mob (this pretty much connects
     * to the canBePickedUp variable)
     * @return True if the arrow can be picked up
     */
    AbstractArrow.Pickup canBePickedUp();

    /**
     * Gets the item dropped when the enemy is killed (the arrow item used)
     * @return Itemstack of the arrow
     */
    ItemStack getDroppedItem();
}
