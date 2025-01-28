package minefantasy.mfr.init;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.constants.Tool;
import minefantasy.mfr.item.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MFRItems {
    private static final DeferredRegister.Items ITEMS;

    public static final DeferredItem<MetalComponentItem> BAR;

    public static final DeferredItem<MetalComponentItem> METAL_HUNK;
    public static final DeferredItem<MetalComponentItem> PLATE;
    public static final DeferredItem<MetalComponentItem> PLATE_HUGE;
    public static final DeferredItem<MetalComponentItem> SCALE_MESH;
    public static final DeferredItem<MetalComponentItem> CHAIN_MESH;
    public static final DeferredItem<MetalComponentItem> SPLINT_MESH;

    public static final DeferredItem<WoodComponentItem> TIMBER;
    public static final DeferredItem<WoodComponentItem> TIMBER_CUT;
    public static final DeferredItem<WoodComponentItem> TIMBER_PANE;

    // STANDARD ARMOR

    public static final DeferredItem<CustomArmorItem> STANDARD_SCALE_HELMET;
    public static final DeferredItem<CustomArmorItem> STANDARD_SCALE_CHESTPLATE;
    public static final DeferredItem<CustomArmorItem> STANDARD_SCALE_LEGGINGS;
    public static final DeferredItem<CustomArmorItem> STANDARD_SCALE_BOOTS;
    public static final DeferredItem<CustomArmorItem> STANDARD_CHAIN_HELMET;
    public static final DeferredItem<CustomArmorItem> STANDARD_CHAIN_CHESTPLATE;
    public static final DeferredItem<CustomArmorItem> STANDARD_CHAIN_LEGGINGS;
    public static final DeferredItem<CustomArmorItem> STANDARD_CHAIN_BOOTS;
    public static final DeferredItem<CustomArmorItem> STANDARD_SPLINT_HELMET;
    public static final DeferredItem<CustomArmorItem> STANDARD_SPLINT_CHESTPLATE;
    public static final DeferredItem<CustomArmorItem> STANDARD_SPLINT_LEGGINGS;
    public static final DeferredItem<CustomArmorItem> STANDARD_SPLINT_BOOTS;
    public static final DeferredItem<CustomArmorItem> STANDARD_PLATE_HELMET;
    public static final DeferredItem<CustomArmorItem> STANDARD_PLATE_CHESTPLATE;
    public static final DeferredItem<CustomArmorItem> STANDARD_PLATE_LEGGINGS;
    public static final DeferredItem<CustomArmorItem> STANDARD_PLATE_BOOTS;

    // STANDARD CUSTOM TOOLS

    public static final DeferredItem<MFRSwordItem> STANDARD_SWORD;
    public static final DeferredItem<WaraxeItem> STANDARD_WARAXE;
    public static final DeferredItem<MaceItem> STANDARD_MACE;
    public static final DeferredItem<DaggerItem> STANDARD_DAGGER;
    public static final DeferredItem<SpearItem> STANDARD_SPEAR;
    public static final DeferredItem<GreatswordItem> STANDARD_GREATSWORD;
    public static final DeferredItem<BattleaxeItem> STANDARD_BATTLEAXE;
    public static final DeferredItem<WarhammerItem> STANDARD_WARHAMMER;
    public static final DeferredItem<KatanaItem> STANDARD_KATANA;
    public static final DeferredItem<HalbeardItem> STANDARD_HALBEARD;
    public static final DeferredItem<LanceItem> STANDARD_LANCE;
    public static final DeferredItem<MFRPickaxeItem> STANDARD_PICK;
    public static final DeferredItem<MFRAxeItem> STANDARD_AXE;
    public static final DeferredItem<MFRShovelItem> STANDARD_SHOVEL;
    public static final DeferredItem<MFRHoeItem> STANDARD_HOE;
    public static final DeferredItem<HeavyPickaxeItem> STANDARD_HEAVY_PICK;
    public static final DeferredItem<HeavyShovelItem> STANDARD_HEAVY_SHOVEL;
    public static final DeferredItem<HandpickItem> STANDARD_HANDPICK;
    public static final DeferredItem<TrowItem> STANDARD_TROW;
    public static final DeferredItem<ScytheItem> STANDARD_SCYTHE;
    public static final DeferredItem<MattockItem> STANDARD_MATTOCK;
    public static final DeferredItem<LumberAxeItem> STANDARD_LUMBER;
    public static final DeferredItem<HammerItem> STANDARD_HAMMMER;
    public static final DeferredItem<HammerItem> STANDARD_HEAVY_HAMMMER;
    public static final DeferredItem<TongsItem> STANDARD_TONGS;
    public static final DeferredItem<MFRShearsItem> STANDARD_SHEARS;
    public static final DeferredItem<KnifeItem> STANDARD_KNIFE;
    public static final DeferredItem<NeedleItem> STANDARD_NEEDLE;
    public static final DeferredItem<SawItem> STANDARD_SAW;
    public static final DeferredItem<BasicCraftToolItem> STANDARD_SPOON;
    public static final DeferredItem<BasicCraftToolItem> STANDARD_MALLET;
    public static final DeferredItem<SpannerItem> STANDARD_SPANNER;
    public static final DeferredItem<WashClothItem> WASH_CLOTH_WOOL;
    public static final DeferredItem<MFRBowItem> STANDARD_BOW;
    public static final DeferredItem<MFRArrowItem> STANDARD_ARROW;
    public static final DeferredItem<MFRArrowItem> STANDARD_BOLT;
    public static final DeferredItem<MFRArrowItem> STANDARD_ARROW_BODKIN;
    public static final DeferredItem<MFRArrowItem> STANDARD_ARROW_BROAD;

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    static {
        ITEMS = DeferredRegister.Items.createItems(MineFantasyReforged.MOD_ID);

        BAR = ITEMS.register("bar", () ->
                new MetalComponentItem(new Item.Properties(), 1f));

        METAL_HUNK = ITEMS.register("metal_hunk", () ->
                new MetalComponentItem(new Item.Properties(), 0.25f));
        PLATE = ITEMS.register("plate", () ->
                new MetalComponentItem(new Item.Properties(), 2f));
        PLATE_HUGE = ITEMS.register("plate_huge", () ->
                new MetalComponentItem(new Item.Properties(), 8f));
        SCALE_MESH = ITEMS.register("scale_mesh", () ->
                new MetalComponentItem(new Item.Properties(), 1f));
        CHAIN_MESH = ITEMS.register("chain_mesh", () ->
                new MetalComponentItem(new Item.Properties(), 1f));
        SPLINT_MESH = ITEMS.register("splint_mesh", () ->
                new MetalComponentItem(new Item.Properties(), 1f));

        TIMBER = ITEMS.register("timber", () ->
                new WoodComponentItem(new Item.Properties()));
        TIMBER_CUT = ITEMS.register("timber_cut", () ->
                new WoodComponentItem(new Item.Properties()));
        TIMBER_PANE = ITEMS.register("timber_pane", () ->
                new WoodComponentItem(new Item.Properties()));

        // STANDARD ARMOR

        STANDARD_SCALE_HELMET = ITEMS.register("standard_scale_helmet", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_SCALE_CHESTPLATE = ITEMS.register("standard_scale_chestplate", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_SCALE_LEGGINGS = ITEMS.register("standard_scale_leggings", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_SCALE_BOOTS = ITEMS.register("standard_scale_boots", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_CHAIN_HELMET = ITEMS.register("standard_chain_helmet", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_CHAIN_CHESTPLATE = ITEMS.register("standard_chain_chestplate", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_CHAIN_LEGGINGS = ITEMS.register("standard_chain_leggings", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_CHAIN_BOOTS = ITEMS.register("standard_chain_boots", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_SPLINT_HELMET = ITEMS.register("standard_splint_helmet", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_SPLINT_CHESTPLATE = ITEMS.register("standard_splint_chestplate", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_SPLINT_LEGGINGS = ITEMS.register("standard_splint_leggings", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_SPLINT_BOOTS = ITEMS.register("standard_splint_boots", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_PLATE_HELMET = ITEMS.register("standard_plate_helmet", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_PLATE_CHESTPLATE = ITEMS.register("standard_plate_chestplate", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_PLATE_LEGGINGS = ITEMS.register("standard_plate_leggings", () -> new CustomArmorItem(new Item.Properties()));
        STANDARD_PLATE_BOOTS = ITEMS.register("standard_plate_boots", () -> new CustomArmorItem(new Item.Properties()));

        // STANDARD CUSTOM TOOLS

        STANDARD_SWORD = ITEMS.register("standard_sword", () ->
                new MFRSwordItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_WARAXE = ITEMS.register("standard_waraxe", () ->
                new WaraxeItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_MACE = ITEMS.register("standard_mace", () ->
                new MaceItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_DAGGER = ITEMS.register("standard_dagger", () ->
                new DaggerItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_SPEAR = ITEMS.register("standard_spear", () ->
                new SpearItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_GREATSWORD = ITEMS.register("standard_greatsword", () ->
                new GreatswordItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_BATTLEAXE = ITEMS.register("standard_battleaxe", () ->
                new BattleaxeItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_WARHAMMER = ITEMS.register("standard_warhammer", () ->
                new WarhammerItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_KATANA = ITEMS.register("standard_katana", () ->
                new KatanaItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_HALBEARD = ITEMS.register("standard_halbeard", () ->
                new HalbeardItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_LANCE = ITEMS.register("standard_lance", () ->
                new LanceItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_PICK = ITEMS.register("standard_pick", () ->
                new MFRPickaxeItem(Tiers.IRON, new Item.Properties(), 1f, true));
        STANDARD_AXE = ITEMS.register("standard_axe", () ->
                new MFRAxeItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_SHOVEL = ITEMS.register("standard_spade", () ->
                new MFRShovelItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_HOE = ITEMS.register("standard_hoe", () ->
                new MFRHoeItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_HEAVY_PICK = ITEMS.register("standard_heavy_pick", () ->
                new HeavyPickaxeItem(Tiers.IRON, new Item.Properties(), 1f, true));
        STANDARD_HEAVY_SHOVEL = ITEMS.register("standard_heavy_shovel", () ->
                new HeavyShovelItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_HANDPICK = ITEMS.register("standard_handpick", () ->
                new HandpickItem(Tiers.IRON, new Item.Properties(), 1f, true));
        STANDARD_TROW = ITEMS.register("standard_trow", () ->
                new TrowItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_SCYTHE = ITEMS.register("standard_scythe", () ->
                new ScytheItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_MATTOCK = ITEMS.register("standard_mattock", () ->
                new MattockItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_LUMBER = ITEMS.register("standard_lumber", () ->
                new LumberAxeItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_HAMMMER = ITEMS.register("standard_hammer", () ->
                new HammerItem(Tiers.IRON, false, 0, new Item.Properties(), 1f, true));
        STANDARD_HEAVY_HAMMMER = ITEMS.register("standard_heavy_hammer", () ->
                new HammerItem(Tiers.IRON, true, 0, new Item.Properties(), 1f, true));
        STANDARD_TONGS = ITEMS.register("standard_tongs", () ->
                new TongsItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_SHEARS = ITEMS.register("standard_shears", () ->
                new MFRShearsItem(new Item.Properties(), true));
        STANDARD_KNIFE = ITEMS.register("standard_knife", () ->
                new KnifeItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_NEEDLE = ITEMS.register("standard_needle", () ->
                new NeedleItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_SAW = ITEMS.register("standard_saw", () ->
                new SawItem(Tiers.IRON, new Item.Properties(), true));
        STANDARD_SPOON = ITEMS.register("standard_spoon", () ->
                new BasicCraftToolItem(Tool.SPOON, 0, new Item.Properties(), true));
        STANDARD_MALLET = ITEMS.register("standard_mallet", () ->
                new BasicCraftToolItem(Tool.MALLET, 0, new Item.Properties(), true));
        STANDARD_SPANNER = ITEMS.register("standard_spanner", () ->
                new SpannerItem(Tiers.IRON, new Item.Properties(), true));
        WASH_CLOTH_WOOL = ITEMS.register("wash_cloth_wool", () ->
                new WashClothItem(Tiers.GOLD, new Item.Properties(), true));
        STANDARD_BOW = ITEMS.register("standard_bow", () ->
                new MFRBowItem(new Item.Properties()));
        STANDARD_ARROW = ITEMS.register("standard_arrow", () ->
                new MFRArrowItem(new Item.Properties()));
        STANDARD_BOLT = ITEMS.register("standard_bolt", () ->
                new MFRArrowItem(new Item.Properties()));
        STANDARD_ARROW_BODKIN = ITEMS.register("standard_arrow_bodkin", () ->
                new MFRArrowItem(new Item.Properties()));
        STANDARD_ARROW_BROAD = ITEMS.register("standard_arrow_broad", () ->
                new MFRArrowItem(new Item.Properties()));
    }
}
