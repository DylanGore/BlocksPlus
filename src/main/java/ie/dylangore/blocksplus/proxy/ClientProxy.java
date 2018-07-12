/*
 * Project: BlocksPlus
 * File: ClientProxy.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.proxy;

import ie.dylangore.blocksplus.client.model.ModModelManager;
import ie.dylangore.blocksplus.handler.ColorHandler;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy implements IProxy {

    @Override
    public void onPreInit(FMLPreInitializationEvent event) {
    }

    @Override
    public void onInit(FMLInitializationEvent event) {
        ColorHandler.init();
    }

    @Override
    public void onPostInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
        ModModelManager.init();
    }
}
