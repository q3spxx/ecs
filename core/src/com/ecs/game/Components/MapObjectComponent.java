package com.ecs.game.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Polygon;

public class MapObjectComponent implements Component {
    public Polygon poly;
    public MapObjectComponent (Polygon poly) {
        this.poly = poly;
    }
}
