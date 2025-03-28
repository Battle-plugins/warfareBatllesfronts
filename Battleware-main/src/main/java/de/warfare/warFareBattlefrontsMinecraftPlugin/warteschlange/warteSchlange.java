package de.warfare.warFareBattlefrontsMinecraftPlugin.warteschlange;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Set;

public class warteSchlange {
    private final Set<Player> wartendeSpieler = new HashSet<>();

    public void spielerBeitreten(Player player) {
        wartendeSpieler.add(player);
        player.sendMessage(Strings.getMessage("prefix")+"you joined the quere (" + wartendeSpieler.size() + "/20)");

        if (wartendeSpieler.size() >= 1) {
            starteRunde();
        }
    }

    public void starteRunde() {
        Bukkit.broadcastMessage(Strings.getMessage("prefix")+Strings.getMessage("enough_player"));
        starteCooldown();
    }

    public void adminStart() {
        starteCooldown();
    }

    private void starteCooldown() {
        new BukkitRunnable() {
            int countdown = 5;
            final ChatColor[] farben = {ChatColor.GREEN, ChatColor.YELLOW, ChatColor.GOLD, ChatColor.RED, ChatColor.DARK_RED};

            @Override
            public void run() {
                if (countdown > 0) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendTitle(farben[5 - countdown] + "" + countdown, "Rounds starts soon", 5, 20, 5);
                    }
                    countdown--;
                } else {
                    Bukkit.broadcastMessage(Strings.getMessage("prefix")+Strings.getMessage("started"));
                    wartendeSpieler.clear();
                    cancel();
                }
            }
        }.runTaskTimer(Bukkit.getPluginManager().getPlugin("WarFare-Battlefronts-MinecraftPlugin"), 0, 20);
    }
}
