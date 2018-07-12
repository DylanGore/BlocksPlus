/*
 * Project: BlocksPlus
 * File: ModItems.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.init;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems {

//    public static ItemBPDye itemDye;

    public static void preInit() {

//        itemDye = new ItemBPDye(Reference.BlocksPlusItems.DYE.getName());
//        registerItems();
    }

    public static void init(){
//        registerColorOreDict(itemDye, "dye", true);
    }

    private static void registerItems() {
//        registerItem(itemDye);
        LogHelper.info("Items registered!");
    }

    private static void registerItem(Item item) {
        ModRegistry.addItem(item);
   }

    @SuppressWarnings("SameParameterValue")
    private static void registerColorOreDict(Item item, String oreDictName, boolean isWildcard) {

        OreDictionary.registerOre(oreDictName, new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE));
        for (int meta = 0; meta < EnumDyeColor.values().length; meta++) {
            String colorName = oreDictName + Reference.getColorNameFromMeta(meta, true);
            OreDictionary.registerOre(colorName, new ItemStack(item, 1, meta));
            LogHelper.debug("Adding " + item.getRegistryName() + " to ore dictionary under " + colorName);
        }
    }


}
