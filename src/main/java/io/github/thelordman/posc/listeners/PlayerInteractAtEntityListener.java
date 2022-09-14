package io.github.thelordman.posc.listeners;

import io.github.thelordman.posc.guis.GUIHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class PlayerInteractAtEntityListener implements Listener {
    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked().getName().equals("Sylvester")) GUIHandler.openGUI(GUIHandler.GUIType.FOOD_SHOP, event.getPlayer());
        if (event.getRightClicked().getName().equals("Claus")) GUIHandler.openGUI(GUIHandler.GUIType.SHOP, event.getPlayer());
    }
}