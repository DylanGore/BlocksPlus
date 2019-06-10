/*
 * Project: BlocksPlus
 * File: ItemBlockColored.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.blocks.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

//TODO 1.13
public class ItemBlockColored extends ItemBlockBase {
    public ItemBlockColored(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }
//    public ItemBlockColored(Block block) {
//        super(block);
//        this.setMaxDamage(0);
//        this.setHasSubtypes(true);
//    }

//    @Override
//    public int getMetadata(int damage) {
//        return damage;
//    }
//
//    @Nonnull
//    @Override
//    public String getUnlocalizedName(ItemStack itemStackIn) {
//        return super.getUnlocalizedName() + "." + EnumDyeColor.byMetadata(itemStackIn.getMetadata()).getName();
//    }
}
