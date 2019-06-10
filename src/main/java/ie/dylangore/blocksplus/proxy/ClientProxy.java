/*
 * Project: BlocksPlus
 * File: ClientProxy.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.proxy;

import ie.dylangore.blocksplus.client.model.ModModelManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientProxy implements IProxy {



    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
        ModModelManager.init();
    }

    @Override
    public void setup(FMLCommonSetupEvent event) {
    }
}
