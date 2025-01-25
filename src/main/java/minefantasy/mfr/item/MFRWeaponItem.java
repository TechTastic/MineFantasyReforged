package minefantasy.mfr.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class MFRWeaponItem extends SwordItem {
    public final boolean isCustom;

    public MFRWeaponItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties);
        this.isCustom = isCustom;
    }
}
