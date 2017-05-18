package com.cygnusx1.game;

import com.badlogic.gdx.Game;

public class CygnusX1 extends Game{

	public void create(){
		this.setScreen(new com.cygnusx1.game.Screens.Escenario(this));
	}

	public void render(){
		super.render();
	}

	public void dispose(){

	}
}
