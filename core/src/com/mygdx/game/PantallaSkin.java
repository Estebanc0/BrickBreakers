package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class PantallaSkin implements Screen {
	private BlockBreakerGame game;
	private OrthographicCamera camera;
	private Texture fondo;
	public PantallaSkin(BlockBreakerGame game) {
		this.game = game;
        fondo=new Texture("Skin.png");
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
		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
			Screen ss = new PantallaJuego(game,Color.GREEN);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
			Screen ss = new PantallaJuego(game,Color.RED);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
			Screen ss = new PantallaJuego(game,Color.BLUE);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
			Screen ss = new PantallaJuego(game,Color.BLACK);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)) {
			Screen ss = new PantallaJuego(game,Color.PURPLE);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.NUM_6)) {
			Screen ss = new PantallaJuego(game,Color.YELLOW);
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