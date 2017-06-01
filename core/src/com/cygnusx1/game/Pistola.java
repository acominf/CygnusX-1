package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by andrey on 28/05/17.
 */
public class Pistola extends Arma {

    public Pistola(float x, float y){
        clip = 100;
        balas = clip;
        velocidad = 15;
        damage = 1;
        bala = new Sprite(new Texture(Gdx.files.internal("bala.png")));
        recBala = bala.getBoundingRectangle();
        bala.translate(x, y);
    }

    @Override
    public void drawStart(SpriteBatch batch) {

    }

    @Override
    public void mueveBalaX(){
        bala.translateX(velocidad);
    }

    @Override
    public void mueveBalamX() {
        bala.translateX(-velocidad);
    }

    @Override
    public void mueveBalaY() {
        bala.translateY(velocidad);
    }

    @Override
    public void mueveBalamY() {
        bala.translateY(-velocidad);
    }
}
