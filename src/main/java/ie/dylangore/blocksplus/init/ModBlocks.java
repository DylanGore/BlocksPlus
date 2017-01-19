package ie.dylangore.blocksplus.init;

import ie.dylangore.blocksplus.BlocksPlus;
import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.Reference.EnumColors;
import ie.dylangore.blocksplus.blocks.BlockAsphaltRoad;
import ie.dylangore.blocksplus.blocks.BlockHealingStation;
import ie.dylangore.blocksplus.blocks.base.BlockBaseColored;
import ie.dylangore.blocksplus.blocks.base.BlockTileEntity;
import ie.dylangore.blocksplus.blocks.itemblocks.ItemBlockColored;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

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

    public static void init(){

        blockAsphaltRoad = new BlockAsphaltRoad(Material.ROCK, Reference.BlocksPlusBlocks.ASPHALT_ROAD.getName());
        blockHealingStation = new BlockHealingStation(Material.IRON, Reference.BlocksPlusBlocks.HEALING_STATION.getName());
        blockColoredCobblestone = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLOURED_COBBLESTONE.getName(), 1.0F, 1.0F);
        blockColoredStone = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE.getName(), 1.0F, 1.0F);

        registerSimpleItemBlock(blockAsphaltRoad, Reference.BlocksPlusBlocks.ASPHALT_ROAD.getName());
        registerSimpleItemBlock(blockHealingStation, Reference.BlocksPlusBlocks.HEALING_STATION.getName());

        registerColorItemBlock(blockColoredCobblestone, Reference.BlocksPlusBlocks.COLOURED_COBBLESTONE.getName());
        registerColorItemBlock(blockColoredStone, Reference.BlocksPlusBlocks.COLORED_STONE.getName());

        LogHelper.info("Blocks registered!");
    }

    public static void registerSimpleItemBlock(Block block, String registryName){
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(registryName);
        GameRegistry.register(itemBlock);
        GameRegistry.register(block);

        if (block instanceof BlockTileEntity) {
            GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
        }

        BlocksPlus.proxy.registerItemRenderer(itemBlock, 0, registryName);
    }

    private static void registerColorItemBlock(Block block, String registryName){
        ItemBlockColored itemBlock = new ItemBlockColored(block);
        itemBlock.setRegistryName(registryName);
        GameRegistry.register(itemBlock);
        GameRegistry.register(block);

        if (block instanceof BlockTileEntity) {
            GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
        }

        for(int meta = 0; meta < EnumColors.values().length; meta++){
            BlocksPlus.proxy.registerColorItemRenderer(itemBlock, meta, registryName);
        }

    }
}
