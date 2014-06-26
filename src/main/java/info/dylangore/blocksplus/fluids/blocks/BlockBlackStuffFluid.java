package info.dylangore.blocksplus.fluids.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import info.dylangore.blocksplus.lib.ModInfo;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.*;

public class BlockBlackStuffFluid extends BlockFluidClassic{


    public BlockBlackStuffFluid(Fluid fluid) {
        super(fluid, Material.water);
    }

    public static IIcon blackStuffFlowing;
    public static IIcon blackStuffStill;

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        int meta = world.getBlockMetadata(x, y, z);

        if (!world.isRemote)
        {
            if (entity instanceof EntityLivingBase)
            {
                if (!((EntityLivingBase)entity).isPotionActive(Potion.blindness.id))
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 500));

                if (!((EntityLivingBase)entity).isPotionActive(Potion.confusion.id))
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.confusion.id, 500));

                if (!((EntityLivingBase)entity).isPotionActive(Potion.poison.id))
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 500));

                if (!((EntityLivingBase)entity).isPotionActive(Potion.moveSlowdown.id))
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 500));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        blackStuffFlowing = ir.registerIcon(ModInfo.ID + ":" + "blackStuff_flow");
        blackStuffStill = ir.registerIcon(ModInfo.ID + ":" + "blackStuff_still");
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        return side != 0 && side != 1 ? blackStuffFlowing : blackStuffStill;
    }
}
