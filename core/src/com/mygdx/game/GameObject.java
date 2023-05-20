package com.mygdx.game;

public abstract class GameObject {
    protected int x;
    protected int y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        
    }

    public abstract void update();

    
}
