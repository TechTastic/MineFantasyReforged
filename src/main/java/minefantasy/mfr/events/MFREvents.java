package minefantasy.mfr.events;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.item.HandpickItem;
import minefantasy.mfr.item.HeavyPickaxeItem;
import minefantasy.mfr.item.LumberAxeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.ClipContext;
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
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onAOEToolUsage(BlockEvent.BreakEvent event) {
        if (!(event.getLevel() instanceof ServerLevel level))
            return;
        if (!(event.getPlayer() instanceof ServerPlayer player))
            return;
        ItemStack stack = player.getMainHandItem();

        if(stack.getItem() instanceof HeavyPickaxeItem)
            onHeavyPickaxeUsage(level, event.getPos(), stack, player);
        if (stack.getItem() instanceof LumberAxeItem)
            onLumberAxeUsage(level, event.getPos(), stack, player);
    }

    private static void onHeavyPickaxeUsage(ServerLevel level, BlockPos initialBlockPos, ItemStack stack, ServerPlayer player) {
        if (HARVESTED_BLOCKS.contains(initialBlockPos))
            return;

        AABB blocks = getAOEToBeDestroyed(1, initialBlockPos, player);
        if (blocks == null)
            return;

        for (int x = (int) blocks.minX; x < blocks.maxX; x++) {
            for (int y = (int) blocks.minY; y < blocks.maxY; y++) {
                for (int z = (int) blocks.minZ; z < blocks.maxZ; z++) {
                    BlockPos pos = new BlockPos(x, y, z);
                    if(pos.equals(initialBlockPos) || !stack.isCorrectToolForDrops(level.getBlockState(pos)))
                        continue;

                    HARVESTED_BLOCKS.add(pos);
                    player.gameMode.destroyBlock(pos);
                    HARVESTED_BLOCKS.remove(pos);
                }
            }
        }
    }

    private static void onLumberAxeUsage(ServerLevel level, BlockPos initialBlockPos, ItemStack stack, ServerPlayer player) {
        AABB blocks = AABB.ofSize(initialBlockPos.getCenter(), 3, 3, 3);

        for (int x = (int) blocks.minX; x < blocks.maxX; x++) {
            for (int y = (int) blocks.minY; y < blocks.maxY; y++) {
                for (int z = (int) blocks.minZ; z < blocks.maxZ; z++) {
                    BlockPos pos = new BlockPos(x, y, z);
                    if(HARVESTED_BLOCKS.contains(pos) || pos.equals(initialBlockPos) || !stack.isCorrectToolForDrops(level.getBlockState(pos)))
                        continue;

                    HARVESTED_BLOCKS.add(pos);
                    player.gameMode.destroyBlock(pos);
                    HARVESTED_BLOCKS.remove(pos);
                }
            }
        }
    }

    @Nullable
    private static AABB getAOEToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayer player) {
        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(player.getAttributeValue(Attributes.BLOCK_INTERACTION_RANGE)))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        if(traceResult.getType() == HitResult.Type.MISS)
            return null;

        AABB aabb = new AABB(initalBlockPos);

        return switch (traceResult.getDirection()) {
            case DOWN, UP -> aabb.inflate(range, 0, range);
            case NORTH, SOUTH -> aabb.inflate(range, range, 0);
            case EAST, WEST -> aabb.inflate(0, range, range);
        };

        /*return switch (traceResult.getDirection()) {
            case DOWN, UP -> AABB.ofSize(initalBlockPos.getCenter(), range * 2 + .5, 0, range * 2 + .5);
            case NORTH, SOUTH -> AABB.ofSize(initalBlockPos.getCenter(), range * 2 + 1, range * 2 + 1, 0);
            case EAST, WEST -> AABB.ofSize(initalBlockPos.getCenter(), 0, range * 2 + 1, range * 2 + 1);
        };*/
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
