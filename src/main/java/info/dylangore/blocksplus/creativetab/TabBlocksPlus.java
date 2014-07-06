/*
 * Project: BlocksPlus
 * File: TabBlocksPlus.java
 * Author: Dylan Gore (http://dylangore.info)
 * Creation Date: 02/07/14 18:13
 * Modified: 02/07/14 18:13
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import info.dylangore.blocksplus.init.BPBlocks;

public class TabBlocksPlus extends CreativeTabs {
	public TabBlocksPlus(int tabID, String tabLabel) {
		super(tabID, tabLabel);
	}
	
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack()
	{
			return new ItemStack(BPBlocks.colorStone,1, 3);
	}

    @Override
    public Item getTabIconItem() {
        return null;
    }

    public String getTranslatedTabLabel(){
		return "Blocks Plus";
	}
}
