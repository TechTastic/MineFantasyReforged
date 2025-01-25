package minefantasy.mfr.init;

import minefantasy.mfr.MineFantasyReforged;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MFRTags {

    public static class Blocks {
        public static TagKey<Block> MINEABLE_WITH_HAMMER = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "mineable/hammer"));

        public static TagKey<Block> YEW_LOGS = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "yew_logs"));
        public static TagKey<Block> IRONBARK_LOGS = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ironbark_logs"));
        public static TagKey<Block> EBONY_LOGS = TagKey.create(Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ebony_logs"));
    }

    public static class Items {
        public static TagKey<Item> YEW_LOGS = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "yew_logs"));
        public static TagKey<Item> IRONBARK_LOGS = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ironbark_logs"));
        public static TagKey<Item> EBONY_LOGS = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "ebony_logs"));
    }
}
