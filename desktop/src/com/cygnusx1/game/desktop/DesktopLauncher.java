package com.cygnusx1.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cygnusx1.game.CygnusX1;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("user.name","Oscar");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new CygnusX1(), config);
	}
}
