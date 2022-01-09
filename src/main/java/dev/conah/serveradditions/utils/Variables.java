package dev.conah.serveradditions.utils;

import dev.conah.serveradditions.ServerAdditions;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;

import java.util.List;

public class Variables {
    private static final ServerAdditions plugin = ServerAdditions.inst();

    public static String _NAME_ = plugin.getDescription().getName();
    public static String _PREFIX_ = plugin.getDescription().getPrefix();
    public static String _VERSION_ = plugin.getDescription().getVersion();
    public static String _APIVERSION_ = plugin.getDescription().getAPIVersion();
    public static List<String> _AUTHORS_ = plugin.getDescription().getAuthors();


    public static String _CPREFIX_ = plugin.getConfig().getString("general-config.prefix");
    public static String _LANGUAGE_ = plugin.getConfig().getString("general-config.language");


    public static Server server = Bukkit.getServer();
    public static ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
}
