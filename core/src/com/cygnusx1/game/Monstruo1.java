package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Oscar Patiño on 23/05/2017.
 */

public class Monstruo1 extends Enemigo{
    public Monstruo1(int x, int y){

        lives = 20;
        sprite = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("enemigos.png")), 0, 0, 110, 115));
        ataque = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("armas.png")), 720, 480, 120, 100));
        ataque2 = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("armas.png")), 720, 480, 120, 100));
        ataque3 = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("armas.png")), 720, 480, 120, 100));
        ataque4 = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("armas.png")), 720, 480, 120, 100));

        ataque.translate(x, y);
        ataque2.translate(x, y);
        ataque3.translate(x, y);
        ataque4.translate(x, y);
        sprite.translate(x, y);
        rectangle = sprite.getBoundingRectangle();
    }

    @Override
    public void move(){  //metodo que se encarga de mover el monstruo y mover t//odo lo relacionado con el
        if (counter < 80){
            sprite.translateX(5f);
        } else {
            if (counter < 160) {
                sprite.translateX(-5f);
            } else {
                counter = 0;
            }
        }
        if((counter-counter2) %20 == 0){  //ataque del monstruo 1
            counter2++;
            ataque.translateX(10);
            ataque2.translateX(-10);
            ataque3.translateY(10);
            ataque4.translateY(-10);
            if(counter2 == 10){
                counter2 = 0;
                ataque.setPosition(sprite.getX(), sprite.getY());
                ataque2.setPosition(sprite.getX(), sprite.getY());
                ataque3.setPosition(sprite.getX(), sprite.getY());
                ataque4.setPosition(sprite.getX(), sprite.getY());
            }
        }

        ///System.out.println(counter + ", " + counter2);
        counter++;
    }

    @Override
    public void draw(SpriteBatch batch){ //funcion que dibuja el monstruo y sus ataques
        batch.draw(sprite, sprite.getX(), sprite.getY());
        batch.draw(ataque, ataque.getX(), ataque.getY());
        batch.draw(ataque2, ataque2.getX(), ataque2.getY());
        batch.draw(ataque3, ataque3.getX(), ataque3.getY());
        batch.draw(ataque4, ataque4.getX(), ataque4.getY());
    }

    @Override
    public void dispose(){
        sprite.getTexture().dispose();
        ataque.getTexture().dispose();
        ataque2.getTexture().dispose();
        ataque3.getTexture().dispose();
        ataque4.getTexture().dispose();
    }
}
