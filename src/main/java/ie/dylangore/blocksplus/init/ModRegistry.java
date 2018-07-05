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
        for(int i = 0; i < blockList.size(); i++){
//            LogHelper.info("Registering Block: " + blockList.get(i).getUnlocalizedName());
            r.register(blockList.get(i));
        }

//        registerOreDict(blockColoredCobblestone, "cobblestone", true);
//        registerOreDict(blockColoredStone, "stone", true);
//        registerOreDict(blockRimmedGlass, "blockGlass", true);
//        registerOreDict(blockRimmedGlowingGlass, "blockGlass", true);
//
//        registerOreDict(blockGlowingGlass, "blockGlass", false);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> r = event.getRegistry();
        for(int i = 0; i < itemList.size(); i++) {
//            LogHelper.info("Registering Item: " + itemList.get(i).getUnlocalizedName());
            r.register(itemList.get(i));
        }
    }



    public static void addBlock(Block block){
        blockList.add(block);
    }

    public static void addItem(Item item){
        itemList.add(item);
    }

}
