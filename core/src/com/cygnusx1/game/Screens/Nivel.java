package com.cygnusx1.game.Screens;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.cygnusx1.game.CygnusX1;

/**
 * Created by Oscar Patiño on 29/05/2017.
 */
public class Nivel{
    protected Label vida;
    protected Label texto;
    protected Table tabla;
    protected SpriteBatch batch;

    protected CygnusX1 juego;
    protected TiledMap map;
    protected Sound sound;
    protected OrthogonalTiledMapRenderer mapRen;
    protected OrthographicCamera camera;

    public float period = 0.1f;
    public float timeSeconds = 0f;
}
