package dev.conah.serveradditions.version;

public class ServerVersion {

    public static MinecraftVersion getVersion() {
        return MinecraftVersions.RUNTIME_VERSION;
    }

    private ServerVersion() {
    }

    public static boolean isAfter(MinecraftVersion other) {
        return MinecraftVersions.RUNTIME_VERSION.compareTo(other) > 0;
    }

    public static boolean isAfterOrEq(MinecraftVersion other) {
        return MinecraftVersions.RUNTIME_VERSION.compareTo(other) >= 0;
    }

    public static boolean isBefore(MinecraftVersion other) {
        return MinecraftVersions.RUNTIME_VERSION.compareTo(other) < 0;
    }

    public static boolean isBeforeOrEq(MinecraftVersion other) {
        return MinecraftVersions.RUNTIME_VERSION.compareTo(other) <= 0;
    }

    public static boolean isBetween(MinecraftVersion o1, MinecraftVersion o2) {
        return isAfterOrEq(o1) && isBeforeOrEq(o2) || isBeforeOrEq(o1) && isAfterOrEq(o2);
    }

    public static boolean equals(MinecraftVersion other) {
        return MinecraftVersions.RUNTIME_VERSION.getMajor() == other.getMajor() && MinecraftVersions.RUNTIME_VERSION.getMinor() == other.getMinor() && MinecraftVersions.RUNTIME_VERSION.getPatch() == other.getPatch();
    }

}