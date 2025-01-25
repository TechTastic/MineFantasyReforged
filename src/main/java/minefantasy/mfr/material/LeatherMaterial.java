package minefantasy.mfr.material;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import minefantasy.mfr.registry.factories.CustomMaterialFactory;
import minefantasy.mfr.registry.types.CustomMaterialType;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;

public class LeatherMaterial extends CustomMaterial {
    public static final MapCodec<LeatherMaterial> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            CustomMaterialTypeRegistry.MATERIAL_TYPE_REGISTRY.byNameCodec().fieldOf("type").forGetter(CustomMaterial::getType),
            Ingredient.CODEC.fieldOf("materialIngredient").forGetter(CustomMaterial::getMaterialIngredient),
            CustomMaterialFactory.Properties.CODEC.fieldOf("properties").forGetter(CustomMaterialFactory.Properties::fromMaterial),
            CustomMaterialFactory.Colors.CODEC.fieldOf("color").forGetter(CustomMaterialFactory.Colors::fromMaterial)
    ).apply(instance, (type, ingredient, properties, colors) ->
            new LeatherMaterial(
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
                    properties.unbreakable()
            )
    ));

    public LeatherMaterial(CustomMaterialType type, Ingredient material, int[] color, float hardness, float durability, float flexibility,
                           float sharpness, float resistance, float density, int tier, Rarity rarity, int enchantability, int crafterTier, boolean unbreakable) {
        super(type, material, color, hardness, durability, flexibility, sharpness, resistance,
                density, tier, rarity, enchantability, crafterTier, 0, 0f, 0, CustomMaterialFactory.ArmorStats.DEFAULT.toArray(), unbreakable);
    }
}
