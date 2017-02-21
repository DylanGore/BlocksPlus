package ie.dylangore.blocksplus;

import ie.dylangore.blocksplus.creativetab.TabBlocksPlus;
import ie.dylangore.blocksplus.handler.ConfigurationHandler;
import ie.dylangore.blocksplus.init.ModBlocks;
import ie.dylangore.blocksplus.init.ModItems;
import ie.dylangore.blocksplus.proxy.CommonProxy;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Project: BlocksPlus
 * File: BlocksPlus
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION, updateJSON = Reference.UPDATE_JSON_URL, guiFactory = Reference.GUI_FACTORY_LOC)
public class BlocksPlus {

    public static final TabBlocksPlus creativeTab = new TabBlocksPlus();

    @Mod.Instance
    public static BlocksPlus instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_LOC, serverSide = Reference.COMMON_PROXY_LOC)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        LogHelper.info("Blocks Plus is loading...");

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        ModItems.init();
        ModBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }

}
