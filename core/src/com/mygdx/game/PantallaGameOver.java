package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;


public class PantallaGameOver extends BaseScreen{
	private OrthographicCamera camera;
	private Texture fondo;
	public PantallaGameOver(BlockBreakerGame game,Color c) {
		super(game,c);
        fondo=new Texture("gameOver.jpg");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1200, 800);
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);
		game.getBatch().begin();
		game.getBatch().draw(fondo, 0, 0, 1200,800);
		game.getBatch().end();
		

		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			Screen ss = new PantallaJuego(game,color);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			Screen ss = new PantallaMenu(game);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
	}
 
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
   
}