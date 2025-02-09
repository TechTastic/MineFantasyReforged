package minefantasy.mfr.datagen;

import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.init.MFRBlocks;
import minefantasy.mfr.init.MFRItems;
import minefantasy.mfr.init.MFRTags;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class MFRLanguageDatagen extends LanguageProvider {
    public MFRLanguageDatagen(PackOutput output) {
        super(output, MineFantasyReforged.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // TAGS

        addTag(() -> MFRTags.Items.YEW_LOGS, "Yew Logs");
        addTag(() -> MFRTags.Items.IRONBARK_LOGS, "Ironbark Logs");
        addTag(() -> MFRTags.Items.EBONY_LOGS, "Ebony Logs");
        addTag(() -> MFRTags.Blocks.YEW_LOGS, "Yew Logs");
        addTag(() -> MFRTags.Blocks.IRONBARK_LOGS, "Ironbark Logs");
        addTag(() -> MFRTags.Blocks.EBONY_LOGS, "Ebony Logs");

        // INFORMATION

        add("forge.fuel.name", "~Fuel~");
        add("vehicle.fuel.name", "Fuel: %1$s");
        add("info.bow.reload", "Right-Click while sneaking to open firearm.");
        add("info.bow.reload_custom", "Press [%1$s] to open firearm.");
        add("info.firearm.ammo", "%1$s/%2$s");
        add("info.tooltip.more_info", "Hold [%1$s] for more information.");
        add("message.mythic_ore_sound", "You hear a chiming sound from %1$s");
        add("message.definite_article", "the");
        add("message.below", "BELOW");
        add("message.above", "ABOVE");
        add("info.salvage.usage", "Drop a valid item on top of the Salvage Block to salvage it");
        add("gui.no_project_set", "<No Project Set>");
        add("gui.kitchen_bench_dirty_progress", "Dirtiness");
        add("info.offBalance.message", "Trying to use a heavy weapon with only one hand throws you off balance!");
        add("info.noHeatProtection.message", "Ouch! Maybe I should get some blacksmithing equipment for this...");
        add("info.vomiting.message.above", "*Blargh!* Eating that many %1$s that quickly can't be good for you...");
        add("info.dragonforged.ritual.failure", "The Ritual fails due to insufficient heat!");

        add("attribute.kit.salvage.name", "Salvage Modifier");

        add("attribute.kit.repairRate.name", "Repair Value");
        add("attribute.kit.repairRate_enchant.name", "Repair Value (Enchanted Items)");
        add("attribute.kit.repairRate_normal.name", "Repair Value (Normal Items)");

        add("attribute.kit.repairChance.name", "Repair Success Rate");
        add("attribute.kit.breakChance.name", "Kit Break Chance");

        add("attribute.inferior.name", "Inferior");
        add("attribute.superior.name", "Superior");

        add("item.infobook.name", "Research Book");
        add("item.research_scroll.name", "Research Scroll");
        add("item.research_scroll_complete.name", "Completed Research");

        add("item.talisman_lesser.name", "Lesser Knowledge Talisman");
        add("item.talisman_greater.name", "Greater Knowledge Talisman");

        add("item.engin_anvil_tools.name", "Engineering Tools");

        add("prospect.canmine", "You can mine this! (Tool: %1$s)");
        add("prospect.cannotmine", "This cannot be mined with this tool! (Tool: %1$s)");
        add("gui.information", "Research");
        add("information.discovered", "Researched");
        add("information.buy", "Click for Research");
        add("knowledge.unknownUse", "You don't know how to use this!");
        add("knowledge.known", "You already know this");
        add("knowledge.has_scroll", "knowledge.has_scroll");

        add("infoPage.basic", "Basic Information");
        add("infoPage.artisanry", "Artisanry");
        add("infoPage.construction", "Construction");
        add("infoPage.provisioning", "Provisioning");
        add("infoPage.engineering", "Engineering");
        add("infoPage.mastery", "Mastery");
        add("infoPage.dwarvern", "Dwarvern");
        add("infoPage.gnomish", "Gnomish");

        add("knowledge.unlocked", "Research Completed");

        add("vehicle.noArmour", "You cannot fit in this suit when apparel is worn.");
        add("vehicle.tooBigArmour", "Your worn items make you too big to fit.");
        add("vehicle.noBolts", "You have no bolts on you, and you need 16 in total to armor your suit.");
        add("vehicle.noFuel", "The Cogwork Suit needs coke as fuel to operate.");
        add("vehicle.outOfFuel", "The Cogwork Suit is out of Fuel!");
        add("vehicle.noFrame", "You need a proper Frame Assembly to insert the Pulley.");
        add("vehicle.noPulley", "You do not have a Pulley on you.");

        add("research.noskill", "You may learn something from this, with more skill.");
        add("research.noresearch", "You may learn something from this, with more knowledge.");
        add("research.null", "There is nothing to learn from this.");

        add("research.addArtefact", "Added Knowledge to %1$s (%2$s/%3$s)");
        add("research.finishResearch", "Finished Research for %1$s");
        add("research.cluecount", " (%1$s/%2$s)");
        add("research.requires", "Requires %1$s");
        add("research.unknown", "Unknown Research");

        // MOBS

        /*
        entity.MF_Minotaur.name=Minefantasy Minotaur
        entity.MF_Dragon.name=Minefantasy Dragon
        death.attack.dragonstomp=%1$s was stomped by a Dragon
        death.attack.humanstomp=%1$s was stomped by %2$s
        death.attack.fireblast=%1$s was incinerated by %2$s
        death.attack.fireblastBase=%1$s was incinerated
        death.attack.blastfurn=%1$s was incinerated by a Blast Furnace
        death.attack.frostblast=%1$s was frozen by %2$s
        death.attack.frostblastBase=%1$s was frozen
        death.attack.acidblast=%1$s was Vaporised by %2$s
        death.attack.acidblastBase=%1$s was Vaporised
        death.attack.ashblast=%1$s was Suffocated by %2$s
        death.attack.ashblastBase=%1$s was Suffocated

        death.attack.mob.pound=%1$s was pounded by a %2$s
        death.attack.mob.gore=%1$s was gored by a %2$s
        death.attack.mob.beserk=%1$s was torn apart by a %2$s

        entity.minotaur.name=Lesser Minotaur
        entity.minotaur_guard.name=Minotaur Warrior
        entity.minotaur_elite.name=Elite Minotaur
        entity.minotaur_boss.name=Minotaur Warlord

        entity.frost_minotaur.name=Lesser Frost Minotaur
        entity.frost_minotaur_guard.name=Frost Minotaur Warrior
        entity.frost_minotaur_elite.name=Elite Frost Minotaur
        entity.frost_minotaur_boss.name=Frost Minotaur Warlord

        entity.dread_minotaur.name=Lesser Dread Minotaur
        entity.dread_minotaur_guard.name=Dread Minotaur Bruiser
        entity.dread_minotaur_elite.name=Dread Minotaur Punisher
        entity.dread_minotaur_boss.name=Dread Minotaur Death Overlord

        entity.dragonbreed.red.name=Red
        entity.dragonbreed.white.name=Frost
        entity.dragonbreed.dire.name=Dire
        entity.dragonbreed.green.name=Green
        entity.dragonbreed.ash.name=Ash

        entity.dragon_young.name=Young %1$s Dragon
        entity.dragon.name=%1$s Dragon
        entity.dragon_mature.name=Mature %1$s Dragon
        entity.dragon_elder.name=Elder %1$s Dragon
        entity.dragon_ancient.name=Ancient %1$s Dragon

        event.dragonnear.name=A Dragon Prowls, take cover or stay to fight!
        event.dragonnear.forge.name=Your crafts insult dragon kind!
        event.dragonaway.name=The Dragon leaves... For now...

        entity.hound.name=Hound

        entity.bombMF.name=Bomb
        entity.landmineMF.name=Mine

        item.spawn_dragon.name=Spawn Dragon
        item.spawn_dragon.desc=Deadly winged reptiles.
        item.spawn_minotaur.name=Spawn Minotaur
        item.spawn_minotaur.desc=Brutal and mindless.
        item.spawn_hound.name=Spawn Hound
        item.spawn_hound.desc=Highly capable canines with variable traits.
        item.spawn_cogwork.name=Spawn Cogwork Suit
        item.spawn_cogwork.desc=Mechanical suit of superior strength
         */

        // TOOL LIST

        add("item.tool_pick.name", "%1$s Pick");
        add("item.commodity_timber.name", "%1$s Timber");
        add("item.haft.name", "Haft");
        add("item.commodity_metal_hunk.name", "%1$s Hunk");
        add("item.commodity_scrap.name", "%1$s Scrap");
        add("item.commodity_plate.name", "%1$s Plate");
        add("item.commodity_bar.name", "%1$s Bar");
        add("item.commodity_plate_huge.name", "Huge %1$s Plate");
        add("item.commodity_chain_mesh.name", "%1$s Chain Mesh");
        add("item.commodity_scales_mesh.name", "%1$s Scales Mesh");
        add("item.commodity_splint_mesh.name", "%1$s Splint Mesh");
        add("item.commodity_plate_heavy.name", "Heavy %1$s Plate");
        add("item.commodity_arrowhead.name", "%1$s Arrow Head");
        add("item.commodity_bodkin_head.name", "%1$s Bodkin Head");
        add("item.commodity_broad_head.name", "%1$s Broad Head");
        add("item.commodity_cogwork_armour.name", "%1$s Cogwork Plating");

        add("item.mod_plating.name", "%1$s Plating");
        add("item.mod_head.name", "%1$s Head");
        add("item.mod_haft.name", "%1$s Haft");
        add("item.mod_joints.name", "%1$s Joints");

        add("component.head.name", "%1$s Head");
        add("component.shaft.name", "%1$s Shaft");
        add("component.grip.name", "%1$s Grip");
        add("component.brace.name", "%1$s Brace");

        // MATERIAL LIST

        add("materialtype.minefantasyreforged.wood_types.name", "Tier %1$s Wood");
        add("materialtype.minefantasyreforged.leather_types.name", "Tier %1$s Leather");
        add("materialtype.minefantasyreforged.metal_types.name", "Tier %1$s Metal");
        add("materialtype.minefantasyreforged.none.name", "Tier %1$s Any");
        add("materialtype.workable.name", "Workable %1$s*C-%2$s*C");

        add("materialtype.resist.name", "%1$s Resistance");
        add("materialtype.fireresist.name", "%1$s Fire Resistance");
        add("materialtype.maxtemp.name", "%1$s*C Melting Point");
        add("material.any.name", "Any");

        // LEATHER

        add("material.leather.name", "Leather");
        add("material.hardleather.name", "Hardened Leather");
        add("material.monituarskin.name", "Minotaur Leather");
        add("material.dragonskin.name", "Dragon Skin");

        // MATERIAL LOCALIZATION OVERRIDES

        add("material.material_name.name", "Localized Name");

        // VANILLA ITEMS PREFIX OVERRIDES

        /*
        item.shears.name=Crude Shears
        item.hoeWood.name=Crude Wooden Hoe
        item.hatchetWood.name=Crude Wooden Axe
        item.pickaxeWood.name=Crude Wooden Pickaxe
        item.shovelWood.name=Crude Wooden Shovel
        item.swordWood.name=Crude Wooden Sword

        item.hoeStone.name=Crude Stone Hoe
        item.hatchetStone.name=Crude Stone Axe
        item.pickaxeStone.name=Crude Stone Pickaxe
        item.shovelStone.name=Crude Stone Shovel
        item.swordStone.name=Crude Stone Sword

        item.hoeIron.name=Crude Iron Hoe
        item.hatchetIron.name=Crude Iron Axe
        item.pickaxeIron.name=Crude Iron Pickaxe
        item.shovelIron.name=Crude Iron Shovel
        item.swordIron.name=Crude Iron Sword
        item.helmetIron.name=Crude Iron Helmet
        item.chestplateIron.name=Crude Iron Chestplate
        item.leggingsIron.name=Crude Iron Leggings
        item.bootsIron.name=Crude Iron Boots

        item.hoeGold.name=Crude Golden Hoe
        item.hatchetGold.name=Crude Golden Axe
        item.pickaxeGold.name=Crude Golden Pickaxe
        item.shovelGold.name=Crude Golden Shovel
        item.swordGold.name=Crude Golden Sword
        item.helmetGold.name=Crude Golden Helmet
        item.chestplateGold.name=Crude Golden Chestplate
        item.leggingsGold.name=Crude Golden Leggings
        item.bootsGold.name=Crude Golden Boots

        item.hoeDiamond.name=Crude Diamond Hoe
        item.hatchetDiamond.name=Crude Diamond Axe
        item.pickaxeDiamond.name=Crude Diamond Pickaxe
        item.shovelDiamond.name=Crude Diamond Shovel
        item.swordDiamond.name=Crude Diamond Sword
        item.helmetDiamond.name=Crude Diamond Helmet
        item.chestplateDiamond.name=Crude Diamond Chestplate
        item.leggingsDiamond.name=Crude Diamond Leggings
        item.bootsDiamond.name=Crude Diamond Boots

        item.helmetCloth.name=Crude Leather Cap
        item.chestplateCloth.name=Crude Leather Tunic
        item.leggingsCloth.name=Crude Leather Pants
        item.bootsCloth.name=Crude Leather Boots

        item.helmetChain.name=Crude Chain Helmet
        item.chestplateChain.name=Crude Chain Chestplate
        item.leggingsChain.name=Crude Chain Leggings
        item.bootsChain.name=Crude Chain Boots

        item.bow.name=Crude Bow
        item.arrow.name=Crude Arrow
         */

        // ITEM STATS

        add("prefix.hotitem.name", "Hit %1$s");
        add("state.workable", "Workable");
        add("state.unstable", "Unstable");
        add("attribute.weightt.name", "Weight: %1$st");
        add("attribute.weightKg.name", "Weight: %1$sKg");
        add("attribute.weightg.name", "Weight: %1$sg");
        add("attribute.nomfcrafttier.name", "Any Tier");
        add("attribute.mfcrafttier.name", "Tier");
        add("attribute.mfcrafttool.name", "Crafting Tool");
        add("attribute.mfcrafteff.name", "Crafting Efficiency");
        add("attribute.mfcraftedbyname.name", "Crafted By");
        add("tooltype.hammer", "Hammer");
        add("tooltype.heavy_hammer", "Heavy Hammer");
        add("tooltype.saw", "Saw");
        add("tooltype.knife", "Knife");
        add("tooltype.needle", "Needle");
        add("tooltype.mallet", "Mallet");
        add("tooltype.spoon", "Spoon");
        add("tooltype.hands", "Bare-Handed");
        add("tooltype.spanner", "Spanner");
        add("tooltype.shears", "Shears");
        add("tooltype.brush", "Paint Brush");
        add("tooltype.wash", "Wash");

        add("tooltype.anvil", "Anvil");
        add("tooltype.carpenter", "Carpenter Bench");
        add("tooltype.kitchen_bench", "Kitchen Bench");
        add("tooltype.tanner", "Tanner");

        add("attribute.tool.digEfficiency.name", "Dig Speed Modifier x%1$s");

        add("attribute.weapon.penetrateArmor", "Armor Penetration");
        add("attribute.weapon.daze", "Daze");
        add("attribute.weapon.extendedReach", "Reach");
        add("attribute.weapon.attackSpeed", "Attack Speed");
        add("attribute.weapon.backstab", "Backstab");
        add("attribute.weapon.mountedBonus", "Mounted Damage");
        add("attribute.weapon.joustDam", "Joust Damage");
        add("attribute.shield.block.time", "s Block");
        add("attribute.shield.arrow.count", "Arrows");
        add("attribute.quiver.arrow.empty", "Empty");
        add("attribute.quiver.arrow.count", "Arrows");

        add("attribute.armour.protection", "Armor Rating");
        add("attribute.armour.light", "Light Armor");
        add("attribute.armour.medium", "Medium Armor");
        add("attribute.armour.heavy", "Heavy Armor");
        add("attribute.weight.name", "Weight");

        add("attribute.bowPower.name", "Damage Modifier x%1$s");
        add("attribute.bowDrawbackSpeed.name", "Drawback Speed %1$ss");
        add("attribute.arrowPower.name", "Damage");

        add("attribute.armour.rating.0", "Cutting");
        add("attribute.armour.rating.1", "Blunt");
        add("attribute.armour.rating.2", "Piercing");

        add("attribute.armour.cuttingresistance", "Cutting Resistance");
        add("attribute.armour.bluntresistance", "Blunt Resistance");
        add("attribute.armour.piercingresistance", "Piercing Resistance");

        add("attribute.weapon.cutting", "Cutting Damage");
        add("attribute.weapon.blunt", "Blunt Damage");
        add("attribute.weapon.piercing", "Piercing Damage");

        add("attribute.armour.dtcutting", "Cutting Threshold");
        add("attribute.armour.dtblunt", "Blunt Threshold");
        add("attribute.armour.dtpiercing", "Piercing Threshold");

        add("arrow.head.normal.name", "Regular Head");
        add("arrow.head.bodkin.name", "Bodkin Head");
        add("arrow.head.broad.name", "Broad Head");

        add("item.world_gen_placer", "World Gen Placer");

        // INTEGRATION

        /*
        integration.jei.category.minefantasyreforged:carpenter=Carpenter Bench
        integration.jei.category.minefantasyreforged:anvil=MineFantasy Anvil
        integration.jei.category.minefantasyreforged:big_furnace=MineFantasy Big Furnace
        integration.jei.category.minefantasyreforged:crucible=MineFantasy Crucible
        integration.jei.category.minefantasyreforged:bloomery=MineFantasy Bloomery
        integration.jei.category.minefantasyreforged:blast_furnace=MineFantasy Blast Furnace
        integration.jei.category.minefantasyreforged:quern=MineFantasy Quern
        integration.jei.category.minefantasyreforged:tanner=MineFantasy Tanner
        integration.jei.category.minefantasyreforged:oven=MineFantasy Oven
        integration.jei.category.minefantasyreforged:stovetop=MineFantasy Stove Top
        integration.jei.category.minefantasyreforged:kitchen_bench=MineFantasy Kitchen Bench
        integration.jei.category.minefantasyreforged:salvage=MineFantasy Salvage
        integration.jei.category.minefantasyreforged:transformation=MineFantasy Transformation
        integration.jei.category.minefantasyreforged:special=MineFantasy Special Anvil
        item.flux.desc_extended=Flux is an important purification agent for metalworks, primarily this is used for the treatment of metals in the forging process and some alloy creation. The best source of flux is limestone.

        item.bowl_water_salt.desc_extended=Salt Water is used for crafting Salt. You can gather Salt Water by right-clicking a Clay Pot on water that is in an Ocean or Deep Ocean biome.

        tile.cheese_wheel.desc_extended=Cheese Wheels are used for getting cheese slices, simply place the wheel on the ground and use (right-click) a knife to cut a slice.
        item.cheese_slice.desc_extended=Cheese Slices are a great food source. You can get them by slicing a Cheese Wheel block with a knife, see the Cheese Wheel entry.

        tile.pie_meat.desc_extended=Meat Pies are used for getting meat pie slices, simply place the pie on the ground and use (right-click) a knife to cut a slice.
        item.meatpie_slice.desc_extended=Meat Pie Slices are a great food source. You can get them by slicing a Meat Pie block with a knife, see the Meat Pie entry.
        tile.pie_apple.desc_extended=Apple Pies are used for getting apple pie slices, simply place the pie on the ground and use (right-click) a knife to cut a slice.
        item.pieslice_apple.desc_extended=Apple Pie Slices are a great food source. You can get them by slicing a Apple Pie block with a knife, see the Apple Pie entry.
        tile.pie_berry.desc_extended=Berry Pies are used for getting berry pie slices, simply place the pie on the ground and use (right-click) a knife to cut a slice.
        item.pieslice_berry.desc_extended=Berry Pie Slices are a great food source. You can get them by slicing a Berry Pie block with a knife, see the Berry Pie entry.
        tile.pie_shepards.desc_extended=Shepard's Pies are used for getting shepard's pie slices, simply place the pie on the ground and use (right-click) a knife to cut a slice.
        item.pieslice_shepards.desc_extended=Shepard's Pies Slices are a great food source. You can get them by slicing a Shepard's Pie block with a knife, see the Shepard's Pie entry.

        tile.cake_vanilla.desc_extended=Cakes are used for getting cake slices, simple place the cake on the ground and use (right-click) a knife to cut a slice.
        item.cake_slice.desc_extended=Cake Slices are a great food source. You can get them by slicing the cake a Cake block with a knife, see the Cake entry.
        tile.cake_carrot.desc_extended=Carrot Cakes are used for getting carrot cake slices, simple place the cake on the ground and use (right-click) a knife to cut a slice.
        item.carrotcake_slice.desc_extended=Carrot Cake Slices are a great food source. You can get them by slicing the cake a Carrot Cake block with a knife, see the Carrot Cake entry.
        tile.cake_chocolate.desc_extended=Chocolate Cakes are used for getting chocolate cake slices, simple place the cake on the ground and use (right-click) a knife to cut a slice.
        item.choccake_slice.desc_extended=Chocolate Cake Slices are a great food source. You can get them by slicing the cake a Chocolate Cake block with a knife, see the Chocolate Cake entry.
        tile.cake_bf.desc_extended=Black Forest Cakes are used for getting black forest cake slices, simple place the cake on the ground and use (right-click) a knife to cut a slice.
        item.bfcake_slice.desc_extended=Black Forest Cake Slices are a great food source. You can get them by slicing the cake a Black Forest Cake block with a knife, see the Black Forest Cake entry.

        item.exploding_arrow.desc_extended=This is an Exploding Arrow, it can be crafted at the Bomb Bench. See the MFR Research Book entries for more info.
        item.exploding_bolt.desc_extended=This is an Exploding Quarrel, it can be crafted at the Bomb Bench. See the MFR Research Book entries for more info.
        item.bomb_casing_arrow.desc_extended=This is an Arrow Bomb Casing, used to craft Exploding Arrows, it can be crafted at the Bomb Bench. See the MFR Research Book entries for more info.
        item.bomb_casing_bolt.desc_extended=This is an Quarrel Bomb Casing, used to craft Exploding Quarrels, it can be crafted at the Bomb Bench. See the MFR Research Book entries for more info.

        item.bomb_custom.desc_extended=This is a Bomb, it can be crafted at the Bomb Bench. See the MFR Research Book entries for more info.
        item.mine_custom.desc_extended=This is a Mine, it can be crafted at the Bomb Bench. See the MFR Research Book entries for more info.
        item.bomb_component.desc_extended=This is a Bomb component, it can be used at the Bomb Bench to make Bombs/Mines. See the MFR Research Book entries for more info

        item.crossbow_custom.desc_extended=This is a Crossbow, it can be crafted at the Crossbow Bench. See the MFR Research Book entries for more info.
        item.crossbow_component.desc_extended=This is a Crossbow component, it can be used at the Crossbow Bench to make Crossbows. See the MFR Research Book entries for more info

        recipe.bar.desc=Any Material Ingot to Material Bar
        recipe.ingot.desc=Any Material Bar to Material Ingot
        recipe.tier.modify.output.desc=Higher Material Tier, Higher Output

        key.category.mfr.general=MineFantasy Reforged
        key.mfr.reload_menu=MFR Reload Menu
        key.mfr.remove_offhand=Remove item from offhand
         */

        // COMMODITY

        addItem(MFRItems.TIMBER, "Timber");
        add("item.jug_plant_oil.name", "Plant Oil Jug");
        add("item.plankRefined.name", "Refined Timber");
        add("item.rivet.name", "Rivets");
        add("item.nail.name", "Nails");
        add("item.thread.name", "Thread");
        add("item.lime_rock.name", "Limestone Rock");
        add("item.borax_rock.name", "Borax");
        add("item.flux.name", "Flux");
        add("item.flux_strong.name", "Strong Flux");
        add("item.prepared_coal.name", "Prepared Coal");
        add("item.blackpowder.name", "Blackpowder");
        add("item.blackpowder_advanced.name", "Advanced Blackpowder");
        add("item.bolt.name", "Bolts");
        add("item.flux_pot.name", "Fine Flux");
        add("item.coal_flux.name", "Coal Flux");

        add("item.tin_ingot.name", "Tin Ingot");
        add("item.bronze_ingot.name", "Bronze Ingot");
        add("item.pig_iron_ingot.name", "Pig Iron Ingot");
        add("item.steel_ingot.name", "Steel Ingot");
        add("item.encrusted_ingot.name", "Encrusted Ingot");
        add("item.obsidian_ingot.name", "Obsidian Ingot");
        add("item.silver_ingot.name", "Silver Ingot");
        add("item.pure_gold_ingot.name", "Pure Gold Ingot");
        add("item.composite_alloy_ingot.name", "Composite Alloyed Ingot");
        add("item.black_steel_weak_ingot.name", "Unrefined Black Steel");
        add("item.blue_steel_weak_ingot.name", "Unrefined Blue Steel");
        add("item.red_steel_weak_ingot.name", "Unrefined Red Steel");

        add("item.red_steel_ingot.name", "Red Steel Ingot");
        add("item.black_steel_ingot.name", "Black Steel Ingot");
        add("item.blue_steel_ingot.name", "Blue Steel Ingot");

        add("item.adamantium_ingot.name", "Adamantium Ingot");
        add("item.mithril_ingot.name", "Mithril Ingot");

        add("item.ignotumite_ingot.name", "Ignotumite Ingot");
        add("item.mithium_ingot.name", "Mithium Ingot");

        add("item.ender_ingot.name", "Enderforge Ingot");

        add("item.tungsten_ingot.name", "Wolframite Ingot");

        add("item.loot_sack_common.name", "Common Loot");
        add("item.loot_sack_valuable.name", "Valuable Loot");
        add("item.loot_sack_exquisite.name", "Exquisite Loot");

        add("item.copper_coin.name", "Copper Coin");
        add("item.silver_coin.name", "Silver Coin");
        add("item.gold_coin.name", "Gold Coin");

        // COMPONENT

        /*
        item.persistent_component_flag.name=Placed Component Marker
        item.ingot_mould.name=Ingot Mould
        item.ingot_mould_filled.name=Ingot Mould
        item.ingot_mould_uncooked.name=Raw Ingot Mould

        item.clay_pot.name=Clay Pot
        item.clay_pot_uncooked.name=Raw Clay Pot

        item.jug_empty.name=Empty Jug
        item.jug_uncooked.name=Raw Clay Jug
        item.jug_water.name=Water Jug
        item.jug_milk.name=Milk Jug

        tile.salvage_basic.name=Basic Salvage Station
        tile.salvage_advanced.name=Advanced Salvage Station

        tile.repair_kit_basic.name=Basic Repair Kit
        tile.repair_kit_advanced.name=Advanced Repair Kit
        tile.repair_kit_ornate.name=Ornate Repair Kit

        item.rawhide_small.name=Small Hide
        item.rawhide_medium.name=Medium Hide
        item.rawhide_large.name=Large Hide

        item.leather_strip.name=Leather Strip
        item.hide_small.name=Clean Small Hide
        item.hide_medium.name=Clean Medium Hide
        item.hide_large.name=Clean Large Hide

        item.vine.name=Vine
        item.sharp_rock.name=Sharp Rock

        item.prepared_iron.name=Prepared Iron Ore
        item.diamond_shards.name=Diamond Shards
        item.diamond_dust.name=Diamond Dust
        item.obsidian_rock.name=Obsidian Rock
        item.fletching.name=Fletching

        item.coal_dust.name=Coal Dust
        item.nitre.name=Niter
        item.sulfur.name=Sulfur
        item.bomb_casing_uncooked.name=Clay Bomb Casing
        item.bomb_casing_ceramic.name=Ceramic Bomb Casing
        item.mine_casing_uncooked.name=Clay Mine Casing
        item.mine_casing_ceramic.name=Ceramic Mine Casing
        item.shrapnel.name=Shrapnel
        item.magma_cream_refined.name=Refined Magma Cream
        item.bomb_fuse.name=Bomb Fuse
        item.bomb_fuse_long.name=Long Bomb Fuse
        item.bomb_casing_iron.name=Iron Bomb Casing
        item.mine_casing_iron.name=Iron Mine Casing
        item.bomb_casing_obsidian.name=Obsidian Bomb Casing
        item.mine_casing_obsidian.name=Obsidian Mine Casing
        item.bomb_casing_crystal.name=Crystal Bomb Casing
        item.mine_casing_crystal.name=Crystal Mine Casing
        item.bomb_casing_arrow.name=Arrow Bomb Casing
        item.bomb_casing_bolt.name=Quarrel Bomb Casing

        item.clay_brick.name=Clay Brick
        item.kaolinite.name=Kaolinite
        item.kaolinite_dust.name=Kaolinite Dust
        item.fireclay.name=Fire Clay
        item.fireclay_brick.name=Fire Clay Brick
        item.strong_brick.name=Fire Brick

        item.ore_copper.name=Raw Copper Ore
        item.ore_tin.name=Raw Tin Ore
        item.ore_iron.name=Raw Iron Ore
        item.ore_silver.name=Raw Silver Ore
        item.ore_gold.name=Raw Gold Ore
        item.ore_tungsten.name=Raw Wolframite

        item.dragon_heart.name=Dragon Heart
        item.ornate_items.name=Ornate Crest

        item.iron_frame.name=Iron Frame
        item.iron_strut.name=Iron Strut
        item.bronze_gears.name=Bronze Cogworks
        item.tungsten_gears.name=Intricate Cogworks
        item.steel_tube.name=Steel Tube
        item.cogwork_shaft.name=Cogwork Shaft
         */

        // GADGET

        /*
        item.spyglass.name=Spyglass
        item.climbing_pick_basic.name=Climbing Pick
        item.parachute.name=Parachute
        item.syringe.name= Syringe
        item.syringe_empty.name=Empty Syringe

        tile.block_cogwork_helm.name=Cogwork Helmet Block
        tile.block_cogwork_chestplate.name=Cogwork Chest Block
        tile.block_cogwork_legs.name=Cogwork Legs Block
        tile.frame_block.name=Frame Block
        tile.cogwork_holder.name=Cogwork Holder

        item.cogwork_pulley.name=Cogwork Pulley

        bomb.component.name=Bomb Component
        bomb.component.filling=Filling
        bomb.component.bombcase=Bomb Case
        bomb.component.minecase=Mine Case
        bomb.component.arrow=Arrow Case
        bomb.component.bolt=Quarrel Case
        bomb.component.fuse=Fuse
        bomb.component.powder=Powder

        crossbow.component.name=Crossbow Component
        crossbow.component.stock=Stock
        crossbow.component.mechanism=Arms
        crossbow.component.mod=Modification
        crossbow.component.muzzle=Muzzle

        item.bomb_crude.name=Crude Bomb
        item.bomb_basic.name=Basic Bomb
        item.bomb_shrapnel.name=Shrapnel Bomb
        item.bomb_fire.name=Incineration Bomb
        item.exploding_arrow.name=Bomb Arrow
        item.exploding_bolt.name=Explosive Quarrel

        item.mine_basic.name=Basic Mine
        item.mine_shrapnel.name=Shrapnel Mine
        item.mine_fire.name=Incineration Mine

        death.attack.mine=%1$s stood on a mine
        death.attack.bomb.thrown=%1$s was blown up by %2$s
        death.attack.bomb=%1$s was blown up by a bomb
        death.attack.bomb.suicide=%1$s blew themself up.... Idiot

        bomb.powder.black_powder.name=Blackpowder Charge
        bomb.powder.advanced_black_powder.name=Advanced Blackpowder Charge
        bomb.fuse.basic.name=Basic Fuse
        bomb.fuse.long.name=Long Fuse
        bomb.case.crude.name=Paper Casing
        bomb.case.ceramic.name=Ceramic Casing
        bomb.case.iron.name=Iron Casing
        bomb.case.obsidian.name=Obsidian Casing
        bomb.case.crystal.name=Crystal Casing
        bomb.damage.name=Blast Damage
        bomb.range.metric.name=Blast Radius: %1$s metres
        bomb.fusetime.name=Fuse Time: %1$s seconds
        bomb.case.sticky=Sticky

        gui.bombcraftmf.name=Bomb Crafting
        gui.crossbowcraftmf.name=Crossbow Crafting

        attribute.crossbow.power.name=Power x%1$s
        attribute.crossbow.speed.name=Reload Time %1$ss
        attribute.crossbow.spread.name=Spread x%1$s
        attribute.crossbow.recoil.name=Recoil x%1$s
        attribute.crossbow.capacity.name=Capacity %1$s
        attribute.crossbow.bash.name=Melee Dmg %1$s

        crosspart.stock.crossbow_stock_wood=Crossbow
        crosspart.stock.crossbow_stock_iron=Crossbow
        crosspart.stock.crossbow_handle_wood=Hand Crossbow
        crosspart.mechanism.crossbow_arms_light=Light
        crosspart.mechanism.crossbow_arms_heavy=Heavy
        crosspart.mechanism.crossbow_arms_advanced=Advanced
        crosspart.mod.crossbow_ammo=Repeating
        crosspart.mod.crossbow_scope=Scoped

        item.crossbow_stock_wood.name=Crossbow Stock
        item.crossbow_handle_wood.name=Crossbow Handle
        item.crossbow_stock_iron.name=Advanced Crossbow Stock
        item.crossbow_arms_light.name=Light Crossbow Arms
        item.crossbow_arms_basic.name=Crossbow Arms
        item.crossbow_arms_heavy.name=Heavy Crossbow Arms
        item.crossbow_arms_advanced.name=Advanced Crossbow Arms
        item.crossbow_ammo.name=Repeating Crossbow Mechanism
        item.crossbow_scope.name=Crossbow Scope
        item.crossbow_bayonet.name=Crossbow Bayonet

        item.crossbow_stock_wood.desc=Standard.
        item.crossbow_handle_wood.desc=Easier reload, more recoil and spread.
        item.crossbow_stock_iron.desc=Dampens Recoil.
        item.crossbow_arms_light.desc=Less power and recoil, faster.
        item.crossbow_arms_basic.desc=Standard.
        item.crossbow_arms_heavy.desc=More power, slow with more recoil.
        item.crossbow_arms_advanced.desc=More accuracy and power, but slow with high recoil.
        item.crossbow_ammo.desc=6x shot capacity, increased spread.
        item.crossbow_scope.desc=Allows zoom function.
        item.crossbow_bayonet.desc=Adds melee damage, reduces recoil, slow reload.

        tile.berry_bush.name=Berry Bush
         */

        // ORES

        addBlock(MFRBlocks.TIN_ORE, "Tin Ore");
        addBlock(MFRBlocks.DEEPSLATE_TIN_ORE, "Deepslate Tin Ore");
        addBlock(MFRBlocks.SILVER_ORE, "Silver Ore");
        addBlock(MFRBlocks.DEEPSLATE_SILVER_ORE, "Deepslate Silver Ore");
        addBlock(MFRBlocks.MYTHIC_ORE, "Mythic Ore");

        addBlock(MFRBlocks.KAOLINITE_ORE, "Kaolinite Deposit");
        addBlock(MFRBlocks.DEEPSLATE_KAOLINITE_ORE, "Deepslate Kaolinite Deposit");
        addBlock(MFRBlocks.NITRE_ORE, "Nitre Deposit");
        addBlock(MFRBlocks.SULFUR_ORE, "Sulfur Deposit");
        addBlock(MFRBlocks.BORAX_ORE, "Borax Deposit");
        addBlock(MFRBlocks.DEEPSLATE_BORAX_ORE, "Deepslate Borax Deposit");
        addBlock(MFRBlocks.TUNGSTEN_ORE, "Wolframite Ore");
        addBlock(MFRBlocks.RICH_COAL_ORE, "Rich Coal Deposit");
        addBlock(MFRBlocks.DEEPSLATE_RICH_COAL_ORE, "Deepslate Rich Coal Deposit");
        
        addBlock(MFRBlocks.WINDOW, "Window");
        addBlock(MFRBlocks.WINDOW_PANE, "Window Pane");
        /*
        tile.mud_road.name=Mud Road
        tile.mud_road_block.name=Mud Road Block
        tile.mud_road_block_slab.name=Mud Road Slab
        */
        addBlock(MFRBlocks.THATCH, "Thatch");
        addBlock(MFRBlocks.THATCH_STAIRS, "Thatch Stairs");
        addBlock(MFRBlocks.THATCH_SLAB, "Thatch Slab");
        addBlock(MFRBlocks.THATCH_WALL, "Thatch Wall");

        addBlock(MFRBlocks.LIMESTONE, "Limestone");
        addBlock(MFRBlocks.LIMESTONE_STAIRS, "Limestone Stairs");
        addBlock(MFRBlocks.LIMESTONE_SLAB, "Limestone Slab");
        addBlock(MFRBlocks.LIMESTONE_WALL, "Limestone Wall");
        addBlock(MFRBlocks.COBBLE_LIMESTONE, "Cobbled Limestone");
        addBlock(MFRBlocks.COBBLE_LIMESTONE_STAIRS, "Cobbled Limestone Stairs");
        addBlock(MFRBlocks.COBBLE_LIMESTONE_SLAB, "Cobbled Limestone Slab");
        addBlock(MFRBlocks.COBBLE_LIMESTONE_WALL, "Cobbled Limestone Wall");
        addBlock(MFRBlocks.LIMESTONE_BRICKS, "Limestone Bricks");
        addBlock(MFRBlocks.LIMESTONE_BRICK_STAIRS, "Limestone Brick Stairs");
        addBlock(MFRBlocks.LIMESTONE_BRICK_SLAB, "Limestone Brick Slab");
        addBlock(MFRBlocks.LIMESTONE_BRICK_WALL, "Limestone Brick Wall");

        /*tile.limestone_road.name=Limestone Road
        tile.limestone_road_block.name=Limestone Road Block
        tile.limestone_road_block_slab.name=Limestone Road Slab

        tile.slate.name=Slate
        tile.slate_cobblestone.name=Slate Cobblestone
        tile.slate_brick.name=Slate Brick
        tile.slate_pavement.name=Slate Pavement
        tile.slate_stair.name=Slate Stairs
        tile.slate_cobblestone_stair.name=Slate Cobblestone Stairs
        tile.slate_brick_stair.name=Slate Brick Stairs*/
        
        addBlock(MFRBlocks.FRAMED_GLASS, "Framed Glass");
        addBlock(MFRBlocks.FRAMED_GLASS_PANE, "Framed Glass Pane");
        addBlock(MFRBlocks.FIREBRICKS, "Fire Bricks");
        addBlock(MFRBlocks.FIREBRICK_STAIRS, "Fire Brick Stairs");
        addBlock(MFRBlocks.FIREBRICK_SLAB, "Fire Brick Slab");
        addBlock(MFRBlocks.FIREBRICK_WALL, "Fire Brick Wall");
        /*
        tile.cobblestone_road.name=Cobblestone Road
        tile.cobblestone_road_block.name=Cobblestone Road Block
        tile.cobblestone_road_block_slab.name=Cobblestone Road Slab
        */
        addBlock(MFRBlocks.COBBLE_BRICKS, "Cobblestone Bricks");
        addBlock(MFRBlocks.COBBLE_BRICK_STAIRS, "Cobblestone Brick Stairs");
        addBlock(MFRBlocks.COBBLE_BRICK_SLAB, "Cobblestone Brick Slab");
        addBlock(MFRBlocks.COBBLE_BRICK_WALL, "Cobblestone Brick Wall");
        addBlock(MFRBlocks.CLAY_PANEL, "Clay Wall Panel");
        addBlock(MFRBlocks.CLAY_PANEL_STAIRS, "Clay Wall Stairs");
        addBlock(MFRBlocks.CLAY_PANEL_SLAB, "Clay Wall Slab");
        addBlock(MFRBlocks.CLAY_PANEL_WALL, "Clay Wall");
        /*
        tile.clay_wall_right_diagonal.name=Clay Wall Right Diagonal Panel
        tile.clay_wall_left_diagonal.name=Clay Wall Left Diagonal Panel
        */

        addBlock(MFRBlocks.YEW_LOG, "Yew Log");
        addBlock(MFRBlocks.YEW_WOOD, "Yew Wood");
        addBlock(MFRBlocks.STRIPPED_YEW_LOG, "Stripped Yew Log");
        addBlock(MFRBlocks.STRIPPED_YEW_WOOD, "Stripped Yew Wood");
        addBlock(MFRBlocks.YEW_PLANKS, "Yew Planks");
        addBlock(MFRBlocks.YEW_LEAVES, "Yew Leaves");
        addBlock(MFRBlocks.YEW_SAPLING, "Yew Sapling");
        addBlock(MFRBlocks.YEW_STAIRS, "Yew Stairs");
        addBlock(MFRBlocks.YEW_SLAB, "Yew Slab");
        addBlock(MFRBlocks.YEW_FENCE, "Yew Fence");
        addBlock(MFRBlocks.YEW_FENCE_GATE, "Yew Fence Gate");
        addBlock(MFRBlocks.YEW_PRESSURE_PLATE, "Yew Pressure Plate");
        addBlock(MFRBlocks.YEW_BUTTON, "Yew Button");
        addBlock(MFRBlocks.YEW_DOOR, "Yew Door");
        addBlock(MFRBlocks.YEW_TRAPDOOR, "Yew Trapdoor");

        addBlock(MFRBlocks.IRONBARK_LOG, "Ironbark Log");
        addBlock(MFRBlocks.IRONBARK_WOOD, "Ironbark Wood");
        addBlock(MFRBlocks.STRIPPED_IRONBARK_LOG, "Stripped Ironbark Log");
        addBlock(MFRBlocks.STRIPPED_IRONBARK_WOOD, "Stripped Ironbark Wood");
        addBlock(MFRBlocks.IRONBARK_PLANKS, "Ironbark Planks");
        addBlock(MFRBlocks.IRONBARK_LEAVES, "Ironbark Leaves");
        addBlock(MFRBlocks.IRONBARK_SAPLING, "Ironbark Sapling");
        addBlock(MFRBlocks.IRONBARK_STAIRS, "Ironbark Stairs");
        addBlock(MFRBlocks.IRONBARK_SLAB, "Ironbark Slab");
        addBlock(MFRBlocks.IRONBARK_FENCE, "Ironbark Fence");
        addBlock(MFRBlocks.IRONBARK_FENCE_GATE, "Ironbark Fence Gate");
        addBlock(MFRBlocks.IRONBARK_PRESSURE_PLATE, "Ironbark Pressure Plate");
        addBlock(MFRBlocks.IRONBARK_BUTTON, "Ironbark Button");
        addBlock(MFRBlocks.IRONBARK_DOOR, "Ironbark Door");
        addBlock(MFRBlocks.IRONBARK_TRAPDOOR, "Ironbark Trapdoor");

        addBlock(MFRBlocks.EBONY_LOG, "Ebony Log");
        addBlock(MFRBlocks.EBONY_WOOD, "Ebony Wood");
        addBlock(MFRBlocks.STRIPPED_EBONY_LOG, "Stripped Ebony Log");
        addBlock(MFRBlocks.STRIPPED_EBONY_WOOD, "Stripped Ebony Wood");
        addBlock(MFRBlocks.EBONY_PLANKS, "Ebony Planks");
        addBlock(MFRBlocks.EBONY_LEAVES, "Ebony Leaves");
        addBlock(MFRBlocks.EBONY_SAPLING, "Ebony Sapling");
        addBlock(MFRBlocks.EBONY_STAIRS, "Ebony Stairs");
        addBlock(MFRBlocks.EBONY_SLAB, "Ebony Slab");
        addBlock(MFRBlocks.EBONY_FENCE, "Ebony Fence");
        addBlock(MFRBlocks.EBONY_FENCE_GATE, "Ebony Fence Gate");
        addBlock(MFRBlocks.EBONY_PRESSURE_PLATE, "Ebony Pressure Plate");
        addBlock(MFRBlocks.EBONY_BUTTON, "Ebony Button");
        addBlock(MFRBlocks.EBONY_DOOR, "Ebony Door");
        addBlock(MFRBlocks.EBONY_TRAPDOOR, "Ebony Trapdoor");

        addBlock(MFRBlocks.NAILED_PLANKS, "Nailed Wood Planks");
        addBlock(MFRBlocks.NAILED_STAIRS, "Nailed Wood Stairs");
        addBlock(MFRBlocks.NAILED_SLAB, "Nailed Wood Slab");
        addBlock(MFRBlocks.NAILED_FENCE, "Nailed Wood Fence");
        addBlock(MFRBlocks.NAILED_FENCE_GATE, "Nailed Wood Fence Gate");
        addBlock(MFRBlocks.NAILED_PRESSURE_PLATE, "Nailed Wood Pressure Plate");
        addBlock(MFRBlocks.NAILED_BUTTON, "Nailed Wood Button");
        addBlock(MFRBlocks.REFINED_PLANKS, "Refined Wood Planks");
        addBlock(MFRBlocks.REFINED_STAIRS, "Refined Wood Stairs");
        addBlock(MFRBlocks.REFINED_SLAB, "Refined Wood Slab");
        addBlock(MFRBlocks.REFINED_FENCE, "Refined Wood Fence");
        addBlock(MFRBlocks.REFINED_FENCE_GATE, "Refined Wood Fence Gate");
        addBlock(MFRBlocks.REFINED_PRESSURE_PLATE, "Refined Wood Pressure Plate");
        addBlock(MFRBlocks.REFINED_BUTTON, "Refined Wood Button");
        
        addBlock(MFRBlocks.REINFORCED_STONE, "Reinforced Stone");
        addBlock(MFRBlocks.REINFORCED_STONE_STAIRS, "Reinforced Stone Stairs");
        addBlock(MFRBlocks.REINFORCED_STONE_SLAB, "Reinforced Stone Slab");
        addBlock(MFRBlocks.REINFORCED_STONE_WALL, "Reinforced Stone Wall");
        addBlock(MFRBlocks.REINFORCED_STONE_BRICKS, "Reinforced Stone Bricks");
        addBlock(MFRBlocks.REINFORCED_STONE_BRICK_STAIRS, "Reinforced Stone Brick Stairs");
        addBlock(MFRBlocks.REINFORCED_STONE_BRICK_SLAB, "Reinforced Stone Brick Slab");
        addBlock(MFRBlocks.REINFORCED_STONE_BRICK_WALL, "Reinforced Stone Brick Wall");
        /*
        tile.reinforced_stone_base.name=Reinforced Stone
        tile.reinforced_stone_engraved_0.name=Engraved Reinforced Stone
        tile.reinforced_stone_engraved_1.name=Engraved Reinforced Stone
        tile.reinforced_stone_engraved_2.name=Engraved Reinforced Stone
        tile.reinforced_stone_engraved_3.name=Engraved Reinforced Stone
        */

        addBlock(MFRBlocks.MOSSY_REINFORCED_STONE_BRICKS, "Mossy Reinforced Stone Bricks");
        addBlock(MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_STAIRS, "Mossy Reinforced Stone Brick Stairs");
        addBlock(MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_SLAB, "Mossy Reinforced Stone Brick Slab");
        addBlock(MFRBlocks.MOSSY_REINFORCED_STONE_BRICK_WALL, "Mossy Reinforced Stone Brick Wall");
        addBlock(MFRBlocks.CRACKED_REINFORCED_STONE_BRICKS, "Cracked Reinforced Stone Bricks");
        addBlock(MFRBlocks.CRACKED_REINFORCED_STONE_BRICK_STAIRS, "Cracked Reinforced Stone Brick Stairs");
        addBlock(MFRBlocks.CRACKED_REINFORCED_STONE_BRICK_SLAB, "Cracked Reinforced Stone Brick Slab");
        addBlock(MFRBlocks.CRACKED_REINFORCED_STONE_BRICK_WALL, "Cracked Reinforced Stone Brick Wall");

        addBlock(MFRBlocks.FRAMED_REINFORCED_STONE, "Framed Reinforced Stone Bricks");
        addBlock(MFRBlocks.FRAMED_REINFORCED_STONE_STAIRS, "Framed Reinforced Stone Brick Stairs");
        addBlock(MFRBlocks.FRAMED_REINFORCED_STONE_SLAB, "Framed Reinforced Stone Brick Slab");
        addBlock(MFRBlocks.FRAMED_REINFORCED_STONE_WALL, "Framed Reinforced Stone Brick Wall");
        addBlock(MFRBlocks.IRON_FRAMED_REINFORCED_STONE, "Iron-Framed Reinforced Stone Bricks");
        addBlock(MFRBlocks.IRON_FRAMED_REINFORCED_STONE_STAIRS, "Iron-Framed Reinforced Stone Brick Stairs");
        addBlock(MFRBlocks.IRON_FRAMED_REINFORCED_STONE_SLAB, "Iron-Framed Reinforced Stone Brick Slab");
        addBlock(MFRBlocks.IRON_FRAMED_REINFORCED_STONE_WALL, "Iron-Framed Reinforced Stone Brick Wall");

        /*
        tile.bronze_bars.name=Bronze Bars
        tile.iron_bars.name=Iron Bars
        tile.steel_bars.name=Steel Bars
        tile.dragon_forge_bars.name=Dragonforge Bars
        tile.red_steel_bars.name=Red Steel Bars
        tile.black_steel_bars.name=Black Steel Bars
        tile.blue_steel_bars.name=Blue Steel Bars

        tile.copper_block.name=Block of Copper
        tile.tin_block.name=Block of Tin
        tile.silver_block.name=Block of Silver
        tile.pig_iron_block.name=Block of Pig Iron

        tile.bronze_block.name=Block of Bronze
        tile.steel_block.name=Block of Steel
        tile.dragon_forge_block.name=Block of Dragonforge
        tile.red_steel_block.name=Block of Red Steel
        tile.black_steel_block.name=Block of Black Steel
        tile.blue_steel_block.name=Block of Blue Steel

        tile.adamantium_block.name=Block of Adamantium
        tile.mithril_block.name=Block of Mithril
        tile.ignotumite_block.name=Block of Ignotumite
        tile.mithium_block.name=Block of Mithium

        tile.enderforge_block.name=Block of Enderforge

        tile.forge_stone.name=Stone Forge
        tile.forge_metal.name=Advanced Forge
        tile.bloomery.name=Bloomery
        tile.crucible_stone.name=Stone Crucible
        tile.crucible_fireclay.name=Fireclay Crucible
        tile.crucible_auto.name=Advanced Crucible
        tile.crucible_mythic.name=Ancient Crucible
        tile.crucible_master.name=Master Ancient Crucible

        tile.chimney.stone.name=Stone Chimney
        tile.chimney.stone.wide.name=Wide Stone Chimney
        tile.chimney.stone_extractor.wide.name=Stone Extractor Chimney
        tile.chimney.pipe.name=Smoke Pipe
        tile.bellows.name=Bellows
        tile.tanner.name=Shabby Tanning Rack
        tile.tanner_refined.name=Tanning Rack
        tile.tanner_metal.name=Advanced Tanning Rack
        tile.bomb_bench.name=Bomb Crafting Table
        tile.crossbow_bench.name=Crossbow Assembly Table
        tile.bomb_press.name=Bomb Press
        tile.carpenter_bench.name=Carpenter Bench
        tile.kitchen_bench_granite.name=Kitchen Bench
        tile.kitchen_bench_diorite.name=Kitchen Bench
        tile.kitchen_bench_andesite.name=Kitchen Bench
        tile.research_bench.name=Research Bench
        tile.quern.name=Quern
        tile.anvil_stone.name=Stone Anvil
        tile.anvil_bronze.name=Bronze Anvil
        tile.anvil_iron.name=Iron Anvil
        tile.anvil_steel.name=Steel Anvil
        tile.anvil_black_steel.name=Black Steel Anvil
        tile.anvil_red_steel.name=Red Steel Anvil
        tile.anvil_blue_steel.name= Blue Steel Anvil
        tile.furnace_stone.name=Furnace
        tile.furnace_heater.name=Furnace Heater
        tile.blastfurnchamber.name=Blast Furnace Chamber
        tile.blastfurnheater.name=Blast Furnace Heater

        tile.firepit.name=Firepit
        tile.stove.name=Stove
        tile.oven.name=Stone Oven

        tile.rack_wood.name=%1$s Tool Rack
        tile.food_box_basic.name=%1$s Provisions Box
        tile.ammo_box_basic.name=%1$s Ammunition Box
        tile.crate_basic.name=%1$s Crate
        tile.trough_wood.name=%1$s Trough
        attribute.box.capacity.name=Capacity: %1$s Stacks
        attribute.fill.capacity.name=Capacity: %1$s
        attribute.fill=Fill x%1$s

        item.bedroll.name=Bedroll
        tile.bedroll.name=Bedroll

        tile.mythic_stone_framed.name=Framed Mythic Stone
        tile.mythic_stone_decorated.name=Decorated Mythic Stone
         */

        // TABS

        add("itemGroup.minefantasyreforged.forged_tools", "[MF] Forged Tools");
        add("itemGroup.minefantasyreforged.forged_weapons", "[MF] Forged Weapons");
        add("itemGroup.minefantasyreforged.forged_armour", "[MF] Forged Armor");
        add("itemGroup.minefantasyreforged.gadgets", "[MF] Gadgets");
        add("itemGroup.minefantasyreforged.utility_blocks", "[MF] Utility Blocks");
        add("itemGroup.minefantasyreforged.archery", "[MF] Archery");
        add("itemGroup.minefantasyreforged.materials", "[MF] Materials");
        add("itemGroup.minefantasyreforged.advanced_tools", "[MF] Advanced Tools");
        add("itemGroup.minefantasyreforged.crafting_tools", "[MF] Crafting Tools");
        add("itemGroup.minefantasyreforged.ores", "[MF] Ores");
        add("itemGroup.minefantasyreforged.food", "[MF] Food");
        add("itemGroup.minefantasyreforged.primitive", "[MF] Primitive Items");
        add("itemGroup.minefantasyreforged.dragonforged", "[MF] Dragonforged Style");
        add("itemGroup.minefantasyreforged.ornate", "[MF] Ornate Style");

        // FIRESTARTER

        /*
        item.dryrocks.name=Dry Rocks
        item.tinderbox.name=Tinderbox
         */

        // BANDAGE

        /*
        item.bandage_crude.name=Crude Bandage
        item.bandage_wool.name=Wool Bandage
        item.bandage_tough.name=Strong Bandage
        item.bandage_heal_amount=Heals %1$s hearts of damage. Use for 5 seconds to apply
        */

        // TRAINING

        /*
        item.training_sword.name=Training Sword
        item.training_waraxe.name=Training Waraxe
        item.training_mace.name=Training Mace
        item.training_spear.name=Training Spear
         */

        // LEATHER STUFF

        /*
        item.hide_helmet.name=Hide Headress
        item.hide_chestplate.name=Hide Armor
        item.hide_leggings.name=Hide Skirt
        item.hide_boots.name=Hide Boots

        item.rough_leather_helmet.name=Rough Leather Helmet
        item.rough_leather_chestplate.name=Rough Leather Armor
        item.rough_leather_leggings.name=Rough Leather Leggings
        item.rough_leather_boots.name=Rough Leather Boots

        item.strong_leather_helmet.name=Reinforced Leather Helmet
        item.strong_leather_chestplate.name=Reinforced Leather Armor
        item.strong_leather_leggings.name=Reinforced Leather Leggings
        item.strong_leather_boots.name=Reinforced Leather Boots

        item.stud_leather_helmet.name=Studded Helmet
        item.stud_leather_chestplate.name=Studded Armor
        item.stud_leather_leggings.name=Studded Leggings
        item.stud_leather_boots.name=Studded Boots

        item.scale_leather_helmet.name=Scaled Helmet
        item.scale_leather_chestplate.name=Scaled Armor
        item.scale_leather_leggings.name=Scaled Leggings
        item.scale_leather_boots.name=Scaled Boots

        item.padded_helmet.name=Padded Cap
        item.padded_chestplate.name=Gambeson
        item.padded_leggings.name=Padded Leggings
        item.padded_boots.name=Padded Boots

        item.leather_apron.name=Leather Blacksmith Attire
         */

        // WOOD STUFF

        /*
        item.malletWood.name=Wooden Mallet
        item.spoonWood.name=Wooden Spoon
        item.paint_brush.name=Paint Brush
         */

        // STONE STUFF

        /*
        item.stone_pick.name=Stone Pickaxe
        item.stone_axe.name=Stone Axe
        item.stone_hoe.name=Stone Hoe
        item.stone_spade.name=Stone Shovel

        item.stone_knife.name=Stone Knife
        item.stone_hammer.name=Stone Hammer
        item.stone_tongs.name=Stone Tongs
        item.bone_needle.name=Bone Needle

        item.stone_sword.name=Stone Sword
        item.stone_waraxe.name=Stone Waraxe
        item.stone_mace.name=Stone Club
        item.stone_spear.name=Stone Spear
         */

        // WASH

        addItem(MFRItems.WASH_CLOTH_WOOL, "Wool Wash Cloth");

        // STANDARD

        add("languagecfg.tooltiptier", "false");
        // You can move the main tier to the tooltip if this is true, make sure to remove "%1$s " instnaces if you do this

        addItem(MFRItems.STANDARD_PICK, "%1$s Pickaxe");
        addItem(MFRItems.STANDARD_AXE, "%1$s Axe");
        addItem(MFRItems.STANDARD_SHOVEL, "%1$s Shovel");
        addItem(MFRItems.STANDARD_HOE, "%1$s Hoe");

        addItem(MFRItems.STANDARD_SHEARS, "%1$s Shears");
        addItem(MFRItems.STANDARD_KNIFE, "%1$s Knife");
        addItem(MFRItems.STANDARD_NEEDLE, "%1$s Needle");
        addItem(MFRItems.STANDARD_HAMMMER, "%1$s Hammer");
        addItem(MFRItems.STANDARD_HEAVY_HAMMMER, "Heavy %1$s Hammer");
        addItem(MFRItems.STANDARD_TONGS, "%1$s Tongs");
        addItem(MFRItems.STANDARD_SAW, "%1$s Saw");
        addItem(MFRItems.STANDARD_SPANNER, "%1$s Spanner");


        addItem(MFRItems.STANDARD_DAGGER, "%1$s Dagger");
        addItem(MFRItems.STANDARD_SWORD, "%1$s Sword");
        addItem(MFRItems.STANDARD_MACE, "%1$s Mace");
        addItem(MFRItems.STANDARD_WARAXE, "%1$s Waraxe");
        addItem(MFRItems.STANDARD_SPEAR, "%1$s Spear");

        addItem(MFRItems.STANDARD_KATANA, "%1$s Katana");
        addItem(MFRItems.STANDARD_GREATSWORD, "%1$s Greatsword");
        addItem(MFRItems.STANDARD_WARHAMMER, "%1$s Warhammer");
        addItem(MFRItems.STANDARD_BATTLEAXE, "%1$s Battleaxe");
        addItem(MFRItems.STANDARD_HALBEARD, "%1$s Halbeard");
        addItem(MFRItems.STANDARD_LANCE, "%1$s Lance");

        addItem(MFRItems.STANDARD_HANDPICK, "%1$s Handpick");
        addItem(MFRItems.STANDARD_HEAVY_PICK, "Heavy %1$s Pickaxe");
        addItem(MFRItems.STANDARD_TROW, "%1$s Trow");
        addItem(MFRItems.STANDARD_HEAVY_SHOVEL, "Heavy %1$s Shovel");
        addItem(MFRItems.STANDARD_SCYTHE, "%1$s Scythe");
        addItem(MFRItems.STANDARD_MATTOCK, "%1$s Mattock");
        addItem(MFRItems.STANDARD_LUMBER, "%1$s Lumber Axe");

        addItem(MFRItems.STANDARD_SCALE_HELMET, "%1$s Scale Helmet");
        addItem(MFRItems.STANDARD_SCALE_CHESTPLATE, "%1$s Scale Suit");
        addItem(MFRItems.STANDARD_SCALE_LEGGINGS, "%1$s Scale Leggings");
        addItem(MFRItems.STANDARD_SCALE_BOOTS, "%1$s Scale Boots");

        addItem(MFRItems.STANDARD_CHAIN_HELMET, "%1$s Coif");
        addItem(MFRItems.STANDARD_CHAIN_CHESTPLATE, "%1$s Mail Suit");
        addItem(MFRItems.STANDARD_CHAIN_LEGGINGS, "%1$s Mail Leggings");
        addItem(MFRItems.STANDARD_CHAIN_BOOTS, "%1$s Mail Boots");

        addItem(MFRItems.STANDARD_SPLINT_HELMET, "%1$s Splint Helmet");
        addItem(MFRItems.STANDARD_SPLINT_CHESTPLATE, "%1$s Splint Suit");
        addItem(MFRItems.STANDARD_SPLINT_LEGGINGS, "%1$s Splint Leggings");
        addItem(MFRItems.STANDARD_SPLINT_BOOTS, "%1$s Splint Boots");

        addItem(MFRItems.STANDARD_PLATE_HELMET, "%1$s Great Helm");
        addItem(MFRItems.STANDARD_PLATE_CHESTPLATE, "%1$s Curiass");
        addItem(MFRItems.STANDARD_PLATE_LEGGINGS, "%1$s Greaves");
        addItem(MFRItems.STANDARD_PLATE_BOOTS, "%1$s Sabatons");

        addItem(MFRItems.STANDARD_BOW, "%1$s Bow");
        addItem(MFRItems.STANDARD_ARROW, "%1$s Arrow");
        addItem(MFRItems.STANDARD_ARROW_BODKIN, "%1$s Bodkin Arrow");
        addItem(MFRItems.STANDARD_ARROW_BROAD, "%1$s Broadhead Arrow");
        addItem(MFRItems.STANDARD_BOLT, "%1$s Quarrel");

        addItem(MFRItems.STANDARD_MALLET, "%1$s Mallet");
        addItem(MFRItems.STANDARD_SPOON, "%1$s Spoon");

        // DRAGONFORGE

        /*
        item.dragonforged_pick.name=Dragonforged %1$s Pickaxe
        item.dragonforged_axe.name=Dragonforged %1$s Axe
        item.dragonforged_spade.name=Dragonforged %1$s Shovel
        item.dragonforged_hoe.name=Dragonforged %1$s Hoe

        item.dragonforged_shears.name=Dragonforged %1$s Shears
        item.dragonforged_knife.name=Dragonforged %1$s Knife
        item.dragonforged_needle.name=Dragonforged %1$s Needle
        item.dragonforged_hammer.name=Dragonforged %1$s Hammer
        item.dragonforged_heavy_hammer.name=Heavy Dragonforged %1$s Hammer
        item.dragonforged_tongs.name=Dragonforged %1$s Tongs
        item.dragonforged_saw.name=Dragonforged %1$s Saw
        item.dragonforged_spanner.name=Dragonforged %1$s Spanner


        item.dragonforged_dagger.name=Dragonforged %1$s Dagger
        item.dragonforged_sword.name=Dragonforged %1$s Sword
        item.dragonforged_mace.name=Dragonforged %1$s Mace
        item.dragonforged_waraxe.name=Dragonforged %1$s Waraxe
        item.dragonforged_spear.name=Dragonforged %1$s Spear

        item.dragonforged_katana.name=Dragonforged %1$s Katana
        item.dragonforged_greatsword.name=Dragonforged %1$s Greatsword
        item.dragonforged_warhammer.name=Dragonforged %1$s Warhammer
        item.dragonforged_battleaxe.name=Dragonforged %1$s Battleaxe
        item.dragonforged_halbeard.name=Dragonforged %1$s Halbeard
        item.dragonforged_lance.name=Dragonforged %1$s Lance

        item.dragonforged_handpick.name=Dragonforged %1$s Handpick
        item.dragonforged_heavy_pick.name=Heavy Dragonforged %1$s Pickaxe
        item.dragonforged_trow.name=Dragonforged %1$s Trow
        item.dragonforged_heavy_shovel.name=Heavy Dragonforged %1$s Shovel
        item.dragonforged_scythe.name=Dragonforged %1$s Scythe
        item.dragonforged_mattock.name=Dragonforged %1$s Mattock
        item.dragonforged_lumber.name=Dragonforged %1$s Lumber Axe

        item.dragonforged_scale_helmet.name=Dragonforged %1$s Scale Helmet
        item.dragonforged_scale_chestplate.name=Dragonforged %1$s Scale Suit
        item.dragonforged_scale_leggings.name=Dragonforged %1$s Scale Leggings
        item.dragonforged_scale_boots.name=Dragonforged %1$s Scale Boots

        item.dragonforged_chain_helmet.name=Dragonforged %1$s Coif
        item.dragonforged_chain_chestplate.name=Dragonforged %1$s Mail Suit
        item.dragonforged_chain_leggings.name=Dragonforged %1$s Mail Leggings
        item.dragonforged_chain_boots.name=Dragonforged %1$s Mail Boots

        item.dragonforged_splint_helmet.name=Dragonforged %1$s Splint Helmet
        item.dragonforged_splint_chestplate.name=Dragonforged %1$s Splint Suit
        item.dragonforged_splint_leggings.name=Dragonforged %1$s Splint Leggings
        item.dragonforged_splint_boots.name=Dragonforged %1$s Splint Boots

        item.dragonforged_plate_helmet.name=Dragonforged %1$s Bascinet
        item.dragonforged_plate_chestplate.name=Dragonforged %1$s Curiass
        item.dragonforged_plate_leggings.name=Dragonforged %1$s Greaves
        item.dragonforged_plate_boots.name=Dragonforged %1$s Sabatons

        item.dragonforged_bow.name=Dragonforged %1$s Bow
         */

        // ORNATE

        /*
        item.ornate_pick.name=Ornate %1$s Pickaxe
        item.ornate_axe.name=Ornate %1$s Axe
        item.ornate_spade.name=Ornate %1$s Shovel
        item.ornate_hoe.name=Ornate %1$s Hoe

        item.ornate_shears.name=Ornate %1$s Shears
        item.ornate_knife.name=Ornate %1$s Knife
        item.ornate_needle.name=Ornate %1$s Needle
        item.ornate_hammer.name=Ornate %1$s Hammer
        item.ornate_heavy_hammer.name=Heavy Ornate %1$s Hammer
        item.ornate_tongs.name=Ornate %1$s Tongs
        item.ornate_saw.name=Ornate %1$s Saw
        item.ornate_spanner.name=Ornate %1$s Spanner


        item.ornate_dagger.name=Ornate %1$s Dagger
        item.ornate_sword.name=Ornate %1$s Sword
        item.ornate_mace.name=Ornate %1$s Mace
        item.ornate_waraxe.name=Ornate %1$s Waraxe
        item.ornate_spear.name=Ornate %1$s Spear

        item.ornate_katana.name=Ornate %1$s Katana
        item.ornate_greatsword.name=Ornate %1$s Greatsword
        item.ornate_warhammer.name=Ornate %1$s Warhammer
        item.ornate_battleaxe.name=Ornate %1$s Battleaxe
        item.ornate_halbeard.name=Ornate %1$s Halbeard
        item.ornate_lance.name=Ornate %1$s Lance

        item.ornate_handpick.name=Ornate %1$s Handpick
        item.ornate_heavy_pick.name=Heavy Ornate %1$s Pickaxe
        item.ornate_trow.name=Ornate %1$s Trow
        item.ornate_heavy_shovel.name=Heavy Ornate %1$s Shovel
        item.ornate_scythe.name=Ornate %1$s Scythe
        item.ornate_mattock.name=Ornate %1$s Mattock
        item.ornate_lumber.name=Ornate %1$s Lumber Axe

        item.ornate_scale_helmet.name=Ornate %1$s Scale Helmet
        item.ornate_scale_chestplate.name=Ornate %1$s Scale Suit
        item.ornate_scale_leggings.name=Ornate %1$s Scale Leggings
        item.ornate_scale_boots.name=Ornate %1$s Scale Boots

        item.ornate_chain_helmet.name=Ornate %1$s Coif
        item.ornate_chain_chestplate.name=Ornate %1$s Mail Suit
        item.ornate_chain_leggings.name=Ornate %1$s Mail Leggings
        item.ornate_chain_boots.name=Ornate %1$s Mail Boots

        item.ornate_splint_helmet.name=Ornate %1$s Splint Helmet
        item.ornate_splint_chestplate.name=Ornate %1$s Splint Suit
        item.ornate_splint_leggings.name=Ornate %1$s Splint Leggings
        item.ornate_splint_boots.name=Ornate %1$s Splint Boots

        item.ornate_plate_helmet.name=Ornate %1$s Armet
        item.ornate_plate_chestplate.name=Ornate %1$s Curiass
        item.ornate_plate_leggings.name=Ornate %1$s Greaves
        item.ornate_plate_boots.name=Ornate %1$s Sabatons

        item.ornate_bow.name=Ornate %1$s Bow
         */

        // ARTIFACT

        /*
        stat.artefact.name=Artefact
        item.ancient_jewel.name=Ancient Jewel
        item.ancient_jewel_mithril.name=Ancient Jewel
        item.ancient_jewel_adamant.name=Ancient Jewel
        item.ancient_jewel_master.name=Ancient Jewel
        item.trilogy_jewel.name=Ancient Trilogy

        tile.schematic_gears.name=Cogwork Gears Schematics
        tile.schematic_forge.name=Advanced Forge Schematics
        tile.schematic_cogwork.name=Cogwork Frame Schematics
        tile.schematic_bomb.name=Dwarven Bomb Schematics
        tile.schematic_crossbow.name=Dwarven Crossbow Schematics
        tile.schematic_alloy.name=Composite Alloy Schematics
         */

        // FOOD

        /*
        item.berries.name=Berries
        item.berries_juicy.name=Juicy Berries
        item.generic_meat_uncooked.name=Raw Generic Meat
        item.generic_meat_cooked.name=Cooked Generic Meat
        item.generic_meat_strip_uncooked.name=Raw Meat Strips
        item.generic_meat_strip_cooked.name=Cooked Meat Strips
        item.generic_meat_chunk_uncooked.name=Raw Meat Chunks
        item.generic_meat_chunk_cooked.name=Cooked Meat Chunks
        item.generic_meat_mince_uncooked.name=Raw Mince
        item.generic_meat_mince_cooked.name=Cooked Mince
        item.burnt_food.name=Burnt Food
        item.burnt_pot.name=Burnt Food
        item.burnt_cake.name=Burnt Food
        item.burnt_pie.name=Burnt Food

        tile.berries.name=Berry Bush
        item.breadcrumbs.name=Bread Crumbs
        item.breadroll.name=Bread Roll
        item.bread_slice.name=Bread Slice
        item.horse_raw.name=Raw Horse Meat
        item.horse_cooked.name=Cooked Horse Meat
        item.wolf_raw.name=Raw Wolf Chop
        item.wolf_cooked.name=Cooked Wolf Chop
        item.mutton_raw.name=Raw Mutton
        item.mutton_cooked.name=Cooked Mutton
        item.spider_raw.name=Raw Spider Meat
        item.spider_cooked.name=Cooked Spider Meat

        item.bowl_water_salt.name=Salt Water
        item.salt.name=Salt
        item.cake_tin.name=Cake Tin
        item.pie_tray.name=Pie Tray
        item.pie_tray_uncooked.name=Clay Pie Tray
        item.flour.name=Flour
        item.sugar_pot.name=Sugar Pot
        item.bread_uncooked.name=Uncooked Bread
        item.guts.name=Guts

        item.raw_bread.name=Bread Dough
        item.dough.name=Dough
        item.pastry.name=Pastry
        item.stew.name=Stew
        item.oats.name=Oats

        item.curds.name=Curds
        item.cheese_pot.name=Cheese Pot

        item.jerky.name=Jerky
        item.cheese_roll.name=Cheese Roll
        item.sweetroll.name=Sweetroll
        item.sandwitch.name=Sandwich
        item.sandwitch_big.name=Big Sandwich

        tile.pie_meat.name=Meat Pie
        tile.pie_apple.name=Apple Pie
        tile.pie_berry.name=Berry Pie
        tile.pie_shepards.name=Shepard's Pie

        item.meatpie_slice.name=Meat Pie Slice
        item.pieslice_apple.name=Apple Pie Slice
        item.pieslice_berry.name=Berry Pie Slice
        item.pieslice_shepards.name=Shepard's Pie Slice

        item.chicken_roast.name=Chicken Roast
        item.pork_roast.name=Pork Roast
        item.beef_roast.name=Beef Roast
        item.mutton_roast.name=Mutton Roast

        tile.cake_vanilla.name=Cake
        tile.cake_carrot.name=Carrot Cake
        tile.cake_chocolate.name=Chocolate Cake
        tile.cake_bf.name=Black-Forest Cake

        item.cake_slice.name=Cake Slice
        item.carrotcake_slice.name=Carrot Cake Slice
        item.choccake_slice.name=Chocolate Cake Slice
        item.bfcake_slice.name=Black-Forest Cake Slice

        item.coca_powder.name=Coca Powder
        item.chocolate.name=Chocolate
        item.choc_chips.name=Chocolate Chips
        item.eclair.name=Eclair
        item.eclair_raw.name=Eclair Dough
        item.eclair_uniced.name=Uniced Eclair
        item.eclair_empty.name=Empty Eclair
        item.saussage_cooked.name=Sausage
        item.saussage_raw.name=Raw Sausage
        tile.cheese_wheel.name=Cheese Wheel
        item.cheese_slice.name=Cheese
        item.sushi.name=Sushi
        item.curry.name=Curry
        item.pizza_basic.name=Pizza
        item.sweetroll_raw.name=Sweetroll Dough
        item.sweetroll_uniced.name=Uniced Sweetroll
        item.icing.name=Icing
        item.custard.name=Custard

        item.cake_raw.name=Cake Batter
        item.cake_simple_raw.name=Simple Cake Batter
        item.cake_carrot_raw.name=Carrot Cake Batter
        item.cake_choc_raw.name=Chocolate Cake Batter
        item.cake_bf_raw.name=Black-Forest Cake Batter

        item.cake_uniced.name=Uniced Cake
        item.cake_simple_uniced.name=Uniced Simple Cake
        item.cake_carrot_uniced.name=Uniced Carrot Cake
        item.cake_choc_uniced.name=Uniced Chocolate Cake
        item.cake_bf_uniced.name=Uniced Black-Forest Cake

        item.pie_meat_uncooked.name=Uncooked Meat Pie
        item.pie_apple_uncooked.name=Uncooked Apple Pie
        item.pie_berry_uncooked.name=Uncooked Berry Pie
        item.pie_shepard_uncooked.name=Uncooked Shepards Pie
        item.pie_pumpkin_uncooked.name=Uncooked Pumpkin Pie

        item.pie_meat_cooked.name=Cooked Meat Pie
        item.pie_apple_cooked.name=Cooked Apple Pie
        item.pie_berry_cooked.name=Cooked Berry Pie
        item.pie_shepard_cooked.name=Cooked Shepards Pie
        item.pie_pumpkin_cooked.name=Cooked Pumpkin Pie
         */

        // FOOD STATS

        /*
        food.stat.list.name=On Eaten:
        food.stat.hunger.name=+%1$s Hunger
        food.stat.staminaPlus.name=Restore %1$s Stamina
        food.stat.staminabuffHours.name=Bonus %1$s stamina for %2$s hours
        food.stat.staminabuffMinutes.name=Bonus %1$s stamina for %2$s mins
        food.stat.staminabuffSeconds.name=Bonus %1$s stamina for %2$s secs
        food.stat.eatDelay.name=Eat Delay: %1$s secs
        food.stat.fatAccumulation.name=Fat Accumulation: %1$s grams
        food.stat.staminabuffRegenMinutes.name=Regen %1$s stamina/second for %2$s mins
        food.stat.staminabuffRegenSeconds.name=Regen %1$s stamina/second for %2$s secs
        food.stat.cure.poison=Cure Poison
         */

        // CONSTRUCTION
        add("item.hinge.name", "Hinge");
        add("item.commodity_timber_cut.name", "Cut %1$s Timber");
        add("item.commodity_timber_pane.name", "%1$s Timber Pane");
    }

    /*
# RPG

rpg.levelup=Your %1$s skill has increased to %2$s
rpg.required=Requires %1$s %2$s
rpg.skillmod=Skill Modifier: +

skill.lowskill=You don't have enough skill!
skill.value=Level %1$s

skill.list.basic=Basic Skills
skill.list.craft=Crafting Skills
skill.list.combat=Combat Skills

skill.none.name=No Skill
skill.artisanry.name=Artisanry
skill.construction.name=Construction
skill.provisioning.name=Provisioning
skill.engineering.name=Engineering
skill.combat.name=Weaponry

item.skillbook_artisanry.name=The art of the Forge
item.skillbook_artisanry.desc=+%1$s Artisanry
item.skillbook_construction.name=Carpentry Techniques
item.skillbook_construction.desc=+%1$s Construction
item.skillbook_provisioning.name=Feeding a Village
item.skillbook_provisioning.desc=+%1$s Provisioning
item.skillbook_engineering.name=Advanced Mechanics
item.skillbook_engineering.desc=+%1$s Engineering
item.skillbook_combat.name=Mixed Field Tactics
item.skillbook_combat.desc=+%1$s Weaponry

item.skillbook_artisanry_max.name=Artisans through the ages
item.skillbook_artisanry_max.desc=Max Artisanry
item.skillbook_construction_max.name=Archive of Architecture
item.skillbook_construction_max.desc=Max Construction
item.skillbook_provisioning_max.name=History of Trade
item.skillbook_provisioning_max.desc=Max Provisioning
item.skillbook_engineering_max.name=Engineers' Lexicon
item.skillbook_engineering_max.desc=Max Engineering
item.skillbook_combat_max.name=Great War Journal
item.skillbook_combat_max.desc=Max Weaponry

# KNOWLEDGE INFORMATION

method.workbench=Crafting Table
method.furnace=Smelting
method.baking=Baking
method.roasting=Roasting
method.bloomery=Bloomery
method.tanner=Tanner
method.blastfurnace=Blast Furnace
method.anvil=Anvil
method.carpenter=Carpenter
method.crucible=Crucible
method.crucibleT2=Firebrick Crucible
method.crucibleT3=Mythic Crucible
method.crucibleT4=Masterwork Crucible
method.quern=Quern
method.kitchen_bench=Kitchen Bench
info.hasKnowledge=Can Research

gui.purchase=Purchase
knowledge.guiSubtitle=This is the GUI
knowledge.basicstructure=Basic Structure
knowledge.example=Example
knowledge.rightclickspanner=Right-Click spanner

# KNOWLEDGE TEXT
#knowledge.title=  DUPLICATE
#knowledge.title.desc= DUPLICATE
#knowledge.title.1= DUPLICATE

knowledge.minotaurs=Minotaur
knowledge.minotaurs.desc=Horrible Abominations

knowledge.minotaurs.1=Few creatures match the strength and rage of a minotaur. Legend has it these creatures were once human and cow before being fused into this new, horrible form. Minotaurs are omnivores have an extremely short temper.^Regardless of origins, a minotaur is powerful enough to rip someone to shreds within seconds if their set off, are able to heal quickly from the blood of their foes, and (in some cases) show signs of organisation.
knowledge.minotaurs.2=$hLesser Minotaur-$r^It may be common sight to see lesser minotaurs in the wild proving a threat to those unfortunate enough to come close.^These creatures are little more than beasts yet provide a misconception of actual minotaur behavior. Lesser minotaurs either have no home or are set out to scavenge for their greater counterparts.
knowledge.minotaurs.3=$hGreater Minotaur-$r^Greater minotaurs are found dwelling in dwarven complexes underground providing a challenge to explorers.^The minotaurs that are housed within these ruins are more organised and deadly. Standard minotaur warriors are brutal and armed while the elite and warlords that can be found deeper within ruins are powerful foes. It shall be made clear that ruins should be explored only by the prepared. One warrior may prove a challenge, but a group? few have survived.
knowledge.minotaurs.4=$hSpecies-$r^There are three known species of minotaur found in both wild and ruin. There is no difference to the behavior or living patterns of minotaurs of different species but physical properties do vary.
knowledge.minotaurs.combat=$hCombat-$r^The best advice that could be given to fighting off a minotaur would be range. Don't let them get close enough to hit you, even the strongest armour buckles under the force of their fury. Many minotaurs are heavily armoured as well but both hide and plate are vulnerable to piercing attacks a spear would be capable of exploiting both these weaknesses. Spears, explosives, distance and heavy armour give the best chances of survival.

knowledge.mob.minotaur.name=Brown Minotaur

knowledge.minotaur.1=Brown-fur minotaurs are the more common species in the overworld. They are found to have excessive strength and prove to be a powerful foe. Standard minotaurs have no natural armour but are still hard to kill.

knowledge.mob.minotaur_frost.name=Frost Minotaur

knowledge.minotaur_frost.1=Found in colder regions, these Minotaurs appear to have thicker hide than the brown minotaurs, resulting in natural armour. The Albino minotaur is difficult to see in the snow and can unleash a devistating rage on the unsuspecting traveller.

knowledge.mob.minotaur_dread.name=Dread Minotaur

knowledge.minotaur_dread.1=Not as much is known about what some call the Dread Minotaur. Denizens of the nether, dark-grey or black fur, powerfully thick skin, and immunity to fire. This species are far hardier than their overworld cousins.

knowledge.dragons=Dragons
knowledge.dragons.desc=Death from above

knowledge.dragons.1=Dragons are proud but destructive reptiles found stalking their prey from above. Many breeds of dragon are found in the world, varying greatly in their offensive capabilities. Keep an eye on the skies when travelling to avoid an ill omen.^Each dragon has a unique ability to emit deadly substances from their breath, though the actual mechanics behind this still remain unknown, it's always a decent idea to prepare for these dangers.^ Although their young may be easy to kill, the elder dragons are powerful monsters to

knowledge.dragons.2=face. The skin of these reptiles are so strong that most weapons are ineffective. Special dragonforged weapons can be made to penetrate their powerful scales.^ Dragons are hunted for their hearts, which have been useful for skilled artisans. Young dragon hearts aren't worth anything however and only older dragons are hunted for these purposes.

knowledge.mob.red_dragon.name=Red Dragon
knowledge.red_dragon.1=The most common form, red dragons have the capability of breathing fire. Many have fallen to these creatures and entire villages have gone up in flames. They use their breath more sparingly than other dragons, but appear to be extremely aggressive with their bite.

knowledge.mob.blue_dragon.name=Frost Dragon
knowledge.blue_dragon.1=With homes in the colder regions, Frost dragons get their name from the icy winds they are able to breathe out, freezing their foes. The frost dragon isn't seen as destructive or fearsome as their cousins, but are still deadly.

knowledge.mob.green_dragon.name=Green Dragon
knowledge.green_dragon.1=Green dragons, also known as "Venom Dragons" have a filthy, gruesome nature. They fly mainly in swampland, but can also come out in the rain. Green dragons emit a deadly acid from their breath, decaying armour and poisoning their victim.

knowledge.mob.ash_dragon.name=Ash Dragon
knowledge.ash_dragon.1=Ash dragons are found in the hot and dry such as deserts and can be easily identified by their two legs (rather than four). Ash dragons are blind, and require the use of sound and smell to track their target. keep your distance and remain quiet to avoid attack.

knowledge.dragons.combat=$hCombat-$r^Dragons may be fast and have the sky advantage, but they have a few weaknesses to exploit. Firstly is the ability to leave and return the battlefield, you are best to pay attention and avoid losing sight of your foe. As the dragon swoops, make your strike. A proerly lined ranged attack will grant an advantage when it takes off again. As well as that: specialised dragonforged items may be crafted to give an edge to the battle.

knowledge.getting_started=Getting Started
knowledge.getting_started.desc=From the ground-up

knowledge.getting_started.1=This is where you start working on MineFantasy. At this stage, it's recommended you at least have a hole to live in and somewhere to build, as well you should have a supply of wood, coal, copper, stone and hide. With these resources you can begin. To start in your world you will need to ready the three main processes.
knowledge.getting_started.2=Crafting blocks require some interaction on your part to function. First: Set up the recipe as instructed(heating items for anvils). Then select the correct tool with the correct tier (such as fists, knives, hammers, etc). You will then need to click the block with the item keeping hits about a second apart until it finishes.

knowledge.getting_started.hcc=$hHardcore Crafting-$r^Hardcore crafting appears to be active. Regular tools are less effective and its recommended that primitive tools are crafted. See the Artisanry section for all the tools.^To start off: Punch some stone... no really, break stone bare-handed (meaning no item held) and Sharp Rocks will be dropped.^Use these to break some leaves for vines and sticks, and logs for wood.

knowledge.getting_started.fire=$hFirepit-$r^Before you get to work, you need a fire, one of these should provide flame and a place to cook if you have meat.^Right-click with timber to add fuel, and firestarter to light.
knowledge.getting_started.food=Also place one of these stove tops on top of the fire. You then need to right-click raw food (mainly meat) to place them on the plate.

knowledge.getting_started.carpenter=$hCarpenter Bench-$r^The carpenter bench is a basic crafting table for a selection of recipes. The tools needed for this vary and some recipes require bare fists. See the crafting tools section for more information on tools.

knowledge.getting_started.tanning=$hTanning-$r^By now you likely would have gathered some hide you can't use. Tanning is a simple method of creating leather from hide.^To start off, build a shabby tanning rack and a stone knife. These tools are poor quality and should be upgraded when convenient.

knowledge.getting_started.forging=$hForging-$r^Forging is the main method of crafting. Pretty much every tool and metal object is made through this process. Start off by making a stone forge, anvil and tools. Place the anvil near the forge and some water. The artisanty tab has an entry of how forging works. Be sure to make a basic firestarter (Dry rocks-Craft-Tools), and wear an apron too!

knowledge.getting_started.forging_bars=Most recipes use bars rather than ingots. A bar is an easy to forge component made from metal. Create bars from placing a hot ingot on an anvil and hammering them.
knowledge.getting_started.flux=Flux is an important purification agent for metalworks. Primarily this is used for the treatment of metals in the forging process and some alloy creation. Flux is required or hunks and plates, required for some tools and armour.^The best source of flux is limestone. Make sure to keep a look out in your travels.
knowledge.getting_started.3=Now you need some leather strips for tools. Gather 2 copper (crafted into bars), 2 planks and 1 leather to craft a set of copper shears.
knowledge.getting_started.4=With these shears, you can cut leather to strips on the carpenter's bench OR a tanning rack by right-clicking them on the block with leather on it.

knowledge.getting_started.5=At this point: You now should have access to leather, copper, planks and strips. It is now possible to upgrade that stone hammer!

knowledge.getting_started.6=With your forge set up, you can now craft some copper tools. Check the "Forged Tools" Section for some copper alternatives.^Make sure to use tongs when handling hot items of course by right-clicking forge/anvil with tongs held.

knowledge.getting_started.upgrade=$hUpgrading-$r^Basic crummy old copper will only get you so far, soon enough you will want more. The research book and table allows you to expand on what can be made and how.^To start off, make a research table. The research table can study various items to unlock new recipes and processes to aid in your survival. Open the research book to view your current progress on knowledge, open the research table to place an item for studying.

knowledge.getting_started.7=Start off by smelting a copper and tin ingot and placing each on the research table, assuming your artisanry skill is high enough (level 5): you will be able to learn something from them. Try and work towards bronze smithing. You may also try looking at some leather to learn how to make better armour.


knowledge.getting_started.10=Soon enough you will need to work with dusts, either in cooking, engineering or artisanry. Most dusts are made with a quern in clay pots.

knowledge.getting_started.11=Try work towards "Bronze Smithing" now, crucibles are already known as you see. For this you will need 5 "Artisanry". You gain artisanry from crafting tools, weapons, armour and some commodities.^Once bronze smithing is researched, try upgrade your tools and start the road to the next endevour.

knowledge.getting_started.12=$hSalvage-$r^If you've found yourself low on useful resources and/or high on unused junk; give the salvage station a go.^This small, portable block allows retrival of components from objects.
knowledge.getting_started.13=To use: Just place the block and drop an item on top of it, then right-click the block. (Only Basic game, and Minefantasy items can be salvaged.^This is pretty much the basics, the rest is for you to find out...

knowledge.dust=Grinding Powders
knowledge.dust.desc=Technique for Dusts
knowledge.dust.1=You may be able to hold a pinch or so of dust in your hand, but there's no control for how much, or how to keep it from spilling. Clay Pots are used for carrying dusts and powders for many purposes, most dust is made with the quern, while very few recipe may use other tools. Here are some examples:
knowledge.dust.quern=To use the quern: all you need is to put clay pots in the middle, the correct item in the top, then click the top of the block.
knowledge.dust.icing=Some food based recipes (like icing) are made from multiple ingredients and mixed.

knowledge.research=Research Book
knowledge.research.desc=Keeping track

knowledge.research.1=There is a lot out there in the world to discover, all you have to do is find it. Research is a method of finding what's hidden within the world and using it to better your own works. Most of what you can do or make must be researched, and requires both skill and study to uncover its secrets.^To begin research, you enter without knowing what you may find. A research table must be crafted, and used to study items. Depending on your skill and what items you study may unlock some clues to new knowledge.

# /Table recipe

knowledge.research.2=With a research table placed, you are able to study items to uncover new knowledge. You require a certain amount of skill to unlock information, assuming your skill is high enough and you have appropriate prior knowledge, you may gain a clue to your research. Once you get all the clues for research will it be unlocked, you can view your progress with the research book.^If you lack the skill to discover anything new, keep the item and return later on when you discover and learn more.

knowledge.carpenter=Carpenter Bench
knowledge.carpenter.desc=Simple crafting
knowledge.carpenter.1=The carpenter bench is used for mostly wood related recipes, but should be built early on anyway. This bench can use a variety of tools such as bare hands(no item), hammers, and knives just to name a few. To use this, just assemble the recipe and click the block slowly with the proper tool.

knowledge.salvage=Salvage Station
knowledge.salvage.desc=Always Recycle
knowledge.salvage.1=There may be some advantages for being a hoarder in a harsh land, but there's really no use for all that unused furniture... or those inferior tools.^Salvaging stations can recover raw materials from many created items (Either Vanilla or MF).
knowledge.salvage.2=To use: Place the block and drop an item on top of it, right-click the block to salvage, there's a chance of recovering everything but it's not guaranteed. Damaged items have lower recovery rates.
knowledge.salvage.3=If you use a hammer on the block, there's a higher chance for returning items.^Saws are even more effective.

knowledge.talisman=Knowledge Talismans
knowledge.talisman.desc=Easy reading
knowledge.talisman.1=Figuring out the essentials of how something works can be difficult. Normally: Using the research table takes a lot of time and effort to get what you want. Talismans can speed up this process when right-clicked on a table.
knowledge.talisman.2=Greater talismans are rare and hardly used. These work like normal talismans only have infinite uses. You can also make books from them to max any skill.

knowledge.commodities=Commodities
knowledge.commodities.desc=Useful Items
knowledge.commodities.1=Commidities are the lifeblood of craft, each of these items are common and highly valued for their many uses. Most commodities are worth holding on to for later use.

knowledge.commodities.plank=Timber planks are nice solid pieces of wood, a common building commodity of all trades.^Timber can be broken down from a variety of wood, each providing different traits of quality.

knowledge.commodities.refinedplank=Some timber can be refined with a simple mixture, hardening its finish. Refined timber will be used for more advanced works. Only tier 1 woods can be used.

knowledge.commodities.flux=Flux is commonly used in refining metals. Standard flux can be used in devices such as blast furnaces for refining ingots. Strong flux is used in advanced alloys.

knowledge.commodities.hunks=For the smaller creations, hunks are used. You can turn bars into hunks with the application of flux.

knowledge.commodities.nail=Nails are basic items used in woodworking. They can be made from Copper, Tin, Bronze, Iron or Steel. (This doesn't affect quality, just amount made)

knowledge.commodities.rivet=Rivets are similar to nails, these are used in metalworking. They can be made from Copper, Tin, Bronze, Iron or Steel. (This doesn't affect quality, just amount made)

knowledge.commodities.leatherstrip=Leather strips are useful mainly in tool crafting.

knowledge.commodities.thread=Thread is used in sewing recipes. Thread can be turned into string

knowledge.commodities.bucket=Buckets can be made from metal, higher tiers make more.

knowledge.plants=Biological Gen
knowledge.plants.desc=Organic resources
knowledge.plants.1=A common sight on the surface is a variety of tree and plant life that can prove valuable for the right purposes.^Here are the plants found on the surface that can provide food and ingredients when needed.
knowledge.plants.2=Trees provide different types of wood, some better for certain purposes than others. This is a list of the trees found in the world.
knowledge.yew.1=Yew trees can be found within many forests, sparsely spread, standing alone. The properties of yew are superior than common wood, but are specifically effective in the creation of bows.

knowledge.ironbark.1=Ironbark is a recognisable tree that can be found in forests occasionally. The rough grey bark and orange inners make this tree stand out above the rest. Ironbark is a strong wood excellent for creating durable items.

knowledge.ebony.1=Ebony trees are huge and rare. These are found in moderate regions and provide extremely strong timber. Ebony trees are recognised by their size and dark brown to black wood. Ebony trees produce the strongest wood available.

knowledge.berry=Berries
knowledge.berry.desc=Nature's snack
knowledge.berry.1=Berries generate throughout the world if the temperature and rainfall is right. These are a common sight in forests.^Juicy(purple) berries are less common drops, and cure poison.^Berry Bushes can only be harvested with shears or silk touch.

knowledge.ores=Geological Gen
knowledge.ores.desc=Earthed resources
knowledge.ores.1=There is a small range of ores that generate in the world. Each of these can be smelted into ingots in one way or another.
knowledge.ores.copper=Copper ore is a common occurrence between layers 48-96. It can easily be smelted into ingots and turned into tools.^Copper can also be used to make bronze
knowledge.ores.tin=Tin is about half as common as copper but can be found in the same levels (48-96).^Tin is smelted into ingots and is used with copper to make bronze.
knowledge.ores.silver=Silver is found in the same areas as gold from layers <32. It's not very useful early on but more uses may be discovered.
knowledge.ores.wolframite=Wolframite is a rare substance, used for high-tech engineering purposes. It can be found in layers <16 in single block veins.
knowledge.ores.mythic=Little is known about this "Mythic ore" only that it is somewhat rare and found near bedrock. This strange ore seems to emit tingling sounds, for what reason is unknown...

knowledge.ores.2=Minerals also can be found generating within the world. Unlike ores: these can't be smelted into ingots, but have other uses instead.
knowledge.minerals.clay=Just as well as sand, clay can be found within dirt. Dirt-bearing clay can be found underneath grass, grass cannot grow on it either so it can be easy to find in hills.
knowledge.minerals.kaolinite=Kaolinite has a rather specific use. Mixed with clay: this mineral can beef up the strength of bricks.^It is found near the surface at layers 48-72 and although it's uncommon, comes in large vein sizes.
knowledge.minerals.limestone=A common source of flux. Limestone generates in large hunks throughout the world.
knowledge.minerals.borax=This is a relatively rare substance, Borax is the best source of strong flux: which is needed for powerful alloys.^This is a rare find but can be found at layers 48-96.
knowledge.minerals.nitre=A common occurrence within some cave walls in layers 16-64. Nitre is used in explosive creation.
knowledge.minerals.sulfur=Sulfur is found deep underground near lava at layers <16. It can be used to make explosives.

knowledge.chimney=Smoke and Chimneys
knowledge.chimney.desc=What greenhouse gasses?

knowledge.chimney.1=It is a well-known fact that burning fuel produces smoke. You will also need to understand that breathing smoke is not wise.^But if you're reading this you probably already figured that out after attempting to smoke it like a pipe.^In any case: Chimneys can be used to redirect smoke away from your precious breathing air and into the sky! Leave it for someone else a few centuries later to complain about.

knowledge.chimney.2=Chimneys can be widened by building a layer of stone around them, these can both increase the strength and capacity while also being able to seal gaps between ceilings and floors.

knowledge.chimney.3=Extractor chimneys can also be used on some devices (forge and crucible mainly) to absorb smoke indirectly.^"Indirectly" of course just means 1 block adjacent to where it normally would go.

knowledge.chimney.pipe=Smoke pipes allow the transport of gas between chimney systems. Each pipe itself cannot release smoke and must connect to a regular chimney at some point, these can only accept smoke from chimneys directly under.

knowledge.chimney.pipe.2=Best use includes a pipe system starting on the top of a starting chimney block, and leading outside with a second chimney on top.

knowledge.tanning=Tanning
knowledge.tanning.desc=Dead animal working

knowledge.tanning.1=Leather is a useful resource to have. Nearly any tool, weapon or armour uses leather.^Tanning is a simple method of cleaning up raw hide into a usable commodity.^To start off: You will need a tanning rack.

knowledge.tanning.2=To tan hide you first need to clean it. Either right-click the hide on water or put flux and hide on a crafting grid. When cleaned; right-click the tanning rack with hide to place it. then right-click with a knife steadily to prepare. For shabby tanning racks: there's a 1/10 chance to break the block.^A properly crafted tanning rack however does not break. It's recommended to craft these when their affordable.

knowledge.stamina=Stamina Mechanics
knowledge.stamina.desc=Keep fit

knowledge.stamina.1=It's not so easy to be running and mining all day you know. Stamina mechanics keep track of such.^Stamina (Represented as the green bar on the screen) decays when performing a variety of actions. It regenerates naturally and its speed is modified by equipped items. MF foods can modify stamina variables and sweet food can give regeneration. It's wise to consider the effects of some heavier items and how they may fit with your play style.

knowledge.combat=Combat mechanics
knowledge.combat.desc=More than one way to slay a skeleton

knowledge.combat.1=You may have noticed that constantly swinging aimlessly at monsters without a care in the world has lost it's effect some times. Combat (being a thing that you just have to deal with some times) has been modified to incorporate more complicated techniques.^Not only that but monsters can also use these meaning a zombie with a weapon is more dangerous than ever, as they can block attacks, power attack, and use other abilities mentioned.

knowledge.parry.info=$hParrying and Blocking$r^When holding right-click on most weapons, you block, simple right? Well now: blocking is much more effective. When you block an attack from straight-up, you immediately reduce(and can remove) the damage of the hit, blades are best at this while hafted weapons (like axes and blunt) take damage based on the hit.^It is recommended to block attacks rather than try take them, this technique can save lives. Attacking directly after a parry does reduce damage however.


knowledge.advanced_parry.info=$hParrying abilities$r^When a parry succeeds: if you're holding shift, you will lunge forward, and even past an attacker, throwing them your way. This consumes stamina but timed right, can change the battlefield to your favor. It is also possible to do this while jumping.

knowledge.power_attack.info=$hPower attacks$r^If you hold sneak and attack while falling down, you will attempt a power attack. A power attack cost stamina, but when it succeeds will double damage and bypass through a blocking target. This can be interrupted if attacked just before the attempt.

knowledge.dodge.info=$hDodge$r^In many situations, it's better to avoid a hit all together. If you jump to the sides or back while blocking, you will leap quickly. This uses stamina and cannot be done in heavy armour.

knowledge.armour.info=$hArmour Selection$r^There are three main types of armour Light, Medium and Heavy. If you rely more on avoidance and skill, use light, if you want more protection, rely on heavy, for a mix of both, use medium.

knowledge.blade.info=
knowledge.fastblade.info=
knowledge.axe.info=
knowledge.blunt.info=
knowledge.polearms.info=

knowledge.bar=Metal Bar
knowledge.bar.desc=Standardised shaping
knowledge.bar.1=An ingot may be used for your standard crafting and trading needs but their too thick for easy forging. Bars are produced from ingots to create a standardised, easy to reforge commodity, allowing easy setup and production of items. Bars are used in artisanry in particular over ingots for this reason.^A bar can be reconverted to an ingot with a similar method.

knowledge.smelt_copper=Copper Smithing
knowledge.smelt_copper.desc=Tier %1$s, Common material
knowledge.smelt_copper.1=The path of metalworking is a long and difficult one to learn. Copper is an easily workable and risk-free material.^It's still a piece of junk though, and is unable to make advanced tools, heavy weapons or heavy armour. But it's your piece of junk!

knowledge.smelt_bronze=Bronze Smithing
knowledge.smelt_bronze.desc=Tier %1$s, Common material
knowledge.smelt_bronze.1=With further refinement; both tin and copper are able to create an alloy greater than the sum of their parts. ^The applications of this material may be appreciated in later work.

knowledge.smelt_iron=Iron Smithing
knowledge.smelt_iron.desc=Tier %1$s, Common material
knowledge.smelt_iron.1=After some study on local rock formations, it appears rich levels of iron ore can be found. With correct refinement, the metal can be separated from the stone and formed into an ingot.^Iron is stronger than bronze and far more common, allowing for a low-cost and practical material.
knowledge.smelt_iron.2=Smelting iron into workable ingots isn't too difficult, but a certain level of skill is used to work it into a decent shape. You have refined some smithing techniques to enable proper construction of iron tools.

knowledge.smelt_pig_iron=Pig Iron
knowledge.smelt_pig_iron.desc=Iron preparation
knowledge.smelt_pig_iron.1=Natural iron is full of impurities and defects and proper refining of it is crucial to create a decent alloy. The blast furnace has been developed to achieve this. Iron ore can be refined with a particular mixture containing flux. Upon heating: the furnace will be able to draw more impurities away from the ore than other methods, this will yield a purer form of iron.^Pig iron, the product of this process is very brittle however, and further refinement is needed to make any use of it.

knowledge.smelt_steel=Steel Smithing
knowledge.smelt_steel.desc=Tier %1$s, Common material
knowledge.smelt_steel.1=After taking a look at the pig iron, it appears you may have found the problem behind its brittle nature. A simple method of heating and re-forging these ingots will be able to soften the shape, and increase flexibility.

knowledge.smelt_encrusted=Encrusted Smithing
knowledge.smelt_encrusted.desc=Tier %1$s, Exotic material
knowledge.smelt_encrusted.1=For what appeared to be a stupid idea at first may prove rather useful. By embedding tiny shards into steel it is possible to improve both the resistance and sharpness of the material.^Encrusted diamond ingots are far superior than regular steel and provide excellent perks for their cost.

knowledge.smelt_obsidian=Obsidian Smithing
knowledge.smelt_obsidian.desc=Tier %1$s, Exotic material
knowledge.smelt_obsidian.1=Studies into obsidian crystallisations have pointed you towards new discoveries in metallurgy. The high impact resistance of obsidian is unmatched in nature and now it may be possible to make use of these in your own works.^Mixing some molten obsidian with steel allows a strong crystalline ingot which can be worked into tools, providing a range of advantages.

knowledge.smelt_black_steel=Black Steel Smithing
knowledge.smelt_black_steel.desc=Tier %1$s, Common material
knowledge.smelt_black_steel.1=Every material has its limit, now you have found the right balance between bronze and iron alloys to perfect a new material. Black steel is extremely strong and far exceeds anything discovered thus far, although it can be difficult to produce and work, it may not be a decent replacement for iron.^This takes a two stage process, bringing together processes done thus far. Black steel can be made in a crucible of reasonable quality, and the ingots can be further refined in a blast furnace. The final result is a new dark, powerful material.

knowledge.craft_ornate=Ornate Style
knowledge.craft_ornate.desc=Worthy of cleansing

knowledge.craft_ornate.1=With the proper materials and time, it is possible to create more decorative variants of weapon, tool and armour. Ornate items are far more powerful against the unholy such as undead.^An ornate crest is used to craft these. place a single crest in the output slot of anvils then craft an appropriate item. When crafting finishes: an ornate item will be crafted.

knowledge.smelt_dragonforged=Dragonforge Style
knowledge.smelt_dragonforged.desc=Crude and powerful

knowledge.smelt_dragonforged.1=Dragons are tough creatures, and hunting them takes preparation and experience. Through your efforts, it is possible to use their own powers against them, Dragonforge weapons are more effective against damaging dragons.^To create dragonforge: Start by making any standard melee weapon with a dragon heart in the output slot. Just before finishing however: increase the temperature of three Forges around the anvil to be extremely hot, using their combined heat to raise the heat massively, then quickly finish the craft.
knowledge.smelt_dragonforged.2=If all goes well you will have a dragonforge item.^Unlike other designs; dragonforged items require this ritual take place for the craft to work.

knowledge.smelt_blue_steel=Blue Steel Smithing
knowledge.smelt_blue_steel.desc=Tier %1$s, Common material

knowledge.smelt_blue_steel.1=With further research into complex alloys, black steel seem to be nearing the peak of capability. However it seems apparent that some improvements can be made to the weight of the alloy. By mixing lapis lazuli and silver you can remove some particular elements from black steel and refine it to a much more lightweight material. How this works isn't fully understood, but it should provide a decent upgrade.

knowledge.smelt_red_steel=Red Steel Smithing
knowledge.smelt_red_steel.desc=Tier %1$s, Common material

knowledge.smelt_red_steel.1=Black steel is nearing the limits of metal capabilities and doesn't appear to be getting much better. Although after studying the effects of redstone and gold had revealed an unusual reaction take place. Redstone when mixed with gold appears to draw material such as black steel closer together, improving strength and weight. An alloy can be developed using this method to create a superior alloy with unimaginable strength.

knowledge.smelt_mithril=Mithril Smithing
knowledge.smelt_mithril.desc=Tier %1$s, Exotic material

knowledge.smelt_mithril.1=This mythic ore you found is very strange indeed. Any form of alterations made to this significantly changes its physical properties. You have found that interacting silver seems to alter its mass and hardness, but you don't know why or how to control it.^This amulet appears to contain a form of metallurgical instruction in its design. It appears these trinkets are for the purpose of showing off how they are created, likely for the ancient artisans to pass off their knowledge to later generations, that's the theory anyway.

knowledge.smelt_mithril.2=From the readings of this 'schematic talisman' it appears possible to use silver to force the mythic ore into a particular lightweight design. Seemingly the silver takes a large part in turning mythic ore into mithril.^It seems the trinket itself however, though complicated has no purpose.


knowledge.smelt_adamantium=Adamantium Smithing
knowledge.smelt_adamantium.desc=Tier %1$s, Exotic material

knowledge.smelt_adamantium.1=Mythic ore seems to follow its own rules and research into its properties have yielded strange results' upon exposing gold to this material, it increases greatly in density, becoming hard and heavy, this baffles you. ^This amulet appears to contain a form of metallurgical instruction in its design. It appears these trinkets are for the purpose of showing off how they are created, likely for the ancient artisans to pass off their knowledge to later generations, that's the theory anyway.

knowledge.smelt_adamantium.2=From the readings of this 'schematic talisman' it appears possible to use gold to force the mythic ore into its green, heavy state. Gold must play a part in the transformation of mythic ore into this particular set of chemistry. ^It seems the trinket itself however, though complicated has no purpose.

knowledge.smelt_master=Masterwork Mythics
knowledge.smelt_master.desc=The next level

knowledge.smelt_master.1=Your seeing some patterns emerging here. Whatever civilisation left these talismans behind appear to use them as a basic form of storing information, though it seems a book would have done just fine, but why judge.^You have found a new one, similar to the rest with the anvil shaped edges on a barbed shield shape, this follows the same set of instructions as the previously found artefacts. However with all three of these; it appears that they fit together like a puzzle. The master talisman appears to be carried by an elite artisan, with the two apprentices carrying the

knowledge.smelt_master.2=lesser talismans. There are also markings on the back of the master talisman describing a combined piece being placed into a working mythic crucible' This may be able to improve the crucible in some way.^The interesting part is the locations you have found these artefacts. Though the master talisman could be found anywhere, the lesser talismans were found depending on geographical location. Further south regions had the mithril workers while the northern regions had the adamantium workers.This pattern reinforces the idea that the mythic works were formed

knowledge.smelt_master.3=between different cultures in different regions. This has no effect on what forges can create what materials however, so their design must be the same.^In any case; this trilogy appears to hold great power and likely comes from the master artisans from both regions, perhaps using it on an active crucible may allow further refinements.

knowledge.smelt_ignotumite=Ignotumite Smithing
knowledge.smelt_ignotumite.desc=Tier %1$s, Master material

knowledge.smelt_ignotumite.1=The material known as Ignotumite appears to be a pure upgrade from adamantium. This seems to use more gold along the mythic materials to create what appears to be the heaviest, yet strongest of all the materials.^This can only be made in a master crucible.

knowledge.smelt_mithium=Mithium Smithing
knowledge.smelt_mithium.desc=Tier %1$s, Master material

knowledge.smelt_mithium.1=This material is a purer form of regular mithril in the ancient arts. What is known as Mithium appears to be nearly weightless, and appears hollow at the touch. It will be possible to further refine the properties of mithril to create the lightest material yet.^This can only be made in a master crucible.

knowledge.smelt_ender=Enderforge Smithing
knowledge.smelt_ender.desc=Tier %1$s, Master material

knowledge.smelt_ender.1=There's always been something strange about those ender creatures... And this discovery may lead to their origins, perhaps they were the ones that created these artefacts, can't explain how though, ender creatures don't appear too civilised.^Enderforge appears to be designed as a compromise between the two materials of mithril and adamantium, taking the best from both to create a new material. It appears that ender pearls can act as a catalyst to form these two materials together.^This can only be made in a master crucible.

knowledge.coal_flux=Coal Flux
knowledge.coal_flux.desc=Conservative
knowledge.coal_flux.1=A growing problem with smelting equipment is the large amount of coal required for proper reactions to take place. This results in difficulty refining large loads of material without a lot of coal to back it up.^You believe mixing flux with coal would be able to reduce the cost taken in these reactions, this would potentially halve the cost of coal for each use, allowing a single piece to create two equally useful materials.^This does come at a cost, the coal processed would no longer serve as a viable fuel source.

knowledge.big_furnace=Furnace
knowledge.big_furnace.desc=Mass Producing

knowledge.big_furnace.1=The process of refining basic ores and materials is nearly perfected now. The bloomery is a low-tech, slow and uneconomical device that makes a chore of all smelting work.^A large furnace has been developed from fire clay.

knowledge.big_furnace.2=This furnace is able to smelt four items at a time with relatively high efficiency. Its design is simple enough to work with ease, but will take some work to properly install.

knowledge.big_furnace.heater=For the furnace to function, it needs a place for the fuel to go. These heater blocks will be able to burn fuel steadily, the hotter these get, and the faster the furnace will smelt. Heaters need to be kept stable however, requiring fire-brick walls across its sides.

knowledge.big_furnace.top=Above the heater goes the furnace itself. This block works similar to the smaller models used, only is capable of regulating temperature much more efficiently. Much like the fuel-based counterpart the furnace requires fire bricks across its sides and top.

knowledge.big_furnace.structures=the structures works with multiple furnaces, two side walls and one back wall can support many connected furnaces.

knowledge.blast_furnace=Refining
knowledge.blast_furnace.desc=More than smelting

knowledge.blast_furnace.1=Processing of materials such as iron tends to leave them filled with impurities, and not reaching their full potential. A solution may be found by using a blast furnace.^Blast furnaces allow material to be smelted at incredibly high temperatures, and with a much higher rate of purity than other smelting equipment. This furnace does come at a cost in order to generate such a reaction, but should be able to properly refine iron ore to a much higher grade.

knowledge.blast_furnace.2=Of course before making the furnace: you will need to make a decent casing around them. For that, there's fire bricks.^Firebricks are able to sustain the extreme temperatures of the blast furnace and are used in its creation.
#Firebrick Recipes
knowledge.blast_furnace.3=The furnace is made of two blocks: Heaters and Chambers. Make one heater and up to 16 chamber blocks. The more chambers you put in, the more it can smelt.
#Furnace Recipes
knowledge.blast_furnace.4=Now with fire bricks, a heater, and some chambers: You can now assemble the furnace.^To start off: place the heater on the ground.^If a crucible is under the heater: It will catch the output.^Also make sure to leave plenty of room (about 4 blocks) all 4 sides.^The heater should have firebricks on 4 corners at its level. And by the life of you: don't cover the sides.
knowledge.blast_furnace.5=With that ready, stack the shafts on top of the heater, and put fire bricks on all 4 sides. leaving the top exposed to the sky (or a chimney).
#Structure
knowledge.blast_furnace.6=Using the blast furnace is pretty simple, but does consume a lot of fuel.^Start off by putting input (such as prepared iron) in the bottom slot and coal in the top slot of the top-most chamber block, (its recommended to use a small chimney to catch the smoke while remaining in
knowledge.blast_furnace.7=access to the block). When done properly the items will fall down the chute stacking 1 per chamber. After that: put some fuel in the bottom, fuel burns regardless of smelting so it's wise to take note of how much you may need. Upon finishing: all chambers will process one item, and the heater will evacuate its pressure, leaving a spectacular jet of flames.^Just make sure not to obstruct these jets or the furnace could explode. And keep flammable objects away!

knowledge.blast_furnace.hcc=$hHardcore Crafting-$r^With Hardcore crafting; A crucible must be placed underneath the furnace heater to catch molten ingots, you need to use a mould to remove them.

#Prepared Iron

knowledge.blast_furnace.9=Prepared iron ore is used to make pig iron.^Pig iron can be turned into steel.^You may use strong flux to double production, but strong flux is rare and should be used wisely.

knowledge.bloomery=Bloomery
knowledge.bloomery.desc=Early Metalworks

knowledge.bloomery.1=Gaining the precious material from rock-encrusted sources isn't easy. Bloomeries allow proper smelting of ingots from raw ores.

knowledge.bloomery.2=To use: Place equal amounts of ore and coal in the block and right-click it with a firestarter. If all goes well it will start smelting, the more items it has- the slower it works.^Bloomeries must be placed outdoors, clear to sky in order to function and chimneys will not work either.^The whole stack will be smelted in this process, when finished- the top will come off and expose the bloom. Click this steadily with a hammer to finish the process, keep going until all ingots are retrieved.

knowledge.bloomery.3=Make sure you're holding empty tongs when you collect the ingot.

knowledge.crucible=Alloying
knowledge.crucible.desc=Mixing metals

knowledge.crucible.1=There's only so far you can go by relying on one metal or another to fit your needs. For this: there's the crucible.^Crucibles are designed for alloying, where you can get multiple materials and mix them to make even better materials.

knowledge.crucible.2=In order to function, Crucibles need a heat source below them(such as a $hForge$r), lava also works but is very slow.^Crucible recipes are shapeless and run off "ratio".^For example: 3 Bronze is 2 copper and 1 tin. This means you can put copper in 2 slots, and tin in 1, and each smelt gives 3 bronze. But you can put 4 and 2 in to get 6, and so on...

knowledge.crucible.hcc=$hHardcore Crafting-$r^With hardcore crafting however: Items cannot be retrieved from the crucible GUI. You need to craft an ingot mould, right-click this to retrieve the ingots 1 at a time, and cool them in water.^Also: If you break the crucible, outputs will be lost!

knowledge.firebrick_crucible=Advanced Alloying
knowledge.firebrick_crucible.desc=More Mixing...
knowledge.firebrick_crucible.1=The possible applications for fire clay and brick are always broadening. Crucibles have always had difficulties with heat regulation and were never able to properly melt down material efficiently. The addition of fireclay should fix this problem.

knowledge.firebrick_crucible.blocks=The outer layer is not enough however for the crucible to function properly. Four additional blocks of fire brick must be set around the block for the crucible to function properly.

knowledge.apron=Blacksmith Apron
knowledge.apron.desc=Protective wear

knowledge.apron.1=Forges can get hot, and so can the metals processed in them. When using a forge its recommended to wear one of these. Blacksmith attire consists of a shirt, apron and gloves. This is suitable for forge and ingot handling. Items burn you in your inventory without these.

knowledge.anvil=Forging
knowledge.anvil.desc=The basis of metalworks

knowledge.anvil.1=Not that crafting tables are obsolete or anything but there's many better ways to craft items. Forging is the most common means to craft anything metal.^This process includes using the Forge to heat metals, and working them on an anvil.

#Recipe

knowledge.anvil.2=Anvils are simple to craft and can be recycled in a furnace.^Place the anvil on the ground, somewhere near water and a forge. Right-clicking the anvil from the side or without a hammer opens the GUI.

#Gui

knowledge.anvil.3=Crafting items can be complicated, there are two stages to crafting.^Firstly some items(mostly metal ingots and hunks) need to be heated in the $hForge$r. If an items heatable, it needs to be heated.^Secondly is the recipe itself: Start by assembling the components on the

knowledge.anvil.4=grid$h[3]$r then: equip a proper hammer (either heavy or normal depending on the recipe). Each recipe has a recommended tier of hammer and anvil. Hammers will yield unpredictable results on quality if a low tier and anvils will make quality crafting harder on low tiers. Tiers will appear above the title$h[1]$r.^Hit the anvil with the hammer by clicking. The progress bar$h[2]$r will now fill in, when finished: The result appears in the output slot$h[4]$r.^Some items will be hot, you can right-click them on water or a cauldron(shift click), to cool them.

knowledge.anvil.5=To pick up finished items: right-click with tongs, tongs only take items from the final output slot. Holding hot items will burn you, so when you need to pick something off the forge, right-click it with tongs, then the anvil to place.

knowledge.anvil.6=While crafting, keep track of the quality metre. The aim here is to keep the marker away from the edges. If it hits either side it ruins the recipe. When crafting damageable items however; the durability of the item is diminished if the marker is outside the pins when completing.^As you see, there's the two green pins that damage items if the blue marker is outside, either end of the bar itself is the dead zone. Be sure to distribute a mix of left-click and right-clicks to craft an item and think ahead before hitting. also note the metre moves right slower than left.

#Quality
knowledge.anvil.7=If you SHIFT-LEFT click however it will knock the metre back(to give you some more time to craft), don't exceed 0 however, or it will ruin the item.

knowledge.forge=Forge
knowledge.forge.desc=Its getting hot in here.

knowledge.forge.1=The forge is a simple device, put fuel in it (Right-click an item). and light it with a firestarter (like flint and steel).^It's easy! Just throw stuff in it and set it on fire!

knowledge.forge.2=Forges burn at different temperatures depending on the fuel, the temperature depends on the last item thrown. $hBellows$r can be used to temporarily increase the temperature.^You can place heatable items(like ingots and hunks) in the forge, and they slowly will heat up.^ $y"WORKABLE"$r items are needed to use an anvil, $d"UNSTABLE"$r Items are too hot.^Use different fuels and bellows to get the temperature where you want it, and make sure to monitor

knowledge.forge.3=your items.^NOTE: if a crucible(or similar) is above the forge: it cannot be accessed.

knowledge.bellows=Bellows
knowledge.bellows.desc=Heat Injection

knowledge.bellows.1=Sometimes the fire just isn't hot enough, or it may be taking to long to warm up. Using hotter fuels only takes you so far and can be wasteful when not needed.^Bellows can temporarily boost the temperature of forges by up to 50%%. To use: Place them pointing at the desired block and right-click them constantly. They can also work through solid walls.

knowledge.trough=Trough
knowledge.trough.desc=Ready to Quench

knowledge.trough.1=Having to walk to or build near water sources can be tricky, and regular water sources can damage smithed items. Troughs are simple containers capable of quenching hot items, just right-click tongs or hot items on this. To fill: Right-click with a bucket or water jug, but make sure not to overfill it.^It is recommended to quench items in a trough, they may be damaged otherwise.^Troughs can also be filled by right-clicking the block on water, you can also pick them up without losing contents.

knowledge.trough.2=With some nails and a little bit of effort, troughs can be assembled properly with minimal leakage and allows wooden materials to affect its quality.

knowledge.repair_basic=Repair Kits
knowledge.repair_basic.desc=Keeping tools in condition

knowledge.repair_basic.1=Tools get damaged a lot, and replacing them is wasteful. You've been studying various bits of leather and some nails and had found a new use for them.^Simple materials with some tools should be enough to repair some items, it's not perfect but seems to be better than nothing. Perhaps more research would yield something more effective.^To use: right-click damaged items onto a placed kit, the kit has a chance of breaking.

knowledge.repair_advanced=Advanced Repairing
knowledge.repair_advanced.desc=Better conditioning

knowledge.repair_advanced.1=You've taken a look at this strange slime produced by the gelatinous cubes. Whatever their made of seems to stick like no one's business. And this silk from the local giant spiders is extremely strong and sticky as well.^Together they should be able to upgrade one of these repair kits for more effective use.

knowledge.repair_ornate=Ornate Repair Kits
knowledge.repair_ornate.desc=Enchantment Repair

knowledge.repair_ornate.1=Magical items seem to play by their own rules here' Stuff just doesn't stick to them. It however appears that gold and diamond can counteract these effects. If the tools are used with these materials in a particular way, they may be able to repair enchanted items.^This also offers some increased effectiveness over a regular advanced repair kit.

knowledge.craft_armour_basic=Basic Armor
knowledge.craft_armour_basic.desc=Nothing fancy
knowledge.craft_armour_basic.1=When you first start out in this world, you may want something to wear. These Armors don't offer much protection but their better than nothing.

knowledge.craft_armour_light=Light Armor
knowledge.craft_armour_light.desc=Cheap and practical
knowledge.craft_armour_light.1=Light armor is designed to be as easy to wear as possible and is only made from a small variety of material. You do not get much protection from this, but your ability to dodge and parry will be unaffected.^These suits are best worn where tactics and avoidance are used.
knowledge.craft_armour_light.2=Rough leather is a basic layer of sewn leather pieces covering the body. This alone provides little protection but acts as a foundation for other suits.
knowledge.craft_armour_light.3=Padded armour is highly effective against light attacks, blunt in particular. This suit is used as a foundation for heavy armour.
knowledge.craft_armour_light.4=Reinforced and studded leather are upgraded versions from rough leather. Reinforced leather can be used to craft medium armour.

knowledge.craft_armour_medium=Medium Armor
knowledge.craft_armour_medium.desc=Average protection
knowledge.craft_armour_medium.1=Through some inspection of leathers, it appears obvious that it has many limits to its strength and impact resistance.^Much similar to how animals have fur, scales and bone that may assist in protection, you must also find something to reinforce leather with to allow better protective capabilities.^Mail armour is made of standard leather, only with metal components to give some extra resistance, though it may restrict movement slightly and would prove tiring to wear.
knowledge.craft_armour_medium.scale=As an alternative, Scalemail can be created. Scale armor has more balanced protection against all forms of damage, not quite as effective against piercing and cutting resistance, it makes up in blunt.

knowledge.craft_armour_heavy=Heavy Armor
knowledge.craft_armour_heavy.desc=Strong but restricted
knowledge.craft_armour_heavy.1=You have gained decent protection from medium armour, yet is still seems limited. Medium armour does have a large amount of advantages but there may be a way to improve further.^Through study of the anatomy of some of the wildlife: It seems apparent that wool and feathers cushion blows rather effectively, a padded piece of armour may offer a decent advantage.^This would make armours created in this style very heavy and hard to wear however.
knowledge.craft_armour_heavy.2=Heavy armour is crafted with a padded suit already made. Padded armour provides a soft and protective layer for underneath armour.
knowledge.craft_armour_heavy.splint=Splintmail isn't quite as heavy as a full blown suit of plate, and has lesser protective qualities in return. However, splintmail is still far superior to medium armors and protects all damage types equally.
knowledge.craft_armour_heavy.plate=Plate armour is the strongest, but most expensive and difficult to craft.

knowledge.crafting_HCC_tools=Primitive Tools
knowledge.crafting_HCC_tools.desc=(HARDCORE CRAFTING)

knowledge.crafting_HCC_tools.1=With Hardcore Crafting active: Basic tools are not what they used to be... You need to work your way up to metal by crafting primitive stone tools first.^Primitive stone tools are made on the carpenter bench.^ Every Stone tool needs 3 components to make:^Sharp rocks are gained by breaking stone bare-handed (No item held).^Vines can be gained by breaking leaves with a sharp rock.

knowledge.crafting_HCC_tools.2=Sticks can be gained similar to vines.^Stone can also be crafted from cobblestone, a hammer is first needed though.

knowledge.crafting_HCC_tools.3=With these thee components, a carpenter bench must be made for tool crafting: It is recommended to make a pick first, as they can mine stone (processed into rocks).

knowledge.craft_tools=Forged Tools
knowledge.craft_tools.desc=Properly crafted
knowledge.craft_tools.1=What is that? you throw a stick on some rocks and call that a tool? HA! These are how REAL tools are made!^All the goodness of normal tools only made properly, these tools have double the durability... and double the style.^Picks can also tell you a blocks tier and if it can be mined. Just right-click a block with a forged pick.

knowledge.craft_advanced_tools=Advanced Tools
knowledge.craft_advanced_tools.desc=Fit for purpose

knowledge.craft_advanced_tools.1=Not only can you forge proper tools but there is also a selection of additional tools with their own uses. Most of these tools are alternatives to existing tools, only... different.^$hHandpick$r^Handpicks have a chance to drop random items (like ores and minerals) from mining some blocks like stone and netherrack^Also they drop additional items from ore like coal and diamond.

knowledge.heavy_pick.info=$hHeavy Pick$r^Heavy picks mean business! Upon breaking blocks; heavy picks mine a 3x3x3 block around them, with lower drop rates. Perfect for digging large caverns or mineshafts.

knowledge.trow.info=$hTrow$r^This little cute spade works like a handpick. When digging dirt it can drop random items, grass can drop seeds.

knowledge.heavy_shovel.info=$hHeavy Shovel$r^Apart from looking like a door on a haft; Heavy shovels are rather useful tools for digging.^When digging, these shovels will break a disc shaped hole, ignoring hills. Great for levelling terrain out.

knowledge.scythe.info=$hScythe$r^Scythes can break grass or leaves within a large area when right-clicked, their good for farming and clearing up. Also: If you wear a black hood with it: You can scare old people!

knowledge.mattock.info=$hMattock$r^A commonly used tool for landscaping, a mattock is used for creating roads. Dirt, Grass or sand can be dug out and turned into a road. Blocks can then be placed on there to change their look.
knowledge.mattock.use=Right-click with the mattock to turn a block into a road. you can then right-click any solid, cuboid block to change its texture. You can also right-click a shovel to turn it into a half block.^With a mattock in hand, Roads can be locked to prevent further modification with right-click. A red-icon on screen means the block cannot be edited, a green icon means it can. toggle this when you're working on the road.

knowledge.lumber.info=$hLumber Axe$r^This heavy axe is used for ripping down forests with ease. The lumber axe is capable of demolishing a whole tree with a single break of a block. Larger trees use more durability and can drain the strength of the tool fast.

knowledge.craft_weapons=Forged Weapons
knowledge.craft_weapons.desc=For "Defense"

knowledge.craft_weapons.1=What is that? A wooden sword... you can do better than that...^Different combat styles use different weapons, there should be one to fit your style.^$hDagger$r^Daggers are tiny little blades that... well their pretty lame really.^But their light and quick to the strike! Pretty good for a spammy-attack style.

knowledge.sword.info=$hSword$r^A good old sword. Swords block the most damage and at the best arc. A finesse based blocking and countering style suits this weapon.

knowledge.mace.info=$hMace$r^For a good bop across the bonce!. Maces aren't that special and blocking damages the weapon more. But they have good durability and damage.

knowledge.waraxe.info=$hWaraxe$r^A heavy hand axe for brutal hacking at your foes. War axes do decent damage and have bonuses when sprinting and jumping attacks. Good for the barbaric types. They also take more damage from blocking.

knowledge.spear.info=$hSpear$r^If you're too scared for close combat, spears allow you to poke them from afar.. you know like you're just pushing them away with a long stick!^Spears do more damage when sprinting

knowledge.bow.info=$hBow$r^Standard wooden bow with metal joints.^Note that some more brittle metals (like pig iron) will lessen the damage of the item.^RIGHT-CLICK while sneaking to open the inventory. Ammo must be loaded before use.

knowledge.craft_advanced_weapons=Heavy Weapons
knowledge.craft_advanced_weapons.desc=Big enough?

knowledge.craft_advanced_weapons.1=I'm not sure what you're intending on killing but here's some of the... larger pieces.^$hKatana$r^Katanas are the lightest heavy weapon and aren't much heavier than a normal sword. This weapon strikes fast and is the least tiring to use. Power attacks will also damage armour.^^Ninja approved!

knowledge.greatsword.info=$hGreatsword$r^A heavy, flat blade. Greatswords are the best defensive heavy weapon. Like swords: Greatswords are decent for blocking.

knowledge.warhammer.info=$hWarhammer$r^If you ever wanted to hit something across the skull with a weapon the size of the anvil it was made of. Warhammers pack a punch!

knowledge.battleaxe.info=$hBattleaxe$r^For when a waraxe won't cut it (pun not intended). Battleaxes do more damage then waraxes and are heavier(obviously). for an even crazier barbaric type.^Tiring to use though

knowledge.halbeard.info=$hHalbeard$r^Well if a spear is too whimpy! You can put an axe on it. Halbeards do more damage than spears but are heavier.^Halbeards can stab when sprinting.

knowledge.lance.info=$hLance$r^Lances are pretty useless as a weapon. But when mounted they do more damage based on the speed you're going.^More suited for jousting if you haven't figured that out.

knowledge.firemaker=Firemaking
knowledge.firemaker.desc=Burn it all
knowledge.dryrocks.info=Dry rocks are the most basic, and least effective method of creating fire. Banging two of these together will create a flame after awhile.
knowledge.tinderbox.info=The tinderbox is effective at starting fires and highly durable. It still may take a few tries to get a flame, but the extra uses pays off.
knowledge.flintsteel.info=This is the most effective fire starter as it works instantly. Flint and Steels have less durability than a tinder box however.

knowledge.craft_crafters=Crafting Tools
knowledge.craft_crafters.desc=That's tools for crafting

knowledge.craft_crafters.1=There's a variety of different tools for the purpose of crafting. A lot of recipes require you to interact with the block with these tools.^$hHammer$r^Hammers are used mostly in forging. hammers are highly useful for both metalworks and some woodworks.
knowledge.heavy_hammer.info=$hHeavy Hammer$r^There also are heavier counterparts of the hammer, used for forging some of the larger metal items.

knowledge.tongs.info=$hTongs$r^Tongs are used for picking up hot items from the anvil, to transfer to a water source. Unlike simply dropping hot items, tongs will place items above the block rather than randomly about.

knowledge.knife.info=$hKnife$r^Knives can be used in cooking and tanning. Knives are useful.^Just don't run with them.

knowledge.saw.info=$hSaw$r^Saws can cut wood into planks more efficiently. Put a planks block on a carpenter bench and hit it with a saw.^Saws also are much more effective at salvaging items.

knowledge.needle.info=$hNeedle$r^Needles are used for sewing based recipes. Needles are used wherever thread is used.

knowledge.mallet.info=$hMallet$r^Mallets are not really common... It's pretty much only used where a hammer may be a bit too much. So basically: some woodworks use this.

knowledge.spoon.info=$hSpoon$r^Spoons. Used for cooking, generally mixing... What else to say... it's a spoon...

knowledge.arrows=Fletching
knowledge.arrows.desc=Arrow crafting

knowledge.arrows.1=Crafting arrows can take some time, but still remains moderately low-cost. You can make many different arrow heads from any metal. Arrow shafts can be crafted with paper or feathers, but feathers are more effective. Attach the heads to their shafts on a carpenter bench.

knowledge.arrows_bodkin=Bodkin Arrows
knowledge.arrows_bodkin.desc=Light and fast

knowledge.arrows_bodkin.1=The physical properties of arrows takes time to master, but there is a way to improve it. You believe a lightweight, smooth and symmetrical head would improve the speed and accuracy of arrows. This would come at a cost of damage, but it may be worth it.

knowledge.arrows_broad=Broad arrows
knowledge.arrows_broad.desc=Heavy and strong

knowledge.arrows_broad.1=After studying a piece of flint, you find a fascinating shape to one sample in particular. Although making arrows accurate and fast is an excellent choice, a heavy and broadened head could offer a decent damage bonus.^A broad head arrow is heavier, slower and less accurate than the previously created bodkin design. Although the damage this would cause would be a worthy trade indeed.

knowledge.engineering_tools=Engineering Tools
knowledge.engineering_tools.desc=Tools of the trade
knowledge.engineering_tools.1=Engineering could be a delicate trade in some aspects. For that, you need tools that can handle these processes.

knowledge.engineering_components=Components and Commodities
knowledge.engineering_components.desc=For Engineering

knowledge.engineering_components.1=For engineering, there's some nifty ways you can join components. However, you may need to find some alternative commodities for doing such. It's worthwhile to make a few of these for when their needed.

knowledge.engineering_components.2=Most engineered objects aren't just forged. Construction usually takes pre-forged components and attaching them together. Components however are mostly used for specific purposes, and are better made on-site (Unless you intend to mass produce).

knowledge.coke=Coke
knowledge.coke.desc=Refined Fuels

knowledge.coke.1=Alone, Coal is just full of impurities which reflect on poor burning capabilities. With much refinement, and the use of redstone, charcoal can be burned at a rate that completely removes all imperfections and leaves the coal in its purest form, for optimal fuel use. This process only works with coal however.

knowledge.tungsten=Wolframite Smithing
knowledge.tungsten.desc=Machine-Worthy Metal

knowledge.tungsten.1=There's always a limit to using iron based materials in engineering; It just cannot handle the stress some machines have applied. Wolframite is a rare metal found within lower layers of stone. The ore itself can be found in some occasions, but can also be found by use of a handpick.

knowledge.tungsten.2=If you use a high enough tier (such as encrusted) below layer 16: It is possible to mine raw Wolframite ore.^After that, it's only a matter of refining it. Wolframite requires to be melted down with large amounts of coal and flux to separate the ore.

knowledge.tungsten.3=Although this material is highly valued to engineers, it does require some decent smithing skills to refine the ore, making it even more difficult to acquire.

knowledge.engineering_tanner=Advanced Tanner
knowledge.engineering_tanner.desc=Easy Tanning

knowledge.engineering_tanner.1=Tanning is probably one of the most tiring methods of production. Now with some proper mechanical methods you can make it easier!^This tanning rack is able to slice and dice clean hide for you. Just place the item as usual, then sneak right-click.

knowledge.advanced_crucible=Auto Crucible
knowledge.advanced_crucible.desc=Easy Alloys

knowledge.advanced_crucible.1=These schematics found highlight an interesting secret behind dwarven metalworks. Through study into smelting technology, it appears there is a mechanical system that can shape and cool off metal into ingots without effort. If a crucible were to be fitted with this system, it would improve production indeed.

knowledge.advanced_forge=Advanced Forge
knowledge.advanced_forge.desc=Full control

knowledge.advanced_forge.1=These dwarven schematics also appear to have a design of forge which as such a well-controlled method of burning fuel that it can be controlled with a redstone signal.^This forge can be easily switched on and off, saving fuel consumption.

knowledge.blackpowder=Explosives
knowledge.blackpowder.desc=Boom!

knowledge.blackpowder.1=Using generic gunpowder and TNT to blow things up may be satisfying but it makes one hell of a mess. It is possible however to create devices with more controlled explosions that limit the environmental damage.^Blackpowder is an explosive substance capable of doing large damage while limiting the destruction of blocks.^It's not world-shatteringly powerful like the stuff creepers use.^Blackpowder is made from various minerals found while mining.

knowledge.advanced_blackpowder=Refined Blackpowder
knowledge.advanced_blackpowder.desc=Ka Boom!

knowledge.advanced_blackpowder.1=Blackpowder has proven useful for explosive creation but sometimes you may need more of a blast.^Through the use of redstone and glowstone: you can beef-up the power of blackpowder to increase damage.

knowledge.climber=Climbing Pick
knowledge.climber.desc=Getting up there
knowledge.climber.1=It's getting a bit awkward having to go around mountains and find stairways up the slopes, especially so if you just fell 50 metres down a cave. A climbing pick allows you to grapple solid blocks, only complete cubes can be grappled (such as stone and grass).
knowledge.climber.2=To use this properly can be tricky. First off, hold down right-click on a block you're right up against (you can also do blocks above that). Then hit left-click to pull yourself up, holding shift and left clicking goes down. It is possible to climb sideways, and up overhangs, but is difficult.

knowledge.spyglass=Spyglass
knowledge.spyglass.desc=Yondar!
knowledge.spyglass.1=There's so much to see out there, but due to the limit of our eyes we have to walk all the way over there to see it... Not anymore.^Spyglasses allow you to see further when used, Shift-Right-Click changes the scope mode.

knowledge.parachute=Parachute
knowledge.parachute.desc=What goes up...
knowledge.parachute.1=You may know how to get up to a high place, but some time the ground may have something to say on the matter. Parachutes allow you to safely drop from high distances, slowly.

knowledge.syringe=Syringe
knowledge.syringe.desc=Easy administer
knowledge.syringe.1=Drinking potions is slow and awkward in emergencies. Syringes allow you to inject potions directly into your system, being useful the moment you need it. You can also shift-click on others to use on them.^To Fill: Place an empty syringe and a regular potion on a crafting grid.

knowledge.bombs=Bomb Crafting
knowledge.bombs.desc=Explosion Delivery

knowledge.bombs.1=What use is blackpowder without something to put it in? Well these little gadgets will do serious damage to a small area.^Bomb crafting is more... experimental than other works. First of all: you need a workstation set up.

knowledge.bombs.2=Now put that down... Wherever.^With this table you will be able to create both bombs and mines. Bombs can be thrown by holding right-click for a short time and they will explode at after a time. Mines however will be placed with holding right click and explode when something steps near them.

knowledge.bombs.3=Bombs and Mines require 3-4 components in their creation.^The casing$h[1]$r determines the damage and range of the device. Powder$h[2]$r will modify damage. Filling$h[3]$r can be empty and is used to add effects to the bomb. Finally the fuse$h[4]$r determines the time until detonation.

knowledge.bombs.4=To craft a bomb: simply put components in their respective slots for example ceramic casing, blackpowder and a short fuse. then click the block to make a single bomb.

knowledge.crossbows=Crossbow Crafting
knowledge.crossbows.desc=Deadly Projectiles
knowledge.crossbows.1=Crossbows are a custom-made firearm capable of dealing large amounts of damage with a reliable rate. Although these are usually slower than bows, crossbows can be made with a variety of components, allowing them to excel at a wider range of purposes.
knowledge.crossbows.2=To create crossbows, you will need an assembly table.^This table allows the combination of parts to create a finished device. The traits of the crossbow depend on these 4 components (Stock, Arms, Mod and Muzzle).
knowledge.crossbows.3=Place this bench down in the desired location. Now you will need to create parts for your crossbow (See further entries).^The Stock and Arms are required for any crossbow. Stocks affect the recoil, and reload speed of the crossbow, short handles define "Hand crossbows" which are fast and inaccurate.
knowledge.crossbows.4=You may also add both a mod and muzzle to the crossbow. Mods go on the top and can add additional functionality (at a cost). Muzzles are mods specially designed to be fitted at the tip of the weapon (like a bayonet). It's always good not to add a mod if it's not needed.
knowledge.crossbows.5=To craft a crossbow: Place the desired parts in their respected slots. (Similar to bomb crafting) You will then need to steadily click the block with a spanner to craft the item.
knowledge.crossbows.6=When that's finished: you have a crossbow. Crossbows function differently to bows and can be fired immediately if the weapon is ready. Sneak and use the item to open its inventory. This must be used. You can add any bolt to the inventory of the crossbow and it will load when you use it.

knowledge.crossbow_shafts=Crossbow Stocks
knowledge.crossbow_shafts.desc=Vital component
knowledge.crossbow_shafts.handle=Handles are miniature stocks designed for creating hand crossbows. This small design allows fast reload speed at the cost of accuracy and recoil.
knowledge.crossbow_shafts.stock=Stocks are full-sized versions of the Handle and are capable of firing a crossbow with less recoil. Due to their size, reduce the reload time.

knowledge.crossbow_heads=Crossbow Arms
knowledge.crossbow_heads.desc=Vital Component
knowledge.crossbow_heads.light=A Lightweight crossbow head allows easy reload speed at a cost of power. This head can be modified multiple times to increase its weight and power.
knowledge.crossbow_heads.medium=A standard sized crossbow head. This has a balanced power and speed.
knowledge.crossbow_heads.heavy=A heavy-duty, reinforced crossbow head. This has a massive force behind it, and it shows with a high recoil and slow reload time.

knowledge.crossbow_head_advanced=Advanced Crossbow Arms
knowledge.crossbow_head_advanced.desc=Precision over speed

knowledge.crossbow_head_advanced.1=This set of dwarven crossbow schematics consists of a steel cross capable of releasing a powerful force. With the right materials and tools, it is possible to create your own.^Although slow, this crossbow head should be able to fire bolts with deadly power and accuracy.

knowledge.crossbow_shaft_advanced=Advanced Crossbow Stock
knowledge.crossbow_shaft_advanced.desc=Recoil Control

knowledge.crossbow_shaft_advanced.1=For what appears to be based off a regular wooden stock: this dwarven crossbow includes a metal design. Although heavy, it appears to contain a spring-loaded system for absorbing recoil.

knowledge.crossbow_ammo=Repeating Crossbow
knowledge.crossbow_ammo.desc=Expanded capacity
knowledge.crossbow_ammo.1=Crossbows can take time to reload, and you may need to fire more than once to get the job done. Repeating mechanisms go in the "mod" slot and allow crossbows to fire multiple shots before reloading (at a cost of accuracy)

knowledge.crossbow_scope=Crossbow Scope
knowledge.crossbow_scope.desc=Primitive Sniper
knowledge.crossbow_scope.1=What use would an accurate crossbow be without the ability to see what you're shooting at. Spyglasses can now be modified to fit onto crossbows in the "mod" slot.

knowledge.crossbow_bayonet=Crossbow Bayonet
knowledge.crossbow_bayonet.desc=Melee Damage
knowledge.crossbow_bayonet.1=While some reload their crossbows, it's usual for some jerk to take advantage of the situation, you need to fight back another way. Bayonets attach to the "muzzle" slot and can increase the melee damage from crossbows.

knowledge.bomb_press=Bomb Press
knowledge.bomb_press.desc=Mass Productive
knowledge.bomb_press.1=Having to assemble each bomb individually can be tedious... very tedious. This device can do the work for you, all you need to do is place it directly above a bomb crafting table, pull the lever and it crafts the bomb for you.

knowledge.bomb_arrow=Bomb Arrows
knowledge.bomb_arrow.desc=To pack a punch
knowledge.bomb_arrow.1=Your experience in the creations of bombs has paid off. These tiny explosives can be packed similar to bombs and deliver a deadly blast. Bomb arrows are created like any bomb, place the arrow casing in the case slot. These do not take fuses.

knowledge.shrapnel=Shrapnel Bombs
knowledge.shrapnel.desc=Simple Filling
knowledge.shrapnel.1=Bombs seem all well and good so far, but there seems to be room to improve. Each bomb is able to fit in a layer of filling that modifies the detonation of the device.^Shrapnel can be added in bomb crafting to increase the damage dealt from explosions.

knowledge.firebomb=Firey Explosions
knowledge.firebomb.desc=Deadly Incineration

knowledge.firebomb.1=Adding shrapnel to bombs is very effective at eliminating ones fellow critters of the land. But there can be more insane carnage.^A mixture of magma cream can release a massive blast of pure flame upon detonation. Refined magma cream burns at such a high temperature few can withstand its blast.

knowledge.firebomb.2=How it works is the magma cream (being a mixture of burning embers and sticky slime) is able to keep a self-sustaining flame while remaining as a spreadable substance. Additional blaze powder then reacts with a dragon heart to release a magical catalyst that increases the temperature of the flame.
knowledge.firebomb.3=Incineration bombs may be expensive, but their extremely effective against armour.

knowledge.bomb_ceramic=Ceramic Bomb Casing
knowledge.bomb_ceramic.desc=Basic Bombs
knowledge.bomb_ceramic.1=Bombs are one of the simplest forms of explosives: Just throw it and it explodes.^Ceramic casings however are brittle and don't restrict the blast much. Bombs made from these will have an average explosion radius.

knowledge.mine_ceramic=Ceramic Mine Casing
knowledge.mine_ceramic.desc=Basic Mines
knowledge.mine_ceramic.1=Mines aren't as useful as your conventional bomb but still have their place. A mine will explode when something walks near it.^Ceramic cases are brittle and unstable, this means their both sensitive and don't restrict blasts much. Ceramic mines have an average explosion radius.

knowledge.bomb_iron=Iron Bomb Casing
knowledge.bomb_iron.desc=Compacted Blasts
knowledge.bomb_iron.1=It normally would be wise to make a bomb easy to detonate... But why not let it build up some pressure?^Iron casings take a bit more force to break. This means when they do detonate the explosion(though smaller) has a bit more force behind it.

knowledge.mine_iron=Iron Mine Casing
knowledge.mine_iron.desc=Compacted Blasts
knowledge.mine_iron.1=Ceramic casings may bit too sensitive. Iron bomb casings not only allow the blast to build more pressure, but their solid construction makes them harder to trigger, reducing their range but increasing their damage.

knowledge.bomb_obsidian=Obsidian Bomb Casing
knowledge.bomb_obsidian.desc=Sealing in the freshness

knowledge.bomb_obsidian.1=This set of bomb schematics appears to consist of a casing made from obsidian. This casing though hard is designed with fracture points for a more controlled explosion. These would yield high damage over smaller range.

knowledge.mine_obsidian=Obsidian Mine Casing
knowledge.mine_obsidian.desc=Sealing in the freshness

knowledge.mine_obsidian.1=This is a dwarven design of a mine casing. The design incorporates a hard obsidian casing with fracture points in particular areas. The explosion dealt from this would yield large damage over a smaller area.

knowledge.bomb_crystal=Crystal Bomb Casing
knowledge.bomb_crystal.desc=Stylish

knowledge.bomb_crystal.1=Reducing the blast radius to focus more on damage seems decent, but why not increase the blast radius?^Glass casings have no resistance meaning all the power spreads as far as possible.^And add some diamond into the mix so the shards cause more damage anyway!

knowledge.mine_crystal=Crystal Mine Casing
knowledge.mine_crystal.desc=Stylish
knowledge.mine_crystal.1=A delicate glass mine. This can be set off real easy with a large explosion.^Not only that but adding diamond shards into the workings of the case just makes it hurt all the more (and by that I mean the person who stands on it, not the fact it cost you a diamond to make).

knowledge.bomb_fuse=Bomb Fuses
knowledge.bomb_fuse.desc=Timed destruction
knowledge.bomb_fuse.1=What's a bomb without a fuse? A massively blown up hand! Fuses are a vital part of any explosive devices, even mines use them to some extent.^The fuse you create determines how long until the device explodes.
knowledge.bomb_fuse.2=You can also make an extended fuse. With this: bombs can be thrown much farther before exploding. Not much use on mines though...

knowledge.sticky_bomb=Sticky Bombs
knowledge.sticky_bomb.desc=Catch this!
knowledge.sticky_bomb.1=Sticky bombs- as the name might suggest, are bombs that are sticky. And with this amazing trait: will attach themselves to whatever poor sod gets in its way.^So what you have here is a bomb that does a lot of damage sticking to someone! Which never stops being funny.
knowledge.sticky_bomb.2=To create these: Leave(or put) a bomb in the output slot and right-click the block with a slime ball. A single slimeball can coat a stack of any size.

# Use of Cogworks

knowledge.cogwork_armour=Cogwork Suit
knowledge.cogwork_armour.desc=Power Armor

knowledge.cogwork_armour.1=This appears to be a real discovery, and seems to highlight why dwarven ruins had particularly large halls. These are schematics for an advanced set of gears which can replicate human movement into a heavy exoskeleton. What this reveals is a massive suit of armour capable of making the wearer nearly invulnerable to damage.^Cogwork armour is the pinnacle of dwarven engineering and capable of carrying huge amounts of weight. The only downside however is powering the suit, as it requires pure burning fuel and a lot of it.

knowledge.cogwork_armour.2=Though no actual suits have been found in ruins, the assembly systems remain in-tact and they appear to be more than capable of fitting a suit to something more human sized.

knowledge.cogwork_armour.station.1=$hCrafting Station$r^A crafting station is necessary for any construction or modification to take place. Cogwork crafting stations are made from a frame and pulley system. To start off, built three posts 4 blocks tall with a single one in the middle-top.
# Example
knowledge.cogwork_station=Crafting Station
knowledge.cogwork_armour.station.2=With the frame set up, you need to craft the pulley, when this is made, right-click the top block of the frame to install it. Ensure you have the frame in the right place, there's no way to return the pulley after installation.
# Pulley Recipe
knowledge.cogwork_armour.crafting=To craft cogwork armour: you need the three blocks (Helmet, Chest and Legs). Stack these on top of each other inside the frame. Then right-click the chest with a spanner.
# Piece Recipes
knowledge.cogwork_armour.armour=$hPlating$r^To add plating, you need to craft a plating item. Each set of plates cost a lot of ingots, and is recommended to use simple materials like steel. These can be installed by right-clicking a suit in a frame. You also need 16 bolts, which will be consumed before plating can be added. plating can easily be removed with a spanner.
# Armour Recipe
knowledge.cogwork_armour.fuel=$hRefueling$r^Cogwork armour only takes refined fuels (coke or magma cream). Right-click the suit to add fuel.^The heavier the armour on the suit, the faster fuel decays.
knowledge.cogwork_armour.advantage=$hAdvantages$r^An unarmoured suit can give immunity to smoke, remove fall damage, increase attack damage and eliminate stamina decay.
knowledge.cogwork_armour.advantage.2=When fitted with plating: the suit is sealed, you will gain a huge armour bonus and be able to breathe underwater. The suit is also able to remove poison/wither damage and make the wearer immune to fire.
knowledge.cogwork_armour.advantage.3=The armour can still take damage from fire depending on its melting point, higher durability tiers make the armour last longer as well, plating must be removed at a cogwork station for repair.
knowledge.cogwork_armour.disadvantage=When wearing cogwork, you cannot jump, but are able to walk up single-block steps, your movement is also much slower and you are unable to sneak.
knowledge.cogwork_armour.disadvantage.2=Explosions can also damage the armour more than other forms of damage, as well as stun you for a second.
knowledge.cogwork_armour.removal=Although plating is removed when the suit is broken, the framework remains in tact, an empty, unarmoured suit can be broken by hitting it with a spanner, it may also be destroyed if left in fire or lava when plating is broken.

knowledge.composite_alloy=Composite Alloy
knowledge.composite_alloy.desc=Powerful all-rounder

knowledge.composite_alloy.1=So far, most alloys have simply been a matter of mixing them together in a pot. This dwarven design of alloy appears to be different, layering multiple materials together into a plate. Although not as efficient at making tools, the applications for armour would be very efficient, although heavy.^It is obvious this particular alloy was designed to be used with the cogwork armour.

knowledge.refined_planks=Refined Planks
knowledge.refined_planks.desc=Structurally stable
knowledge.refined_planks.1=Refined planks are both strong and resistant to weathering and should prove a decent building material. By nailing some of these together, you can make a block for building. This block cannot be taken apart.^You can also make this out of normal planks.

knowledge.construction_parts=Construction Parts
knowledge.construction_parts.desc=Prepared Woods
knowledge.construction_parts.1=Wood must be cut and shaped in many ways before being workable, here are a few shapes and sizes required for construction.^A lot of timber goes in to creating proper furnishings, as well as metal for fittings and nails.

knowledge.reinforced_stone=Reinforced Stone
knowledge.reinforced_stone.desc=Heavy Duty
knowledge.reinforced_stone.1=Stone is a useful material being strong, non-flammable and resists explosions. You can however, increase the capabilities of stone by melting some obsidian and kaolinite with it.^You will not need an ingot mould to retrieve this from the crucible.

knowledge.clay_wall=Clay Panel
knowledge.clay_wall.desc=Decorative Walls
knowledge.clay_wall.1=These walls are mainly for decorative purposes. Excellent for 2-story buildings and lining rooftops.

knowledge.glass=Glass Blocks
knowledge.glass.desc=Decorative Windows
knowledge.glass.1=Glass is decorative, but extremely fragile. Putting a frame around glass not only improves its strength, but allows it to be picked up safely without ruining its shape.

knowledge.brickworks=Basic Brickworks
knowledge.brickworks.desc=Expanded stone
knowledge.brickworks.1=There's more than one way to build with stone. Dirt and stone can make bricks and roads.

knowledge.bars=Metal Bars
knowledge.bars.desc=Strong Fencing
knowledge.bars.1=These bars are great for letting light in while remaining strong. Bars can be made out of common materials (not rare or exotic though).^It however is possible to make dragonforge bars that burn what touches it.

knowledge.thatch=Thatch
knowledge.thatch.desc=Soft Roofing
knowledge.thatch.1=Simple roofing made from grass. These go well with mud bricks and are easy to make.

knowledge.paint_brush=Paint Brush
knowledge.paint_brush.desc=Spreading finish
knowledge.paint_brush.1=It has come to your attention the obvious fact that spreading oil with your hands is just messy. You need a paint brush.^Paint brushes can refine planks much more efficiently and can be used to apply oil to pre-existing plank blocks.
knowledge.paint_brush.2=$hPainting In-World$r^To save the trouble of going to the workbench every time, you can also paint some blocks in-game, So long as you have plant oil in your inventory, right-click blocks such as Nailed Planks to turn it into refined blocks.

knowledge.decorated_stone=Decorated Stone
knowledge.decorated_stone.desc=Metal Trimming
knowledge.decorated_stone.1=Stone can look bland in large quantities, so you've learnt to trim reinforced stone with metals, adding just a little bit of style to your walls.

knowledge.tool_rack=Tool Rack
knowledge.tool_rack.desc=Store your hardware
knowledge.tool_rack.1=There are a lot of tools that may be needed and only so much space to hold them. Tool racks can be used to place items for easy access.^Right-click the block to place or with empty hands to remove tools.^Heavy weapons need at second rack below to fit, and polearms need an additional rack above.
knowledge.tool_rack.rules=*Heavy weapons require a rack below them.^*Polearms require above and below.^*Full-size crossbows count as heavy weapons.^*Crossbows cannot be placed on edge hooks.

knowledge.bed_roll=Bedroll
knowledge.bed_roll.desc=Sleeping out
knowledge.bed_roll.1=When in the wilderness, you sometimes need to sleep where you'd rather not live. Bedrolls allow sleeping without resetting spawn points.

knowledge.food_box=Provisions Box
knowledge.food_box.desc=Food storage
knowledge.food_box.1=Food and medical supplies should be kept on easy access for when its needed. Provision boxes allow food items and bandages to be stored multiple times their own stack size. Right-clicking can place an item and retrieve with empty hands.

knowledge.ammo_box=Ammo Box
knowledge.ammo_box.desc=Munitions storage
knowledge.ammo_box.1=Ammunition is always needed and must be kept easy-access for when it's used. Ammunition boxes allow up to 8x the normal stack size of arrows, bolts, bombs or mines to be kept in a crate. Right-click to place items, empty hands retrieves a stack, clicking an appropriate firearm (bow/crossbow) can load the weapon.
knowledge.ammo_box.2=Upon breaking, the stored items are still kept, ready for placement allowing easy carrying of storage.

knowledge.big_box=Storage Crate
knowledge.big_box.desc=Store anything
knowledge.big_box.1=For either storage or shipment of bulk material, these crates allow anything to be placed inside them, these can hold one item at a multiple of their stack size.

knowledge.generic_meat=Generic Meat
knowledge.generic_meat.desc=Good for any recipe
knowledge.generic_meat.1=There's a lot of meat out there. But sometimes, it shouldn't matter. Generic meat is made from a variety of meat types cooked or uncooked, used for easier storage and use in recipes.^You're better off preparing raw meat, as some can give additional output.

knowledge.wild_meat=Wild Meat
knowledge.wild_meat.desc=You Monster!
knowledge.wild_meat.1=You may have noticed that those noble horses and cute wolves are made of meat too...^You should at least cook these meats so you can't tell what they are.

knowledge.stew=Stew
knowledge.stew.desc=Kind of bland
knowledge.stew.1=You're no cook... not yet anyway. Stew is the food of the novice. Just throw some diced meat in a bowl and call it a meal! Stew can be made from generic meat.

knowledge.jerky=Jerky
knowledge.jerky.desc=For the traveller
knowledge.jerky.1=Jerky may not be the tastiest or warmest of food, but it has its own purpose. This is one of the few stackable foods and has a decent stamina bonus across the board. Good for mining trips and explorations.

knowledge.sausage=Sausage
knowledge.sausage.desc=Sealed meats
knowledge.sausage.1=When rationing meats into jerky, you tend to sacrifice pleasure of consumption for practicality. No more chewy, salty, jerky! Sausages keep meat fresh in a casing made from... uh... entrails...

knowledge.sandwitch=Sandwiches
knowledge.sandwitch.desc=Simple
knowledge.sandwitch.1=A piece of meat in between some bread, how could you not have known this before! Sandwiches though not stackable can be eaten twice.

knowledge.sandwitch_big=Big Sandwich
knowledge.sandwitch_big.desc=Extra long
knowledge.sandwitch_big.1=You can now make sandwiches out of whole loafs of bread with more filling. These have 4 uses.

knowledge.meatpie=Meat Pie
knowledge.meatpie.desc=Hearty and filling
knowledge.meatpie.1=What's better than putting meat in a pie? nothing! Meat pies are filling and give a high stamina buff. Place the pie block and right-click with a knife to cut a slice.

knowledge.shepard_pie=Shepards Pie
knowledge.shepard_pie.desc=You can eat it if you're not a shepard too
knowledge.shepard_pie.1=Even better than a meat pie, now with potato! And a bigger stamina buff. Place the pie block and right-click with a knife to cut a slice.

knowledge.salt=Salt
knowledge.salt.desc=A little extra
knowledge.salt.1=Salt is an additive for cooking sometimes used. To create salt, first gather some salt water.^Salt water is gathered by right-clicking a a Clay Pot on water that is directly above sand(such as a beach). Then cook this to produce salt.
knowledge.salt.2=Clay pots are able to handle constant carrying and dying of salt water without decaying. These are used to gather salt water.^Salt water is detemined by being directly above sand OR being a beach/ocean biome.

knowledge.jug=Jug
knowledge.jug.desc=Liquid Storage
knowledge.jug.1=Food can be picky with quantities, due to this, and the fact you can't carry liquids, jugs will be used. Jugs can store milk, water and oil.
knowledge.jug.2=Water can be gathered similar to buckets through right-click, but can also be converted from buckets. Milk cannot be obtained directly from cows.

knowledge.bread=Bread And Pastry
knowledge.bread.desc=Grainy
knowledge.bread.1=Bread may be a boring meal alone, but can be used in conjunction with other, more interesting food.^Flour however can be used for making all kinds of pastries.
knowledge.bread.other=Some recipes (such as bread as mentioned before) have alternate recipes, though are still inferior to MF food.

knowledge.oats=Oats
knowledge.oats.desc=Wholesome and basic
knowledge.oats.1=Not all meals are fancy multi-food mixtures. Keep it simple with this mixture of natural grains.

knowledge.icing=Sugar
knowledge.icing.desc=Sugary Goodness
knowledge.icing.1=There's nothing wrong with a little sugar... unless it's kept in someones pocket for three days... You can now use pots for proper sugar storage and grind cane directly into them. It is possible to put pocket-sugar in these too.
knowledge.icing.2=Some food just isn't quite complete without icing. Icing is used in many sweet food recipes.

knowledge.sweetroll=Sweetroll
knowledge.sweetroll.desc=Let me guess...
knowledge.sweetroll.1=Sweetrolls are a sugary treat anyone can enjoy. Eating one of these, though not filling restores stamina and gives stamina regen. Sweetrolls can be eaten twice.

knowledge.eclair=Eclair
knowledge.eclair.desc=Fancy
knowledge.eclair.1=Now you're just showing off... But some of us just can't do without the fanciest of sweeties...^These little heart attacks in a pastry can be eaten 4 times.

knowledge.cake=Cake
knowledge.cake.desc=Made the RIGHT way!
knowledge.cake.1=A big cake. Restores stamina and gives stamina regen. Place the cake block and right-click with a knife to cut a slice.

knowledge.carrot_cake=Carrot Cake
knowledge.carrot_cake.desc=Kind of healthy...
knowledge.carrot_cake.1=Standard cake with carrots in it. Restores stamina and gives stamina regen that lasts longer. Place the cake block and right-click with a knife to cut a slice.

knowledge.chocolate_cake=Chocolate Cake
knowledge.chocolate_cake.desc=Decedant
knowledge.chocolate_cake.1=Dense with chocolate. Restores stamina and gives a faster stamina regen. Place the cake block and right-click with a knife to cut a slice.

knowledge.black_forest_cake=Black-Forest Cake
knowledge.black_forest_cake.desc=Fancy
knowledge.black_forest_cake.1=Layers of chocolate and fresh berries. Restores large stamina and gives fast stamina regen for longer. Place the cake block and right-click with a knife to cut a slice.

knowledge.berry_pie=Berry Pie
knowledge.berry_pie.desc=Simple dessert
knowledge.berry_pie.1=Berries are nice and juicy, but you may want to do something with them. Berry pies restore some stamina and give a stamina regen buff for a short time. Place the pie block and right-click with a knife to cut a slice.

knowledge.apple_pie=Apple Pie
knowledge.apple_pie.desc=Simple dessert
knowledge.apple_pie.1=Similar to berry pies only with slightly better effects. Apple pies restore some stamina and give a stamina regen buff for a short time. Place the pie block and right-click with a knife to cut a slice.

knowledge.cheese=Cheese
knowledge.cheese.desc=Solid dairy
knowledge.cheese.1=Cheese is made from refining milk. It has use in some recipes. Place the cheese block and right-click with a knife to cut a slice.

knowledge.cheese_roll=Cheese Roll
knowledge.cheese_roll.desc=Easy snack
knowledge.cheese_roll.1=Cheese goes well with bread. Put some cheese in a roll to give it some flavour.

knowledge.kitchen_bench=Kitchen Bench
knowledge.kitchen_bench.desc=Kitchen crafting
knowledge.kitchen_bench.1=The Kitchen Bench is a dedicated space for mixing, cutting, rolling, and prepping your foodstuffs.^It is essential for any aspiring chef, so make sure to make this in your favorite stone-top style!^It is used similarly to the Carpenter Bench, simply set your recipe up and use tools, like knives, spoons, and your fists, to craft your culinary masterpieces.
knowledge.kitchen_bench.2=The Kitchen Bench is going to get filthy with all that dough rolling and meat chopping!^If you're not careful, the level of mess will make it impossible to keep cooking.^Make sure to clean it up with a wash cloth! Simply repeatedly right click your kitchen bench with the wash cloth to clean it, and clean off your wash cloth by repeatedly right clicking water.

knowledge.firepit=Firepit and Stoves
knowledge.firepit.desc=Basic cooking
knowledge.firepit.1=The firepit is the easiest way to steadily provide flame for cooking and lighting purposes and can be made with litte cost.^To create a fire, place a firepit block and right-click timber items to add fuel, then right-click with a firestarter.
knowledge.firepit.2=Stovetops are used to cook food, these must be placed on top of a heat source (firepit or forge).^Right-click raw food ontop of the plate to place it, and wait until it cooks, try not to overcook it. Some recipes such as cakes require more steady temperature. use of a forge and coal dust can give a proper temperature for these purposes.
knowledge.firepit.3=Ovens are able to cook baked items such as bread as well as that of a normal cooktop.^Ovens are also required to make ceramics out of clay making them useful in cooking as well as other crafts, provided the temperature is very high, such as coal in a forge.
knowledge.firepit.4=When cooking: use a firepit for basic cooking, a forge with coal dust for advanced cooking, and a forge with standard fuel (like coal) for ceramics.

knowledge.cooking_utensils=Cooking Utensils
knowledge.cooking_utensils.desc=Tools for cooking
knowledge.cooking_utensils.1=For cooking, there's a variety of non-edible items that go into cooking. These include mostly trays and tins. For tools: see the basic section.

knowledge.bandage=Bandages
knowledge.bandage.desc=First Aid
knowledge.bandage.1=There's times when someone gets badly injured, now simply asking them to shut up and eat a piece of chicken gets old fast. Bandages can restore health when used, hold right-click to use.^They don't work when you're starving, drowning, burning, poisoned, and... a lot of stuff really.

knowledge.bandage_advanced=Strong Bandages
knowledge.bandage_advanced.desc=Tough Stuff
knowledge.bandage_advanced.1=These advanced leather bandages heal much more damage. They can be costly however.

# MASTERY TEXT
knowledge.title=
knowledge.title.desc=
knowledge.title.1=

knowledge.fitness=Fitness
knowledge.fitness.desc=Kept in shape
knowledge.fitness.1=Your biggest foe in battle is your energy (well apart from the actual enemy).^Stamina decays 25%% Slower.

knowledge.toughness=Toughness
knowledge.toughness.desc=Take it!
knowledge.toughness.1=Your constant exposure to battle has granted you a higher resistance to the elements.^Damage from all sources is reduced by 10%%.

knowledge.armour_pro=Armor Proficiency
knowledge.armour_pro.desc=Feel the weight
knowledge.armour_pro.1=After all this time, your core has become stronger.^Armor penalty to stamina cost is halved.

knowledge.parry_pro=Parry Tactics
knowledge.parry_pro.desc=Control your movement
knowledge.parry_pro.1=The position in the battlefield is an important weapon and should be used to your advantage.^Holding shift when parrying allows you to leap towards, and past your opponent. This is useful to slip past their defenses.

knowledge.counter_attack=Counter attack
knowledge.counter_attack.desc=Return strike
knowledge.counter_attack.1=Parrying may protect you but it throws you off balance a bit, however you are experienced enough to use this to your advantage.^Right after parrying you can do an alternate attack that does different damage.
knowledge.counter_attack.2=Swords, Daggers and Katanas do a piercing stab.^Waraxes use their piercing back.^Heavy weapons deal a pummel smash.^Blunt weapons and polearms have no effect.

knowledge.auto_parry=Reflex Parry
knowledge.auto_parry.desc=Ready for the hit
knowledge.auto_parry.1=Your constant use of finesse has granted you some automatic reflexes.^You can parry attacks without blocking (with a reduced arc).

knowledge.scrapper=Scavenger
knowledge.scrapper.desc=Take it all
knowledge.scrapper.1=Your skill in crafting items has allowed you to understand how things come together, and apart..^You now have higher drop rates when salvaging.

knowledge.first_aid=First Aid
knowledge.first_aid.desc=Tend to the wounded
knowledge.first_aid.1=You need to be fast when tending to some injuries and need to be ready for the moment.^Using bandages is significantly faster.

knowledge.doctor=Doctor
knowledge.doctor.desc=Duty to benefit
knowledge.doctor.1=Your constant use of aiding your fellow humans has yielded you experience in medicine.^Bandages heal 50%% more damage.
     */
}
