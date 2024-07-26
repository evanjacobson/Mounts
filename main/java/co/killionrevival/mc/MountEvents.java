package co.killionrevival.mc;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
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
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if ( action.equals( Action.RIGHT_CLICK_AIR ) || action.equals( Action.RIGHT_CLICK_BLOCK ) ) {
            if ( item != null && item.getType() == Material.LEATHER_HORSE_ARMOR ) {
                player.sendMessage( "You have right clicked " + Material.LEATHER_HORSE_ARMOR.toString());
            }
        }

    }
}
