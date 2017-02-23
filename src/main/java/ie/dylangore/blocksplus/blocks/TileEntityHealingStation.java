package ie.dylangore.blocksplus.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Project: BlocksPlus
 * File: TileEntityHealingStation
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 11 January 2017
 */
public class TileEntityHealingStation extends TileEntity {

    private boolean blockStatus = false;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setBoolean("blockStatus", blockStatus);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        blockStatus = compound.getBoolean("blockStatus");
        super.readFromNBT(compound);
    }

    public boolean isBlockDisabled() {
        return blockStatus;
    }

    public void disableBlock() {
        blockStatus = true;
        markDirty();
    }

    public void enableBlock() {
        blockStatus = false;
        markDirty();
    }


}
