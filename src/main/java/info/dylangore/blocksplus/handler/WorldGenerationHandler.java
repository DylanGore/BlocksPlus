/*
 * Project: BlocksPlus
 * File: WorldGenerationHandler.java
 * Author: Dylan Gore (http://dylangore.info)
 * Creation Date: 02/07/14 18:13
 * Modified: 02/07/14 18:13
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.handler;

import cpw.mods.fml.common.IWorldGenerator;
import info.dylangore.blocksplus.init.BPBlocks;
import info.dylangore.blocksplus.reference.WorldGeneration;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class WorldGenerationHandler implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        switch(world.provider.dimensionId){
            //Nether
            case -1:
                generateNether(world, random, chunkX*16, chunkZ*16);
                break;
            // Overworld
            case 0:
                generateSurface(world, random, chunkX*16, chunkZ*16);
                break;
            //End
            case 1:
                generateEnd(world, random, chunkX*16, chunkZ*16);
                break;
        }

    }

    private void generateEnd(World world, Random random, int posX, int posZ) {
    }

    private void generateSurface(World world, Random random, int posX, int posZ) {
        int Xcoord = posX + random.nextInt(16);
        int Zcoord = posZ + random.nextInt(16);

        int maxYcoord = 60;
        int veinSize = WorldGeneration.minVeinSize + random.nextInt(WorldGeneration.maxVeinSize);

        if(WorldGeneration.enableWhiteStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,0, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableOrangeStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,1, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableMagentaStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,2, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableLightBlueStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,3, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableYellowStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,4, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableLimeStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,5, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enablePinkStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,6, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableGrayStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,7, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableLightGrayStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,8, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableCyanStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,9, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enablePurpleStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,10, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableBlueStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,11, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableBrownStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,12, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableGreenStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,13, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableRedStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,14, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }
        if(WorldGeneration.enableBlackStoneGen){
            (new WorldGenMinable(BPBlocks.colorStone,15, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
        }


//        for(int meta = 0; meta < BPBlocks.colors.length; meta ++){
//            (new WorldGenMinable(BPBlocks.colorStone,meta, veinSize, Blocks.stone)).generate(world, random, Xcoord, maxYcoord, Zcoord);
//        }



    }

    private void generateNether(World world, Random random, int posX, int posZ) {
    }

    //	 /**
//     * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
//     *
//     * @param The Block to spawn
//     * @param The World to spawn in
//     * @param A Random object for retrieving random positions within the world to spawn the Block
//     * @param An int for passing the X-Coordinate for the Generation method
//     * @param An int for passing the Z-Coordinate for the Generation method
//     * @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
//     * @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
//     * @param An int for setting the maximum size of a vein
//     * @param An int for the Number of chances available for the Block to spawn per-chunk
//     * @param An int for the minimum Y-Coordinate height at which this block may spawn
//     * @param An int for the maximum Y-Coordinate height at which this block may spawn
//     **/
    public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {
        @SuppressWarnings("unused")
        int maxPossY = minY + (maxY - 1);
        assert maxY > minY: "The maximum Y must be greater than the Minimum Y";
        assert maxX > 0 && maxX <= 16: "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
        assert minY > 0: "addOreSpawn: The Minimum Y must be greater than 0";
        assert maxY < 256 && maxY > 0: "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
        assert maxZ > 0 && maxZ <= 16: "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

        int diffBtwnMinMaxY = maxY - minY;
        for(int x = 0; x < chancesToSpawn; x++)
        {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(diffBtwnMinMaxY);
            int posZ = blockZPos + random.nextInt(maxZ);
            (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
    }

}