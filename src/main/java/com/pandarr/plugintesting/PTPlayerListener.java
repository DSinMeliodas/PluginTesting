package com.pandarr.plugintesting;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class PTPlayerListener extends PlayerListener {

    /* (non-Javadoc)
     * @see org.bukkit.event.player.PlayerListener#onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent)
     */
    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.getName().startsWith("P")) {
            player.sendMessage("Welcome to the server!");
        }
    }
}
