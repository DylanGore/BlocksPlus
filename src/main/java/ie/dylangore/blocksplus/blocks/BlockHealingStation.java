package ie.dylangore.blocksplus.blocks;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.blocks.base.BlockTileEntity;
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

import javax.annotation.Nullable;

/**
 * Project: BlocksPlus
 * File: BlockHealingStation
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 11 January 2017
 */

public class BlockHealingStation extends BlockTileEntity<TileEntityHealingStation> {

    public BlockHealingStation(Material material, String name, float hardness, float resistance) {
        super(material, name, hardness, resistance);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY) {
        //TODO Add functionality

        String italicCyan = "\u00A73 \u00A7o";

        TileEntityHealingStation tile = getTileEntity(worldIn, pos);
        if (tile.isBlockDisabled()) {
            playerIn.sendStatusMessage(new TextComponentString(String.format("Block Disabled!")), true);
        } else {
            if (worldIn.isRemote) {
                playerIn.sendStatusMessage(new TextComponentString(String.format(italicCyan + "You harness the regenerative power of the wither but your")), false);
                playerIn.sendStatusMessage(new TextComponentString(String.format(italicCyan + "body is being overwhelmed by the sudden influx of energy.")), false);

                playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.REGENERATION.getPotionId()), 40, 1000, true, false));
                playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.BLINDNESS.getPotionId()), 40, 1000, true, false));
                playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.NAUSEA.getPotionId()), 40, 1000, true, false));
                playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.SLOWNESS.getPotionId()), 40, 1000, true, false));
                playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.INSTANT_HEALTH.getPotionId()), 40, 40, true, false));

                playerIn.clearActivePotions();
            }

            tile.disableBlock();
            playerIn.clearActivePotions();
        }

        if (worldIn.isBlockPowered(pos)) {
            tile.enableBlock();
        }

        return true;
    }

    @Override
    public Class<TileEntityHealingStation> getTileEntityClass() {
        return TileEntityHealingStation.class;
    }

    @Nullable
    @Override
    public TileEntityHealingStation createTileEntity(World world, IBlockState state) {
        return new TileEntityHealingStation();
    }
}
