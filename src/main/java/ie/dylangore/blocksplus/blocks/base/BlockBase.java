package ie.dylangore.blocksplus.blocks.base;

import ie.dylangore.blocksplus.BlocksPlus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

/**
 * Project: BlocksPlus
 * File: BlockBase
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */
public class BlockBase extends Block {
    protected String name;

    public BlockBase(Material material, String name, float hardness, float resistance) {
        super(material);

        this.name = name;
        setCreativeTab(BlocksPlus.creativeTab);
        setHardness(hardness);
        setResistance(resistance);

        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
