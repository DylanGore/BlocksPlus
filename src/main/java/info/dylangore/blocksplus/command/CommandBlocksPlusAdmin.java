/*
 * Project: BlocksPlus
 * File: CommandBlocksPlusAdmin.java
 * Author: Dylan Gore (http://dylangore.info)
 * Modified: 11/08/14 10:35
 * License: GNU LGPLv3 (https://www.gnu.org/licenses/lgpl.html)
 */

package info.dylangore.blocksplus.command;

import info.dylangore.blocksplus.reference.Reference;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentText;

import java.util.List;

public class CommandBlocksPlusAdmin extends CommandBase {

    private String prefix = "\u00A74" + "[BlocksPlus] ";

    @Override
    public String getCommandName() {
        return Reference.ID.toLowerCase() + "admin";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
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
        if(arguments[0].matches("tool")){
            commandAdminTool(sender, arguments);
        }
    }

    private void commandAdminTool(ICommandSender sender, String[] arguments){
        String color = "\u00A73";

        sender.addChatMessage(new ChatComponentText(String.format(prefix + color + "This command is WIP!")));
    }
}

