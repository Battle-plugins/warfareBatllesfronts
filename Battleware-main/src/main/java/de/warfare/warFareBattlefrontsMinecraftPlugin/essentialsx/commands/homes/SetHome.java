package de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.homes;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetHome implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("non_player"));
            return true;
        }

        Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("home_name"));
            return true;
        }

        String homeName = args[0];
        File homesFile = new File("plugins/WarFare-Battlefronts-MinecraftPlugin", p.getUniqueId() + ".yml");

        if (!homesFile.exists()) {
            try {
                homesFile.createNewFile();
            } catch (IOException e) {
                p.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("home_creation_eror"));
                e.printStackTrace();
                return true;
            }
        }

        FileConfiguration homesConfig = YamlConfiguration.loadConfiguration(homesFile);


        homesConfig.set("homes." + homeName + ".World", p.getWorld().getName());
        homesConfig.set("homes." + homeName + ".X", p.getLocation().getX());
        homesConfig.set("homes." + homeName + ".Y", p.getLocation().getY());
        homesConfig.set("homes." + homeName + ".Z", p.getLocation().getZ());
        homesConfig.set("homes." + homeName + ".Yaw", p.getLocation().getYaw());
        homesConfig.set("homes." + homeName + ".Pitch", p.getLocation().getPitch());

        try {
            homesConfig.save(homesFile);
            p.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("home_setted") + homeName);
        } catch (IOException e) {
            p.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("failed_home"));
            e.printStackTrace();
        }

        return true;
    }
}
