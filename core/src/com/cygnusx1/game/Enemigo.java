package com.cygnusx1.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Oscar Patiño on 28/05/2017.
 */

public abstract class Enemigo{
    protected Sprite sprite;
    protected Sprite ataque;
    protected Sprite ataque2;
    protected Sprite ataque3;
    protected Sprite ataque4;
    protected Rectangle rectangle;

    protected boolean alive = true;
    protected int counter = 0;
    protected int counter2 = 0;
    protected int lives;

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

    public abstract void dispose();

    public Rectangle getRectangle(){
        return sprite.getBoundingRectangle();
    }
}
