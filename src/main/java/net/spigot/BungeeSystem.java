package net.spigot;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import net.spigot.commands.TeamChatCommand;
import net.spigot.utils.ConfigManager;
import net.spigot.utils.MessageManager;

public class BungeeSystem extends Plugin {

    private static BungeeSystem instance;

    ConfigManager configManager = new ConfigManager();
    MessageManager messageManager = new MessageManager();

    @Override
    public void onEnable() {
        instance = this;

        configManager.createFilesIfNotExists();
        messageManager.createFilesIfNotExists();

        registerEverything();
    }

    public void registerEverything() {
        PluginManager manager = ProxyServer.getInstance().getPluginManager();

        manager.registerCommand(this, new TeamChatCommand());
    }
}
