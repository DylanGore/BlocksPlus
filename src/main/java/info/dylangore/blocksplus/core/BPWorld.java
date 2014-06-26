package info.dylangore.blocksplus.core;

import cpw.mods.fml.common.registry.GameRegistry;
import info.dylangore.blocksplus.handler.WorldGenHandler;

public class BPWorld {

	public static WorldGenHandler worldGen = new WorldGenHandler();

	public static void init(){
		GameRegistry.registerWorldGenerator(worldGen, 1);
	}

}
