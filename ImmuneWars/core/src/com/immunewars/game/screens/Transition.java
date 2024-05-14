package com.immunewars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.immunewars.game.ImmuneWars;

public class Transition extends Actor {
	float speed = 2000;
	float x, y;
	float width, height;
	Texture texture;
	boolean transIn = true;
	ImmuneWars game;
	TransitionableScreen newScreen;
	
	public Transition(Texture texture, ImmuneWars game, TransitionableScreen newScreen, float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.game = game;
		this.newScreen = newScreen;
		
		this.addAction(new TransitionAction());
	}
	
	public void draw (Batch batch, float parentAlpha) {
		batch.draw(texture, x, y, width, height);
	}
	
	public boolean isIdle() {
		return x == 0;
	}
	
	public boolean isDone() {
		return x == -width;
	}
	
	public void transOut() {
		transIn = false;
	}
	
	private class TransitionAction extends Action {
		
		public boolean act(float delta) {
			if (isIdle()) {
				game.setScreen(newScreen);
				newScreen.addActorAsFirst(this.getActor());
				transOut();
			}
			
			if (x > 0 && transIn) {
				System.out.println("trans in " + x);
				x = Math.max(x - speed * delta, 0);
				
			} else if (x + width > 0 && !transIn){
				x = Math.max(x - speed * delta, -width);
				
			}
			
			if (isDone()) {
				
			}
			
			//System.out.println(mouseXNormalized + " " + mouseYNormalized);
			return false;
		}
		
	}
}
