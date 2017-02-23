package ie.dylangore.blocksplus.blocks.base;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Project: BlocksPlus
 * File: BlockTileEntity
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 11 January 2017
 */
public abstract class BlockTileEntity<TE extends TileEntity> extends BlockBase {

    public BlockTileEntity(Material material, String name, float hardness, float resistance) {
        super(material, name, hardness, resistance);
    }

    public abstract Class<TE> getTileEntityClass();

    public TE getTileEntity(IBlockAccess world, BlockPos pos) {
        return (TE) world.getTileEntity(pos);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public abstract TE createTileEntity(World world, IBlockState state);

}
