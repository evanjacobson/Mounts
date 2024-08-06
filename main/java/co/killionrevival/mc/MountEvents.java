package co.killionrevival.mc;

import co.killionrevival.mc.Objects.GoldenMountEntity;
import co.killionrevival.mc.Objects.LeatherMountEntity;
import org.bukkit.Material;
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
        if (item == null) {
            return;
        }

        switch(item.getType()){
            case Material.LEATHER_HORSE_ARMOR:
                new LeatherMountEntity().spawnEntity(event);
                break;
            case Material.IRON_HORSE_ARMOR:
                break;
            case Material.GOLDEN_HORSE_ARMOR:
                new GoldenMountEntity().spawnEntity(event);
                break;
            case Material.DIAMOND_HORSE_ARMOR:
                break;
            default:
                break;
        }
    }
}
