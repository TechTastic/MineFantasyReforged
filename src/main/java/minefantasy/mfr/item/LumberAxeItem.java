package minefantasy.mfr.item;

import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LumberAxeItem extends MFRAxeItem {
    public LumberAxeItem(Tier tier, Properties properties, boolean isCustom) {
        super(tier, properties, 1f, isCustom);
    }

    @Override
    public ItemStack construct(ResourceLocation main, ResourceLocation haft) {
        ItemStack stack = super.construct(main, haft);

        CustomMaterial material = CustomMaterialRegistry.getMaterial(main);
        float efficiency = material.getHardness() > 0 ? material.getHardness() : this.getMaterial().getSpeed();

        stack.set(DataComponents.TOOL, new Tool(List.of(
                Tool.Rule.deniesDrops(material.getOrCreateIncorrectBlocksTag()),
                Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_AXE, CustomToolHelper
                        .getEfficiency(stack, efficiency,
                                getEfficiencyModifier() / 8))
        ), 1f, 1));

        return stack;
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack stack, @NotNull Level level, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity miningEntity) {
        if (level.isClientSide || !stack.isCorrectToolForDrops(level.getBlockState(pos)))
            return super.mineBlock(stack, level, state, pos, miningEntity);

        ConcurrentLinkedQueue<BlockPos> queue = new ConcurrentLinkedQueue<>();
        List<BlockPos> visited = new ArrayList<>();
        queue.add(pos);

        while (!queue.isEmpty()) {
            BlockPos center = queue.poll();
            visited.add(center);

            AABB blocks = AABB.ofSize(center.getCenter(), 3, 3, 3);
            for (int x = (int) blocks.minX; x < blocks.maxX; x++) {
                for (int y = (int) blocks.minY; y < blocks.maxY; y++) {
                    for (int z = (int) blocks.minZ; z < blocks.maxZ; z++) {
                        BlockPos newPos = new BlockPos(x, y, z);
                        if (visited.contains(newPos) || !stack.isCorrectToolForDrops(level.getBlockState(newPos)))
                            continue;

                        queue.add(newPos);
                        super.mineBlock(stack, level, level.getBlockState(center), center, miningEntity);
                        level.destroyBlock(newPos, true, miningEntity);
                    }
                }
            }
        }

        return super.mineBlock(stack, level, state, pos, miningEntity);
    }

    @Override
    public int getMaxDamage(@NotNull ItemStack stack) {
        return super.getMaxDamage(stack) * 5;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (isCustom)
            CustomToolHelper.addInformation(stack, tooltipComponents);

        CustomMaterial mat = CustomToolHelper.getCustomPrimaryMaterial(stack);
        float efficiency = mat.getHardness() > 0 ? mat.getHardness() : 1f;
        tooltipComponents.add(Component.translatable("attribute.tool.digEfficiency.name",
                CustomMaterialRegistry.DECIMAL_FORMAT.format(CustomToolHelper
                        .getEfficiency(stack, efficiency, this.getEfficiencyModifier() / 8f))).withStyle(ChatFormatting.GREEN));
    }
}