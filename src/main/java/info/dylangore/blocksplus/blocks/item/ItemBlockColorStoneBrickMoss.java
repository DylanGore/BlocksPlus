package info.dylangore.blocksplus.blocks.item;

import info.dylangore.blocksplus.lib.BlockInfo;
import info.dylangore.blocksplus.core.BPBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockColorStoneBrickMoss extends ItemBlock{

	public static String unlocName = BPBlocks.colorStoneBricksMoss.getUnlocalizedName();

	public ItemBlockColorStoneBrickMoss(Block block) {
		super(block);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack stack)
    {
          return unlocName + "_" + BlockInfo.colorBlockNames[stack.getItemDamage()];
    }
   
    public int getMetadata(int meta)
    {
          return meta;
    }
}
