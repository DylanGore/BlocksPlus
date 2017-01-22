package ie.dylangore.blocksplus.creativetab;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Project: BlocksPlus
 * File: TabBlocksPlus
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class TabBlocksPlus extends CreativeTabs {
    public TabBlocksPlus() {
        super(Reference.ID);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public Item getTabIconItem() {
        return new ItemStack(ModBlocks.blockAsphaltRoad, 1, 0).getItem();
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }


}
