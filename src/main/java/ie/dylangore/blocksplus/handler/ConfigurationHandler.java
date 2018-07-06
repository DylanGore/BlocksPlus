package ie.dylangore.blocksplus.handler;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

/**
 * Project: BlocksPlus
 * File: Configuration
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 21 February 2017
 */

@SuppressWarnings("WeakerAccess")
public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean testValue;

    public static void init(File configFile) {

        if (configuration == null) {
            configuration = new Configuration(configFile, true);
            loadConfiguration();
        }
    }

    private static void loadConfiguration() {

        LogHelper.debug("Loading configuration file");

        testValue = configuration.getBoolean("testing value", Configuration.CATEGORY_GENERAL, false, "This is an example configuration value");

        if (configuration.hasChanged()) {
            configuration.save();
        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase(Reference.ID)) {
            LogHelper.debug("Configuration has changed, reloading");
            loadConfiguration();
        }
    }

}
