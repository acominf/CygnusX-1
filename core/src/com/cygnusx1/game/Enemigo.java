package com.cygnusx1.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Oscar Patiño on 28/05/2017.
 */

public abstract class Enemigo{
    public Sprite sprite;
    public Sprite ataque;
    public Sprite ataque2;
    public Sprite ataque3;
    public Sprite ataque4;
    public Rectangle rectangle;

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

    public void hit(SpriteBatch batch, Arma gun, float x, float y){
        if(!colisiona(gun.rectanguloBala()) && alive && lives > 0){
            draw(batch);
        }
        else{
            if(lives > 0){
                lives -= gun.getDamage();
                //jug.cont = 0;
                gun.reposicionaBala(x, y);
            }
            else{
                if(lives <= 0){
                    alive = false;
                }
            }
        }
    }

    public boolean colisiona(Rectangle rec){
        rectangle = sprite.getBoundingRectangle();
        return rectangle.overlaps(rec);
        //return rec.overlaps(rectangle); CHECA ESTO :vvvvvvvvvvvvvvvvvvvvvvvvvv
    }

    public abstract void move();

    public abstract void draw(SpriteBatch batch);

    public boolean isAlive(){
        return alive;
    }
}
