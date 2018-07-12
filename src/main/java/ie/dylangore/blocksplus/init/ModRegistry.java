/*
 * Project: BlocksPlus
 * File: ModRegistry.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ModRegistry {

    private static List<Block> blockList = new ArrayList<>();
    private static List<Item> itemList = new ArrayList<>();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        IForgeRegistry<Block> r = event.getRegistry();
        for (Block aBlockList : blockList) {
            r.register(aBlockList);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> r = event.getRegistry();
        for (Item anItemList : itemList) {
            r.register(anItemList);
        }
    }



    static void addBlock(Block block){
        blockList.add(block);
    }

    static void addItem(Item item){
        itemList.add(item);
    }

}
