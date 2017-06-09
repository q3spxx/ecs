package com.ecs.game.Systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ecs.game.Components.*;

public class RenderingSystem extends EntitySystem {

    private ImmutableArray<Entity> entities;
    private ImmutableArray<Entity> emitters;
    private SpriteBatch batch;

    private ComponentMapper<PositionComponent> pc = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<AnimationComponent> ac = ComponentMapper.getFor(AnimationComponent.class);
    private ComponentMapper<CameraComponent> cc = ComponentMapper.getFor(CameraComponent.class);
    private ComponentMapper<ParticlesEmitterComponent> pec = ComponentMapper.getFor(ParticlesEmitterComponent.class);

    public RenderingSystem() {
        super(901);
        batch = new SpriteBatch();
    }

    public void addedToEngine (Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, AnimationComponent.class).get());
        emitters = engine.getEntitiesFor(Family.all(PositionComponent.class, ParticlesEmitterComponent.class).get());
    }
    public void update (float delta) {

        batch.begin();
        for (Entity entity : entities) {
            PositionComponent position  = pc.get(entity);
            AnimationComponent animation = ac.get(entity);
            animation.stateTime += delta;
            TextureRegion currentFrame = animation.animation.getKeyFrame(animation.stateTime, true);

            if (cc.get(entity) != null) {
                CameraComponent camera = cc.get(entity);
                batch.setProjectionMatrix(camera.cam.combined);
            }

            batch.draw(currentFrame, (int) position.x, (int) position.y, (int) position.w, (int) position.h);
        }
        for (Entity entity : emitters) {
            PositionComponent position  = pc.get(entity);
            ParticlesEmitterComponent emitter = pec.get(entity);

            emitter.effect.setPosition(480 + (float) Math.sin(emitter.angle) * 50, 270 + (float) Math.cos(emitter.angle) * 50);
            emitter.angle -= 0.05d;

            emitter.effect.draw(batch, delta);

            if (emitter.effect.isComplete()) {
                emitter.effect.reset();
            }
        }
        batch.end();
    }


}
