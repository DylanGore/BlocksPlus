/*
 * Project: BlocksPlus
 * File: BPItem.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.items;

import info.dylangore.blocksplus.BlocksPlus;
import info.dylangore.blocksplus.creativetab.TabBlocksPlus;
import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BPItem extends Item {

    public String texName;

    public BPItem(String name, String textureName, int stackSize){
        this.setUnlocalizedName(name);
        this.setTextureName(Reference.ID + ":" + textureName);
        this.setCreativeTab(TabBlocksPlus.tabBlocksPlus);
        this.setMaxStackSize(stackSize);
    }
}
