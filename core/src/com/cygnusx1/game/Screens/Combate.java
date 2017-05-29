package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.cygnusx1.game.CygnusX1;

/**
 * Created by Oscar Patiño on 16/05/2017.
 */
public class Combate extends ScreenAdapter implements Screen{
    private CygnusX1 j;
    private Escenario es;

    public Combate(CygnusX1 juego, Escenario escenario){
        j = juego;
        es = escenario;
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            dispose();
            j.setScreen(es);
            return;
        }
    }

    @Override
    public void show(){

    }

    @Override
    public void resize(int width, int height){
    }

    @Override
    public void pause(){
    }

    @Override
    public void resume(){

    }

    @Override
    public void hide(){

    }

    @Override
    public void dispose(){

    }
}
