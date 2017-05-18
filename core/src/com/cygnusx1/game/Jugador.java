package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cygnusx1.game.Screens.Portada;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by andrey on 9/05/17.
 */
public class Jugador{
    private Sprite sprite;
    private int x;
    private int y;
    private float tam;
    private CygnusX1 juego;

    public Jugador(int x, int y, CygnusX1 game){
        juego = game;
        this.x = x;
        this.y = y;
        this.tam = 5;

        sprite = new Sprite( new Texture(Gdx.files.internal("abajo.png")));

    }


    public void movimiento(final SpriteBatch batch){

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            this.x+=this.tam;
            this.sprite = new Sprite ( new Texture(Gdx.files.internal("derecha.png")));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            this.sprite = new Sprite ( new Texture(Gdx.files.internal("izquierda.png")));

            this.x-=this.tam;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            this.sprite = new Sprite ( new Texture(Gdx.files.internal("arriba.png")));
            this.y+=this.tam;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            this.sprite = new Sprite ( new Texture(Gdx.files.internal("abajo.png")));
            this.y-=this.tam;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            juego.setScreen(new Portada(juego));
        }
        batch.draw(sprite, x, y);
    }
}
