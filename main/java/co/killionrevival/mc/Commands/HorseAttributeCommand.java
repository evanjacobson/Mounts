package co.killionrevival.mc.Commands;

import co.killionrevival.mc.Utils.EntityUtils;
import co.killionrevival.mc.Utils.PersistentKeys;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HorseAttributeCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            return false;
        }

        if(args.length < 2){
            return false;
        }

        var horseEgg = player.getInventory().getItemInMainHand();
        if(!horseEgg.getItemMeta().getPersistentDataContainer().has(PersistentKeys.IS_MOUNT_EGG)){
            return false;
        }

        List<String> attributes = EntityUtils.getAttributeNames();
        String attrName = args[0];

        if(!attributes.contains(attrName.toUpperCase())){
            return false;
        }

        String val = args[1];
        double d;

        var persistentKey = EntityUtils.getPersistentKey(attrName);
        if(persistentKey == null){
            return false;
        }

        var itemMeta = horseEgg.getItemMeta();

        try{
            d = Double.parseDouble(val);
            itemMeta.getPersistentDataContainer().set(persistentKey, PersistentDataType.DOUBLE, d);
        }
        catch(NumberFormatException ex){
            if(!val.equalsIgnoreCase("unset")){
                return false;
            }

            itemMeta.getPersistentDataContainer().remove(persistentKey);

        }

        var container = itemMeta.getPersistentDataContainer();
        var keys = new HashSet<>(container.getKeys());
        keys.remove(PersistentKeys.IS_MOUNT_EGG);

        List<Component> lore = new ArrayList<>();
        for(var data : keys){
            Component c = Component.text(data.getKey() + ": " + container.get(data, PersistentDataType.DOUBLE), NamedTextColor.DARK_RED);
            lore.add(c);
        }

        itemMeta.lore(lore);

        horseEgg.setItemMeta(itemMeta);

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length < 2){
            return EntityUtils.getAttributeNames().stream().filter(attr -> attr.startsWith(args[0].toUpperCase())).toList();
        }
        return List.of("unset", "<enter a decimal value here>");
    }
}
