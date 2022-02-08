package dev.conah.serveradditions.commands;

import dev.conah.serveradditions.ServerAdditions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static dev.conah.serveradditions.utils.PluginUtils.checkPerm;

public class BroadcastSystem implements CommandExecutor {

    private static final ServerAdditions plugin = ServerAdditions.inst();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player p){}
        if(sender instanceof ConsoleCommandSender c){}

        if(checkPerm(sender, "serveradditions.broadcast")){
            if(args.length == 0){

            }
            if(args[0].equalsIgnoreCase("")&&checkPerm(sender, "serveradditions.save-flush")){

            }
            if(args[0].equalsIgnoreCase("help")){

            }

            return false;
        }
        return true;
    }
}
