/*
 * Project: BlocksPlus
 * File: ItemBlockToggle.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 11/08/14 14:45
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.block.item;

import info.dylangore.blocksplus.init.BPBlocks;
import info.dylangore.blocksplus.reference.BlockReference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockToggle extends ItemBlock{

	public static String unlocName = BPBlocks.toggleBlock.getUnlocalizedName();

	public ItemBlockToggle(Block block) {
		super(block);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack stack)
    {
        String[] names = {"", "_off"};
        return unlocName + names[stack.getItemDamage()];
    }
   
    public int getMetadata(int meta)
    {
          return meta;
    }
}
