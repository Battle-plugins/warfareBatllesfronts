package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands;


import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player p){
            if(p.hasPermission("rank.ec")){
                if (args.length == 0) {
                    p.openInventory(p.getEnderChest());
                    p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("enderchest_open"));
                }else {
                    if (p.isOp()){
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if (target == null || !target.isOnline()) {
                            p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("offline_player"));
                            return true;
                        }else {
                            p.openInventory(target.getEnderChest());
                            p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("opened_enderchest") + target );
                        }
                    }else {
                        p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("not_allowed"));
                    }
                }
            } else {
                p.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("not_allowed"));
            }
        }else {
            commandSender.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("non_player"));
        }
        return false;
    }
}
