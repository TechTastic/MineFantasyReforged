package minefantasy.mfr.item;

import minefantasy.mfr.api.crafting.ITieredComponent;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class MFRComponentItem extends Item implements ITieredComponent {
    private final boolean isCustom;

    public MFRComponentItem(Properties properties, boolean isCustom) {
        super(properties);
        this.isCustom = isCustom;
    }

    public MFRComponentItem(Properties properties) {
        this(properties, false);
    }

    @Override
    public void verifyComponentsAfterLoad(ItemStack itemStack) {
        super.verifyComponentsAfterLoad(itemStack);

        Rarity rarity = itemStack.get(DataComponents.RARITY);
        if (rarity == null)
            rarity = Rarity.COMMON;
        itemStack.set(DataComponents.RARITY, CustomToolHelper.getRarity(CustomMaterialRegistry.ACCESS, itemStack, rarity));
    }

    public boolean canDamage() {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        if (isCustom)
            CustomToolHelper.addComponentString(list, CustomToolHelper.getCustomPrimaryMaterial(CustomMaterialRegistry.ACCESS, itemStack));
    }

    @Override
    public @NotNull Component getName(ItemStack itemStack) {
        if (isCustom)
			return CustomToolHelper.getLocalisedName(CustomMaterialRegistry.ACCESS, itemStack, "item.commodity_" + BuiltInRegistries.ITEM.getKey(this).getPath() + ".name");

        String unlocalizedName = super.getDescriptionId(itemStack);
		return CustomToolHelper.getLocalisedName(CustomMaterialRegistry.ACCESS, itemStack, unlocalizedName);
    }
}
