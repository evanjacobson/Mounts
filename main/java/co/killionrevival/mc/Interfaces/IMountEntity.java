package co.killionrevival.mc.Interfaces;

import org.bukkit.entity.AbstractHorse;
import org.bukkit.event.player.PlayerInteractEvent;

public interface IMountEntity {

    // Physical Characteristics
    public final String EntityScaleAttribute = "EntityScale";

    // Movement and Speed
    public final String MovementSpeedAttribute = "MovementSpeed";
    public final String MovementEfficiencyAttribute = "MovementEfficiency";
    public final String StepHeightAttribute = "StepHeight";
    public final String WaterMovementEfficiencyAttribute = "WaterMovementEfficiency";

    // Jumping and fall damage
    public final String JumpStrengthAttribute = "JumpStrength";
    public final String FallDamageMultiplierAttribute = "FallDamageMultiplier";
    public final String SafeFallDistanceAttribute = "SafeFallDistance";
    public final String GravityAttribute = "Gravity";

    // Health and Combat
    public final String MaxHealthAttribute = "MaxHealth";
    public final String KnockbackResistanceAttribute = "KnockbackResistance";
    public final String ExplosionKnockbackResistanceAttribute = "ExplosionKnockbackResistance";
    public final String BurnTimeAttribute = "BurnTime";

    // Armor
    public final String ArmorDurabilityAttribute = "ArmorDurability";
    public final String ArmorToughnessAttribute = "ArmorToughness";

    AbstractHorse spawnEntity(PlayerInteractEvent event);

    void setAttributeValue(String fieldName, double value) throws NoSuchFieldException;
}
