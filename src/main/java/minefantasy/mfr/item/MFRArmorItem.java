package minefantasy.mfr.item;

import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class MFRArmorItem extends ArmorItem {
    public MFRArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        String unlocalName = super.getDescriptionId(stack);
        return CustomToolHelper.getLocalisedName(stack, unlocalName);
    }

    @Override
    public boolean isPiglinCurrency(@NotNull ItemStack stack) {
        return CustomToolHelper.getCustomPrimaryMaterial(stack).getName().equals(MFRMaterials.GOLD_METAL);
    }

    @Override
    public boolean makesPiglinsNeutral(@NotNull ItemStack stack, @NotNull LivingEntity wearer) {
        return CustomToolHelper.getCustomPrimaryMaterial(stack).getName().equals(MFRMaterials.GOLD_METAL);
    }
}
