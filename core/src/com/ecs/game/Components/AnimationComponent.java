package com.ecs.game.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationComponent implements Component {
    public Animation<TextureRegion> animation;
    public float stateTime;
    public AnimationComponent (Texture texture) {
        stateTime =  0f;
        TextureRegion[][] temp = TextureRegion.split(texture, texture.getWidth() / 1, texture.getHeight() / 1);
        TextureRegion [] frames = new TextureRegion[1];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                frames[index] = temp[i][j];
                index++;
            }
        }
        this.animation = new Animation<TextureRegion>(0.025f, frames);
    }
}
