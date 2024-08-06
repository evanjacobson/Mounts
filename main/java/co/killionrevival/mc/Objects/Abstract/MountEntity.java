package co.killionrevival.mc.Objects.Abstract;

import co.killionrevival.mc.Annotations.EntityAttribute;
import co.killionrevival.mc.Interfaces.IMountEntity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

public abstract class MountEntity implements IMountEntity {

    public AbstractHorse AbstractHorseEntity;
    public EntityType HorseType;
    public Material MountTrigger;

    public MountEntity(EntityType horseType, Material mountTrigger){
        HorseType = horseType;
        MountTrigger = mountTrigger;
    }

    @Override
    public AbstractHorse spawnEntity(PlayerInteractEvent event) {
        var player = event.getPlayer();
        var world = player.getWorld();
        var loc = getHorseSpawnLocation(event);

        this.AbstractHorseEntity = (AbstractHorse) world.spawnEntity(loc, this.HorseType);

        this.AbstractHorseEntity.setTamed(true);
        this.AbstractHorseEntity.addScoreboardTag(player.getName());
        this.AbstractHorseEntity.setAdult();
        this.AbstractHorseEntity.getInventory().setSaddle(new ItemStack(Material.SADDLE));

        return this.AbstractHorseEntity;
    }

    private Location getHorseSpawnLocation(PlayerInteractEvent event){

        Player player = event.getPlayer();

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

        Field field;

        try{
            field = IMountEntity.class.getDeclaredField(fieldName);
        }
        catch(NoSuchFieldException e){
            String errorMessage = "Error setting attribute value: " + e.getMessage() + "Stack Trace: " + Arrays.toString(e.getStackTrace());
            Bukkit.getServer().getConsoleSender().sendMessage(errorMessage);
            return;
        }

        var attr = field.getAnnotation(EntityAttribute.class).k();

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