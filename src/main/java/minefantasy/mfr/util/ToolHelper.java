package minefantasy.mfr.util;

import minefantasy.mfr.api.crafting.CustomCrafterEntry;
import minefantasy.mfr.api.tier.IToolMaterial;
import minefantasy.mfr.api.tool.IToolMFR;
import minefantasy.mfr.api.weapon.ISharpenable;
import minefantasy.mfr.constants.Tool;
import minefantasy.mfr.init.MFRDataComponents;
import minefantasy.mfr.item.component.CraftQualityDataComponent;
import minefantasy.mfr.item.component.SharpnessDataComponent;
import minefantasy.mfr.item.component.SpecialTypeDataComponent;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.context.UseOnContext;

import java.util.ArrayList;
import java.util.Objects;

public class ToolHelper {
    // CRAFTER TOOLS//

    public static boolean shouldShowTooltip(ItemStack stack) {
        Tool tool = getToolTypeFromStack(stack);
        return !(tool == Tool.HANDS || tool == Tool.OTHER);
    }

    public static float getCrafterEfficiency(ItemStack tool) {
        if (tool.isEmpty()) {
            return 1F;
        }
        if (tool.getItem() instanceof IToolMFR) {
            return ((IToolMFR) tool.getItem()).getEfficiency(tool);
        }
        return CustomCrafterEntry.getEntryEfficiency(tool);
    }

    // MATERIALS//

    public static int getCrafterTier(ItemStack tool) {
        if (tool.isEmpty()) {
            return 0;
        }
        if (tool.getItem() instanceof IToolMFR) {
            return ((IToolMFR) tool.getItem()).getTier(tool);
        }
        return CustomCrafterEntry.getEntryTier(tool);
    }

    // TODO(ItemWashCloth)
    /*public static boolean isStackValidWashTool(ItemStack stack) {
        return ToolHelper.getToolTypeFromStack(stack) == Tool.WASH && stack.getDamageValue() != ToolHelper.getWashMaxUses(stack);
    }

    public static int getWashMaxUses(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        }
        if (stack.getItem() instanceof ItemWashCloth clotch) {
            return cloth.getMaxUses();
        }
        return 0; //Todo add Custom Wash Entry
    }*/

    /**
     * Conduct Block Transformation on {@link Item#useOn(UseOnContext useOnContext)}
     * @param player The Player using the item
     * @param world The World
     * @param pos The Block Position of the block being transformed
     * @param hand The hand the Player is using the item with
     * @param facing The facing of the action
     * @return The {@link InteractionResult} which represents the result of the transformation
     */
    /*public static InteractionResult performBlockTransformation(
            Player player,
            Level world,
            BlockPos pos,
            InteractionHand hand,
            Direction facing) {

        ItemStack tool = player.getItemInHand(hand);
        BlockState oldState = world.getBlockState(pos);

        // Find Recipe
        ItemStack input = new ItemStack(oldState.getBlock());
        //if (input.getItem().getHasSubtypes()) {
        //    input = new ItemStack(oldState.getBlock(), 1, oldState.getBlock().getMetaFromState(oldState));
        //}
        TransformationRecipeBase recipe = CraftingManagerTransformation
                .findMatchingRecipe(tool, input, oldState, pos, player, facing);

        if (recipe == null) {
            return InteractionResult.FAIL;
        }

        if (!world.isClientSide) {
            //We assume the recipe's transformation is valid
            return recipe.onUsedWithBlock(world, pos, oldState, tool, player, facing);
        }
        else {
            player.swing(hand);
            if (recipe.getSound() != null) {
                world.playSound(player, pos, recipe.getSound(), SoundSource.BLOCKS, 1F, 1F);
            }
        }
        return InteractionResult.FAIL;
    }*/

    /**
     * Checks the specified ItemStack's Tool type. Returns OTHER if it has no valid tool nbt tag
     *
     * @param stack The item stack to check
     * @return
     */
    public static Tool getToolTypeFromStack(ItemStack stack) {
        if (stack == null) {
            MFRLogUtil.logWarn("Attempted to get the tool type of a null ItemStack");
            return Tool.HANDS;
        }

        if (stack.isEmpty()) {
            return Tool.HANDS;
        }

        if (stack.getItem() instanceof IToolMFR tool) {
            return tool.getToolType(stack);
        }

        if (CustomCrafterEntry.getEntry(stack) != null) {
            return CustomCrafterEntry.getEntryType(stack);
        }

        return Tool.OTHER;
    }

    /**
     * Compares an itemstack to see if the item is made from the said material ONLY
     * APPLIES TO IToolMaterial in api.
     */
    public static boolean isItemMaterial(ItemStack stack, Tier material) {
        // You need the item to implement this so it can see
        if (!stack.isEmpty() && stack.getItem() instanceof IToolMaterial mat) {
            return mat.getMaterial() != null && mat.getMaterial() == material;
        }
        return false;
    }

    public static ItemStack setQuality(ItemStack item, float qualityLvl) {
        if (item.getMaxStackSize() > 0)
            return item;

        item.set(MFRDataComponents.CRAFT_QUALITY_DATA_COMPONENT_TYPE.get(), new CraftQualityDataComponent(qualityLvl));

        return item;
    }

    /**
     * Gets how well an item has been crafted: 100 is default ranging from 0-200
     */
    public static float getQualityLevel(ItemStack stack) {
        if (stack.getMaxStackSize() == 1) {
            if (stack.has(MFRDataComponents.CRAFT_QUALITY_DATA_COMPONENT_TYPE.get())) {
                return Objects.requireNonNull(stack.get(MFRDataComponents.CRAFT_QUALITY_DATA_COMPONENT_TYPE.get())).quality();
            }
        }
        return 100.0F;
    }

    public static int setDuraOnQuality(ItemStack item, int dura) {
        float quality = getQualityLevel(item);
        if (item.has(MFRDataComponents.INFERIOR_QUALITY_DATA_COMPONENT_TYPE.get())) {
            if (Objects.requireNonNull(item.get(MFRDataComponents.INFERIOR_QUALITY_DATA_COMPONENT_TYPE.get())).isInferior()) {
                dura /= 2;
            } else {
                dura *= 2;
            }
        }

        if (quality > 100) {
            dura += (int) ((dura) / 100F * (quality - 100));// This means 100+ adds to 2x durability at level 200
        }
        if (quality < 100) {
            dura -= (int) ((dura * 0.75) / 100 * (100F - quality));// This means 100- takes upto 75% from it's max durability
            // lvl0 is 25%dura
        }
        return dura;
    }

    public static float modifyDigOnQuality(ItemStack item, float digspeed) {
        if (item.has(MFRDataComponents.INFERIOR_QUALITY_DATA_COMPONENT_TYPE.get())) {
            if (Objects.requireNonNull(item.get(MFRDataComponents.INFERIOR_QUALITY_DATA_COMPONENT_TYPE.get())).isInferior()) {
                digspeed /= 1.25F;
            } else {
                digspeed *= 1.25F;
            }
        }
        float quality = getQualityLevel(item);

        if (quality > 100) {
            digspeed += ((digspeed * 0.5F) / 100F * (quality - 100));// This means 100+ adds 50% speed at level 200
        }
        if (quality < 100) {
            digspeed -= ((digspeed * 0.5f) / 100f * (100F - quality));// This means 100- takes upto 50% from it's max
            // speed lvl0 is 50% speed
        }
        return digspeed;
    }

    // NBT//

    public static float modifyDamOnQuality(ItemStack item, float damage) {
        float quality = getQualityLevel(item);
        if (item.has(MFRDataComponents.INFERIOR_QUALITY_DATA_COMPONENT_TYPE.get())) {
            if (Objects.requireNonNull(item.get(MFRDataComponents.INFERIOR_QUALITY_DATA_COMPONENT_TYPE.get())).isInferior()) {
                damage /= 1.25F;
            } else {
                damage *= 1.25F;
                }
        }

        if (quality > 100) {
            damage += ((damage * 0.25F) / 100F * (quality - 100));// This means 100+ adds 25% damage at level 200
        }
        if (quality < 100) {
            damage -= ((damage * 0.25f) / 100f * (100F - quality));// This means 100- takes upto 25% from it's max damage
            // lvl0 is 75% damage
        }
        return damage;
    }

    public static float modifyArmourRating(ItemStack item, float rating) {
        float quality = getQualityLevel(item);
        if (item.has(MFRDataComponents.INFERIOR_QUALITY_DATA_COMPONENT_TYPE.get())) {
            if (Objects.requireNonNull(item.get(MFRDataComponents.INFERIOR_QUALITY_DATA_COMPONENT_TYPE.get())).isInferior()) {
                rating /= 1.25F;
            } else {
            rating *= 1.25F;
            }
        }

        if (quality > 100) {
            rating += ((rating * 0.5F) / 100F * (quality - 100));// This means 100+ adds 50% armour at level 200
        }
        if (quality < 100) {
            rating -= ((rating * 0.5f) / 100f * (100F - quality));// This means 100- takes upto 50% from it's max armour
            // lvl0 is 50% armour
        }
        return rating;
    }

    public static boolean hasCustomQualityTag(ItemStack item) {
        return item.has(MFRDataComponents.CRAFT_QUALITY_DATA_COMPONENT_TYPE.get());
    }

    public static void setSpecial(ItemStack item, String type) {
        item.set(MFRDataComponents.SPECIAL_TYPE_DATA_COMPONENT_TYPE.get(),
                new SpecialTypeDataComponent(type));
    }

    public static boolean isSpecial(ItemStack item, String type) {
        String special = getSpecial(item);
        return special != null && special.equals(type);
    }

    public static String getSpecial(ItemStack item) {
        if (item.has(MFRDataComponents.SPECIAL_TYPE_DATA_COMPONENT_TYPE.get()))
            return Objects.requireNonNull(item.get(MFRDataComponents.SPECIAL_TYPE_DATA_COMPONENT_TYPE.get())).type();
        return null;
    }

    public static void setToolSharpness(ItemStack item, float level) {
        float currentLevel = getSharpnessLevel(item);
        float maxLevel = getMaxSharpness(item);
        item.set(MFRDataComponents.SHARPNESS_DATA_COMPONENT_TYPE.get(),
                new SharpnessDataComponent(Math.min(maxLevel, currentLevel + level)));
    }

    public static float getSharpnessLevel(ItemStack item) {
        if (item.has(MFRDataComponents.SHARPNESS_DATA_COMPONENT_TYPE.get()))
            return Objects.requireNonNull(item.get(MFRDataComponents.SHARPNESS_DATA_COMPONENT_TYPE.get())).sharpness();
        return 0F;
    }

    public static boolean canBeSharpened(ItemStack itemstack, float level) {
        if (itemstack.isEmpty())
            return false;
        return false;
    }

    /**
     * The max amount of uses of sharpness
     */
    public static float getMaxSharpness(ItemStack item) {
        return getSharpnessTraits(item)[0];
    }

    /**
     * The max percent that it can increase damage
     */
    public static float getMaxSharpnessPercent(ItemStack item) {
        return getSharpnessTraits(item)[1];
    }

    /**
     * The modifier for how much percent is added each use
     */
    public static float getSharpUsesModifier(ItemStack item) {
        return getSharpnessTraits(item)[2];
    }

    // maxSharpness, maxBuff, sharpnessModifier
    public static float[] getSharpnessTraits(ItemStack item) {
        float[] list = new float[] {100, 20F, 3F};

        if (!item.isEmpty() && item.getItem() instanceof ISharpenable instance) {
            list[0] = instance.getMaxSharpness(item);
            list[1] = instance.getDamagePercentMax(item);
            list[2] = instance.getSharpUsesModifier(item);
        }
        return list;
    }

    public static String[] breakdownLineForResearchArray(String string) {
        String temp = "";
        ArrayList<String> entries = new ArrayList<String>();

        for (int a = 0; a < string.length(); a++) {
            if (a == string.length() - 1) {
                temp = temp + string.charAt(a);
            }
            if (string.charAt(a) == ' ' || a == string.length() - 1) {
                entries.add(temp);
            } else {
                if (string.charAt(a) != ' ') {
                    temp = temp + string.charAt(a);
                }
            }
        }
        int size = entries.size();
        String[] stringList = new String[size];
        for (int i = 0; i < size; i++) {
            stringList[i] = entries.get(i);
        }
        return stringList;
    }

    @Deprecated
    public static boolean isToolSufficient(ItemStack heldItem, String toolNeeded, int toolTierNeeded) {
        Tool tool = getToolTypeFromStack(heldItem);

        int tier = getCrafterTier(heldItem);

        return tool.getName().equals(toolNeeded) && tier >= toolTierNeeded;
    }

    public static boolean isToolSufficient(ItemStack heldItem, Tool toolNeeded, int toolTierNeeded) {
        Tool tool = getToolTypeFromStack(heldItem);

        int tier = getCrafterTier(heldItem);

        return tool == toolNeeded && tier >= toolTierNeeded;
    }

    public static void setUnbreakable(ItemStack tool, boolean isUnbreakable) {
        Unbreakable unbreakable = tool.get(DataComponents.UNBREAKABLE);
        if (unbreakable == null)
            unbreakable = new Unbreakable(isUnbreakable);
        tool.set(DataComponents.UNBREAKABLE, unbreakable.withTooltip(isUnbreakable));
    }
}
