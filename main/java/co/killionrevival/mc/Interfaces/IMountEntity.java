package co.killionrevival.mc.Interfaces;

import co.killionrevival.mc.Annotations.EntityAttribute;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Dictionary;
import java.util.Hashtable;

public interface IMountEntity {

    // Physical Characteristics
    @EntityAttribute(k = Attribute.GENERIC_SCALE)
    //public double EntityScale = 1;
    public final String EntityScaleAttribute = "EntityScale";

    // Movement and Speed
    @EntityAttribute(k = Attribute.GENERIC_MOVEMENT_SPEED)
    //public double MovementSpeed = 1;
    public final String MovementSpeedAttribute = "MovementSpeed";

    @EntityAttribute(k = Attribute.GENERIC_MOVEMENT_EFFICIENCY)
    //public double MovementEfficiency = 1;
    public final String MovementEfficiencyAttribute = "MovementEfficiency";

    @EntityAttribute(k = Attribute.GENERIC_STEP_HEIGHT)
    //public double StepHeight = 1;
    public final String StepHeightAttribute = "StepHeight";

    @EntityAttribute(k = Attribute.GENERIC_WATER_MOVEMENT_EFFICIENCY)
    //public double WaterMovementEfficiency = 1;
    public final String WaterMovementEfficiencyAttribute = "WaterMovementEfficiency";

    // Jumping and fall damage
    @EntityAttribute(k = Attribute.GENERIC_JUMP_STRENGTH)
    //public double JumpStrength = 1;
    public final String JumpStrengthAttribute = "JumpStrength";

    @EntityAttribute(k = Attribute.GENERIC_FALL_DAMAGE_MULTIPLIER)
    //public double FallDamageMultiplier = 1;
    public final String FallDamageMultiplierAttribute = "FallDamageMultiplier";

    @EntityAttribute(k = Attribute.GENERIC_SAFE_FALL_DISTANCE)
    //public double SafeFallDistance = 10;
    public final String SafeFallDistanceAttribute = "SafeFallDistance";

    @EntityAttribute(k = Attribute.GENERIC_GRAVITY)
    //public double Gravity = 1;
    public final String GravityAttribute = "Gravity";

    // Health and Combat
    @EntityAttribute(k = Attribute.GENERIC_MAX_HEALTH)
    //public double MaxHealth = 10; // double check
    public final String MaxHealthAttribute = "MaxHealth";


    @EntityAttribute(k = Attribute.GENERIC_KNOCKBACK_RESISTANCE)
    //public double KnockbackResistance = 1;
    public final String KnockbackResistanceAttribute = "KnockbackResistance";

    @EntityAttribute(k = Attribute.GENERIC_EXPLOSION_KNOCKBACK_RESISTANCE)
    //public double ExplosionKnockbackResistance = 1;
    public final String ExplosionKnockbackResistanceAttribute = "ExplosionKnockbackResistance";


    @EntityAttribute(k = Attribute.GENERIC_BURNING_TIME)
    //public double BurnTime = 1;
    public final String BurnTimeAttribute = "BurnTime";

    // Armor
    @EntityAttribute(k = Attribute.GENERIC_ARMOR)
    //public double ArmorDurability = 1;
    public final String ArmorDurabilityAttribute = "ArmorDurability";

    @EntityAttribute(k = Attribute.GENERIC_ARMOR_TOUGHNESS)
    //public double ArmorToughness = 1;
    public final String ArmorToughnessAttribute = "ArmorToughness";

    AbstractHorse spawnEntity(PlayerInteractEvent event);
    void setAttributeValue(String fieldName, double value) throws NoSuchFieldException;
}
