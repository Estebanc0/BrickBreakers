package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PantallaJuego implements Screen{
	private BlockBreakerGame game;
	private OrthographicCamera camera;
	private SpriteBatch batch;	   
	private BitmapFont font;
	private ShapeRenderer shape;
	private PingBall ball;
	private Paddle pad;
	private ArrayList<Block> blocks = new ArrayList<>();
	private int vidas;
	private int puntaje;
	private int nivel;
	private Texture bloqueTexture;
	private Texture fondoTexture;
	public PantallaJuego(BlockBreakerGame game) {
		this.game=game;
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 800, 480);
	    batch = new SpriteBatch();
	    font = new BitmapFont();
	    font.getData().setScale(3, 2);
	    nivel = 1;
	    crearBloques(2+nivel);
	    
	    bloqueTexture = new Texture("ladrillo.png");
	    fondoTexture = new Texture("fondo.png");
		
	    shape = new ShapeRenderer();
	    ball = new PingBall(Gdx.graphics.getWidth()/2-10, 41, 10, 5, 7, true);
	    pad = new Paddle(Gdx.graphics.getWidth()/2-50,40,100,10);
	    vidas = 3;
	    puntaje = 0;    
	}
	public void crearBloques(int filas) {
		blocks.clear();
		int blockWidth = 70;
	    int blockHeight = 26;
	    int y = Gdx.graphics.getHeight();
	    for (int cont = 0; cont<filas; cont++ ) {
	    	y -= blockHeight+10;
	    	for (int x = 5; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
	            blocks.add(new Block(x, y, blockWidth, blockHeight));
	        }
	    }
	}
	public void dibujaTextos() {
		//actualizar matrices de la cámara
		camera.update();
		//actualizar 
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//dibujar textos
		font.draw(batch, "Puntos: " + puntaje, 10, 25);
		font.draw(batch, "Vidas : " + vidas, Gdx.graphics.getWidth()-20, 25);
		batch.end();
	}

	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 	
		batch.begin();
		batch.draw(fondoTexture,0,0,800, 600);
		batch.end();
		
        shape.begin(ShapeRenderer.ShapeType.Filled);
        pad.draw(shape);
        
        // monitorear inicio del juego
        if (ball.estaQuieto()) {
        	ball.setXY(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11);
        	if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) ball.setEstaQuieto(false);
        }else ball.update();
        //verificar si se fue la bola x abajo
        if (ball.getY()<0) {
        	vidas--;
        	//nivel = 1;
        	ball = new PingBall(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11, 10, 5, 7, true);
        }
        // verificar game over
        if (vidas<=0) {
        	vidas = 3;
        	nivel = 1;
        	puntaje=0;
        	crearBloques(2+nivel);
        	//ball = new PingBall(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11, 10, 5, 7, true);	        	
        }
        // verificar si el nivel se terminó
        if (blocks.size()==0) {
        	nivel++;
        	crearBloques(2+nivel);
        	ball = new PingBall(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11, 10, 5, 7, true);
        }    	
        //dibujar bloques
        for (Block b : blocks) {        	
            b.draw(shape);
            ball.checkCollision(b);
        }
        // actualizar estado de los bloques 
        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            if (b.isDestroyed()) {
            	puntaje++;
                blocks.remove(b);
                i--; //para no saltarse 1 tras eliminar del arraylist
            }
        }
        
        ball.checkCollision(pad);
        ball.draw(shape);
        
        shape.end();
        dibujaTextos();
		
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
