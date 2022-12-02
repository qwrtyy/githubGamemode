/*
 * githubGamemode
 * Copyright (C) 2022 qwrtyy
 */

package cc.qwrtyy.github.commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class GamemodeCommand implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sendMessage(sender, "&7[githubGamemode] &4[!] &7Nie jestes &cgraczem!");
            return true;
        }
        Player player = (Player)sender;

        if (args.length < 1)
            return sendMessage(player, "&4[!] &7Poprawne uzycie: &c/gamemode <tryb> <gracz>");

        Player target;

        if (args.length < 2)
            target = player;
        else
            target = Bukkit.getPlayerExact(args[1]);

        if (target == null)
            return sendMessage(player, "&4[!] &7Nie znaleziono &cgracza!");

        int gameModeValue = 0;

        try {
            gameModeValue = Integer.parseInt(args[0]);
        } catch (Exception e) {
            return sendMessage(player, "&4[!] &7To nie jest &cliczba");
        }

        GameMode gameMode = GameMode.getByValue(gameModeValue);

        target.setGameMode(gameMode);

        sendTitle(player, "", "&7Zmieniles tryb gry na &d"+ gameMode);

        return true;
    }
    private boolean sendMessage(final @NotNull CommandSender player, final String message) {
        player.sendMessage(fixColor(message));
        return true;
    }
    private void sendTitle(final @NotNull Player player, final String titleMessage, final String subTitleMessage) {
        player.sendTitle(fixColor(titleMessage), fixColor(subTitleMessage));
    }
    public static @NotNull String fixColor(final String s) {
        return ChatColor.translateAlternateColorCodes('&', s)
                .replace(">>", "»")
                .replace("<<", "«");
    }
}