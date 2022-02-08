package dev.conah.serveradditions.utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatUtils implements  Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setMessage(ColorUtils.format(event.getMessage()));
    }
}