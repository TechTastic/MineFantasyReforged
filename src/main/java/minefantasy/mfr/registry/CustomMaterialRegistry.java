package minefantasy.mfr.registry;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.extension.EnumExtensions;
import minefantasy.mfr.init.MFRBlocks;
import minefantasy.mfr.init.MFRDataComponents;
import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.item.component.MaterialDataComponent;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.material.LeatherMaterial;
import minefantasy.mfr.material.MetalMaterial;
import minefantasy.mfr.material.WoodMaterial;
import minefantasy.mfr.registry.types.CustomMaterialType;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.text.DecimalFormat;
import java.util.*;

public class CustomMaterialRegistry {
    public static final ResourceKey<Registry<CustomMaterial>> MATERIAL_REGISTRY_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "materials"));

    public static HashMap<CustomMaterialType, List<CustomMaterial>> TYPE_LIST = new HashMap<>();

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public static RegistryAccess ACCESS = null;

    public static Collection<CustomMaterial> getValues(RegistryAccess access) {
        return access.lookup(MATERIAL_REGISTRY_KEY).map(lookup ->
                lookup.listElements().map(Holder.Reference::value).toList()
        ).orElse(List.of());
    }

    /**
     * Gets a Material by name
     */
    public static CustomMaterial getMaterial(ResourceLocation name) {
        if (name == null)
            return MFRMaterials.NONE.get();

        Optional<Holder.Reference<CustomMaterial>> optMaterial =
                ACCESS.lookup(MATERIAL_REGISTRY_KEY).flatMap(lookup ->
                        lookup.get(ResourceKey.create(MATERIAL_REGISTRY_KEY, name)));

        return optMaterial.map(Holder.Reference::value).orElse(MFRMaterials.NONE.get());
    }

    /**
     * Gets the list of all Materials of the given type
     * @param type the Type of the Custom Materials
     * @return List of Custom Materials
     */
    public static List<CustomMaterial> getList(RegistryAccess access, CustomMaterialType type) {
        TYPE_LIST.computeIfAbsent(type, k -> access.lookup(MATERIAL_REGISTRY_KEY).map(lookup ->
                lookup.listElements().map(Holder.Reference::value).filter(mat -> mat.getType() == type)
                        .sorted((matA, matB) -> matB.getTier() - matA.getTier()).toList().reversed()
        ).orElse(List.of()));

        return TYPE_LIST.get(type);
    }

    /**
     * Adds a Custom Material to an ItemStack
     * @param item 		The ItemStack to add the Custom Material to
     * @param slot 		The 'position' of the Material
     * @param material	The CustomMaterial to add
     */
    public static void addMaterial(ItemStack item, String slot, ResourceLocation material) {
        MaterialDataComponent comp = getOrCreateComponent(item);
        if (Objects.equals(slot, MaterialDataComponent.SLOT_HAFT))
            item.set(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE.get(),
                    new MaterialDataComponent(comp.mainMaterial().orElse(null), material));
        else
            item.set(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE.get(),
                    new MaterialDataComponent(material, comp.haftMaterial().orElse(null)));
    }

    /**
     * Gets the Custom Material of an ItemStack
     * @param item The ItemStack to get the Material of
     * @param slot The 'position' of the Material
     * @return The Custom Material
     */
    public static CustomMaterial getMaterialFor(ItemStack item, String slot) {
        MaterialDataComponent comp = getOrCreateComponent(item);
        if (Objects.equals(slot, MaterialDataComponent.SLOT_HAFT))
            return getMaterial(comp.haftMaterial().orElse(MFRMaterials.ANY));
        return getMaterial(comp.mainMaterial().orElse(MFRMaterials.ANY));
    }

    public static MaterialDataComponent getOrCreateComponent(ItemStack item) {
        if (item.has(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE.get()))
            return item.get(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE.get());
        MaterialDataComponent comp = new MaterialDataComponent(
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "none"),
                ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "none")
        );
        item.set(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE.get(), comp);
        return comp;
    }

    /**
     * Gets the formatted weight string for a given mass
     * @param mass the mass to be formatted
     * @return the formatted string
     */
    @OnlyIn(Dist.CLIENT)
    public static String getWeightString(float mass) {
        String s = "attribute.weightKg.name";
        if (mass > 0 && mass < 1.0F) {
            s = "attribute.weightg.name";
            mass = (int) (mass * 1000F);
        } else if (mass > 1000) {
            s = "attribute.weightt.name";
            mass = (int) (mass / 1000F);
        }
        return I18n.get(s, DECIMAL_FORMAT.format(mass));
    }

    public static void setupAccess(LevelAccessor level) {
        ACCESS = level.registryAccess();
    }

    /**
     * Used to datagen all basic CustomMaterial JSON files
     *
     * @param context the bootstrap context
     */
    public static void bootstrap(BootstrapContext<CustomMaterial> context) {
        // Registering NONE/ANY material
        context.register(createMaterialKey(MFRMaterials.ANY), MFRMaterials.NONE.get());

        // Registering Leather material
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "leather"), new LeatherMaterial(
                CustomMaterialTypeRegistry.LEATHER_TYPES.get(),
                Ingredient.EMPTY, new int[]{255, 198, 92, 53}, 1.0F, 0.4F, 1.2F,
                0.5F, 0F, 0.1F, 0, Rarity.COMMON, 15, 0, false
        ));

        registerWoodMaterials(context);
        registerMetalMaterials(context);
    }

    public static void registerWoodMaterials(BootstrapContext<CustomMaterial> context) {
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/scrap"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.STICK),
                new int[] { 255, 100, 95, 80 },
                0.1f,
                0.5f,
                0.5f,
                10,
                0.5f,
                0,
                EnumExtensions.POOR_RARITY_PROXY.getValue(),
                0,
                2f,
                false
        ));
        context.register(createMaterialKey(MFRMaterials.OAK_WOOD), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.OAK_PLANKS),
                new int[] { 255, 149, 119, 70 },
                0.7f,
                1f,
                1.3f,
                40,
                0.8f,
                1,
                Rarity.COMMON,
                1,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/spruce"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.SPRUCE_PLANKS),
                new int[] { 255, 102, 79, 47 },
                0.2f,
                0.9f,
                1f,
                20,
                0.4f,
                1,
                Rarity.COMMON,
                1,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/birch"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.BIRCH_PLANKS),
                new int[] { 255, 200, 183, 122 },
                0.5f,
                0.9f,
                1.3f,
                10,
                0.7f,
                1,
                Rarity.COMMON,
                1,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/jungle"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.JUNGLE_PLANKS),
                new int[] { 255, 159, 113, 74 },
                0.4f,
                1f,
                1.2f,
                50,
                0.6f,
                1,
                Rarity.COMMON,
                1,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/acacia"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.ACACIA_PLANKS),
                new int[] { 255, 173, 93, 50 },
                0.5f,
                1.2f,
                1f,
                20,
                0.6f,
                1,
                Rarity.COMMON,
                1,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/dark_oak"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.DARK_OAK_PLANKS),
                new int[] { 255, 62, 41, 18 },
                1.2f,
                1.5f,
                1.3f,
                50,
                1f,
                1,
                Rarity.COMMON,
                1,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/cherry"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.CHERRY_PLANKS),
                new int[] { 255, 184, 148, 144 },
                0.5f,
                0.8f,
                1.3f,
                40,
                0.5f,
                1,
                Rarity.COMMON,
                1,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/mangrove"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.MANGROVE_PLANKS),
                new int[] { 255, 93, 39, 43 },
                0.7f,
                0.8f,
                1.3f,
                35,
                0.8f,
                1,
                Rarity.COMMON,
                1,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/bamboo"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.BAMBOO),
                new int[] { 255, 173, 155, 75 },
                0.4f,
                0.75f,
                1.5f,
                10,
                0.2f,
                0,
                Rarity.COMMON,
                0,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/warped"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.WARPED_PLANKS),
                new int[] { 255, 32, 89, 82 },
                0.9f,
                3.5f,
                1.1f,
                50,
                0.9f,
                2,
                Rarity.UNCOMMON,
                2,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/crimson"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(Items.CRIMSON_PLANKS),
                new int[] { 255, 107, 49, 72 },
                0.9f,
                3.5f,
                1.1f,
                50,
                0.9f,
                2,
                Rarity.UNCOMMON,
                2,
                2f,
                false
        ));
        // TODO: Refined Wood
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/yew"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(MFRBlocks.YEW_PLANKS),
                new int[] { 255, 195, 138, 54 },
                0.7f,
                2f,
                2f,
                40,
                0.7f,
                2,
                Rarity.UNCOMMON,
                2,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/ironbark"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(MFRBlocks.IRONBARK_PLANKS),
                new int[] { 255, 202, 92, 29 },
                0.9f,
                3.5f,
                1.1f,
                50,
                0.9f,
                2,
                Rarity.UNCOMMON,
                2,
                2f,
                false
        ));
        context.register(createMaterialKey(MineFantasyReforged.MOD_ID, "wood/ebony"), new WoodMaterial(
                CustomMaterialTypeRegistry.WOOD_TYPES.get(),
                Ingredient.of(MFRBlocks.EBONY_PLANKS),
                new int[] { 255, 50, 46, 40 },
                1.3f,
                4f,
                1.6f,
                80,
                1f,
                3,
                Rarity.RARE,
                3,
                2f,
                false
        ));
    }

    public static void registerMetalMaterials(BootstrapContext<CustomMaterial> context) {
        context.register(createMaterialKey(MFRMaterials.TIN_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/tin"))),
                new int[] { 255, 164, 177, 177 },
                1.5f,
                1f,
                0.5f,
                0f,
                10,
                2f,
                0,
                Rarity.COMMON,
                5,
                -1,
                2f,
                900,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.COPPER_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/copper"))),
                new int[] { 255, 255, 132, 66 },
                1.5f,
                1f,
                1f,
                0f,
                50,
                3f,
                0,
                Rarity.COMMON,
                5,
                0,
                2f,
                1000,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.BRONZE_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/bronze"))),
                new int[] { 255, 207, 165, 118 },
                2.25f,
                1.5f,
                1f,
                1.5f,
                20,
                3f,
                1,
                Rarity.COMMON,
                5,
                1,
                5f,
                1200,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.IRON_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/iron"))),
                new int[] { 255, 140, 120, 100 },
                2.5f,
                2f,
                1f,
                2.0f,
                20,
                2.5f,
                2,
                Rarity.COMMON,
                5,
                2,
                6f,
                1200,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.PIG_IRON_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/pig_iron"))),
                new int[] { 255, 120, 95, 95 },
                2.5f,
                2f,
                0.8f,
                2f,
                20,
                2.5f,
                2,
                Rarity.COMMON,
                3,
                2,
                6f,
                1200,
                new Float[] { 1.1f, 0.8f, 1.1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.STEEL_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/steel"))),
                new int[] { 255, 168, 168, 168 },
                2.75f,
                3f,
                1f,
                2.5f,
                30,
                2.5f,
                3,
                Rarity.COMMON,
                10,
                3,
                7f,
                1500,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.ENCRUSTED_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/encrusted"))),
                new int[] { 255, 64, 255, 255 },
                3f,
                8f,
                1f,
                3f,
                35,
                3f,
                4,
                Rarity.COMMON,
                25,
                3,
                8f,
                1800,
                new Float[] { 1f, 1f, 1.2f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.OBSIDIAN_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/obsidian"))),
                new int[] { 255, 90, 45, 90 },
                3f,
                8f,
                1f,
                3f,
                35,
                3f,
                4,
                Rarity.COMMON,
                25,
                3,
                8f,
                2000,
                new Float[] { 1f, 1.3f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.TUNGSTEN_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/tungsten"))),
                new int[] { 255, 66, 86, 65 },
                3f,
                8f,
                0.5f,
                3f,
                35,
                4f,
                4,
                Rarity.COMMON,
                5,
                3,
                8f,
                2000,
                new Float[] { 1.3f, 1f, 1.3f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.BLACK_STEEL_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/black_steel"))),
                new int[] { 255, 80, 80, 80 },
                3.5f,
                6f,
                1f,
                4f,
                50,
                3f,
                5,
                Rarity.COMMON,
                12,
                4,
                10f,
                2000,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.BLUE_STEEL_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/blue_steel"))),
                new int[] { 255, 28, 31, 159 },
                4f,
                7f,
                1.2f,
                5f,
                65,
                2f,
                6,
                Rarity.COMMON,
                20,
                5,
                12f,
                2000,
                new Float[] { 1f, 1.2f, 0.8f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.RED_STEEL_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/red_steel"))),
                new int[] { 255, 219, 56, 58 },
                4.5f,
                8f,
                0.8f,
                6f,
                50,
                3.5f,
                6,
                Rarity.COMMON,
                1,
                5,
                14f,
                2000,
                new Float[] { 0.9f, 0.9f, 1.2f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.SILVER_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/silver"))),
                new int[] { 255, 155, 206, 205 },
                1.5f,
                2.5f,
                1f,
                0f,
                40,
                3.5f,
                0,
                Rarity.COMMON,
                10,
                0,
                2f,
                1200,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.GOLD_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/gold"))),
                new int[] { 255, 243, 222, 49 },
                1.5f,
                2f,
                1f,
                0f,
                40,
                3.5f,
                0,
                Rarity.COMMON,
                10,
                0,
                2f,
                1200,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.MITHRIL_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/mithril"))),
                new int[] { 255, 250, 140, 250 },
                5f,
                10f,
                0.8f,
                7f,
                90,
                2f,
                7,
                Rarity.UNCOMMON,
                30,
                6,
                16f,
                2500,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.ADAMANTIUM_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/adamantium"))),
                new int[] { 255, 100, 200, 100 },
                5.5f,
                12f,
                0.8f,
                8f,
                80,
                3.5f,
                7,
                Rarity.UNCOMMON,
                10,
                6,
                18f,
                2500,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.MITHIUM_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/mithium"))),
                new int[] { 255, 60, 200, 255 },
                6.5f,
                15f,
                0.8f,
                10f,
                95,
                2f,
                8,
                Rarity.RARE,
                40,
                7,
                22f,
                2500,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.IGNOTUMITE_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/ignotumite"))),
                new int[] { 255, 20, 255, 100 },
                8.5f,
                15f,
                0.8f,
                14f,
                85,
                3.5f,
                8,
                Rarity.RARE,
                20,
                7,
                30f,
                3000,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.ENDER_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/ender"))),
                new int[] { 255, 255, 63, 243 },
                7.5f,
                15f,
                0.8f,
                12f,
                90,
                3f,
                8,
                Rarity.RARE,
                20,
                7,
                26f,
                3000,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.COMPOSITE_ALLOY_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/composite_alloy"))),
                new int[] { 255, 65, 75, 65 },
                2.5f,
                10f,
                0.8f,
                2.5f,
                75,
                4f,
                4,
                Rarity.UNCOMMON,
                10,
                3,
                7f,
                2500,
                new Float[] { 1f, 1f, 1f },
                false
        ));
        context.register(createMaterialKey(MFRMaterials.NETHERITE_METAL), new MetalMaterial(
                CustomMaterialTypeRegistry.METAL_TYPES.get(),
                Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/netherite"))),
                new int[] { 255, 115, 113, 115 },
                5.5f,
                10f,
                0.6f,
                8.5f,
                95,
                3f,
                7,
                Rarity.RARE,
                25,
                6,
                18f,
                4950,
                new Float[] { 1f, 1f, 1f },
                false
        ));
    }

    public static ResourceKey<CustomMaterial> createMaterialKey(String modId, String name) {
        return createMaterialKey(ResourceLocation.fromNamespaceAndPath(modId, name));
    }

    public static ResourceKey<CustomMaterial> createMaterialKey(ResourceLocation location) {
        return ResourceKey.create(CustomMaterialRegistry.MATERIAL_REGISTRY_KEY, location);
    }
}
