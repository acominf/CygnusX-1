package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

/**
 * Created by andrey on 28/05/17.
 */
public class Pistola extends Arma {
    private  TiledMapTileLayer mapa;
    private boolean colisionDown;

    public Pistola(float x, float y, TiledMapTileLayer mapa) {
        super(mapa);
        sprite = new Sprite(new Texture(Gdx.files.internal("bala1.png")));
        sprite.translate(x,y);
    }

    @Override
    public void move() {

    }
}
