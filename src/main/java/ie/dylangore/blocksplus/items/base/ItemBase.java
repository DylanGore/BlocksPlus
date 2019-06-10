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

    public ItemBase(Properties properties, String name) {
        super(properties);
        this.name = name;
        setRegistryName(name);
        //TODO creative tab
    }

}
