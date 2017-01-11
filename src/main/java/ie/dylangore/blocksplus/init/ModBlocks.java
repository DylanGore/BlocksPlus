package ie.dylangore.blocksplus.init;

import ie.dylangore.blocksplus.BlocksPlus;
import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.blocks.BlockAsphaltRoad;
import ie.dylangore.blocksplus.blocks.base.BlockBase;
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

    public static void init(){

        blockAsphaltRoad = new BlockAsphaltRoad(Material.ROCK, Reference.BlocksPlusBlocks.ASPHALT_ROAD.getName());
        registerSimpleItemBlock(blockAsphaltRoad, Reference.BlocksPlusBlocks.ASPHALT_ROAD.getName());

        LogHelper.info("Blocks registered!");
    }

    public static void registerSimpleItemBlock(Block block, String registryName){
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(registryName);
        GameRegistry.register(itemBlock);
        GameRegistry.register(block);

        BlocksPlus.proxy.registerItemRenderer(itemBlock, 0, registryName);
    }
}
