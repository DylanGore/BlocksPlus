/*
 * Project: BlocksPlus
 * File: TabBlocksPlus.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.creativetab;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabBlocksPlus extends CreativeTabs {
    public TabBlocksPlus() {
        super(Reference.ID);
        setBackgroundImageName("item_search.png");
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.blockAsphaltRoad, 1, 0);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }


}
