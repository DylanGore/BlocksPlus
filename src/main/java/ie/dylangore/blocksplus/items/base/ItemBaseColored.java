/*
 * Project: BlocksPlus
 * File: ItemBaseColored.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.items.base;

public class ItemBaseColored extends ItemBase {

    public ItemBaseColored(Properties properties, String name) {
        super(properties, name);
    }

//    @SuppressWarnings("NullableProblems")
//    @OnlyIn(Dist.CLIENT)
//    @Override
//    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
//        for (int metadata = 0; metadata < EnumDyeColor.values().length; metadata++) {
//            subItems.add(new ItemStack(this, 1, metadata));
//        }
//    }

//    @Nonnull
//    @Override
//    public String getUnlocalizedName(ItemStack stackIn) {
//        int meta = stackIn.getMetadata();
//        return super.getUnlocalizedName(stackIn) + "." + EnumDyeColor.byMetadata(meta);
//    }
}
