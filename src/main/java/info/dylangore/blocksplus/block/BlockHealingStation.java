/*
 * Project: BlocksPlus
 * File: BlockHealingStation.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 11/08/14 13:08
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.block;

import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHealingStation extends BPBlock {

    public BlockHealingStation(String blockName) {
        super(blockName);
    }

    @Override
    public void registerBlockIcons(IIconRegister ir) {
        this.blockIcon = ir.registerIcon(Reference.ID + ":" + "healingStation");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

        String formatting = "\u00A73 \u00A7o";

        if(world.isRemote){
            player.addChatMessage(new ChatComponentText(String.format(formatting + "You harness the regenerative power of the wither but your")));
            player.addChatMessage(new ChatComponentText(String.format(formatting + "body is being overwhelmed by the sudden influx of energy.")));
        }

        if (player.getActivePotionEffect(Potion.regeneration) == null) {
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 60, 100));
        }
        if (player.getActivePotionEffect(Potion.blindness) == null) {
            player.addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 100));
        }
        if (player.getActivePotionEffect(Potion.confusion) == null) {
            player.addPotionEffect(new PotionEffect(Potion.confusion.id, 60, 100));
        }
        if (player.getActivePotionEffect(Potion.moveSlowdown) == null) {
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 60, 100));
        }
        if (player.getActivePotionEffect(Potion.heal) == null) {
            player.addPotionEffect(new PotionEffect(Potion.heal.id, 20, 40));
        }


        if(player.isSneaking()){
            player.addPotionEffect(new PotionEffect(Potion.harm.id, 20, 1));
        }
        return true;
    }
}
