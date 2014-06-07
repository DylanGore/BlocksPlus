package dylangore.mods.blocksplus.items;

import dylangore.mods.blocksplus.BlocksPlus;
import dylangore.mods.blocksplus.lib.ModInfo;
import net.minecraft.item.Item;

public class BPItem extends Item {

    public String texName;

    public BPItem(String name, String textureName, int stackSize){
        this.setUnlocalizedName(name);
        this.setTextureName(ModInfo.ID + ":" + textureName);
        this.setCreativeTab(BlocksPlus.tabBlocksPlus);
        this.setMaxStackSize(stackSize);
    }

}
