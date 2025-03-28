package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Util;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class TeleportToSpawn {
    private static final File spawnFile = new File("plugins/WarFare-Battlefronts-MinecraftPlugin", "spawn.yml");
    private static final FileConfiguration spawnConfig = YamlConfiguration.loadConfiguration(spawnFile);

    public static boolean teleport(Player player) {
        if (!spawnFile.exists()) {
            player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("spawn_not_set"));
            return false;
        }

        World world = Bukkit.getWorld(spawnConfig.getString("spawn.world"));
        if (world == null) {
            player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("world_not_found"));
            return false;
        }

        double x = spawnConfig.getDouble("spawn.x");
        double y = spawnConfig.getDouble("spawn.y");
        double z = spawnConfig.getDouble("spawn.z");
        float yaw = (float) spawnConfig.getDouble("spawn.yaw");
        float pitch = (float) spawnConfig.getDouble("spawn.pitch");

        player.teleport(new Location(world, x, y, z, yaw, pitch));
        player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("successful_spawn_teleport"));
        return true;
    }
}
