package minefantasy.mfr.item;

import minefantasy.mfr.api.tier.IToolMaterial;
import minefantasy.mfr.api.tool.IToolMFR;
import minefantasy.mfr.api.weapon.IDamageType;
import minefantasy.mfr.constants.Tool;
import minefantasy.mfr.init.MFRDataComponents;
import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.item.component.MaterialDataComponent;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HammerItem extends TieredItem implements IToolMaterial, IToolMFR, IDamageType {
    public final boolean heavy;
    public final int craftTier;
    public final float efficiencyModifier;
    public final boolean isCustom;

    public HammerItem(Tier tier, boolean heavy, int craftTier, Properties properties, float efficiencyModifier, boolean isCustom) {
        super(tier, properties.component(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE, MaterialDataComponent.TOOL_DEFAULT)
        );
        this.heavy = heavy;
        this.craftTier = craftTier;
        this.isCustom = isCustom;
        this.efficiencyModifier = efficiencyModifier;
    }

    @Override
    public Tier getMaterial() {
        return this.getTier();
    }

    @Override
    public float getEfficiencyModifier() {
        return this.efficiencyModifier;
    }

    @Override
    public ItemStack construct(ResourceLocation main, ResourceLocation haft) {
        return CustomToolHelper.construct(this, main, haft);
    }

    @Override
    public float getEfficiency(ItemStack item) {
        return CustomToolHelper.getEfficiency(item, getMaterial().getSpeed(), getEfficiencyModifier());
    }

    @Override
    public int getTier(ItemStack item) {
        return this.craftTier;
    }

    @Override
    public Tool getToolType(ItemStack stack) {
        return heavy ? Tool.HEAVY_HAMMER : Tool.HAMMER;
    }

    @Override
    public float[] getDamageRatio(Object... implement) {
        return new float[] {0, 1, 0};
    }

    @Override
    public float getPenetrationLevel(Object implement) {
        return 0;
    }

    @Override
    public int getMaxDamage(@NotNull ItemStack stack) {
        return CustomToolHelper.getMaxDamage(stack, super.getMaxDamage(stack));
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue(@NotNull ItemStack stack) {
        return CustomToolHelper.getCustomPrimaryMaterial(stack).getEnchantability();
    }

    @Override
    public @NotNull ItemAttributeModifiers getDefaultAttributeModifiers(@NotNull ItemStack stack) {
        return super.getDefaultAttributeModifiers(stack)
                .withModifierAdded(Attributes.ATTACK_DAMAGE, new AttributeModifier(
                                Item.BASE_ATTACK_DAMAGE_ID, CustomToolHelper.getMeleeDamage(stack,
                                getMaterial().getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .withModifierAdded(Attributes.ATTACK_SPEED, new AttributeModifier(
                                Item.BASE_ATTACK_SPEED_ID, -3f, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (isCustom)
            CustomToolHelper.addInformation(stack, tooltipComponents);

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
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
