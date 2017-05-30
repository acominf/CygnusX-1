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
        sprite.setPosition(x, y);
        rectangle = sprite.getBoundingRectangle();
    }

    @Override
    public void move(){


    }

    @Override
    public void draw(SpriteBatch batch){
        batch.draw(sprite, sprite.getX(), sprite.getY());
    }
}
