package minefantasy.mfr.item;

import minefantasy.mfr.api.tier.IToolMaterial;
import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class HeavyPickaxeItem extends PickaxeItem implements IToolMaterial {
    public final float efficiencyModifier;
    public final boolean isCustom;

    public HeavyPickaxeItem(Tier tier, Properties properties, float efficiencyModifier, boolean isCustom) {
        super(tier, properties);
        this.efficiencyModifier = efficiencyModifier;
        this.isCustom = isCustom;
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        String unlocalName = super.getDescriptionId(stack);
        return CustomToolHelper.getLocalisedName(stack, unlocalName);
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
                                getEfficiencyModifier() / 8))
        ), 1f, 1));

        return stack;
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

    @Nullable
    public static AABB getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayer player) {
        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        if(traceResult.getType() == HitResult.Type.MISS)
            return null;

        return switch (traceResult.getDirection()) {
            case DOWN, UP -> AABB.ofSize(initalBlockPos.getCenter(), range * 2 + 1, .5, range * 2 + 1);
            case NORTH, SOUTH -> AABB.ofSize(initalBlockPos.getCenter(), range * 2 + 1, range * 2 + 1, .5);
            case EAST, WEST -> AABB.ofSize(initalBlockPos.getCenter(), .5, range * 2 + 1, range * 2 + 1);
        };
    }

    @Override
    public boolean isPiglinCurrency(@NotNull ItemStack stack) {
        return CustomToolHelper.getCustomPrimaryMaterial(stack).getName().equals(MFRMaterials.GOLD_METAL);
    }
}
