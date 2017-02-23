package ie.dylangore.blocksplus.items.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

/**
 * Project: BlocksPlus
 * File: ItemBaseColored
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 22 February 2017
 */

public class ItemBaseColored extends ItemBase {
    public ItemBaseColored(String name) {
        super(name);
        setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for (int metadata = 0; metadata < EnumDyeColor.values().length; metadata++) {
            subItems.add(new ItemStack(itemIn, 1, metadata));
        }
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stackIn) {
        int meta = stackIn.getMetadata();
        return super.getUnlocalizedName(stackIn) + "." + EnumDyeColor.byMetadata(meta);
    }
}
