package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Oscar Patiño on 29/05/2017.
 */
public class Metralleta extends Arma{
    public Metralleta(float x, float y){
        clip = 300;
        balas = clip;
        velocidad = 20;
        damage = 2;
        taked = false;
        arma = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("armas.png")), 370, 250, 100, 100));
        bala = new Sprite(new Texture(Gdx.files.internal("bullet.png")));
        recArma = arma.getBoundingRectangle();
        recBala = bala.getBoundingRectangle();
        arma.setPosition(x, y);
    }
}
