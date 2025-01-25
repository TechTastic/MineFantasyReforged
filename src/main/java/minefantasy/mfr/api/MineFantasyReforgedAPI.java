package minefantasy.mfr.api;

import minefantasy.mfr.api.heating.Heatable;
import minefantasy.mfr.util.MFRLogUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class MineFantasyReforgedAPI {
    public static void debugMsg(String msg) {
        MFRLogUtil.logDebug(msg);
    }

    /**
     * Allows an item to be heated
     *
     * @param item     the item to heat
     * @param min      the minimum heat to forge with(celcius)
     * @param max      the maximum heat until the item is ruined(celcius)
     * @param unstable when the ingot is unstable(celcius)
     */
    public static void setHeatableStats(ItemStack item, int min, int unstable, int max) {
        Heatable.addItem(item, min, unstable, max);
    }

    /**
     * Allows an item to be heated ignoring subId
     *
     * @param id       the item to heat
     * @param min      the minimum heat to forge with(celcius)
     * @param max      the maximum heat until the item is ruined(celcius)
     * @param unstable when the ingot is unstable(celcius)
     */
    public static void setHeatableStats(Item id, int min, int unstable, int max) {
        Heatable.addItem(new ItemStack(id, 1), min, unstable, max);
    }

    public static void setHeatableStats(TagKey<Item> tag, int min, int unstable, int max) {
        for (ItemStack item : BuiltInRegistries.ITEM.getOrCreateTag(tag).stream().map(holder -> new ItemStack(holder.value())).toList()) {
            setHeatableStats(item, min, unstable, max);
        }
    }

    public static void setHeatableStats(Ingredient ingredient, int min, int unstable, int max) {
        for (ItemStack itemStack : ingredient.getItems()) {
            setHeatableStats(itemStack, min, unstable, max);
        }
    }
}
