package dylangore.mods.blocksplus.registry;

import dylangore.mods.blocksplus.blocks.BlockColored;
import dylangore.mods.blocksplus.blocks.item.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import dylangore.mods.blocksplus.lib.BlockInfo;

public class BPBlocks {

	/* Block Declaration */
	public static Block colorCobble = new BlockColored("cobblestone", "colorCobble");
	public static Block colorStone = new BlockColored("stone", "colorStone");
	public static Block colorStoneBricks = new BlockColored("stonebrick", "colorStoneBrick");
	public static Block colorStoneBricksMoss = new BlockColored("stonebrick_moss", "colorStoneBrickMoss");
	public static Block colorStoneBricksCracked = new BlockColored("stonebrick_cracked", "colorStoneBrickCracked");
	public static Block colorStoneBricksChiseled = new BlockColored("stonebrick_carved", "colorStoneBrickChiseled");
	
	//public static Block secureBlock;
	//public static Block phantomBlock;

    public static void init(){
        regBlocks();
        regTileEntities();
        addRecipes();
    }

	public static void regBlocks(){
		GameRegistry.registerBlock(colorCobble, ItemBlockColorCobble.class, "colorCobblestone");
		GameRegistry.registerBlock(colorStone, ItemBlockColorStone.class, "colorStone");
		GameRegistry.registerBlock(colorStoneBricks, ItemBlockColorStoneBrick.class ,"colorStoneBrick");
		GameRegistry.registerBlock(colorStoneBricksMoss, ItemBlockColorStoneBrickMoss.class, "colorStoneBrickMoss");
		GameRegistry.registerBlock(colorStoneBricksCracked, ItemBlockColorStoneBrickCracked.class, "colorStoneBrickCracked");
		GameRegistry.registerBlock(colorStoneBricksChiseled, ItemBlockColorStoneBrickChiseled.class ,"colorStoneBrickChiseled");

		/* Ore Dict */
		for(int meta = 0; meta < BlockInfo.colorBlockNames.length; meta ++){
			OreDictionary.registerOre("stone", new ItemStack(colorStone, 1, meta));
			OreDictionary.registerOre("cobblestone", new ItemStack(colorCobble, 1, meta));
            OreDictionary.registerOre("stoneBricks", new ItemStack(colorStoneBricks, 1, meta));
            OreDictionary.registerOre("stoneBricks_moss", new ItemStack(colorStoneBricksMoss, 1, meta));
            OreDictionary.registerOre("stoneBricks_cracked", new ItemStack(colorStoneBricksCracked, 1, meta));
            OreDictionary.registerOre("stoneBricks_chiseled", new ItemStack(colorStoneBricksChiseled, 1, meta));
		}
	}
	
	public static void regTileEntities(){
	}
	public static void addRecipes(){
		final String[] colors = {"White", "Orange", "Magenta", "LightBlue", "Yellow", "Lime", "Pink", "Gray", "LightGray", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};
		
		for (int i = 0; i < colors.length; i ++){

        }
	}
	
}
