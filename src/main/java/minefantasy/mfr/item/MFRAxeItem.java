package minefantasy.mfr.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class MFRAxeItem extends AxeItem {
    public final boolean isCustom;

    public MFRAxeItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties);
        this.isCustom = isCustom;
    }
}