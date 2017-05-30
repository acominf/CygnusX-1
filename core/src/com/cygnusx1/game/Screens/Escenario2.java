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
import com.cygnusx1.game.CygnusX1;
import com.cygnusx1.game.Jugador;
import com.cygnusx1.game.Pistola;

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
    private Pistola pistola;

    public Escenario2(CygnusX1 jueg, Jugador j) {
        juego = jueg;
        jug = j;
    }

    @Override
    public void show(){
        map = new TmxMapLoader().load("map2.tmx");
        mapRen = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera(Gdx.graphics.getWidth()/1.5f, Gdx.graphics.getHeight()/1.5f);
        sound = Gdx.audio.newSound(Gdx.files.internal("MF.mp3"));
        sound.play();
        jug.sprite.setPosition(128, 128);
        jug.mapa = (TiledMapTileLayer)map.getLayers().get(0);

        //jug = new Jugador(128, 128, (TiledMapTileLayer)(map.getLayers().get(0)));
        pistola = new Pistola(128, 128);
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

    }

    @Override
    public void dispose() {

    }
}
