package minefantasy.mfr.registry;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MFRDataComponents;
import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.item.component.MaterialDataComponent;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.factories.CustomMaterialFactory;
import minefantasy.mfr.registry.types.CustomMaterialType;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
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
    public static CustomMaterial getMaterial(RegistryAccess access, ResourceLocation name) {
        if (name == null)
            return MFRMaterials.NONE.get();

        Optional<Holder.Reference<CustomMaterial>> optMaterial =
                access.lookup(MATERIAL_REGISTRY_KEY).flatMap(lookup ->
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
                    new MaterialDataComponent(comp.mainMaterial(), material));
        else
            item.set(MFRDataComponents.MATERIAL_DATA_COMPONENT_TYPE.get(),
                    new MaterialDataComponent(material, comp.haftMaterial()));
    }

    /**
     * Gets the Custom Material of an ItemStack
     * @param item The ItemStack to get the Material of
     * @param slot The 'position' of the Material
     * @return The Custom Material
     */
    public static CustomMaterial getMaterialFor(RegistryAccess access, ItemStack item, String slot) {
        MaterialDataComponent comp = getOrCreateComponent(item);
        if (Objects.equals(slot, MaterialDataComponent.SLOT_HAFT))
            return getMaterial(access, comp.haftMaterial());
        return getMaterial(access, comp.mainMaterial());
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
}
