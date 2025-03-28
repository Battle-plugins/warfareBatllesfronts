package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Strings {
    private static FileConfiguration config;

    public static void load(JavaPlugin plugin) {
        config = plugin.getConfig();
    }

    public static String getMessage(String path) {
        String message = config.getString("messages." + path, null);
        if (message == null) {

            return ChatColor.translateAlternateColorCodes('&', "§cMessage not found for path: " + path);
        }
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
