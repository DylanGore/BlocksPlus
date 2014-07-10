/*
 * Project: BlocksPlus
 * File: BPEventHandler.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.handler;

import cpw.mods.fml.common.FMLCommonHandler;

/**
 * Author: Dylan Gore (http://dylangore.info)
 * Created: 02/07/2014
 */
public class BPEventHandler {
    public static void initConfigEvents(){
        // Register onConfigurationChanged Event
        ConfigurationHandler configurationHandler = new ConfigurationHandler();
        FMLCommonHandler.instance().bus().register(configurationHandler);
    }

}
