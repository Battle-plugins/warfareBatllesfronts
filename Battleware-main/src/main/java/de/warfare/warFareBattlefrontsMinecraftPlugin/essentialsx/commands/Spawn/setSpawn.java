package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.Spawn;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class setSpawn implements CommandExecutor {
    private final FileConfiguration spawnConfig;
    private final File spawnFile;

    public setSpawn() {
        // Warps-File laden
        this.spawnFile = new File("plugins/WarFare-Battlefronts-MinecraftPlugin", "spawn.yml");
        if (!spawnFile.exists()) {
            try {
                spawnFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.spawnConfig = YamlConfiguration.loadConfiguration(spawnFile);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("only_player_spawn"));
            return false;
        }
        Player player = (Player) sender;

        spawnConfig.set("spawn." + ".world", player.getWorld().getName());
        spawnConfig.set("spawn." +  ".x", player.getLocation().getX());
        spawnConfig.set("spawn." +  ".y", player.getLocation().getY());
        spawnConfig.set("spawn." +  ".z", player.getLocation().getZ());
        spawnConfig.set("spawn." +  ".yaw", player.getLocation().getYaw());
        spawnConfig.set("spawn." +  ".pitch", player.getLocation().getPitch());


        saveSpawn();

        player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("spawn_setted") );
        return true;
    }

    public void saveSpawn() {
        try {
            spawnConfig.save(spawnFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

