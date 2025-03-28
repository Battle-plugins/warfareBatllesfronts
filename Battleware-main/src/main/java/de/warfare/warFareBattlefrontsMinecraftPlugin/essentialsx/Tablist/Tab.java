package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Tablist;


import de.warfare.warFareBattlefrontsMinecraftPlugin.WarFareBattlefrontsMinecraftPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;


import java.lang.reflect.Field;

public class Tab implements Listener {

    public void modifyTabList(WarFareBattlefrontsMinecraftPlugin plugin) {
        new BukkitRunnable() {
            @Override
            public void run() {

                for (Player player : Bukkit.getOnlinePlayers()) {

                    String header = ChatColor.GREEN + "Welcome to WareFareBattleFronts!";
                    String footer = ChatColor.YELLOW + "This is an Footer: ";

                    player.setPlayerListHeader(header);
                    player.setPlayerListFooter(footer);

                    String tabName = ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.WHITE;
                    player.setPlayerListName(tabName);

                    if (player.isOp()) {
                        player.setPlayerListName(ChatColor.RED + "[Admin] " + player.getName());
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 100);
    }


    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        String prefix = "";

        if (player.isOp()) {
            prefix = ChatColor.RED + "[Admin] " + ChatColor.WHITE;
            event.setFormat(prefix + event.getPlayer().getName() + ": " + event.getMessage());
        }
    }
}
