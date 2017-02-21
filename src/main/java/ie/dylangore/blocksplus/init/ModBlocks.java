package ie.dylangore.blocksplus.init;

import ie.dylangore.blocksplus.BlocksPlus;
import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.Reference.EnumColors;
import ie.dylangore.blocksplus.blocks.BlockAsphaltRoad;
import ie.dylangore.blocksplus.blocks.BlockHealingStation;
import ie.dylangore.blocksplus.blocks.base.BlockBaseColored;
import ie.dylangore.blocksplus.blocks.base.BlockTileEntity;
import ie.dylangore.blocksplus.blocks.itemblocks.ItemBlockColored;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Project: BlocksPlus
 * File: ModBlocks
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class ModBlocks {

    public static BlockAsphaltRoad blockAsphaltRoad;
    public static BlockHealingStation blockHealingStation;
    public static BlockBaseColored blockColoredCobblestone;
    public static BlockBaseColored blockColoredStone;
    public static BlockBaseColored blockColoredStoneBricks;
    public static BlockBaseColored blockColoredStoneBricksChiseled;
    public static BlockBaseColored blockColoredStoneBricksCracked;

    public static void init(){

        blockAsphaltRoad = new BlockAsphaltRoad(Material.ROCK, Reference.BlocksPlusBlocks.ASPHALT_ROAD.getName());
        blockHealingStation = new BlockHealingStation(Material.IRON, Reference.BlocksPlusBlocks.HEALING_STATION.getName());
        blockColoredCobblestone = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLOURED_COBBLESTONE.getName(), 2.0F, 1.0F);
        blockColoredStone = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE.getName(), 1.5F, 1.0F);
        blockColoredStoneBricks = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS.getName(), 1.5F, 1.0F);
        blockColoredStoneBricksChiseled = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CHISELED.getName(), 1.5F, 1.0F);
        blockColoredStoneBricksCracked = new BlockBaseColored(Material.ROCK, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CRACKED.getName(), 1.5F, 1.0F);

        registerSimpleItemBlock(blockAsphaltRoad, Reference.BlocksPlusBlocks.ASPHALT_ROAD.getName());
        //registerSimpleItemBlock(blockHealingStation, Reference.BlocksPlusBlocks.HEALING_STATION.getName());

        registerColorItemBlock(blockColoredCobblestone, Reference.BlocksPlusBlocks.COLOURED_COBBLESTONE.getName());
        registerColorItemBlock(blockColoredStone, Reference.BlocksPlusBlocks.COLORED_STONE.getName());
        registerColorItemBlock(blockColoredStoneBricks, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS.getName());
        registerColorItemBlock(blockColoredStoneBricksChiseled, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CHISELED.getName());
        registerColorItemBlock(blockColoredStoneBricksCracked, Reference.BlocksPlusBlocks.COLORED_STONE_BRICKS_CRACKED.getName());

        addColorRecipes(blockColoredCobblestone, Blocks.COBBLESTONE, "cobblestone");
        addColorRecipes(blockColoredStone, Blocks.STONE, "stone");
        addColorRecipes(blockColoredStoneBricks, Blocks.STONEBRICK, "stonebrick");

        addColorBrickRecipes(blockColoredStoneBricks, blockColoredStone);
        addColorBrickChiseledRecipes(blockColoredStoneBricksChiseled, blockColoredStoneBricks);
        addColorStoneBrickCrackedRecipes(blockColoredStoneBricks, blockColoredStoneBricksCracked, 0.1F);

        addColorSmeltingRecipes(blockColoredCobblestone, blockColoredStone, 0.1F);

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockHealingStation, 1),
                "sss", "ana", "sss",
                's', "stone", 'a', new ItemStack(Items.GOLDEN_APPLE, 1, 1), 'n', "netherStar" ));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockAsphaltRoad, 9),
                "gsg", "sgs", "gsg",
                'g', "gravel", 's', "stone"));

        registerOreDict(blockColoredCobblestone, "cobblestone", true);
        registerOreDict(blockColoredStone, "stone", true);

        LogHelper.info("Blocks registered!");
    }

    public static void registerSimpleItemBlock(Block block, String registryName){
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(registryName);
        GameRegistry.register(itemBlock);
        GameRegistry.register(block);

        if (block instanceof BlockTileEntity) {
            GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
        }

        BlocksPlus.proxy.registerItemRenderer(itemBlock, 0, registryName);
    }

    private static void registerColorItemBlock(Block block, String registryName){
        ItemBlockColored itemBlock = new ItemBlockColored(block);
        itemBlock.setRegistryName(registryName);
        GameRegistry.register(itemBlock);
        GameRegistry.register(block);

        if (block instanceof BlockTileEntity) {
            GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
        }

        for(int meta = 0; meta < EnumColors.values().length; meta++){
            BlocksPlus.proxy.registerColorItemRenderer(itemBlock, meta, registryName);
        }

    }

    private static void addColorRecipes(Block colorBlock, Block baseBlock, String baseBlockOreDict){
        for(int meta = 0; meta < EnumColors.values().length; meta++) {

            String currColor;
            if(meta == 8){
                currColor = "LightGray";
            }else{
                currColor = EnumColors.byMetadata(meta).getCapitalName();
            }
            String currDye = "dye" + currColor;
            LogHelper.debug("Current Dye:" + currDye);
            LogHelper.debug("Current Meta:" + meta);

            if(OreDictionary.doesOreNameExist(baseBlockOreDict)){
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(baseBlock, 1), new ItemStack(colorBlock, 1, meta)));

                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(colorBlock, 8, meta),
                        baseBlockOreDict, baseBlockOreDict, baseBlockOreDict,
                        baseBlockOreDict, currDye, baseBlockOreDict,
                        baseBlockOreDict, baseBlockOreDict, baseBlockOreDict
                ));
            }else{
                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(baseBlock, 1), new ItemStack(colorBlock, 1, meta)));

                GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(colorBlock, 8, meta),
                        baseBlock, baseBlock, baseBlock,
                        baseBlock, currDye, baseBlock,
                        baseBlock, baseBlock, baseBlock
                ));
            }

        }
    }

    private static void addColorBrickRecipes(Block colorBlockOutput, Block colorBlockInput){
        for(int meta = 0; meta < EnumColors.values().length; meta++) {

            ItemStack colorBaseStack = new ItemStack(colorBlockInput, 1, meta);

            GameRegistry.addRecipe(new ItemStack(colorBlockOutput, 4, meta),
                    "ss", "ss", 's', colorBaseStack
            );
        }
    }

    private static void addColorBrickChiseledRecipes(Block colorBlockOutput, Block colorBlockInput){
        for(int meta = 0; meta < EnumColors.values().length; meta++) {

            ItemStack colorBaseStack = new ItemStack(colorBlockInput, 1, meta);

            GameRegistry.addRecipe(new ItemStack(colorBlockOutput, 2, meta),
                    "s", "s", 's', colorBaseStack
            );
        }
    }

    private static void addColorStoneBrickCrackedRecipes(Block colorBlockInput, Block colorBlockOutput, float xp){
        for(int meta = 0; meta < EnumColors.values().length; meta++) {
            GameRegistry.addSmelting(new ItemStack(colorBlockInput, 1, meta), new ItemStack(colorBlockOutput,1,meta) ,xp);
        }
    }

    private static void addColorSmeltingRecipes(Block input, Block output, float xp){
        for(int meta = 0; meta < EnumColors.values().length; meta++) {
            GameRegistry.addSmelting(new ItemStack(input, 1, meta), new ItemStack(output,1,meta) ,xp);
        }
    }

    private static void registerOreDict(Block block, String oreDictName, boolean isWildcard){
        if(isWildcard){
            OreDictionary.registerOre(oreDictName, new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
        }else{
            OreDictionary.registerOre(oreDictName, block);
        }
    }
}
