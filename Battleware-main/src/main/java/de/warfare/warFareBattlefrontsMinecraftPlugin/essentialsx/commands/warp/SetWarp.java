package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.warp;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class SetWarp implements CommandExecutor {
    private final FileConfiguration warpConfig;
    private final File warpFile;

    public SetWarp() {
        // Warps-File laden
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
            sender.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("only_player_warp"));
            return false;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("warp_name"));
            return false;
        }

        String warpName = args[0];

        warpConfig.set("warps." + warpName + ".name", warpName);
        warpConfig.set("warps." + warpName + ".world", player.getWorld().getName());
        warpConfig.set("warps." + warpName + ".x", player.getLocation().getX());
        warpConfig.set("warps." + warpName + ".y", player.getLocation().getY());
        warpConfig.set("warps." + warpName + ".z", player.getLocation().getZ());
        warpConfig.set("warps." + warpName + ".yaw", player.getLocation().getYaw());
        warpConfig.set("warps." + warpName + ".pitch", player.getLocation().getPitch());

        saveWarps();

        player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("setted_warp") + warpName);
        return true;
    }

    public void saveWarps() {
        try {
            warpConfig.save(warpFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
