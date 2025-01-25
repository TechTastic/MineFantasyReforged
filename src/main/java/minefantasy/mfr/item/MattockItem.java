package minefantasy.mfr.item;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class MattockItem extends PickaxeItem {
    public final boolean isCustom;

    public MattockItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties);
        this.isCustom = isCustom;
    }
}
