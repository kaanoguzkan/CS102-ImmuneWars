package com.immunewars.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowIcon( "ImmuneWars\\desktop\\src\\com\\immunewars\\game\\logo.png" ); 
		config.setForegroundFPS(GameConfig.targetFPS);
		config.setWindowedMode(1280, 800);
		config.setTitle("Immune Wars");
		new Lwjgl3Application(new ImmuneWars(), config);
	}
}
