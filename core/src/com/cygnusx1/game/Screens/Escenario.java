package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.cygnusx1.game.*;

/**
 * Created by andrey and Oscar on 11/05/17.
 */

public class Escenario implements Screen{
    private TiledMap map;
    private Sound sound;
    private OrthogonalTiledMapRenderer mapRen;
    private OrthographicCamera camera;

    //private Stage stage;
    private CygnusX1 juego;
    private Jugador jug;
    private Arma pistola;
    private Monstruo1 ene1;
    private Monstruo2 ene3;

    private Boss jefe;

    public float timeSeconds = 0f;
    public float period = 0.1f;
    private Metralleta metralleta;

    public Escenario(CygnusX1 j){
        juego = j;
    }

    @Override
    public void show(){
        map = new TmxMapLoader().load("map.tmx");
        mapRen = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera(Gdx.graphics.getWidth()/1.5f, Gdx.graphics.getHeight()/1.5f);
        sound = Gdx.audio.newSound(Gdx.files.internal("MF.mp3"));
        sound.play();

        jug = new Jugador(128, 128, (TiledMapTileLayer)(map.getLayers().get(0)));
        ene1 = new Monstruo1(200, 700);
        jefe = new Boss(2950, 3000);
        ene3 = new Monstruo2(350, 1400);
        pistola = new Pistola(128, 128);
        metralleta = new Metralleta(200, 500);

        Gdx.input.setInputProcessor(jug);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        mapRen.setView(camera);
        mapRen.render(new int[] {0});
        mapRen.getBatch().begin();
        camera.position.x = jug.getX()+32;
        camera.position.y = jug.getY()+32;
        camera.update();

        jug.draw((SpriteBatch)mapRen.getBatch(), pistola);
        if(jug.hitGun(metralleta)){
            System.out.println("Junto a arma");
            pistola = metralleta;
            metralleta.taked = true;
        }


        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if(timeSeconds > period){
            timeSeconds -=period;
            ene1.move(); //mueve el jugador cada cierto tiempo
            ene3.move();
        }

        ene1.hit((SpriteBatch)(mapRen.getBatch()), pistola, jug.getX(),jug.getY(), jug); //detecta si un enemigo es golpeado, le quita una vida al enemigo y aumenta puntos
        jefe.hit((SpriteBatch)(mapRen.getBatch()), pistola, jug.getX(),jug.getY(), jug);
        ene3.hit((SpriteBatch)(mapRen.getBatch()), pistola, jug.getX(),jug.getY(), jug);

        if(!jefe.alive){
            juego.setScreen(new Escenario2(juego, jug));
        }
        if(!metralleta.taked) {
            metralleta.draw((SpriteBatch) (mapRen.getBatch()));
        }
        jefe.draw((SpriteBatch)(mapRen.getBatch()));
        mapRen.getBatch().end();
        //System.out.println(jug.getX() + ", " + jug.getY());
        //mapRen.render(new int[] {1});
    }

    @Override
    public void dispose() {
        mapRen.dispose();
        map.dispose();
        sound.dispose();
        ene1.sprite.getTexture().dispose();
        jefe.sprite.getTexture().dispose();
        ene3.sprite.getTexture().dispose();
        sound.dispose();
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
    public void hide(){
        dispose();
    }
}
