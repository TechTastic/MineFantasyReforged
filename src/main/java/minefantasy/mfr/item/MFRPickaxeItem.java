package minefantasy.mfr.item;

import minefantasy.mfr.api.tier.IToolMaterial;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MFRPickaxeItem extends PickaxeItem implements IToolMaterial {
    public final float efficiencyModifier;
    public final boolean isCustom;

    public MFRPickaxeItem(Tier tier, Properties properties, float efficiencyModifier, boolean isCustom) {
        super(tier, properties);
        this.efficiencyModifier = efficiencyModifier;
        this.isCustom = isCustom;
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
        ItemStack stack = CustomToolHelper.construct(this, main, haft);

        CustomMaterial material = CustomMaterialRegistry.getMaterial(main);
        float efficiency = material.getHardness() > 0 ? material.getHardness() : this.getMaterial().getSpeed();

        stack.set(DataComponents.TOOL, new Tool(List.of(
                Tool.Rule.deniesDrops(material.getOrCreateIncorrectBlocksTag()),
                Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_PICKAXE, CustomToolHelper
                        .getEfficiency(stack, efficiency,
                                getEfficiencyModifier() / 2))
        ), 1f, 1));

        return stack;
    }

    @Override
    public @NotNull ItemAttributeModifiers getDefaultAttributeModifiers(@NotNull ItemStack stack) {
        return super.getDefaultAttributeModifiers(stack)
                .withModifierAdded(Attributes.ATTACK_DAMAGE, new AttributeModifier(
                                Item.BASE_ATTACK_DAMAGE_ID, 2f, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND)
                .withModifierAdded(Attributes.ATTACK_SPEED, new AttributeModifier(
                                Item.BASE_ATTACK_SPEED_ID, -2.8f, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        // TODO: Inform player about mine-ability of block
        return super.useOn(context);
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
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (isCustom)
            CustomToolHelper.addInformation(stack, tooltipComponents);

        CustomMaterial mat = CustomToolHelper.getCustomPrimaryMaterial(stack);
        float efficiency = mat.getHardness() > 0 ? mat.getHardness() : 1f;
        tooltipComponents.add(Component.translatable("attribute.tool.digEfficiency.name",
                CustomMaterialRegistry.DECIMAL_FORMAT.format(CustomToolHelper
                        .getEfficiency(stack, efficiency, 0.5f))).withStyle(ChatFormatting.GREEN));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        String unlocalName = this.getDescriptionId(stack);
        return CustomToolHelper.getLocalisedName(stack, unlocalName);
    }
}
