package ie.dylangore.blocksplus.blocks.base;

import ie.dylangore.blocksplus.BlocksPlus;
import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.Reference.EnumColors;
import ie.dylangore.blocksplus.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Project: BlocksPlus
 * File: BlockBaseColoured
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 18 January 2017
 */

public class BlockBaseColored extends BlockBase {

    public static final PropertyEnum<EnumColors> BLOCK_COLOR = PropertyEnum.<EnumColors>create("block_color", EnumColors.class);

    public BlockBaseColored(Material material, String name, float hardness, float resistance) {
        super(material, name, hardness, resistance);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BLOCK_COLOR, EnumColors.WHITE));
        this.setSoundType(SoundType.STONE);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        Block block = state.getBlock();
        int metadata = state.getBlock().getMetaFromState(state);
        if(block == ModBlocks.blockColoredStone){
            return (new ItemStack(ModBlocks.blockColoredCobblestone, 1, metadata).getItem());
        }else{
            return super.getItemDropped(state, rand, fortune);
        }
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((EnumColors)state.getValue(BLOCK_COLOR)).getMetadata();
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumColors)state.getValue(BLOCK_COLOR)).getMetadata();
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(BLOCK_COLOR, EnumColors.byMetadata(meta));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {BLOCK_COLOR});
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list)
    {
        for (EnumColors enumColors : EnumColors.values())
        {
            list.add(new ItemStack(itemIn, 1, enumColors.getMetadata()));
        }
    }

}
