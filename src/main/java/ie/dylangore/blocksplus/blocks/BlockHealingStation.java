package ie.dylangore.blocksplus.blocks;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.blocks.base.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * Project: BlocksPlus
 * File: BlockHealingStation
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 11 January 2017
 */

public class BlockHealingStation extends BlockBase {
    public BlockHealingStation(Material material, String name) {
        super(material, name);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY) {
        String formatting = "\u00A73 \u00A7o";

        if(worldIn.isRemote){
            playerIn.addChatMessage(new TextComponentString(String.format(formatting + "You harness the regenerative power of the wither but your")));
            playerIn.addChatMessage(new TextComponentString(String.format(formatting + "body is being overwhelmed by the sudden influx of energy.")));
        }

        if (playerIn.getActivePotionEffect(Potion.getPotionById(Reference.PotionEffects.REGENERATION.getPotionId())) == null) {
            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.REGENERATION.getPotionId()), 60, 100, false, false));
        }
        if (playerIn.getActivePotionEffect(Potion.getPotionById(Reference.PotionEffects.BLINDNESS.getPotionId())) == null) {
            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.BLINDNESS.getPotionId()), 80, 100, false, false));
        }
        if (playerIn.getActivePotionEffect(Potion.getPotionById(Reference.PotionEffects.NAUSEA.getPotionId())) == null) {
            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.NAUSEA.getPotionId()), 60, 100, false, false));
        }
        if (playerIn.getActivePotionEffect(Potion.getPotionById(Reference.PotionEffects.SLOWNESS.getPotionId())) == null) {
            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.SLOWNESS.getPotionId()), 60, 100, false, false));
        }
        if (playerIn.getActivePotionEffect(Potion.getPotionById(Reference.PotionEffects.INSTANT_HEALTH.getPotionId())) == null) {
            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.INSTANT_HEALTH.getPotionId()), 20, 40, false, false));
        }

        return true;
    }
}
