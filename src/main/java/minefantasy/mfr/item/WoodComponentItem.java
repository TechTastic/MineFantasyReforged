package minefantasy.mfr.item;

import minefantasy.mfr.init.MFRDataComponents;
import minefantasy.mfr.item.component.MaterialDataComponent;
import minefantasy.mfr.registry.types.CustomMaterialType;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class WoodComponentItem extends MFRComponentItem {
    public WoodComponentItem(Properties properties) {
        super(properties.component(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE.get(), MaterialDataComponent.ITEM_DEFAULT), true);
    }

    @Override
    public CustomMaterialType getMaterialType(ItemStack item) {
        return CustomMaterialTypeRegistry.WOOD_TYPES.get();
    }

    public ItemStack construct(ResourceLocation material) {
        return CustomToolHelper.construct(this, material);
    }
}
