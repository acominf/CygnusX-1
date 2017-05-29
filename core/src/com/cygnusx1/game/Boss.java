package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Oscar Patiño on 29/05/2017.
 */

public class Boss extends Enemigo{
    public Boss(int x, int y){
        lives = 150;
        sprite = new Sprite(new Texture(Gdx.files.internal("boss.png")));
        rectangle = sprite.getBoundingRectangle();

        if(counter < 80){
            sprite.translateX(5f);
        }
        else{
            if(counter < 160){
                sprite.translateX(-5f);
            }
            else{
                counter = 0;
            }
        }
        counter ++; sprite.setPosition(x, y);
    }

    @Override
    public void move(){

    }

    @Override
    public void draw(SpriteBatch batch){
        batch.draw(sprite, sprite.getX(), sprite.getY());
    }
}
