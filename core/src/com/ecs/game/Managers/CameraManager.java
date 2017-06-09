package com.ecs.game.Managers;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.ecs.game.Components.CameraComponent;
import com.ecs.game.Components.PositionComponent;

public class CameraManager {
    private Engine engine;
    public CameraComponent cameraComponent;
    public CameraManager (Engine engine) {
        this.engine = engine;
    }
    public void createComponent (float width, float height) {
        cameraComponent = new CameraComponent(width, height);
    }
    public void setTarget (Entity target) {
        ImmutableArray<Entity> entities = engine.getEntitiesFor(Family.all(CameraComponent.class, PositionComponent.class).get());

        for (Entity entity : entities) {
            entity.remove(CameraComponent.class);
        }

        target.add(cameraComponent);
    }
}
