/*
 * Project: BlocksPlus
 * File: BlockNT.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 11/08/14 11:24
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.block;

import info.dylangore.blocksplus.block.BPBlock;
import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BlockAsphaltRoad extends BPBlock {
    public BlockAsphaltRoad(String blockName) {
        super(blockName);
    }

    @Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        if (entity instanceof Entity) {
            if (((EntityLivingBase) entity).getActivePotionEffect(Potion.moveSpeed) == null) {
                ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 2));
            }
            if (((EntityLivingBase) entity).getActivePotionEffect(Potion.jump) == null) {
                ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.jump.id, 20, 2));
            }
        }
        super.onEntityWalking(world, x, y, z, entity);
    }

    @Override
    public void registerBlockIcons(IIconRegister ir) {
        this.blockIcon = ir.registerIcon(Reference.ID + ":" + "asphaltRoad");
    }
}
