package dev.conah.serveradditions.utils;

import dev.conah.serveradditions.ServerAdditions;

public class Config {

    private static final ServerAdditions plugin = ServerAdditions.inst();


    public static String getConfig(String path) {
        return plugin.getConfig().getString(path);
    }
}
