/*
 * Project: BlocksPlus
 * File: ItemBlockColorStoneBrick.java
 * Author: Dylan Gore (http://dylangore.info)
 * Creation Date: 02/07/14 18:13
 * Modified: 02/07/14 18:13
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.block.item;

import info.dylangore.blocksplus.reference.BlockReference;
import info.dylangore.blocksplus.init.BPBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockColorStoneBrick extends ItemBlock{

	public static String unlocName = BPBlocks.colorStoneBricks.getUnlocalizedName();

	public ItemBlockColorStoneBrick(Block block) {
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
