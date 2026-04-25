package com.tokensmp;

import com.tokensmp.commands.*;
import com.tokensmp.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class TokenSMP extends JavaPlugin {

    private static TokenSMP instance;
    private ConfigManager configManager;
    private TokenManager tokenManager;
    private LifeManager lifeManager;

    @Override
    public void onEnable() {
        instance = this;

        // Initialize Managers
        this.configManager = new ConfigManager(this);
        this.tokenManager = new TokenManager(this);
        this.lifeManager = new LifeManager(this);

        // Register Commands
        getCommand("tokens").setExecutor(new TokensCommand(this));
        getCommand("tokeninfo").setExecutor(new TokenInfoCommand(this));
        getCommand("spin").setExecutor(new SpinCommand(this));
        getCommand("tokensmp").setExecutor(new TokenSMPCommand(this));

        // Register Listeners
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
        getServer().getPluginManager().registerEvents(new ItemUseListener(this), this);
        getServer().getPluginManager().registerEvents(new AbilityListener(this), this);
        getServer().getPluginManager().registerEvents(new ReviveListener(this), this);

        getLogger().info("TokenSMP has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TokenSMP has been disabled!");
    }

    public static TokenSMP getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public TokenManager getTokenManager() {
        return tokenManager;
    }

    public LifeManager getLifeManager() {
        return lifeManager;
    }
}