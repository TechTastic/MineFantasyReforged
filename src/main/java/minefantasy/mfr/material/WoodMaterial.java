package minefantasy.mfr.material;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import minefantasy.mfr.registry.factories.CustomMaterialFactory;
import minefantasy.mfr.registry.types.CustomMaterialType;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;

public class WoodMaterial extends CustomMaterial {
    public static final MapCodec<WoodMaterial> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            CustomMaterialTypeRegistry.MATERIAL_TYPE_REGISTRY.byNameCodec().fieldOf("type").forGetter(CustomMaterial::getType),
            Ingredient.CODEC.fieldOf("materialIngredient").forGetter(CustomMaterial::getMaterialIngredient),
            CustomMaterialFactory.Properties.CODEC.fieldOf("properties").forGetter(CustomMaterialFactory.Properties::fromMaterial),
            CustomMaterialFactory.Colors.CODEC.fieldOf("color").forGetter(CustomMaterialFactory.Colors::fromMaterial)
    ).apply(instance, (type, ingredient, properties, colors) ->
            new WoodMaterial(
                    type,
                    ingredient,
                    colors.toArray(),
                    properties.hardness(),
                    properties.durability(),
                    properties.flexibility(),
                    properties.resistance(),
                    properties.density(),
                    properties.tier(),
                    properties.rarity(),
                    properties.craftTier(),
                    properties.craftTimeModifier(),
                    properties.unbreakable()
            )
    ));

    public WoodMaterial(CustomMaterialType type, Ingredient materialIngredient,  int[] colourRGB, float hardness,
                         float durability, float flexibility, float resistance, float density, int tier, Rarity rarity,
                         int crafterTier, Float craftTimeModifier, boolean unbreakable) {

        super(type, materialIngredient, colourRGB, hardness, durability, flexibility, 0f, resistance, density,
                tier, rarity, 0, crafterTier, 0, craftTimeModifier,
                0, CustomMaterialFactory.ArmorStats.DEFAULT.toArray(), unbreakable);
    }

    @Override
    public String getMaterialString() {
        return I18n.get("materialtype." + CustomMaterialTypeRegistry.getName(this.getType()).toLanguageKey() + ".name", this.getTier());
    }
}
