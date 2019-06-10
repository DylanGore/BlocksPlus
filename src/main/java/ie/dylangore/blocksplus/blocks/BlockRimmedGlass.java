/*
 * Project: BlocksPlus
 * File: BlockRimmedGlass.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.blocks;

import ie.dylangore.blocksplus.blocks.base.BlockBaseColored;
import net.minecraft.block.state.IBlockState;

//TODO 1.13
public class BlockRimmedGlass extends BlockBaseColored {
    public BlockRimmedGlass(Properties props, String name, float hardness, float resistance) {
        super(props, name, hardness, resistance);
    }

    public BlockRimmedGlass(Properties props, String name, float hardness, float resistance, float lightLevel) {
        super(props.lightValue((int) lightLevel), name, hardness, resistance);
    }

//    @Nonnull
//    @Override
//    @SideOnly(Side.CLIENT)
//    public BlockRenderLayer getBlockLayer() {
//        return BlockRenderLayer.CUTOUT;
//    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

//    @SuppressWarnings("deprecation")
//    @Override
//    public boolean isOpaqueCube(IBlockState state) {
//        return false;
//    }
//
//    @Override
//    public int quantityDropped(Random random) {
//        return 0;
//    }

//    @SuppressWarnings("NullableProblems")
//    @Override
//    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
//        return true;
//    }
}
