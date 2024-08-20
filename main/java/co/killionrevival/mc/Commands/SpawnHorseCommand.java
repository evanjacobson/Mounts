package co.killionrevival.mc.Commands;

import co.killionrevival.mc.Objects.GoldenMountEntity;
import co.killionrevival.mc.Objects.LeatherMountEntity;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnHorseCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;

        if(args.length < 1){
            player.sendMessage("You must specify the horse type: horse, skeleton, or zombie");
            return false;
        }

        var horseType = args[0].toLowerCase();

        switch(horseType){
            case "horse":
                new GoldenMountEntity().spawnEntity(player);
                break;
            case "zombie":
                new LeatherMountEntity().spawnEntity(player);
                break;
            case "skeleton":
            default:
                return false;
        }

        player.sendMessage("Spawned your " + horseType + " horse");
        return true;
//
//        ItemStack horseEgg = new ItemStack(Material.HORSE_SPAWN_EGG);
//
//
//        player.getInventory().addItem();

    }
}
