package minefantasy.mfr.item;

import minefantasy.mfr.api.crafting.ITieredComponent;
import minefantasy.mfr.block.StorageComponentBlock;
import minefantasy.mfr.blockentity.StorageComponentBE;
import minefantasy.mfr.init.MFRBlocks;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class MFRComponentItem extends BlockItem implements ITieredComponent {
    private final boolean isCustom;

    public MFRComponentItem(Properties properties, boolean isCustom) {
        super(MFRBlocks.STORAGE_COMPONENT.get(), properties);
        this.isCustom = isCustom;
    }

    public MFRComponentItem(Properties properties) {
        this(properties, false);
    }

    public boolean canDamage() {
        return false;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        if (isCustom)
            CustomToolHelper.addComponentString(list, CustomToolHelper.getCustomPrimaryMaterial(itemStack));
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack itemStack) {
        if (isCustom)
			return CustomToolHelper.getLocalisedName(itemStack, "item.commodity_" + BuiltInRegistries.ITEM.getKey(this).getPath() + ".name");

        String unlocalizedName = super.getDescriptionId(itemStack);
		return CustomToolHelper.getLocalisedName(itemStack, unlocalizedName);
    }

    @Override
    protected boolean canPlace(@NotNull BlockPlaceContext context, @NotNull BlockState state) {
        StorageComponentBlock.Type type = StorageComponentBlock.Type.getType(context.getItemInHand());
        if (type == null) return false;

        state.setValue(StorageComponentBlock.TYPE, type);

        return super.canPlace(context, state);
    }
}
