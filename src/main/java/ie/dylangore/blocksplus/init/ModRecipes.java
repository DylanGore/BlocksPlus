/*
 * Project: BlocksPlus
 * File: ModRecipes.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.init;

import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init() {
        /* Colored Cobblestone -> Colored Stone smelting recipe */
        addColorSmeltingRecipes(ModBlocks.blockColoredCobblestone, ModBlocks.blockColoredStone, 0.1F);

        /* Colored Stone Bricks -> Colored Cracked Stone Bricks smelting recipe */
        addColorSmeltingRecipes(ModBlocks.blockColoredStoneBricks, ModBlocks.blockColoredStoneBricksCracked, 0.1F);

        /* Colored Sand -> Rimmed Glass */
        addColorSmeltingRecipes(ModBlocks.blockColoredSand, ModBlocks.blockRimmedGlass, 0.1F);
    }

    //TODO 1.13
    private static void addColorSmeltingRecipes(Block input, Block output, float xp) {
//        for (int meta = 0; meta < EnumDyeColor.values().length; meta++) {
//            GameRegistry.addSmelting(new ItemStack(input, 1, meta), new ItemStack(output, 1, meta), xp);
//        }
    }

}
