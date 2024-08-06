package co.killionrevival.mc.Objects.Abstract;

import co.killionrevival.mc.Interfaces.IHorseEntity;
import org.bukkit.Material;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class HorseEntity extends MountEntity implements IHorseEntity {

    public Horse HorseEntity;

    public HorseEntity(Material mountTrigger) {
        super(EntityType.HORSE, mountTrigger);


    }

    @Override
    public AbstractHorse spawnEntity(PlayerInteractEvent event) {
        this.HorseEntity = (Horse) super.spawnEntity(event);

        return HorseEntity;
    }


}

