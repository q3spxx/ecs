package com.ecs.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.ecs.game.Managers.*;

public class Main extends Game {
	public static EntitiesManager entitiesManager;
	public static CameraManager cameraManager;
	public static MapManager mapManager;
	public static InputManager inputManager;
	public static ScreensManager screensManager;
	public static Box2dManager box2dManager;
	public static Engine engine;

	@Override
	public void create () {
		//Engine
		engine = new Engine();
		//Managers
		entitiesManager = new EntitiesManager(engine);
		cameraManager = new CameraManager(engine);
		inputManager = new InputManager(engine);
		Gdx.input.setInputProcessor(inputManager);
		mapManager = new MapManager(engine);
		box2dManager = new Box2dManager(engine);
		screensManager = new ScreensManager(this);

		screensManager.setScreen("MapScreen");
	}

	@Override
	public void render () {
		super.render();
	}

	
	@Override
	public void dispose () {
	}
}
