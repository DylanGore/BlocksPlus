/*
 * Project: BlocksPlus
 * File: BlockBaseColored.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.blocks.base;

import ie.dylangore.blocksplus.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockBaseColored extends BlockBase {

    public static final PropertyEnum<EnumDyeColor> BLOCK_COLOR = PropertyEnum.create("color", EnumDyeColor.class);

    public BlockBaseColored(Material material, String name, float hardness, float resistance) {
        super(material, name, hardness, resistance);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BLOCK_COLOR, EnumDyeColor.WHITE));
        this.setSoundType(SoundType.STONE);
    }

    @Nonnull
    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, BLOCK_COLOR);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        Block block = state.getBlock();
        int metadata = state.getBlock().getMetaFromState(state);
        if (block == ModBlocks.blockColoredStone) {
            return (new ItemStack(ModBlocks.blockColoredCobblestone, 1, metadata).getItem());
        } else {
            return super.getItemDropped(state, rand, fortune);
        }
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(BLOCK_COLOR).getMetadata();
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (meta >= EnumDyeColor.values().length) {
            meta = 0;
        }
        return getDefaultState().withProperty(BLOCK_COLOR, EnumDyeColor.byMetadata(meta));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        for (int i = 0; i < EnumDyeColor.values().length; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }
}
