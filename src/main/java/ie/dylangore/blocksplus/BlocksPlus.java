/*
 * Project: BlocksPlus
 * File: BlocksPlus.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus;

import ie.dylangore.blocksplus.creativetab.TabBlocksPlus;
import ie.dylangore.blocksplus.handler.IMCHandler;
import ie.dylangore.blocksplus.init.ModBlocks;
import ie.dylangore.blocksplus.init.ModItems;
import ie.dylangore.blocksplus.proxy.ClientProxy;
import ie.dylangore.blocksplus.proxy.IProxy;
import ie.dylangore.blocksplus.proxy.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("Convert2MethodRef")
@Mod(Reference.ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlocksPlus {

    public static final TabBlocksPlus creativeTab = new TabBlocksPlus();

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public BlocksPlus(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        proxy.setup(event);
        ModBlocks.init();
        ModItems.init();
        IMCHandler.init();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent<Block> event){

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent<Item> event){

    }

//        @Mod.EventHandler
//    public void preInit(FMLPreInitializationEvent event) {
//        proxy.onPreInit(event);
//
//        LogHelper.info("Blocks Plus is loading...");
//
//        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
//
//        ModItems.preInit();
//        ModBlocks.preInit();
//    }

}
