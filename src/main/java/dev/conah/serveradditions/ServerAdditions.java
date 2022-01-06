package dev.conah.serveradditions;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

import dev.conah.serveradditions.commands.RestartSystem;
import dev.conah.serveradditions.commands.SavingSystem;

import static dev.conah.serveradditions.utils.Console.*;
import static dev.conah.serveradditions.utils.Variables.*;

public final class ServerAdditions extends JavaPlugin {

    //Instance
    private static ServerAdditions instance;

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
        if(!Initialize()) {
            instance.getPluginLoader().disablePlugin(instance);
        }

    }

    @Override
    // Plugin disabling logic.
    // "[ServerAdditions] Disabling ServerAdditions"
    public void onDisable() {
        instance = null;
    }

    public boolean Initialize() {
        try {
            registerCommands();
            registerListeners();
            registerTabCompleter();
            printASCIIArt();
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
