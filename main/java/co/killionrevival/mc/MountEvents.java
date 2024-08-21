package co.killionrevival.mc;

import co.killionrevival.mc.Objects.MountHorse;
import co.killionrevival.mc.Utils.PersistentKeys;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class MountEvents implements Listener {

    //region Singleton Loader
    private static MountEvents instance = null;

    private MountEvents(){}

    public static synchronized MountEvents getInstance()
    {
        if(instance == null){
            instance = new MountEvents();
        }

        return instance;
    }
    //endregion

    @EventHandler
    public void onPlayerClicks(PlayerInteractEvent event) {

        if(!event.getAction().isRightClick()){
            return;
        }

        ItemStack item = event.getItem();
        if (item == null
                || !item.getItemMeta().getPersistentDataContainer().has(PersistentKeys.IS_MOUNT_EGG)) {
            return;
        }

        event.setCancelled(true);

        Player player = event.getPlayer();

        if(!player.hasPermission("mounts.events.spawn")){
            player.sendMessage(Component.text("You do not have permission to use mount eggs", NamedTextColor.DARK_RED));
            return;
        }

        new MountHorse().spawnEntity(player, item);
    }
}
