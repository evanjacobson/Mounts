package co.killionrevival.mc.Objects;

import co.killionrevival.mc.Objects.Abstract.HorseEntity;
import org.bukkit.Material;

public class LeatherMountEntity extends HorseEntity {

    public LeatherMountEntity() {
        super(Material.LEATHER_HORSE_ARMOR);

        setAttributeValue(this.MovementSpeedAttribute, 10);
    }
}
