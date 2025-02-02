package minefantasy.mfr.init;

import minefantasy.mfr.MineFantasyReforged;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class MFRTags {

    public static class Blocks {
        public static TagKey<Block> YEW_LOGS = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "yew_logs"));
        public static TagKey<Block> IRONBARK_LOGS = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ironbark_logs"));
        public static TagKey<Block> EBONY_LOGS = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ebony_logs"));


        public static TagKey<Block> INCORRECT_FOR_TIN_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_tin_tool"));
        public static TagKey<Block> INCORRECT_FOR_COPPER_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_copper_tool"));
        public static TagKey<Block> INCORRECT_FOR_BRONZE_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_bronze_tool"));
        public static TagKey<Block> INCORRECT_FOR_IRON_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_iron_tool"));
        public static TagKey<Block> INCORRECT_FOR_PIG_IRON_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_pig_iron_tool"));
        public static TagKey<Block> INCORRECT_FOR_STEEL_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_steel_tool"));
        public static TagKey<Block> INCORRECT_FOR_ENCRUSTED_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_encrusted_tool"));
        public static TagKey<Block> INCORRECT_FOR_OBSIDIAN_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_obsidian_tool"));
        public static TagKey<Block> INCORRECT_FOR_TUNGSTEN_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_tungsten_tool"));
        public static TagKey<Block> INCORRECT_FOR_BLACK_STEEL_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_black_steel_tool"));
        public static TagKey<Block> INCORRECT_FOR_BLUE_STEEL_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_blue_steel_tool"));
        public static TagKey<Block> INCORRECT_FOR_RED_STEEL_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_red_steel_tool"));
        public static TagKey<Block> INCORRECT_FOR_SILVER_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_silver_tool"));
        public static TagKey<Block> INCORRECT_FOR_GOLD_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_gold_tool"));
        public static TagKey<Block> INCORRECT_FOR_MITHRIL_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_mithril_tool"));
        public static TagKey<Block> INCORRECT_FOR_ADAMANTIUM_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_adamantium_tool"));
        public static TagKey<Block> INCORRECT_FOR_MITHIUM_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_mithium_tool"));
        public static TagKey<Block> INCORRECT_FOR_IGNOTUMITE_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_ignotumite_tool"));
        public static TagKey<Block> INCORRECT_FOR_ENDER_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_ender_tool"));
        public static TagKey<Block> INCORRECT_FOR_COMPOSITE_ALLOY_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_composite_alloy_tool"));
        public static TagKey<Block> INCORRECT_FOR_NETHERITE_TOOL = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "incorrect_for_netherite_tool"));

        public static TagKey<Block> getCommonTag(String path) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", path));
        }
    }

    public static class Items {
        public static TagKey<Item> YEW_LOGS = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "yew_logs"));
        public static TagKey<Item> IRONBARK_LOGS = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ironbark_logs"));
        public static TagKey<Item> EBONY_LOGS = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ebony_logs"));

        public static TagKey<Item> getCommonTag(String path) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", path));
        }
    }

    public static class Biomes {
        public static TagKey<Biome> HAS_DWARVEN_STRONGHOLD = TagKey.create(Registries.BIOME,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "has_structure/dwarven_stronghold"));
    }
}
