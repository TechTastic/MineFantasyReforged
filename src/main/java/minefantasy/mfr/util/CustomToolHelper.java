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
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.Arrays;
import java.util.List;

public class CustomToolHelper {
    /**
     * A bit of the new system, gets custom materials for the head
     */
    public static CustomMaterial getCustomPrimaryMaterial(ItemStack item) {
        if (item.isEmpty())
            return MFRMaterials.NONE.get();

        return CustomMaterialRegistry.getMaterialFor(item, MaterialDataComponent.SLOT_MAIN);
    }

    public static CustomMaterial getCustomSecondaryMaterial(ItemStack item) {
        if (item.isEmpty())
            return MFRMaterials.NONE.get();

        return CustomMaterialRegistry.getMaterialFor(item, MaterialDataComponent.SLOT_HAFT);
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

        updateRarity(item);

        return item;
    }

    public static ItemStack constructSingleColoredLayer(Item base, ResourceLocation main) {
        return constructSingleColoredLayer(base, main, 1);
    }

    public static ItemStack constructSingleColoredLayer(Item base, ResourceLocation main, int stacksize) {
        ItemStack item = new ItemStack(base, stacksize);
        CustomMaterialRegistry.addMaterial(item, MaterialDataComponent.SLOT_MAIN, main);

        updateRarity(item);

        return item;
    }

    public static void updateRarity(ItemStack stack) {
        Rarity rarity = stack.get(DataComponents.RARITY);
        if (rarity == null)
            rarity = Rarity.COMMON;
        stack.set(DataComponents.RARITY, CustomToolHelper.getRarity(stack, rarity));
    }

    /**
     * Gets the rarity for a custom item
     *
     * @param itemRarity is the default id
     */
    public static Rarity getRarity(ItemStack item, Rarity itemRarity) {
        int lvl = itemRarity.ordinal();
        CustomMaterial material = getCustomPrimaryMaterial(item);
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
    public static int getMaxDamage(ItemStack stack, int dura) {
        CustomMaterial head = getCustomPrimaryMaterial(stack);
        CustomMaterial haft = getCustomSecondaryMaterial(stack);
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
    public static int getColourFromItemStack(ItemStack item, int layer) {
        if (layer == 0) {
            CustomMaterial material = getCustomPrimaryMaterial(item);
            if (material != MFRMaterials.NONE.get())
                return material.getColourInt();
        }
        if (layer == 1) {
            CustomMaterial material = getCustomSecondaryMaterial(item);
            if (material != MFRMaterials.NONE.get())
                return material.getColourInt();
        }

        return MFRMaterials.NONE.get().getColourInt();
    }

    public static float getWeightModifier(ItemStack item, float base) {
        CustomMaterial metal = getCustomPrimaryMaterial(item);
        CustomMaterial wood = getCustomSecondaryMaterial(item);

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
    public static float getMeleeDamage(ItemStack item, float defaultModifier) {
        CustomMaterial custom = getCustomPrimaryMaterial(item);
        if (custom != MFRMaterials.NONE.get())
            return custom.getSharpness();
        return defaultModifier;
    }

    public static float getBowDamage(ItemStack item, float defaultModifier) {
        CustomMaterial base = getCustomSecondaryMaterial(item);
        CustomMaterial joints = getCustomPrimaryMaterial(item);

        if (base != MFRMaterials.NONE.get())
            defaultModifier = base.getFlexibility();
        if (joints != MFRMaterials.NONE.get())
            defaultModifier *= joints.getFlexibility();
        return defaultModifier;
    }

    /**
     * The total damage of a bow and arrow
     */
    public static float getBaseDamages(ItemStack item, float defaultModifier) {
        CustomMaterial custom = getCustomPrimaryMaterial(item);
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

    public static float getEfficiencyForHds(ItemStack item, float value, float mod) {
        CustomMaterial custom = getCustomPrimaryMaterial(item);
        if (custom != MFRMaterials.NONE.get())
            value = 2.0F + (custom.getHardness() * 4F);// Efficiency starts at 2 and each point of sharpness adds 2
        return ToolHelper.modifyDigOnQuality(item, value) * mod;
    }

    public static float getEfficiency(ItemStack item, float value, float mod) {
        CustomMaterial custom = getCustomPrimaryMaterial(item);
        if (custom != MFRMaterials.NONE.get())
            value = 2.0F + (custom.getSharpness() * 2F);// Efficiency starts at 2 and each point of sharpness adds 2
        return ToolHelper.modifyDigOnQuality(item, value) * mod;
    }

    public static int getCrafterTier(ItemStack item, int value) {
        CustomMaterial custom = getCustomPrimaryMaterial(item);
        if (custom != MFRMaterials.NONE.get())
            return custom.getCrafterTier();
        return value;
    }

    public static int getHarvestLevel(ItemStack item, int value) {
        if (value <= 0) {
            return value;// If its not effective
        }

        CustomMaterial custom = getCustomPrimaryMaterial(item);
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
    public static void addInformation(ItemStack item, List<Component> list) {
        CustomMaterial secondaryMaterial = getCustomSecondaryMaterial(item);

        if (materialOnTooltip()) {
            CustomMaterial mainMaterial = getCustomPrimaryMaterial(item);
            if (mainMaterial != null && mainMaterial != MFRMaterials.NONE.get()) {
                String matName = I18n.get(I18n.get(Utils.convertSnakeCaseToSplitCapitalized(mainMaterial.getName().getPath().split("/")[1])));
                list.add(Component.literal(matName).withStyle(ChatFormatting.GOLD));
            }
        }

        if (secondaryMaterial != MFRMaterials.NONE.get()) {
            String name;
            String localized_material;
            name = secondaryMaterial.getName().getPath();
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
    public static void addBowInformation(ItemStack item, List<Component> list) {

        CustomMaterial material = getCustomPrimaryMaterial(item);
        if (material != MFRMaterials.NONE.get()) {
            String name;
            String localized_material;
            name = material.getName().getPath();
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

    public static String getSecondaryLocalisedName(ItemStack item, String unlocalizedName) {
        if (materialOnTooltip()) {
            I18n.get(unlocalizedName);
        }

        CustomMaterial material = getCustomSecondaryMaterial(item);
        String name = "any";
        String localized_material = null;
        if (material != MFRMaterials.NONE.get()) {
            name = material.getName().getPath();
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

    public static Component getLocalisedName(ItemStack item, String unlocalizedName) {
        if (materialOnTooltip()) {
            return Component.translatable(unlocalizedName);
        }

        CustomMaterial material = getCustomPrimaryMaterial(item);
        String name = "any";
        String localized_material = null;
        if (material != MFRMaterials.NONE.get()) {
            name = material.getName().getPath();
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

    public static boolean areEqual(ItemStack recipeItem, ItemStack inputItem) {
        if (recipeItem.isEmpty())
            return inputItem.isEmpty();
        if (inputItem.isEmpty())
            return false;

        return ItemStack.isSameItem(recipeItem, inputItem) && doesMainMatchForRecipe(recipeItem, inputItem)
                && doesHaftMatchForRecipe(recipeItem, inputItem);
    }

    /**
     * Checks if two items' materials match
     */
    public static boolean doesMatchForRecipe(ItemStack recipeItem, ItemStack inputItem) {
        return doesMainMatchForRecipe(recipeItem, inputItem) && doesHaftMatchForRecipe(recipeItem, inputItem);
    }

    /**
     * Checks if two items' materials match
     */
    public static boolean doesMatchForRecipe(Ingredient ingredient, ItemStack inputItem) {
        return Arrays.stream(ingredient.getItems())
                .anyMatch(itemStack -> doesMainMatchForRecipe(itemStack, inputItem) && doesHaftMatchForRecipe(itemStack, inputItem));
    }

    public static boolean doesMainMatchForRecipe(ItemStack recipeItem, ItemStack inputItem) {
        CustomMaterial recipeMat = CustomToolHelper.getCustomPrimaryMaterial(recipeItem);
        CustomMaterial inputMat = CustomToolHelper.getCustomPrimaryMaterial(inputItem);

        if (recipeMat == MFRMaterials.NONE.get()) {
            return true;
        }

        if (inputMat == MFRMaterials.NONE.get()) {
            return false;
        }
        return recipeMat == inputMat;
    }

    public static boolean doesHaftMatchForRecipe(ItemStack recipeItem, ItemStack inputItem) {
        CustomMaterial recipeMat = CustomToolHelper.getCustomSecondaryMaterial(recipeItem);
        CustomMaterial inputMat = CustomToolHelper.getCustomSecondaryMaterial(inputItem);

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

    public static float getBurnModifier(ItemStack fuel) {
        CustomMaterial mat = getCustomPrimaryMaterial(fuel);
        if (mat != MFRMaterials.NONE.get() && mat.getType() == CustomMaterialTypeRegistry.WOOD_TYPES.get()) {
            return (2 * mat.getDensity()) + 0.5F;
        }
        return 1.0F;
    }

    public static String getReferenceName(ItemStack item) {
        return getReferenceName(item, true);
    }

    public static String getReferenceName(ItemStack item, boolean tiered) {
        String reference = getSimpleReferenceName(item.getItem());

        if (tiered) {
            CustomMaterial base = getCustomPrimaryMaterial(item);
            CustomMaterial haft = getCustomSecondaryMaterial(item);

            if (base != MFRMaterials.NONE.get()) {
                reference += "_" + base.getName();
            }
            if (haft != MFRMaterials.NONE.get()) {
                reference += "_" + haft.getName();
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

    public static boolean areToolsSame(ItemStack item1, ItemStack item2) {
        CustomMaterial mainMaterial1 = getCustomPrimaryMaterial(item1);
        CustomMaterial secondaryMaterial1 = getCustomSecondaryMaterial(item2);
        CustomMaterial mainMaterial2 = getCustomPrimaryMaterial(item1);
        CustomMaterial secondaryMaterial2 = getCustomSecondaryMaterial(item2);
        if ((mainMaterial1 == MFRMaterials.NONE.get() && secondaryMaterial1 != MFRMaterials.NONE.get()) || (secondaryMaterial1 == MFRMaterials.NONE.get() && mainMaterial1 != MFRMaterials.NONE.get()))
            return false;
        if ((mainMaterial2 == MFRMaterials.NONE.get() && secondaryMaterial2 != MFRMaterials.NONE.get()) || (secondaryMaterial2 == MFRMaterials.NONE.get() && mainMaterial2 != MFRMaterials.NONE.get()))
            return false;

        if (mainMaterial1 != secondaryMaterial1)
            return false;
        return mainMaterial2 == secondaryMaterial2;
    }

    public static boolean isMythic(ItemStack result) {
        CustomMaterial main1 = getCustomPrimaryMaterial(result);
        CustomMaterial haft1 = getCustomPrimaryMaterial(result);
        if (main1 != null  && main1 != MFRMaterials.NONE.get() && main1.isUnbreakable()) {
            return true;
        }
        return haft1 != null && haft1 != MFRMaterials.NONE.get() && haft1.isUnbreakable();
    }

    public static String getComponentMaterial(ItemStack item, CustomMaterialType type) {
        if (item.isEmpty() || type == null)
            return null;

        // TODO: ItemHeated
        //if (item.getItem() instanceof ItemHeated) {
        //    return getComponentMaterial(ItemHeated.getStack(item), type);
        //}

        CustomMaterial material = CustomToolHelper.getCustomPrimaryMaterial(item);
        if (material != MFRMaterials.NONE.get()) {
            return material.getType() == type ? material.getName().getPath().split("/")[1] : null;
        }
        return null;
    }

    public static boolean hasAnyMaterial(ItemStack item) {
        return getCustomPrimaryMaterial(item) != MFRMaterials.NONE.get() || getCustomSecondaryMaterial(item) != MFRMaterials.NONE.get();
    }

    public static void tryDeconstruct(ItemStack newitem, ItemStack mainItem) {
        CustomMaterialType type = null;
        if (!newitem.isEmpty() && newitem.getItem() instanceof ITieredComponent tiered) {
            type = tiered.getMaterialType(newitem);
        }

        if (type != null) {
            CustomMaterial primary = CustomToolHelper.getCustomPrimaryMaterial(mainItem);
            CustomMaterial secondary = CustomToolHelper.getCustomSecondaryMaterial(mainItem);

            if (primary != MFRMaterials.NONE.get() && primary.getType() == type) {
                CustomMaterialRegistry.addMaterial(newitem, MaterialDataComponent.SLOT_MAIN, primary.getName());
            } else {
                if (secondary != MFRMaterials.NONE.get() && secondary.getType() == type) {
                    CustomMaterialRegistry.addMaterial(newitem, MaterialDataComponent.SLOT_MAIN, secondary.getName());
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