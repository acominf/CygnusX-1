package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cygnusx1.game.CygnusX1;
import sun.java2d.pipe.SpanIterator;

/**
 * Created by andrey on 30/05/17.
 */
public class Ayuda implements Screen {
    private Sprite ayuda;
    private SpriteBatch batch;
    private CygnusX1 juego;

    public Ayuda(CygnusX1 juego){
        this.juego = juego;
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        ayuda = new Sprite(new Texture(Gdx.files.internal("Ayuda.png")));
    }

    @Override
    public void render(float delta) {
        batch.begin();
        ayuda.draw(batch);
        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            juego.setScreen(new Menu(juego));
        }
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

    }

    @Override
    public void dispose() {
        batch.dispose();
        ayuda.getTexture().dispose();
    }
}
