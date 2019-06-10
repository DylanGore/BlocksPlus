/*
 * Project: BlocksPlus
 * File: BlockColoredSand.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.blocks;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

//TODO 1.13
public class BlockColoredSand extends BlockFalling {
    protected String name;
//    private static final PropertyEnum<EnumDyeColor> BLOCK_COLOR = PropertyEnum.create("color", EnumDyeColor.class);

    public BlockColoredSand(String name, float hardness, float resistance) {
        super(Properties.create(Material.SAND).hardnessAndResistance(hardness, resistance).sound(SoundType.SAND));
        this.name = name;
//        setCreativeTab(BlocksPlus.creativeTab);
//        setHarvestLevel("shovel", 0);

//        setUnlocalizedName(name);
        setRegistryName(name);
    }

//    @Nonnull
//    @Override
//    public BlockStateContainer createBlockState() {
//        return new BlockStateContainer(this, BLOCK_COLOR);
//    }

//    @Override
//    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
//        Block block = state.getBlock();
//        int metadata = state.getBlock().getMetaFromState(state);
//        if (block == ModBlocks.blockColoredStone) {
//            return (new ItemStack(ModBlocks.blockColoredCobblestone, 1, metadata).getItem());
//        } else {
//            return super.getItemDropped(state, rand, fortune);
//        }
//    }
//
//    @Override
//    public int damageDropped(IBlockState state) {
//        return getMetaFromState(state);
//    }
//
//    @Override
//    public int getMetaFromState(IBlockState state) {
//        return state.getValue(BLOCK_COLOR).getMetadata();
//    }
//
//    @SuppressWarnings("deprecation")
//    @Nonnull
//    @Override
//    public IBlockState getStateFromMeta(int meta) {
//        if (meta >= EnumDyeColor.values().length) {
//            meta = 0;
//        }
//        return getDefaultState().withProperty(BLOCK_COLOR, EnumDyeColor.byMetadata(meta));
//    }
//
//    @SideOnly(Side.CLIENT)
//    @Override
//    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
//        for (int i = 0; i < EnumDyeColor.values().length; i++) {
//            list.add(new ItemStack(this, 1, i));
//        }
//    }
}
