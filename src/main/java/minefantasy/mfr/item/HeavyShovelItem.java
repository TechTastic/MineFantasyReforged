package minefantasy.mfr.item;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class HeavyShovelItem extends ShovelItem {
    public final boolean isCustom;

    public HeavyShovelItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties);
        this.isCustom = isCustom;
    }
}
