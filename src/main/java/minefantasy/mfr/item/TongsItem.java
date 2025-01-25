package minefantasy.mfr.item;

import minefantasy.mfr.init.MFRDataComponents;
import minefantasy.mfr.item.component.MaterialDataComponent;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;

public class TongsItem extends TieredItem {
    public final boolean isCustom;

    public TongsItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties.stacksTo(1)
                .component(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE, MaterialDataComponent.TOOL_DEFAULT)
        );
        this.isCustom = isCustom;
    }
}
