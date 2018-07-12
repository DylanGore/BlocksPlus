/*
 * Project: BlocksPlus
 * File: FormattingHelper.java
 * Author: Dylan Gore (hello@dylangore.ie)
 * License: GNU Lesser General Public License v3.0
 */

package ie.dylangore.blocksplus.util;

@SuppressWarnings("unused")
public enum FormattingHelper {

    BLACK("0"),
    DARK_BLUE("1"),
    DARK_GREEN("2"),
    DARK_AQUA("3"),
    DARK_RED("4"),
    DARK_PURPLE("5"),
    GOLD("6"),
    GRAY("7"),
    DARK_GRAY("8"),
    BLUE("9"),
    GREEN("a"),
    AQUA("b"),
    RED("c"),
    LIGHT_PURPLE("d"),
    YELLOW("e"),
    WHITE("f"),
    OBFUSCATED("k"),
    BOLD("l"),
    STRIKETHROUGH("m"),
    UNDERLINE("n"),
    ITALIC("o"),
    RESET("r");

    private String itemName;

    FormattingHelper(String name) {
        this.itemName = name;
    }

    public String getFormattingCode() {
        return "\u00A7" + itemName;
    }

}
