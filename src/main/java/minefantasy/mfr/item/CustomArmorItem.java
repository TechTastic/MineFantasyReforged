package minefantasy.mfr.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;

public class CustomArmorItem extends MFRArmorItem {
    public CustomArmorItem(/*Holder<ArmorMaterial> material, Type type,*/ Properties properties) {
        // TODO: Temporary
        super(ArmorMaterials.DIAMOND, net.minecraft.world.item.ArmorItem.Type.CHESTPLATE, properties);
    }
}
