package dev.conah.serveradditions.utils;

import dev.conah.serveradditions.ServerAdditions;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static dev.conah.serveradditions.utils.Variables.*;

public class PluginUtils {

    static final ServerAdditions plugin = ServerAdditions.inst();


    public static boolean checkPerm(CommandSender sender, String perm) {
        return checkPerm(sender, perm, true);
    }
    public static boolean checkPerm(CommandSender sender, String perm, boolean sendMessage) {
        if (sender.hasPermission(perm)) {
            return true;
        } else if (sendMessage) {
            sender.sendMessage("");
            sender.sendMessage(_PREFIX_);
            sender.sendMessage("&cYou don't have the following permission to use this:"); //reminder to later replace this with .yml
            sender.sendMessage(" §6"+perm);
        }
        return false;
    }

    public static boolean sendCommand(CommandSender sender, String cmd) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            p.chat(cmd); //PlayerCommandPreProcessEvent included.
            //p.performCommand(cmd);
            return true;
        }
        if(sender instanceof ConsoleCommandSender){
            ConsoleCommandSender c = server.getConsoleSender();
            plugin.getServer().dispatchCommand(c, cmd);
            return true;
        }
        return false;
    }
    public static void sendConsole(String cmd){
        ConsoleCommandSender c = server.getConsoleSender();
        server.dispatchCommand(c, cmd);
    }

    public static void broadcast(String message){
        broadcast(message, "global");
    }
    public static void broadcast(String message, String type){
        if(type.equalsIgnoreCase("global")){
            server.broadcast(message, "serveradditions.receive.global");
        }
        if(type.equalsIgnoreCase("admin")){
            server.broadcast(message,"serveradditions.receive.admin");
        }
        if(type.equalsIgnoreCase("silent")){
            server.broadcast(message,"serveradditions.receive.silent");
        }
    }
}
