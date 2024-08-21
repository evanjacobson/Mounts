package co.killionrevival.mc.Objects;

import co.killionrevival.mc.Objects.Abstract.HorseEntity;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LeatherMountEntity extends HorseEntity {


    public LeatherMountEntity() {
        super();
    }

    @Override
    public AbstractHorse spawnEntity(Player player, ItemStack spawnItem) {

        Horse horse = (Horse) super.spawnEntity(player, spawnItem);

//        setAttributeValue(this.MovementSpeedAttribute, 10);
//        setAttributeValue(this.JumpStrengthAttribute, 10);
//        setAttributeValue(this.GravityAttribute, 0.1);
//        setAttributeValue(this.FallDamageMultiplierAttribute, 0);

        horse.setColor(Horse.Color.CHESTNUT);
        horse.setStyle(Horse.Style.BLACK_DOTS);

        return this.HorseEntity;
    }

}
