package de.warfare.warFareBattlefrontsMinecraftPlugin.warteschlange;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class adminCommand implements CommandExecutor {
    private final warteSchlange warteschlange;

    public adminCommand(warteSchlange warteschlange) {
        this.warteschlange = warteschlange;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                warteschlange.adminStart();
                player.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("game_start"));
            } else {
                player.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("not_allowed"));
            }
        } else {
            sender.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("non_player"));
        }
        return true;
    }
}
