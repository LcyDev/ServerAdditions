package dev.conah.serveradditions.commands;

import dev.conah.serveradditions.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Objective;
import org.jetbrains.annotations.NotNull;


import dev.conah.serveradditions.ServerAdditions;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static dev.conah.serveradditions.utils.Config.*;
import static dev.conah.serveradditions.utils.PluginUtils.*;
import static dev.conah.serveradditions.utils.Variables.*;


public class SavingSystem implements CommandExecutor, TabCompleter {

    private static final ServerAdditions plugin = ServerAdditions.inst();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player p){}
        if(sender instanceof ConsoleCommandSender c){}

        final Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective obj = initializeOBJ("output", "dummy", "output");;
        int num;

        if(checkPerm(sender, "serveradditions.save")){
            if(args.length == 0 || args[0].equalsIgnoreCase("all") || args[0].equalsIgnoreCase("-s")){
                Score score = obj.getScore("save-all");
                score.setScore(3);
                sendConsole("execute store success score save-all output run save-all");
                num = score.getScore();

                if (args.length > 1 && args[1].equalsIgnoreCase("-s") || args.length > 0 && args[0].equalsIgnoreCase("-s")){
                    broadcastList(msgYML.getStringList("silent-saving.normal"), "silent");
                    if(num==1){
                        broadcastList(msgYML.getStringList("silent-saving.success"), "silent");
                    }
                    if(num==0){
                        broadcastList(msgYML.getStringList("silent-saving.failure"), "silent");
                    }
                    return true;
                }
                broadcastList(msgYML.getStringList("public-saving.normal"));
                if (num == 1) {
                    broadcastList(msgYML.getStringList("public-saving.success"));
                }
                if (num == 0) {
                    broadcastList(msgYML.getStringList("public-saving.failure"));
                }
                return true;
            }
            if(args[0].equalsIgnoreCase("flush")&&checkPerm(sender, "serveradditions.save-flush")){
                Score score = obj.getScore("save-flush");
                score.setScore(3);
                sendConsole("execute store success score save-flush output run save-all flush");
                num = score.getScore();

                if (args.length > 1 && args[1].equalsIgnoreCase("-s")){
                    broadcastList(msgYML.getStringList("silent-saving.flushing"), "silent");
                    if(num==1){
                        broadcastList(msgYML.getStringList("silent-saving.success"), "silent");
                    }
                    if(num==0){
                        broadcastList(msgYML.getStringList("silent-saving.failure"), "silent");
                    }
                    return true;
                }
                broadcastList(msgYML.getStringList("public-saving.flushing"));
                if(num==1){
                    broadcastList(msgYML.getStringList("public-saving.success"));
                }
                if(num==0){
                    broadcastList(msgYML.getStringList("public-saving.failure"));
                }
                return true;
            }
            if(args[0].equalsIgnoreCase("on")&&checkPerm(sender, "serveradditions.save-on")){
                Score score = obj.getScore("save-on");
                score.setScore(3);
                sendConsole("execute store success score save-on output run save-on");
                num = score.getScore();

                if (args.length > 1 && args[1].equalsIgnoreCase("-s")){
                    if(num==1){
                        broadcastList(msgYML.getStringList("silent-enabling.enable"), "silent");
                    }
                    if(num==0){
                        broadcastList(msgYML.getStringList("silent-enabling.already-on"), "silent");
                    }
                    return true;
                }
                if(num==1){
                    broadcastList(msgYML.getStringList("public-enabling.enable"));
                }
                if(num==0){
                    broadcastList(msgYML.getStringList("public-enabling.already-on"));
                }
                return true;
            }
            if(args[0].equalsIgnoreCase("off")&&checkPerm(sender, "serveradditions.save-off")) {
                Score score = obj.getScore("save-off");
                score.setScore(3);
                sendConsole("execute store success score save-off output run save-off");
                num = score.getScore();

                if (args.length > 1 && args[1].equalsIgnoreCase("-s")){
                    if(num==1){
                        broadcastList(msgYML.getStringList("silent-enabling.disable"), "silent");
                    }
                    if(num==0){
                        broadcastList(msgYML.getStringList("silent-enabling.already-off"), "silent");
                    }
                    return true;
                }
                if(num==1){
                    broadcastList(msgYML.getStringList("public-enabling.disable"));
                }
                if(num==0){
                    broadcastList(msgYML.getStringList("public-enabling.already-off"));
                }
                return true;
            }
            if(args[0].equalsIgnoreCase("help")){
                sender.sendMessage("");
                sender.sendMessage(_CPREFIX_+" §cValid commands:");
                sender.sendMessage("§e /save");
                sender.sendMessage("§e /save <all/flush>");
                sender.sendMessage("§e /save <on/off>");
                sender.sendMessage("§e /save help");
                return true;
            }
            return false;
        }
        return  true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String alias, @NotNull String[] args) {
        if(sender.hasPermission("serveradditions.save")) {
            if (args.length == 1) {
                List<String> str = new ArrayList<>();
                if (sender.hasPermission("serveradditions.save.silent")) {
                    str.add("-s");
                }
                if (sender.hasPermission("serveradditions.save")) {
                    str.add("all");
                }
                if (sender.hasPermission("serveradditions.save-flush")) {
                    str.add("flush");
                }
                if (sender.hasPermission("serveradditions.save-on")) {
                    str.add("on");
                }
                if (sender.hasPermission("serveradditions.save-off")) {
                    str.add("off");
                }
                return str;
            }
            if (args.length == 2) {
                List<String> str = new ArrayList<>();
                if (sender.hasPermission("serveradditions.save.silent")) {
                    str.add("-s");
                }
                return str;
            }
            if (args.length > 1) {
                List<String> str = new ArrayList<>();
                str.add("");
                return str;
            }
            return null;
        }
        return null;
    }
}
