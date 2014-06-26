package info.dylangore.blocksplus.handler.event;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import info.dylangore.blocksplus.handler.BPConfig;
import info.dylangore.blocksplus.reference.Reference;

public class ConfigEventHandler {

    @SubscribeEvent
    public void onWorldGenConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if(eventArgs.modID.equals(Reference.ID))
            BPConfig.syncConfig();
    }



}
