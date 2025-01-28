package minefantasy.mfr.init;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.factories.CustomMaterialFactory;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class MFRMaterials {
    public static final ResourceLocation ANY;

    public static final ResourceLocation OAK_WOOD;
    public static final ResourceLocation IRONBARK_WOOD;
    public static final ResourceLocation EBONY_WOOD;

    public static final ResourceLocation TIN_METAL;
    public static final ResourceLocation COPPER_METAL;
    public static final ResourceLocation BRONZE_METAL;
    public static final ResourceLocation IRON_METAL;
    public static final ResourceLocation PIG_IRON_METAL;
    public static final ResourceLocation STEEL_METAL;
    public static final ResourceLocation ENCRUSTED_METAL;
    public static final ResourceLocation OBSIDIAN_METAL;
    public static final ResourceLocation TUNGSTEN_METAL;
    public static final ResourceLocation BLACK_STEEL_METAL;
    public static final ResourceLocation BLUE_STEEL_METAL;
    public static final ResourceLocation RED_STEEL_METAL;
    public static final ResourceLocation SILVER_METAL;
    public static final ResourceLocation GOLD_METAL;
    public static final ResourceLocation MITHRIL_METAL;
    public static final ResourceLocation ADAMANTIUM_METAL;
    public static final ResourceLocation MITHIUM_METAL;
    public static final ResourceLocation IGNOTUMITE_METAL;
    public static final ResourceLocation ENDER_METAL;
    public static final ResourceLocation COMPOSITE_ALLOY_METAL;
    public static final ResourceLocation NETHERITE_METAL;

    public static final Supplier<CustomMaterial> NONE;
    
    static {
        ANY = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "any");

        OAK_WOOD = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "wood/oak");
        IRONBARK_WOOD = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "wood/ironbark");
        EBONY_WOOD = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "wood/ebony");

        TIN_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/tin");
        COPPER_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/copper");
        BRONZE_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/bronze");
        IRON_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/iron");
        PIG_IRON_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/pig_iron");
        STEEL_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/steel");
        ENCRUSTED_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/encrusted");
        OBSIDIAN_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/obsidian");
        TUNGSTEN_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/tungsten");
        BLACK_STEEL_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/black_steel");
        BLUE_STEEL_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/blue_steel");
        RED_STEEL_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/red_steel");
        SILVER_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/silver");
        GOLD_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/gold");
        MITHRIL_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/mithril");
        ADAMANTIUM_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/adamantium");
        MITHIUM_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/mithium");
        IGNOTUMITE_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/ignotumite");
        ENDER_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/ender");
        COMPOSITE_ALLOY_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/composite_alloy");
        NETHERITE_METAL = ResourceLocation
                .fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "metal/netherite");

        NONE = () -> new CustomMaterial(
                CustomMaterialTypeRegistry.NONE.get(),
                Ingredient.EMPTY, new int[] {255, 237, 237, 237}, 0, 0,0,0,0,
                0,0, Rarity.COMMON,0, 0, 0, 0f, 0,
                CustomMaterialFactory.ArmorStats.DEFAULT.toArray(), false
        );
    }
}
