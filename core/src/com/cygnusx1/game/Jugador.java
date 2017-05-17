package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by andrey on 9/05/17.
 */
public class Jugador {
    private Sprite sprite;
    private int x;
    private int y;
    private  float tam;

    public Jugador(int x, int y){
        this.x = x;
        this.y = y;
        this.tam = 5;

        sprite = new Sprite( new Texture(Gdx.files.internal("abajo.png")));

    }


    public  void movimiento(final SpriteBatch batch){

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            this.x+=this.tam;
            this.sprite = new Sprite ( new Texture(Gdx.files.internal("derecha.png")));
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            this.sprite = new Sprite ( new Texture(Gdx.files.internal("izquierda.png")));

            this.x-=this.tam;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            this.sprite = new Sprite ( new Texture(Gdx.files.internal("arriba.png")));
            this.y+=this.tam;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            this.sprite = new Sprite ( new Texture(Gdx.files.internal("abajo.png")));
            this.y-=this.tam;
        }
        batch.draw(sprite, x, y);
    }
}
