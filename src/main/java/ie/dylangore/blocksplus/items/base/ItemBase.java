package ie.dylangore.blocksplus.items.base;

import ie.dylangore.blocksplus.BlocksPlus;
import net.minecraft.item.Item;

/**
 * Project: BlocksPlus
 * File: ItemBase
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */
public class ItemBase extends Item {

    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(BlocksPlus.creativeTab);
    }

    public void registerItemModel() {
        BlocksPlus.proxy.registerItemRenderer(this, 0, name);
    }

}
