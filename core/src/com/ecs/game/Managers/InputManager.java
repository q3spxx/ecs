package com.ecs.game.Managers;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.InputAdapter;
import com.ecs.game.Components.InputComponent;

public class InputManager extends InputAdapter {
    public InputComponent inputComponent;
    private Engine engine;
    private int startX = 0;
    private int startY = 0;

    public InputManager (Engine engine) {
        this.engine = engine;
        this.inputComponent = new InputComponent(0 ,0);
    }

    public boolean touchDown (int screenX, int screenY, int pointer, int button) {
        startX = screenX;
        startY = screenY;
        return false;
    }

    public boolean touchDragged (int screenX, int screenY, int pointer) {
        int vectorX = screenX - startX;
        int vectorY = -(screenY - startY);
        float vectorLength = (float) Math.sqrt(Math.pow(vectorX, 2d) + (Math.pow(vectorY, 2d)));
        inputComponent.x = vectorX / vectorLength;
        inputComponent.y = vectorY / vectorLength;
        return false;
    }

    public boolean touchUp (int screenX, int screenY, int pointer, int button) {
        startX = 0;
        startY = 0;
        inputComponent.x = 0;
        inputComponent.y = 0;
        return false;
    }
    public void setTarget (Entity target) {
        ImmutableArray<Entity>  entities = engine.getEntitiesFor(Family.all(InputComponent.class).get());

        for (Entity entity : entities) {
            entity.remove(InputComponent.class);
        }

        target.add(inputComponent);
    }
}
