package cc.qwrtyy.github;

import cc.qwrtyy.github.commands.GamemodeCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        final long load = System.currentTimeMillis() - System.currentTimeMillis(); //async
        Bukkit.getLogger().info("");
        Bukkit.getLogger().info("### Trwa wczytywanie pluginu na gamemode ###");
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        Bukkit.getLogger().info("     Komendy zaladowano w czasie: " + load + "ms.");
        Bukkit.getLogger().info("");
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
