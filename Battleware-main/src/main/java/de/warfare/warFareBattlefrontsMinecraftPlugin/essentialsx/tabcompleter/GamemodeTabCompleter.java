package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter;

import de.warfare.warFareBattlefrontsMinecraftPlugin.values.TabCompleterStrings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class GamemodeTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> suggestions = new ArrayList<>();
        if (command.getName().equalsIgnoreCase("gamemode") || command.getName().equalsIgnoreCase("gm")) {
            if (args.length == 1) {
                suggestions.add(TabCompleterStrings.survival);
                suggestions.add(TabCompleterStrings.creative);
                suggestions.add(TabCompleterStrings.adventure);
                suggestions.add(TabCompleterStrings.spectator);
                suggestions.add(TabCompleterStrings.gamemode0);
                suggestions.add(TabCompleterStrings.gamemode1);
                suggestions.add(TabCompleterStrings.gamemode2);
                suggestions.add(TabCompleterStrings.gamemode3);
            }
        }
        return suggestions;
    }

}
