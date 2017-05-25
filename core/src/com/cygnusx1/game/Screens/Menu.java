package com.cygnusx1.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cygnusx1.game.CygnusX1;

import static com.badlogic.gdx.Gdx.files;

/**
 * Created by Oscar Patiño on 19/05/2017.
 */
public class Menu implements Screen{
    private Stage stage;
    private CygnusX1 juego;
    private Texture texBot;
    private TextureRegion miRegion;
    private TextureRegionDrawable texDraw;
    private Button inicio;
    private ImageButton boton;
    private Label outputLabel;

    public Menu(CygnusX1 juego){
        this.juego = juego;
        texBot = new Texture(Gdx.files.internal("playButton.png"));
        miRegion = new TextureRegion(texBot);
        texDraw = new TextureRegionDrawable(miRegion);
        boton = new ImageButton(texDraw);

        stage = new Stage(new ScreenViewport());
        stage.addActor(boton);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(1, 1, 1, 1 );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        boton.setSize(100, 100);
        boton.setPosition(100, 100);
        boton.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button){
                outputLabel.setText("Boton presionado");
            }

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                outputLabel.setText("Boton despresionado");
                return true;
            }

        });
        stage.addActor(boton);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void show(){

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
