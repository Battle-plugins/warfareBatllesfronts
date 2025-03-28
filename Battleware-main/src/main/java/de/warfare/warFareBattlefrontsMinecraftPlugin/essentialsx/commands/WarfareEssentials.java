package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands;

import de.warfare.warFareBattlefrontsMinecraftPlugin.WarFareBattlefrontsMinecraftPlugin;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class WarfareEssentials implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender.isOp()) {
            if (commandSender instanceof Player p) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("reload")) {
                        Bukkit.reload();
                        p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("reload"));
                    } else if (args[0].equalsIgnoreCase("disable")) {
                        Bukkit.getPluginManager().disablePlugin(WarFareBattlefrontsMinecraftPlugin.plugin);
                    }
                } else {
                    p.sendMessage(Strings.getMessage("prefix") + "§cVerwendung: /warfareessentials <reload/disable>");
                }

            } else {
                commandSender.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("non_player"));
            }
        }else {
            commandSender.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("not_allowed"));
        }
        return true;
    }


}
