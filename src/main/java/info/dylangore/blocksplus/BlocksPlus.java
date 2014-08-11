/*
 * Project: BlocksPlus
 * File: BlocksPlus.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import info.dylangore.blocksplus.command.CommandBlocksPlus;
import info.dylangore.blocksplus.command.CommandBlocksPlusAdmin;
import info.dylangore.blocksplus.creativetab.TabBlocksPlus;
import info.dylangore.blocksplus.handler.BPEventHandler;
import info.dylangore.blocksplus.handler.ConfigurationHandler;
import info.dylangore.blocksplus.init.*;
import info.dylangore.blocksplus.proxy.CommonProxy;
import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUIFACTORY_CLASS)

public class BlocksPlus {
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY_CLASS, serverSide = Reference.COMMONPROXY_CLASS)
	public static CommonProxy proxy;

	@Instance(Reference.ID)
	public static BlocksPlus instance;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event){

        /* Initialize Config Files */
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        /* Initialize block and items added by BlocksPlus */
        BPBlocks.init();
        BPItems.init();

        /* Initialize the fluid added by BlocksPlus */
        BPFluids.init();

        /* Initialize crafting recipes*/
        BPCrafting.init();

        /* Initialize World Generator */
        BPBlocks.initWorldGenerator();

	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event){
        BPEventHandler.initConfigEvents();
    }

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event){
        //BPIntegration.initClient();
	}

    @EventHandler
    public static void serverStarting(FMLServerStartingEvent event){
        event.registerServerCommand(new CommandBlocksPlus());
        event.registerServerCommand(new CommandBlocksPlusAdmin());
    }
	
}
