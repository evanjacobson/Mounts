package co.killionrevival.mc;

import co.killionrevival.mc.Commands.HorseAttributeCommand;
import co.killionrevival.mc.Commands.SpawnHorseCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mounts extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(MountEvents.getInstance(), this);

        this.getCommand("mount").setExecutor(new SpawnHorseCommand());
        this.getCommand("mountedit").setExecutor(new HorseAttributeCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Mounts getInstance(){
        return getPlugin(Mounts.class);
    }
}
