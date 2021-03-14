package net.spigot.utils;

import org.simpleyaml.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessageManager {
    public File folder = new File("plugins/BungeeSystem");
    public File config = new File("plugins/BungeeSystem/Messages.yml");
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
