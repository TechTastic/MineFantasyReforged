package minefantasy.mfr.util;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Sets;
import minefantasy.mfr.api.archery.IAmmo;
import minefantasy.mfr.api.archery.IFirearm;
import minefantasy.mfr.item.MFRArrowItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Utils {
    public Utils() {
        throw new IllegalStateException("Util class cannot be instantiated");
    }

    public static <T> T nullValue() {
        return null;
    }

    public static boolean doesMatch(ItemStack item1, ItemStack item2) {
        return item2.getItem() == item1.getItem();
    }

    public static String convertSnakeCaseToSplitCapitalized(String string) {
        return WordUtils.capitalize(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, string).replaceAll("_", " "));
    }

    public static String convertSplitCapitalizedToSnakeCase(String string) {
        return string.toLowerCase().replaceAll(" ", "_");
    }

    public static String serializeList(Set<String> list) {
        return list.toString().replaceAll("[\\[|\\]]", "");
    }

    public static Set<String> deserializeList(String string) {
        List<String> list = Arrays.asList(StringUtils.splitByWholeSeparator(string, ","));
        list.replaceAll(String::trim);
        return Sets.newHashSet(list);
    }

    public static boolean canAcceptArrow(ItemStack ammo, ItemStack weapon) {
        String ammoType = "null";
        if (!ammo.isEmpty() && ammo.getItem() instanceof IAmmo ammoHolder) {
            ammoType = ammoHolder.getAmmoType(ammo);
        }

        if (isVanillaArrow(ammo)) {
            ammoType = "arrow";
        }

        if (!weapon.isEmpty() && weapon.getItem() instanceof IFirearm firearm) {
            return firearm.canAcceptAmmo(weapon, ammoType);
        }

        return ammoType.equalsIgnoreCase("arrow");
    }

    public static boolean isVanillaArrow(ItemStack ammo) {
        return ammo.getItem() instanceof ArrowItem arrow && !(arrow instanceof MFRArrowItem);
    }

    public static ChestBlockEntity getOtherDoubleChest(BlockEntity inv) {
        if (inv instanceof ChestBlockEntity chest &&
                chest.getBlockState().getValue(ChestBlock.TYPE) != ChestType.SINGLE) {
            Level level = chest.getLevel();
            BlockPos pos = chest.getBlockPos().relative(ChestBlock.getConnectedDirection(chest.getBlockState()));

            if (level != null && level.getBlockEntity(pos) instanceof ChestBlockEntity otherChest)
                return otherChest;
        }
        return null;
    }

    /**
     * Provides the percent difference between two integers, provided in percentage form.
     * @param a the first input integer
     * @param b the second input integer
     * @return the percent difference
     */
    public static float percentDifferenceCalculator (int a, int b){
        float absoluteDifference = Math.abs(a - b);
        float average = (a + b) / 2F;
        return 100 * (absoluteDifference/average);
    }

    public static Long gcd(List<Long> input) {
        long result = input.getFirst();
        for (int i = 1; i < input.size(); i++)
            result = gcd(result, input.get(i));
        return result;
    }

    private static long gcd(Long a, Long b) {
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
