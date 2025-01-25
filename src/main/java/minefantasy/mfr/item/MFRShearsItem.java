package minefantasy.mfr.item;

import net.minecraft.world.item.ShearsItem;

public class MFRShearsItem extends ShearsItem {
    public final boolean isCustom;

    public MFRShearsItem(Properties properties, boolean isCustom) {
        super(properties);
        this.isCustom = isCustom;
    }
}
