package minefantasy.mfr.api.heating;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;

public class Heatable {
    public static HashMap<ResourceLocation, Heatable> registerList = new HashMap<>();

    /**
     * The min heat the ingot must be to forge with mesured in celcius
     */
    private final int minTemperature;
    /**
     * The heat when it becomes unstable mesured in celcius
     */
    private final int unstableTemperature;
    /**
     * The max heat until the ingot is destroyed mesured in celcius
     */
    private final int maxTemperature;
    /**
     * The item that's used
     */
    protected ItemStack object;

    public Heatable(ItemStack item, int min, int unstable, int max) {
        this.object = item;
        this.minTemperature = min;
        this.unstableTemperature = unstable;
        this.maxTemperature = max;
    }

    public static void addItem(ItemStack item, int min, int unstable, int max) {
        registerList.put(BuiltInRegistries.ITEM.getKey(item.getItem()), new Heatable(item, min, unstable, max));
    }

    public static boolean canHeatItem(ItemStack item) {
        return loadStats(item) != null;
    }

    public static Heatable loadStats(ItemStack item) {
        if (item.isEmpty())
            return null;

        if (registerList.isEmpty())
            return null;

        Heatable stats = findRegister(item);
        if (stats != null && ItemStack.isSameItem(stats.object, item))
            return stats;

        return null;
    }

    private static Heatable findRegister(ItemStack item) {
        return registerList.get(BuiltInRegistries.ITEM.getKey(item.getItem()));
    }
}
