package ie.dylangore.blocksplus.client.gui;

import ie.dylangore.blocksplus.Reference;
import ie.dylangore.blocksplus.handler.ConfigurationHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.List;

/**
 * Project: BlocksPlus
 * File: BlocksPlusGuiConfig
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 21 February 2017
 */

public class BlocksPlusGuiConfig extends GuiConfig {
    public BlocksPlusGuiConfig(GuiScreen guiScreen)
    {
        super(guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
