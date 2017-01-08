package ie.dylangore.blocksplus.init;

import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Project: BlocksPlus
 * File: ModBlocks
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class ModBlocks {

    public static void init(){
        LogHelper.info("Blocks registered!");
    }

    public static void registerBlock(ItemBlock itemBlock, Block block, String registryName){
        itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(registryName);
        GameRegistry.register(itemBlock);
        GameRegistry.register(block);
    }
}
