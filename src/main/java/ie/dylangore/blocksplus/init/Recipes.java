package ie.dylangore.blocksplus.init;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Project: BlocksPlus
 * File: Recipes
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 21 February 2017
 */

public class Recipes {

    public static void init() {
        Recipes.addColorRecipes(ModBlocks.blockColoredCobblestone, Blocks.COBBLESTONE, "cobblestone");
        Recipes.addColorRecipes(ModBlocks.blockColoredStone, Blocks.STONE, "stone");
        Recipes.addColorRecipes(ModBlocks.blockColoredStoneBricks, Blocks.STONEBRICK, "stonebrick");

        Recipes.addColorBrickRecipes(ModBlocks.blockColoredStoneBricks, ModBlocks.blockColoredStone);
        Recipes.addColorBrickChiseledRecipes(ModBlocks.blockColoredStoneBricksChiseled, ModBlocks.blockColoredStoneBricks);
        Recipes.addColorStoneBrickCrackedRecipes(ModBlocks.blockColoredStoneBricks, ModBlocks.blockColoredStoneBricksCracked, 0.1F);

        /* Colored Cobblestone -> Colored Stone smelting recipe */
        Recipes.addColorSmeltingRecipes(ModBlocks.blockColoredCobblestone, ModBlocks.blockColoredStone, 0.1F);

        /* Healing Station crafting recipe */
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockHealingStation, 1),
                "sss", "ana", "sss",
                's', "stone", 'a', new ItemStack(Items.GOLDEN_APPLE, 1, 1), 'n', "netherStar"));

        /* Asphalt Road crafting recipe */
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockAsphaltRoad, 9),
                "gsg", "sgs", "gsg",
                'g', "gravel", 's', "stone"));
    }

    private static void addColorRecipes(Block colorBlock, Block baseBlock, String baseBlockOreDict) {
        for (int meta = 0; meta < EnumDyeColor.values().length; meta++) {

            String currColor;
            if (meta == 8) {
                currColor = "LightGray";
            } else {
                currColor = Reference.getColorNameFromMeta(meta, true);
            }
            String currDye = "dye" + currColor;
            LogHelper.debug("Current Dye:" + currDye);
            LogHelper.debug("Current Meta:" + meta);

            if (OreDictionary.doesOreNameExist(baseBlockOreDict)) {
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(baseBlock, 1), new ItemStack(colorBlock, 1, meta)));

                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(colorBlock, 8, meta),
                        baseBlockOreDict, baseBlockOreDict, baseBlockOreDict,
                        baseBlockOreDict, currDye, baseBlockOreDict,
                        baseBlockOreDict, baseBlockOreDict, baseBlockOreDict
                ));
            } else {
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(baseBlock, 1), new ItemStack(colorBlock, 1, meta)));

                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(colorBlock, 8, meta),
                        baseBlock, baseBlock, baseBlock,
                        baseBlock, currDye, baseBlock,
                        baseBlock, baseBlock, baseBlock
                ));
            }

        }
    }

    private static void addColorBrickRecipes(Block colorBlockOutput, Block colorBlockInput) {
        for (int meta = 0; meta < EnumDyeColor.values().length; meta++) {

            ItemStack colorBaseStack = new ItemStack(colorBlockInput, 1, meta);

            GameRegistry.addRecipe(new ItemStack(colorBlockOutput, 4, meta),
                    "ss", "ss", 's', colorBaseStack
            );
        }
    }

    private static void addColorBrickChiseledRecipes(Block colorBlockOutput, Block colorBlockInput) {
        for (int meta = 0; meta < EnumDyeColor.values().length; meta++) {

            ItemStack colorBaseStack = new ItemStack(colorBlockInput, 1, meta);

            GameRegistry.addRecipe(new ItemStack(colorBlockOutput, 2, meta),
                    "s", "s", 's', colorBaseStack
            );
        }
    }

    private static void addColorStoneBrickCrackedRecipes(Block colorBlockInput, Block colorBlockOutput, float xp) {
        for (int meta = 0; meta < EnumDyeColor.values().length; meta++) {
            GameRegistry.addSmelting(new ItemStack(colorBlockInput, 1, meta), new ItemStack(colorBlockOutput, 1, meta), xp);
        }
    }

    private static void addColorSmeltingRecipes(Block input, Block output, float xp) {
        for (int meta = 0; meta < EnumDyeColor.values().length; meta++) {
            GameRegistry.addSmelting(new ItemStack(input, 1, meta), new ItemStack(output, 1, meta), xp);
        }
    }

}
