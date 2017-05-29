package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

/**
 * Created by Oscar Patiño on 28/05/2017.
 */

public class Monstruo2 extends Enemigo{

    public Monstruo2(int x, int y) {
        lives = 30;
        sprite = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("enemigos.png")), 110, 0, 60, 100));
        sprite.setPosition(x, y);
        rectangle = sprite.getBoundingRectangle();
    }

    @Override
    public void move(){
        if(counter < 80){
            sprite.translateY(5f);
        }
        else{
            if(counter < 160){
                sprite.translateY(-5f);
            }
            else{
                counter = 0;
            }
        }
        counter ++;
    }

    @Override
    public void draw(SpriteBatch batch) {

    }
}
