/*
 * Project: BlocksPlus
 * File: IMCHandler.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.handler;

import ie.dylangore.blocksplus.imc.IMCChisel;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraftforge.fml.common.Loader;

public class IMCHandler {

    public static void init(){

        // Chisel
        if(Loader.isModLoaded("chisel")){
            LogHelper.info("Loading BlocksPlus Chisel integration module...");
            IMCChisel.init();
        }else{
            LogHelper.info("IMC: Chisel module not loaded, chisel is not loaded by FML");
        }

    }

}
