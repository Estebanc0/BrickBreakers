package com.mygdx.game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class PowerUp extends GameObject implements Drawable {
    private int size;
    private int ySpeed;
    private boolean active;
    private Color color;
    
    public PowerUp(int x, int y, int size, int ySpeed, Color color) {
        super(x, y);
        this.size = size;
        this.ySpeed = ySpeed;
        this.active = false;
        this.color = color;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public void update() {
        if (active) {
            y -= ySpeed;
        }
    }

    @Override
    public void draw(ShapeRenderer shape) {
        if (active) {
            shape.setColor(color);
            shape.circle(x, y, size);
        }
    }
    
    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
          
            ySpeed = -ySpeed;}
    }
    
    boolean collidesWith(Paddle pp) {
        boolean intersectaX = (pp.getX() + pp.getWidth() >= x - size) && (pp.getX() <= x + size);
        boolean intersectaY = (pp.getY() + pp.getHeight() >= y - size) && (pp.getY() <= y + size);
        return intersectaX && intersectaY;
    }
    
    public static PowerUpBuilder builder() {
        return new PowerUpBuilder();
    }
}
