package minefantasy.mfr.api.tier;

import minefantasy.mfr.init.MFRMaterials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public interface IToolMaterial {
    /**
     * Gets the material for outside reference
     */
    Tier getMaterial();

    /**
     * Constructs the given item with the given main and haft materials
     */
    ItemStack construct(ResourceLocation main, ResourceLocation haft);

    /**
     * Constructs the given item with the given main material
     */
    default ItemStack construct(ResourceLocation main) {
        return construct(main, MFRMaterials.OAK_WOOD);
    }
}
