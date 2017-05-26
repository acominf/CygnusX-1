package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cygnusx1.game.CygnusX1;

/**
 * Created by Oscar y adnrey on 17/05/17.
 */
public class Portada implements Screen{
    private CygnusX1 juego;
    private Sprite portada;
    private SpriteBatch batch;

    public Portada(CygnusX1 j){
        juego = j;
        batch = new SpriteBatch();
        portada = new Sprite(new Texture(Gdx.files.internal("Portada2.png")));
    }

    @Override
    public void show(){
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        portada.draw(batch);
        batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            this.dispose();
            juego.setScreen(new Menu(juego));
        }
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
    }
}
