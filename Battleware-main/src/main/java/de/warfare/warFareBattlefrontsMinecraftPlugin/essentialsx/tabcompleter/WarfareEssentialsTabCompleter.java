package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WarfareEssentialsTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        // Wenn der Benutzer 'reload' oder 'disable' eingibt
        if (args.length == 1) {
            if ("reload".startsWith(args[0].toLowerCase())) {
                completions.add("reload");
            }
            if ("disable".startsWith(args[0].toLowerCase())) {
                completions.add("disable");
            }
        }

        return completions;
    }
}
