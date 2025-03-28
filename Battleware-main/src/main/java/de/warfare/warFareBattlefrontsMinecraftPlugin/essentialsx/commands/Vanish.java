package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Vanish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player p){
            if (p.isOp()){
               if (p.isInvisible()){
                   p.setInvisible(false);
                   p.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("disabled_vanish"));
               }else {
                   p.setInvisible(true);
                   p.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("enabled_vanish"));
               }
            }else {
                p.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("not_allowed"));
            }
        }else {
            sender.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("non_player"));
        }
        return false;
    }
}
