package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WarpTabCompleter implements TabCompleter {
    private final FileConfiguration config;

    public WarpTabCompleter(FileConfiguration config) {
        this.config = config;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> suggestions = new ArrayList<>();
        if (args.length == 1) {
            Set<String> warpNames = config.getConfigurationSection("warps").getKeys(false);
            for (String warpName : warpNames) {
                suggestions.add(warpName);
            }
        }

        return suggestions;
    }
}
