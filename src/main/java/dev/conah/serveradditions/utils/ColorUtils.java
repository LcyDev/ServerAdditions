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

    public static String convert(@Nullable String msg) {
        if (msg == null) return null;
        char[] b = coloredString(msg).toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == '&') {
                if (b[i + 1] == '&') {
                    b[i + 1] = '=';
                } else if (b[i + 1] != ' ') {
                    b[i] = ChatColor.COLOR_CHAR;
                    b[i + 1] = Character.toLowerCase(b[i + 1]);
                }
            }
        }
        return new String(b).replace("&=", "&");
    }

    public static String coloredString(@Nullable String string) {
        if (string == null) return null;
        if (ServerVersion.isAfterOrEq(MinecraftVersions.v1_16)) {
            Matcher match = HEX_PATTERN.matcher(string);
            while (match.find()) {
                String color = string.substring(match.start(), match.end());
                string = string.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
            }
            match = HEX_PATTERN_OTHER.matcher(string);
            while (match.find()) {
                String color = string.substring(match.start(), match.end());
                string = string.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
            }
        }
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}