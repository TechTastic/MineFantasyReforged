package minefantasy.mfr.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class SawItem extends AxeItem {
    public final boolean isCustom;

    public SawItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties);
        this.isCustom = isCustom;
    }
}