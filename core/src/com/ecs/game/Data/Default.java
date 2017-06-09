package com.ecs.game.Data;

import com.badlogic.ashley.core.Entity;

public class Default implements GameObject {
    public Entity create() {
        return new Entity();
    }
}
