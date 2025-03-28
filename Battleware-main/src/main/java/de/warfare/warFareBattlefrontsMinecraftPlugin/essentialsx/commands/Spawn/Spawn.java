package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.Spawn;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Util.TeleportToSpawn;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player p) {
            TeleportToSpawn.teleport(p);
        }else {
            commandSender.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("non_player"));
        }

        return false;
    }
}
