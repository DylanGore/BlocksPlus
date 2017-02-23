package ie.dylangore.blocksplus.items;

import ie.dylangore.blocksplus.items.base.ItemBaseColored;
import ie.dylangore.blocksplus.util.FormattingHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Project: BlocksPlus
 * File: ItemBPDye
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 22 February 2017
 */

public class ItemBPDye extends ItemBaseColored {
    public ItemBPDye(String name) {
        super(name);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getActiveItemStack();
        Block block = worldIn.getBlockState(pos).getBlock();
        EnumDyeColor color = EnumDyeColor.byMetadata(stack.getItemDamage());
        if (block == Blocks.WOOL && color != worldIn.getBlockState(pos).getValue(BlockColored.COLOR)
                || block == Blocks.CARPET && color != worldIn.getBlockState(pos).getValue(BlockCarpet.COLOR)) {
            worldIn.setBlockState(pos, worldIn.getBlockState(pos).withProperty(block == Blocks.WOOL ? BlockColored.COLOR : BlockCarpet.COLOR, color), 1 | 2);
            stack.shrink(1);
            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.PASS;
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target, EnumHand hand) {
        if (target instanceof EntitySheep) {
            EntitySheep entitysheep = (EntitySheep) target;
            EnumDyeColor i = EnumDyeColor.byMetadata(stack.getItemDamage());

            if (!entitysheep.getSheared() && entitysheep.getFleeceColor() != i) {
                entitysheep.setFleeceColor(i);
                stack.shrink(1);
            }

            return true;
        }
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(FormattingHelper.RED.getFormattingCode() + "Work in Progress");
    }
}
