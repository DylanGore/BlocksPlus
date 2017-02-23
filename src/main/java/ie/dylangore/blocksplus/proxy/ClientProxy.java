package ie.dylangore.blocksplus.proxy;

import ie.dylangore.blocksplus.handler.ColorHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Project: BlocksPlus
 * File: ClientProxy
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class ClientProxy extends CommonProxy {
    @Override
    public void init(FMLInitializationEvent event){
        ColorHandler.init();
    }
}
