package co.killionrevival.mc.Interfaces;

import co.killionrevival.mc.Attributes.EntityAttribute;
import org.bukkit.attribute.Attribute;

public interface IMountEntity {

    // Physical Characteristics
    @EntityAttribute(k = Attribute.GENERIC_SCALE)
    public double EntityScale = 1;

    // Movement and Speed
    @EntityAttribute(k = Attribute.GENERIC_MOVEMENT_SPEED)
    public double MovementSpeed = 1;
    @EntityAttribute(k = Attribute.GENERIC_MOVEMENT_EFFICIENCY)
    public double MovementEfficiency = 1;
    @EntityAttribute(k = Attribute.GENERIC_STEP_HEIGHT)
    public double StepHeight = 1;
    @EntityAttribute(k = Attribute.GENERIC_WATER_MOVEMENT_EFFICIENCY)
    public double WaterMovementEfficiency = 1;

    // Jumping and fall damage
    @EntityAttribute(k = Attribute.GENERIC_JUMP_STRENGTH)
    public double JumpStrength = 1;
    @EntityAttribute(k = Attribute.GENERIC_FALL_DAMAGE_MULTIPLIER)
    public double FallDamageMultiplier = 1;
    @EntityAttribute(k = Attribute.GENERIC_SAFE_FALL_DISTANCE)
    public double SafeFallDistance = 10;
    @EntityAttribute(k = Attribute.GENERIC_GRAVITY)
    public double Gravity = 1;

    // Health and Combat
    @EntityAttribute(k = Attribute.GENERIC_MAX_HEALTH)
    public double MaxHealth = 10; // double check
    @EntityAttribute(k = Attribute.GENERIC_KNOCKBACK_RESISTANCE)
    public double KnockbackResistance = 1;
    @EntityAttribute(k = Attribute.GENERIC_EXPLOSION_KNOCKBACK_RESISTANCE)
    public double ExplosionKnockbackResistance = 1;
    @EntityAttribute(k = Attribute.GENERIC_BURNING_TIME)
    public double BurnTime = 1;

    // Armor
    @EntityAttribute(k = Attribute.GENERIC_ARMOR)
    public double ArmorDurability = 1;
    @EntityAttribute(k = Attribute.GENERIC_ARMOR_TOUGHNESS)
    public double ArmorToughness = 1;


}
