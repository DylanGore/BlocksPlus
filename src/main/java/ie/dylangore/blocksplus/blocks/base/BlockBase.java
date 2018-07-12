/*
 * Project: BlocksPlus
 * File: BlockBase.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.blocks.base;

import ie.dylangore.blocksplus.BlocksPlus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    protected String name;

    public BlockBase(Material material, String name, float hardness, float resistance) {
        super(material);

        this.name = name;
        setCreativeTab(BlocksPlus.creativeTab);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel("pickaxe", 0);

        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
