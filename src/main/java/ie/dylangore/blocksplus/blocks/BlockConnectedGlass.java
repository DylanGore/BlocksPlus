/*
 * Project: BlocksPlus
 * File: BlockConnectedGlass.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.blocks;

import ie.dylangore.blocksplus.blocks.base.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;

public class BlockConnectedGlass extends BlockBase {
    public BlockConnectedGlass(Properties props, String name, float hardness, float resistance) {
        super(props.sound(SoundType.GLASS), name, hardness, resistance);
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
//
//    @SuppressWarnings("NullableProblems")
//    @Override
//    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
//        return true;
//    }
}
