package com.tokensmp.tokens;

import org.bukkit.Material;

public enum Token {
    STRENGTH("Strength", Material.REDSTONE_BLOCK, "Increases physical power."),
    SPEED("Speed", Material.SUGAR, "Increases movement speed."),
    RESISTANCE("Resistance", Material.IRON_BLOCK, "Reduces incoming damage."),
    LUCK("Luck", Material.RABBIT_FOOT, "Increases rare drop chances.");

    private final String displayName;
    private final Material material;
    private final String description;

    Token(String displayName, Material material, String description) {
        this.displayName = displayName;
        this.material = material;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Material getMaterial() {
        return material;
    }

    public String getDescription() {
        return description;
    }
}