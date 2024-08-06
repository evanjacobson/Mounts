package co.killionrevival.mc.Objects.Abstract;

import co.killionrevival.mc.Annotations.EntityAttribute;
import co.killionrevival.mc.Interfaces.IMountEntity;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

public abstract class MountEntity implements IMountEntity {

    public AbstractHorse Horse;
    public EntityType HorseType;
    public Material MountTrigger;

    public MountEntity(EntityType horseType, Material mountTrigger){
        HorseType = horseType;
        MountTrigger = mountTrigger;
    }

    @Override
    public void setAttributeValue(String fieldName, double value) {

        if(!isSpawned()){
            Bukkit.getServer().getConsoleSender().sendMessage("The horse must exist to have attributes!");
            return;
        }

        Field field;

        try{
            field = IMountEntity.class.getDeclaredField(fieldName);
        }
        catch(NoSuchFieldException e){
            String errorMessage = "Error setting attribute value: " + e.getMessage() + "Stack Trace: " + Arrays.toString(e.getStackTrace());
            Bukkit.getServer().getConsoleSender().sendMessage(errorMessage);
            return;
        }

        var attr = field.getAnnotation(EntityAttribute.class).k();

        Objects.requireNonNull(Horse.getAttribute(attr)).setBaseValue(value);
    }

    public AbstractHorse getHorseEntity(){
        return isSpawned()
                ? Horse
                : null;
    }

    private boolean isSpawned(){
        return Horse != null;
    }
}