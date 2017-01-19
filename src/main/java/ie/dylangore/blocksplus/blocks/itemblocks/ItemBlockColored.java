package ie.dylangore.blocksplus.blocks.itemblocks;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.Reference.EnumColors;
import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Project: BlocksPlus
 * File: ItemBlockColored
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 18 January 2017
 */
public class ItemBlockColored extends ItemBlock {
    public ItemBlockColored(Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStackIn) {
        return super.getUnlocalizedName() + "." + EnumColors.byMetadata(itemStackIn.getMetadata()).getName();
    }
}
