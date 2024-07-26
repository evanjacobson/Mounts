package co.killionrevival.mc;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

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
        ItemStack item = event.getItem();
        if (item == null) {
            return;
        }

        Player player = event.getPlayer();
        Action action = event.getAction();


        var horseArmor = List.of(Material.LEATHER_HORSE_ARMOR, Material.IRON_HORSE_ARMOR, Material.GOLDEN_HORSE_ARMOR, Material.DIAMOND_HORSE_ARMOR);

        if (action.isRightClick() && horseArmor.contains(item.getType())) {

            //var targetLocation = player.getLocation().add(player.getEyeLocation().getDirection());

            var target = player.getTargetBlock(null, 5);

            var loc = target.getLocation();

            if (target.isSolid()) {
                loc.add(0, 1, 0);
            }

            player.getWorld().spawnEntity(loc, EntityType.HORSE);
            player.sendMessage("Spawned your horse " + target.getLocation().distance(player.getLocation()) + " blocks away");
        }
    }

}
