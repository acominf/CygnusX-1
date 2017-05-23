package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.cygnusx1.game.CygnusX1;
import com.cygnusx1.game.Jugador;

/**
 * Created by andrey and Oscar on 11/05/17.
 */

public class Escenario implements Screen{
    private CygnusX1 juego;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Jugador jug;
    private Sprite mons1;
    private Timer t1;
    private int x;

    public Escenario(CygnusX1 juego){
        x = 1;
        this.juego = juego;
        jug = new Jugador(0, 0, juego);
        mons1 = new Sprite(new Texture(Gdx.files.internal("botiquin.png")));
        batch = new SpriteBatch(); // Objetos a Dibujar

        camera = new OrthographicCamera(); // Canvas
        camera.setToOrtho(false, 800, 600); // Dimensiones de la pantalla
        camera.update();
        //sprite = new Sprite(new Texture(Gdx.files.internal("tierra.png")));
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        camera.update();
        //batch.setProjectionMatrix(camera.combined);
        batch.begin();
        if(x == 1){
            batch.draw(mons1, 100, 100);
            batch.draw(mons1, 200, 200);
            x = 3;
        }
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
