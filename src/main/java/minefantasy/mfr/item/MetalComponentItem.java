package minefantasy.mfr.item;

import minefantasy.mfr.init.MFRDataComponents;
import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.item.component.MaterialDataComponent;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.registry.types.CustomMaterialType;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MetalComponentItem extends MFRComponentItem {
    private final float mass;

    public MetalComponentItem(Properties properties, float mass) {
        super(properties.component(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE.get(), MaterialDataComponent.ITEM_DEFAULT));
        this.mass = mass;
    }

    @Override
    public CustomMaterialType getMaterialType(ItemStack item) {
        return CustomMaterialTypeRegistry.METAL_TYPES.get();
    }

    public float getWeightInKg(ItemStack tool) {
        CustomMaterial base = getBase(tool);
        if (base != MFRMaterials.NONE.get()) {
            return base.getDensity() * mass;
        }
        return mass;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);

        if (!canDamage()) {
			CustomToolHelper.addComponentString(list, getBase(itemStack), mass);
		}
        // TODO: EntityCogwork
		/*if (this == MineFantasyItems.COGWORK_ARMOUR) {
			int AR = EntityCogwork.getArmourRating(getBase(tool));
			list.add(I18n.format("attribute.armour.protection") + " " + AR);
			if (mass > 0)
				list.add(CustomMaterialRegistry.getWeightString(getWeightInKg(tool)));
		}*/
    }

    @Override
    public @NotNull Component getName(ItemStack itemStack) {
        return CustomToolHelper.getLocalisedName(itemStack,
                "item.commodity_" + BuiltInRegistries.ITEM.getKey(this).getPath() + ".name");
    }

    public CustomMaterial getBase(ItemStack component) {
        return CustomToolHelper.getCustomPrimaryMaterial(component);
    }

    @OnlyIn(Dist.CLIENT)
    public ItemStack createComponentItemStack(ResourceLocation base) {
        return createComponentItemStack(base, 1);
    }

    @OnlyIn(Dist.CLIENT)
    public ItemStack createComponentItemStack(ResourceLocation base, int stack) {
        ItemStack item = new ItemStack(this, stack);
        CustomMaterialRegistry.addMaterial(item, MaterialDataComponent.SLOT_MAIN, base);
        return item;
    }

    @Override
    public boolean isPiglinCurrency(@NotNull ItemStack stack) {
        return CustomToolHelper.getCustomPrimaryMaterial(stack).getName().equals(MFRMaterials.GOLD_METAL);
    }
}
