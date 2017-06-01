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
    private Sprite sprite;
    private Rectangle rectangulo;
    public TiledMapTileLayer mapa;

    private boolean keyRight;
    private boolean keyLeft;
    private boolean keyUp;
    private boolean keyDown;

    private Texture arriba;
    private Texture abajo;
    private Texture izquierda;
    private Texture derecha;
    private Texture texDisparo;

    private int vidas; // vida
    private float timeSeconds = 0f;
    private float period = 0.025f;
    private boolean dispara;
    private int cont = 0;
    private int direction = 1;

    public Jugador(int x, int y, TiledMapTileLayer m, int vidas){
        mapa = m;
        this.vidas = vidas;
        arriba = new Texture(Gdx.files.internal("arriba.png"));
        abajo = new Texture(Gdx.files.internal("abajo.png"));
        derecha = new Texture(Gdx.files.internal("derecha.png"));
        izquierda = new Texture(Gdx.files.internal("izquierda.png"));

        sprite = new Sprite(abajo);
        sprite.translate(x, y);
        rectangulo = sprite.getBoundingRectangle();

    }

    public void draw(final SpriteBatch batch, Arma pistola){  //metodo
        float tileWidth = mapa.getTileWidth(), tileHeight = mapa.getTileHeight();
        float x = sprite.getX(), y = sprite.getY();
        boolean colisionDown;

        if(keyDown && sprite.getY() > 0){ //abajo
            sprite.translateY(-5f);
            sprite.setTexture(abajo);
            colisionDown = mapa.getCell((int)((x/tileWidth+1)), (int)(((y)/tileHeight))).getTile().getProperties().containsKey("Pared");
            if(colisionDown)
                sprite.translateY(5f);
        }
        if(keyUp && sprite.getY() < 32*98){ //arriba //numero de celdas -2 * tamaño de la celda
            sprite.translateY(5f);
            sprite.setTexture(arriba);
            colisionDown = mapa.getCell((int)((x/tileWidth+1)), (int)(((y+sprite.getHeight()/1.3)/tileHeight))).getTile().getProperties().containsKey("Pared");
            if(colisionDown)
                sprite.translateY(-5f);
        }
        if(keyLeft && sprite.getX() > 0){ //izquierda
            sprite.translateX(-5f);
            sprite.setTexture(izquierda);
            colisionDown = mapa.getCell((int)(((x-sprite.getWidth()/3)/tileWidth+1)), (int)(((y)/tileHeight))).getTile().getProperties().containsKey("Pared");
            if(colisionDown)
                sprite.translateX(5f);
        }
        if(keyRight && sprite.getX() < 32*98){ //derecha
            sprite.translateX(5f);
            sprite.setTexture(derecha);
            colisionDown = mapa.getCell((int)(((x+sprite.getWidth()/3)/tileWidth+1)), (int)(y/tileHeight)).getTile().getProperties().containsKey("Pared");
            if(colisionDown)
                sprite.translateX(-5f);
        }
        if(dispara){
            cont = 30;
            pistola.shoot();
            pistola.reposicionaBala(x, y);
            dispara = false;
        }

        if(cont > 0){
            //pistola.drawBala(batch);
            //batch.draw(pistola.getSprite(), pistola.getSprite().getX(), pistola.getSprite().getY());
            timeSeconds += Gdx.graphics.getRawDeltaTime();
        }
        if(timeSeconds > period && cont > 0){
            timeSeconds -= period;
            if(cont > 0){
                if(direction == 3){
                    pistola.mueveBalaX();
                } else {
                    if (direction == 4) {
                        pistola.mueveBalamX();
                    } else {
                        if (direction == 2) {
                            pistola.mueveBalaY();
                        } else {
                            if (direction == 1) {
                                pistola.mueveBalamY();
                            }
                        }
                    }
                }
                cont--;
            }
        }
        pistola.drawBala(batch);
        //batch.draw(pistola.getSprite(), pistola.getSprite().getX(), pistola.getSprite().getY());
        batch.draw(sprite, sprite.getX(), sprite.getY());
    }

    @Override
    public boolean keyDown(int keycode){
        switch(keycode){
            case 20: //down
                direction = 1;
                keyDown = true;
                break;
            case 19: //up
                direction = 2;
                keyUp = true;
                break;
            case 22: //right
                direction = 3;
                keyRight = true;
                break;
            case 21: //left
                direction = 4;
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
        return rectangulo.overlaps(arma.rectanguloArma());
    }

    public boolean hitMonster(Enemigo ene){
        return sprite.getBoundingRectangle().overlaps(ene.getRectangle());
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

    public int getLives(){
        return vidas;
    }

    public void loseLife(){
        vidas--;
    }

    public void moveSprite(){
        sprite.translate(-100, -100);
    }

    public void inicializa(){
        sprite.setPosition(128, 128);
    }

    public void dispose(){
        arriba.dispose();
        abajo.dispose();
        derecha.dispose();
        izquierda.dispose();
        sprite.getTexture().dispose();
    }
}
