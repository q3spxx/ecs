package com.ecs.game.Screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.ecs.game.Main;
import com.ecs.game.Systems.*;

public class MapScreen implements Screen{
    private Engine engine;
    private World world;
    Entity entity;
    Entity target;
    @Override
    public void show() {
        engine = Main.engine;
        world = new World(new Vector2(0, 0), true);
        //Systems
        engine.addSystem(new RenderingSystem());
        engine.addSystem(new ForcesSystem());
        engine.addSystem(new MovementSystem());
        engine.addSystem(new CameraSystem());
        engine.addSystem(new MapSystem());
        engine.addSystem(new CollisionSystem());
        engine.addSystem(new DebugRenderingSystem());
        engine.addSystem(new Box2dLightSystem());
        //Components
        Main.cameraManager.createComponent(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Main.mapManager.createComponent("testMap.tmx");
        //Entities
        entity = Main.entitiesManager.createEntityFromPattern("Pic");
        Main.cameraManager.setTarget(entity);
        Main.inputManager.setTarget(entity);
//		target = entitiesManager.createEntityFromPattern("Alisa");
        Main.mapManager.createEntity(Main.cameraManager.cameraComponent);

    }

    @Override
    public void render(float delta) {
        handler();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        engine.update(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    private void handler () {
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            Main.cameraManager.setTarget(target);
            Main.inputManager.setTarget(target);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            Main.cameraManager.setTarget(entity);
            Main.inputManager.setTarget(entity);
        }
    }
}
