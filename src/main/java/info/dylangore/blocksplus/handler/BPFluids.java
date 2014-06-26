package info.dylangore.blocksplus.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import info.dylangore.blocksplus.fluids.BPFluid;
import info.dylangore.blocksplus.fluids.blocks.BlockBlackStuffFluid;
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
