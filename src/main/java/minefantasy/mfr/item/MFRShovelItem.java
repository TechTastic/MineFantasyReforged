package minefantasy.mfr.item;

import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

public class MFRShovelItem extends ShovelItem {
    public final boolean isCustom;

    public MFRShovelItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties);
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
