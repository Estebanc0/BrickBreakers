package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class PantallaMenu implements Screen {
	private BlockBreakerGame game;
	private OrthographicCamera camera;
	private Texture fondo;
	private static volatile PantallaMenu instance;
	private PantallaMenu(BlockBreakerGame game) {
		this.game = game;
        fondo=new Texture("1.png");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1200, 800);
	}
	public static synchronized PantallaMenu getInstance(BlockBreakerGame game) {
		if (instance == null) {
            synchronized (PantallaMenu.class) {
                if (instance == null) {
                    instance = new PantallaMenu(game);
                }
            }
        }
        return instance;
    }
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);

		
		game.getBatch().begin();
		game.getBatch().draw(fondo, 0, 0, 1200,800);
		game.getBatch().end();
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			Screen ss = new PantallaSkin(game);
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
