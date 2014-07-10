/*
 * Project: BlocksPlus
 * File: BPGuiConfig.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.client.gui.config;

import cpw.mods.fml.client.config.*;
import info.dylangore.blocksplus.handler.ConfigurationHandler;
import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class BPGuiConfig extends GuiConfig {
    public BPGuiConfig(GuiScreen parentScreen)
    {
        super(parentScreen, getConfigElements(), Reference.ID, false, false, I18n.format("blocksplus.gui.config.title"), getAbridgedConfigPath("CURRENTLY SERVES NO PURPOSE! CONFIG SETTINGS YET TO BE IMPLEMENTED!"));
    }

    private static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> list = new ArrayList<IConfigElement>();

        list.add(new DummyConfigElement.DummyCategoryElement("bpGeneral", "blocksplus.gui.config.general", BPEntryGeneral.class));
        list.add(new DummyConfigElement.DummyCategoryElement("bpIntegration", "blocksplus.gui.config.integration", BPEntryIntegration.class));
        list.add(new DummyConfigElement.DummyCategoryElement("bpWorldGen", "blocksplus.gui.config.worldgen", BPEntryWorldGen.class));

        return list;
    }

    public static class BPEntryWorldGen extends GuiConfigEntries.CategoryEntry {

        public BPEntryWorldGen(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
        {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen()
        {
            // This GuiConfig object specifies the configID of the object and as such will force-save when it is closed. The parent
            // GuiConfig object's entryList will also be refreshed to reflect the changes.
            return new GuiConfig(this.owningScreen,
                    (new ConfigElement(ConfigurationHandler.configuration.getCategory(ConfigurationHandler.CATEGORY_WORLDGEN)).getChildElements()),
                    Reference.ID, true, false, I18n.format("blocksplus.gui.config.worldgen.title"));
        }

    }

    public static class BPEntryGeneral extends GuiConfigEntries.CategoryEntry {

        public BPEntryGeneral(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
        {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen()
        {
            // This GuiConfig object specifies the configID of the object and as such will force-save when it is closed. The parent
            // GuiConfig object's entryList will also be refreshed to reflect the changes.
            return new GuiConfig(this.owningScreen,
                    (new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements()),
                    Reference.ID, false, false, I18n.format("blocksplus.gui.config.general.title"));
        }

    }

    public static class BPEntryIntegration extends GuiConfigEntries.CategoryEntry {

        public BPEntryIntegration(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
        {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen()
        {
            // This GuiConfig object specifies the configID of the object and as such will force-save when it is closed. The parent
            // GuiConfig object's entryList will also be refreshed to reflect the changes.
            return new GuiConfig(this.owningScreen,
                    (new ConfigElement(ConfigurationHandler.configuration.getCategory(ConfigurationHandler.CATEGORY_INTEGRATION)).getChildElements()),
                    Reference.ID, false, true, I18n.format("blocksplus.gui.config.integration.title"));

        }
    }
}