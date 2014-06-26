package info.dylangore.blocksplus.blocks.tile;

import info.dylangore.blocksplus.BlocksPlus;
import info.dylangore.blocksplus.network.PacketManager;
import info.dylangore.blocksplus.network.PacketMimic;
import info.dylangore.blocksplus.util.mimic.BlockHolder;
import info.dylangore.blocksplus.util.mimic.FakeWorld;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import scala.tools.nsc.doc.model.Public;

import java.util.Arrays;
import java.util.UUID;

public class TileEntityMimic extends TileEntity{

    private BlockHolder holder;
    public boolean[] isCamo;
    public static String ownerName = "";

    public TileEntityMimic()
    {
        super();
        holder = null;
        isCamo = new boolean[6];
        Arrays.fill(isCamo, true);
    }

    @Override
    public boolean canUpdate()
    {
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        holder = BlockHolder.buildFromNBT(nbt);

        ownerName = nbt.getString("ownerName");

        for (int i = 0; i < isCamo.length; i++)
        {
            isCamo[i] = nbt.getBoolean("isCamo" + i);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        holder.writeToNBT(nbt);
        // if this throws an NPE.. something has gone TERRIBLY wrong...

        for (int i = 0; i < isCamo.length; i++)
        {
            nbt.setBoolean("isCamo" + i, isCamo[i]);
            nbt.setString("owner", ownerName);
        }


    }

    /**
     * signs and mobSpawners use this to send text and meta-data
     */
    @Override
    public Packet getDescriptionPacket()
    {
        return PacketManager.toMcPacket(new PacketMimic(this));
    }

    public void setBlockHolder(BlockHolder holder)
    {
        if (holder == null)
            return;
        FakeWorld fake = BlocksPlus.proxy.getFakeWorld(worldObj);
        if (fake != null)
        {
            fake.addOverrideBlock(xCoord, yCoord, zCoord, holder);
        }

        this.holder = holder;
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    /**
     * invalidates a tile entity
     */
    @Override
    public void invalidate()
    {
        FakeWorld fake = BlocksPlus.proxy.getFakeWorld(worldObj);
        if (fake != null)
        {
            fake.removeOverrideBlock(xCoord, yCoord, zCoord);
        }
        super.invalidate();
    }

    @Override
    public void validate()
    {
        FakeWorld fake = BlocksPlus.proxy.getFakeWorld(worldObj);
        if (fake != null)
        {
            fake.addOverrideBlock(xCoord, yCoord, zCoord, holder);
        }
        super.validate();
    }

    public BlockHolder getBlockHolder()
    {
        return holder;
    }

    public Block getCopyBlock()
    {
        return holder == null ? null : holder.block;
    }

    public boolean isCamoSide(int side)
    {
        if (side >= 0 && side <= 5)
            return isCamo[side];
        else
            return false;
    }

}
