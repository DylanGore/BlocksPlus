package dylangore.mods.blocksplus.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dylangore.mods.blocksplus.BlocksPlus;
import dylangore.mods.blocksplus.lib.BlockInfo;
import dylangore.mods.blocksplus.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public class BlockColored extends Block {

    private String blockType;

    public BlockColored(String baseBlock, String blockName) {
        super(Material.rock);
        this.setResistance(1.5F);
        this.setHardness(1.0F);
        this.stepSound = soundTypeStone;
        this.setCreativeTab(BlocksPlus.tabBlocksPlus);
        this.setBlockName(blockName);
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
        this.blockIcon = ir.registerIcon(ModInfo.ID + ":" + getBlockType());
    }

    @Override
    public int damageDropped (int meta) {
        return meta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int meta) {
        return BlockInfo.colors[meta];
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
        for (int ix = 0; ix < BlockInfo.colors.length; ix++) {
            subItems.add(new ItemStack(this, 1, ix));
        }
    }
}