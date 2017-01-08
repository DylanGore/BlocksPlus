package ie.dylangore.blocksplus.init;

import ie.dylangore.blocksplus.items.base.ItemBase;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Project: BlocksPlus
 * File: ModItems
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */
public class ModItems {

    public static void init(){


        LogHelper.info("Items registered!");
    }

    public static void registerItem(Item item){
        GameRegistry.register(item);
        if (item instanceof ItemBase) {
            ((ItemBase)item).registerItemModel();
        }
    }

}
