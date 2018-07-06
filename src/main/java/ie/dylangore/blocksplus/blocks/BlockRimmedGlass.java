package ie.dylangore.blocksplus.blocks;

import ie.dylangore.blocksplus.blocks.base.BlockBaseColored;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Random;

/**
 * Project: BlocksPlus
 * File: BlockRimmedGlass
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 09 March 2017
 */
public class BlockRimmedGlass extends BlockBaseColored {
    public BlockRimmedGlass(Material material, String name, float hardness, float resistance) {
        super(material, name, hardness, resistance);
    }

    public BlockRimmedGlass(Material material, String name, float hardness, float resistance, float lightLevel) {
        super(material, name, hardness, resistance);
        setLightLevel(lightLevel);
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return true;
    }
}
