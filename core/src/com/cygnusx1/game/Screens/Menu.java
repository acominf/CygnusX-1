package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cygnusx1.game.CygnusX1;
import com.cygnusx1.game.Jugador;

/**
 * Created by Oscar Patiño on 19/05/2017.
 */
public class Menu implements Screen{
    private Stage stage;
    private SpriteBatch batch;
    private Sprite menu;
    private CygnusX1 juego;
    private Label outputLabel;
    private Jugador jug;
    private TiledMap map;

    public Menu(CygnusX1 juego){
        this.juego = juego;
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 0 );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        batch.begin();
        menu.draw(batch);
        batch.end();
        stage.draw();
    }

    @Override
    public void show(){
        batch = new SpriteBatch();
        menu = new Sprite(new Texture(Gdx.files.internal("menu.png")));
        stage = new Stage(new ScreenViewport());
        ImageButton boton1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("playButton.png")))));
        ImageButton boton2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("exitButton.png")))));
        ImageButton boton3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("helpButton.png")))));
        ImageButton boton4 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("howButton.png")))));

        boton1.setSize(64, 64);
        boton1.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2+200);
        boton1.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                juego.setScreen(new Escenario(juego));
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                return true;
            }

        });
        stage.addActor(boton1);

        boton2.setSize(64, 64);
        boton2.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2-200);
        boton2.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button){
                Gdx.app.exit();
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                return true;
            }

        });
        stage.addActor(boton2);

        boton3.setSize(64, 64);
        boton3.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2+100);
        boton3.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                juego.setScreen(new Creditos(juego));
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                return true;
            }

        });
        stage.addActor(boton3);

        boton4.setSize(64, 64);
        boton4.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2-100);
        boton4.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button){
                juego.setScreen(new Ayuda(juego));
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                return true;
            }

        });
        stage.addActor(boton4);
        Gdx.input.setInputProcessor(stage);
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
        this.dispose();
    }

    @Override
    public void dispose(){
        stage.dispose();
        batch.dispose();
        menu.getTexture().dispose();
    }
}
