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
    public BlockHealingStation(Material material, String name) {
        super(material, name);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY) {
        String formatting = "\u00A73 \u00A7o";

        if(worldIn.isRemote){

           if(playerIn.isSneaking()){
               playerIn.removePotionEffect(Potion.getPotionById(Reference.PotionEffects.REGENERATION.getPotionId()));
               playerIn.removePotionEffect(Potion.getPotionById(Reference.PotionEffects.BLINDNESS.getPotionId()));
               playerIn.removePotionEffect(Potion.getPotionById(Reference.PotionEffects.NAUSEA.getPotionId()));
               playerIn.removePotionEffect(Potion.getPotionById(Reference.PotionEffects.SLOWNESS.getPotionId()));
               playerIn.removePotionEffect(Potion.getPotionById(Reference.PotionEffects.INSTANT_HEALTH.getPotionId()));
           }else{
               TileEntityHealingStation tile = getTileEntity(worldIn, pos);
               if(tile.isBlockDisabled()){
                   playerIn.addChatMessage(new TextComponentString(String.format(formatting + "Disabled!")));
               }else{
                   playerIn.addChatMessage(new TextComponentString(String.format(formatting + "You harness the regenerative power of the wither but your")));
                   playerIn.addChatMessage(new TextComponentString(String.format(formatting + "body is being overwhelmed by the sudden influx of energy.")));

                   playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.REGENERATION.getPotionId()), 1, 1000, false, false));
                   playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.BLINDNESS.getPotionId()), 1, 1000, false, false));
                   playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.NAUSEA.getPotionId()), 1, 1000, false, false));
                   playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.SLOWNESS.getPotionId()), 1, 1000, false, false));
                   playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.INSTANT_HEALTH.getPotionId()), 1, 40, false, false));

                   tile.disableBlock();
               }

               if(worldIn.isBlockPowered(pos)){
                   tile.enableBlock();
               }
           }

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
