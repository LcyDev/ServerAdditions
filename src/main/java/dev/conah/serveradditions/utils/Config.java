package dev.conah.serveradditions.utils;

import dev.conah.serveradditions.ServerAdditions;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.List;

public class Config {

    private Config() {
        if(!messagesFile.exists()){
            plugin.saveResource("messages.yml", true);
        }
    }

    private static final ServerAdditions plugin = ServerAdditions.inst();

    public static File messagesFile = new File(plugin.getDataFolder()+"/messages.yml");
    public static YamlConfiguration msgYML = YamlConfiguration.loadConfiguration(messagesFile);
    public static FileConfiguration configYML = plugin.getConfig();
}
