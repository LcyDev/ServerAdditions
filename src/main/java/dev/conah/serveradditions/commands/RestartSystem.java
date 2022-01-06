package dev.conah.serveradditions.commands;

import dev.conah.serveradditions.ServerAdditions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static dev.conah.serveradditions.utils.PluginUtils.*;
import static dev.conah.serveradditions.utils.Variables.*;

public class RestartSystem implements CommandExecutor {

    private static final ServerAdditions plugin = ServerAdditions.inst();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        //if(sender instanceof Player p){}
        //if(sender instanceof ConsoleCommandSender c){}

        final Objective obj = initializeOBJ("output", "dummy", "output");

        if(checkPerm(sender, "serveradditions.restart")) {
            Score score = obj.getScore("stopping");
            if(score.getScore() == 0) {
                if(args.length == 0) {
                    score.setScore(1);
                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        broadcast("");
                        broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 60 segundos.");
                        broadcast("");
                    }, 20);
                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        broadcast("");
                        broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 30 segundos.");
                        broadcast("");
                    }, 20);
                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        broadcast("");
                        broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 20 segundos.");
                        broadcast("");
                    }, 20);
                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        broadcast("");
                        broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 10 segundos.");
                        broadcast("");
                    }, 20);
                    Bukkit.getScheduler().runTaskLater(plugin, () -> broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 5 segundos."), 20);
                    Bukkit.getScheduler().runTaskLater(plugin, () -> broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 4 segundos."), 20);
                    Bukkit.getScheduler().runTaskLater(plugin, () -> broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 3 segundos."), 20);
                    Bukkit.getScheduler().runTaskLater(plugin, () -> broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 2 segundos."), 20);
                    Bukkit.getScheduler().runTaskLater(plugin, () -> broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 1 segundos."), 20);
                    broadcast("");
                    broadcast("&8[&6Historika&8] &cCerrando el servidor...");
                    broadcast("");
                    score.setScore(0);
                    //sendConsole("execute run stop")
                    return true;
                }
                if(args[0].equalsIgnoreCase("-fast")) {
                    score.setScore(1);
                    broadcast("");
                    broadcast("&8[&6Historika&8] &cCerrando el servidor...");
                    broadcast("");
                    score.setScore(0);
                    //sendConsole("execute run stop");
                    return true;
                }
                if(args[0].equalsIgnoreCase("-m")) {
                    score.setScore(1);
                    StringBuilder message = new StringBuilder();
                    for (int i = 1; i < args.length; i++){
                        message.append(" ").append(Arrays.toString(args));
                    }

                    broadcast("");
                    broadcast("&3"+message);
                    broadcast("&8[&6Historika&8] &cCerrando el servidor...");
                    broadcast("");
                    score.setScore(0);
                    //sendConsole("execute run stop");
                    return true;
                }
                if(args[0].equalsIgnoreCase("help")){
                    sender.sendMessage("");
                    sender.sendMessage(_PREFIX_+" §cValid commands:");
                    sender.sendMessage("§e  ");
                    return true;
                }
            } else {
                sender.sendMessage("");
                sender.sendMessage("&4>> &cEl servidor ya se esta cerrando!");
                return true;
            }
            return false;
        }
        return true;
    }
}