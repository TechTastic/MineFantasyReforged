package minefantasy.mfr.item;

import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import org.jetbrains.annotations.NotNull;

public class MFRShearsItem extends ShearsItem {
    public final boolean isCustom;

    public MFRShearsItem(Properties properties, boolean isCustom) {
        super(properties);
        this.isCustom = isCustom;
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        String unlocalName = super.getDescriptionId(stack);
        return CustomToolHelper.getLocalisedName(stack, unlocalName);
    }
}
