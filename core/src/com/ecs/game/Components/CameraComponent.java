package com.ecs.game.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraComponent implements Component {
    public OrthographicCamera cam;

    public CameraComponent (float screenWidth, float screenHeight) {
        this.cam = new OrthographicCamera();
        this.cam.setToOrtho(false, 1920, 1080);
    }
}
