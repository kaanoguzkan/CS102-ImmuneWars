package com.immunewars.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.immunewars.game.GameConfig;
import com.immunewars.game.ImmuneWars;

public class TransitionGenerator {
	ImmuneWars game;
	Screen currentScreen;
	Texture texture;
	Stage stage;
	Transition trans;

	public TransitionGenerator (ImmuneWars game, Stage stage, TransitionableScreen newScreen){
		this.game = game;
		this.stage = stage;
		
		texture = new Texture("loadScreen1.png");
		trans = new Transition(texture, game, newScreen ,GameConfig.resolutionX, 0, 
				GameConfig.resolutionX, GameConfig.resolutionY);
	}
	
	public void startTransition() {
		stage.addActor(trans);		
	}
	
	public Transition getTransition() {return trans;}

}
