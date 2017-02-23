package ie.dylangore.blocksplus.init;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.blocks.BlockAsphaltRoad;
import ie.dylangore.blocksplus.blocks.BlockHealingStation;
import ie.dylangore.blocksplus.blocks.base.BlockBaseColored;
import ie.dylangore.blocksplus.blocks.base.BlockTileEntity;
import ie.dylangore.blocksplus.blocks.itemblocks.ItemBlockColored;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Project: BlocksPlus
 * File: ModBlocks
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class ModBlocks {

     public static BlockAsphaltRoad blockAsphaltRoad;
     public static BlockHealingStation blockHealingStation;
     public static BlockBaseColored blockColoredCobblestone;
     public static BlockBaseColored blockColoredStone;
     public static BlockBaseColored blockColoredStoneBricks;
     public static BlockBaseColored blockColoredStoneBricksChiseled;
     public static BlockBaseColored blockColoredStoneBricksCracked;

    public static void init(){

        blockAsphaltRoad = new BlockAsphaltRoad(Material.ROCK, Reference.BlocksPlusBlocks.ASPHALT_ROAD.getName(), 1.5F, 1.0F);
        blockHealingStation = new BlockHealingStation(Material.IRON, Reference.BlocksPlusBlocks.HEALING_STATION.getName(), 1.0F, 1.0F);
        blockColoredCobblestone = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLOURED_COBBLESTONE.getName(), 2.0F, 1.0F);
        blockColoredStone = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE.getName(), 1.5F, 1.0F);
        blockColoredStoneBricks = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS.getName(), 1.5F, 1.0F);
        blockColoredStoneBricksChiseled = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CHISELED.getName(), 1.5F, 1.0F);
        blockColoredStoneBricksCracked = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CRACKED.getName(), 1.5F, 1.0F);

        registerBlocks();
    }

    private static void registerBlocks(){
        registerSimpleItemBlock(blockAsphaltRoad, Reference.BlocksPlusBlocks.ASPHALT_ROAD.getName());
        //registerSimpleItemBlock(blockHealingStation, Reference.BlocksPlusBlocks.HEALING_STATION.getName());

        registerColorItemBlock(blockColoredCobblestone, Reference.BlocksPlusBlocks.COLOURED_COBBLESTONE.getName());
        registerColorItemBlock(blockColoredStone, Reference.BlocksPlusBlocks.COLORED_STONE.getName());
        registerColorItemBlock(blockColoredStoneBricks, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS.getName());
        registerColorItemBlock(blockColoredStoneBricksChiseled, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CHISELED.getName());
        registerColorItemBlock(blockColoredStoneBricksCracked, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CRACKED.getName());

        registerOreDict(blockColoredCobblestone, "cobblestone", true);
        registerOreDict(blockColoredStone, "stone", true);

        LogHelper.info("Blocks registered!");
    }

    private static void registerSimpleItemBlock(Block block, String registryName){
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(registryName);
        GameRegistry.register(itemBlock);
        GameRegistry.register(block);

        if (block instanceof BlockTileEntity) {
            GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
        }
    }

    private static void registerColorItemBlock(Block block, String registryName){
        ItemBlockColored itemBlock = new ItemBlockColored(block);
        itemBlock.setRegistryName(registryName);
        GameRegistry.register(itemBlock);
        GameRegistry.register(block);

        if (block instanceof BlockTileEntity) {
            GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
        }

    }

    private static void registerOreDict(Block block, String oreDictName, boolean isWildcard){
        if(isWildcard){
            OreDictionary.registerOre(oreDictName, new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
        }else{
            OreDictionary.registerOre(oreDictName, block);
        }
    }
}
