package dev.conah.serveradditions.utils;

import dev.conah.serveradditions.ServerAdditions;

import java.util.logging.ConsoleHandler;
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
    public static void log(Level level, String msg) {
        //logger.log(level, () -> ColorChat.replaceColoredKeys(msg));
        logger.log(level, () -> msg);
    }

    public static void rawlog(Level level, String msg) {
        _logger.log(level, () -> msg);
    }

    public static void info(String msg) {
        log(Level.INFO, msg);
    }
    public static void rawinfo(String msg) {
        rawlog(Level.INFO, msg);
    }

    public static void fine(String msg) {
        log(Level.FINE, msg);
    }
    public static void rawfine(String msg) {
        rawlog(Level.FINE, msg);
    }


    public static void finer(String msg) {
        log(Level.FINER, msg);
    }
    public static void rawfiner(String msg) {
        rawlog(Level.FINER, msg);
    }

    public static void finest(String msg) {
        log(Level.FINEST, msg);
    }
    public static void rawfinest(String msg) {
        rawlog(Level.FINEST, msg);
    }

    public static void warn(String msg) {
        log(Level.WARNING, msg);
    }
    public static void rawwarn(String msg) {
        rawlog(Level.WARNING, msg);
    }

    public static void severe(String msg) {
        log(Level.SEVERE, msg);
    }
    public static void rawsevere(String msg) {
        rawlog(Level.SEVERE, msg);
    }

    public static void debug(String msg) {
        if (plugin.hasDebuggingMode()) {
            info(msg);
        }
    }
    public static void rawdebug(String msg) {
        if (plugin.hasDebuggingMode()) {
            rawinfo(msg);
        }
    }

    public Logger getLogger() {
        return logger;
    }
}
