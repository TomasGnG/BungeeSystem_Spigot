package net.spigot;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import net.spigot.utils.ConfigManager;

public class BungeeSystem extends Plugin {

    private static BungeeSystem instance;

    ConfigManager configManager = new ConfigManager();

    @Override
    public void onEnable() {
        instance = this;

        configManager.createFilesIfNotExists();

        registerEverything();
    }

    public void registerEverything() {
        PluginManager manager = ProxyServer.getInstance().getPluginManager();


    }
}
