package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.homes;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Home implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("non_player"));
            return true;
        }
        Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("home_usage"));
            return true;
        }
        String homeName = args[0];
        File homesFile = new File("plugins/WarFare-Battlefronts-MinecraftPlugin", p.getUniqueId() + ".yml");

        if (!homesFile.exists()) {
            p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("no_home"));
            return true;
        }

        FileConfiguration homesConfig = YamlConfiguration.loadConfiguration(homesFile);

        if (!homesConfig.contains("homes." + homeName)) {
            p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("non_existet_home"));
            return true;
        }

        World world = Bukkit.getWorld(homesConfig.getString("homes." + homeName + ".World"));
        double x = homesConfig.getDouble("homes." + homeName + ".X");
        double y = homesConfig.getDouble("homes." + homeName + ".Y");
        double z = homesConfig.getDouble("homes." + homeName + ".Z");
        float yaw = (float) homesConfig.getDouble("homes." + homeName + ".Yaw");
        float pitch = (float) homesConfig.getDouble("homes." + homeName + ".Pitch");

        if (world == null) {
            p.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("world_dont_exist_home"));
            return true;
        }

        Location homeLocation = new Location(world, x, y, z, yaw, pitch);
        p.teleport(homeLocation);
        p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("home_teleportet"));

        return true;
    }
}
