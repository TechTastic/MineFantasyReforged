package minefantasy.mfr.blockentity;

import minefantasy.mfr.init.MFRBlockEntities;
import minefantasy.mfr.item.component.MaterialDataComponent;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class StorageComponentBE extends BlockEntity {
    private ItemStack stack;

    public StorageComponentBE(BlockPos pos, BlockState blockState) {
        super(MFRBlockEntities.STORAGE_COMPONENT.get(), pos, blockState);
    }

    public void setStack(ItemStack stack) {
        this.stack = stack.copyWithCount(1);
    }

    public CustomMaterial getMaterial() {
        return CustomMaterialRegistry.getMaterialFor(this.stack, MaterialDataComponent.SLOT_MAIN);
    }

    public ItemStack getStackWithSize(int size) {
        return this.stack.copyWithCount(size);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        tag.put("stack", this.stack.save(registries));

        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(tag, registries);

        this.stack = ItemStack.parse(registries, tag.getCompound("stack")).orElse(ItemStack.EMPTY);
    }
}
