package com.cygnusx1.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

    public void drawBala(SpriteBatch batch){
        batch.draw(bala, bala.getX(), bala.getY());
    }

    public void recarga(){
        balas = clip;
    }

    public abstract void drawStart(SpriteBatch batch);

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

    public Rectangle rectanguloArma(){
        return(arma.getBoundingRectangle());
    }

    public float getVelocity(){
        return velocidad;
    }

    public abstract void dispose();

    public abstract void mueveBalaX();
    public abstract void mueveBalamX();
    public abstract void mueveBalaY();
    public abstract void mueveBalamY();
}
