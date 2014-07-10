/*
 * Project: BlocksPlus
 * File: BPFluids.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.init;

import cpw.mods.fml.common.registry.GameRegistry;
import info.dylangore.blocksplus.fluid.BPFluid;
import info.dylangore.blocksplus.fluid.blocks.BlockBlackStuffFluid;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BPFluids {

    /* Declare Fluids */
    public static Fluid blackStuff;

    /* Declare Fluid Blocks */
    public static Block fluidBlackStuff;

    public static void init(){
        registerFluids();
        registerFluidBlocks();
    }

    private static void registerFluids(){
        blackStuff = new BPFluid("blackStuff").setIcons(BlockBlackStuffFluid.blackStuffStill, BlockBlackStuffFluid.blackStuffFlowing);
        FluidRegistry.registerFluid(blackStuff);
    }

    private static void registerFluidBlocks(){
        fluidBlackStuff = new BlockBlackStuffFluid(blackStuff).setBlockName("fluidBlackStuff");
        GameRegistry.registerBlock(fluidBlackStuff, "fluidBlackStuff");
        blackStuff.setBlock(fluidBlackStuff);
    }

}
