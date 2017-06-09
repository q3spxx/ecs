package com.ecs.game.Systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.ecs.game.Components.PositionComponent;
import com.ecs.game.Components.VelocityComponent;

public class MovementSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;

    private ComponentMapper<PositionComponent> pc = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<VelocityComponent> vc = ComponentMapper.getFor(VelocityComponent.class);

    public MovementSystem () {
        super(702);
    }

    public void addedToEngine (Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, VelocityComponent.class).get());
    }

    public void update (float delta) {

        for (Entity entity : entities) {
            VelocityComponent velocity = vc.get(entity);
            PositionComponent position = pc.get(entity);

            position.x += velocity.x * delta * 100;
            position.y += velocity.y * delta * 100;
            velocity.x = 0;
            velocity.y = 0;
        }
    }
}
