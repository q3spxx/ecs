package com.ecs.game.Systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.ecs.game.Components.Box2dComponent;
import com.ecs.game.Components.CameraComponent;

public class Box2dLightSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;
    private ComponentMapper<Box2dComponent> bc = ComponentMapper.getFor(Box2dComponent.class);
    private ComponentMapper<CameraComponent> cc = ComponentMapper.getFor(CameraComponent.class);
    public Box2dLightSystem () {
        super(904);
    }
    public void addedToEngine (Engine engine) {
        entities = engine.getEntitiesFor(Family.all(Box2dComponent.class, CameraComponent.class).get());
    }
    public void update (float delta) {
        for (Entity entity : entities) {
            Box2dComponent box2d = bc.get(entity);
            CameraComponent camera = cc.get(entity);
            box2d.rayHandler.setCombinedMatrix(camera.cam);
            box2d.rayHandler.updateAndRender();
        }
    }
}
