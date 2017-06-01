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
import com.cygnusx1.game.*;

/**
 * Created by Oscar Patiño on 29/05/2017.
 */
public class Escenario2 implements Screen{
    private CygnusX1 juego;
    private TiledMap map;
    private Sound sound;
    private OrthogonalTiledMapRenderer mapRen;
    private OrthographicCamera camera;

    private Jugador jug;
    private Arma pistola;

    private Monstruo1 e1;
    private Monstruo2 e2;
    private Boss jefe;
    private Metralleta metralleta;

    private float timeSeconds = 0f;
    private float period = 0.1f;
    private int vidasAnteriores;

    public Escenario2(CygnusX1 juego, int vidas) {
        this.juego = juego;
        vidasAnteriores = vidas;
    }

    @Override
    public void show(){
        map = new TmxMapLoader().load("map2.tmx");
        mapRen = new OrthogonalTiledMapRenderer(map);
        jug = new Jugador(128, 128, (TiledMapTileLayer)(map.getLayers().get(0)), vidasAnteriores);
        camera = new OrthographicCamera(Gdx.graphics.getWidth()/1.5f, Gdx.graphics.getHeight()/1.5f);
        sound = Gdx.audio.newSound(Gdx.files.internal("MF.mp3"));
        sound.play();
        jug.inicializa();
        jug.mapa = (TiledMapTileLayer)map.getLayers().get(0);

        //jug = new Jugador(128, 128, (TiledMapTileLayer)(map.getLayers().get(0)));
        e1 = new Monstruo1(700, 300);
        e2 = new Monstruo2(2500, 500);
        jefe = new Boss(200, 3000);
        pistola = new Pistola(128, 128);
        metralleta = new Metralleta(2500, 500);
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
        jug.draw((SpriteBatch)mapRen.getBatch(), pistola);

        camera.position.x = jug.getX()+32;
        camera.position.y = jug.getY()+32;
        camera.update();

        jug.draw((SpriteBatch)mapRen.getBatch(), pistola);
        if(jug.hitGun(metralleta)){
            System.out.println("Junto a arma");
            pistola = metralleta;
            metralleta.take();
        }

        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if(timeSeconds > period){
            timeSeconds -=period;
            e1.move(); //mueve el jugador cada cierto tiempo
            e2.move();
        }

        e1.hit((SpriteBatch)(mapRen.getBatch()), pistola, jug.getX(),jug.getY()); //detecta si un enemigo es golpeado, le quita una vida al enemigo y aumenta puntos
        e2.hit((SpriteBatch)(mapRen.getBatch()), pistola, jug.getX(),jug.getY());
        jefe.hit((SpriteBatch)(mapRen.getBatch()), pistola, jug.getX(),jug.getY());

        if(!jefe.isAlive()){
            juego.setScreen(new Menu(juego));
        }
        if(!metralleta.isTaked()) {
            metralleta.drawStart((SpriteBatch) (mapRen.getBatch()));
        }
        jefe.draw((SpriteBatch)(mapRen.getBatch()));

        mapRen.getBatch().end();

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
        dispose();
    }

    @Override
    public void dispose() {
        mapRen.dispose();
        map.dispose();
        sound.dispose();
        e1.dispose();
        jefe.dispose();
        e2.dispose();
        jug.dispose();
        pistola.dispose();
        metralleta.dispose();
        sound.dispose();
    }
}
