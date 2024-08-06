package co.killionrevival.mc;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
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
            var block = player.getTargetBlock(null,5);
            var blockFace = player.getTargetBlockFace(5);

            var loc = blockFace != null
                    ? block.getRelative(blockFace).getLocation()
                    : block.getLocation();

            var horse = (Horse) player.getWorld().spawnEntity(loc, EntityType.HORSE);
            horse.setColor(Horse.Color.CHESTNUT);
            horse.setStyle(Horse.Style.BLACK_DOTS);
            //horse.setLeashHolder(player);
            horse.setTamed(true);
            horse.addScoreboardTag("Name");
            horse.setAdult();
            horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(10);
            horse.getAttribute(Attribute.GENERIC_JUMP_STRENGTH).setBaseValue(1000);
            horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));

            player.sendMessage("Spawned your horse " + loc.distance(player.getLocation()) + " blocks away");
        }
    }

}
