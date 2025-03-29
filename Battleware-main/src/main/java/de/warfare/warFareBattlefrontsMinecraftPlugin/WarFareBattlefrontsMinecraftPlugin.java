package de.warfare.warFareBattlefrontsMinecraftPlugin;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.Tablist.Tab;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.*;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.Spawn.Spawn;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.Spawn.setSpawn;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.homes.Home;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.homes.SetHome;

import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.warp.SetWarp;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.warp.Warp;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.listener.OnJoin;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter.GamemodeTabCompleter;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter.HomeTabCompleter;
import de.warfare.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter.UnbanTabCompleter;
import de.warfare.warFareBattlefrontsMinecraftPlugin.warteschlange.adminCommand;
import de.warfare.warFareBattlefrontsMinecraftPlugin.warteschlange.warteSchlange;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public final class WarFareBattlefrontsMinecraftPlugin extends JavaPlugin {
    private FileConfiguration customConfig = null;
    private File customConfigFile = null;
    public static WarFareBattlefrontsMinecraftPlugin plugin;



    @Override
    public void onEnable() {
        plugin = this;

        getServer().broadcastMessage("WarFare-Battlefronts-MinecraftPlugin Initiliezt");
        //Commands from EssentialsX

        getCommand("gm").setExecutor(new Gamemode());
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("fly").setExecutor(new Fly());
        getCommand("unban").setExecutor(new unban());
        getCommand("v").setExecutor(new Vanish());
        getCommand("vanish").setExecutor(new Vanish());
        getCommand("ec").setExecutor(new EnderChest());
        getCommand("enderchest").setExecutor(new EnderChest());
        getCommand("sethome").setExecutor(new SetHome());
        getCommand("home").setExecutor(new Home());
        getCommand("warfareessentials").setExecutor(new WarfareEssentials());

        getCommand("setspawn").setExecutor(new setSpawn());
        getCommand("spawn").setExecutor(new Spawn());

        getCommand("setwarp").setExecutor(new SetWarp());
        getCommand("warp").setExecutor(new Warp());
        //TabCompleter from EssentialsX
        getCommand("gm").setTabCompleter(new GamemodeTabCompleter());
        getCommand("gamemode").setTabCompleter(new GamemodeTabCompleter());
        getCommand("unban").setTabCompleter(new UnbanTabCompleter());
        getCommand("home").setTabCompleter(new HomeTabCompleter());
        getCommand("warfareessentials").setExecutor(new WarfareEssentials());

        //listener for EssentialsX
        getServer().getPluginManager().registerEvents(new OnJoin(), this);


        //config
        saveDefaultConfig();
        Strings.load(this);

        //warteSchlange
        warteSchlange warteschlange = new warteSchlange();
        getCommand("adminStart").setExecutor(new adminCommand(warteschlange));

        //TabList
        Tab customTab = new Tab();
        customTab.modifyTabList(this);
        getServer().getPluginManager().registerEvents(new Tab(), this);
    }

    }





