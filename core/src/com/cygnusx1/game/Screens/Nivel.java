package com.cygnusx1.game.Screens;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.cygnusx1.game.CygnusX1;

/**
 * Created by Oscar Patiño on 29/05/2017.
 */
public class Nivel{
    private CygnusX1 juego;
    private TiledMap map;
    private Sound sound;
    private OrthogonalTiledMapRenderer mapRen;
    private OrthographicCamera camera;

    public float period = 0.1f;
    public float timeSeconds = 0f;
}
