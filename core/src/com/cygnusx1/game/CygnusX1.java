package com.cygnusx1.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CygnusX1 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private OrthographicCamera camera;
	private Jugador jug;

	@Override
	public void create () {
		batch = new SpriteBatch(); // Objetos a Dibujar
		img = new Texture("tierra.png");
		camera = new OrthographicCamera(); // Canvas
		camera.setToOrtho(false, 1024, 600); // Dimensiones de la pantalla
		camera.update();
		jug = new Jugador(1024-400, 600-400);
	}

	@Override
	public void render () {
		//Limpiar buffer de dibujo
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		jug.movimiento(batch);
		batch.draw(img, 150, 150);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}




}
