package dev.conah.serveradditions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class CmdExecutor implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //Checks if the label is one of yours.
        if(ServerAdditions.commands.containsKey(label)) {
            //If so, it will check if they have the permission.
            if(sender.hasPermission("serveradditions." + label)) {
                //Get the module so you can access its variables.
                CommandModule mod = ServerAdditions.commands.get(label);

                //Checks if the amount of arguments is within the minimum amount and maximum amount.
                if(args.length >= mod.minArgs && args.length <= mod.maxArgs) {
                    //If so, it will run the command.
                    mod.run(sender, args);
                } else {
                    //If not, it will send the player some sass.
                    sender.sendMessage("You should learn how to use this command...");
                }
            } else {
                //If not, it will send the player some more sass.
                sender.sendMessage("Looks like you are lacking some perms.");
            }
        }
        return false;
    }
}