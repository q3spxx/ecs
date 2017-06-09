package com.ecs.game.Systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.ecs.game.Components.CameraComponent;
import com.ecs.game.Components.Box2dComponent;

public class DebugRenderingSystem extends EntitySystem {
    private Box2DDebugRenderer debugRenderer;
    private ImmutableArray<Entity> entities;
    private ComponentMapper<Box2dComponent> bc = ComponentMapper.getFor(Box2dComponent.class);
    private ComponentMapper<CameraComponent> cc = ComponentMapper.getFor(CameraComponent.class);

    public DebugRenderingSystem () {
        super(903);
    }

    public void addedToEngine (Engine engine) {
        debugRenderer = new Box2DDebugRenderer();
        entities = engine.getEntitiesFor(Family.all(Box2dComponent.class, CameraComponent.class).get());
    }
    public void update (float delta) {
        for (Entity entity : entities) {
            Box2dComponent box2d = bc.get(entity);
            CameraComponent camera = cc.get(entity);
            debugRenderer.render(box2d.world, camera.cam.combined);
        }
    }
}
