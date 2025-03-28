package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class unban implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender.isOp()){
            String targetName = args[0];
            if (args.length != 1) {
                commandSender.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("unban_usage"));
                return true;
            }

            if (!Bukkit.getBanList(BanList.Type.NAME).isBanned(targetName)) {
                commandSender.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("non_banned_player"));
            }else {
                Bukkit.getBanList(BanList.Type.NAME).pardon(targetName);
                commandSender.sendMessage(Strings.getMessage("prefix")+targetName +Strings.getMessage("unban"));
            }
        }else {
            commandSender.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("non_player"));
        }
        return false;
    }
}
