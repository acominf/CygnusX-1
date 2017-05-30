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
        clip = 100;
        balas = clip;
        velocidad = 15;
        damage = 1;
        taked = false;
        bala = new Sprite(new Texture(Gdx.files.internal("bala.png")));
        recBala = bala.getBoundingRectangle();
        System.out.print("Bala construida");
        bala.translate(x, y);
    }

    public void relocaliza(float x, float y){
        bala.translate(x, y);
    }

    public Rectangle rectangulo(){
        //rectangulo de la bala, no de la postola
        return bala.getBoundingRectangle();
    }
}
