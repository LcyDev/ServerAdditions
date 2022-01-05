package dev.conah.serveradditions.commands;

import dev.conah.serveradditions.ServerAdditions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static dev.conah.serveradditions.utils.Variables.*;
import static dev.conah.serveradditions.utils.PluginUtils.*;


public class SavingSystem implements CommandExecutor {

    private static final ServerAdditions plugin = ServerAdditions.inst();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player p){}
        if(sender instanceof ConsoleCommandSender c){}

        //Scoreboard board = Objects.requireNonNull(Bukkit.getScoreboardManager()).getMainScoreboard();
        Objective obj = initializeOBJ("output", "dummy", "output");
        int num;


        if(checkPerm(sender, "serveradditions.save")){
            if(args.length == 0 || args[0].equalsIgnoreCase("all")){
                Score save_all = obj.getScore("save-all");
                num = save_all.getScore();
                sendConsole("scoreboard players set output saveall 3");
                sendConsole("save-all");
                broadcast("");
                broadcast("&8[&6Historika&8] &9Guardando todos los datos del servidor...");
                broadcast("");
                sendConsole("execute store success score output saveall run save-all");
                if(num==1){
                    broadcast("");
                    broadcast("&8[&6Historika&8] &aLos datos se guardaron correctamente!");
                    broadcast("");
                }
                if(num==0){
                    broadcast("");
                    broadcast("&8[&6Historika&8] &cSe detecto un error al intentar guardar los datos!");
                    broadcast("");
                }
            }
            /*
            if(args[0].equalsIgnoreCase("flush")&&checkPerm(sender, "serveradditions.save-flush")){
                sendConsole("/save-all flush");
            }
            if(args[0].equalsIgnoreCase("on")&&checkPerm(sender, "serveradditions.save-on")){
                sendConsole("/save-on");
            }
            if(args[0].equalsIgnoreCase("off")&&checkPerm(sender, "serveradditions.save-off")){
                if(args[1].equalsIgnoreCase("-s")){
                    sendConsole("/save-off");
                    broadcast("", "silent");
                }else
                    sender.sendMessage("");
            }
            if(args[0].equalsIgnoreCase("help")){
                sender.sendMessage("");
                sender.sendMessage(_PREFIX_+" §cValid commands:");
                sender.sendMessage("§e");
            }
            */
            return true;
        }
        return  false;
    }
}
