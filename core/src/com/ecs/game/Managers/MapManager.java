package com.ecs.game.Managers;

import box2dLight.DirectionalLight;
import box2dLight.PointLight;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Polygon;
import com.ecs.game.Components.CameraComponent;
import com.ecs.game.Components.MapComponent;
import com.ecs.game.Components.MapObjectComponent;
import com.ecs.game.Components.PositionComponent;
import com.ecs.game.Main;
import com.ecs.game.Utils.ResourceLoader;

public class MapManager {
    private MapComponent mapComponent;
    private Engine engine;
    public MapManager (Engine engine) {
        this.engine = engine;
    }
    public void createComponent (String mapName) {
        Main.box2dManager.createComponent();
        TiledMap tiledMap = ResourceLoader.loadTmx(mapName);
        mapComponent = new MapComponent(tiledMap);

        MapLayers mapLayers = tiledMap.getLayers();
        MapLayer mapLayer = mapLayers.get("solid");
        MapObjects mapObjects = mapLayer.getObjects();
        MapObject mapObject;
        for (int i = 0; i < mapObjects.getCount(); i++) {
            mapObject = mapObjects.get(i);
            PolygonMapObject polyObject = (PolygonMapObject) mapObject;
            Polygon poly = polyObject.getPolygon();
            Entity entity = new Entity();
            float x = (Float) mapObject.getProperties().get("x");
            float y = (Float) mapObject.getProperties().get("y");
            float w = (Float) mapObject.getProperties().get("width");
            float h = (Float) mapObject.getProperties().get("height");
            entity.add(new PositionComponent(x, y, w, h));
            entity.add(new MapObjectComponent(poly));

//            Main.box2dManager.addBody(x, y, w, h);
            engine.addEntity(entity);
        }
//        Main.box2dManager.addPointLight(600, Color.WHITE, 400, 200f, 200f);
    }
    public void createEntity (CameraComponent cameraComponent) {
        Entity entity = new Entity();
        entity.add(mapComponent);
        entity.add(cameraComponent);
        engine.addEntity(entity);
    }

}
