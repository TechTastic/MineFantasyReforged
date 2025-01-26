package minefantasy.mfr.util;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.api.crafting.ITieredComponent;
import minefantasy.mfr.api.crafting.exotic.ISpecialDesign;
import minefantasy.mfr.init.MFRMaterials;
import minefantasy.mfr.item.component.MaterialDataComponent;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.registry.types.CustomMaterialType;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.Arrays;
import java.util.List;

public class CustomToolHelper {
    /**
     * A bit of the new system, gets custom materials for the head
     */
    public static CustomMaterial getCustomPrimaryMaterial(RegistryAccess access, ItemStack item) {
        if (item.isEmpty())
            return MFRMaterials.NONE.get();

        return CustomMaterialRegistry.getMaterialFor(access, item, MaterialDataComponent.SLOT_MAIN);
    }

    public static CustomMaterial getCustomSecondaryMaterial(RegistryAccess access, ItemStack item) {
        if (item.isEmpty())
            return MFRMaterials.NONE.get();

        return CustomMaterialRegistry.getMaterialFor(access, item, MaterialDataComponent.SLOT_HAFT);
    }

    public static ItemStack construct(Item base, ResourceLocation main) {
        return construct(base, main, ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID, "wood/oak"));
    }

    public static ItemStack construct(Item base, ResourceLocation main, ResourceLocation haft) {
        ItemStack item = new ItemStack(base);
        CustomMaterialRegistry.addMaterial(item, MaterialDataComponent.SLOT_MAIN, main);
        if (haft != null) {
            CustomMaterialRegistry.addMaterial(item, MaterialDataComponent.SLOT_HAFT, haft);
        }

        Rarity rarity = item.get(DataComponents.RARITY);
        if (rarity == null)
            rarity = Rarity.COMMON;
        item.set(DataComponents.RARITY, getRarity(CustomMaterialRegistry.ACCESS, item, rarity));

        return item;
    }

    public static ItemStack constructSingleColoredLayer(Item base, ResourceLocation main) {
        return constructSingleColoredLayer(base, main, 1);
    }

    public static ItemStack constructSingleColoredLayer(Item base, ResourceLocation main, int stacksize) {
        ItemStack item = new ItemStack(base, stacksize);
        CustomMaterialRegistry.addMaterial(item, MaterialDataComponent.SLOT_MAIN, main);

        Rarity rarity = item.get(DataComponents.RARITY);
        if (rarity == null)
            rarity = Rarity.COMMON;
        item.set(DataComponents.RARITY, CustomToolHelper.getRarity(CustomMaterialRegistry.ACCESS, item, rarity));

        return item;
    }

    /**
     * Gets the rarity for a custom item
     *
     * @param itemRarity is the default id
     */
    public static Rarity getRarity(RegistryAccess access, ItemStack item, Rarity itemRarity) {
        int lvl = itemRarity.ordinal();
        CustomMaterial material = getCustomPrimaryMaterial(access, item);
        if (material != MFRMaterials.NONE.get())
            lvl = material.getRarity().ordinal();

        if (item.isEnchanted()) {
            if (lvl == 0)
                lvl++;
            lvl++;
        }
        if (lvl >= Rarity.values().length)
            lvl = Rarity.values().length - 1;
        return Rarity.values()[lvl];
    }

    /**
     * Gets the max durability
     *
     * @param dura is the default dura
     */
    public static int getMaxDamage(RegistryAccess access, ItemStack stack, int dura) {
        CustomMaterial head = getCustomPrimaryMaterial(access, stack);
        CustomMaterial haft = getCustomSecondaryMaterial(access, stack);
        if (head != MFRMaterials.NONE.get())
            dura = (int) (head.getDurability() * 100);
        if (haft != MFRMaterials.NONE.get())
            dura += (int) (haft.getDurability() * 100);// Hafts add 50% to the durability
        return ToolHelper.setDuraOnQuality(stack, dura);
    }

    /**
     * Gets the colour for a layer
     *
     * @param layer 0 is base, haft is 1, 2 is detail
     */
    public static int getColourFromItemStack(RegistryAccess access, ItemStack item, int layer) {
        if (layer == 0) {
            CustomMaterial material = getCustomPrimaryMaterial(access, item);
            if (material != MFRMaterials.NONE.get())
                return material.getColourInt();
        }
        if (layer == 1) {
            CustomMaterial material = getCustomSecondaryMaterial(access, item);
            if (material != MFRMaterials.NONE.get())
                return material.getColourInt();
        }

        return MFRMaterials.NONE.get().getColourInt();
    }

    public static float getWeightModifier(RegistryAccess access, ItemStack item, float base) {
        CustomMaterial metal = getCustomPrimaryMaterial(access, item);
        CustomMaterial wood = getCustomSecondaryMaterial(access, item);

        if (metal != MFRMaterials.NONE.get())
            base = (metal.getDensity() / 2.5F) * base;
        if (wood != MFRMaterials.NONE.get())
            base += (wood.getDensity() / 2.5F);
        return base;
    }

    /**
     * Gets the material modifier if it exists
     *
     * @param defaultModifier default if no material exists
     */
    public static float getMeleeDamage(RegistryAccess access, ItemStack item, float defaultModifier) {
        CustomMaterial custom = getCustomPrimaryMaterial(access, item);
        if (custom != MFRMaterials.NONE.get())
            return custom.getSharpness();
        return defaultModifier;
    }

    public static float getBowDamage(RegistryAccess access, ItemStack item, float defaultModifier) {
        CustomMaterial base = getCustomSecondaryMaterial(access, item);
        CustomMaterial joints = getCustomPrimaryMaterial(access, item);

        if (base != MFRMaterials.NONE.get())
            defaultModifier = base.getFlexibility();
        if (joints != MFRMaterials.NONE.get())
            defaultModifier *= joints.getFlexibility();
        return defaultModifier;
    }

    /**
     * The total damage of a bow and arrow
     */
    public static float getBaseDamages(RegistryAccess access, ItemStack item, float defaultModifier) {
        CustomMaterial custom = getCustomPrimaryMaterial(access, item);
        if (custom != MFRMaterials.NONE.get())
            return getBaseDamage(custom.getSharpness() * custom.getFlexibility());
        return getBaseDamage(defaultModifier);
    }

    /**
     * The damage a bow and arrow should do (same as a sword)
     */
    public static float getBaseDamage(float modifier) {
        return 4F + modifier;
    }

    public static float getEfficiencyForHds(RegistryAccess access, ItemStack item, float value, float mod) {
        CustomMaterial custom = getCustomPrimaryMaterial(access, item);
        if (custom != MFRMaterials.NONE.get())
            value = 2.0F + (custom.getHardness() * 4F);// Efficiency starts at 2 and each point of sharpness adds 2
        return ToolHelper.modifyDigOnQuality(item, value) * mod;
    }

    public static float getEfficiency(RegistryAccess access, ItemStack item, float value, float mod) {
        CustomMaterial custom = getCustomPrimaryMaterial(access, item);
        if (custom != MFRMaterials.NONE.get())
            value = 2.0F + (custom.getSharpness() * 2F);// Efficiency starts at 2 and each point of sharpness adds 2
        return ToolHelper.modifyDigOnQuality(item, value) * mod;
    }

    public static int getCrafterTier(RegistryAccess access, ItemStack item, int value) {
        CustomMaterial custom = getCustomPrimaryMaterial(access, item);
        if (custom != MFRMaterials.NONE.get())
            return custom.getCrafterTier();
        return value;
    }

    public static int getHarvestLevel(RegistryAccess access, ItemStack item, int value) {
        if (value <= 0) {
            return value;// If its not effective
        }

        CustomMaterial custom = getCustomPrimaryMaterial(access, item);
        if (custom != MFRMaterials.NONE.get()) {
            if (custom.getTier() == 0)
                return 1;
            if (custom.getTier() <= 2)
                return 2;
            return Math.max(custom.getTier(), 2);
        }
        return value;
    }

    @OnlyIn(Dist.CLIENT)
    public static void addInformation(RegistryAccess access, ItemStack item, List<Component> list) {
        CustomMaterial secondaryMaterial = getCustomSecondaryMaterial(access, item);

        if (materialOnTooltip()) {
            CustomMaterial mainMaterial = getCustomPrimaryMaterial(access, item);
            if (mainMaterial != null && mainMaterial != MFRMaterials.NONE.get()) {
                String matName = I18n.get(I18n.get(Utils.convertSnakeCaseToSplitCapitalized(mainMaterial.getName(access).getPath().split("/")[1])));
                list.add(Component.literal(matName).withStyle(ChatFormatting.GOLD));
            }
        }

        if (secondaryMaterial != MFRMaterials.NONE.get()) {
            String name;
            String localized_material;
            name = secondaryMaterial.getName(access).getPath();
            if (name.contains("/"))
                name = name.split("/")[1];
            localized_material = I18n.get("material." + name + ".name");
            if (!localized_material.endsWith(".name")) {
                name = localized_material;
            }
            String matName = I18n.get("item.mod_haft.name", I18n.get(Utils.convertSnakeCaseToSplitCapitalized(name)));
            list.add(Component.literal(matName).withStyle(ChatFormatting.GOLD));
        }

    }

    /**
     * Gets if the language puts tiers in the tooltip, leaving the name blank
     *
     * @return material boolean
     */
    public static boolean materialOnTooltip() {
        String cfg = I18n.get("languagecfg.tooltiptier");
        return cfg.equalsIgnoreCase("true");
    }

    @OnlyIn(Dist.CLIENT)
    public static void addBowInformation(RegistryAccess access, ItemStack item, List<Component> list) {

        CustomMaterial material = getCustomPrimaryMaterial(access, item);
        if (material != MFRMaterials.NONE.get()) {
            String name;
            String localized_material;
            name = material.getName(access).getPath();
            if (name.contains("/"))
                name = name.split("/")[1];
            localized_material = I18n.get("material." + name + ".name");
            if (!localized_material.endsWith(".name")) {
                name = localized_material;
            }
            String matName = I18n.get(
                    "item.mod_joint.name",
                    I18n.get(Utils.convertSnakeCaseToSplitCapitalized(name)));
            list.add(Component.literal(matName).withStyle(ChatFormatting.GOLD));
        }

    }

    public static String getSecondaryLocalisedName(RegistryAccess access, ItemStack item, String unlocalizedName) {
        if (materialOnTooltip()) {
            I18n.get(unlocalizedName);
        }

        CustomMaterial material = getCustomSecondaryMaterial(access, item);
        String name = "any";
        String localized_material = null;
        if (material != MFRMaterials.NONE.get()) {
            name = material.getName(access).getPath();
            if (name.contains("/"))
                name = name.split("/")[1];
            localized_material = I18n.get("material." + name + ".name");
        }
        if (localized_material != null && !localized_material.endsWith(".name")) {
            name = localized_material;
        }
        return I18n.get(
                unlocalizedName,
                I18n.get(Utils.convertSnakeCaseToSplitCapitalized(name)));
    }

    public static Component getLocalisedName(RegistryAccess access, ItemStack item, String unlocalizedName) {
        if (materialOnTooltip()) {
            return Component.translatable(unlocalizedName);
        }

        CustomMaterial material = getCustomPrimaryMaterial(access, item);
        String name = "any";
        String localized_material = null;
        if (material != MFRMaterials.NONE.get()) {
            name = material.getName(access).getPath();
            if (name.contains("/"))
                name = name.split("/")[1];
            localized_material = I18n.get("material." + name + ".name");
        }
        if (localized_material != null && !localized_material.endsWith(".name")) {
            name = localized_material;
        }

        return Component.translatable(
                unlocalizedName,
                I18n.get(Utils.convertSnakeCaseToSplitCapitalized(name)));
    }

    public static boolean areEqual(RegistryAccess access, ItemStack recipeItem, ItemStack inputItem) {
        if (recipeItem.isEmpty())
            return inputItem.isEmpty();
        if (inputItem.isEmpty())
            return false;

        return ItemStack.isSameItem(recipeItem, inputItem) && doesMainMatchForRecipe(access, recipeItem, inputItem)
                && doesHaftMatchForRecipe(access, recipeItem, inputItem);
    }

    /**
     * Checks if two items' materials match
     */
    public static boolean doesMatchForRecipe(RegistryAccess access, ItemStack recipeItem, ItemStack inputItem) {
        return doesMainMatchForRecipe(access, recipeItem, inputItem) && doesHaftMatchForRecipe(access, recipeItem, inputItem);
    }

    /**
     * Checks if two items' materials match
     */
    public static boolean doesMatchForRecipe(RegistryAccess access, Ingredient ingredient, ItemStack inputItem) {
        return Arrays.stream(ingredient.getItems())
                .anyMatch(itemStack -> doesMainMatchForRecipe(access, itemStack, inputItem) && doesHaftMatchForRecipe(access, itemStack, inputItem));
    }

    public static boolean doesMainMatchForRecipe(RegistryAccess access, ItemStack recipeItem, ItemStack inputItem) {
        CustomMaterial recipeMat = CustomToolHelper.getCustomPrimaryMaterial(access, recipeItem);
        CustomMaterial inputMat = CustomToolHelper.getCustomPrimaryMaterial(access, inputItem);

        if (recipeMat == MFRMaterials.NONE.get()) {
            return true;
        }

        if (inputMat == MFRMaterials.NONE.get()) {
            return false;
        }
        return recipeMat == inputMat;
    }

    public static boolean doesHaftMatchForRecipe(RegistryAccess access, ItemStack recipeItem, ItemStack inputItem) {
        CustomMaterial recipeMat = CustomToolHelper.getCustomSecondaryMaterial(access, recipeItem);
        CustomMaterial inputMat = CustomToolHelper.getCustomSecondaryMaterial(access, inputItem);

        if (recipeMat == MFRMaterials.NONE.get()) {
            return true;
        }

        if (inputMat == MFRMaterials.NONE.get()) {
            return false;
        }
        return recipeMat == inputMat;
    }

    @OnlyIn(Dist.CLIENT)
    public static void addComponentString(List<Component> list, CustomMaterial base) {
        addComponentString(list, base, 1);
    }

    @OnlyIn(Dist.CLIENT)
    public static void addComponentString(List<Component> list, CustomMaterial base, float units) {
        float mass = base.getDensity() * units;
        if (base != MFRMaterials.NONE.get())
            list.add(Component.literal(base.getMaterialString()).withStyle(ChatFormatting.GOLD));
        if (mass > 0)
            list.add(Component.translatable(CustomMaterialRegistry.getWeightString(mass)));

        if (base.isHeatable()) {
            int maxTemp = base.getHeatableStats()[0];
            int beyondMax = base.getHeatableStats()[1];
            list.add(Component.literal(I18n.get("materialtype.workable.name", maxTemp, beyondMax)));
        }
    }

    public static float getBurnModifier(RegistryAccess access, ItemStack fuel) {
        CustomMaterial mat = getCustomPrimaryMaterial(access, fuel);
        if (mat != MFRMaterials.NONE.get() && mat.getType() == CustomMaterialTypeRegistry.WOOD_TYPES.get()) {
            return (2 * mat.getDensity()) + 0.5F;
        }
        return 1.0F;
    }

    public static String getReferenceName(RegistryAccess access, ItemStack item) {
        return getReferenceName(access, item, true);
    }

    public static String getReferenceName(RegistryAccess access, ItemStack item, boolean tiered) {
        String reference = getSimpleReferenceName(item.getItem());

        if (tiered) {
            CustomMaterial base = getCustomPrimaryMaterial(access, item);
            CustomMaterial haft = getCustomSecondaryMaterial(access, item);

            if (base != MFRMaterials.NONE.get()) {
                reference += "_" + base.getName(access);
            }
            if (haft != MFRMaterials.NONE.get()) {
                reference += "_" + haft.getName(access);
            }
        }

        return reference;
    }

    public static String getSimpleReferenceName(Item item) {
        String reference = String.valueOf(BuiltInRegistries.ITEM.getKey(item));
        if (reference == null)
            return "";
        return reference.toLowerCase();
    }

    public static boolean areToolsSame(RegistryAccess access, ItemStack item1, ItemStack item2) {
        CustomMaterial mainMaterial1 = getCustomPrimaryMaterial(access, item1);
        CustomMaterial secondaryMaterial1 = getCustomSecondaryMaterial(access, item2);
        CustomMaterial mainMaterial2 = getCustomPrimaryMaterial(access, item1);
        CustomMaterial secondaryMaterial2 = getCustomSecondaryMaterial(access, item2);
        if ((mainMaterial1 == MFRMaterials.NONE.get() && secondaryMaterial1 != MFRMaterials.NONE.get()) || (secondaryMaterial1 == MFRMaterials.NONE.get() && mainMaterial1 != MFRMaterials.NONE.get()))
            return false;
        if ((mainMaterial2 == MFRMaterials.NONE.get() && secondaryMaterial2 != MFRMaterials.NONE.get()) || (secondaryMaterial2 == MFRMaterials.NONE.get() && mainMaterial2 != MFRMaterials.NONE.get()))
            return false;

        if (mainMaterial1 != secondaryMaterial1)
            return false;
        return mainMaterial2 == secondaryMaterial2;
    }

    public static boolean isMythic(RegistryAccess access, ItemStack result) {
        CustomMaterial main1 = getCustomPrimaryMaterial(access, result);
        CustomMaterial haft1 = getCustomPrimaryMaterial(access, result);
        if (main1 != null  && main1 != MFRMaterials.NONE.get() && main1.isUnbreakable()) {
            return true;
        }
        return haft1 != null && haft1 != MFRMaterials.NONE.get() && haft1.isUnbreakable();
    }

    public static String getComponentMaterial(RegistryAccess access, ItemStack item, CustomMaterialType type) {
        if (item.isEmpty() || type == null)
            return null;

        // TODO: ItemHeated
        //if (item.getItem() instanceof ItemHeated) {
        //    return getComponentMaterial(ItemHeated.getStack(item), type);
        //}

        CustomMaterial material = CustomToolHelper.getCustomPrimaryMaterial(access, item);
        if (material != MFRMaterials.NONE.get()) {
            return material.getType() == type ? material.getName(access).getPath().split("/")[1] : null;
        }
        return null;
    }

    public static boolean hasAnyMaterial(RegistryAccess access, ItemStack item) {
        return getCustomPrimaryMaterial(access, item) != MFRMaterials.NONE.get() || getCustomSecondaryMaterial(access, item) != MFRMaterials.NONE.get();
    }

    public static void tryDeconstruct(RegistryAccess access, ItemStack newitem, ItemStack mainItem) {
        CustomMaterialType type = null;
        if (!newitem.isEmpty() && newitem.getItem() instanceof ITieredComponent tiered) {
            type = tiered.getMaterialType(newitem);
        }

        if (type != null) {
            CustomMaterial primary = CustomToolHelper.getCustomPrimaryMaterial(access, mainItem);
            CustomMaterial secondary = CustomToolHelper.getCustomSecondaryMaterial(access, mainItem);

            if (primary != MFRMaterials.NONE.get() && primary.getType() == type) {
                CustomMaterialRegistry.addMaterial(newitem, MaterialDataComponent.SLOT_MAIN, primary.getName(access));
            } else {
                if (secondary != MFRMaterials.NONE.get() && secondary.getType() == type) {
                    CustomMaterialRegistry.addMaterial(newitem, MaterialDataComponent.SLOT_MAIN, secondary.getName(access));
                }
            }
        }
    }

    public static String getCustomStyle(ItemStack weapon) {
        if (!weapon.isEmpty() && weapon.getItem() instanceof ISpecialDesign design) {
            return design.getDesign(weapon);
        }
        return null;
    }
}