package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by andrey on 28/05/17.
 */
public class Pistola extends Arma{

    private TiledMapTileLayer mapa;
    private boolean colisionDown;

    public Pistola(float x, float y){
        balas = 100;
        //arma = new Sprite(new Texture(Gdx.files.internal("pistola.png")));
        bala = new Sprite(new Texture(Gdx.files.internal("bala.png")));
        System.out.print("Bala construida");
        //arma.translate(x, y);
        bala.translate(x, y);
    }

    //@Override
    public void dispara(Sprite jug, SpriteBatch batch){

    }

    public void relocaliza(float x, float y){
        bala.translate(x, y);
    }

    public void recarga(){
        balas = 100;
    }

    public Rectangle rectangulo(){
        //rectangulo de la bala, no de la postola
        return bala.getBoundingRectangle();
    }
}
