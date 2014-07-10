/*
 * Project: BlocksPlus
 * File: BPBlock.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.block;

import info.dylangore.blocksplus.BlocksPlus;
import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BPBlock extends Block {

    private static String name;

    public BPBlock(String blockName) {
        super(Material.rock);
        this.setResistance(1.5F);
        this.setHardness(1.0F);
        this.stepSound = soundTypeStone;
        this.setCreativeTab(BlocksPlus.tabBlocksPlus);
        this.setBlockName(blockName);
        this.name = blockName;
    }

    @Override
    public void registerBlockIcons(IIconRegister ir) {
        this.blockIcon = ir.registerIcon(Reference.ID + ":" + this.getName());
    }


   /*
    * Returns un-localized name of block
    */
    public String getName(){
        return name;
    }
}
