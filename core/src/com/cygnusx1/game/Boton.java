package com.cygnusx1.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import javafx.stage.Stage;

/**
 * Created by Oscar Patiño y Andrey Alonso on 19/05/2017.
 * Se crea un boton, usando la clase de los botones
 * @param Stage maneja los eventos de entrada
 * @param TextButton texto del boton
 * @param TextButtonStyle
 * @param BitmapFont Renderiza la fuente
 * @param TextureAtlas carga imagenes de atlas de texturas
 */

public class Boton extends Game{
    private Stage stage;
    private TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;

    @Override
    public void create(){
        stage = new Stage();
        //Gdx.input.setInputProcessor(stage);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        button = new TextButton("Boton 2", textButtonStyle);
    }

    @Override
    public void render(){
        super.render();
        //stage.draw();
    }
}
