package ie.dylangore.blocksplus.blocks;

import ie.dylangore.blocksplus.blocks.base.BlockBase;
import net.minecraft.block.SoundType;
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
 * File: BlockConnectedGlass
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 March 2017
 */

//TODO Implement connected textures

public class BlockConnectedGlass extends BlockBase {
    public BlockConnectedGlass(Material material, String name, float hardness, float resistance) {
        super(material, name, hardness, resistance);
        setSoundType(SoundType.GLASS);
        setLightLevel(1.0F);
        setHarvestLevel("pickaxe", -1);
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

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
