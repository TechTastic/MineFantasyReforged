package minefantasy.mfr.init;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.factories.CustomMaterialFactory;
import minefantasy.mfr.registry.types.CustomMaterialType;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class MFRMaterials {
    public static ResourceLocation ANY = ResourceLocation
            .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "any");

    public static ResourceLocation OAK_WOOD = ResourceLocation
            .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "wood/oak");
    public static ResourceLocation IRONBARK_WOOD = ResourceLocation
            .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "wood/ironbark");
    public static ResourceLocation EBONY_WOOD = ResourceLocation
            .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "wood/ebony");

    public static ResourceLocation TIN_METAL = ResourceLocation
            .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/tin");
    public static ResourceLocation IRON_METAL = ResourceLocation
            .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/iron");

    public static final Supplier<CustomMaterial> NONE = () -> new CustomMaterial(
            CustomMaterialTypeRegistry.NONE.get(),
            Ingredient.EMPTY, new int[] {255, 237, 237, 237}, 0, 0,0,0,0,
            0,0, Rarity.COMMON,0, 0, 0, 0f, 0,
            CustomMaterialFactory.ArmorStats.DEFAULT.toArray(), false
    );
}
