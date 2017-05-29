package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Oscar Patiño on 28/05/2017.
 */

public abstract class Enemigo{
    private TiledMapTileLayer mapa;
    protected int vidas;
    protected Sprite sprite;
    protected int counter = 0;

    public Enemigo(TiledMapTileLayer mapa){
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
