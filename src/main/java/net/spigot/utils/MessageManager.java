package net.spigot.utils;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessageManager {
    public File folder = new File("plugins/BungeeSystem");
    public File config = new File("plugins/BungeeSystem/Messages.yml");
    public Configuration cfg;

    {
        try {
            cfg = ConfigurationProvider.getProvider(YamlConfiguration.class).load(config);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void createFilesIfNotExists() {
        if(!folder.exists())
            folder.mkdirs();
        if(!config.exists()) {
            try {
                config.createNewFile();
                addConfigContent();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    private void addConfigContent() {
        cfg.set("Prefix", "&cBungeeSystem &8| &7");
        cfg.set("MissingPermission", "{prefix} &cYou don't have permissions!");
        // TeamChat Command
        cfg.set("TeamChat.format", "{prefix} &8[&7{server}&8] &e{player} &8-> &f{message}");
        //

        saveConfig();
    }

    private void saveConfig() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(cfg, config);
            cfg = ConfigurationProvider.getProvider(YamlConfiguration.class).load(config);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // GETTING MESSAGES
    public String getPrefix() {
        return cfg.getString("Prefix").replaceAll("&", "§");
    }
    public String getMissingPermission() {
        return cfg.getString("MissingPermission").replaceAll("&", "§");
    }

    public String getTeamChatFormat(String server, String playerName, String message) {
        return cfg.getString("TeamChat.format").
                replaceAll("&", "§").
                replace("{prefix}", getPrefix()).
                replace("{server}", server).
                replace("{player}", playerName).
                replace("{message}", message);
    }
    //
}
