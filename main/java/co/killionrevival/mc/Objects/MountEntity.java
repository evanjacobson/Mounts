package co.killionrevival.mc.Objects;

import co.killionrevival.mc.Attributes.EntityAttribute;
import co.killionrevival.mc.Interfaces.IMountEntity;
import org.bukkit.Bukkit;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;
import org.slf4j.event.Level;

import java.io.Console;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

public class MountEntity implements IMountEntity {

    public AbstractHorse Horse;
    public EntityType HorseType;

    public MountEntity(EntityType horseType){
        HorseType = horseType;
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