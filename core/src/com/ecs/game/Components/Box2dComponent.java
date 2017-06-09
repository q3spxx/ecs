package com.ecs.game.Components;

import box2dLight.RayHandler;
import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.World;

public class Box2dComponent implements Component {
    public World world;
    public RayHandler rayHandler;
    public Box2dComponent(World world) {
        this.world = world;
        this.rayHandler = new RayHandler(world);
        this.rayHandler.setShadows(true);
        this.rayHandler.setAmbientLight(0.1f, 0.1f, 0f, 0.7f);
        this.rayHandler.setGammaCorrection(true);
    }
}
