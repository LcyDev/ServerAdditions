package dev.conah.serveradditions;

import dev.conah.serveradditions.utils.ChatUtils;
import dev.conah.serveradditions.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dev.conah.serveradditions.commands.RestartSystem;
import dev.conah.serveradditions.commands.SavingSystem;

import static dev.conah.serveradditions.utils.Console.*;
import static dev.conah.serveradditions.utils.Variables.*;

public final class ServerAdditions extends JavaPlugin implements Listener {

    //Instance
    private static ServerAdditions instance;
    public static HashMap<String, CommandModule> commands;

    public ServerAdditions() {
        super();
        instance = this;
    }

    @Override
    // Plugin loading logic. (Warning, Careful, Some API's don't work here yet.)
    // "[ServerAdditions] Loading ServerAdditions"
    public void onLoad() {}

    @Override
    // Plugin enabling logic.
    // "[ServerAdditions] Enabling ServerAdditions"
    public void onEnable() {
        commands = new HashMap<String, CommandModule>();
        new ExampleCMD();
        if(!Initialize()) {
            instance.getPluginLoader().disablePlugin(instance);
        }
    }

    @Override
    // Plugin disabling logic.
    // "[ServerAdditions] Disabling ServerAdditions"
    public void onDisable() {
        instance = null;
        commands.clear();
    }

    public boolean Initialize() {
        try {
            registerCommands();
            registerListeners();
            registerTabCompleter();
            printASCIIArt();
            saveDefaultConfig();
            info("§6Internal load successful!");
            return true;
        }
        catch(java.lang.NullPointerException e) {
            e.printStackTrace();
            severe("§cERROR: Failed to load internally!");
            warn("§eOne of the commands inside this plugin is not registered!");
        }
        catch(Exception e) {
            e.printStackTrace();
            severe("§cERROR: Failed to load internally!");
        }
        return false;
    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("save")).setExecutor(new SavingSystem());
        Objects.requireNonNull(getCommand("se_restart")).setExecutor(new RestartSystem());
    }
    private void registerListeners(){
        getServer().getPluginManager().registerEvents(new ChatUtils(), this);
    }
    private void registerTabCompleter(){
        Objects.requireNonNull(getCommand("save")).setTabCompleter(new SavingSystem());
    }

    public void printASCIIArt() {
        info("");
        info("§b╔═╗┌─┐┬─┐┬  ┬┌─┐┬─┐  ╔═╗┌┬┐┌┬┐┬┌┬┐┬┌─┐┌┐┌┌─┐");
        info("§b╚═╗├┤ ├┬┘└┐┌┘├┤ ├┬┘  ╠═╣ ││ │││ │ ││ ││││└─┐");
        info("§b╚═╝└─┘┴└─ └┘ └─┘┴└─  ╩ ╩─┴┘─┴┘┴ ┴ ┴└─┘┘└┘└─┘");
        info("§6                         By ConaII_");
        info("§2Version v" + _VERSION_ );
    }

    public boolean hasDebuggingMode() {
        return instance.getConfig().getBoolean("debugMode");
    }

    public static ServerAdditions inst() {
        return instance;
    }
}
