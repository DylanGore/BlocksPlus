/*
 * Project: BlocksPlus
 * File: TabBlocksPlus.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.creativetab;

import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import info.dylangore.blocksplus.init.BPBlocks;

public class TabBlocksPlus{
    public static final CreativeTabs tabBlocksPlus = new CreativeTabs(Reference.ID.toLowerCase()) {

        public ItemStack getIconItemStack() {
            return new ItemStack(BPBlocks.colorStone, 1, 3);
        }

        @Override
        public Item getTabIconItem() {
            return null;
        }

        public String getTranslatedTabLabel() {
            return "Blocks Plus";
        }
    };
}
