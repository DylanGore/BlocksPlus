package ie.dylangore.blocksplus.proxy;

import ie.dylangore.blocksplus.client.model.ModModelManager;
import ie.dylangore.blocksplus.handler.ColorHandler;

/**
 * Project: BlocksPlus
 * File: ClientProxy
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class ClientProxy extends ServerProxy implements CommonProxy {
    @Override
    public void init() {
        ColorHandler.init();
    }

    @Override
    public void initModels() {
        ModModelManager.init();
    }
}
