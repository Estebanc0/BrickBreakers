package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;


public class PantallaGameOver implements Screen {

	private BlockBreakerGame game;
	private OrthographicCamera camera;
	private Color color;
	public PantallaGameOver(BlockBreakerGame game,Color c) {
		this.game = game;
        color=c;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1200, 800);
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);

		game.getBatch().begin();
		game.getFont().draw(game.getBatch(), "Game Over !!! ", 400, 500,400,1,true);
		game.getFont().draw(game.getBatch(), "Presiona enter para reiniciar o escape para volver al menu principal", 200, 400);
	
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