package ie.dylangore.blocksplus.proxy;

import ie.dylangore.blocksplus.client.model.ModModelManager;
import ie.dylangore.blocksplus.handler.ColorHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Project: BlocksPlus
 * File: ClientProxy
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class ClientProxy extends CommonProxy {

    @Override
    public void onPreInit(FMLPreInitializationEvent event) {
        super.onPreInit(event);

        ModModelManager.init();
    }

    @Override
    public void onInit(FMLInitializationEvent event) {
        super.onInit(event);

        ColorHandler.init();
    }
}
