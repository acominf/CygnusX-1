package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by andrey on 9/05/17.
 */
public class Jugador extends Actor implements InputProcessor{
    private Sprite sprite;
    private int vidas; // vidas
    private int x;
    private int y;
    private float tam;
    private TiledMapTileLayer mapa;
    private CygnusX1 juego;
    private boolean keyDown; //flechas de movimiento
    private boolean keyUp;
    private boolean keyLeft;
    private boolean keyRight;


    public Jugador(int x, int y, CygnusX1 game, TiledMapTileLayer m){
        this.mapa = m;
        juego = game;
        this.x = x;
        this.y = y;

        this.tam = 3;
        sprite = new Sprite(new Texture(Gdx.files.internal("abajo.png")));
    }

    public void draw(final SpriteBatch batch){  //metodo
        float oldX = getX(), oldY = getY(), tileWidth = mapa.getTileWidth(), tileHeight = mapa.getTileHeight();
        boolean colisionUp = false, colisionDown = false, colisionRight = false, colisionLeft = false;


        if(keyDown && sprite.getY() > 0){ //abajo
            sprite.translateY(-5f);
        }
        if(keyUp && sprite.getY() < Gdx.graphics.getHeight()){ //arriba
            sprite.translateY(5f);
        }
        if(keyLeft && sprite.getX() > 0){ //izquierda
            sprite.translateX(-5f);
        }
        if(keyRight && sprite.getX() < Gdx.graphics.getWidth()){ // izquierda
            sprite.translateX(5f);
        }

        System.out.println((int)((sprite.getX()/tileWidth)+1) + ", " + (int)((99-(sprite.getY()/tileHeight))+1));

        //colisionDown = mapa.getCell((int)(sprite.getX()/tileWidth), (int)((sprite.getY()-sprite.getHeight())/tileHeight)).getTile().getProperties().containsKey("Pared");
        //System.out.println(mapa.getCell((int)(sprite.getX()/tileHeight), (int)((sprite.getY()-sprite.getHeight())/tileHeight)).getTile().getId());        ;
        if(colisionDown){
            sprite.translateY(5f);
        }
        batch.draw(sprite, sprite.getX(), sprite.getY());
    }

    @Override
    public boolean keyDown(int keycode){
        switch(keycode){
            case 20: //down
                keyDown = true;
                break;
            case 19: //up
                keyUp = true;
                break;
            case 22: //right
                keyRight = true;
                break;
            case 21: //left
                keyLeft = true;
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode){
        switch(keycode){
            case 20: //down
                keyDown = false;
                break;
            case 19: //up
                keyUp = false;
                break;
            case 22: //right
                keyRight = false;
                break;
            case 21: //left
                keyLeft = false;
                break;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
