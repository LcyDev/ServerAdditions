package dev.conah.serveradditions.utils;

import dev.conah.serveradditions.ServerAdditions;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Objects;

import static dev.conah.serveradditions.utils.Variables.*;

public class PluginUtils {

    static final ServerAdditions plugin = ServerAdditions.inst();


    public static Objective initializeOBJ(String name, String criteria, String display) {
        Scoreboard sb = Objects.requireNonNull(Bukkit.getScoreboardManager()).getMainScoreboard();
        if (sb.getObjective(name) == null) {
            sb.registerNewObjective(name, criteria, display);
        }
        return sb.getObjective(name);
    }

    public static boolean checkPerm(CommandSender sender, String perm) {
        return checkPerm(sender, perm, true);
    }
    public static boolean checkPerm(CommandSender sender, String perm, boolean sendMessage) {
        if (sender.hasPermission(perm)) {
            return true;
        } else if (sendMessage) {
            sender.sendMessage("");
            sender.sendMessage(_PREFIX_);
            sender.sendMessage("§cYou don't have the following permission to use this:");
            sender.sendMessage(" §6"+perm);
        }
        return false;
    }

    public static boolean sendCommand(CommandSender sender, String cmd) {
        if(sender instanceof Player p){
            p.chat(cmd); //PlayerCommandPreProcessEvent included.
            //p.performCommand(cmd);
            return true;
        }
        if(sender instanceof ConsoleCommandSender c){
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
        message = ColorUtils.convert(message);
        if(type.equalsIgnoreCase("global")){
            server.broadcast(message, "serveradditions.receive.global");
        }
        if(type.equalsIgnoreCase("admin")){
            server.broadcast(message,"serveradditions.receive.admin");
        }
        if(type.equalsIgnoreCase("silent")){
            server.broadcast(message,"serveradditions.receive.silent");
        }
        console.sendMessage(message);
    }
}
