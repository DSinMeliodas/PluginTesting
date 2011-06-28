package com.pandarr.plugintesting;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginTesting extends JavaPlugin {
    private static final PTPlayerListener myPlayerListener = new PTPlayerListener();

    public void onDisable() {
        
    }

    public void onEnable() {
        PluginManager pluginManager = this.getServer().getPluginManager();
        
        pluginManager.registerEvent(Type.PLAYER_JOIN, myPlayerListener, Priority.Monitor, this);
    }
}
