package ie.dylangore.blocksplus;

/**
 * Project: BlocksPlus
 * File: Reference
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class Reference {

    public static final String ID = "blocksplus";
    public static final String NAME = "Blocks Plus";
    public static final String VERSION = "3.0.0";
    public static final String UPDATE_JSON_URL = "https://dylangore.ie/mods/blocksplus/updates.json"; //Temporary link

    public static final String CLIENT_PROXY_LOC = "ie.dylangore.blocksplus.proxy.ClientProxy";
    public static final String COMMON_PROXY_LOC = "ie.dylangore.blocksplus.proxy.CommonProxy";

    public static enum BlocksPlusBlocks{

        ASPHALT_ROAD("asphalt_road"), HEALING_STATION("healing_station");

        private String blockName;

        BlocksPlusBlocks(String name){
            this.blockName = name;
        }

        public String getName(){
            return blockName;
        }

    }

//    public static enum BlocksPlusItems{
//
//        //INSERT ITEMS HERE
//
//        private String itemName;
//
//        BlocksPlusItems(String name){
//            this.itemName = name;
//        }
//
//        public String getName(){
//            return itemName;
//        }
//    }

    public static enum PotionEffects {
        SPEED(1), SLOWNESS(2), HASTE(3), MINING_FATIGUE(4), STRENGTH(5), INSTANT_HEALTH(6), INSTANT_DAMAGE(7), JUMP_BOOST(8),
        NAUSEA(9), REGENERATION(10), RESISTANCE(11), FIRE_RESISTANCE(12), WATER_BREATHING(13), INVISIBILITY(14), BLINDNESS(15),
        NIGHT_VISION(16), HUNGER(17), WEAKNESS(18), POISON(19), WITHER(20), HEALTH_BOOST(21), ABSORPTION(22), SATURATION(23),
        GLOWING(24), LEVITATION(25), LUCK(26), BAD_LUCK(27);

        private int potion_id;

        PotionEffects(int id){
            this.potion_id = id;
        }

        public int getPotionId(){
            return potion_id;
        }
    }

}
