package dev.ikrlegido.simpleLobbyPlugin;

import dev.ikrlegido.simpleLobbyPlugin.config.MainConfigManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleLobbyPlugin extends JavaPlugin {

    private MainConfigManager mainConfigManager;
    public String version = getDescription().getVersion();

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommands();
        registerEvents();
        mainConfigManager = new MainConfigManager(this);
        Bukkit.getConsoleSender().sendMessage(
                Component.text("Iniciando SimpleLobbyPlugin. ")
                .color(TextColor.color(NamedTextColor.AQUA))
                .append(Component.text("Versión: "))
                .color(TextColor.color(NamedTextColor.WHITE))
                .append(Component.text(version))
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents(){

    }

    public void registerCommands() {

    }

    public MainConfigManager getMainConfigManager() {
        return mainConfigManager;
    }
}
