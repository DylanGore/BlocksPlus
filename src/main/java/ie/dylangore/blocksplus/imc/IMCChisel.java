/*
 * Project: BlocksPlus
 * File: IMCChisel.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.imc;

import ie.dylangore.blocksplus.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;

//TOOD 1.13
public class IMCChisel {

    public static void init(){
        // Group: Sand
        addChiselColorVariation("sand", Blocks.SAND, 2);
        addChiselColorVariation("sand", ModBlocks.blockColoredSand, 16);

        // Group: cobblestone
        addChiselColorVariation("cobblestone", ModBlocks.blockColoredCobblestone, 16);

        // Group: stonebrick (contains vanilla Stone and Stone Bricks by default)
        addChiselColorVariation("stonebrick", ModBlocks.blockColoredStone, 16);

        // Group: coloredStoneBricks (contains all forms of Colored Stone Brick
        addChiselColorVariation("coloredStoneBricks", ModBlocks.blockColoredStoneBricks, 16);
        addChiselColorVariation("coloredStoneBricks", ModBlocks.blockColoredStoneBricksChiseled, 16);
        addChiselColorVariation("coloredStoneBricks", ModBlocks.blockColoredStoneBricksCracked, 16);

        // Group: glass
        addChiselColorVariation("glass", ModBlocks.blockRimmedGlass, 16);

        //Grouo: glowingGlass
        addChiselColorVariation("glowingGlass", ModBlocks.blockRimmedGlowingGlass, 16);
    }

    @SuppressWarnings("ConstantConditions")
    private static void addChiselVariation(String chiselGroup, Block block, int meta)
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("group", chiselGroup);
        tag.setString("block", block.getRegistryName().toString());
//        tag.setInteger("meta", meta);
//        FMLInterModComms.sendMessage("chisel", "add_variation", tag);
    }

    private static void addChiselColorVariation(String chiselGroup, Block block, int maxMeta){
        for(int i = 0; i < maxMeta; i++){
            addChiselVariation(chiselGroup, block, i);
        }
    }

}
