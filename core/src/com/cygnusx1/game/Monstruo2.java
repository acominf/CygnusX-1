package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

/**
 * Created by Oscar Patiño on 28/05/2017.
 */

public class Monstruo2 extends Enemigo{
    public Monstruo2(int x, int y) {
        lives = 30;
        sprite = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("enemigos.png")), 110, 0, 60, 100));
        ataque = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("armas.png")), 720, 480, 120, 100));
        ataque2 = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("armas.png")), 720, 480, 120, 100));
        ataque3 = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("armas.png")), 720, 480, 120, 100));
        ataque4 = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("armas.png")), 720, 480, 120, 100));
        sprite.setPosition(x, y);
        ataque.translate(x, y);
        ataque2.translate(x, y);
        ataque3.translate(x, y);
        ataque4.translate(x, y);
        rectangle = sprite.getBoundingRectangle();
    }

    @Override
    public void move(){
        if (counter < 80){
            sprite.translateY(5f);
        } else {
            if (counter < 160) {
                sprite.translateY(-5f);
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
    public void draw(SpriteBatch batch) {
        batch.draw(sprite, sprite.getX(), sprite.getY());
        batch.draw(ataque, ataque.getX(), ataque.getY());
        batch.draw(ataque2, ataque2.getX(), ataque2.getY());
        batch.draw(ataque3, ataque3.getX(), ataque3.getY());
        batch.draw(ataque4, ataque4.getX(), ataque4.getY());
    }
}
