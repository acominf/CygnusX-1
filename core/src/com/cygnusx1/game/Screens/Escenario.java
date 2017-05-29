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
import com.badlogic.gdx.math.Rectangle;
import com.cygnusx1.game.CygnusX1;
import com.cygnusx1.game.Monstruo1;
import com.cygnusx1.game.Jugador;
import com.cygnusx1.game.Monstruo2;

/**
 * Created by andrey and Oscar on 11/05/17.
 */

public class Escenario implements Screen{
    //private Stage stage;
    private CygnusX1 juego;
    private Jugador jug;
    private Monstruo1 ene1;
    private Monstruo2 ene2;

    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRen;

    private OrthographicCamera camera;
    public float timeSeconds = 0f;
    public float period = 0.1f;

    boolean colision = false;
    private Rectangle rjug;
    private Rectangle rene1;

    private Sprite bala;

    public Escenario(CygnusX1 j){
        juego = j;
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

        camera.position.x = jug.getX();
        camera.position.y = jug.getY();
        camera.update();
        jug.draw((SpriteBatch)mapRen.getBatch());

        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if(timeSeconds > period){
            timeSeconds -=period;
            ene1.move();
            //ene2.move();
        }
        ene1.draw((SpriteBatch)mapRen.getBatch());
        rjug = jug.rectangulo();
        rene1 = ene1.rectangulo();
        colision = rjug.overlaps(rene1);

        if(colision){
            //ene1.remove();

            //juego.setScreen(new Combate(juego, this));
        }

        //if(!ene1.exists())
            //ene1.draw((SpriteBatch)mapRen.getBatch());
        mapRen.getBatch().end();
        //mapRen.render(new int[] {1});
    }

    @Override
    public void show(){
        map = new TmxMapLoader().load("map.tmx");
        jug = new Jugador(128, 128, (TiledMapTileLayer)(map.getLayers().get(0)));
        bala = new Sprite(new Texture(Gdx.files.internal("bullet.png")));
        ene1 = new Monstruo1(400, 400, (TiledMapTileLayer)(map.getLayers().get(0)));
        //ene2 = new Monstruo2(400, 400, (TiledMapTileLayer)(map.getLayers().get(0)));
        mapRen = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.input.setInputProcessor(jug);
    }

    @Override
    public void dispose() {
        mapRen.dispose();
        map.dispose();
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
