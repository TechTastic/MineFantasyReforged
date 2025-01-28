package minefantasy.mfr.item;

import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

public class MFRAxeItem extends AxeItem {
    public final boolean isCustom;

    public MFRAxeItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties);
        this.isCustom = isCustom;
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        String unlocalName = super.getDescriptionId(stack);
        return CustomToolHelper.getLocalisedName(stack, unlocalName);
    }
}