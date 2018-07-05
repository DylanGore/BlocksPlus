package ie.dylangore.blocksplus;

import ie.dylangore.blocksplus.creativetab.TabBlocksPlus;
import ie.dylangore.blocksplus.proxy.IProxy;
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

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION, useMetadata = true, updateJSON = Reference.UPDATE_JSON_URL, guiFactory = Reference.GUI_FACTORY_LOC)
public class BlocksPlus {

    public static final TabBlocksPlus creativeTab = new TabBlocksPlus();

    @Mod.Instance
    public static BlocksPlus instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_LOC, serverSide = Reference.SERVER_PROXY_LOC)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.onPreInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.onInit(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.onPostInit(event);
    }

}
