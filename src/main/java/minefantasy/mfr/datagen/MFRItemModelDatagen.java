package minefantasy.mfr.datagen;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MFRBlocks;
import minefantasy.mfr.init.MFRItems;
import minefantasy.mfr.item.LanceItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class MFRItemModelDatagen extends ItemModelProvider {
    public MFRItemModelDatagen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MineFantasyReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        getBuilder("item/window_pane").parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", modLoc("block/window"));
        getBuilder("item/framed_glass_pane").parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", modLoc("block/framed_glass"));

        //withExistingParent(MFRBlocks.BRONZE_BARS.getId().toString(), mcLoc("item/generated"))
        //        .texture("layer0", modLoc("block/" + MFRBlocks.BRONZE_BARS.getId().getPath()));

        simpleBlockItem(MFRBlocks.ENGRAVED_REINFORCED_STONE_0.get());
        simpleBlockItem(MFRBlocks.ENGRAVED_REINFORCED_STONE_1.get());
        simpleBlockItem(MFRBlocks.ENGRAVED_REINFORCED_STONE_2.get());
        simpleBlockItem(MFRBlocks.ENGRAVED_REINFORCED_STONE_3.get());

        basicItem(MFRItems.BAR.get());

        withExistingParent(MFRItems.METAL_HUNK.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/hunk");
        basicItem(MFRItems.PLATE.get());
        basicItem(MFRItems.PLATE_HUGE.get());
        withExistingParent(MFRItems.SCALE_MESH.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/scalemesh");
        withExistingParent(MFRItems.CHAIN_MESH.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/chainmesh");
        withExistingParent(MFRItems.SPLINT_MESH.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/splintmesh");

        basicItem(MFRItems.TIMBER.get());
        basicItem(MFRItems.TIMBER_CUT.get());
        basicItem(MFRItems.TIMBER_PANE.get());

        twoPieceTools(MFRItems.STANDARD_SCALE_HELMET);
        twoPieceTools(MFRItems.STANDARD_SCALE_CHESTPLATE);
        twoPieceTools(MFRItems.STANDARD_SCALE_LEGGINGS);
        twoPieceTools(MFRItems.STANDARD_SCALE_BOOTS);
        twoPieceTools(MFRItems.STANDARD_CHAIN_HELMET);
        twoPieceTools(MFRItems.STANDARD_CHAIN_CHESTPLATE);
        twoPieceTools(MFRItems.STANDARD_CHAIN_LEGGINGS);
        twoPieceTools(MFRItems.STANDARD_CHAIN_BOOTS);
        twoPieceTools(MFRItems.STANDARD_SPLINT_HELMET);
        twoPieceTools(MFRItems.STANDARD_SPLINT_CHESTPLATE);
        twoPieceTools(MFRItems.STANDARD_SPLINT_LEGGINGS);
        twoPieceTools(MFRItems.STANDARD_SPLINT_BOOTS);
        twoPieceTools(MFRItems.STANDARD_PLATE_HELMET);
        twoPieceTools(MFRItems.STANDARD_PLATE_CHESTPLATE);
        twoPieceTools(MFRItems.STANDARD_PLATE_LEGGINGS);
        twoPieceTools(MFRItems.STANDARD_PLATE_BOOTS);

        getOrMakeDoubleScaleHandheldModel();
        getOrMakeTripleScaleHandheldModel();

        threePieceTools(MFRItems.STANDARD_SWORD);
        threePieceTools(MFRItems.STANDARD_WARAXE);
        threePieceTools(MFRItems.STANDARD_MACE);
        threePieceTools(MFRItems.STANDARD_DAGGER);
        tripleScaledThreePieceTools(MFRItems.STANDARD_SPEAR);
        doubleScaledThreePieceTools(MFRItems.STANDARD_GREATSWORD);
        doubleScaledThreePieceTools(MFRItems.STANDARD_BATTLEAXE);
        doubleScaledThreePieceTools(MFRItems.STANDARD_WARHAMMER);
        doubleScaledThreePieceTools(MFRItems.STANDARD_KATANA);
        tripleScaledThreePieceTools(MFRItems.STANDARD_HALBEARD);
        lance(MFRItems.STANDARD_LANCE);
        threePieceTools(MFRItems.STANDARD_PICK);
        threePieceTools(MFRItems.STANDARD_AXE);
        threePieceTools(MFRItems.STANDARD_SHOVEL);
        threePieceTools(MFRItems.STANDARD_HOE);
        threePieceTools(MFRItems.STANDARD_HEAVY_PICK);
        threePieceTools(MFRItems.STANDARD_HEAVY_SHOVEL);
        threePieceTools(MFRItems.STANDARD_HANDPICK);
        threePieceTools(MFRItems.STANDARD_TROW);
        doubleScaledThreePieceTools(MFRItems.STANDARD_SCYTHE);
        threePieceTools(MFRItems.STANDARD_MATTOCK);
        doubleScaledThreePieceTools(MFRItems.STANDARD_LUMBER);
        threePieceTools(MFRItems.STANDARD_HAMMMER);
        threePieceTools(MFRItems.STANDARD_HEAVY_HAMMMER);
        twoPieceTools(MFRItems.STANDARD_TONGS);
        twoPieceTools(MFRItems.STANDARD_SHEARS);
        threePieceTools(MFRItems.STANDARD_KNIFE);
        twoPieceTools(MFRItems.STANDARD_NEEDLE);
        threePieceTools(MFRItems.STANDARD_SAW);
        handheldItem(MFRItems.STANDARD_SPOON.get());
        handheldItem(MFRItems.STANDARD_MALLET.get());
        threePieceTools(MFRItems.STANDARD_SPANNER);
        withExistingParent(MFRItems.WASH_CLOTH_WOOL.getId().toString(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/wash_cloth_dry_0"));
        bow(MFRItems.STANDARD_BOW);
        twoPieceTools(MFRItems.STANDARD_ARROW);
        twoPieceTools(MFRItems.STANDARD_BOLT);
        twoPieceTools(MFRItems.STANDARD_ARROW_BODKIN);
        twoPieceTools(MFRItems.STANDARD_ARROW_BROAD);
    }

    public void lance(DeferredItem<LanceItem> item) {
        tripleScaledThreePieceTools(item).transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).scale(1.7f, 1.7f, 0.85f)
                .translation(0f, 11f, 0.5f).rotation(0, -90, 55).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).scale(1.7f, 1.7f, 0.85f)
                .translation(0f, 11f, 0.5f).rotation(0, 90, -55).end()
                .end();
    }

    public ItemModelBuilder getOrMakeDoubleScaleHandheldModel() {
        return withExistingParent("item/handheld/double", mcLoc("item/handheld")).transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .scale(1.7f, 1.7f, 0.85f)
                .translation(0f, 7.5f, 0.5f)
                .rotation(0, -90, 55)
                .end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .scale(1.7f, 1.7f, 0.85f)
                .translation(0f, 7.5f, 0.5f)
                .rotation(0, 90, -55)
                .end()

                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .scale(1.36f, 1.36f, 0.68f)
                .translation(1.13f, 7.8f, 1.13f)
                .rotation(0, -90, 25)
                .end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .scale(1.36f, 1.36f, 0.68f)
                .translation(1.13f, 7.8f, 1.13f)
                .rotation(0, 90, -25)
                .end()

                .transform(ItemDisplayContext.GROUND)
                .scale(2f, 2f, 1f)
                .translation(12f, 12f, 0f)
                .end().end();
    }

    public ItemModelBuilder getOrMakeTripleScaleHandheldModel() {
        return withExistingParent("item/handheld/triple", mcLoc("item/handheld")).transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).scale(2.55f, 2.55f, 0.85f)
                .translation(0f, 7f, 0.5f).rotation(0, -90, 55).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).scale(2.55f, 2.55f, 0.85f)
                .translation(0f, 7f, 0.5f).rotation(0, 90, -55).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).scale(2.04f, 2.04f, 0.68f)
                .translation(1.13f, 7.2f, 1.13f).rotation(0, -90, 25).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).scale(2.04f, 2.04f, 0.68f)
                .translation(1.13f, 7.2f, 1.13f).rotation(0, 90, -25).end()
                .transform(ItemDisplayContext.GROUND).scale(3f, 3f, 1f).translation(24f, 18f, 0f).end()
                .end();
    }

    public ItemModelBuilder doubleScaledThreePieceTools(DeferredItem<? extends Item> tool) {
        return threePieceTools(tool, "", "minefantasyreforged:item/handheld/double");
    }

    public ItemModelBuilder tripleScaledThreePieceTools(DeferredItem<? extends Item> tool) {
        return threePieceTools(tool, "", "minefantasyreforged:item/handheld/triple");
    }

    public void bow(DeferredItem<? extends Item> tool) {
        threePieceTools(tool, "", "item/bow")
                .override().predicate(mcLoc("pulling"), 1).model(threePieceTools(tool, "_pulling_0", "item/bow")).end()
                .override().predicate(mcLoc("pulling"), 1).predicate(mcLoc("pull"), 0.65f).model(threePieceTools(tool, "_pulling_1", "item/bow")).end()
                .override().predicate(mcLoc("pulling"), 1).predicate(mcLoc("pull"), 0.9f).model(threePieceTools(tool, "_pulling_2", "item/bow")).end();
    }

    public ItemModelBuilder threePieceTools(DeferredItem<? extends Item> tool, String suffix, String parent) {
        return withExistingParent(tool.getId() + suffix, mcLoc(parent))
                .texture("layer0", "item/" + tool.getId().getPath() + suffix)
                .texture("layer1", "item/" + tool.getId().getPath() + suffix + "_haft")
                .texture("layer2", "item/" + tool.getId().getPath() + suffix + "_detail");
    }

    public ItemModelBuilder threePieceTools(DeferredItem<? extends Item> tool, String suffix) {
        return threePieceTools(tool, suffix, "item/handheld");
    }

    public ItemModelBuilder threePieceTools(DeferredItem<? extends Item> tool) {
        return threePieceTools(tool, "");
    }

    public ItemModelBuilder twoPieceTools(DeferredItem<? extends Item> tool) {
        return withExistingParent(tool.getId().toString(), mcLoc("item/handheld"))
                .texture("layer0", "item/" + tool.getId().getPath())
                .texture("layer1", "item/" + tool.getId().getPath() + "_detail");
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(MineFantasyReforged.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
