package co.killionrevival.mc.Objects.Abstract;

import co.killionrevival.mc.Interfaces.IMountEntity;
import co.killionrevival.mc.Utils.HorseAttributes;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public abstract class MountEntity implements IMountEntity {

    public AbstractHorse AbstractHorseEntity;
    public EntityType HorseType;

    public MountEntity(EntityType horseType){
        HorseType = horseType;
    }

    @Override
    public AbstractHorse spawnEntity(Player player, ItemStack spawnItem) {
        var loc = getHorseSpawnLocation(player);

        var spawnedEntity = (AbstractHorse) player.getWorld().spawnEntity(loc, this.HorseType);

        spawnedEntity.setTamed(true);
        spawnedEntity.addScoreboardTag(player.getName());
        spawnedEntity.setAdult();
        spawnedEntity.getInventory().setSaddle(new ItemStack(Material.SADDLE));

        this.AbstractHorseEntity = spawnedEntity;

        var container = spawnItem.getItemMeta().getPersistentDataContainer();

        try{
            for(NamespacedKey key : container.getKeys()){
                var keyName = key.getKey();
                var val = container.get(key, PersistentDataType.DOUBLE);
                setAttributeValue(keyName, val);
                player.sendMessage("Key: " + keyName + " | Value: " + val);
            }
        }
        catch(NullPointerException ex){

        }

        return this.AbstractHorseEntity;
    }

    private Location getHorseSpawnLocation(Player player){
        var block = player.getTargetBlock(null,5);

        var blockFace = player.getTargetBlockFace(5);

        return blockFace != null
                ? block.getRelative(blockFace).getLocation()
                : block.getLocation();
    }

    @Override
    public void setAttributeValue(String fieldName, double value) {

        if(!isSpawned()){
            Bukkit.getServer().getConsoleSender().sendMessage("The horse must exist to have attributes!");
            return;
        }

        var attr = HorseAttributes.getAttribute(fieldName);
        Objects.requireNonNull(AbstractHorseEntity.getAttribute(attr)).setBaseValue(value);
    }

    public AbstractHorse getHorseEntity(){
        return isSpawned()
                ? AbstractHorseEntity
                : null;
    }

    private boolean isSpawned(){
        return AbstractHorseEntity != null;
    }
}