package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public abstract class BaseScreen implements Screen{
	protected BlockBreakerGame game;
    protected Color color;
    
    public BaseScreen(BlockBreakerGame game, Color color) {
        this.game = game;
        this.color = color;
    }
    
    @Override
    public void show() {
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
