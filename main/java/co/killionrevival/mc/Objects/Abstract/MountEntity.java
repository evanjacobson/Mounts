package co.killionrevival.mc.Objects.Abstract;

import co.killionrevival.mc.Interfaces.IMountEntity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public abstract class MountEntity implements IMountEntity {

    public AbstractHorse AbstractHorseEntity;
    public EntityType HorseType;

    public MountEntity(EntityType horseType){
        HorseType = horseType;
    }

    @Override
    public AbstractHorse spawnEntity(PlayerInteractEvent event) {
        var player = event.getPlayer();
        var loc = getHorseSpawnLocation(event);

        var spawnedEntity = (AbstractHorse) player.getWorld().spawnEntity(loc, this.HorseType);

        spawnedEntity.setTamed(true);
        spawnedEntity.addScoreboardTag(player.getName());
        spawnedEntity.setAdult();
        spawnedEntity.getInventory().setSaddle(new ItemStack(Material.SADDLE));

        this.AbstractHorseEntity = spawnedEntity;

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

    public Attribute getAttribute(String attributeName){
        switch (attributeName) {
            case EntityScaleAttribute:
                return Attribute.GENERIC_SCALE;
            case MovementSpeedAttribute:
                return Attribute.GENERIC_MOVEMENT_SPEED;
            case MovementEfficiencyAttribute:
                return Attribute.GENERIC_MOVEMENT_EFFICIENCY;
            case StepHeightAttribute:
                return Attribute.GENERIC_STEP_HEIGHT;
            case WaterMovementEfficiencyAttribute:
                return Attribute.GENERIC_WATER_MOVEMENT_EFFICIENCY;
            case JumpStrengthAttribute:
                return Attribute.GENERIC_JUMP_STRENGTH;
            case FallDamageMultiplierAttribute:
                return Attribute.GENERIC_FALL_DAMAGE_MULTIPLIER;
            case SafeFallDistanceAttribute:
                return Attribute.GENERIC_SAFE_FALL_DISTANCE;
            case GravityAttribute:
                return Attribute.GENERIC_GRAVITY;
            case MaxHealthAttribute:
                return Attribute.GENERIC_MAX_HEALTH;
            case KnockbackResistanceAttribute:
                return Attribute.GENERIC_KNOCKBACK_RESISTANCE;
            case ExplosionKnockbackResistanceAttribute:
                return Attribute.GENERIC_EXPLOSION_KNOCKBACK_RESISTANCE;
            case BurnTimeAttribute:
                return Attribute.GENERIC_BURNING_TIME;
            case ArmorDurabilityAttribute:
                return Attribute.GENERIC_ARMOR;
            case ArmorToughnessAttribute:
                return Attribute.GENERIC_ARMOR_TOUGHNESS;
            default:
                // Handle unknown attribute name
                throw new IllegalArgumentException("Unknown attribute name: " + attributeName);
        }
    }
    @Override
    public void setAttributeValue(String fieldName, double value) {

        if(!isSpawned()){
            Bukkit.getServer().getConsoleSender().sendMessage("The horse must exist to have attributes!");
            return;
        }

        var attr = getAttribute(fieldName);
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