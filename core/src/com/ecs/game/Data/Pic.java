package com.ecs.game.Data;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.ecs.game.Components.AnimationComponent;
import com.ecs.game.Components.ParticlesEmitterComponent;
import com.ecs.game.Components.PositionComponent;
import com.ecs.game.Components.VelocityComponent;

public class Pic implements GameObject {
    public Entity create () {
        Entity entity = new Entity();
        entity.add(new PositionComponent(0f, 0f, 128f, 128f));
        entity.add(new VelocityComponent(0f, 0f));
        entity.add(new ParticlesEmitterComponent("particle.p"));
        entity.add(new AnimationComponent(new Texture("badlogic.jpg")));
        return entity;
    }
}
