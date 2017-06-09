package com.ecs.game.Managers;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.ecs.game.Data.Alisa;
import com.ecs.game.Data.Default;
import com.ecs.game.Data.GameObject;
import com.ecs.game.Data.Pic;

import java.util.HashMap;

public class EntitiesManager {
    private HashMap<String, Class<?>> gameObjectMap;
    private Engine engine;

    public EntitiesManager(Engine engine) {
        this.engine = engine;
        gameObjectMap = new HashMap<String, Class<?>>();
        init();
    }

    public void init () {
        gameObjectMap.put(Default.class.getSimpleName(), Default.class);
        gameObjectMap.put(Pic.class.getSimpleName(), Pic.class);
        gameObjectMap.put(Alisa.class.getSimpleName(), Alisa.class);
    }

    public Entity createEntityFromPattern (String name) {
        Class<?> gameObjectClass = gameObjectMap.get(name);
        if (gameObjectClass == null) {
            System.out.println("Class not found");
            return null;
        }

        GameObject gameObject = null;

        try {
            gameObject = (GameObject) gameObjectClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Entity entity = gameObject.create();

        engine.addEntity(entity);

        return  entity;
    }
    public Entity getEntity (Class<? extends Component> componentClass) {
        ImmutableArray<Entity> finedEntities = engine.getEntitiesFor(Family.one(componentClass).get());
        return finedEntities.get(0);
    }
}
