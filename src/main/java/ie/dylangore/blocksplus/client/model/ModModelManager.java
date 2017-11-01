package ie.dylangore.blocksplus.client.model;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.blocks.base.BlockBaseColored;
import ie.dylangore.blocksplus.init.ModBlocks;
import ie.dylangore.blocksplus.init.ModItems;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Project: BlocksPlus
 * File: BPModelManager
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 22 February 2017
 */

@SideOnly(Side.CLIENT)
public class ModModelManager {


    public static void init() {

        registerColorBlockModel(ModBlocks.blockColoredCobblestone);
        registerColorBlockModel(ModBlocks.blockColoredStone);
        registerColorBlockModel(ModBlocks.blockColoredStoneBricks);
        registerColorBlockModel(ModBlocks.blockColoredStoneBricksChiseled);
        registerColorBlockModel(ModBlocks.blockColoredStoneBricksCracked);
        registerColorBlockModel(ModBlocks.blockRimmedGlass);
        registerColorBlockModel(ModBlocks.blockRimmedGlowingGlass);

        registerBlockModel(ModBlocks.blockAsphaltRoad);
        registerBlockModel(ModBlocks.blockHealingStation);
        registerBlockModel(ModBlocks.blockGlowingGlass);

        registerColorItemModel(ModItems.itemDye);

        LogHelper.info("Models Registered!");
    }

    private static void registerBlockModel(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.ID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }

    private static void registerColorBlockModel(Block block) {
        ModelLoader.setCustomStateMapper(block, new StateMap.Builder().ignore(BlockBaseColored.BLOCK_COLOR).build());

        for (int i = 0; i < EnumDyeColor.values().length; i++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), i, new ModelResourceLocation(Reference.ID + ":" + block.getUnlocalizedName().substring(5), "normal"));
        }
    }

    private static void registerColorItemModel(Item item) {
        for (int i = 0; i < EnumDyeColor.values().length; i++) {
            ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(Reference.ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
        }
    }
}
