/*
 * Project: BlocksPlus
 * File: ConfigurationHandler.java
 * Author: Dylan Gore (http://dylangore.info)
 * Creation Date: 02/07/14 18:13
 * Modified: 02/07/14 18:13
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import info.dylangore.blocksplus.init.BPIntegration;
import info.dylangore.blocksplus.reference.Reference;
import info.dylangore.blocksplus.reference.WorldGeneration;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    public static final String CATEGORY_WORLDGEN = "worldgen";
    public static final String CATEGORY_INTEGRATION = "integration";
    
    public static Configuration configuration;

    public static void init(File file){
        if(configuration == null){
            configuration = new Configuration(file);
            loadConfiguration();
        }

        loadConfiguration();
    }

    public static void loadConfiguration(){
        //General

        //Mod Integration
        BPIntegration.enableFMPModule = configuration.getBoolean("Enable FMP Integration", CATEGORY_INTEGRATION, true, "Will Only work if FMP is present, regardless of the setting");

        //World Generation
        WorldGeneration.minVeinSize = configuration.getInt("minVeinSize", CATEGORY_WORLDGEN, 32, 1, 128, "");
        WorldGeneration.maxVeinSize = configuration.getInt("maxVeinSize", CATEGORY_WORLDGEN, 64, 1, 128, "") - WorldGeneration.minVeinSize;
        WorldGeneration.enableWhiteStoneGen = configuration.getBoolean("Enable generation of White Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableOrangeStoneGen = configuration.getBoolean("Enable generation of Orange Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableMagentaStoneGen = configuration.getBoolean("Enable generation of Magenta Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableLightBlueStoneGen = configuration.getBoolean("Enable generation of Light Blue Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableYellowStoneGen = configuration.getBoolean("Enable generation of Yellow Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableLimeStoneGen = configuration.getBoolean("Enable generation of Lime Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enablePinkStoneGen = configuration.getBoolean("Enable generation of Pink Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableGrayStoneGen = configuration.getBoolean("Enable generation of Gray Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableLightGrayStoneGen = configuration.getBoolean("Enable generation of Light Gray Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableCyanStoneGen = configuration.getBoolean("Enable generation of Cyan Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enablePurpleStoneGen = configuration.getBoolean("Enable generation of Purple Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableBlueStoneGen = configuration.getBoolean("Enable generation of Blue Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableBrownStoneGen = configuration.getBoolean("Enable generation of Brown Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableGreenStoneGen = configuration.getBoolean("Enable generation of Green Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableRedStoneGen = configuration.getBoolean("Enable generation of Red Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableBlackStoneGen = configuration.getBoolean("Enable generation of Black Stone", CATEGORY_WORLDGEN, true, "");

        if(configuration.hasChanged()){
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onWorldGenConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if(event.modID.equalsIgnoreCase(Reference.ID))
            loadConfiguration();
    }
}
