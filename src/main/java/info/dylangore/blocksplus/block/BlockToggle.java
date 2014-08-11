/*
 * Project: BlocksPlus
 * File: BlockToggle.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import info.dylangore.blocksplus.init.BPBlocks;
import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class BlockToggle extends BPBlock {

    private IIcon[] icons;

    public BlockToggle(String blockName) {
        super(blockName);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void registerBlockIcons(IIconRegister ir) {
        icons = new IIcon[2];
        for(int i = 0; i < icons.length; i++)
        icons[i] = ir.registerIcon(Reference.ID + ":" + "toggleBlock_" + i);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List list){
        for(int i = 0; i < icons.length; ++i) {
            list.add(new ItemStack(BPBlocks.toggleBlock, 1, i));
        }
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        if(world.getBlockMetadata(x,y,z) != 0){
            world.setBlock(x,y,z, BPBlocks.toggleBlock);
        }
        return super.onBlockPlaced(world, x, y, z, side, hitX, hitY, hitZ, meta);
    }

    @Override
    public int damageDropped(int meta){
        if(meta == 1){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        return icons[meta];
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        final World fworld = world;
        final int fx = x;
        final int fy = y;
        final int fz = z;
        fworld.playSound((double) fx + 0.5D, (double) fy + 0.5D, (double) fz + 0.5D, "dig.stone", 1.0F, fworld.rand.nextFloat() * 0.1F * 0.9F, true);
        world.setBlockToAir(x,y,z);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        fworld.playSound((double) fx + 0.5D, (double) fy + 0.5D, (double) fz + 0.5D, "dig.stone", 1.0F, fworld.rand.nextFloat() * 0.1F * 0.9F, true);
                        fworld.setBlock(fx, fy, fz, BPBlocks.toggleBlock);
                    }
                },
                2500
        );
        return true;
    }

    @Override
    public boolean isBlockNormalCube() {
        return false;
    }

    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity) {
        if(world.getBlockMetadata(x,y,z) != 1){
            super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        if(world.getBlockMetadata(x,y,z) != 1){
           return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
        }else{
            return null;
        }
    }
}
