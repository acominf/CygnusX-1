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
    protected Sprite arma;
    public Sprite bala;
    protected int balas;

    public Arma(TiledMapTileLayer mapa){
        this.mapa = mapa;
    }

    public void draw(SpriteBatch batch, float x, float y){
        batch.draw(arma, x+30, y-30);
    }

    public abstract void dispara(Sprite sprite, SpriteBatch batch);

    public void relocaliza(float x, float y){
        bala.translate(x, y);
    }
}
