package com.cygnusx1.game;

import com.cygnusx1.game.Screens.*;
import com.badlogic.gdx.Game;
import sun.java2d.ScreenUpdateManager;

public class CygnusX1 extends Game{

	public void create(){
		this.setScreen(new Portada(this));
	}

	public void render(){
		super.render();
	}

	public void dispose(){

	}
}
