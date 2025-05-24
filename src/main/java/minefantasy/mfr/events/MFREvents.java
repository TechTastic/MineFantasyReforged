package minefantasy.mfr.events;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.item.HandpickItem;
import minefantasy.mfr.item.HeavyPickaxeItem;
import minefantasy.mfr.item.LumberAxeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.enchanting.GetEnchantmentLevelEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

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
