/*
 * Project: BlocksPlus
 * File: GuiFactory.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

import java.util.Set;

@SuppressWarnings("unused")
public class GuiFactory implements IModGuiFactory {
    @Override
    public void initialize(Minecraft minecraftInstance) {

    }

    @Override
    public boolean hasConfigGui() {
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen) {
        return new BlocksPlusGuiConfig(parentScreen);
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }
}
