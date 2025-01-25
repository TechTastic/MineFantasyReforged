package minefantasy.mfr.item;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class MFRHoeItem extends HoeItem {
    public final boolean isCustom;

    public MFRHoeItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties);
        this.isCustom = isCustom;
    }
}
