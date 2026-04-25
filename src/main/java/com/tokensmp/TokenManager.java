package com.tokensmp;

import com.tokensmp.tokens.Token;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenManager {

    private final TokenSMP plugin;
    private final Map<UUID, Token> playerTokens = new HashMap<>();

    public TokenManager(TokenSMP plugin) {
        this.plugin = plugin;
    }

    public void setToken(Player player, Token token) {
        playerTokens.put(player.getUniqueId(), token);
        plugin.getConfigManager().getDataConfig().set("players." + player.getUniqueId() + ".token", token.name());
        plugin.getConfigManager().saveDataConfig();
    }

    public Token getToken(Player player) {
        return playerTokens.get(player.getUniqueId());
    }

    public void loadPlayer(Player player) {
        String tokenName = plugin.getConfigManager().getDataConfig().getString("players." + player.getUniqueId() + ".token");
        if (tokenName != null) {
            try {
                playerTokens.put(player.getUniqueId(), Token.valueOf(tokenName));
            } catch (IllegalArgumentException ignored) {}
        }
    }
}