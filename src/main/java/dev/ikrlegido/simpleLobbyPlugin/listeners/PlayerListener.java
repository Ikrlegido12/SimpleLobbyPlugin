package dev.ikrlegido.simpleLobbyPlugin.listeners;

import dev.ikrlegido.simpleLobbyPlugin.SimpleLobbyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    private SimpleLobbyPlugin plugin;
    public PlayerListener(SimpleLobbyPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void LobbyCoordsTeleportInLobbyWorld(PlayerJoinEvent event){
        Location location = new Location(Bukkit.getWorld(plugin.getMainConfigManager().getLobbyworld()), plugin.getMainConfigManager().getCoordX(), plugin.getMainConfigManager().getCoordY()+0.5, plugin.getMainConfigManager().getCoordZ(), plugin.getMainConfigManager().getYaw(), plugin.getMainConfigManager().getPitch());
        if (event.getPlayer().getLocation().getWorld().equals(plugin.getMainConfigManager().getLobbyworld())){
            event.getPlayer().teleport(location);
        }
    }

    @EventHandler
    public void LobbyDeath(PlayerDeathEvent event){
        if (plugin.getMainConfigManager().isIfDeathInThisWroldTeleportToLobby()) {
            Location location = new Location(Bukkit.getWorld(plugin.getMainConfigManager().getLobbyworld()), plugin.getMainConfigManager().getCoordX(), plugin.getMainConfigManager().getCoordY() + 0.5, plugin.getMainConfigManager().getCoordZ(), plugin.getMainConfigManager().getYaw(), plugin.getMainConfigManager().getPitch());
            Location deathLoc = event.getEntity().getLocation();
            if (deathLoc.getWorld().toString().equals(plugin.getMainConfigManager().getLobbyworld())) {
                Player player = event.getEntity();
                if (player.isDead()) {
                    player.spigot().respawn();
                }
                player.teleport(location);
            }
        }
    }

}
