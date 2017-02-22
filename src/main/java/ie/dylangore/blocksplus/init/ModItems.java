package ie.dylangore.blocksplus.init;

import ie.dylangore.blocksplus.BlocksPlus;
import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.items.ItemBPDye;
import ie.dylangore.blocksplus.items.base.ItemBase;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Project: BlocksPlus
 * File: ModItems
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class ModItems {

    public static ItemBPDye itemDye;

    public static void init(){

        itemDye = new ItemBPDye(Reference.BlocksPlusItems.DYE.getName());
        registerItems();

        registerColorOreDict(itemDye, "dye", true);
        LogHelper.info("Items registered!");
    }

    private static void registerItems(){
        registerColorItem(itemDye, Reference.BlocksPlusItems.DYE.getName());
    }

    public static void registerItem(Item item){
        GameRegistry.register(item);
        if (item instanceof ItemBase) {
            ((ItemBase)item).registerItemModel();
            LogHelper.debug("Registering item model for " + item.getRegistryName() + " as instance of ItemBase");
        }
    }

    private static void registerColorItem(Item item, String name){
        GameRegistry.register(item);
        for(int meta = 0; meta < Reference.EnumColors.values().length; meta++){
            BlocksPlus.proxy.registerColorItemRenderer(item, meta, name);
            LogHelper.debug("Registering item model for " + item.getRegistryName() + " meta " + meta + " as instance of ItemBase");
        }
    }

    private static void registerColorOreDict(Item item, String oreDictName, boolean isWildcard){

        OreDictionary.registerOre(oreDictName, new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE));
        for(int meta = 0; meta < Reference.EnumColors.values().length; meta++){
            String colorName = oreDictName + Reference.EnumColors.byMetadata(meta).getCapitalName();
            OreDictionary.registerOre(colorName, new ItemStack(item, 1, meta));
            LogHelper.debug("Adding " + item.getRegistryName() + " to ore dictionary under " + colorName);
        }
    }


}
