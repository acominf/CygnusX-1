package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cygnusx1.game.CygnusX1;
import com.cygnusx1.game.Jugador;

/**
 * Created by Oscar Patiño on 30/05/2017.
 */
public class EndScreen implements Screen {
    private final SpriteBatch batch;
    private CygnusX1 juego;
    private Sprite gameOver;
    private int timer = 50;

    public EndScreen(CygnusX1 j, Jugador jug){
        juego = j;
        batch = new SpriteBatch();
        gameOver = new Sprite(new Texture(Gdx.files.internal("end.png")));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        if(timer > 0){
            gameOver.draw(batch);
            timer--;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            juego.setScreen(new Menu(juego));
        }
            juego.setScreen(new Menu(juego));
        batch.end();
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
        gameOver.getTexture().dispose();
        batch.dispose();
    }

    @Override
    public void dispose() {

    }
}
