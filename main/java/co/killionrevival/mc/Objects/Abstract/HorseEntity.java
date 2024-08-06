package co.killionrevival.mc.Objects.Abstract;

import co.killionrevival.mc.Interfaces.IHorseEntity;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;

public abstract class HorseEntity extends MountEntity implements IHorseEntity {

    public Horse HorseEntity;

    public HorseEntity(Material mountTrigger) {
        super(EntityType.HORSE, mountTrigger);

        this.HorseEntity = (Horse) this.AbstractHorseEntity;
    }
}

