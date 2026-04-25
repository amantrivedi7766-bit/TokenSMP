package com.tokensmp.tokens;

import org.bukkit.entity.Player;

public abstract class TokenAbility {

    private final String name;
    private final int cooldown;

    public TokenAbility(String name, int cooldown) {
        this.name = name;
        this.cooldown = cooldown;
    }

    public String getName() {
        return name;
    }

    public int getCooldown() {
        return cooldown;
    }

    public abstract void activate(Player player);
}