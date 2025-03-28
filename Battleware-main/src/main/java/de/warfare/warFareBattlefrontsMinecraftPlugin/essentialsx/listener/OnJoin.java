package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.listener;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Util.TeleportToSpawn;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(@NotNull PlayerJoinEvent e) {
        Player p = e.getPlayer();
        TeleportToSpawn.teleport(p);
    }
}
