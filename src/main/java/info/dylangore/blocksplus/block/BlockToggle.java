/*
 *
 *  * Project: BlocksPlus
 *  * File: BlockToggle.java
 *  * Author: Dylan Gore (http://dylangore.info)
 *  * Creation Date: 06/07/14 21:54
 *  * Modified: 06/07/14 21:54
 *  * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 *
 */

package info.dylangore.blocksplus.block;

import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockToggle extends BPBlock {

    private IIcon blockIconOff;

    public BlockToggle(String blockName) {
        super(blockName);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void registerBlockIcons(IIconRegister ir) {
        this.blockIcon = ir.registerIcon(Reference.ID + ":" + this.getName());
        this.blockIconOff = ir.registerIcon(Reference.ID + ":" + this.getName()+ "_off");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        world.spawnEntityInWorld(new EntityLightningBolt(world, (double)x, (double)y, (double)z));
        if(world.isRemote){
            player.addChatComponentMessage(new ChatComponentText("This block is W.I.P!"));
        }
        return true;
    }
}
