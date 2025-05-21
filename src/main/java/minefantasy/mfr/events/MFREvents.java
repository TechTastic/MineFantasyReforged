package minefantasy.mfr.events;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.item.HandpickItem;
import minefantasy.mfr.item.HeavyPickaxeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.enchanting.GetEnchantmentLevelEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = MineFantasyReforged.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class MFREvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHeavyPickaxeUsage(BlockEvent.BreakEvent event) {
        System.err.println("Event Fired!");

        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HeavyPickaxeItem pickaxe && player instanceof ServerPlayer serverPlayer) {
            System.err.println("Is Heavy Pickaxe Item and ServerPlayer");
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos))
                return;

            AABB blocks = HeavyPickaxeItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer);
            System.err.println("AABB gotten: " + blocks);
            if (blocks == null)
                return;

            for (int x = (int) blocks.minX; x <= blocks.maxX; x++) {
                for (int y = (int) blocks.minY; y <= blocks.maxY; y++) {
                    for (int z = (int) blocks.minZ; z <= blocks.maxZ; z++) {
                        BlockPos pos = new BlockPos(x, y, z);
                        if(pos.equals(initialBlockPos) || !pickaxe.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos)))
                            continue;

                        System.err.println("Harvesting Block At: " + pos);

                        HARVESTED_BLOCKS.add(pos);
                        serverPlayer.gameMode.destroyBlock(pos);
                        HARVESTED_BLOCKS.remove(pos);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onHandpickMine(GetEnchantmentLevelEvent event) {
        Holder<Enchantment> target = event.getTargetEnchant();
        ItemEnchantments.Mutable enchantments = event.getEnchantments();
        if (event.getStack().getItem() instanceof HandpickItem && target != null && event.isTargetting(Enchantments.FORTUNE)) {
            enchantments.set(target, enchantments.getLevel(target) + 1);
        }
    }
}
