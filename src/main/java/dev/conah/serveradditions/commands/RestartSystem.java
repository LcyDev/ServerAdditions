package dev.conah.serveradditions.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Objective;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;


import dev.conah.serveradditions.ServerAdditions;
import static dev.conah.serveradditions.utils.PluginUtils.*;
import static dev.conah.serveradditions.utils.Variables.*;

public class RestartSystem implements CommandExecutor {

    private static final ServerAdditions plugin = ServerAdditions.inst();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player p){}
        if(sender instanceof ConsoleCommandSender c){}

        final Objective obj = initializeOBJ("output", "dummy", "output");

        if(checkPerm(sender, "serveradditions.restart")) {
            Score score = obj.getScore("stopping");
            if(score.getScore() == 0) {
                if(args.length == 0) {
                    score.setScore(1);
                    broadcast("");
                    broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 60 segundos.");
                    broadcast("");
                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        broadcast("");
                        broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 30 segundos.");
                        broadcast("");
                        Bukkit.getScheduler().runTaskLater(plugin, () -> {
                            broadcast("");
                            broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 20 segundos.");
                            broadcast("");
                            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                broadcast("");
                                broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 10 segundos.");
                                broadcast("");
                                Bukkit.getScheduler().runTaskLater(plugin, () -> broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 5 segundos."), 20);
                                Bukkit.getScheduler().runTaskLater(plugin, () -> broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 4 segundos."), 20*2);
                                Bukkit.getScheduler().runTaskLater(plugin, () -> broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 3 segundos."), 20*3);
                                Bukkit.getScheduler().runTaskLater(plugin, () -> broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 2 segundos."), 20*4);
                                Bukkit.getScheduler().runTaskLater(plugin, () -> broadcast("&8[&6Historika&8] &cEl servidor se cerrara en 1 segundo."), 20*5);
                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                    broadcast("");
                                    broadcast("&8[&6Historika&8] &cCerrando el servidor...");
                                    broadcast("");
                                    score.setScore(0);
                                    //sendConsole("execute run stop")
                                }, 20*5);
                            }, 20*10);
                        }, 20*10);
                    }, 20*30);
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
                    if(args.length > 1) {
                        score.setScore(1);

                        String msg = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                        /*StringBuilder message = new StringBuilder();
                        for (int i = 1; i < args.length; i++){
                            message.append(args[i]).append(" ");

                        }
                        String msg = message.toString();*/
                        broadcast("");
                        broadcast("&3"+msg);
                        broadcast("&8[&6Historika&8] &cCerrando el servidor...");
                        broadcast("");
                        score.setScore(0);
                    } else {
                        sender.sendMessage("§4>> §cArgumentos insuficientes.");
                    }
                    //sendConsole("execute run stop");
                    return true;
                }
                if(args[0].equalsIgnoreCase("-d")) {
                    if(args.length > 1) {
                        if(StringUtils.isNumeric(args[1])) {
                            int delay = Integer.valueOf(args[1]);

                            if(args[2].equalsIgnoreCase("-m")) {
                                if(args.length > 3) {
                                    score.setScore(1);
                                    String msg = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                                    broadcast("");
                                    broadcast("&3"+msg);
                                    broadcast("&8[&6Historika&8] &cEl servidor se cerrara en"+delay+" segundos.");
                                    broadcast("");

                                    broadcast("");
                                    broadcast("&8[&6Historika&8] &cCerrando el servidor...");
                                    broadcast("");
                                } else {
                                    sender.sendMessage("§4>> §cArgumentos insuficientes.");
                                }
                            }
                            score.setScore(0);
                        } else {
                            sender.sendMessage("§4>> §cEl argumento delay debe ser un numero!");
                        }

                    } else {
                        sender.sendMessage("§4>> §cArgumentos insuficientes.");
                    }
                    //sendConsole("execute run stop");
                    return true;
                }
                if(args[0].equalsIgnoreCase("help")){
                    sender.sendMessage("");
                    sender.sendMessage(_PREFIX_+" §cValid commands:");
                    sender.sendMessage("§e /se_restart (Cooldown 60s)");
                    sender.sendMessage("§e /se_restart -m <message>");
                    sender.sendMessage("§e /se_restart -d <seconds>");
                    sender.sendMessage("§e /se_restart -d <seconds> -m <message>");
                    sender.sendMessage("§e /se_restart -fast");
                    return true;
                }
            } else {
                sender.sendMessage("");
                sender.sendMessage("§4>> §cEl servidor ya se esta cerrando!");
                return true;
            }
            return false;
        }
        return true;
    }
}