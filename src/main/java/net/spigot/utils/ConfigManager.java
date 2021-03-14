package net.spigot.utils;

import org.simpleyaml.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    public File folder = new File("plugins/BungeeSystem");
    public File config = new File("plugins/BungeeSystem/Config.yml");
    public YamlConfiguration cfg = YamlConfiguration.loadConfiguration(config);

    public void createFilesIfNotExists() {
        if(!folder.exists())
            folder.mkdirs();
        if(!config.exists()) {
            try {
                config.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
