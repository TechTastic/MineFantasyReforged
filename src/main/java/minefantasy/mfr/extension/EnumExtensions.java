package minefantasy.mfr.extension;

import minefantasy.mfr.init.MFRBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import java.util.function.Supplier;

public class EnumExtensions {
    public static final EnumProxy<Rarity> POOR_RARITY_PROXY = new EnumProxy<>(
            Rarity.class, -1, "minefantasyreforged:poor", ChatFormatting.BLACK
    );

    public static final EnumProxy<Boat.Type> YEW_BOAT_TYPE_PROXY = new EnumProxy<>(
            Boat.Type.class,
            MFRBlocks.YEW_PLANKS,
            "minefantasyreforged:yew",
            (Supplier<Item>) () -> Items.OAK_BOAT,
            (Supplier<Item>) () -> Items.OAK_CHEST_BOAT,
            (Supplier<Item>) () -> Items.STICK,
            false
    );

    public static final EnumProxy<Boat.Type> IRONBARK_BOAT_TYPE_PROXY = new EnumProxy<>(
            Boat.Type.class,
            MFRBlocks.IRONBARK_PLANKS,
            "minefantasyreforged:ironbark",
            (Supplier<Item>) () -> Items.OAK_BOAT,
            (Supplier<Item>) () -> Items.OAK_CHEST_BOAT,
            (Supplier<Item>) () -> Items.STICK,
            false
    );

    public static final EnumProxy<Boat.Type> EBONY_BOAT_TYPE_PROXY = new EnumProxy<>(
            Boat.Type.class,
            MFRBlocks.EBONY_PLANKS,
            "minefantasyreforged:ebony",
            (Supplier<Item>) () -> Items.OAK_BOAT,
            (Supplier<Item>) () -> Items.OAK_CHEST_BOAT,
            (Supplier<Item>) () -> Items.STICK,
            false
    );
}
