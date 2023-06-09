package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle extends GameObject implements Drawable {
    private int width;
    private int height;
    private int speed;
    
    
	public Paddle(int x, int y, int width, int height,int speed) {
        super(x,y);
        this.width = width;
        this.height = height;
        this.speed = speed;
    }
    public int getSpeed() {
		return speed;
	}
	public void AumentaSpeed(int a) {
		this.speed = speed + a;
	}

    public void setLongerWidth() {
    	this.width = width*2;
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
    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.BLUE);
        int x2 = x;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || (Gdx.input.isKeyPressed(Input.Keys.A))) {
            x2 = x - speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || (Gdx.input.isKeyPressed(Input.Keys.D))) {
            x2 = x + speed;
        }
        if (x2 > 0 && x2 + width < Gdx.graphics.getWidth()) {
            x = x2;
        }
        shape.rect(x, y, width, height);
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
