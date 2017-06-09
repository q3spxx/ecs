package com.ecs.game.Systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.ecs.game.Components.InputComponent;
import com.ecs.game.Components.VelocityComponent;

public class ForcesSystem extends EntitySystem {
    private ImmutableArray<Entity> controlledEntities;

    private ComponentMapper<VelocityComponent> vc = ComponentMapper.getFor(VelocityComponent.class);
    private ComponentMapper<InputComponent> ic = ComponentMapper.getFor(InputComponent.class);

    public ForcesSystem () {
        super(700);
    }

    public void addedToEngine (Engine engine) {
        controlledEntities = engine.getEntitiesFor(Family.all(VelocityComponent.class, InputComponent.class).get());
    }

    public void update (float delta) {
        for (Entity entity : controlledEntities) {
            VelocityComponent velocity = vc.get(entity);
            InputComponent input = ic.get(entity);

            velocity.x += input.x;
            velocity.y += input.y;
        }
    }
}
