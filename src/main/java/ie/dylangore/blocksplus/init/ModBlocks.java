/*
 * Project: BlocksPlus
 * File: ModBlocks.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.init;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.blocks.BlockAsphaltRoad;
import ie.dylangore.blocksplus.blocks.BlockColoredSand;
import ie.dylangore.blocksplus.blocks.BlockRimmedGlass;
import ie.dylangore.blocksplus.blocks.base.BlockBaseColored;
import ie.dylangore.blocksplus.blocks.itemblocks.ItemBlockColored;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {

    public static BlockAsphaltRoad blockAsphaltRoad;
    public static BlockBaseColored blockColoredCobblestone;
    public static BlockBaseColored blockColoredStone;
    public static BlockBaseColored blockColoredStoneBricks;
    public static BlockBaseColored blockColoredStoneBricksChiseled;
    public static BlockBaseColored blockColoredStoneBricksCracked;
    public static BlockColoredSand blockColoredSand;
    public static BlockRimmedGlass blockRimmedGlass;
    public static BlockRimmedGlass blockRimmedGlowingGlass;
//    public static BlockConnectedGlass blockGlowingGlass;

    public static void preInit(){

        blockAsphaltRoad = new BlockAsphaltRoad(Material.ROCK, Reference.BlocksPlusBlocks.ASPHALT_ROAD.getName(), 1.5F, 1.0F);
        blockColoredCobblestone = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLOURED_COBBLESTONE.getName(), 2.0F, 1.0F);
        blockColoredStone = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE.getName(), 1.5F, 1.0F);
        blockColoredStoneBricks = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS.getName(), 1.5F, 1.0F);
        blockColoredStoneBricksChiseled = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CHISELED.getName(), 1.5F, 1.0F);
        blockColoredStoneBricksCracked = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CRACKED.getName(), 1.5F, 1.0F);
        blockRimmedGlass = new BlockRimmedGlass(Material.GLASS, Reference.BlocksPlusBlocks.RIMMED_GLASS.getName(), 1.0F, 1.0F);
        blockRimmedGlowingGlass = new BlockRimmedGlass(Material.GLASS, Reference.BlocksPlusBlocks.RIMMED_GLOWING_GLASS.getName(), 1.0F, 1.0F, 1.0F);
//        blockGlowingGlass = new BlockConnectedGlass(Material.GLASS, Reference.BlocksPlusBlocks.GLOWING_GLASS.getName(), 1.0F, 1.0F);
        blockColoredSand = new BlockColoredSand(Reference.BlocksPlusBlocks.COLORED_SAND.getName(), 0.5F, 1.0F);

        registerBlocks();
    }

    public static void init(){
        registerOreDict(blockColoredCobblestone, "cobblestone", true);
        registerOreDict(blockColoredStone, "stone", true);
        registerOreDict(blockRimmedGlass, "blockGlass", true);
        registerOreDict(blockColoredSand, "sand", true);
        registerOreDict(blockColoredSand, "coloredSand", true);


        registerOreDict(blockRimmedGlass, "blockRimmedGlass", true);
        registerOreDict(blockRimmedGlowingGlass, "blockRimmedGlowingGlass", true);

        ModRecipes.init();
    }

    private static void registerBlocks() {
        registerSimpleItemBlock(blockAsphaltRoad, Reference.BlocksPlusBlocks.ASPHALT_ROAD.getName());
//        registerSimpleItemBlock(blockGlowingGlass, Reference.BlocksPlusBlocks.GLOWING_GLASS.getName());

        registerColorItemBlock(blockColoredCobblestone, Reference.BlocksPlusBlocks.COLOURED_COBBLESTONE.getName());
        registerColorItemBlock(blockColoredStone, Reference.BlocksPlusBlocks.COLORED_STONE.getName());
        registerColorItemBlock(blockColoredStoneBricks, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS.getName());
        registerColorItemBlock(blockColoredStoneBricksChiseled, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CHISELED.getName());
        registerColorItemBlock(blockColoredStoneBricksCracked, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CRACKED.getName());
        registerColorItemBlock(blockRimmedGlass, Reference.BlocksPlusBlocks.RIMMED_GLASS.getName());
        registerColorItemBlock(blockRimmedGlowingGlass, Reference.BlocksPlusBlocks.RIMMED_GLOWING_GLASS.getName());
        registerColorItemBlock(blockColoredSand, Reference.BlocksPlusBlocks.COLORED_SAND.getName());

        LogHelper.info("Blocks registered!");
    }

    private static void registerSimpleItemBlock(Block block, String registryName) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(registryName);
        ModRegistry.addItem(itemBlock);
        ModRegistry.addBlock(block);
    }

    private static void registerColorItemBlock(Block block, String registryName) {
        ItemBlockColored itemBlock = new ItemBlockColored(block);
        itemBlock.setRegistryName(registryName);
        ModRegistry.addItem(itemBlock);
        ModRegistry.addBlock(block);
    }

    @SuppressWarnings("SameParameterValue")
    private static void registerOreDict(Block block, String oreDictName, boolean isWildcard) {
        if (isWildcard) {
            OreDictionary.registerOre(oreDictName, new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
        } else {
            OreDictionary.registerOre(oreDictName, block);
        }
    }
}
