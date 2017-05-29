package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

/**
 * Created by andrey on 28/05/17.
 */
public class Pistola extends Arma {
    private TiledMapTileLayer mapa;
    private boolean colisionDown;

    public Pistola(float x, float y, TiledMapTileLayer mapa) {
        super(mapa);
        balas = 100;
        arma = new Sprite(new Texture(Gdx.files.internal("pistola.png")));
        bala = new Sprite(new Texture(Gdx.files.internal("bala1.png")));
        arma.translate(x, y);
        bala.translate(x, y);
    }

    @Override
    public void dispara(Sprite jug, SpriteBatch batch){

    }

        /*
    public void disparaBala(){
        Sprite bala = new Sprite(new Texture(Gdx.files.internal("bullet.png")));
        int cont = 0;
        while(cont != 30){
            if(sprite.getTexture() == derecha){
                bala.translateX(5f);
            }
            else
                if(sprite.getTexture() == izquierda){
                    bala.translateX(-5f);
                }
                else
                    if(sprite.getTexture() == arriba){
                        bala.translateY(5f);
                    }
                    else
                        bala.translateY(-5f);
            cont ++;
        }
    }
    */

    public void recarga(){
        balas = 100;
    }
}
