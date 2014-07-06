/*
 * Project: BlocksPlus
 * File: BlocksPlus.java
 * Author: Dylan Gore (http://dylangore.info)
 * Creation Date: 02/07/14 18:13
 * Modified: 02/07/14 18:13
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import info.dylangore.blocksplus.creativetab.TabBlocksPlus;
import info.dylangore.blocksplus.handler.BPEventHandler;
import info.dylangore.blocksplus.handler.ConfigurationHandler;
import info.dylangore.blocksplus.init.BPBlocks;
import info.dylangore.blocksplus.init.BPCrafting;
import info.dylangore.blocksplus.init.BPFluids;
import info.dylangore.blocksplus.init.BPItems;
import info.dylangore.blocksplus.proxy.CommonProxy;
import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUIFACTORY_CLASS)

public class BlocksPlus {
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY_CLASS, serverSide = Reference.COMMONPROXY_CLASS)
	public static CommonProxy proxy;

	@Instance(Reference.ID)
	public static BlocksPlus instance;

    public static CreativeTabs tabBlocksPlus = new TabBlocksPlus(CreativeTabs.getNextID(), I18n.format("blocksplus.gui.creativetab.title"));

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
		
	}
	
}
