package minefantasy.mfr.item;

import minefantasy.mfr.api.tier.IToolMaterial;
import minefantasy.mfr.api.tool.IToolMFR;
import minefantasy.mfr.api.weapon.IDamageType;
import minefantasy.mfr.constants.Tool;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

public class BasicCraftToolItem extends TieredItem implements IToolMaterial, IToolMFR, IDamageType {
    private final int tier;
    private final Tool toolType;
    public final boolean isCustom;

    public BasicCraftToolItem(Tool type, int tier, Properties properties, boolean isCustom) {
        super(Tiers.WOOD, properties);
        this.tier = tier;
        this.toolType = type;
        this.isCustom = isCustom;
    }

    @Override
    public @NotNull Component getName(ItemStack item) {
        String unlocalName = super.getDescriptionId(item);
        return CustomToolHelper.getLocalisedName(item, unlocalName);
    }

    @Override
    public Tier getMaterial() {
        return this.getTier();
    }

    @Override
    public float getEfficiencyModifier() {
        return 1f;
    }

    @Override
    public ItemStack construct(ResourceLocation main, ResourceLocation haft) {
        return CustomToolHelper.construct(this, main, haft);
    }

    @Override
    public float getEfficiency(ItemStack item) {
        return CustomToolHelper.getEfficiencyForHds(item, getMaterial().getSpeed(), getEfficiencyModifier());
    }

    @Override
    public int getTier(ItemStack item) {
        return CustomToolHelper.getCrafterTier(item, this.tier);
    }

    @Override
    public Tool getToolType(ItemStack stack) {
        return this.toolType;
    }

    @Override
    public float[] getDamageRatio(Object... implement) {
        return new float[] {0, 1, 0};
    }

    @Override
    public float getPenetrationLevel(Object implement) {
        return 0;
    }
}
