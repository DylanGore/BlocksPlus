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

    public BlockBase(Block.Properties properties, String name, float hardness, float resistance) {
        super(properties);

        this.name = name;
        properties.hardnessAndResistance(hardness, resistance);
        setRegistryName(name);
    }
}
