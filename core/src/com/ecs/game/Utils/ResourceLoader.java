package com.ecs.game.Utils;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public abstract class ResourceLoader {
    public static TiledMap loadTmx (String name) {
        return new TmxMapLoader().load(name);
    }
}
