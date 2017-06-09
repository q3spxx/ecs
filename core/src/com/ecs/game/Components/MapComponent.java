package com.ecs.game.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapComponent implements Component {
    public TiledMapRenderer renderer;
    public TiledMap map;

    public MapComponent(TiledMap map) {
        this.map = map;
        this.renderer = new OrthogonalTiledMapRenderer(map);
    }
}
