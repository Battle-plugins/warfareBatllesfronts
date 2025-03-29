package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.tpa;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TpaAccept implements CommandExecutor {

    private Map<String, String> tpaRequests = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("non_player"));
            return false;
        }
        Player player = (Player) sender;

        if (!tpaRequests.containsKey(player.getName())) {
            player.sendMessage(ChatColor.RED + "Du hast keine Teleportationsanfrage.");
            return false;
        }

        String requesterName = tpaRequests.get(player.getName());
        Player requester = Bukkit.getPlayer(requesterName);

        if (requester == null || !requester.isOnline()) {
            player.sendMessage(ChatColor.RED + "Der Spieler, der die Anfrage gesendet hat, ist nicht mehr online.");
            return false;
        }


        player.teleport(requester.getLocation());
        player.sendMessage(ChatColor.GREEN + "Du wurdest zu " + requester.getName() + " teleportiert.");
        requester.sendMessage(ChatColor.GREEN + player.getName() + " hat deine Teleportationsanfrage akzeptiert...");

        tpaRequests.remove(player.getName());
        //fick die github.com

        return true;
    }
}
