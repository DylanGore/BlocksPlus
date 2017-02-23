package ie.dylangore.blocksplus.blocks.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

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

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack itemStackIn) {
        return super.getUnlocalizedName() + "." + EnumDyeColor.byMetadata(itemStackIn.getMetadata()).getName();
    }
}
