package ie.dylangore.blocksplus;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.TextFormatting;

/**
 * Project: BlocksPlus
 * File: Reference
 * Author: Dylan Gore (hello@dylangore.ie)
 * Date Created: 08 January 2017
 */

public class Reference {

    public static final String ID = "blocksplus";
    public static final String NAME = "Blocks Plus";
    public static final String VERSION = "mod_version";
    public static final String UPDATE_JSON_URL = "https://dylangore.ie/mods/blocksplus/updates.json"; //Temporary link

    public static final String CLIENT_PROXY_LOC = "ie.dylangore.blocksplus.proxy.ClientProxy";
    public static final String COMMON_PROXY_LOC = "ie.dylangore.blocksplus.proxy.CommonProxy";

    public static final String GUI_FACTORY_LOC = "ie.dylangore.blocksplus.client.gui.GuiFactory";

    public static enum BlocksPlusBlocks{

        COLOURED_COBBLESTONE("colored_cobblestone"), COLORED_STONE("colored_stone"), COLORED_STONE_BRICKS("colored_stone_bricks"),
        COLORED_STONE_BRICKS_CHISELED("colored_stone_bricks_chiseled"), COLORED_STONE_BRICKS_CRACKED("colored_stone_bricks_cracked"),
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

    //TODO Re-write EnumColors

    public static enum EnumColors implements IStringSerializable{
        WHITE(0, 15, "white", "white", MapColor.SNOW, TextFormatting.WHITE),
        ORANGE(1, 14, "orange", "orange", MapColor.ADOBE, TextFormatting.GOLD),
        MAGENTA(2, 13, "magenta", "magenta", MapColor.MAGENTA, TextFormatting.AQUA),
        LIGHT_BLUE(3, 12, "light_blue", "lightBlue", MapColor.LIGHT_BLUE, TextFormatting.BLUE),
        YELLOW(4, 11, "yellow", "yellow", MapColor.YELLOW, TextFormatting.YELLOW),
        LIME(5, 10, "lime", "lime", MapColor.LIME, TextFormatting.GREEN),
        PINK(6, 9, "pink", "pink", MapColor.PINK, TextFormatting.LIGHT_PURPLE),
        GRAY(7, 8, "gray", "gray", MapColor.GRAY, TextFormatting.DARK_GRAY),
        SILVER(8, 7, "silver", "silver", MapColor.SILVER, TextFormatting.GRAY),
        CYAN(9, 6, "cyan", "cyan", MapColor.CYAN, TextFormatting.DARK_AQUA),
        PURPLE(10, 5, "purple", "purple", MapColor.PURPLE, TextFormatting.DARK_PURPLE),
        BLUE(11, 4, "blue", "blue", MapColor.BLUE, TextFormatting.DARK_BLUE),
        BROWN(12, 3, "brown", "brown", MapColor.BROWN, TextFormatting.GOLD),
        GREEN(13, 2, "green", "green", MapColor.GREEN, TextFormatting.DARK_GREEN),
        RED(14, 1, "red", "red", MapColor.RED, TextFormatting.DARK_RED),
        BLACK(15, 0, "black", "black", MapColor.BLACK, TextFormatting.BLACK);

        private static final EnumColors[] META_LOOKUP = new EnumColors[values().length];
        private static final EnumColors[] DYE_DMG_LOOKUP = new EnumColors[values().length];
        private final int meta;
        private final int dyeDamage;
        private final String name;
        private final String unlocalizedName;
        private final MapColor mapColor;
        private final TextFormatting chatColor;

        private EnumColors(int meta, int dyeDamage, String name, String unlocalizedName, MapColor mapColorIn, TextFormatting chatColor)
        {
            this.meta = meta;
            this.dyeDamage = dyeDamage;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
            this.mapColor = mapColorIn;
            this.chatColor = chatColor;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public int getDyeDamage()
        {
            return this.dyeDamage;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        public String getCapitalName() {
            String capName;
            String unlocName = this.unlocalizedName;
            capName = unlocName.substring(0, 1).toUpperCase() + unlocName.substring(1);
            return capName;
        }

        public MapColor getMapColor()
        {
            return this.mapColor;
        }

        public static EnumColors byDyeDamage(int damage)
        {
            if (damage < 0 || damage >= DYE_DMG_LOOKUP.length)
            {
                damage = 0;
            }

            return DYE_DMG_LOOKUP[damage];
        }

        public static EnumColors byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String toString()
        {
            return this.unlocalizedName;
        }

        public String getName()
        {
            return this.name;
        }

        static
        {
            for (EnumColors enumColors : values())
            {
                META_LOOKUP[enumColors.getMetadata()] = enumColors;
                DYE_DMG_LOOKUP[enumColors.getDyeDamage()] = enumColors;
            }
        }
    }

}
