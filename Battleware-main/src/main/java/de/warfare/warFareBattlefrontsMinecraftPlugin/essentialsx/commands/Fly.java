package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player p){
            if (p.isOp()){
                if (p.getGameMode().equals(GameMode.SURVIVAL)||equals(GameMode.ADVENTURE)) {
                    if (p.getAllowFlight() == false) {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("activated_fly"));
                    } else {
                        p.setFlying(false);
                        p.setAllowFlight(false);
                        p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("deactivated_fly"));
                    }
                }else {
                    p.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("fly_eror"));
                }
            }else {
                p.sendMessage(Strings.getMessage("prefix")+ Strings.getMessage("not_allowed"));
            }
        }else {
            commandSender.sendMessage(Strings.getMessage("prefix")+ Strings.getMessage("non_player"));
        }
        return false;
    }
}
