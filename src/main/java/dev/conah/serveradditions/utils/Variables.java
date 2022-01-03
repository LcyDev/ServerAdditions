package dev.conah.serveradditions.utils;

import dev.conah.serveradditions.ServerAdditions;
import org.bukkit.Bukkit;
import org.bukkit.Server;

public class Variables {
    private static final ServerAdditions plugin = ServerAdditions.inst();

    public static String _PREFIX_ = plugin.getDescription().getPrefix();
    public static String _VERSION_ = plugin.getDescription().getVersion();


    public static Server server = Bukkit.getServer();
}
