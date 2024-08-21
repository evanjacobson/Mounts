package co.killionrevival.mc.Commands;

import co.killionrevival.mc.Utils.PersistentKeys;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class SpawnHorseCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        var horseEgg = new ItemStack(Material.HORSE_SPAWN_EGG);
        var meta = horseEgg.getItemMeta();
        var container = meta.getPersistentDataContainer();

        meta.itemName(Component.text("Horse Mount Egg", NamedTextColor.GOLD));

        container.set(PersistentKeys.IS_MOUNT_EGG, PersistentDataType.DOUBLE, 1.0);

        horseEgg.setItemMeta(meta);

        player.getInventory().addItem(horseEgg);

        return true;

    }

}
