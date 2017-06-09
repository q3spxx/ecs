package com.ecs.game.Components;

import com.badlogic.ashley.core.Component;

public class InputComponent implements Component {
    public float x;
    public float y;

    public InputComponent (float x, float y) {
        this.x = x;
        this.y = y;
    }
}
