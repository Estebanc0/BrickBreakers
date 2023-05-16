package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PingBall implements Drawable{
    private int x;
    private int y;
    private int size;
    private int xSpeed;
    private int ySpeed;
    private Color color;
    private boolean estaQuieto;

    public PingBall(int x, int y, int size, int xSpeed, int ySpeed, boolean iniciaQuieto) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.color = Color.BLACK;
        this.estaQuieto = iniciaQuieto;
    }

    public boolean estaQuieto() {
        return estaQuieto;
    }

    public void setEstaQuieto(boolean estaQuieto) {
        this.estaQuieto = estaQuieto;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    

    public void update() {
        if (estaQuieto) {
            return;
        }
        x += xSpeed;
        y += ySpeed;
        if (x - size < 0 || x + size > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if (y + size > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            color = Color.GREEN;
            ySpeed = -ySpeed;
        } else {
            color = Color.BLACK;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        boolean intersectaX = (paddle.getX() + paddle.getWidth() >= x - size) && (paddle.getX() <= x + size);
        boolean intersectaY = (paddle.getY() + paddle.getHeight() >= y - size) && (paddle.getY() <= y + size);
        return intersectaX && intersectaY;
    }

    public void checkCollision(Block block) {
        if (collidesWith(block)) {
            ySpeed = -ySpeed;
            block.setDestroyed(true);
        }
    }

    private boolean collidesWith(Block block) {
        boolean intersectaX = (block.getX() + block.getWidth() >= x - size) && (block.getX() <= x + size);
        boolean intersectaY = (block.getY() + block.getHeight() >= y - size) && (block.getY() <= y + size);
        return intersectaX && intersectaY;
    }
    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }
}
