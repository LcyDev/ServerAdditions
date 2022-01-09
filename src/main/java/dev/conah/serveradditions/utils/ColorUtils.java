package dev.conah.serveradditions.utils;

import net.md_5.bungee.api.ChatColor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jetbrains.annotations.Nullable;


import dev.conah.serveradditions.version.ServerVersion;
import dev.conah.serveradditions.version.MinecraftVersions;

public class ColorUtils {
    private ColorUtils() {
    }

    private static final Pattern HEX_PATTERN = Pattern.compile("&#[A-Fa-f0-9]{6}"); // &#RRGGBB
    private static final Pattern HEX_PATTERN_OTHER = Pattern.compile("&\\{#[A-Fa-f0-9]{6}}"); // &{#RRGGBB}


    public static String format(@Nullable String str) {
        if(str==null) return null;
        if (ServerVersion.isAfterOrEq(MinecraftVersions.v1_16)) {
            Matcher match = HEX_PATTERN.matcher(str);
            while (match.find()) {
                String group = match.group(0);
                //String color = str.substring(match.start(), match.end()); // alt way, can replace group. (except in if statement).
                if(str.contains(group)) {
                    str = str.replace(group, net.md_5.bungee.api.ChatColor.of(group.replace("&", "")).toString());
                    match = HEX_PATTERN.matcher(str);
                }
            }
            match = HEX_PATTERN_OTHER.matcher(str);
            while (match.find()) {
                String group = match.group(0);
                if(str.contains(group)) {
                    str = str.replace(group, net.md_5.bungee.api.ChatColor.of(group.replace("{", "").replace("}", "").replace("&", "")).toString());
                    match = HEX_PATTERN_OTHER.matcher(str);
                }
            }
        }
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}