package ie.dylangore.blocksplus.proxy;

import ie.dylangore.blocksplus.client.model.ModModelManager;
import ie.dylangore.blocksplus.handler.ColorHandler;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Project: BlocksPlus
 * File: ClientProxy
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void onPreInit(FMLPreInitializationEvent event) {
        super.onPreInit(event);
    }

    @Override
    public void onInit(FMLInitializationEvent event) {
        super.onInit(event);
        ColorHandler.init();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
        ModModelManager.init();
    }
}
