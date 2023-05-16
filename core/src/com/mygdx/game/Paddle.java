package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    private int x;
    private int y;
    private int width;
    private int height;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.BLUE);
        int x2 = x;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x2 = x - 15;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x2 = x + 15;
        }
        if (x2 > 0 && x2 + width < Gdx.graphics.getWidth()) {
            x = x2;
        }
        shape.rect(x, y, width, height);
    }
}
