package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

/**
 * Created by Oscar Patiño on 23/05/2017.
 */

public class Monstruo1 extends Enemigo{

    public Monstruo1(int x, int y, TiledMapTileLayer mapa){
        super(mapa);
        sprite = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("enemigos.png")), 0, 0, 100, 100));
        sprite.translate(x, y);
    }

    @Override
    public void move(){
        if(counter < 80){
            sprite.translateX(5f);
        }
        else{
            if(counter < 160){
                sprite.translateX(-5f);
            }
            else{
                counter = 0;
            }
        }
        counter ++;
    }
}
