package minefantasy.mfr.material;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import minefantasy.mfr.api.MineFantasyReforgedAPI;
import minefantasy.mfr.init.MFRItems;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.registry.factories.CustomMaterialFactory;
import minefantasy.mfr.registry.types.CustomMaterialType;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import minefantasy.mfr.util.MFRLogUtil;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class MetalMaterial extends CustomMaterial {
    public static final MapCodec<MetalMaterial> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            CustomMaterialTypeRegistry.MATERIAL_TYPE_REGISTRY.byNameCodec().fieldOf("type").forGetter(CustomMaterial::getType),
            Ingredient.CODEC.fieldOf("materialIngredient").forGetter(CustomMaterial::getMaterialIngredient),
            CustomMaterialFactory.Properties.CODEC.fieldOf("properties").forGetter(CustomMaterialFactory.Properties::fromMaterial),
            CustomMaterialFactory.Colors.CODEC.fieldOf("color").forGetter(CustomMaterialFactory.Colors::fromMaterial),
            CustomMaterialFactory.ArmorStats.CODEC.optionalFieldOf("armor_stats", CustomMaterialFactory.ArmorStats.DEFAULT).forGetter(CustomMaterialFactory.ArmorStats::fromMaterial)
    ).apply(instance, (type, ingredient, properties, colors, armor) ->
            new MetalMaterial(
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
                    properties.craftTimeModifier(),
                    properties.meltingPoint(),
                    armor.toArray(),
                    properties.unbreakable()
            )
    ));

    public MetalMaterial(CustomMaterialType type, Ingredient materialIngredient, int[] colourRGB, float hardness,
                         float durability, float flexibility, float sharpness, float resistance, float density, int tier, Rarity rarity,
                         int enchantability, int crafterTier, Float craftTimeModifier, Integer meltingPoint,
                         Float[] armourProtection, boolean unbreakable) {

        super(type, materialIngredient, colourRGB, hardness, durability, flexibility, sharpness, resistance, density, tier,
                rarity, enchantability, crafterTier, Math.min(-1, 4), craftTimeModifier * (2f + (sharpness * 2f)),
                meltingPoint, armourProtection, unbreakable);

        setArmourStats(1.0F, flexibility, 1F / flexibility);// Harder materials absorb blunt less but resist cutting and piercing more

        // Adding this is necessary to preserve the old system where defaults are dynamically calculated above with setArmourStats and non-default values take precedence over the calculated values
        // old formula: hardness = ((sharpness + 5F) / 2F) - 1F;
        for (float value : armourProtection) {
            if (value != 1.0) {
                setArmourStats(armourProtection[0], armourProtection[1], armourProtection[2]);
                break;
            }
        }
    }

    public static void addHeatables(RegistryAccess access) {
        List<CustomMaterial> metal = CustomMaterialRegistry.getList(access, CustomMaterialTypeRegistry.METAL_TYPES.get());
        for (CustomMaterial customMat : metal) {
            int[] stats = customMat.getHeatableStats();
            MFRLogUtil.logDebug("Set Heatable Stats for " + customMat.getName(access) + ": " + stats[0] + "," + stats[1] + "," + stats[2]);

            MineFantasyReforgedAPI.setHeatableStats(customMat.materialIngredient, stats[0], stats[1], stats[2]);
            //MineFantasyReforgedAPI.setHeatableStats("hunk" + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, customMat.getName(access).getPath().split("/")[1]), stats[0], stats[1], stats[2]);
        }

        //MineFantasyReforgedAPI.setHeatableStats(MineFantasyItems.RIVET, 1000, 2000, 3000);
        MineFantasyReforgedAPI.setHeatableStats(MFRItems.METAL_HUNK.get(), -1, -1, -1);
        MineFantasyReforgedAPI.setHeatableStats(MFRItems.BAR.get(), -1, -1, -1);
    }

    @Override
    public boolean isHeatable() {
        return true;
    }
}
