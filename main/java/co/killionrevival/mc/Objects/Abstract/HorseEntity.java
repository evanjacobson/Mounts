package co.killionrevival.mc.Objects.Abstract;

import co.killionrevival.mc.Interfaces.IHorseEntity;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

public abstract class HorseEntity extends MountEntity implements IHorseEntity {
    public HorseEntity(Material mountTrigger) {
        super(EntityType.HORSE, mountTrigger);
    }
}

