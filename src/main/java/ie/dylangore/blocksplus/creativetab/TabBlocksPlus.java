package ie.dylangore.blocksplus.creativetab;

import ie.dylangore.blocksplus.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
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
    public ItemStack getTabIconItem() {
        return new ItemStack(Blocks.STONE, 1, 0);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
