package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.warp;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Warp implements CommandExecutor {
    private final FileConfiguration warpConfig;
    private final File warpFile;

    public Warp() {

        this.warpFile = new File("plugins/WarFare-Battlefronts-MinecraftPlugin", "warps.yml");
        if (!warpFile.exists()) {
            try {
                warpFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.warpConfig = YamlConfiguration.loadConfiguration(warpFile);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("non_player"));
            return false;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("warp_usage"));
            return false;
        }

        String warpName = args[0];
        if (!warpConfig.contains("warps." + warpName)) {
            player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("non_existent_warp"));
            return false;
        }

        World world = Bukkit.getWorld(warpConfig.getString("warps." + warpName + ".world"));
        double x = warpConfig.getDouble("warps." + warpName + ".x");
        double y = warpConfig.getDouble("warps." + warpName + ".y");
        double z = warpConfig.getDouble("warps." + warpName + ".z");
        float yaw = (float) warpConfig.getDouble("warps." + warpName + ".yaw");
        float pitch = (float) warpConfig.getDouble("warps." + warpName + ".pitch");

        if (world != null) {
            Location warpLocation = new Location(world, x, y, z, yaw, pitch);
            player.teleport(warpLocation);
            player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("succeful_warp_teleport") + warpName);
        } else {
            player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("world_not_found"));
        }
        return true;
    }

    // Funktion zum Speichern der Warps
    public void saveWarps() {
        try {
            warpConfig.save(warpFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
