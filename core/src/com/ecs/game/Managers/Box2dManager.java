package com.ecs.game.Managers;

import box2dLight.PointLight;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.ecs.game.Components.Box2dComponent;
import com.ecs.game.Main;

public class Box2dManager {
    public Box2dComponent box2dComponent;
    public Engine engine;
    public Box2dManager (Engine engine) {
        this.engine = engine;
    }
    public void createComponent () {
        Entity entity = new Entity();
        box2dComponent = new Box2dComponent(new World(new Vector2(0 ,0), true));
        entity.add(box2dComponent);
        entity.add(Main.cameraManager.cameraComponent);
        engine.addEntity(entity);
    }
    public void addPointLight (int rays, Color color, float distance, float x, float y) {
        new PointLight(box2dComponent.rayHandler, rays,color, distance, x, y);
    }

    public void addBody (float x, float y, float width, float height) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x + width / 2, y + height / 2);
        bodyDef.angle = -0.785f;
        Body body = box2dComponent.world.createBody(bodyDef);

        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(width / 2, height / 2);
        body.createFixture(polygonShape, 0.5f);
    }

    public void deleteWorld () {
        ImmutableArray<Entity> entities = engine.getEntitiesFor(Family.all(Box2dComponent.class).get());
        for (Entity entity : entities) {
            engine.removeEntity(entity);
        }
    }
}
