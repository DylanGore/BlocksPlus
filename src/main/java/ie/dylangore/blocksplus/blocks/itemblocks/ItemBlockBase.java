/*
 * Project: BlocksPlus
 * File: ItemBlockBase.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.blocks.itemblocks;

import ie.dylangore.blocksplus.BlocksPlus;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockBase extends ItemBlock {
    public ItemBlockBase(Block blockIn, Properties builder) {
        super(blockIn, builder.group(BlocksPlus.creativeTab));
    }
}
