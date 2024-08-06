package co.killionrevival.mc.Objects;

import co.killionrevival.mc.Objects.Abstract.HorseEntity;
import org.bukkit.Material;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.Horse;
import org.bukkit.event.player.PlayerInteractEvent;

public class LeatherMountEntity extends HorseEntity {


    public LeatherMountEntity() {
        super(Material.LEATHER_HORSE_ARMOR);
    }

    @Override
    public AbstractHorse spawnEntity(PlayerInteractEvent event) {

        super.spawnEntity(event);

        setAttributeValue(this.MovementSpeedAttribute, 10);
        setAttributeValue(this.JumpStrengthAttribute, 10);
        setAttributeValue(this.GravityAttribute, 0.1);
        setAttributeValue(this.FallDamageMultiplierAttribute, 0);

        this.HorseEntity.setColor(Horse.Color.CHESTNUT);
        this.HorseEntity.setStyle(Horse.Style.BLACK_DOTS);

        return this.HorseEntity;
    }

}
