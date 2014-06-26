package info.dylangore.blocksplus;

import cpw.mods.fml.common.FMLCommonHandler;
import info.dylangore.blocksplus.creativetabs.TabBlocksPlus;
import info.dylangore.blocksplus.handler.*;
import info.dylangore.blocksplus.handler.BPConfig;
import info.dylangore.blocksplus.handler.event.ConfigEventHandler;
import info.dylangore.blocksplus.reference.Reference;
import info.dylangore.blocksplus.util.LogHelper;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import info.dylangore.blocksplus.proxies.CommonProxy;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUIFACTORY)

public class BlocksPlus {
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;

	@Instance(Reference.ID)
	public static BlocksPlus instance;

    public static CreativeTabs tabBlocksPlus = new TabBlocksPlus(CreativeTabs.getNextID(), "info.dylangore.blocksplus.BlocksPlus");

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event){

        /* Initialize Config Files */
        BPConfig.init(event.getSuggestedConfigurationFile());

        /* Initialize blocks and items added by BlocksPlus */
        BPBlocks.init();
        LogHelper.logInit("Blocks");
        BPItems.init();
        LogHelper.logInit("Items");

        /* Initialize the fluids added by BlocksPlus */
        BPFluids.init();
        LogHelper.logInit("Fluids");

        /* Initialize crafting recipes*/
        BPCrafting.init();
        LogHelper.logInit("Crafting Manager");

        /* Initialize World Generator */
        BPWorld.init();
        LogHelper.logInit("World Generator");

	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event){

        ConfigEventHandler configEventHandler = new ConfigEventHandler();
        FMLCommonHandler.instance().bus().register(configEventHandler);

	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		
	}
	
}
