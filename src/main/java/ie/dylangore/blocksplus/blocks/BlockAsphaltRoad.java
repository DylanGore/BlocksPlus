/*
 * Project: BlocksPlus
 * File: BlockAsphaltRoad.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

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

public class BlockAsphaltRoad extends BlockBase {

    public BlockAsphaltRoad(Material material, String name, float hardness, float resistance) {
        super(material, name, hardness, resistance);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {

        if (entityIn != null) {
            if (((EntityLivingBase) entityIn).getActivePotionEffect(Potion.getPotionById(Reference.PotionEffects.SPEED.getPotionId())) == null) {
                ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(Reference.PotionEffects.SPEED.getPotionId()), 10, 2, false, false));
            }
        }
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
