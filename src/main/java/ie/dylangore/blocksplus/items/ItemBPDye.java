/*
 * Project: BlocksPlus
 * File: ItemBPDye.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.items;

import ie.dylangore.blocksplus.items.base.ItemBaseColored;

//TODO 1.13
public class ItemBPDye extends ItemBaseColored {
    public ItemBPDye(Properties properties, String name) {
        super(properties, name);
    }

//    @SuppressWarnings("NullableProblems")
//    @Override
//    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//        ItemStack stack = player.getActiveItemStack();
//        Block block = worldIn.getBlockState(pos).getBlock();
//        EnumDyeColor color = EnumDyeColor.byMetadata(stack.getItemDamage());
//        if (block == Blocks.WOOL && color != worldIn.getBlockState(pos).getValue(BlockColored.COLOR)
//                || block == Blocks.CARPET && color != worldIn.getBlockState(pos).getValue(BlockCarpet.COLOR)) {
//            worldIn.setBlockState(pos, worldIn.getBlockState(pos).withProperty(block == Blocks.WOOL ? BlockColored.COLOR : BlockCarpet.COLOR, color), 1 | 2);
//            stack.shrink(1);
//            return EnumActionResult.SUCCESS;
//        }
//
//        return EnumActionResult.PASS;
//    }
//
//    @Override
//    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target, EnumHand hand) {
//        if (target instanceof EntitySheep) {
//            EntitySheep entitysheep = (EntitySheep) target;
//            EnumDyeColor i = EnumDyeColor.byMetadata(stack.getItemDamage());
//
//            if (!entitysheep.getSheared() && entitysheep.getFleeceColor() != i) {
//                entitysheep.setFleeceColor(i);
//                stack.shrink(1);
//            }
//
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
//        tooltip.add(FormattingHelper.RED.getFormattingCode() + "Work in Progress");
//    }
}
