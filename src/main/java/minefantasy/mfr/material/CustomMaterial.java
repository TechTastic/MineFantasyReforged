package minefantasy.mfr.material;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.registry.factories.CustomMaterialFactory;
import minefantasy.mfr.registry.types.CustomMaterialType;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.SimpleTier;

import java.util.concurrent.atomic.AtomicReference;

public class CustomMaterial {
    /**
     * The Codec used to parse Custom Material from JSON and used in Dynamic Registry
     */
    public static final MapCodec<CustomMaterial> CODEC;

    /**
     * This Codec is used for syncing values ot the Client such as color
     */
    public static final Codec<CustomMaterial> SYNC_CODEC;

    private static final int[] flameResistArray = new int[] {100, 300};

    private final CustomMaterialType type;

    protected Ingredient materialIngredient;
    /**
     * The material colour
     */
    private final int[] colourARGB;
    /**
     * Base threshold for armour rating
     */
    private final float hardness;
    /**
     * The Modifier for durability (1pt per 250 uses)
     */
    private final float durability;
    /**
     * used for bow power.. >1 weakens blunt prot, <1 weakens piercing prot
     */
    private final float flexibility;
    /**
     * The Efficiency modifier (Like ToolMaterial) Also does damage
     */
    private final float sharpness;
    /**
     * The modifier to resist elements like fire and corrosion)
     */
    private final float resistance;
    /**
     * The weight Kg/U (Kilogram per unit)
     */
    private final float density;
    private final int tier;
    private final Rarity rarity;
    private final int enchantability;
    private final int crafterTier;
    private final Integer crafterAnvilTier;
    private final Float craftTimeModifier;
    private final Integer meltingPoint;
    private Float[] armourProtection; // TODO: consider making this property into a typed class
    private final boolean unbreakable;

    public CustomMaterial(CustomMaterialType type, Ingredient materialIngredient, int[] colourRGB, float hardness,
                          float durability, float flexibility, float sharpness, float resistance, float density, int tier, Rarity rarity,
                          int enchantability, int crafterTier, Integer crafterAnvilTier, Float craftTimeModifier, Integer meltingPoint,
                          Float[] armourProtection, boolean unbreakable) {
        this.type = type;
        this.materialIngredient = materialIngredient;
        this.colourARGB = colourRGB;
        this.hardness = hardness;
        this.durability = durability;
        this.flexibility = flexibility;
        this.sharpness = sharpness;
        this.resistance = resistance;
        this.density = density;
        this.tier = tier;
        this.rarity = rarity;
        this.enchantability = enchantability;
        this.crafterTier = crafterTier;
        this.crafterAnvilTier = crafterAnvilTier;
        this.craftTimeModifier = craftTimeModifier;
        this.meltingPoint = meltingPoint;
        this.armourProtection = armourProtection;
        this.unbreakable = unbreakable;
    }

    /**
     * Gets or Creates a "incorrect_for_[material]_tool" tag for the given material
     * @return "incorrect_for_[material]_tool" tag key
     */
    public TagKey<Block> getOrCreateIncorrectBlocksTag() {
        ResourceLocation name = this.getName();
        String path = name.getPath();

        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(
                name.getNamespace(), "incorrect_for_" + (path.contains("/") ?
                        path.split("/")[1] : path) + "_tool"));
    }

    /**
     * Gets or Creates a "needs_[material]_tool" tag for the given material
     * @return "needs_[material]_tool" tag key
     */
    public TagKey<Block> getOrCreateNeedsBlocksTag() {
        ResourceLocation name = this.getName();
        String path = name.getPath();

        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(
                name.getNamespace(), "needs_" + (path.contains("/") ?
                        path.split("/")[1] : path) + "_tool"));
    }

    /**
     * Gets a new Tier for the Material
     */
    public Tier getToolTier() {
        return new SimpleTier(
                this.getOrCreateIncorrectBlocksTag(),
                (int) this.getDurability(),
                2.0F + (this.getSharpness() * 2F),
                this.getSharpness(),
                this.getEnchantability(),
                this::getMaterialIngredient
        );
    }

    /**
     * Gets material name
     */
    public ResourceLocation getName() {
        AtomicReference<ResourceLocation> name = new AtomicReference<>(MFRMaterials.ANY);
        CustomMaterialRegistry.ACCESS.registry(CustomMaterialRegistry.MATERIAL_REGISTRY_KEY).ifPresent(reg -> name.set(reg.getKey(this)));
        return name.get() == null ? MFRMaterials.ANY : name.get();
    }

    /**
     * Gets material type
     */
    public CustomMaterialType getType() {
        return type;
    }

    public void setMaterialIngredient(Ingredient materialIngredient) {
        this.materialIngredient = materialIngredient;
    }

    public Ingredient getMaterialIngredient() {
        return materialIngredient;
    }

    public int[] getColourARGB() {
        return colourARGB;
    }

    public int getColourInt() {
        return (colourARGB[0] << 24) + (colourARGB[1] << 16) + (colourARGB[2] << 8) + colourARGB[3];
    }

    public float getHardness() {
        return hardness;
    }

    public float getDurability() {
        return durability;
    }

    public float getFlexibility() {
        return flexibility;
    }

    public float getSharpness() {
        return sharpness;
    }

    public float getResistance() {
        return resistance;
    }

    public float getDensity() {
        return density;
    }

    public int getTier() {
        return tier;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getEnchantability() {
        return enchantability;
    }

    public int getCrafterTier() {
        return crafterTier;
    }

    public Integer getCrafterAnvilTier() {
        return crafterAnvilTier;
    }

    public Float getCraftTimeModifier() {
        return craftTimeModifier;
    }

    public Integer getMeltingPoint() {
        return meltingPoint;
    }

    public void setArmourStats(float cutting, float blunt, float piercing) {
        armourProtection = new Float[] {cutting, blunt, piercing};
    }

    public Float[] getArmourProtection() {
        return armourProtection;
    }

    public boolean isUnbreakable() {
        return unbreakable;
    }

    @OnlyIn(Dist.CLIENT)
    public String getMaterialString() {
        return I18n.get("materialtype." + CustomMaterialTypeRegistry.getName(this.type).toLanguageKey() + ".name", this.crafterTier);
    }

    public float getArmourProtection(int id) {
        return armourProtection[id];
    }

    public float getFireResistance() {
        if (meltingPoint > flameResistArray[0]) {
            float max = flameResistArray[1] - flameResistArray[0];
            float heat = meltingPoint - flameResistArray[0];

            int res = (int) (heat / max * 100F);
            return Math.min(100, res);
        }
        return 0F;
    }

    // -----------------------------------BOW
    // FUNCTIONS----------------------------------------\\

    public int[] getHeatableStats() {
        int workableTemp = meltingPoint;
        int unstableTemp = (int) (workableTemp * 1.5F);
        int maxTemp = (int) (workableTemp * 2F);
        return new int[] {workableTemp, unstableTemp, maxTemp};
    }

    public boolean isHeatable() {
        return false;
    }

    static {
        CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                CustomMaterialTypeRegistry.MATERIAL_TYPE_REGISTRY.byNameCodec().fieldOf("type").forGetter(CustomMaterial::getType),
                Ingredient.CODEC.fieldOf("materialIngredient").forGetter(CustomMaterial::getMaterialIngredient),
                CustomMaterialFactory.Properties.CODEC.fieldOf("properties").forGetter(CustomMaterialFactory.Properties::fromMaterial),
                CustomMaterialFactory.Colors.CODEC.fieldOf("color").forGetter(CustomMaterialFactory.Colors::fromMaterial),
                CustomMaterialFactory.ArmorStats.CODEC.fieldOf("armor_stats").forGetter(CustomMaterialFactory.ArmorStats::fromMaterial)
        ).apply(instance, (type, ingredient, properties, colors, armor) ->
                new CustomMaterial(
                        type,
                        ingredient,
                        colors.toArray(),
                        properties.hardness(),
                        properties.durability(),
                        properties.flexibility(),
                        properties.sharpness(),
                        properties.resistance(),
                        properties.density(),
                        properties.tier(),
                        properties.rarity(),
                        properties.enchantability(),
                        properties.craftTier(),
                        properties.craftAnvilTier(),
                        properties.craftTimeModifier(),
                        properties.meltingPoint(),
                        armor.toArray(),
                        properties.unbreakable()
                )
        ));

        SYNC_CODEC = RecordCodecBuilder.create(instance -> instance.group(
                CustomMaterialTypeRegistry.MATERIAL_TYPE_REGISTRY.byNameCodec().fieldOf("type").forGetter(CustomMaterial::getType),
                Ingredient.CODEC.fieldOf("materialIngredient").forGetter(CustomMaterial::getMaterialIngredient),
                CustomMaterialFactory.Properties.CODEC.fieldOf("properties").forGetter(CustomMaterialFactory.Properties::fromMaterial),
                CustomMaterialFactory.Colors.CODEC.fieldOf("color").forGetter(CustomMaterialFactory.Colors::fromMaterial),
                CustomMaterialFactory.ArmorStats.CODEC.optionalFieldOf("armor_stats", CustomMaterialFactory.ArmorStats.DEFAULT).forGetter(CustomMaterialFactory.ArmorStats::fromMaterial)
        ).apply(instance, (type, ingredient, properties, colors, armor) ->
                new CustomMaterial(
                        type,
                        ingredient,
                        colors.toArray(),
                        properties.hardness(),
                        properties.durability(),
                        properties.flexibility(),
                        properties.sharpness(),
                        properties.resistance(),
                        properties.density(),
                        properties.tier(),
                        properties.rarity(),
                        properties.enchantability(),
                        properties.craftTier(),
                        properties.craftAnvilTier(),
                        properties.craftTimeModifier(),
                        properties.meltingPoint(),
                        armor.toArray(),
                        properties.unbreakable()
                )
        ));
    }
}
