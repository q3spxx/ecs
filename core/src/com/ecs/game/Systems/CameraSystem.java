package com.ecs.game.Systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.ecs.game.Components.CameraComponent;
import com.ecs.game.Components.PositionComponent;

public class CameraSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;
    private ComponentMapper<PositionComponent> pc = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<CameraComponent> cc = ComponentMapper.getFor(CameraComponent.class);

    public CameraSystem () {
        super(800);
    }

    public void addedToEngine (Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, CameraComponent.class).get());
    }
    public void update (float delta) {
        for (Entity entity : entities) {
            PositionComponent pos = pc.get(entity);
            CameraComponent camera = cc.get(entity);
            camera.cam.position.set(pos.x, pos.y, 0);
            camera.cam.update();
        }
    }
}
