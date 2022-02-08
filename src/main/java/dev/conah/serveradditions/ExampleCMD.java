package dev.conah.serveradditions;

import org.bukkit.command.CommandSender;

public class ExampleCMD extends CommandModule {
    public ExampleCMD() {
        //It defines the label, min args, and max args.
        super("example", 0, 0);
    }

    //The method that "runs" the command.
    public void run(CommandSender sender, String[] args) {
        //Send the player saying it worked.
        sender.sendMessage("You did it right!");
    }
}