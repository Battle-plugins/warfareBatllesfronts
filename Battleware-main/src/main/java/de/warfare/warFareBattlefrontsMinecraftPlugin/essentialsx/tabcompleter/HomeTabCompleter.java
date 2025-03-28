package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomeTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender instanceof Player)) {
            return new ArrayList<>();
        }

        Player p = (Player) sender;
        File homesFile = new File("plugins/WarFare-Battlefronts-MinecraftPlugin", p.getUniqueId() + ".yml");

        if (!homesFile.exists()) {
            return new ArrayList<>();
        }

        FileConfiguration homesConfig = YamlConfiguration.loadConfiguration(homesFile);

        if (!homesConfig.contains("homes")) {
            return new ArrayList<>();
        }

        Set<String> homeNames = homesConfig.getConfigurationSection("homes").getKeys(false);
        return new ArrayList<>(homeNames);
    }
}
