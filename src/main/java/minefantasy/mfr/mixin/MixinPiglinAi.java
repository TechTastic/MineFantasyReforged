package minefantasy.mfr.mixin;

import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinAi.class)
public class MixinPiglinAi {
    @Inject(method = "isLovedItem", at = @At("RETURN"), cancellable = true)
    private static void mfr$isItemGold(ItemStack item, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            cir.setReturnValue(CustomToolHelper.getCustomPrimaryMaterial(item).getName().equals(MFRMaterials.GOLD_METAL));
        }
    }
}
