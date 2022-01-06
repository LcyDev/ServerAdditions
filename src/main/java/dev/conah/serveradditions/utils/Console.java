package dev.conah.serveradditions.utils;

import dev.conah.serveradditions.ServerAdditions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Console {
    private static final ServerAdditions plugin = ServerAdditions.inst();
    private static final Logger logger = plugin.getLogger();
    private static final Logger _logger = plugin.getServer().getLogger();
    /*
    /. Only info, warn and severe work by default on a server
    /. Raw does not include [PluginPrefix]
     */
    public static void log(Level level, String msg, String type) {
        if(type.equalsIgnoreCase("raw")){
            _logger.log(level, () -> ColorUtils.convert(msg));
        } else {
            logger.log(level, () -> ColorUtils.convert(msg));
        }
    }

    public static void log(Level level, String msg) {
    }

    public static void info(String msg) {
        log(Level.INFO, msg, "plugin");
    }
    public static void raw_info(String msg) {
        log(Level.INFO, msg, "raw");
    }

    public static void fine(String msg) {
        log(Level.FINE, msg, "plugin");
    }
    public static void raw_fine(String msg) {
        log(Level.FINE, msg, "raw");
    }


    public static void finer(String msg) {
        log(Level.FINER, msg, "plugin");
    }
    public static void raw_finer(String msg) {
        log(Level.FINER, msg, "raw");
    }

    public static void finest(String msg) {
        log(Level.FINEST, msg, "plugin");
    }
    public static void raw_finest(String msg) {
        log(Level.FINEST, msg, "raw");
    }

    public static void warn(String msg) {
        log(Level.WARNING, msg, "plugin");
    }
    public static void raw_warn(String msg) {
        log(Level.WARNING, msg, "raw");
    }

    public static void severe(String msg) {
        log(Level.SEVERE, msg, "plugin");
    }
    public static void raw_severe(String msg) {
        log(Level.SEVERE, msg, "raw");
    }

    public static void debug(String msg) {
        if (plugin.hasDebuggingMode()) {
            info(msg);
        }
    }
    public static void raw_debug(String msg) {
        if (plugin.hasDebuggingMode()) {
            raw_info(msg);
        }
    }

    public Logger getLogger() {
        return logger;
    }
}
