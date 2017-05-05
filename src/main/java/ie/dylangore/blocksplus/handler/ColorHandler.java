package ie.dylangore.blocksplus.handler;

import ie.dylangore.blocksplus.init.ModBlocks;
import ie.dylangore.blocksplus.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Project: BlocksPlus
 * File: ColorHandler
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 22 February 2017
 */

@SideOnly(Side.CLIENT)
public class ColorHandler {

    public static void init() {
        ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
        BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();

        registerBlockColourHandlers(blockColors);
        registerItemColorsHandlers(itemColors, blockColors);
    }

    private static void registerBlockColourHandlers(final BlockColors blockColors) {
        // Use the grass colour of the biome or the default grass colour
        final IBlockColor colorBlocks = (state, blockAccess, pos, tintIndex) -> {
            if (blockAccess != null && pos != null) {
                return EnumDyeColor.byMetadata(state.getBlock().getMetaFromState(state)).getMapColor().colorValue;
            }

            return EnumDyeColor.byMetadata(state.getBlock().getMetaFromState(state)).getMapColor().colorValue;
        };

        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockColoredCobblestone);
        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockColoredStone);
        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockColoredStoneBricks);
        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockColoredStoneBricksChiseled);
        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockColoredStoneBricksCracked);
        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockRimmedGlass);
        blockColors.registerBlockColorHandler(colorBlocks, ModBlocks.blockRimmedGlowingGlass);
    }

    private static void registerItemColorsHandlers(ItemColors itemColors, BlockColors blockColors) {

        final IItemColor dyeItemColorHandler = (state, i) -> {
            return EnumDyeColor.byMetadata(state.getItemDamage()).getMapColor().colorValue;
        };

        // Use the Block's colour handler for an ItemBlock
        final IItemColor itemBlockColourHandler = (stack, tintIndex) -> {
            @SuppressWarnings("deprecation")
            final IBlockState state = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
            return blockColors.colorMultiplier(state, null, null, tintIndex);
        };

        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockColoredCobblestone);
        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockColoredStone);
        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockColoredStoneBricks);
        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockColoredStoneBricksChiseled);
        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockColoredStoneBricksCracked);
        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockRimmedGlass);
        itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.blockRimmedGlowingGlass);

        itemColors.registerItemColorHandler(dyeItemColorHandler, ModItems.itemDye);

    }


}
