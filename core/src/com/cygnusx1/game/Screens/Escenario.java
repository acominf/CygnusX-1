package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
//import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.cygnusx1.game.CygnusX1;
import com.cygnusx1.game.Jugador;

/**
 * Created by andrey and Oscar on 11/05/17.
 */

public class Escenario implements Screen{
    //private Stage stage;
    private CygnusX1 juego;
    private Jugador jug;
    private Sprite mons1;

    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRen;
    private OrthographicCamera camera;

    public Escenario(CygnusX1 j){
        juego = j;

        //stage = new Stage(new ScreenViewport());
        //stage.addActor(jug);

        mons1 = new Sprite(new Texture(Gdx.files.internal("botiquin.png")));
        //SpriteBatch batch = new SpriteBatch();

    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //stage.act();
        camera.update();
        mapRen.setView(camera);

        mapRen.render(new int[] {0});
        mapRen.getBatch().begin();

        jug.draw((SpriteBatch)mapRen.getBatch());

        mapRen.getBatch().end();
        mapRen.render(new int[] {1});

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
    public void show(){
        map = new TmxMapLoader().load("map.tmx");
        jug = new Jugador(0, 0, juego, (TiledMapTileLayer)map.getLayers().get(0));
        mapRen = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // AREA DQUE CUBRE LA CANAARA

        Gdx.input.setInputProcessor(jug);
    }

    @Override
    public void dispose() {
        mapRen.dispose();
        map.dispose();
    }
}
