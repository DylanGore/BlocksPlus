/*
 * Project: BlocksPlus
 * File: CommandBlocksPlus.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 11/08/14 09:35
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.command;

import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentText;

import java.util.List;

public class CommandBlocksPlus extends CommandBase {

    private String prefix = "\u00A74" + "[BlocksPlus] ";

    @Override
    public String getCommandName() {
        return Reference.ID.toLowerCase();
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
        return true;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + this.getCommandName() + " help";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] arguments) {
        if(arguments.length <= 0){
            throw new WrongUsageException("Type '" + this.getCommandUsage(sender) + "' for help.");
        }
        if(arguments[0].matches("version")){
            commandVersion(sender, arguments);
        }
        else if(arguments[0].matches("help")){
            commandHelp(sender, arguments);
        }
    }

    private void commandVersion(ICommandSender sender, String[] arguments){
        String color = "\u00A73";

        sender.addChatMessage(new ChatComponentText(String.format(prefix + color + "You are running Blocks Plus " + Reference.VERSION )));
        sender.addChatMessage(new ChatComponentText(String.format(color + "for Minecraft " + Reference.VERSION_MINECRAFT)));
    }

    private void commandHelp(ICommandSender sender, String[] arguments){
        String color = "\u00A72";

        sender.addChatMessage(new ChatComponentText(String.format(color + "Format: '/" + this.getCommandName() + " <command> <arguments>'")));
        sender.addChatMessage(new ChatComponentText("Available commands:"));
        sender.addChatMessage(new ChatComponentText("- version : Version information."));
        sender.addChatMessage(new ChatComponentText("- help : displays this text."));
        return;
    }

    private void commandAdmin(ICommandSender sender, String[] arguments){
        String color = "\u00A73";

        sender.addChatMessage(new ChatComponentText(String.format(prefix + color + "This command is WIP!")));
    }

    private void commandAdminTool(ICommandSender sender, String[] arguments){
        String color = "\u00A73";

        sender.addChatMessage(new ChatComponentText(String.format(prefix + color + "This command is WIP!")));
    }
}
