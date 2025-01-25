package minefantasy.mfr.init;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.material.CustomMaterial;
import minefantasy.mfr.registry.CustomMaterialRegistry;
import minefantasy.mfr.registry.types.CustomMaterialTypeRegistry;
import minefantasy.mfr.util.CustomToolHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class MFRCreativeTabs {
    private static final DeferredRegister<CreativeModeTab> TABS;

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FORGED_TOOLS_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FORGED_WEAPONS_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FORGED_ARMOR_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ARCHERY_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> UTILITY_BLOCKS_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GADGETS_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MATERIALS_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ADVANCED_TOOLS_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CRAFTING_TOOLS_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ORES_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FOOD_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DRAGONFORGED_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ORNATE_TAB;
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PRIMITIVE_TAB;

    public static ItemStack constructTool(Item item, ResourceLocation location) {
        return CustomToolHelper.construct(item, location, MFRMaterials.OAK_WOOD);
    }

    public static ItemStack constructTool(Item item, CustomMaterial material) {
        return constructTool(item, material.getName(CustomMaterialRegistry.ACCESS));
    }

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
    
    static {
        TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MineFantasyReforged.MOD_ID);
        
        FORGED_TOOLS_TAB = TABS.register("forged_tools", () ->
                CreativeModeTab.builder()
                        .icon(() -> constructTool(MFRItems.STANDARD_AXE.get(), MFRMaterials.TIN_METAL))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_PICK.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_AXE.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_SHOVEL.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_HOE.get(), mat)).toList());
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.forged_tools"))
                        .build()
        );

        FORGED_WEAPONS_TAB = TABS.register("forged_weapons", () ->
                CreativeModeTab.builder()
                        .icon(() -> constructTool(MFRItems.STANDARD_SWORD.get(), MFRMaterials.TIN_METAL))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_SWORD.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_WARAXE.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_MACE.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_DAGGER.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_SPEAR.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_GREATSWORD.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_BATTLEAXE.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_WARHAMMER.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_KATANA.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_HALBEARD.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_LANCE.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_WARAXE.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_WARAXE.get(), mat)).toList());
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.forged_weapons"))
                        .withTabsBefore(FORGED_TOOLS_TAB.getId())
                        .build()
        );

        FORGED_ARMOR_TAB = TABS.register("forged_armour", () ->
                CreativeModeTab.builder()
                        .icon(() -> constructTool(MFRItems.STANDARD_PLATE_HELMET.get(), MFRMaterials.TIN_METAL))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            metals.forEach(mat -> output.acceptAll(List.of(
                                    constructTool(MFRItems.STANDARD_CHAIN_HELMET.get(), mat),
                                    constructTool(MFRItems.STANDARD_CHAIN_CHESTPLATE.get(), mat),
                                    constructTool(MFRItems.STANDARD_CHAIN_LEGGINGS.get(), mat),
                                    constructTool(MFRItems.STANDARD_CHAIN_BOOTS.get(), mat),

                                    constructTool(MFRItems.STANDARD_SCALE_HELMET.get(), mat),
                                    constructTool(MFRItems.STANDARD_SCALE_CHESTPLATE.get(), mat),
                                    constructTool(MFRItems.STANDARD_SCALE_LEGGINGS.get(), mat),
                                    constructTool(MFRItems.STANDARD_SCALE_BOOTS.get(), mat),

                                    constructTool(MFRItems.STANDARD_SPLINT_HELMET.get(), mat),
                                    constructTool(MFRItems.STANDARD_SPLINT_CHESTPLATE.get(), mat),
                                    constructTool(MFRItems.STANDARD_SPLINT_LEGGINGS.get(), mat),
                                    constructTool(MFRItems.STANDARD_SPLINT_BOOTS.get(), mat),

                                    constructTool(MFRItems.STANDARD_PLATE_HELMET.get(), mat),
                                    constructTool(MFRItems.STANDARD_PLATE_CHESTPLATE.get(), mat),
                                    constructTool(MFRItems.STANDARD_PLATE_LEGGINGS.get(), mat),
                                    constructTool(MFRItems.STANDARD_PLATE_BOOTS.get(), mat)
                            )));
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.forged_armour"))
                        .withTabsBefore(FORGED_WEAPONS_TAB.getId())
                        .build()
        );

        ARCHERY_TAB = TABS.register("archery", () ->
                CreativeModeTab.builder()
                        .icon(() -> CustomToolHelper.construct(MFRItems.STANDARD_BOW.get(), MFRMaterials.IRON_METAL, MFRMaterials.OAK_WOOD))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());
                            List<CustomMaterial> woods = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.WOOD_TYPES.get());

                            output.acceptAll(woods.stream().map(mat ->
                                    CustomToolHelper.construct(MFRItems.STANDARD_BOW.get(), MFRMaterials.IRON_METAL,
                                            mat.getName(CustomMaterialRegistry.ACCESS))).toList());

                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_ARROW.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_BOLT.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_ARROW_BODKIN.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_ARROW_BROAD.get(), mat)).toList());
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.archery"))
                        .withTabsBefore(FORGED_ARMOR_TAB.getId())
                        .build()
        );

        UTILITY_BLOCKS_TAB = TABS.register("utility_blocks", () ->
                CreativeModeTab.builder()
                        .icon(() -> CustomToolHelper.constructSingleColoredLayer(
                                MFRItems.TIMBER.get(), MFRMaterials.OAK_WOOD))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            //output.acceptAll(metals.stream().map(mat ->
                            //        constructTool(MFRItems.STANDARD_PICK.get(), mat)).toList());

                            output.accept(Items.IRON_INGOT);
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.utility_blocks"))
                        .withTabsBefore(ARCHERY_TAB.getId())
                        .build()
        );

        GADGETS_TAB = TABS.register("gadgets", () ->
                CreativeModeTab.builder()
                        .icon(() -> CustomToolHelper.constructSingleColoredLayer(
                                MFRItems.TIMBER.get(), MFRMaterials.OAK_WOOD))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            //output.acceptAll(metals.stream().map(mat ->
                            //        constructTool(MFRItems.STANDARD_PICK.get(), mat)).toList());

                            output.accept(Items.IRON_INGOT);
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.gadgets"))
                        .withTabsBefore(UTILITY_BLOCKS_TAB.getId())
                        .build()
        );
        
        MATERIALS_TAB = TABS.register("materials", () ->
                CreativeModeTab.builder()
                        .icon(() -> CustomToolHelper.constructSingleColoredLayer(
                                MFRItems.TIMBER.get(), MFRMaterials.OAK_WOOD))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> woods = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.WOOD_TYPES.get());
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            output.acceptAll(metals.stream().map(mat ->
                                    CustomToolHelper.constructSingleColoredLayer(MFRItems.BAR.get(),
                                            mat.getName(CustomMaterialRegistry.ACCESS))).toList());

                            output.acceptAll(woods.stream().map(mat ->
                                    CustomToolHelper.constructSingleColoredLayer(MFRItems.TIMBER.get(),
                                            mat.getName(CustomMaterialRegistry.ACCESS))).toList());
                            output.acceptAll(woods.stream().map(mat ->
                                    CustomToolHelper.constructSingleColoredLayer(MFRItems.TIMBER_CUT.get(),
                                            mat.getName(CustomMaterialRegistry.ACCESS))).toList());
                            output.acceptAll(woods.stream().map(mat ->
                                    CustomToolHelper.constructSingleColoredLayer(MFRItems.TIMBER_PANE.get(),
                                            mat.getName(CustomMaterialRegistry.ACCESS))).toList());
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.materials"))
                        .withTabsBefore(GADGETS_TAB.getId())
                        .build()
        );

        ADVANCED_TOOLS_TAB = TABS.register("advanced_tools", () ->
                CreativeModeTab.builder()
                        .icon(() -> constructTool(MFRItems.STANDARD_HANDPICK.get(), MFRMaterials.TIN_METAL))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_HEAVY_PICK.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_HEAVY_SHOVEL.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_HANDPICK.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_TROW.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_SCYTHE.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_MATTOCK.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_LUMBER.get(), mat)).toList());
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.advanced_tools"))
                        .withTabsBefore(MATERIALS_TAB.getId())
                        .build()
        );
        
        CRAFTING_TOOLS_TAB = TABS.register("crafting_tools", () ->
                CreativeModeTab.builder()
                        .icon(() -> constructTool(MFRItems.STANDARD_HAMMMER.get(), MFRMaterials.TIN_METAL))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_HAMMMER.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_HEAVY_HAMMMER.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_TONGS.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_SHEARS.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_KNIFE.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_NEEDLE.get(), mat)).toList());
                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_SAW.get(), mat)).toList());

                            output.acceptAll(List.of(
                                    constructTool(MFRItems.STANDARD_SPOON.get(), MFRMaterials.OAK_WOOD),
                                    constructTool(MFRItems.STANDARD_SPOON.get(), MFRMaterials.IRONBARK_WOOD),
                                    constructTool(MFRItems.STANDARD_SPOON.get(), MFRMaterials.EBONY_WOOD),
                                    constructTool(MFRItems.STANDARD_MALLET.get(), MFRMaterials.OAK_WOOD),
                                    constructTool(MFRItems.STANDARD_MALLET.get(), MFRMaterials.IRONBARK_WOOD),
                                    constructTool(MFRItems.STANDARD_MALLET.get(), MFRMaterials.EBONY_WOOD)
                            ));

                            output.acceptAll(metals.stream().map(mat ->
                                    constructTool(MFRItems.STANDARD_SPANNER.get(), mat)).toList());

                            // Engineering Tools
                            // Paint Brush
                            output.accept(MFRItems.WASH_CLOTH_WOOL);
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.crafting_tools"))
                        .withTabsBefore(ADVANCED_TOOLS_TAB.getId())
                        .build()
        );

        ORES_TAB = TABS.register("ores", () ->
                CreativeModeTab.builder()
                        .icon(() -> CustomToolHelper.constructSingleColoredLayer(
                                MFRItems.TIMBER.get(), MFRMaterials.OAK_WOOD))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            //output.acceptAll(metals.stream().map(mat ->
                            //        constructTool(MFRItems.STANDARD_PICK.get(), mat)).toList());
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.ores"))
                        .withTabsBefore(CRAFTING_TOOLS_TAB.getId())
                        .build()
        );

        FOOD_TAB = TABS.register("food", () ->
                CreativeModeTab.builder()
                        .icon(() -> CustomToolHelper.constructSingleColoredLayer(
                                MFRItems.TIMBER.get(), MFRMaterials.OAK_WOOD))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            //output.acceptAll(metals.stream().map(mat ->
                            //        constructTool(MFRItems.STANDARD_PICK.get(), mat)).toList());
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.food"))
                        .withTabsBefore(ORES_TAB.getId())
                        .build()
        );

        DRAGONFORGED_TAB = TABS.register("dragonforged", () ->
                CreativeModeTab.builder()
                        .icon(() -> CustomToolHelper.constructSingleColoredLayer(
                                MFRItems.TIMBER.get(), MFRMaterials.OAK_WOOD))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            //output.acceptAll(metals.stream().map(mat ->
                            //        constructTool(MFRItems.STANDARD_PICK.get(), mat)).toList());
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.dragonforged"))
                        .withTabsBefore(FOOD_TAB.getId())
                        .build()
        );

        ORNATE_TAB = TABS.register("ornate", () ->
                CreativeModeTab.builder()
                        .icon(() -> CustomToolHelper.constructSingleColoredLayer(
                                MFRItems.TIMBER.get(), MFRMaterials.OAK_WOOD))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            //output.acceptAll(metals.stream().map(mat ->
                            //        constructTool(MFRItems.STANDARD_PICK.get(), mat)).toList());
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.ornate"))
                        .withTabsBefore(DRAGONFORGED_TAB.getId())
                        .build()
        );

        PRIMITIVE_TAB = TABS.register("primitive", () ->
                CreativeModeTab.builder()
                        .icon(() -> CustomToolHelper.constructSingleColoredLayer(
                                MFRItems.TIMBER.get(), MFRMaterials.OAK_WOOD))
                        .displayItems((param, output) -> {
                            List<CustomMaterial> metals = CustomMaterialRegistry.getList(CustomMaterialRegistry.ACCESS,
                                    CustomMaterialTypeRegistry.METAL_TYPES.get());

                            //output.acceptAll(metals.stream().map(mat ->
                            //        constructTool(MFRItems.STANDARD_PICK.get(), mat)).toList());
                        })
                        .title(Component.translatable("itemGroup.minefantasyreforged.primitive"))
                        .withTabsBefore(ORNATE_TAB.getId())
                        .build()
        );
    }
}
