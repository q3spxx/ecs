package com.ecs.game.Data;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.ecs.game.Components.ImageComponent;
import com.ecs.game.Components.PositionComponent;
import com.ecs.game.Components.VelocityComponent;

public class Alisa implements GameObject {

    @Override
    public Entity create() {
        Entity entity = new Entity();
        entity.add(new PositionComponent(100f, 100f, 100f, 100f));
        entity.add(new VelocityComponent(0f, 0f));
        entity.add(new ImageComponent(new Texture("alisa.jpg")));
        return entity;
    }
}
