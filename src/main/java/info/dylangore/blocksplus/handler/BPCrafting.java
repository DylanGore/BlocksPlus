package info.dylangore.blocksplus.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BPCrafting {

    public static void init(){
        colorCraftingBasic();
        colorSmeltingBasic();
}

    public static void colorCraftingBasic(){
        final String[] colors = {"White", "Orange", "Magenta", "LightBlue", "Yellow", "Lime", "Pink", "Gray", "LightGray", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};


        for (int i = 0; i < colors.length; i ++){

            ItemStack stonebrick = new ItemStack(Blocks.stonebrick, 1, 0);
            ItemStack stonebrick_moss = new ItemStack(Blocks.stonebrick, 1, 1);
            ItemStack stonebrick_cracked = new ItemStack(Blocks.stonebrick, 1, 2);
            ItemStack stonebrick_chiseled = new ItemStack(Blocks.stonebrick, 1, 3);

            //

            /* Cobblestone -> Colored Cobblestone */
            GameRegistry.addShapelessRecipe(new ItemStack(BPBlocks.colorCobble, 1, i),
                    Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone,
                    Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone,
                    Blocks.cobblestone, Blocks.cobblestone, new ItemStack(Items.dye, 1, 15 - i)
            );

            /* Color Cobblestone -> Cobblestone */
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 5),
                    new ItemStack(BPBlocks.colorCobble,1 ,i), new ItemStack(BPBlocks.colorCobble,1 ,i), new ItemStack(BPBlocks.colorCobble,1 ,i),
                    new ItemStack(BPBlocks.colorCobble,1 ,i), new ItemStack(BPBlocks.colorCobble,1 ,i));

            //

            /* Stone -> Colored Stone */
            GameRegistry.addShapelessRecipe(new ItemStack(BPBlocks.colorStone, 8, i),
                    Blocks.stone, Blocks.stone, Blocks.stone,
                    Blocks.stone, Blocks.stone, Blocks.stone,
                    Blocks.stone, Blocks.stone, new ItemStack(Items.dye, 1, 15 - i)
            );

            /* Color Stone -> Stone */
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stone, 5),
                    new ItemStack(BPBlocks.colorStone,1 ,i), new ItemStack(BPBlocks.colorStone,1 ,i), new ItemStack(BPBlocks.colorStone,1 ,i),
                    new ItemStack(BPBlocks.colorStone,1 ,i), new ItemStack(BPBlocks.colorStone,1 ,i));

            //

            /* Stone Bricks (Smooth) -> Colored Stone Bricks (Smooth)*/
            GameRegistry.addShapelessRecipe(new ItemStack(BPBlocks.colorStoneBricks, 8, i),
                    stonebrick, stonebrick, stonebrick,
                    stonebrick, stonebrick, stonebrick,
                    stonebrick, stonebrick, new ItemStack(Items.dye, 1, 15 - i)
            );

            /* Color Stone Bricks (Smooth) -> Stone Bricks */
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 5, 0),
                    new ItemStack(BPBlocks.colorStoneBricks,1 ,i), new ItemStack(BPBlocks.colorStoneBricks,1 ,i), new ItemStack(BPBlocks.colorStoneBricks,1 ,i),
                    new ItemStack(BPBlocks.colorStoneBricks,1 ,i), new ItemStack(BPBlocks.colorStoneBricks,1 ,i));

            //

            /* Stone Bricks (Mossy) -> Colored Stone Bricks (Mossy)*/
            GameRegistry.addShapelessRecipe(new ItemStack(BPBlocks.colorStoneBricksMoss, 8, i),
                    stonebrick_moss, stonebrick_moss, stonebrick_moss,
                    stonebrick_moss, stonebrick_moss, stonebrick_moss,
                    stonebrick_moss, stonebrick_moss, new ItemStack(Items.dye, 1, 15 - i)
            );

            /* Color Stone Bricks (Mossy) -> Stone Bricks (Mossy) */
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 5, 1),
                    new ItemStack(BPBlocks.colorStoneBricksMoss,1 ,i), new ItemStack(BPBlocks.colorStoneBricksMoss,1 ,i), new ItemStack(BPBlocks.colorStoneBricksMoss,1 ,i),
                    new ItemStack(BPBlocks.colorStoneBricksMoss,1 ,i), new ItemStack(BPBlocks.colorStoneBricksMoss,1 ,i));

            //

            /* Stone Bricks (Cracked) -> Colored Stone Bricks (Cracked)*/
            GameRegistry.addShapelessRecipe(new ItemStack(BPBlocks.colorStoneBricksCracked, 8, i),
                    stonebrick_cracked, stonebrick_cracked, stonebrick_cracked,
                    stonebrick_cracked, stonebrick_cracked, stonebrick_cracked,
                    stonebrick_cracked, stonebrick_cracked, new ItemStack(Items.dye, 1, 15 - i)
            );

            /* Color Stone Bricks (Cracked) -> Stone Bricks (Cracked) */
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 5, 2),
                    new ItemStack(BPBlocks.colorStoneBricksCracked,1 ,i), new ItemStack(BPBlocks.colorStoneBricksCracked,1 ,i), new ItemStack(BPBlocks.colorStoneBricksCracked,1 ,i),
                    new ItemStack(BPBlocks.colorStoneBricksCracked,1 ,i), new ItemStack(BPBlocks.colorStoneBricksCracked,1 ,i));

            //

            /* Stone Bricks (Chiseled) -> Colored Stone Bricks (Chiseled)*/
            GameRegistry.addShapelessRecipe(new ItemStack(BPBlocks.colorStoneBricksChiseled, 8, i),
                    stonebrick_chiseled, stonebrick_chiseled, stonebrick_chiseled,
                    stonebrick_chiseled, stonebrick_chiseled, stonebrick_chiseled,
                    stonebrick_chiseled, stonebrick_chiseled, new ItemStack(Items.dye, 1, 15 - i)
            );

            /* Color Stone Bricks (Chiseled) -> Stone Bricks (Chiseled) */
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 5, 3),
                    new ItemStack(BPBlocks.colorStoneBricksChiseled,1 ,i), new ItemStack(BPBlocks.colorStoneBricksChiseled,1 ,i), new ItemStack(BPBlocks.colorStoneBricksChiseled,1 ,i),
                    new ItemStack(BPBlocks.colorStoneBricksChiseled,1 ,i), new ItemStack(BPBlocks.colorStoneBricksChiseled,1 ,i));

            //
        }
    }

    public static void colorSmeltingBasic(){
        final String[] colors = {"White", "Orange", "Magenta", "LightBlue", "Yellow", "Lime", "Pink", "Gray", "LightGray", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};

        for (int i = 0; i < colors.length; i ++){
            /* Colored Cobblestone -> Colored Stone*/
            GameRegistry.addSmelting(new ItemStack(BPBlocks.colorCobble, 1, i), (new ItemStack(BPBlocks.colorStone,1 ,i)), 0.1F);

            /* Colored Stone Bricks (Cracked) -> Colored Stone Bricks (Smooth)*/
            GameRegistry.addSmelting(new ItemStack(BPBlocks.colorStoneBricksCracked, 1, i), (new ItemStack(BPBlocks.colorStoneBricks,1 ,i)), 0.1F);

        }
    }

}
