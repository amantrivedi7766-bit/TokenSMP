package com.tokensmp;

import org.bukkit.entity.Player;

public class LifeManager {

    private final TokenSMP plugin;

    public LifeManager(TokenSMP plugin) {
        this.plugin = plugin;
    }

    public int getLives(Player player) {
        return plugin.getConfigManager().getDataConfig().getInt("players." + player.getUniqueId() + ".lives", 3);
    }

    public void setLives(Player player, int lives) {
        plugin.getConfigManager().getDataConfig().set("players." + player.getUniqueId() + ".lives", lives);
        plugin.getConfigManager().saveDataConfig();
    }

    public void removeLife(Player player) {
        int lives = getLives(player) - 1;
        setLives(player, Math.max(0, lives));
    }

    public void addLife(Player player) {
        setLives(player, getLives(player) + 1);
    }
}