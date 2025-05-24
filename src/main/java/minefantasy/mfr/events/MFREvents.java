package minefantasy.mfr.events;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.item.HandpickItem;
import net.minecraft.core.Holder;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.enchanting.GetEnchantmentLevelEvent;

@EventBusSubscriber(modid = MineFantasyReforged.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class MFREvents {
    @SubscribeEvent
    public static void onHandpickMine(GetEnchantmentLevelEvent event) {
        Holder<Enchantment> target = event.getTargetEnchant();
        ItemEnchantments.Mutable enchantments = event.getEnchantments();
        if (event.getStack().getItem() instanceof HandpickItem && target != null && event.isTargetting(Enchantments.FORTUNE)) {
            enchantments.set(target, enchantments.getLevel(target) + 1);
        }
    }
}
