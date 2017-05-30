package com.cygnusx1.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


/**
 * Created by andrey on 9/05/17.
 */
public class Jugador extends Actor implements InputProcessor{
    public Sprite sprite;
    private Rectangle rectangulo;
    public TiledMapTileLayer mapa;

    private boolean keyDown; //flechas de movimiento
    private boolean keyUp;
    private boolean keyLeft;
    private boolean keyRight;
    private Texture arriba;

    private Texture abajo;
    private Texture izquierda;
    private Texture derecha;
    private Texture texDisparo;

    public int vidas; // vida
    public float timeSeconds = 0f;
    public float period = 0.025f;
    private boolean dispara;
    public int cont = 0;

    public Jugador(int x, int y, TiledMapTileLayer m){
        mapa = m;

        arriba = new Texture(Gdx.files.internal("arriba.png"));
        abajo = new Texture(Gdx.files.internal("abajo.png"));
        derecha = new Texture(Gdx.files.internal("derecha.png"));
        izquierda = new Texture(Gdx.files.internal("izquierda.png"));

        sprite = new Sprite(abajo);
        sprite.translate(x, y);
        rectangulo = sprite.getBoundingRectangle();

    }

    public void draw(final SpriteBatch batch, Arma pistola){  //metodo
        //Sprite bala = new Sprite(new Texture(Gdx.files.internal("bullet.png")));
        float tileWidth = mapa.getTileWidth(), tileHeight = mapa.getTileHeight();
        boolean colisionDown;

        if(keyDown && sprite.getY() > 0){ //abajo
            sprite.translateY(-5f);
            sprite.setTexture(abajo);
            colisionDown = mapa.getCell((int)((sprite.getX()/tileWidth+1)), (int)(((sprite.getY())/tileHeight))).getTile().getProperties().containsKey("Pared");
            if(colisionDown)
                sprite.translateY(5f);
        }
        if(keyUp && sprite.getY() < 32*98){ //arriba //numero de celdas -2 * tamaño de la celda
            sprite.translateY(5f);
            sprite.setTexture(arriba);
            colisionDown = mapa.getCell((int)((sprite.getX()/tileWidth+1)), (int)(((sprite.getY()+sprite.getHeight()/1.3)/tileHeight))).getTile().getProperties().containsKey("Pared");
            if(colisionDown)
                sprite.translateY(-5f);
        }
        if(keyLeft && sprite.getX() > 0){ //izquierda
            sprite.translateX(-5f);
            sprite.setTexture(izquierda);
            colisionDown = mapa.getCell((int)(((sprite.getX()-sprite.getWidth()/3)/tileWidth+1)), (int)(((sprite.getY())/tileHeight))).getTile().getProperties().containsKey("Pared");
            if(colisionDown)
                sprite.translateX(5f);
        }
        if(keyRight && sprite.getX() < 32*98){ //derecha
            sprite.translateX(5f);
            sprite.setTexture(derecha);
            colisionDown = mapa.getCell((int)(((sprite.getX()+sprite.getWidth()/3)/tileWidth+1)), (int)(((sprite.getY())/tileHeight))).getTile().getProperties().containsKey("Pared");
            if(colisionDown)
                sprite.translateX(-5f);
        }
        /* System.out.println(sprite.getX() + ", " + sprite.getY()); */
        if(dispara){
            cont = 30;
            texDisparo = sprite.getTexture();
            pistola.balas--;
            //pistola.bala.setTexture(new Texture(Gdx.files.internal("bullet.png")));
            //pistola.relocaliza(sprite.getX(), sprite.getY());
            pistola.bala.setPosition(sprite.getX(), sprite.getY());
            //System.out.println("Has disparado");
            //System.out.println(pistola.bala.getX() + ", " + pistola.bala.getY());
            dispara = false;
        }

        if(cont > 0){
            batch.draw(pistola.bala, pistola.bala.getX(), pistola.bala.getY());
            timeSeconds += Gdx.graphics.getRawDeltaTime();
        }
        if(timeSeconds > period && cont > 0){
            timeSeconds -= period;
            if(cont > 0){
                if(texDisparo == derecha){
                    pistola.bala.translateX(pistola.velocidad);
                } else {
                    if (texDisparo == izquierda) {
                        pistola.bala.translateX(-pistola.velocidad);
                    } else {
                        if (texDisparo == arriba) {
                            pistola.bala.translateY(pistola.velocidad);
                        } else {
                            if (texDisparo == abajo) {
                                pistola.bala.translateY(-pistola.velocidad);
                            }
                        }
                    }
                }
                cont--;
            }
        }
        System.out.println(cont);
        batch.draw(pistola.bala, pistola.bala.getX(), pistola.bala.getY());
        //pistola.draw(batch, sprite.getX(), sprite.getY());
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
            case 62:
                if(cont == 0)
                    dispara = true;
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
            case 62:
                break;
        }
        return false;
    }

    public float getX(){
        return sprite.getX();
    }

    public float getY(){
        return sprite.getY();
    }

    public void hit(){

    }

    public boolean hitGun(Arma arma){
        rectangulo = sprite.getBoundingRectangle();
        return rectangulo.overlaps(arma.arma.getBoundingRectangle());
    }

    public boolean hitMonster(Enemigo ene){
        return sprite.getBoundingRectangle().overlaps(ene.sprite.getBoundingRectangle());
    }

    public boolean hitBullet(Sprite ataque){
        return sprite.getBoundingRectangle().overlaps(ataque.getBoundingRectangle());
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

    public void rectangle(){
        rectangulo = sprite.getBoundingRectangle();
    }
}
