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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("unused")
@Mod(Reference.ID)
public class BlocksPlus {

    public static BlocksPlus INSTANCE;
    public static final TabBlocksPlus creativeTab = new TabBlocksPlus();

    public BlocksPlus(){
        INSTANCE = this;
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::setup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void setup(final FMLCommonSetupEvent event) {
        ModItems.preInit();
        ModBlocks.preInit();

        ModBlocks.init();
        ModItems.init();
        IMCHandler.init();
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
//
//    @Mod.EventHandler
//    public void init(FMLInitializationEvent event) {
//        proxy.onInit(event);
//        ModBlocks.init();
//        ModItems.init();
//        IMCHandler.init();
//    }
//
//    @Mod.EventHandler
//    public void postInit(FMLPostInitializationEvent event) {
//        proxy.onPostInit(event);
//    }

}
