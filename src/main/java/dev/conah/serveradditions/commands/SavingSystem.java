package dev.conah.serveradditions.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Objective;
import org.jetbrains.annotations.NotNull;


//import dev.conah.serveradditions.ServerAdditions;
import static dev.conah.serveradditions.utils.PluginUtils.*;
import static dev.conah.serveradditions.utils.Variables.*;


public class SavingSystem implements CommandExecutor {

    //private static final ServerAdditions plugin = ServerAdditions.inst();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        //if(sender instanceof Player p){}
        //if(sender instanceof ConsoleCommandSender c){}

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
                    broadcast("","silent");
                    broadcast("&8[&6Historika&8] &7Guardando todos los datos del servidor...","silent");
                    broadcast("","silent");
                    if(num==1){
                        broadcast("","silent");
                        broadcast("&8[&6Historika&8] &7Los datos se guardaron correctamente!","silent");
                        broadcast("","silent");
                    }
                    if(num==0){
                        broadcast("","silent");
                        broadcast("&8[&6Historika&8] &7Se detecto un &cerror&7 al intentar guardar los datos!","silent");
                        broadcast("","silent");
                    }
                    return true;
                }
                broadcast("");
                broadcast("&8[&6Historika&8] &9Guardando todos los datos del servidor...");
                broadcast("");
                if (num == 1) {
                    broadcast("");
                    broadcast("&8[&6Historika&8] &aLos datos se guardaron correctamente!");
                    broadcast("");
                }
                if (num == 0) {
                    broadcast("");
                    broadcast("&8[&6Historika&8] &cSe detecto un error al intentar guardar los datos!");
                    broadcast("");
                }
                return true;
            }
            if(args[0].equalsIgnoreCase("flush")&&checkPerm(sender, "serveradditions.save-flush")){
                Score score = obj.getScore("save-flush");
                score.setScore(3);
                sendConsole("execute store success score save-flush output run save-all flush");
                num = score.getScore();

                if (args.length > 1 && args[1].equalsIgnoreCase("-s")){
                    broadcast("","silent");
                    broadcast("&8[&6Historika&8] &7Guardando todos los datos del servidor...","silent");
                    broadcast("&8[&6Historika&8] &cFlushing enabled&7, esto puede congelar el servidor por unos segundos...","silent");
                    broadcast("","silent");
                    if(num==1){
                        broadcast("","silent");
                        broadcast("&8[&6Historika&8] &7Los datos se guardaron correctamente!");
                        broadcast("","silent");
                    }
                    if(num==0){
                        broadcast("","silent");
                        broadcast("&8[&6Historika&8] &7Se detecto un &cerror&7 al intentar guardar los datos!","silent");
                        broadcast("","silent");
                    }
                    return true;
                }
                broadcast("");
                broadcast("&8[&6Historika&8] &9Guardando todos los datos del servidor...");
                broadcast("&8[&6Historika&8] &cFlushing enabled&7, esto puede congelar el servidor por unos segundos...");
                broadcast("");
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
                return true;
            }
            if(args[0].equalsIgnoreCase("on")&&checkPerm(sender, "serveradditions.save-on")){
                Score score = obj.getScore("save-on");
                score.setScore(3);
                sendConsole("execute store success score save-on output run save-on");
                num = score.getScore();

                if (args.length > 1 && args[1].equalsIgnoreCase("-s")){
                    if(num==1){
                        broadcast("","silent");
                        broadcast("&8[&6Historika&8] &7Guardado automatico &aactivado.","silent");
                        broadcast("","silent");
                    }
                    if(num==0){
                        broadcast("","silent");
                        broadcast("&8[&6Historika&8] &7Guardado automatico ya estaba &cactivado.","silent");
                        broadcast("","silent");
                    }
                    return true;
                }
                if(num==1){
                    broadcast("");
                    broadcast("&8[&6Historika&8] &aGuardado automatico activado.");
                    broadcast("");
                }
                if(num==0){
                    broadcast("");
                    broadcast("&8[&6Historika&8] &cGuardado automatico ya estaba activado.");
                    broadcast("");
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
                        broadcast("","silent");
                        broadcast("&8[&6Historika&8] &7Guardado automatico &edesactivado.","silent");
                        broadcast("","silent");
                    }
                    if(num==0){
                        broadcast("","silent");
                        broadcast("&8[&6Historika&8] &7Guardado automatico ya estaba &cdesactivado.","silent");
                        broadcast("","silent");
                    }
                    return true;
                }
                if(num==1){
                    broadcast("");
                    broadcast("&8[&6Historika&8] &eGuardado automatico desactivado.");
                    broadcast("");
                }
                if(num==0){
                    broadcast("");
                    broadcast("&8[&6Historika&8] &cGuardado automatico ya estaba desactivado.");
                    broadcast("");
                }
                return true;
            }
            if(args[0].equalsIgnoreCase("help")){
                sender.sendMessage("");
                sender.sendMessage(_PREFIX_+" §cValid commands:");
                sender.sendMessage("§e  ");
                return true;
            }
            return false;
        }
        return  true;
    }
}
