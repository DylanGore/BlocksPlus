/*
 * Project: BlocksPlus
 * File: BlocksPlus.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus;

import ie.dylangore.blocksplus.creativetab.TabBlocksPlus;
import ie.dylangore.blocksplus.handler.ConfigurationHandler;
import ie.dylangore.blocksplus.handler.IMCHandler;
import ie.dylangore.blocksplus.init.ModBlocks;
import ie.dylangore.blocksplus.init.ModItems;
import ie.dylangore.blocksplus.proxy.IProxy;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@SuppressWarnings("unused")
@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION, useMetadata = true, updateJSON = Reference.UPDATE_JSON_URL, guiFactory = Reference.GUI_FACTORY_LOC)
public class BlocksPlus {

    public static final TabBlocksPlus creativeTab = new TabBlocksPlus();

    @Mod.Instance
    public static BlocksPlus instance;

    @SuppressWarnings("WeakerAccess")
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_LOC, serverSide = Reference.SERVER_PROXY_LOC)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.onPreInit(event);

        LogHelper.info("Blocks Plus is loading...");

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        ModItems.preInit();
        ModBlocks.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.onInit(event);
        ModBlocks.init();
        ModItems.init();
        IMCHandler.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.onPostInit(event);
    }

}
