package info.dylangore.blocksplus;

import cpw.mods.fml.common.Loader;
import info.dylangore.blocksplus.compat.ModuleForgeMultipart;
import info.dylangore.blocksplus.creativetabs.TabBlocksPlus;
import info.dylangore.blocksplus.core.*;
import info.dylangore.blocksplus.util.LogHelper;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import info.dylangore.blocksplus.lib.ModInfo;
import info.dylangore.blocksplus.proxies.CommonProxy;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)

public class BlocksPlus {
	
	@SidedProxy(clientSide = ModInfo.CLIENTPROXY, serverSide = ModInfo.COMMONPROXY)
	public static CommonProxy proxy;

	@Instance(ModInfo.ID)
	public static BlocksPlus instance;

    public static CreativeTabs tabBlocksPlus = new TabBlocksPlus(CreativeTabs.getNextID(), "info.dylangore.blocksplus.BlocksPlus");

    /* Compatibility Modules */
    public static boolean isGoreCoreLoaded = false;
    public static boolean isFMPLoaded = false;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent evt){

        MinecraftForge.EVENT_BUS.register(proxy);

        /* Check to see if GoreCore is installed */
        if(Loader.isModLoaded("GoreCore")){
            isGoreCoreLoaded = true;
            LogHelper.logInfo("Activating GoreCore integration module...");
        }else{
            isGoreCoreLoaded = false;
            LogHelper.logInfo("GoreCore is not installed! This could cause some serious issues with BlocksPlus!");
        }

        if(Loader.isModLoaded("ForgeMultipart")){
            isFMPLoaded = true;
            LogHelper.logInfo("Activating ForgeMultipart integration module...");
        }

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
	public static void init(FMLInitializationEvent evt){
        /* Check for FMP */
        if(isFMPLoaded){
            ModuleForgeMultipart.init();
        }

	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent evt){
		
	}
	
}
