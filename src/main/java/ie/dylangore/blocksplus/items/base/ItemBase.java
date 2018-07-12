/*
 * Project: BlocksPlus
 * File: ItemBase.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.items.base;

import ie.dylangore.blocksplus.BlocksPlus;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    protected String name;

    ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(BlocksPlus.creativeTab);
    }

}
