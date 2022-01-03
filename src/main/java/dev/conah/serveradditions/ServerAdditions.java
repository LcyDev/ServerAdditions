package dev.conah.serveradditions;

import org.bukkit.plugin.java.JavaPlugin;
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
    }

    public boolean Initialize() {
        try {
            printASCIIArt();
            info("§6Internal load successful!");
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            severe(e.getMessage());
            severe("§cERROR: Failed to load internally!");
            return false;
        }
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
