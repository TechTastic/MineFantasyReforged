package minefantasy.mfr.item;

import minefantasy.mfr.api.tier.IToolMaterial;
import minefantasy.mfr.api.tool.IToolMFR;
import minefantasy.mfr.api.weapon.IDamageType;
import minefantasy.mfr.constants.Tool;
import minefantasy.mfr.init.MFRDataComponents;
import minefantasy.mfr.init.MFRTags;
import minefantasy.mfr.item.component.MaterialDataComponent;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.core.component.DataComponents;
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
    public final boolean isCustom;

    public HammerItem(Tier tier, boolean heavy, int craftTier, Properties properties, boolean isCustom) {
        super(tier, properties.stacksTo(1)
                .component(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE, MaterialDataComponent.TOOL_DEFAULT)
        );
        this.heavy = heavy;
        this.craftTier = craftTier;
        this.isCustom = isCustom;
    }

    @Override
    public Tier getMaterial() {
        return this.getTier();
    }

    @Override
    public float getEfficiency(ItemStack item) {
        return 0;
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
    public int getMaxDamage(ItemStack stack) {
        return CustomToolHelper.getMaxDamage(CustomMaterialRegistry.ACCESS, stack, super.getMaxDamage(stack));
    }

    @Override
    public void verifyComponentsAfterLoad(@NotNull ItemStack itemStack) {
        super.verifyComponentsAfterLoad(itemStack);

        ItemAttributeModifiers modifiers = itemStack.get(DataComponents.ATTRIBUTE_MODIFIERS);
        if (modifiers != null) {
            itemStack.set(DataComponents.ATTRIBUTE_MODIFIERS, modifiers
                    .withModifierAdded(Attributes.ATTACK_DAMAGE, new AttributeModifier(
                            BASE_ATTACK_DAMAGE_ID, CustomToolHelper.getMeleeDamage(CustomMaterialRegistry.ACCESS, itemStack,
                                    getMaterial().getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND)

                    .withModifierAdded(Attributes.ATTACK_SPEED, new AttributeModifier(
                            BASE_ATTACK_SPEED_ID, -3f, AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND)

                    .withModifierAdded(Attributes.MINING_EFFICIENCY, new AttributeModifier(
                            ResourceLocation.withDefaultNamespace("mining_efficiency"), CustomToolHelper
                            .getEfficiency(CustomMaterialRegistry.ACCESS, itemStack, getMaterial().getSpeed(),
                                    1.0F), AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND));
        }

        net.minecraft.world.item.component.Tool tool = new net.minecraft.world.item.component.Tool(List.of(
                net.minecraft.world.item.component.Tool.Rule.deniesDrops(getMaterial().getIncorrectBlocksForDrops()),
                net.minecraft.world.item.component.Tool.Rule.minesAndDrops(MFRTags.Blocks.MINEABLE_WITH_HAMMER,
                        CustomToolHelper.getEfficiency(CustomMaterialRegistry.ACCESS, itemStack, getMaterial().getSpeed(),
                                1.0F / 2f))),
                getMaterial().getSpeed(), 1);

        if (isCustom) {
            tool = CustomToolHelper.getCustomPrimaryMaterial(CustomMaterialRegistry.ACCESS, itemStack)
                    .getToolTier().createToolProperties(MFRTags.Blocks.MINEABLE_WITH_HAMMER);
        }

        itemStack.set(DataComponents.TOOL, tool);
    }

    protected float getWeightModifier(ItemStack stack) {
        return CustomToolHelper.getWeightModifier(CustomMaterialRegistry.ACCESS, stack, 1.0F);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return CustomToolHelper.getCustomPrimaryMaterial(CustomMaterialRegistry.ACCESS, stack).getEnchantability();
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (isCustom)
            CustomToolHelper.addInformation(CustomMaterialRegistry.ACCESS, stack, tooltipComponents);

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public Component getName(ItemStack stack) {
        String unlocalName = super.getDescriptionId(stack);
        return CustomToolHelper.getLocalisedName(CustomMaterialRegistry.ACCESS, stack, unlocalName);
    }
}
