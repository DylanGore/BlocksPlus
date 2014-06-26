package info.dylangore.blocksplus.handler;

import info.dylangore.blocksplus.reference.WorldGeneration;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class BPConfig {
    public static final String CATEGORY_WORLDGEN = "worldgen";
    public static final String CATEGORY_INTEGRATION = "integration";
    
    public static Configuration config;

    public static void init(File file){
        config = new Configuration(file);

        syncConfig();
    }

    public static void syncConfig(){
        BPIntegration.enableFMPModule = config.getBoolean("Enable FMP Integration", CATEGORY_INTEGRATION, true, "Will Only work if FMP is present, regardless of the setting");

        WorldGeneration.enableWhiteStoneGen = config.getBoolean("Enable generation of White Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableOrangeStoneGen = config.getBoolean("Enable generation of Orange Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableMagentaStoneGen = config.getBoolean("Enable generation of Magenta Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableLightBlueStoneGen = config.getBoolean("Enable generation of Light Blue Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableYellowStoneGen = config.getBoolean("Enable generation of Yellow Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableLimeStoneGen = config.getBoolean("Enable generation of Lime Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enablePinkStoneGen = config.getBoolean("Enable generation of Pink Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableGrayStoneGen = config.getBoolean("Enable generation of Gray Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableLightGrayStoneGen = config.getBoolean("Enable generation of Light Gray Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableCyanStoneGen = config.getBoolean("Enable generation of Cyan Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enablePurpleStoneGen = config.getBoolean("Enable generation of Purple Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableBlueStoneGen = config.getBoolean("Enable generation of Blue Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableBrownStoneGen = config.getBoolean("Enable generation of Brown Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableGreenStoneGen = config.getBoolean("Enable generation of Green Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableRedStoneGen = config.getBoolean("Enable generation of Red Stone", CATEGORY_WORLDGEN, true, "");
        WorldGeneration.enableBlackStoneGen = config.getBoolean("Enable generation of Black Stone", CATEGORY_WORLDGEN, true, "");

        if(config.hasChanged())
            config.save();
    }
}
