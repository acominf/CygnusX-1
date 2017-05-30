package com.cygnusx1.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by andrey on 28/05/17.
 */
public abstract class Arma {
    public Sprite bala;
    protected Sprite arma;
    protected Rectangle recBala;
    public Rectangle recArma;
    protected int balas;
    protected float velocidad;
    protected float damage;
    protected int clip;
    public boolean taked;

    public Arma(){
    }

    public void draw(SpriteBatch batch, float x, float y){
        batch.draw(arma, x+30, y-30);
    }

    public void recarga(){
        balas = clip;
    }

    public void draw(SpriteBatch batch){
        batch.draw(arma, arma.getX(), arma.getY());
    }
}
