/*
 * Project: BlocksPlus
 * File: BPBlocks.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 10/07/14 21:30
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.init;

import info.dylangore.blocksplus.block.BPBlock;
import info.dylangore.blocksplus.block.*;
import info.dylangore.blocksplus.block.item.*;
import info.dylangore.blocksplus.handler.WorldGenerationHandler;
import info.dylangore.blocksplus.reference.BlockReference;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class BPBlocks {

    public static final String[] colors = {"White", "Orange", "Magenta", "LightBlue", "Yellow", "Lime", "Pink", "Gray", "LightGray", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};

	/* Block Declaration */
	public static BPBlock colorCobble = new BlockColored("cobblestone", "colorCobble");
	public static BPBlock colorStone = new BlockColored("stone", "colorStone");
	public static BPBlock colorStoneBricks = new BlockColored("stonebrick", "colorStoneBrick");
	public static BPBlock colorStoneBricksMoss = new BlockColored("stonebrick_moss", "colorStoneBrickMoss");
	public static BPBlock colorStoneBricksCracked = new BlockColored("stonebrick_cracked", "colorStoneBrickCracked");
	public static BPBlock colorStoneBricksChiseled = new BlockColored("stonebrick_carved", "colorStoneBrickChiseled");

    public static BPBlock toggleBlock = new BlockToggle("toggleBlock");

    public static BPBlock asphaltRoad = new BlockAsphaltRoad("asphaltRoad");
    public static BPBlock healingStation = new BlockHealingStation("healingStation");
	
	//public static Block secureBlock;
	//public static Block phantomBlock;

    public static void init(){
        regBlocks();
        regTileEntities();
    }

	public static void regBlocks(){
		GameRegistry.registerBlock(colorCobble, ItemBlockColorCobble.class, "colorCobblestone");
		GameRegistry.registerBlock(colorStone, ItemBlockColorStone.class, "colorStone");
		GameRegistry.registerBlock(colorStoneBricks, ItemBlockColorStoneBrick.class ,"colorStoneBrick");
		GameRegistry.registerBlock(colorStoneBricksMoss, ItemBlockColorStoneBrickMoss.class, "colorStoneBrickMoss");
		GameRegistry.registerBlock(colorStoneBricksCracked, ItemBlockColorStoneBrickCracked.class, "colorStoneBrickCracked");
		GameRegistry.registerBlock(colorStoneBricksChiseled, ItemBlockColorStoneBrickChiseled.class ,"colorStoneBrickChiseled");

        GameRegistry.registerBlock(toggleBlock, ItemBlockToggle.class, "toggleBlock");

        GameRegistry.registerBlock(asphaltRoad, "asphaltRoad");
        GameRegistry.registerBlock(healingStation, "healingStation");

		/* Ore Dict */
		for(int meta = 0; meta < BlockReference.colorBlockNames.length; meta ++){
			OreDictionary.registerOre("stone", new ItemStack(colorStone, 1, meta));
			OreDictionary.registerOre("cobblestone", new ItemStack(colorCobble, 1, meta));
            OreDictionary.registerOre("brickStone", new ItemStack(colorStoneBricks, 1, meta));
            OreDictionary.registerOre("brickStoneMossy", new ItemStack(colorStoneBricksMoss, 1, meta));
            OreDictionary.registerOre("brickStoneCracked", new ItemStack(colorStoneBricksCracked, 1, meta));
            OreDictionary.registerOre("brickStoneChiseled", new ItemStack(colorStoneBricksChiseled, 1, meta));
		}
	}
	
	public static void regTileEntities(){
	}

    public static void initWorldGenerator(){
        WorldGenerationHandler worldGen = new WorldGenerationHandler();
        GameRegistry.registerWorldGenerator(worldGen, 1);
    }
	
}
