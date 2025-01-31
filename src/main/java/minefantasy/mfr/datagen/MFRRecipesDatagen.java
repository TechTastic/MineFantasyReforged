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
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class MFRRecipesDatagen extends RecipeProvider {
    public static final TagKey<Item> WOODEN_RODS = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("c", "rods/wooden"));
    public final CompletableFuture<HolderLookup.Provider> registries;

    public MFRRecipesDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
        this.registries = registries;
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        generateRecipes(recipeOutput, MFRBlocks.COBBLE_BRICK_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.COBBLE_BRICKS, Blocks.COBBLESTONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.COBBLE_BRICK_STAIRS, Blocks.COBBLESTONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.COBBLE_BRICK_SLAB, Blocks.COBBLESTONE, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.COBBLE_BRICK_WALL, Blocks.COBBLESTONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.COBBLE_BRICK_STAIRS, MFRBlocks.COBBLE_BRICKS);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.COBBLE_BRICK_SLAB, MFRBlocks.COBBLE_BRICKS, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.COBBLE_BRICK_WALL, MFRBlocks.COBBLE_BRICKS);



        stainedGlassPaneFromStainedGlass(recipeOutput, MFRBlocks.WINDOW_PANE, MFRBlocks.WINDOW);
        stainedGlassPaneFromStainedGlass(recipeOutput, MFRBlocks.FRAMED_GLASS_PANE, MFRBlocks.FRAMED_GLASS);



        generateRecipes(recipeOutput, MFRBlocks.THATCH_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());



        generateRecipes(recipeOutput, MFRBlocks.FIREBRICK_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.FIREBRICK_STAIRS, MFRBlocks.FIREBRICKS);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.FIREBRICK_SLAB, MFRBlocks.FIREBRICKS, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.FIREBRICK_WALL, MFRBlocks.FIREBRICKS);
        generateRecipes(recipeOutput, MFRBlocks.CLAY_PANEL_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());



        generateRecipes(recipeOutput, MFRBlocks.REFINED_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        generateRecipes(recipeOutput, MFRBlocks.NAILED_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());



        generateRecipes(recipeOutput, MFRBlocks.REINFORCED_STONE_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.REINFORCED_STONE_STAIRS, MFRBlocks.REINFORCED_STONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.REINFORCED_STONE_SLAB, MFRBlocks.REINFORCED_STONE, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.REINFORCED_STONE_WALL, MFRBlocks.REINFORCED_STONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.REINFORCED_STONE_BRICKS, MFRBlocks.REINFORCED_STONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.REINFORCED_STONE_BRICK_STAIRS, MFRBlocks.REINFORCED_STONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.REINFORCED_STONE_BRICK_SLAB, MFRBlocks.REINFORCED_STONE, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.REINFORCED_STONE_BRICK_WALL, MFRBlocks.REINFORCED_STONE);



        generateRecipes(recipeOutput, MFRBlocks.REINFORCED_STONE_BRICK_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.REINFORCED_STONE_BRICK_STAIRS, MFRBlocks.REINFORCED_STONE_BRICKS);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.REINFORCED_STONE_BRICK_SLAB, MFRBlocks.REINFORCED_STONE_BRICKS, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.REINFORCED_STONE_BRICK_WALL, MFRBlocks.REINFORCED_STONE_BRICKS);
        generateRecipes(recipeOutput, MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_STAIRS, MFRBlocks.MOSSY_REINFORCED_STONE_BRICKS);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_SLAB, MFRBlocks.MOSSY_REINFORCED_STONE_BRICKS, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_WALL, MFRBlocks.MOSSY_REINFORCED_STONE_BRICKS);
        generateRecipes(recipeOutput, MFRBlocks.CRACKED_REINFORCED_STONE_BRICK_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.CRACKED_REINFORCED_STONE_BRICK_STAIRS, MFRBlocks.CRACKED_REINFORCED_STONE_BRICKS);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.CRACKED_REINFORCED_STONE_BRICK_SLAB, MFRBlocks.CRACKED_REINFORCED_STONE_BRICKS, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.CRACKED_REINFORCED_STONE_BRICK_WALL, MFRBlocks.CRACKED_REINFORCED_STONE_BRICKS);



        generateRecipes(recipeOutput, MFRBlocks.FRAMED_REINFORCED_STONE_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.FRAMED_REINFORCED_STONE_STAIRS, MFRBlocks.FRAMED_REINFORCED_STONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.FRAMED_REINFORCED_STONE_SLAB, MFRBlocks.FRAMED_REINFORCED_STONE, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.FRAMED_REINFORCED_STONE_WALL, MFRBlocks.FRAMED_REINFORCED_STONE);
        generateRecipes(recipeOutput, MFRBlocks.IRON_FRAMED_REINFORCED_STONE_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.IRON_FRAMED_REINFORCED_STONE_STAIRS, MFRBlocks.IRON_FRAMED_REINFORCED_STONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.IRON_FRAMED_REINFORCED_STONE_SLAB, MFRBlocks.IRON_FRAMED_REINFORCED_STONE, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.IRON_FRAMED_REINFORCED_STONE_WALL, MFRBlocks.IRON_FRAMED_REINFORCED_STONE);



        generateRecipes(recipeOutput, MFRBlocks.LIMESTONE_FAMILY.get(), FeatureFlags.REGISTRY.allFlags());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.LIMESTONE_STAIRS, MFRBlocks.LIMESTONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.LIMESTONE_SLAB, MFRBlocks.LIMESTONE, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.LIMESTONE_WALL, MFRBlocks.LIMESTONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.LIMESTONE_BRICKS, MFRBlocks.LIMESTONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.LIMESTONE_BRICK_STAIRS, MFRBlocks.LIMESTONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.LIMESTONE_BRICK_SLAB, MFRBlocks.LIMESTONE, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.LIMESTONE_BRICK_WALL, MFRBlocks.LIMESTONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.COBBLE_LIMESTONE_STAIRS, MFRBlocks.COBBLE_LIMESTONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.COBBLE_LIMESTONE_SLAB, MFRBlocks.COBBLE_LIMESTONE, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.COBBLE_LIMESTONE_WALL, MFRBlocks.COBBLE_LIMESTONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.LIMESTONE_BRICK_STAIRS, MFRBlocks.LIMESTONE_BRICKS);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.LIMESTONE_BRICK_SLAB, MFRBlocks.LIMESTONE_BRICKS, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, MFRBlocks.LIMESTONE_BRICK_WALL, MFRBlocks.LIMESTONE_BRICKS);
        smeltingResultFromBase(recipeOutput, MFRBlocks.LIMESTONE, MFRBlocks.COBBLE_LIMESTONE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MFRBlocks.LIMESTONE_BRICKS, 4)
                .pattern("##")
                .pattern("##")
                .define('#', MFRBlocks.LIMESTONE)
                .unlockedBy("has_limestone", has(MFRBlocks.LIMESTONE))
                .save(recipeOutput);



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
