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
    //private Stage stage;
    private CygnusX1 juego;
    private Jugador jug;
    private Pistola pistola;
    private Monstruo1 ene1;
    private Monstruo2 ene3;
    private Boss ene2;

    private TiledMap map;
    private Sound sound;
    private OrthogonalTiledMapRenderer mapRen;
    private OrthographicCamera camera;
    public float period = 0.1f;
    public float timeSeconds = 0f;

    private boolean colision = false;
    private boolean colisionEne = false;
    private boolean colisionEne2 = false;
    private boolean colisionEne3 = false;

    private Rectangle rjug;
    private Rectangle rene1;
    private Rectangle rpist;
    private Rectangle rene2;
    private Rectangle rene3;

    public Escenario(CygnusX1 j){
        juego = j;
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

        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if(timeSeconds > period){
            timeSeconds -=period;
            ene1.move(); //mueve el jugador cada cierto tiempo
            ene3.move();
        }

        ene1.hit((SpriteBatch)(mapRen.getBatch()), pistola.bala, jug.getX(),jug.getY()); //detecta si un enemigo es golpeado, le quita una vida al enemigo y aumenta puntos
        ene2.hit((SpriteBatch)(mapRen.getBatch()), pistola.bala, jug.getX(),jug.getY());
        ene3.hit((SpriteBatch)(mapRen.getBatch()), pistola.bala, jug.getX(),jug.getY());

        mapRen.getBatch().end();

        //mapRen.render(new int[] {1});
    }

    @Override
    public void show(){
        map = new TmxMapLoader().load("map.tmx");
        mapRen = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera(Gdx.graphics.getWidth()/1.5f, Gdx.graphics.getHeight()/1.5f);
        sound = Gdx.audio.newSound(Gdx.files.internal("MF.mp3"));
        sound.play();

        jug = new Jugador(128, 128, (TiledMapTileLayer)(map.getLayers().get(0)));
        ene1 = new Monstruo1(400, 400);
        ene2 = new Boss(2950, 3000);
        ene3 = new Monstruo2(400, 1000);
        pistola = new Pistola(128, 128);

        Gdx.input.setInputProcessor(jug);
    }

    @Override
    public void dispose() {
        mapRen.dispose();
        map.dispose();
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
    public void hide() {

    }
}
