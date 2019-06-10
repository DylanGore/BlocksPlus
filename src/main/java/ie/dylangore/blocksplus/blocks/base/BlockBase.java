/*
 * Project: BlocksPlus
 * File: BlockBase.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    protected String name;

    public BlockBase(Properties props, String name, float hardness, float resistance) {
        super(props.hardnessAndResistance(hardness, resistance));

        this.name = name;
        setRegistryName(name);
    }
}
