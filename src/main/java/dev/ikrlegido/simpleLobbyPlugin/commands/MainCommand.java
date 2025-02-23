package dev.ikrlegido.simpleLobbyPlugin.commands;

import dev.ikrlegido.simpleLobbyPlugin.SimpleLobbyPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor {
    private final SimpleLobbyPlugin plugin;
    public MainCommand(SimpleLobbyPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(Component.text("La consola no puede ser teletransportada."));
            return true;
        }
        if(args.length >= 1){
            if(args[0].equals("reload")){
                subCommandReload(sender);
            return false;
            } else {
                sender.sendMessage(Component.text("Subcomando no valido"));
            }

        } else {
            Location location = new Location(Bukkit.getWorld(plugin.getMainConfigManager().getLobbyworld()), plugin.getMainConfigManager().getCoordX(), plugin.getMainConfigManager().getCoordY()+0.5, plugin.getMainConfigManager().getCoordZ(), plugin.getMainConfigManager().getYaw(), plugin.getMainConfigManager().getPitch());
            ((Player) sender).getPlayer().teleport(location);
        }
        return false;
    }

    public void subCommandReload(CommandSender sender) {
        if (!sender.hasPermission("simplelobbyplugin.admin")) {
            sender.sendMessage(Component.text("&cNo tienes permisos para usar este comando."));
            return;
        }
        plugin.getMainConfigManager().reloadConfig();
        sender.sendMessage(Component.text("&aConfiguración recargada."));
    }
}
