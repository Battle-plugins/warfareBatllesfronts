package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.tpa;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Tpa implements CommandExecutor {
    private Map<String, String> tpaRequests = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(Strings.getMessage( "prefix")+ Strings.getMessage("tpaUsage"));
            return false;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("non_player"));
            return false;
        }
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null || !target.isOnline()) {
            player.sendMessage(Strings.getMessage("prefix")+ Color.RED + Strings.getMessage("not_online"));
            return false;
        }
        tpaRequests.put(target.getName(), player.getName());
        target.sendMessage(Strings.getMessage("prefix")+ player.getName() + Strings.getMessage("want_teleport"));
        player.sendMessage( Strings.getMessage("sended_tpa") + target.getName() );

        return true;
    }
}
