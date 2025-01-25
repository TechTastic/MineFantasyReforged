package minefantasy.mfr.datagen;

import minefantasy.mfr.init.MFRBlocks;
import minefantasy.mfr.init.MFRTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class MFRRecipesDatagen extends RecipeProvider {
    public static final TagKey<Item> WOODEN_RODS = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("c", "rods/wooden"));

    public MFRRecipesDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        generateRecipes(recipeOutput, MFRBlocks.YEW_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        woodFromLogs(recipeOutput, MFRBlocks.YEW_WOOD, MFRBlocks.YEW_LOG);
        woodFromLogs(recipeOutput, MFRBlocks.STRIPPED_YEW_WOOD, MFRBlocks.STRIPPED_YEW_LOG);
        planksFromLog(recipeOutput, MFRBlocks.YEW_PLANKS, MFRTags.Items.YEW_LOGS, 4);
        
        generateRecipes(recipeOutput, MFRBlocks.IRONBARK_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        woodFromLogs(recipeOutput, MFRBlocks.IRONBARK_WOOD, MFRBlocks.IRONBARK_LOG);
        woodFromLogs(recipeOutput, MFRBlocks.STRIPPED_IRONBARK_WOOD, MFRBlocks.STRIPPED_IRONBARK_LOG);
        planksFromLog(recipeOutput, MFRBlocks.IRONBARK_PLANKS, MFRTags.Items.IRONBARK_LOGS, 4);
        
        generateRecipes(recipeOutput, MFRBlocks.EBONY_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        woodFromLogs(recipeOutput, MFRBlocks.EBONY_WOOD, MFRBlocks.EBONY_LOG);
        woodFromLogs(recipeOutput, MFRBlocks.STRIPPED_EBONY_WOOD, MFRBlocks.STRIPPED_EBONY_LOG);
        planksFromLog(recipeOutput, MFRBlocks.EBONY_PLANKS, MFRTags.Items.EBONY_LOGS, 4);
    }
}
