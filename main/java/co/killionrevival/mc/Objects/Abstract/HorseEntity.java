package co.killionrevival.mc.Objects.Abstract;

import co.killionrevival.mc.Interfaces.IHorseEntity;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class HorseEntity extends MountEntity implements IHorseEntity {

    public Horse HorseEntity;

    public HorseEntity() {
        super(EntityType.HORSE);


    }

    @Override
    public AbstractHorse spawnEntity(Player player, ItemStack spawnItem) {
        this.HorseEntity = (Horse) super.spawnEntity(player, spawnItem);

        return HorseEntity;
    }


}

