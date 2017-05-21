package ie.dylangore.blocksplus.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Project: BlocksPlus
 * File: IProxy
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 05 May 2017
 */

public interface IProxy {
    void onPreInit(FMLPreInitializationEvent event);
    void onInit(FMLInitializationEvent event);
    void onPostInit(FMLPostInitializationEvent event);
    void initModels();
}
