package com.ecs.game.Systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ecs.game.Components.*;

public class CollisionSystem extends EntitySystem {
    private ImmutableArray<Entity> movingEntities;
    private ImmutableArray<Entity> mapObjectEntities;

    public CollisionSystem () {
        super(701);
    }

    private ComponentMapper<PositionComponent> pc = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<VelocityComponent> vc = ComponentMapper.getFor(VelocityComponent.class);
    private ComponentMapper<MapObjectComponent> moc = ComponentMapper.getFor(MapObjectComponent.class);

    public void addedToEngine(Engine engine) {
        movingEntities = engine.getEntitiesFor(Family.all(PositionComponent.class, VelocityComponent.class).get());
        mapObjectEntities = engine.getEntitiesFor(Family.all(PositionComponent.class, MapObjectComponent.class).get());
    }

    public void update (float delta) {
        for (Entity movingEntity : movingEntities) {
            PositionComponent pos = pc.get(movingEntity);
            VelocityComponent vec = vc.get(movingEntity);
            if (vec.x == 0 && vec.y == 0) {
                continue;
            }
//            Rectangle rect = new Rectangle(pos.x + vec.x * delta * 100, pos.y + vec.y * delta * 100, pos.w, pos.h);
           for (Entity mapObjectEntity : mapObjectEntities) {
                MapObjectComponent mapObject = moc.get(mapObjectEntity);
                if (mapObject.poly.contains(new Vector2(pos.x + vec.x * delta * 100, pos.y + vec.y * delta * 100))) {
                    vec.x = 0;
                    vec.y = 0;
                }
//                PositionComponent oPos = pc.get(mapObjectEntity);
//                Rectangle oRect = new Rectangle(oPos.x, oPos.y, oPos.w, oPos.h);
//                if (rect.overlaps(oRect)) {
//                    if (!new Rectangle(pos.x, pos.y + vec.y * delta * 100, pos.w, pos.h).overlaps(oRect)) {
//                        vec.x = 0;
//                    } else if (!new Rectangle(pos.x + vec.x * delta * 100, pos.y, pos.w, pos.h).overlaps(oRect)) {
//                        vec.y = 0;
//                    }
//                    if (vec.x == 0 && vec.y == 0) {
//                        break;
//                    }
//                    continue;
//                }
            }
        }
    }

}
