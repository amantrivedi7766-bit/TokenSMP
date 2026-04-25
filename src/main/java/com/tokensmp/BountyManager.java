package com.tokensmp;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BountyManager {

    private final TokenSMP plugin;
    private final Map<UUID, Double> bounties = new HashMap<>();

    public BountyManager(TokenSMP plugin) {
        this.plugin = plugin;
    }

    public void setBounty(UUID playerUUID, double amount) {
        bounties.put(playerUUID, amount);
    }

    public double getBounty(UUID playerUUID) {
        return bounties.getOrDefault(playerUUID, 0.0);
    }

    public void removeBounty(UUID playerUUID) {
        bounties.remove(playerUUID);
    }
}