package net.spigot.utils;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ConfigManager {
    public File folder = new File("plugins/BungeeSystem");
    public File config = new File("plugins/BungeeSystem/Config.yml");
    public Configuration cfg;

    {
        try {
            cfg = ConfigurationProvider.getProvider(YamlConfiguration.class).load(config);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // Core
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

        // TeamChat Command
        ArrayList<String> teamchatAliases = new ArrayList<>();
        teamchatAliases.add("tc");
        cfg.set("Commands.teamchat.enabled", true);
        cfg.set("Commands.teamchat.permission", "bungeesystem.teamchat");
        cfg.set("Commands.teamchat.aliases", teamchatAliases);
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
    //




    //GETTING
    public boolean isTeamChatEnabled() {
        return cfg.getBoolean("Commands.teamchat.enabled");
    }
    public String getTeamChatPermission() {
        return cfg.getString("Commands.teamchat.permission");
    }
    public ArrayList getTeamChatAliases() {
        return (ArrayList) cfg.getStringList("Commands.teamchat.aliases");
    }
    //
}
