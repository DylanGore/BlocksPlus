package info.dylangore.blocksplus.core;

import cpw.mods.fml.common.registry.GameRegistry;
import info.dylangore.blocksplus.items.BPItem;
import net.minecraft.item.Item;

public class BPItems {

    public static Item itemRemover = new BPItem("remover", "wand", 1);

    public static void init(){
        regItems();
        addRecipes();
    }

	public static void regItems(){

        GameRegistry.registerItem(itemRemover, "remover");

	}
	
	public static void addRecipes(){
	}
	
}
