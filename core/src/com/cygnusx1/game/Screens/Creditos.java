package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cygnusx1.game.CygnusX1;

/**
 * Created by andrey on 29/05/17.
 */
public class Creditos implements Screen {
    private Sprite C0;
    private Sprite C1;
    private Sprite C2;
    private Sprite C3;
    private Sprite C4;
    private Sprite C5;
    private Sprite C6;
    private Sprite C7;
    private Sprite C8;
    private SpriteBatch batch;

    public int timer0= 50;
    public int timer1= 50;
    public int timer2= 50;
    public int timer3= 50;
    public int timer4= 50;
    public int timer5= 50;
    public int timer6= 50;
    public int timer7= 50;
    public int timer8= 50;

    private CygnusX1 juego;

    public Creditos(CygnusX1 juego){
        this.juego = juego;
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        C0 = new Sprite(new Texture(Gdx.files.internal("Creditos/00.png")));
        C1 = new Sprite(new Texture(Gdx.files.internal("Creditos/01.png")));
        C2 = new Sprite(new Texture(Gdx.files.internal("Creditos/02.png")));
        C3 = new Sprite(new Texture(Gdx.files.internal("Creditos/03.png")));
        C4 = new Sprite(new Texture(Gdx.files.internal("Creditos/04.png")));
        C5 = new Sprite(new Texture(Gdx.files.internal("Creditos/05.png")));
        C6 = new Sprite(new Texture(Gdx.files.internal("Creditos/06.png")));
        C7 = new Sprite(new Texture(Gdx.files.internal("Creditos/07.png")));
        C8 = new Sprite(new Texture(Gdx.files.internal("Creditos/08.png")));
    }

    @Override
    public void render(float delta) {
        batch.begin();
        if(timer0 > 0){
            timer0--;
            C0.draw(batch);
        }
        else if(timer1 > 0){
            timer1--;
            C1.draw(batch);
        }
        else if(timer2 > 0){
            timer2--;
            C2.draw(batch);
        }
        else if(timer3 > 0){
            timer3--;
            C3.draw(batch);
        }
        else if(timer4 > 0) {
            timer4--;
            C4.draw(batch);
        }
        else if(timer5 > 0){
            timer5--;
            C5.draw(batch);
        }
        else if(timer6 > 0){
            timer6--;
            C6.draw(batch);
        }
        else if(timer7 > 0){
            timer7--;
            C7.draw(batch);
        }
        else if(timer8 > 0) {
            timer8--;
            C8.draw(batch);
        }
        batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            juego.setScreen(new Menu(juego));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        this.dispose();
    }

    @Override
    public void dispose() {
        C0.getTexture().dispose();
        C1.getTexture().dispose();
        C2.getTexture().dispose();
        C3.getTexture().dispose();
        C4.getTexture().dispose();
        C5.getTexture().dispose();
        C6.getTexture().dispose();
        C7.getTexture().dispose();
        C8.getTexture().dispose();
        batch.dispose();
    }
}
