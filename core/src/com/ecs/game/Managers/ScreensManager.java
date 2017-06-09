package com.ecs.game.Managers;

import com.badlogic.gdx.Screen;
import com.ecs.game.Main;
import com.ecs.game.Screens.MapScreen;

public class ScreensManager {
    private Main main;

    public ScreensManager (Main main) {
        this.main = main;
    }
    public void setScreen (String name) {
        Screen screen = null;
        if (name == "MapScreen") {
            screen = new MapScreen();
        } else {
            return;
        }
        main.setScreen(screen);
    }
}
