package co.killionrevival.mc.Utils;

import org.bukkit.attribute.Attribute;

import java.util.HashMap;
import java.util.Map;

public class HorseAttributes {
    //region Constants
    
    // Physical Characteristics
    public static final String ENTITY_SCALE = "ENTITYSCALE";

    // Movement and Speed
    public static final String MOVEMENT_SPEED = "MOVEMENTSPEED";
    public static final String MOVEMENT_EFFICIENCY = "MOVEMENTEFFICIENCY";
    public static final String STEP_HEIGHT = "STEPHEIGHT";
    public static final String WATER_MOVEMENT_EFFICIENCY = "WATERMOVEMENTEFFICIENCY";

    // Jumping and fall damage
    public static final String JUMP_STRENGTH = "JUMPSTRENGTH";
    public static final String FALL_DAMAGE_MULTIPLIER = "FALLDAMAGEMULTIPLIER";
    public static final String SAFE_FALL_DISTANCE = "SAFEFALLDISTANCE";
    public static final String GRAVITY = "GRAVITY";

    // Health and Combat
    public static final String MAX_HEALTH = "MAXHEALTH";
    public static final String KNOCKBACK_RESISTANCE = "KNOCKBACKRESISTANCE";
    public static final String EXPLOSION_KNOCKBACK_RESISTANCE = "EXPLOSIONKNOCKBACKRESISTANCE";
    public static final String BURN_TIME = "BURNTIME";

    // Armor
    public static final String ARMOR_DURABILITY = "ARMORDURABILITY";
    public static final String ARMOR_TOUGHNESS = "ARMORTOUGHNESS";

    //endregion Constants

    private static final Map<String, Attribute> attributeMap = new HashMap<>();

    static {
        attributeMap.put(ENTITY_SCALE, Attribute.GENERIC_SCALE);
        attributeMap.put(MOVEMENT_SPEED, Attribute.GENERIC_MOVEMENT_SPEED);
        attributeMap.put(MOVEMENT_EFFICIENCY, Attribute.GENERIC_MOVEMENT_EFFICIENCY);
        attributeMap.put(STEP_HEIGHT, Attribute.GENERIC_STEP_HEIGHT);
        attributeMap.put(WATER_MOVEMENT_EFFICIENCY, Attribute.GENERIC_WATER_MOVEMENT_EFFICIENCY);
        attributeMap.put(JUMP_STRENGTH, Attribute.GENERIC_JUMP_STRENGTH);
        attributeMap.put(FALL_DAMAGE_MULTIPLIER, Attribute.GENERIC_FALL_DAMAGE_MULTIPLIER);
        attributeMap.put(SAFE_FALL_DISTANCE, Attribute.GENERIC_SAFE_FALL_DISTANCE);
        attributeMap.put(GRAVITY, Attribute.GENERIC_GRAVITY);
        attributeMap.put(MAX_HEALTH, Attribute.GENERIC_MAX_HEALTH);
        attributeMap.put(KNOCKBACK_RESISTANCE, Attribute.GENERIC_KNOCKBACK_RESISTANCE);
        attributeMap.put(EXPLOSION_KNOCKBACK_RESISTANCE, Attribute.GENERIC_EXPLOSION_KNOCKBACK_RESISTANCE);
        attributeMap.put(BURN_TIME, Attribute.GENERIC_BURNING_TIME);
        attributeMap.put(ARMOR_DURABILITY, Attribute.GENERIC_ARMOR);
        attributeMap.put(ARMOR_TOUGHNESS, Attribute.GENERIC_ARMOR_TOUGHNESS);
    }

    public static Attribute getAttribute(String attributeName) {
        // Normalize the attribute name to uppercase for case-insensitive comparison
        String normalizedAttributeName = attributeName.toUpperCase();

        // Look up the attribute in the map
        return attributeMap.getOrDefault(normalizedAttributeName, null);
    }
}
