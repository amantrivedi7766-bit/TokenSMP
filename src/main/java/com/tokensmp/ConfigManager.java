package com.tokensmp;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private final TokenSMP plugin;
    private FileConfiguration dataConfig;
    private File dataFile;

    public ConfigManager(TokenSMP plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        createDataConfig();
    }

    private void createDataConfig() {
        dataFile = new File(plugin.getDataFolder(), "data.yml");
        if (!dataFile.exists()) {
            dataFile.getParentFile().mkdirs();
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        dataConfig = YamlConfiguration.loadConfiguration(dataFile);
    }

    public FileConfiguration getDataConfig() {
        return dataConfig;
    }

    public void saveDataConfig() {
        try {
            dataConfig.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadConfigs() {
        plugin.reloadConfig();
        dataConfig = YamlConfiguration.loadConfiguration(dataFile);
    }
}