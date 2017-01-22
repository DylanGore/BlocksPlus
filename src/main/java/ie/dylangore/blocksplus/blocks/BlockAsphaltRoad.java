package ie.dylangore.blocksplus.blocks;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.blocks.base.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Project: BlocksPlus
 * File: BlockAsphaltRoad
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */
public class BlockAsphaltRoad extends BlockBase{
    public BlockAsphaltRoad(Material material, String name) {
        super(material, name);

    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {

        if (entityIn instanceof Entity) {
            if (((EntityLivingBase) entityIn).getActivePotionEffect(Potion.getPotionById(Reference.PotionEffects.SPEED.getPotionId())) == null) {
                ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.SPEED.getPotionId()), 10, 2, false, false));
            }
//            if (((EntityLivingBase) entityIn).getActivePotionEffect(Potion.getPotionById(Reference.PotionEffects.JUMP_BOOST.getPotionId())) == null) {
//                ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.JUMP_BOOST.getPotionId()), 10, 1, false, false));
//            }
        }
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
