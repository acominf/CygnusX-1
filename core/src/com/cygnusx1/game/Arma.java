package com.cygnusx1.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by andrey on 28/05/17.
 */
public abstract class Arma {
    private TiledMapTileLayer mapa;
    protected Sprite sprite;

    public Arma(TiledMapTileLayer mapa){
        this.mapa = mapa;
    }

    public void draw(SpriteBatch batch){
        batch.draw(sprite, sprite.getX(), sprite.getY());
    }

    public Rectangle rectangulo(){
        return sprite.getBoundingRectangle();
    }

    public abstract void move();

}
