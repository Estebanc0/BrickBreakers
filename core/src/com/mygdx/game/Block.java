package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block extends GameObject implements Drawable{
    
    private int width;
    private int height;
    private Color color;
    private boolean destroyed;

    public Block(int x, int y, int width, int height) {
        super(x,y);
        this.width = width;
        this.height = height;
        this.destroyed = false;
       
        color =Color.FIREBRICK;
        }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.rect(x, y, width, height);
    }
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}