package minefantasy.mfr.registry.factories;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import minefantasy.mfr.material.CustomMaterial;
import net.minecraft.world.item.Rarity;

public class CustomMaterialFactory {
    public record Properties(int tier, float durability, float flexibility, float sharpness, float hardness,
                              float resistance, float density, Integer meltingPoint, Rarity rarity, int enchantability,
                              int craftTier, Integer craftAnvilTier, Float craftTimeModifier, boolean unbreakable
    ) {
        public static Properties fromMaterial(CustomMaterial material) {
            return new Properties(
                    material.getTier(),
                    material.getDurability(),
                    material.getFlexibility(),
                    material.getSharpness(),
                    material.getHardness(),
                    material.getResistance(),
                    material.getDensity(),
                    material.getMeltingPoint(),
                    material.getRarity(),
                    material.getEnchantability(),
                    material.getCrafterTier(),
                    material.getCrafterAnvilTier(),
                    material.getCraftTimeModifier(),
                    material.isUnbreakable()
            );
        }

        public static final Codec<Properties> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.INT.fieldOf("tier").forGetter(Properties::tier),
                Codec.FLOAT.fieldOf("durability").forGetter(Properties::durability),
                Codec.FLOAT.fieldOf("flexibility").forGetter(Properties::flexibility),
                Codec.FLOAT.optionalFieldOf("sharpness", 0f).forGetter(Properties::sharpness),
                Codec.FLOAT.fieldOf("hardness").forGetter(Properties::hardness),
                Codec.FLOAT.fieldOf("resistance").forGetter(Properties::resistance),
                Codec.FLOAT.fieldOf("density").forGetter(Properties::density),
                Codec.INT.optionalFieldOf("melting_point", 0).forGetter(Properties::meltingPoint),
                Rarity.CODEC.fieldOf("rarity").forGetter(Properties::rarity),
                Codec.INT.fieldOf("enchantability").forGetter(Properties::enchantability),
                Codec.INT.fieldOf("crafter_tier").forGetter(Properties::craftTier),
                Codec.INT.optionalFieldOf("crafter_anvil_tier", 0).forGetter(Properties::craftAnvilTier),
                Codec.FLOAT.optionalFieldOf("craft_time_modifier", 0f).forGetter(Properties::craftTimeModifier),
                Codec.BOOL.optionalFieldOf("unbreakable", false).forGetter(Properties::unbreakable)
        ).apply(instance, Properties::new));
    }

    public record Colors(int alpha, int red, int green, int blue) {
        public int[] toArray() {
            return new int[] { alpha, red, green, blue };
        }

        public static Colors fromArray(int[] arr) {
            return new Colors(arr[0], arr[1], arr[2], arr[3]);
        }

        public static Colors fromMaterial(CustomMaterial material) {
            return fromArray(material.getColourARGB());
        }

        public static final Codec<Colors> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.INT.optionalFieldOf("alpha", 255).forGetter(Colors::alpha),
                Codec.INT.fieldOf("red").forGetter(Colors::red),
                Codec.INT.fieldOf("green").forGetter(Colors::green),
                Codec.INT.fieldOf("blue").forGetter(Colors::blue)
        ).apply(instance, Colors::new));
    }

    public record ArmorStats(float cutting, float blunt, float piercing) {
        public Float[] toArray() {
            return new Float[] { cutting, blunt, piercing };
        }

        public static ArmorStats fromArray(Float[] armor) {
            if (armor == null)
                return null;
            return new ArmorStats(armor[0], armor[1], armor[2]);
        }

        public static ArmorStats fromMaterial(CustomMaterial material) {
            return fromArray(material.getArmourProtection());
        }

        public static final ArmorStats DEFAULT = new ArmorStats(1f, 1f, 1f);

        public static final Codec<ArmorStats> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.FLOAT.fieldOf("cutting").forGetter(ArmorStats::cutting),
                Codec.FLOAT.fieldOf("blunt").forGetter(ArmorStats::blunt),
                Codec.FLOAT.fieldOf("piercing").forGetter(ArmorStats::piercing)
        ).apply(instance, ArmorStats::new));
    }
}
