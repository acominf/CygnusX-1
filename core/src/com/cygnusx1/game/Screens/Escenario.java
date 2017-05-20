package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cygnusx1.game.CygnusX1;
import com.cygnusx1.game.Jugador;

/**
 * Created by andrey and Oscar on 11/05/17.
 */

public class Escenario implements Screen{
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Jugador jug;


    public Escenario(CygnusX1 juego){
        jug = new Jugador(0, 0, juego);

        batch = new SpriteBatch(); // Objetos a Dibujar

        camera = new OrthographicCamera(); // Canvas
        camera.setToOrtho(false, 800, 600); // Dimensiones de la pantalla
        camera.update();
        //sprite = new Sprite(new Texture(Gdx.files.internal("tierra.png")));
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 20, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        camera.update();
        //batch.setProjectionMatrix(camera.combined);
        batch.begin();

        jug.movimiento(batch);

        batch.end();
    }

    @Override
    public void show(){

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
