package co.killionrevival.mc.Objects;

import co.killionrevival.mc.Objects.Abstract.MountEntity;
import org.bukkit.Material;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerInteractEvent;

public class GoldenMountEntity extends MountEntity {
    public GoldenMountEntity(){
        super(EntityType.SKELETON_HORSE, Material.GOLDEN_HORSE_ARMOR);


    }

    @Override
    public AbstractHorse spawnEntity(PlayerInteractEvent event) {

        super.spawnEntity(event);

        setAttributeValue(this.StepHeightAttribute, 10);
        setAttributeValue(this.EntityScaleAttribute, 10);
        setAttributeValue(this.WaterMovementEfficiencyAttribute, 10);

        return this.Horse;
    }
}
