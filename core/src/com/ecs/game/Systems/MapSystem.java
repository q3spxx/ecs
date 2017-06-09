package com.ecs.game.Systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.ecs.game.Components.CameraComponent;
import com.ecs.game.Components.MapComponent;

public class MapSystem extends EntitySystem {

    private ImmutableArray<Entity> entities;

    private ComponentMapper<MapComponent> mc = ComponentMapper.getFor(MapComponent.class);
    private ComponentMapper<CameraComponent> cc  = ComponentMapper.getFor(CameraComponent.class);

    public MapSystem () {
        super(900);
    }

    public void addedToEngine(Engine engine) {
         entities = engine.getEntitiesFor(Family.all(MapComponent.class, CameraComponent.class).get());
    }

    public void update (float delta) {
        for (Entity entity : entities) {
            MapComponent mapRender = mc.get(entity);
            CameraComponent camera = cc.get(entity);
            mapRender.renderer.setView(camera.cam);
            mapRender.renderer.render();
        }
    }
}
