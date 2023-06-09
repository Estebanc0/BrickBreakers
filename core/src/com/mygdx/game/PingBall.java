package com.mygdx.game;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PingBall extends GameObject implements Drawable {
    private int size;
    private int xSpeed;
    private int ySpeed;
    private boolean estaQuieto;
	private Color color;
	private Random random;
	private BallColisionS strategy;

    public PingBall(int x, int y, int size, int xSpeed, int ySpeed, boolean iniciaQuieto,Color c) {
        super(x, y);
        this.color=c;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        estaQuieto = iniciaQuieto;
    }
    public void setStrategy(BallColisionS a) {
    	this.strategy=a;
    }
    public void ChangeSpeedXY(int a) {
    	this.xSpeed = xSpeed + a;
        this.ySpeed = ySpeed + a;
    }
    public boolean estaQuieto() {
        return estaQuieto;
    }

    public void setEstaQuieto(boolean bb) {
        estaQuieto = bb;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {
        if (estaQuieto) return;
        x += xSpeed;
        y += ySpeed;
        if (x - size < 0 || x + size > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if (y + size > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
    }

    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    public void checkCollision(PingBall a, GameObject b) {
        this.strategy.colision(a, b);
    }

    boolean collidesWith(Paddle pp) {
        boolean intersectaX = (pp.getX() + pp.getWidth() >= x - size) && (pp.getX() <= x + size);
        boolean intersectaY = (pp.getY() + pp.getHeight() >= y - size) && (pp.getY() <= y + size);
        return intersectaX && intersectaY;
    }

    boolean collidesWith(Block bb) {
        boolean intersectaX = (bb.getX() + bb.getWidth() >= x - size) && (bb.getX() <= x + size);
        boolean intersectaY = (bb.getY() + bb.getHeight() >= y - size) && (bb.getY() <= y + size);
        return intersectaX && intersectaY;
    }

	public int getY() {
		
		return this.y;
	}
	public int getySpeed() {
		return ySpeed;
	}
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	
}