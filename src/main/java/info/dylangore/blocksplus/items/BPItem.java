package info.dylangore.blocksplus.items;

import info.dylangore.blocksplus.BlocksPlus;
import info.dylangore.blocksplus.lib.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BPItem extends Item {

    public String texName;

    public BPItem(String name, String textureName, int stackSize){
        this.setUnlocalizedName(name);
        this.setTextureName(ModInfo.ID + ":" + textureName);
        this.setCreativeTab(BlocksPlus.tabBlocksPlus);
        this.setMaxStackSize(stackSize);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        if(player.isSneaking()){
            //TileEntity
            return true;
        }else{
            return false;
        }
    }
}
