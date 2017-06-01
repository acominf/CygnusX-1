package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.cygnusx1.game.*;

/**
 * Created by andrey and Oscar on 11/05/17.
 */

public class Escenario extends Nivel implements Screen{
    private Jugador jug;
    private Arma pistola;
    private Monstruo1 ene1;
    private Monstruo2 ene3;
    private Boss jefe;
    private Metralleta metralleta;

    public Escenario(CygnusX1 j){
        juego = j;
        tabla = new Table();
        batch = new SpriteBatch();
    }

    @Override
    public void show(){
        map = new TmxMapLoader().load("map.tmx");
        mapRen = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera(Gdx.graphics.getWidth()/1.5f, Gdx.graphics.getHeight()/1.5f);
        sound = Gdx.audio.newSound(Gdx.files.internal("MF.mp3"));
        sound.play();

        jug = new Jugador(128, 128, (TiledMapTileLayer)(map.getLayers().get(0)), 5);
        ene1 = new Monstruo1(200, 700);
        jefe = new Boss(2950, 3000);
        ene3 = new Monstruo2(350, 1400);
        pistola = new Pistola(128, 128);
        metralleta = new Metralleta(200, 500);

        Gdx.input.setInputProcessor(jug);
        tabla.top();
        tabla.setFillParent(true);
        texto = new Label("Vidas", new Label.LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE));

        tabla.add(texto).expandX().padTop(10);
        tabla.row();
        tabla.add(vida).expandX().padTop(10);
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
        vida = new Label(String.format("%03d", jug.getLives()), new Label.LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE));

        jug.draw((SpriteBatch)mapRen.getBatch(), pistola);
        if(jug.hitGun(metralleta)){
            pistola = metralleta;
            metralleta.take();
        }

        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if(timeSeconds > period){
            timeSeconds -=period;
            ene1.move(); //mueve el jugador cada cierto tiempo
            ene3.move();
        }

        if(jug.hitMonster(ene1) || jug.hitMonster(ene3) || jug.hitMonster(jefe)){
            jug.loseLife();
            jug.moveSprite();
        }

        if(jug.hitBullet(ene1.ataque) || jug.hitBullet(ene1.ataque2) || jug.hitBullet(ene1.ataque3) || jug.hitBullet(ene1.ataque4)){
            jug.loseLife();
            jug.moveSprite();
        }

        ene1.hit((SpriteBatch)(mapRen.getBatch()), pistola, jug.getX(), jug.getY()); //detecta si un enemigo es golpeado, le quita una vida al enemigo y aumenta puntos
        jefe.hit((SpriteBatch)(mapRen.getBatch()), pistola, jug.getX(), jug.getY());
        ene3.hit((SpriteBatch)(mapRen.getBatch()), pistola, jug.getX(), jug.getY());

        if(!jefe.isAlive()){
            juego.setScreen(new Escenario2(juego, jug.getLives()));
        }
        if(!metralleta.isTaked()) {
            metralleta.drawStart((SpriteBatch) (mapRen.getBatch()));
        }

        if(jug.getLives() <= 0){
            juego.setScreen(new Menu(juego));
        }

        jefe.draw((SpriteBatch)(mapRen.getBatch()));
        mapRen.getBatch().end();
        batch.begin();
        vida.draw(batch, 10);
        batch.end();
    }

    @Override
    public void dispose() {
        mapRen.dispose();
        map.dispose();
        sound.dispose();
        ene1.dispose();
        jefe.dispose();
        ene3.dispose();
        pistola.dispose();
        metralleta.dispose();
        sound.dispose();
        batch.dispose();
        jug.dispose();
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
