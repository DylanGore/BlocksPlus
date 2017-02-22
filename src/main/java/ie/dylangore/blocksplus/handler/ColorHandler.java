package ie.dylangore.blocksplus.handler;

import ie.dylangore.blocksplus.blocks.base.BlockBaseColored;
import ie.dylangore.blocksplus.init.ModBlocks;
import ie.dylangore.blocksplus.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.EnumDyeColor;
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

        registerItemColorsHandlers(itemColors);
    }

    private static void registerItemColorsHandlers(ItemColors itemColors){

        final IItemColor dyeItemColorHandler = (state, i) ->{
            return EnumDyeColor.byMetadata(state.getItemDamage()).getMapColor().colorValue;
        };

        itemColors.registerItemColorHandler(dyeItemColorHandler, ModItems.itemDye);

    }
}
