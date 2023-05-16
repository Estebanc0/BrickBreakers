package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected Color color;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        
    }

    public abstract void update();

    
}
