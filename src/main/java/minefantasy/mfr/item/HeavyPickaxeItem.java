package minefantasy.mfr.item;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class HeavyPickaxeItem extends PickaxeItem {
    public final boolean isCustom;

    public HeavyPickaxeItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties);
        this.isCustom = isCustom;
    }
}
