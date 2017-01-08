package ie.dylangore.blocksplus;

/**
 * Project: BlocksPlus
 * File: Reference
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class Reference {

    public static final String ID = "blocksplus";
    public static final String NAME = "BlocksPlus 3";
    public static final String VERSION = "3.0.0";
    public static final String UPDATE_JSON_URL = "https://dylangore.ie/mods/blocksplus/updates.json"; //Temporary link

    public static final String CLIENT_PROXY_LOC = "ie.dylangore.blocksplus.proxy.ClientProxy";
    public static final String COMMON_PROXY_LOC = "ie.dylangore.blocksplus.proxy.CommonProxy";

    public static enum BlocksPlusBlocks{

        ASPHALT_ROAD("asphalt_road");

        private String unlocalizedName;
        private String registryName;

        BlocksPlusBlocks(String name){
            this.unlocalizedName = name;
            this.registryName = name;
        }

        public String getUnlocalizedName(){
            return unlocalizedName;
        }

        public String getRegistryName(){
            return registryName;
        }


    }

    public static enum BlocksPlusItems{

        ICE_CREAM("ice_cream");

        private String unlocalizedName;
        private String registryName;

        BlocksPlusItems(String name){
            this.unlocalizedName = name;
            this.registryName = name;
        }

        public String getUnlocalizedName(){
            return unlocalizedName;
        }

        public String getRegistryName(){
            return registryName;
        }


    }

}
