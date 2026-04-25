package com.tokensmp;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {

    private final Map<UUID, Map<String, Long>> cooldowns = new HashMap<>();

    public void setCooldown(UUID playerUUID, String abilityName, int seconds) {
        long cooldownTime = System.currentTimeMillis() + (seconds * 1000L);
        cooldowns.computeIfAbsent(playerUUID, k -> new HashMap<>()).put(abilityName, cooldownTime);
    }

    public long getCooldown(UUID playerUUID, String abilityName) {
        Map<String, Long> playerCooldowns = cooldowns.get(playerUUID);
        if (playerCooldowns == null || !playerCooldowns.containsKey(abilityName)) {
            return 0;
        }
        return Math.max(0, playerCooldowns.get(abilityName) - System.currentTimeMillis());
    }

    public boolean isOnCooldown(UUID playerUUID, String abilityName) {
        return getCooldown(playerUUID, abilityName) > 0;
    }
}