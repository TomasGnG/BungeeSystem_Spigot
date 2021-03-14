package net.spigot;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class BungeeSystem extends Plugin {

    private static BungeeSystem instance;

    @Override
    public void onEnable() {
        instance = this;

        registerEverything();
    }

    public void registerEverything() {
        PluginManager manager = ProxyServer.getInstance().getPluginManager();
    }
}
