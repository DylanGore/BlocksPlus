package dylangore.mods.blocksplus;

import cpw.mods.fml.common.Loader;
import dylangore.mods.blocksplus.creativetabs.TabBlocksPlus;
import dylangore.mods.blocksplus.registry.BPBlocks;
import dylangore.mods.blocksplus.registry.BPItems;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dylangore.mods.blocksplus.lib.ModInfo;
import dylangore.mods.blocksplus.proxies.CommonProxy;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)

public class BlocksPlus {
	
	@SidedProxy(clientSide = ModInfo.CLIENTPROXY, serverSide = ModInfo.COMMONPROXY)
	public static CommonProxy proxy;

	@Instance(ModInfo.ID)
	public static BlocksPlus instance;

    public static CreativeTabs tabBlocksPlus = new TabBlocksPlus(CreativeTabs.getNextID(), "dylangore.mods.blocksplus.BlocksPlus");

	@EventHandler
	public static void preInit(FMLPreInitializationEvent evt){

        BPBlocks.init();
        BPItems.init();


	}
	
	@EventHandler
	public static void init(FMLInitializationEvent evt){
        System.out.println("[BlocksPLus] " + "Initializing Blocks PLus....");
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent evt){
		
	}
	
}
