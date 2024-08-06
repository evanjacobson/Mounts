package co.killionrevival.mc.Objects;

import co.killionrevival.mc.Interfaces.IHorse;
import co.killionrevival.mc.Interfaces.IMountEntity;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;

import static co.killionrevival.mc.Interfaces.IMountEntity.MovementSpeed;

public class LeatherMountEntity extends MountEntity {

    public LeatherMountEntity() {
        super(EntityType.HORSE);

        setAttributeValue(this.MovementSpeedAttribute, 10);
    }
}
