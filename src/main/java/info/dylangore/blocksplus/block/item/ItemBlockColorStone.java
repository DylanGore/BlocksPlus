/*
 * Project: BlocksPlus
 * File: ItemBlockColorStone.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.block.item;

import info.dylangore.blocksplus.reference.BlockReference;
import info.dylangore.blocksplus.init.BPBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockColorStone extends ItemBlock{

	public static String unlocName = BPBlocks.colorStone.getUnlocalizedName();

	public ItemBlockColorStone(Block block) {
		super(block);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack stack)
    {
          return unlocName + "_" + BlockReference.colorBlockNames[stack.getItemDamage()];
    }
   
    public int getMetadata(int meta)
    {
          return meta;
    }
}
