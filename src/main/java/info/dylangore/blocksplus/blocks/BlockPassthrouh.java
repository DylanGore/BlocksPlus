package info.dylangore.blocksplus.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import info.dylangore.blocksplus.blocks.tile.TileEntityMimic;
import info.dylangore.blocksplus.core.BPItems;
import info.dylangore.blocksplus.items.BPItem;
import info.dylangore.blocksplus.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Random;

public class BlockPassthrouh extends BlockMimic{

    public BlockPassthrouh(Material material, String blockName) {
        super(material, blockName);
        this.setBlockUnbreakable();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        blockIcon = par1IconRegister.registerIcon(ModInfo.ID + ":" + "passthrough");
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        int metadata = par1World.getBlockMetadata(par2, par3, par4);

        if (metadata == 0)
            return null;
        else
            return AxisAlignedBB.getBoundingBox(par2 + minX, par3 + minY, par4 + minZ, par2 + maxX, par3 + maxY, par4 + maxZ);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block changed)
    {
        if (changed != null && changed.canProvidePower())
        {
            world.scheduleBlockUpdate(x, y, z, changed, 0);
        }
    }

    @Override
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        boolean flag = !world.isRemote && (world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j + 1, k));

        if (flag)
        {
            world.setBlockMetadataWithNotify(i, j, k, 1, 4);
        }
        else
        {
            world.setBlockMetadataWithNotify(i, j, k, 0, 4);
        }
    }
}
