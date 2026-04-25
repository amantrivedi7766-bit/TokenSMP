package com.tokensmp;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomItems {

    public static ItemStack getReviveToken() {
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§a§lRevive Token");
        List<String> lore = new ArrayList<>();
        lore.add("§7Use this to revive a fallen player.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getSpinToken() {
        ItemStack item = new ItemStack(Material.GOLD_INGOT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6§lSpin Token");
        List<String> lore = new ArrayList<>();
        lore.add("§7Use this to spin for a new token!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}