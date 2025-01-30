package minefantasy.mfr.item;

import minefantasy.mfr.init.MFRDataComponents;
import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.item.component.MaterialDataComponent;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import org.jetbrains.annotations.NotNull;

public class TongsItem extends TieredItem {
    public final boolean isCustom;

    public TongsItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties.stacksTo(1)
                .component(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE, MaterialDataComponent.TOOL_DEFAULT)
        );
        this.isCustom = isCustom;
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        String unlocalName = super.getDescriptionId(stack);
        return CustomToolHelper.getLocalisedName(stack, unlocalName);
    }

    @Override
    public boolean isPiglinCurrency(@NotNull ItemStack stack) {
        return CustomToolHelper.getCustomPrimaryMaterial(stack).getName().equals(MFRMaterials.GOLD_METAL);
    }
}
