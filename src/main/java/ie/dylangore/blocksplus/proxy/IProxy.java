/*
 * Project: BlocksPlus
 * File: IProxy.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy {
    void onPreInit(FMLPreInitializationEvent event);
    void onInit(FMLInitializationEvent event);
    void onPostInit(FMLPostInitializationEvent event);
}
