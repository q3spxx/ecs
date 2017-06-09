package com.ecs.game.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ParticlesEmitterComponent implements Component {
    public ParticleEffect effect;
    public double angle = 0d;
    public ParticlesEmitterComponent (String name) {
        effect = new ParticleEffect();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("atlas/pack.atlas"));
        effect.load(Gdx.files.internal(name), atlas);
        effect.setPosition(480, 270);
        effect.start();
    }
}
