package co.killionrevival.mc.Commands;

import co.killionrevival.mc.Utils.PersistentKeys;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpawnHorseCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if(args.length < 1){
            return false;
        }

        var horseEgg = new ItemStack(Material.HORSE_SPAWN_EGG);

        var meta = horseEgg.getItemMeta();
        var container = meta.getPersistentDataContainer();

        meta.itemName(Component.text("Horse Mount Egg", NamedTextColor.GOLD));

        container.set(PersistentKeys.IS_MOUNT_EGG, PersistentDataType.DOUBLE, 1.0);
//
//        container.set(PersistentKeys.ENTITY_SCALE, PersistentDataType.DOUBLE, 10.0);
//        container.set(PersistentKeys.MOVEMENT_EFFICIENCY, PersistentDataType.DOUBLE, 1.0);

        horseEgg.setItemMeta(meta);

        player.getInventory().addItem(horseEgg);

        return true;

    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return List.of();
    }
}
