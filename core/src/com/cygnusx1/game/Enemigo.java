package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Oscar Patiño on 28/05/2017.
 */

public abstract class Enemigo{
    public Sprite sprite;
    public Sprite ataque;
    public Rectangle rectangle;

    public boolean colision = false;
    public boolean alive = true;
    public int counter = 0;
    public int counter2 = 0;
    public int lives;

    public Enemigo(){
    }

    public float getX(){
        return sprite.getX();
    }

    public float getY(){
        return sprite.getY();
    }

    public void hit(SpriteBatch batch, Sprite bala, float x, float y){
        if(!colisiona(bala.getBoundingRectangle()) && alive && lives > 0){
            draw(batch);
        }
        else{
            if(lives > 0){
                lives--;
                bala.setPosition(x, y);
            }
            else{
                alive = false;
            }
        }
    }

    public boolean colisiona(Rectangle rec){
        rectangle = sprite.getBoundingRectangle();
        return rectangle.overlaps(rec);
    }

    public abstract void move();

    public abstract void draw(SpriteBatch batch);
}
