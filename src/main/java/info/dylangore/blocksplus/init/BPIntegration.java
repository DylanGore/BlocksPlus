/*
 * Project: BlocksPlus
 * File: BPIntegration.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import info.dylangore.blocksplus.reference.Reference;
import info.dylangore.blocksplus.utility.LogHelper;
import org.apache.logging.log4j.Level;

public class BPIntegration {

    public static Boolean enableFMPModule = true;

    @SideOnly(Side.CLIENT)
    public static void initClient(){
        versionCheckerIMC();
    }

    /* Initialize IMC between BlocksPlus and Dynious' VersionChecker (if it is installed) */
    public static void versionCheckerIMC(){
        LogHelper.log(Level.INFO, "Checking if Dynious' Version Checker mod is installed...");
        if(Loader.isModLoaded("VersionChecker")){
            LogHelper.log(Level.INFO, "Dynious' Version Checker is installed! Initialize IMC...");
            FMLInterModComms.sendRuntimeMessage(Reference.ID, "VersionChecker", "addVersionCheck", "https://raw.githubusercontent.com/DylanGore/BlocksPlus/master/versions.json");
        }else{
            LogHelper.log(Level.INFO, "Dynious' Version Checker is not installed :(");
        }
    }

}
