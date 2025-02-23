package dev.ikrlegido.simpleLobbyPlugin.config;

import dev.ikrlegido.simpleLobbyPlugin.SimpleLobbyPlugin;
import org.bukkit.configuration.file.FileConfiguration;


public class MainConfigManager {

    private CustomConfig configFile;
    private SimpleLobbyPlugin plugin;

    private String lobbyworld;
    private int coordX;
    private int coordY;
    private int coordZ;
    private int pitch;
    private int yaw;
    private String protectedworld;
    private String message;
    private String item;
    private int hotbar;
    private String prefix;

    public MainConfigManager(SimpleLobbyPlugin plugin){
        this.plugin = plugin;
        configFile = new CustomConfig("config.yml",null,plugin,false);
        configFile.registerConfig();
        loadConfig();
    }

    public void loadConfig(){
        FileConfiguration config = configFile.getConfig();
        lobbyworld = config.getString("locations.lobby.lobbyworld");
        coordX = config.getInt("locations.lobby.coordX");
        coordY = config.getInt("locations.lobby.coordY");
        coordZ = config.getInt("locations.lobby.coordZ");
        pitch = config.getInt("locations.lobby.pitch");
        yaw = config.getInt("locations.lobby.yaw");
        protectedworld = config.getString("antiblockprevent.protectedworld");
        message = config.getString("antiblockprevent.message");
        item = config.getString("modalitymenu.item");
        hotbar = config.getInt("modalitymenu.hotbar");
        prefix = config.getString("messages.prefix");
    }

    public void reloadConfig(){
        configFile.reloadConfig();
        loadConfig();
    }

    public String getLobbyworld(){
        return lobbyworld;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getCoordX() {
        return coordX;
    }
    public int getCoordY() {
        return coordY;
    }
    public int getCoordZ() {
        return coordZ;
    }
    public int getPitch() {
        return pitch;
    }
    public int getYaw() {
        return yaw;
    }

    public String getProtectedworld() {
        return protectedworld;
    }
    public String getMessage() {
        return message;
    }
    public int getHotbar() {
        return hotbar;
    }
    public String getItem() {
        return item;
    }
}