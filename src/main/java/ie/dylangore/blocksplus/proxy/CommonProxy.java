package ie.dylangore.blocksplus.proxy;

import ie.dylangore.blocksplus.handler.ConfigurationHandler;
import ie.dylangore.blocksplus.init.ModBlocks;
import ie.dylangore.blocksplus.init.ModItems;
import ie.dylangore.blocksplus.util.LogHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Project: BlocksPlus
 * File: CommonProxy
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */
public abstract class CommonProxy implements IProxy {


    @Override
    public void onPreInit(FMLPreInitializationEvent event) {
        LogHelper.info("Blocks Plus is loading...");

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        ModItems.init();
        ModBlocks.init();
        //TODO Reimplement Recipes
        //Recipes.init();
    }

    @Override
    public void onInit(FMLInitializationEvent event) {

    }

    @Override
    public void onPostInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initModels() {

    }
}
