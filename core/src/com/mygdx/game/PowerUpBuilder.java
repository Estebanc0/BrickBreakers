package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

public class PowerUpBuilder {
	private int x;
    private int y;
    private int size;
    private int ySpeed;
    private boolean active=false;
    private Color color;
    
    public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getySpeed() {
		return ySpeed;
	}
	public int getSize() {
		return size;
	}
	public Color getColor() {
		return color;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public PowerUpBuilder setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }
    
    public PowerUpBuilder setSize(int size) {
        this.size = size;
        return this;
    }
    
    public PowerUpBuilder setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
        return this;
    }
    
    
    
    public PowerUpBuilder setColor(Color color) {
        this.color = color;
        return this;
    }
    
    public PowerUp build() {
        return new PowerUp(this);
    }
}