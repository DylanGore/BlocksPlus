package ie.dylangore.blocksplus.proxy;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.handler.ColorHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Project: BlocksPlus
 * File: ClientProxy
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class ClientProxy extends CommonProxy {
    @Override
    public void init(FMLInitializationEvent event){
        ColorHandler.init();
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.ID + ":" + id, "inventory"));
    }

    @Override
    public void registerColorItemRenderer(Item item, int meta, String id) {
        String colorName = Reference.EnumColors.byMetadata(meta).getName();
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.ID + ":" + id, "inventory" + "_" + colorName));
    }
}
