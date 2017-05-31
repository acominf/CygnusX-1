package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by andrey on 28/05/17.
 */
public class Pistola extends Arma{

    public Pistola(float x, float y){
        clip = 100;
        balas = clip;
        velocidad = 15;
        damage = 1;
        bala = new Sprite(new Texture(Gdx.files.internal("bala.png")));
        recBala = bala.getBoundingRectangle();
        bala.translate(x, y);
    }
}
