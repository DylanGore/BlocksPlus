/*
 * Project: BlocksPlus
 * File: BlockColored.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import info.dylangore.blocksplus.init.BPBlocks;
import info.dylangore.blocksplus.reference.BlockReference;
import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;

import java.util.List;
import java.util.Random;

public class BlockColored extends BPBlock {

    private String blockType;

    public BlockColored(String baseBlock, String blockName) {
        super(blockName);
        this.setBlockType(baseBlock);
    }

    public Block setBlockType(String type){
        this.blockType = type;
        return this;
    }

    public String getBlockType(){
        return this.blockType;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        this.blockIcon = ir.registerIcon(Reference.ID + ":" + getBlockType());
    }

    @Override
    public Item getItemDropped(int i, Random rand, int par3) {
        if(this == BPBlocks.colorStone){
            return Item.getItemFromBlock(BPBlocks.colorCobble);
        }else{
            return Item.getItemFromBlock(this);
        }
    }

    @Override
    public int damageDropped (int meta) {
        return meta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int meta) {
        return BlockReference.colors[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess IBlockAccess, int x, int y, int z) {
        int meta = IBlockAccess.getBlockMetadata(x, y, z);

        int color = 000000;

        switch(meta){
            case 0:
                return 0xffffff;
            case 1:
                return 0xffa500;
            case 2:
                return 0xff00ff;
            case 3:
                return 0x6666ff;
            case 4:
                return 0xffff00;
            case 5:
                return 0x00ff00;
            case 6:
                return 0xffc0cb;
            case 7:
                return 0x4c4c4c;
            case 8:
                return 0x808080;
            case 9:
                return 0x00b2b2;
            case 10:
                return 0x800080;
            case 11:
                return 0x0000ff;
            case 12:
                return 0x4E2E28;
            case 13:
                return 0x008000;
            case 14:
                return 0xff0000;
            case 15:
                return 0x3232320;
            default:
                return color;
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List subItems) {
        for (int ix = 0; ix < BlockReference.colors.length; ix++) {
            subItems.add(new ItemStack(this, 1, ix));
        }
    }
}