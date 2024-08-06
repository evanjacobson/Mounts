package co.killionrevival.mc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mounts extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(MountEvents.getInstance(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
