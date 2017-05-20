package com.cygnusx1.game;

import com.cygnusx1.game.Screens.*;
import com.badlogic.gdx.Game;

public class CygnusX1 extends Game{


	public void create(){
		this.setScreen(new Portada(this));
		//this.setScreen(new Escenario(this));
	}

	public void render(){
		super.render();
	}

	public void dispose(){

	}
}
