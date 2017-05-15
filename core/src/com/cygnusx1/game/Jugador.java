
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
        this.tam = 2;

        sprite = new Sprite( new Texture(Gdx.files.internal("badlogic.jpg")),64,64);
    }

    public  void movimiento(final SpriteBatch batch){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            this.x+=this.tam;
            this.sprite = new Sprite ( new Texture(Gdx.files.internal("x-1.png")));
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            this.x-=this.tam;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            this.y+=this.tam;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            this.y-=this.tam;
        }
        batch.draw(sprite, x, y);
    }
}
