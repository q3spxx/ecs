package com.ecs.game.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;

public class ImageComponent implements Component {
    public Texture img;
    public ImageComponent (Texture img) {
        this.img = img;
    }
}
