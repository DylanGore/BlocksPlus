/*
 * Project: BlocksPlus
 * File: ColorHandler.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.handler;

import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//TODO 1.13
@OnlyIn(Dist.CLIENT)
public class ColorHandler {

    public static void init() {
//        ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
//        BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
//
//        @SuppressWarnings("unused") Map<IRegistryDelegate<Block>, IBlockColor> map = ReflectionHelper.getPrivateValue(BlockColors.class, blockColors, "blockColorMap");

//        registerBlockColourHandlers(blockColors);
//        registerItemColorsHandlers(itemColors, blockColors);
    }

    private static void registerBlockColourHandlers(final BlockColors blockColors) {
//        // Use the grass colour of the biome or the default grass colour
//        final IBlockColor colorBlocks = (state, world, pos, tintIndex) -> {
//            int meta = state.getBlock().getMetaFromState(state);
//            return EnumDyeColor.byMetadata(meta).getColorValue();
//        };
//
//        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockColoredCobblestone);
//        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockColoredStone);
//        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockColoredStoneBricks);
//        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockColoredStoneBricksChiseled);
//        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockColoredStoneBricksCracked);
//        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockRimmedGlass);
//        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockRimmedGlowingGlass);
//        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockColoredSand);
    }

    @SuppressWarnings("deprecation")
    private static void registerItemColorsHandlers(ItemColors itemColors, BlockColors blockColors) {
//
//        final IItemColor dyeItemColorHandler = (stack, i) -> EnumDyeColor.byMetadata(stack.getItemDamage()).getColorValue();
//
//        // Use the Block's colour handler for an ItemBlock
//        final IItemColor itemBlockColourHandler = (stack, tintIndex) -> blockColors.colorMultiplier(((ItemBlock)stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata()), null, null, tintIndex);
//
//        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockColoredCobblestone);
//        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockColoredStone);
//        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockColoredStoneBricks);
//        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockColoredStoneBricksChiseled);
//        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockColoredStoneBricksCracked);
//        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockRimmedGlass);
//        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockRimmedGlowingGlass);
//        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockColoredSand);




//        itemColors.registerItemColorHandler(dyeItemColorHandler, ModItems.itemDye);

    }


}
