package minefantasy.mfr.blockentity;

import minefantasy.mfr.block.StorageComponentBlock;
import minefantasy.mfr.init.MFRBlockEntities;
import minefantasy.mfr.item.component.MaterialDataComponent;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StorageComponentBE extends BlockEntity {
    private ItemStack stack = ItemStack.EMPTY;

    public StorageComponentBE(BlockPos pos, BlockState blockState) {
        super(MFRBlockEntities.STORAGE_COMPONENT.get(), pos, blockState);
    }

    public void setStack(ItemStack stack) {
        this.stack = stack.copyWithCount(1);
    }

    public boolean incrementStack(ServerLevel level, BlockPos pos, BlockState state) {
        StorageComponentBlock.Type type = state.getValue(StorageComponentBlock.TYPE);

        if (this.stack.getCount() >= type.getMaxStackSize())
            return false;

        this.stack.grow(1);
        this.setChanged();
        level.sendBlockUpdated(pos, state, state, Block.UPDATE_CLIENTS);
        return true;
    }

    public void decrementStack(ServerLevel level, BlockPos pos, BlockState state) {
        if (this.stack.getCount() <= 1)
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        else {
            this.stack.shrink(1);
            this.setChanged();
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_CLIENTS);
        }
    }

    public CustomMaterial getMaterial() {
        return CustomMaterialRegistry.getMaterialFor(this.stack, MaterialDataComponent.SLOT_MAIN);
    }

    public boolean hasStack() {
        return this.stack != null;
    }

    public ItemStack getStack() {
        return this.stack.copy();
    }

    public ItemStack getStackWithSize(int size) {
        return this.stack.copyWithCount(size);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag, registries);
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
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
