/*
 * Project: BlocksPlus
 * File: TabBlocksPlus.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.creativetab;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.init.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TabBlocksPlus extends ItemGroup {
    public TabBlocksPlus() {
        super(Reference.ID);
        setBackgroundImageName("item_search.png");
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.blockAsphaltRoad);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }


}
