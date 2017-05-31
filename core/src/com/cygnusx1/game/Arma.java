package com.cygnusx1.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by andrey on 28/05/17.
 */
public abstract class Arma {
    protected Sprite bala;
    protected Sprite arma;
    protected Rectangle recBala;
    protected Rectangle recArma;
    protected float velocidad;
    protected float damage;
    protected int balas;
    protected int clip;
    protected boolean taked = false;

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

    public void take(){
        taked = true;
    }

    public boolean isTaked(){
        return taked;
    }

    public float getDamage(){
        return damage;
    }

    public Rectangle rectanguloBala(){
        return bala.getBoundingRectangle();
    }

    public void reposicionaBala(float x, float y){
        bala.setPosition(x, y);
    }

    public void shoot(){
        balas--;
    }

    public Sprite getSprite(){
        return bala;
    }

    public float getVelocity(){
        return velocidad;
    }
}
